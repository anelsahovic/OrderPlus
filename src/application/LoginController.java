package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {
	
    @FXML
    private TextField passwordTxtField;

    @FXML
    private TextField usernameTxtField;
    
    @FXML
    private Label loginAlert;
    
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	
	
	
	
	public void switchToRegister(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void switchToHome(Label loginAlert2) throws IOException {
		//Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
		//postavljanje usernamea na home sceni
		String username=usernameTxtField.getText();
		
		FXMLLoader loader= new FXMLLoader(getClass().getResource("Home.fxml"));
		root=loader.load();
		
		HomeController homeController = loader.getController();
		homeController.displayUsername(username);
		homeController.displayHomeInfo();
		//prebacivanje na home
		stage= (Stage) loginAlert2.getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    
		
	}
	
	public void loginIntoAccount() {
		
		if(usernameTxtField.getText().isBlank()==false && passwordTxtField.getText().isBlank()==false) {
			//ako nije prazno onda provjeri ima li u bazi taj korisnik
			validateLogin();
			
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Greška!");
			alert.setHeaderText("Niste unijeli podatke u sva polja!");
			alert.setContentText("Molimo Vas popunite sva polja!");

			alert.showAndWait();
		}
		
	}
	
	public void validateLogin() {
		DatabaseConnection connectNow= new DatabaseConnection();
		Connection connectDB= connectNow.getConnection();
		
		String verifyLogin="SELECT count(1) FROM kompanija WHERE username='"+ usernameTxtField.getText()+"' AND sifra='"+ passwordTxtField.getText()+"'";
		
		try {
			
			Statement  statement=connectDB.createStatement();
			ResultSet queryResult= statement.executeQuery(verifyLogin);
			
			while(queryResult.next()) {
				if(queryResult.getInt(1)==1) {
					//("Uspjesno");
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Uspješno!");
					alert.setHeaderText("Uspiješna prijava!");
					alert.setContentText("Uspiješno ste se prijavili na svoj profil!");
					alert.showAndWait();
					
					//prebacivanje na home
					switchToHome(loginAlert);
					
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Greška!");
					alert.setHeaderText("Unijeli ste pogrešno korisničko ime ili lozinku!");
					alert.setContentText("Molimo Vas pokušajte ponovo!");

					alert.showAndWait();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
