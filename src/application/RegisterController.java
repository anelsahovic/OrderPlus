package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RegisterController {
	
	@FXML
    private TextField nameTxtField;

    @FXML
    private TextField passwordTxtField;

    @FXML
    private Label registerAlert;

    @FXML
    private TextField repeatPasswordTxtField;

    @FXML
    private TextField usernameTxtField;
	
	private Stage stage;
	private Scene scene;
	
	
	public void switchToLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void switchToLogin2(Label registerAlert2) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		stage= (Stage)registerAlert2.getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}
	
	
	public void registerAccount() {
		
		if(nameTxtField.getText().isBlank()==true || usernameTxtField.getText().isBlank()==true || passwordTxtField.getText().isBlank()==true || repeatPasswordTxtField.getText().isBlank()==true){
			Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Greška!");
				alert.setHeaderText("Niste popunili sva polja");
				alert.setContentText("Molimo Vas popunite sva polja!");

				alert.showAndWait();
           } else{
				//provjera da li postoji username 
        	   
        	   DatabaseConnection connectNow= new DatabaseConnection();
       		Connection connectDB= connectNow.getConnection();
       		
       		String verifyLogin="SELECT count(1) FROM kompanija WHERE username='"+ usernameTxtField.getText()+"'";
       		
       		try {
       			
       			Statement  statement=connectDB.createStatement();
       			ResultSet queryResult= statement.executeQuery(verifyLogin);
       			
       			while(queryResult.next()) {
       				if(queryResult.getInt(1)==1) {
       					//postoji username
       					Alert alert = new Alert(AlertType.ERROR);
       					alert.setTitle("Greška!");
       					alert.setHeaderText("Unijeli ste korisničko ime koje već postoji");
       					alert.setContentText("Molimo Vas unesite drugo korisničko ime!");

       					alert.showAndWait();
       				}else {
       					if(passwordTxtField.getText().equals(repeatPasswordTxtField.getText())){
    						
       						insertNewRecord();
                        }else{
                        	Alert alert = new Alert(AlertType.ERROR);
           					alert.setTitle("Greška!");
           					alert.setHeaderText("Lozinke se ne podudaraju");
           					alert.setContentText("Molimo Vas unesite iste lozinke!");

           					alert.showAndWait();
                        }
       				}
       			}
       			
       		} catch (Exception e) {
       			e.printStackTrace();
       		}
        	   
				}
				
				
				
			
            }
      
				
	
	
	
	public void insertNewRecord() {
		DatabaseConnection connectNow= new DatabaseConnection();
		Connection connectDB= connectNow.getConnection();
		
		String insertNewUser="INSERT INTO kompanija(username,sifra,naziv) VALUES('"+ usernameTxtField.getText()+"','"+ passwordTxtField.getText() +"','"+ nameTxtField.getText() +"');";
		
		try {
			
			PreparedStatement  statement=connectDB.prepareStatement(insertNewUser);
			statement.execute();
			
			
				Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Uspješna registracija");
					alert.setHeaderText("Uspješno ste se registrovali!");
					alert.setContentText("Prijavite se sa podacima da bi nastavili!");

					alert.showAndWait();
					
					switchToLogin2(registerAlert);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
