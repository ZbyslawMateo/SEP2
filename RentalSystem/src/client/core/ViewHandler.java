package client.core;

import client.view.CustomerBasketView.CustomerBasketViewController;
import client.view.CustomerSingleOrderView.SingleOrderViewController;
import client.view.EmployeeOrderDetails.EmployeeOrderDetailsController;
import client.view.LoginView.LoginViewController;
import client.view.administratorView.AdministratorViewController;
import client.view.customerAllEquipment.CustomerAllEquipmentViewController;
import client.view.customerAllOrdersView.CustomerAllOrdersController;
import client.view.employeeAllOrders.EmployeeAllOrdersController;
import client.view.productDetails.ProductDetailsController;
import client.view.registryView.RegistryViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shared.networking.model.ManageUser;

import java.io.IOException;

/**
 * ViewHandler
 */
public class ViewHandler
{
    private Stage stage;
    private ViewModelFactory vmf;
    private Scene administratorScene;
    private Scene customerAllEquipmentScene;
    private Scene customerBasket;
    private Scene customerAllOrdersScene;
	private Scene employeeAllOrdersScene;
	private Scene employeeOrderDetailsScene;
	private Scene singleOrderView;
	private Scene registryScene;
  private Scene loginScene;
  private Scene productDetailsScene;


    /**
     * Constructor assigning ViewModelFactory and Stage
     * @param vmf ViewModelFactory
     * @param stage Stage
     */
    public ViewHandler(ViewModelFactory vmf, Stage stage){
        this.vmf = vmf;
        this.stage = stage;
    }

	/**
	 * Open selected view
	 * This is what is opened when we launch an application
	 */
    public void start(){

		openLoginView();

        stage.show();
    }

	/**
	 * Get root with provided path
	 * @param path
	 * @param loader
	 * @return Parent root
	 */
    private Parent getRootByPath(String path, FXMLLoader loader){
        loader.setLocation(getClass().getResource(path));
        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }

        return root;
    }

	/**
	 * Open administrator window
	 */
    public void openAdministratorView(){
        FXMLLoader loader = new FXMLLoader();
        if(administratorScene == null){
            Parent root = getRootByPath("/client/view/administratorView/AdministratorView.fxml", loader);
            AdministratorViewController controller = loader.getController();
            controller.init(this,vmf);
            administratorScene = new Scene(root);
        }

        stage.setTitle("Administrator View");
        stage.setScene(administratorScene);
    }

	/**
	 * Open window with all equipment
	 */
    public void openCustomerAllEquipmentView(){
        FXMLLoader loader = new FXMLLoader();

		Parent root = getRootByPath("/client/view/customerAllEquipment/CustomerAllEquipmentView.fxml", loader);
		CustomerAllEquipmentViewController controller = loader.getController();
		controller.init(this,vmf);
		customerAllEquipmentScene = new Scene(root);

        stage.setTitle("All equipment");
        stage.setScene(customerAllEquipmentScene);
    }



    /**
     * Open window with customer basket
     */
    public void openCustomerBasket(){
        FXMLLoader loader = new FXMLLoader();
        if(customerBasket == null){

            Parent root = getRootByPath("/client/view/CustomerBasketView/Basketview.fxml", loader);
            CustomerBasketViewController controller = loader.getController();
            controller.init(this,vmf);
            customerBasket = new Scene(root);
        }

        stage.setTitle("Customer Basket");
        stage.setScene(customerBasket);
    }

  /**
   * open window with customer's all orders
   */
  public void openCustomerAllOrdersView(){
    FXMLLoader loader = new FXMLLoader();
    if(customerAllOrdersScene == null){

      Parent root = getRootByPath("/client/view/customerAllOrdersView/CustomerAllOrders.fxml", loader);
      CustomerAllOrdersController controller = loader.getController();
      controller.init(this,vmf);
      customerAllOrdersScene = new Scene(root);
    }

    stage.setTitle("Customer All Orders");
    stage.setScene(customerAllOrdersScene);
  }

	/**
	 * open window with all reservations
	 */
	public void openEmployeeView(){
		FXMLLoader loader = new FXMLLoader();

		if (employeeAllOrdersScene == null) {
			Parent root = getRootByPath("/client/view/employeeAllOrders/EmployeeAllOrders.fxml", loader);

			EmployeeAllOrdersController controller = loader.getController();
			controller.init(this, vmf);
			employeeAllOrdersScene = new Scene(root);
		}

		stage.setTitle("All reservations");
		stage.setScene(employeeAllOrdersScene);
	}

	/**
	 * open reservation details window
	 */
	public void openEmployeeOrderDetailsView(int id){
		FXMLLoader loader = new FXMLLoader();

		Parent root = getRootByPath("/client/view/EmployeeOrderDetails/EmployeeOrderDetails.fxml", loader);

		EmployeeOrderDetailsController controller = loader.getController();
		controller.init(this, vmf, id);
		employeeOrderDetailsScene = new Scene(root);

		stage.setTitle("Reservation <" + id + ">");
		stage.setScene(employeeOrderDetailsScene);
	}

  /**
   * open Returns ClientPoxy that contains all other clients.
   */
  public void openSingleOrderView(int id){
    FXMLLoader loader = new FXMLLoader();

    Parent root = getRootByPath("/client/view/CustomerSingleOrderView/SingleOrderView.fxml", loader);

    SingleOrderViewController controller = loader.getController();
    //TODO change the ID later
    controller.init(this, vmf, id);
    singleOrderView = new Scene(root);


    stage.setTitle("Single Order");
    stage.setScene(singleOrderView);
  }

    /**
     * open registry window
     */
    public void openRegistryView(){
        FXMLLoader loader = new FXMLLoader();

        if (registryScene == null) {
            Parent root = getRootByPath("/client/view/registryView/RegistryView.fxml", loader);

            RegistryViewController controller = loader.getController();
            controller.init(this, vmf);
            registryScene = new Scene(root);
        }

        stage.setTitle("Create Account");
        stage.setScene(registryScene);
    }

  /**
   * open login window
   */
  public void openLoginView(){
    FXMLLoader loader = new FXMLLoader();

    if (loginScene == null) {
      Parent root = getRootByPath("/client/view/LoginView/LoginView.fxml", loader);

      LoginViewController controller = loader.getController();
      controller.init(this, vmf);
      loginScene = new Scene(root);
    }

    stage.setTitle("Login to Account");
    stage.setScene(loginScene);
  }

  /**
   * open product details window.
   */
	public void openProductDetailsView(int id){
		FXMLLoader loader = new FXMLLoader();

		Parent root = getRootByPath("/client/view/productDetails/ProductDetails.fxml", loader);

		ProductDetailsController controller = loader.getController();
		controller.init(this, vmf, id);
		productDetailsScene = new Scene(root);

		stage.setTitle("Product Details");
		stage.setScene(productDetailsScene);
	}
}
