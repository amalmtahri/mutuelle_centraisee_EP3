package com.mutuelle.application.views;

import com.mutuelle.application.dao.OfficerDAO;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.log4j.Logger;




public class LoginController{
	
	  static final Logger log = Logger.getLogger(LoginController.class.getName());

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageError;
    @FXML
    private TextField emailOfficer;
    @FXML
    private PasswordField passwordOfficer;
    @FXML
    private Label messageLogin;
    @FXML
    private Label emailInvalid;
    @FXML
    private Label passwordInvalid;
	@FXML
	private Label userName;

    private Stage stage;
    private Scene scene;




    @FXML
    public void loginPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void cancelButtonAction(ActionEvent event){
        Platform.exit();
    }
    public void validateLogin(ActionEvent event) throws IOException{

		if(emailOfficer.getText().isBlank() == false && passwordOfficer.getText().isBlank() == false) {

			OfficerDAO officerDAO = new OfficerDAO();
			boolean flag = officerDAO.validateLogin(emailOfficer.getText(), passwordOfficer.getText());

			if (!flag) {
				loginMessageError.setText("Please enter correct Email and Password!");
				log.error("Password ou email est incorrect");

			} else {
				
				log.info("Les données du l’utilisateur authentifié: \nEmail: "+emailOfficer.getText()+"" );
				messageLogin.setText("Success!");
				emailOfficer.setText("");
				passwordOfficer.setText("");
				Parent root = FXMLLoader.load(getClass().getResource("register.fxml"));
				stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			}
			
		}
		else{
			loginMessageError.setText("Please enter your email and password");

		}
       }
   
 
}