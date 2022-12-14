package client.core;

import client.model.ModelProxy;
import client.view.CustomerBasketView.CustomerBasketViewModel;
import client.view.EmployeeOrderDetails.EmployeeOrderDetailsViewModel;
import client.view.LoginView.LoginViewModel;
import client.view.administratorView.AdministratorViewModel;
import client.view.customerAllEquipment.CustomerAllEquipmentViewModel;
import client.view.customerAllOrdersView.CustomerAllOrdersViewModel;
import client.view.employeeAllOrders.EmployeeAllOrdersViewModel;
import client.view.CustomerSingleOrderView.SingleOrderViewModel;
import client.view.productDetails.ProductDetailsViewModel;
import client.view.registryView.RegistryViewModel;

public class ViewModelFactory {
	private AdministratorViewModel administratorViewModel;
	private CustomerAllEquipmentViewModel customerAllEquipmentViewModel;
	private CustomerBasketViewModel customerBasketViewModel;
	private EmployeeOrderDetailsViewModel employeeOrderDetailsViewModel;
	private ModelProxy modelProxy;
	private EmployeeAllOrdersViewModel employeeAllOrdersViewModel;
	private SingleOrderViewModel singleOrderViewModel;
	private RegistryViewModel registryViewModel;
	private LoginViewModel loginViewModel;
	private CustomerAllOrdersViewModel customerAllOrdersViewModel;
	private ProductDetailsViewModel productDetailsViewModel;

	public ViewModelFactory(ModelProxy modelProxy)
	{
		this.modelProxy = modelProxy;
	}

	public ModelProxy getModelProxy() {
		return modelProxy;
	}

	/**
	 * Lazy initiation of view model for administrator
	 * @return AdministratorViewModel object
	 */
	public AdministratorViewModel getAdministratorViewModel() {
		if (administratorViewModel == null) {
			administratorViewModel = new AdministratorViewModel(modelProxy);
		}

		return administratorViewModel;
	}

	/**
	 * Lazy initiation of view model for all equipment
	 * @return CustomerAllEquipmentViewModel object
	 */
	public CustomerAllEquipmentViewModel getCustomerAllEquipmentView() {
		if (customerAllEquipmentViewModel == null) {
			customerAllEquipmentViewModel = new CustomerAllEquipmentViewModel(modelProxy);
		}

		return customerAllEquipmentViewModel;
	}

	/**
	 * Lazy initiation of view model for basket view
	 * @return CustomerBasketViewModel object
	 */
	public CustomerBasketViewModel getCustomerBasketViewModel() {
		if(customerBasketViewModel == null) {
			customerBasketViewModel = new CustomerBasketViewModel(modelProxy);
		}

		return customerBasketViewModel;
	}

	/**
	 * Lazy initiation of view model for all reservations
	 * @return EmployeeAllOrdersViewModel object
	 */
	public EmployeeAllOrdersViewModel getEmployeeViewModel() {
		if (employeeAllOrdersViewModel == null) {
			employeeAllOrdersViewModel = new EmployeeAllOrdersViewModel(modelProxy);
		}

		return employeeAllOrdersViewModel;
	}

	/**
	 * Lazy initiation of view model for single order view
	 * @return SingleOrderViewModel object
	 */
	public SingleOrderViewModel getSingleOrderViewModel(int id) {
		if (singleOrderViewModel == null) {
			singleOrderViewModel = new SingleOrderViewModel(modelProxy, id);
		}

		return singleOrderViewModel;
	}

	/**
	 * Lazy initiation of view model for single reservation view
	 * @return EmployeeOrderDetailsViewModel object
	 */
	public EmployeeOrderDetailsViewModel getEmployeeOrderDetailsViewModel(int id)
	{
		if(employeeOrderDetailsViewModel == null) {
			employeeOrderDetailsViewModel = new EmployeeOrderDetailsViewModel(modelProxy, id);
		}

		return employeeOrderDetailsViewModel;
	}

	/**
	 * Lazy initiation of view model for user registration view
	 * @return RegistryViewModel object
	 */
	public RegistryViewModel getRegistryViewModel() {
		if(registryViewModel == null)
		{
			registryViewModel = new RegistryViewModel(modelProxy);
		}
		return registryViewModel;
	}

	/**
	 * Lazy initiation of view model for user login view
	 * @return LoginViewModel object
	 */
	public LoginViewModel getLoginViewModel() {
		if(registryViewModel == null)
		{
			loginViewModel = new LoginViewModel(modelProxy);
		}
		return loginViewModel;
	}

	/**
	 * Lazy initiation of view model for all customer's reservations
	 * @return CustomerAllOrdersViewModel object
	 */
  public CustomerAllOrdersViewModel getCustomerAllOrdersViewModel()
  {
		if(customerAllOrdersViewModel == null)
		{
			customerAllOrdersViewModel = new CustomerAllOrdersViewModel(modelProxy);
		}
		return customerAllOrdersViewModel;
  }

	/**
	 * Lazy initiation of view model for product details view
	 * @return ProductDetailsViewModel object
	 */
	public ProductDetailsViewModel getProductDetailsViewModel() {
		if(productDetailsViewModel == null)
		{
			productDetailsViewModel = new ProductDetailsViewModel(modelProxy);
		}
		return productDetailsViewModel;
	}
}
