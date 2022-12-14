package client.view.LoginView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import shared.objects.errors.AlertHandler;
import shared.objects.user.User;
import shared.objects.user.UserRole;

/**
 Controller for Login view
 */
public class LoginViewController
{
  private ViewHandler viewHandler;
  private LoginViewModel viewModel;

  @FXML
  private TextField userName;

  @FXML
  private PasswordField password;

  @FXML
  private Button logInButton;

  @FXML
  private Button createAccount;

  /**
   * constructor contains username and password from view model
   * @param viewHandler
   * @param vmf
   */
  public void init(ViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.viewHandler = viewHandler;
    viewModel = vmf.getLoginViewModel();
    userName.textProperty().bindBidirectional(viewModel.getUserNameProperty());
    password.textProperty().bindBidirectional(viewModel.getPasswordProperty());

    viewModel.clearFields();
  }

  @FXML
  /**
   * log user into account if conditions are met
   */
	void logInToAccount() {
		User user = viewModel.checkIdentification(userName.getText(),password.getText());

		if (user != null) {
			UserRole role = viewModel.getRoleOfUser();

			if (role == UserRole.admin)
				viewHandler.openAdministratorView();
			else if(role == UserRole.customer)
				viewHandler.openCustomerAllEquipmentView();
			else if(role == UserRole.employee)
				viewHandler.openEmployeeView();

            viewModel.clearFields();
		}
		else {
			AlertHandler.getInstance().wrongCredentials();
		}

	}

  /**
   * open registry view
   */
    @FXML
    void createAccount() {
      viewHandler.openRegistryView();
      viewModel.clearFields();
    }
}

