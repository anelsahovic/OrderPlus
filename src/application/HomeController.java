package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController implements Initializable{
	 @FXML
	    private Button addPhoneBtn;

	    @FXML
	    private TextField addressTxtField;

	    @FXML
	    private Label availableCountLabel;

	    @FXML
	    private TextField batteryTxtField;

	    @FXML
	    private TextField bojaTxtField;

	    @FXML
	    private TextField cijenaTxtField;

	    @FXML
	    private TextField cityTxtField;

	    @FXML
	    private Button clearPhoneBtn;

	    @FXML
	    private Label customerCountLabel;

	    @FXML
	    private TextField customerIdTxtField;

	    @FXML
	    private Button customers_btn;

	    @FXML
	    private AnchorPane customers_form;

	    @FXML
	    private DatePicker datumTxtField;

	    @FXML
	    private Button deletePhoneBtn;

	    @FXML
	    private ChoiceBox<String> dostupnostChoiceBox;
	    
	    @FXML
	    private ChoiceBox<String> genderChoiceBox;

	    @FXML
	    private TextField firstNameTxtField;

	    @FXML
	    private TextField gbTxtField;

	    @FXML
	    private Button home_btn;

	    @FXML
	    private AnchorPane home_form;

	    @FXML
	    private TextField imeiTxtField;

	    @FXML
	    private Button inventory_btn;

	    @FXML
	    private AnchorPane inventory_form;

	    @FXML
	    private TextField lastNameTxtField;

	    @FXML
	    private Button logout;

	    @FXML
	    private TextField modelTxtField;

	    @FXML
	    private Button myProfile_btn;

	    @FXML
	    private AnchorPane myProfile_form;

	    @FXML
	    private Label ordersCountLabel;

	    @FXML
	    private Button orders_btn;

	    @FXML
	    private AnchorPane orders_form;

	    @FXML
	    private TextField phoneIdTxtField;

	    @FXML
	    private TextField phoneNumberTxtField;

	    @FXML
	    private TextField postalCodeTxtField;

	    @FXML
	    private TextField proizvodjacTextField;

	    @FXML
	    private Button settings_btn;

	    @FXML
	    private AnchorPane settings_form;

	    @FXML
	    private Button updatePhoneBtn;
	    
	    @FXML
	    private Button homeMyProfileBtn;
	    
	    @FXML
	    private Button homeInventoryBtn;
	    
	    @FXML
	    private Button homeOrdersButton;
	    
	    @FXML
	    private Button homeCustomersButton;

	    @FXML
	    private Label usernameLabel;

	    @FXML
	    private TextField usernameTxtField;
	    
	    @FXML
	    private ChoiceBox<String> customerChoiceBox;
	    
	    @FXML
	    private TextField extraCostTxtField;
	    
	    @FXML
	    private Label imeiOrderTxtField;
	    
	    @FXML
	    private TextField orderIDtxtField;
	    
	    @FXML
	    private TextField orderPriceTxtField;
	    
	    @FXML
	    private ChoiceBox<String> imeiChoiceBox;
	    
	    @FXML
	    private DatePicker orderDatePicker;
	    
	    @FXML
	    private Label batteryOrderTxtField;
	    
	    @FXML
	    private Label modelOrderTxtField;
	    
	    @FXML
	    private Label colorOrderTxtField;
	    
	    @FXML
	    private Label storageOrderTxtField;
	    
	    @FXML
	    private TextField profileCompanyName;
	    
	    @FXML
	    private TextField profileCompanyUsername;
	    
	    @FXML
	    private TextField profileCompanyPass;
	    
	    @FXML
	    private TextField profileCompanyPassRepeat;
	    
	    @FXML
	    private TextField phoneSearchTxtField;
	    
	    @FXML
	    private TextField customerSearchTxtField;
	    
	    @FXML
	    private TextField orderSearchTxtField;
	    
	    @FXML
	    private Label companyNameLabel;
	    
	    @FXML
	    private Label prihodiLabel;
	    
	    @FXML
	    private Label rashodiLabel;
	    
	    @FXML
	    private Label profitLabel;
	    
	    
	    @FXML
	    private TableView<Customers> customerTable;
	    @FXML
	    private TableColumn<Customers, String> ctAddress;

	    @FXML
	    private TableColumn<Customers, String> ctCity;

	    @FXML
	    private TableColumn<Customers, String> ctFirstName;

	    @FXML
	    private TableColumn<Customers, String> ctGender;

	    @FXML
	    private TableColumn<Customers, Integer> ctID;

	    @FXML
	    private TableColumn<Customers, String> ctLastName;

	    @FXML
	    private TableColumn<Customers, String> ctPhoneNumber;

	    @FXML
	    private TableColumn<Customers, String> ctPostalCode;

	    @FXML
	    private TableColumn<Customers, String> ctUsername;

	    @FXML
	    private TableView<Inventory> inventoryTable;
	    @FXML
	    private TableColumn<Inventory, String> itAvailability;

	    @FXML
	    private TableColumn<Inventory, String> itBattery;

	    @FXML
	    private TableColumn<Inventory, String> itColor;

	    @FXML
	    private TableColumn<Inventory, String> itDate;

	    @FXML
	    private TableColumn<Inventory, Integer> itID;

	    @FXML
	    private TableColumn<Inventory, String> itImei;

	    @FXML
	    private TableColumn<Inventory, String> itManuf;

	    @FXML
	    private TableColumn<Inventory, String> itModel;

	    @FXML
	    private TableColumn<Inventory, Float> itPrice;

	    @FXML
	    private TableColumn<Inventory, String> itStorage;

	    
	    @FXML
	    private TableView<Orders> ordersTable;
	    
	    @FXML
	    private TableColumn<Orders, String> otCustomer;

	    @FXML
	    private TableColumn<Orders, String> otDate;

	    @FXML
	    private TableColumn<Orders, Float> otExpences;

	    @FXML
	    private TableColumn<Orders, Integer> otID;

	    @FXML
	    private TableColumn<Orders, String> otImei;

	    @FXML
	    private TableColumn<Orders, String> otPhone;

	    @FXML
	    private TableColumn<Orders, Float> otPrice;

	    @FXML
	    private FontAwesomeIcon icon;
	    
	    LoginController loginController= new LoginController();
	    String kompanija_id;
	    private String[] dostupnost= {"na_stanju","prodano"};
	    private String[] pol= {"musko","zensko"};
	    
	    
	    ObservableList<Customers> listC;
	    ObservableList<Inventory> listI;
	    ObservableList<Orders> listO;
	    Connection conn=null;
	    ResultSet rs=null;
	    PreparedStatement pst=null;
	    
	    public void switchForm(ActionEvent event) {

	    	
	    	if(event.getSource() == home_btn) {
	    		home_form.setVisible(true);
	    		myProfile_form.setVisible(false);
	    		inventory_form.setVisible(false);
	    		customers_form.setVisible(false);
	    		orders_form.setVisible(false);
	    		settings_form.setVisible(false);
	    		
	    		home_btn.setStyle("-fx-background-color:#54004a;");
	    		myProfile_btn.setStyle("-fx-background-color:transparent;");
	    		inventory_btn.setStyle("-fx-background-color:transparent;");
	    		customers_btn.setStyle("-fx-background-color:transparent;");
	    		orders_btn.setStyle("-fx-background-color:transparent;");
	    		settings_btn.setStyle("-fx-background-color:transparent;");
	    		
	    		
	    		displayHomeInfo();
	    		
	    	}
	    	
	    	else if(event.getSource() == myProfile_btn || event.getSource() == homeMyProfileBtn) {
	    		home_form.setVisible(false);
	    		myProfile_form.setVisible(true);
	    		inventory_form.setVisible(false);
	    		customers_form.setVisible(false);
	    		orders_form.setVisible(false);
	    		settings_form.setVisible(false);
	    		
	    		myProfile_btn.setStyle("-fx-background-color:#54004a;");
	    		
	    		home_btn.setStyle("-fx-background-color:transparent;");
	    		inventory_btn.setStyle("-fx-background-color:transparent;");
	    		customers_btn.setStyle("-fx-background-color:transparent;");
	    		orders_btn.setStyle("-fx-background-color:transparent;");
	    		settings_btn.setStyle("-fx-background-color:transparent;");
	    		
	    		displayMyProfile();
	    	}
	    	
	    	else if(event.getSource() == inventory_btn || event.getSource() == homeInventoryBtn) {
	    		home_form.setVisible(false);
	    		myProfile_form.setVisible(false);
	    		inventory_form.setVisible(true);
	    		customers_form.setVisible(false);
	    		orders_form.setVisible(false);
	    		settings_form.setVisible(false);
	    		
	    		inventory_btn.setStyle("-fx-background-color:#54004a;");
	    		
	    		myProfile_btn.setStyle("-fx-background-color:transparent;");
	    		home_btn.setStyle("-fx-background-color:transparent;");
	    		customers_btn.setStyle("-fx-background-color:transparent;");
	    		orders_btn.setStyle("-fx-background-color:transparent;");
	    		settings_btn.setStyle("-fx-background-color:transparent;");
	    		
	    		dostupnostChoiceBox.getItems().clear();
	    		dostupnostChoiceBox.getItems().addAll(dostupnost);
	    		
	    		inventoryTable.getItems().clear();
	    		showInventoryTable();
	    	}
	    	
	    	else if(event.getSource() == customers_btn || event.getSource() == homeCustomersButton) {
	    		home_form.setVisible(false);
	    		myProfile_form.setVisible(false);
	    		inventory_form.setVisible(false);
	    		customers_form.setVisible(true);
	    		orders_form.setVisible(false);
	    		settings_form.setVisible(false);
	    		
	    		customers_btn.setStyle("-fx-background-color:#54004a;");
	    		
	    		myProfile_btn.setStyle("-fx-background-color:transparent;");
	    		inventory_btn.setStyle("-fx-background-color:transparent;");
	    		home_btn.setStyle("-fx-background-color:transparent;");
	    		orders_btn.setStyle("-fx-background-color:transparent;");
	    		settings_btn.setStyle("-fx-background-color:transparent;");
	    		
	    		genderChoiceBox.getItems().clear();
	    		genderChoiceBox.getItems().addAll(pol);
	    		
	    		customerTable.getItems().clear();
	    		showCustomersTable();
	    	}
	    	
	    	else if(event.getSource() == orders_btn || event.getSource() == homeOrdersButton) {
	    		home_form.setVisible(false);
	    		myProfile_form.setVisible(false);
	    		inventory_form.setVisible(false);
	    		customers_form.setVisible(false);
	    		orders_form.setVisible(true);
	    		settings_form.setVisible(false);
	    		
	    		orders_btn.setStyle("-fx-background-color:#54004a;");
	    		
	    		myProfile_btn.setStyle("-fx-background-color:transparent;");
	    		inventory_btn.setStyle("-fx-background-color:transparent;");
	    		customers_btn.setStyle("-fx-background-color:transparent;");
	    		home_btn.setStyle("-fx-background-color:transparent;");
	    		settings_btn.setStyle("-fx-background-color:transparent;");
	    		
	    		getCustomersList();
	    		getPhoneList();
	    		ordersTable.getItems().clear();
	    		showOrdersTable();
	    	}
	    	
	    	else if(event.getSource() == settings_btn) {
	    		home_form.setVisible(false);
	    		myProfile_form.setVisible(false);
	    		inventory_form.setVisible(false);
	    		customers_form.setVisible(false);
	    		orders_form.setVisible(false);
	    		settings_form.setVisible(true);
	    		
	    		settings_btn.setStyle("-fx-background-color:#54004a;");
	    		
	    		myProfile_btn.setStyle("-fx-background-color:transparent;");
	    		inventory_btn.setStyle("-fx-background-color:transparent;");
	    		customers_btn.setStyle("-fx-background-color:transparent;");
	    		orders_btn.setStyle("-fx-background-color:transparent;");
	    		home_btn.setStyle("-fx-background-color:transparent;");
	    	}
	    	
	    }

	    public void initialize (URL arg0, ResourceBundle arg1) {
	    	imeiChoiceBox.setOnAction(this::displayPhoneInfo);
	    	
	   
	    }
	    
	    public void displayUsername(String username) {
	    	usernameLabel.setText(username);
	    }
	    
	    
		public void displayHomeInfo() {
			String username;
			username=getKompanijaId();
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			
			float prihodiCijena=0;
			float prihodiTroskovi=0;
			float profit=0;
			
			String selectCustomers="SELECT COUNT(*) FROM kupci WHERE kompanija_id ="+username+";";
			String selectOrders="SELECT COUNT(*) FROM narudzbe WHERE kompanija_id ="+username+";";
			String selectAvPhones= "SELECT COUNT(*) FROM inventar WHERE kompanija_id ="+username+" AND dostupnost='na_stanju';";
			String selectPrihodi="SELECT SUM(cijena) AS prihodi,SUM(dodatni_troskovi) AS troskovi FROM narudzbe  WHERE kompanija_id="+username+" ;";
			String selectRashodi="SELECT SUM(cijena)FROM inventar WHERE kompanija_id="+username+";";
			
			try {
				
				PreparedStatement  statement=connectDB.prepareStatement(selectCustomers);
				 statement.execute();
				
				 Statement  statement2=connectDB.createStatement();
				 Statement  statement3=connectDB.createStatement();
				 Statement  statement4=connectDB.createStatement();
				 Statement  statement5=connectDB.createStatement();
				 Statement  statement6=connectDB.createStatement();

				 ResultSet selectCustomersResult= statement2.executeQuery(selectCustomers);
				 ResultSet selectOrdersResult= statement3.executeQuery(selectOrders);
				 ResultSet selectAvPhonesResult= statement4.executeQuery(selectAvPhones);
				 ResultSet selectPrihodiResult= statement5.executeQuery(selectPrihodi);
				 ResultSet selectRashodiResult= statement6.executeQuery(selectRashodi);
			
				
				 //display broj kupaca
				 while(selectCustomersResult.next()) {
					 customerCountLabel.setText(String.valueOf(selectCustomersResult.getInt(1)));
				 }
				//display broj narudzbi
				 while(selectOrdersResult.next()) {
					 ordersCountLabel.setText(String.valueOf(selectOrdersResult.getInt(1)));
				 }
				//display broj telefona na stanju
				 while(selectAvPhonesResult.next()) {
					 availableCountLabel.setText(String.valueOf(selectAvPhonesResult.getInt(1)));
				 }
				//display prihodi
				 while(selectPrihodiResult.next()) {
					 prihodiCijena=Float.parseFloat(selectPrihodiResult.getString("prihodi"));
					 prihodiTroskovi=Float.parseFloat(selectPrihodiResult.getString("troskovi"));
					 prihodiLabel.setText(String.valueOf(prihodiCijena-prihodiTroskovi));
				 }
				 while(selectRashodiResult.next()) {
					 rashodiLabel.setText(String.valueOf(selectRashodiResult.getInt(1)));
				 }
				
				 profit=Float.parseFloat(prihodiLabel.getText())-Float.parseFloat(rashodiLabel.getText());
				 profitLabel.setText(String.valueOf(profit));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		public String getKompanijaId() {
			
			String id = "";
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			
			String getKompanijaId="SELECT kompanija_id FROM kompanija WHERE username='"+usernameLabel.getText()+"';";
			
			try {
				
				Statement  statement=connectDB.createStatement();
				ResultSet queryGetID= statement.executeQuery(getKompanijaId);
				
				while(queryGetID.next()) {
					id=String.valueOf(queryGetID.getInt(1));
				}
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return id;
			
		}
		
		//PODACI I UNOSENJE PODATAKA O TELEFONIMA

		public  ObservableList<Inventory> getDataInventory(){
			DatabaseConnection sql = new DatabaseConnection();
			Connection conn= sql.getConnection();
			ObservableList<Inventory> inventoryList=FXCollections.observableArrayList();
			String id=getKompanijaId();
			PreparedStatement ps;
			try {
				if(phoneSearchTxtField.getText().isBlank()==true) {
					 ps=conn.prepareStatement("SELECT * FROM inventar WHERE kompanija_id="+id+";");
				}else {
					 ps=conn.prepareStatement("SELECT * FROM inventar WHERE (proizvodjac LIKE '%"+phoneSearchTxtField.getText()+"%' OR model LIKE '%"+phoneSearchTxtField.getText()+"%' OR boja LIKE '%"+phoneSearchTxtField.getText()+"%' OR baterija LIKE '%"+phoneSearchTxtField.getText()+"%' OR imei LIKE '%"+phoneSearchTxtField.getText()+"%' OR pohrana LIKE '%"+phoneSearchTxtField.getText()+"%' OR cijena LIKE '%"+phoneSearchTxtField.getText()+"%'  OR dostupnost LIKE '%"+phoneSearchTxtField.getText()+"%') AND kompanija_id="+getKompanijaId()+";");
				}
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					inventoryList.add(new Inventory(Integer.parseInt(rs.getString("telefon_id")), rs.getString("proizvodjac"), rs.getString("model"), rs.getString("boja"), rs.getString("baterija"), rs.getString("imei"), rs.getString("pohrana"),Float.parseFloat(rs.getString("cijena")) , rs.getString("datum_nabavke"), rs.getString("dostupnost")));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return inventoryList;
			
		}
		
		public void showInventoryTable() {
			
			itID.setCellValueFactory(new PropertyValueFactory<Inventory, Integer>("id"));
			itManuf.setCellValueFactory(new PropertyValueFactory<Inventory, String>("manufactor"));
			itModel.setCellValueFactory(new PropertyValueFactory<Inventory, String>("model"));
			itColor.setCellValueFactory(new PropertyValueFactory<Inventory, String>("color"));
			itBattery.setCellValueFactory(new PropertyValueFactory<Inventory, String>("battery"));
			itImei.setCellValueFactory(new PropertyValueFactory<Inventory, String>("imei"));
			itStorage.setCellValueFactory(new PropertyValueFactory<Inventory, String>("storage"));
			itPrice.setCellValueFactory(new PropertyValueFactory<Inventory, Float>("price"));
			itDate.setCellValueFactory(new PropertyValueFactory<Inventory, String>("date"));
			itAvailability.setCellValueFactory(new PropertyValueFactory<Inventory, String>("availability"));
			
			listI=getDataInventory();
			inventoryTable.setItems(listI);
			
		}

		public int checkImei() {
			int count=0;
			  DatabaseConnection connectNow= new DatabaseConnection();
	       		Connection connectDB= connectNow.getConnection();
	       		
	       		String verifyImei="SELECT count(1) FROM inventar WHERE imei='"+ imeiTxtField.getText()+"'";
	       		
	       		try {
	       			Statement  statement=connectDB.createStatement();
	       			ResultSet queryResult= statement.executeQuery(verifyImei);
		       		while(queryResult.next()) {
		       			count=queryResult.getInt(1);
		       		}
				} catch (Exception e) {
					e.printStackTrace();
				}
			return count;
		}
		
 		public void insertNewPhone() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			int imeiCount=checkImei();
			try {
				if(proizvodjacTextField.getText().isBlank()==true || modelTxtField.getText().isBlank()==true || bojaTxtField.getText().isBlank()==true ||batteryTxtField.getText().isBlank()==true || imeiTxtField.getText().isBlank()==true || gbTxtField.getText().isBlank()==true ||cijenaTxtField.getText().isBlank()==true || datumTxtField.getValue() ==null ||dostupnostChoiceBox.getValue().isBlank()==true ) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Greška");
					alert.setHeaderText("Niste popunili sva polja!");
					alert.setContentText("Molimo Vas popunite sva polja!");
					alert.showAndWait();
				}
				else if(imeiCount==1) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Greška");
					alert.setHeaderText("Unešeni IMEI već postoji");
					alert.setContentText("Molimo Vas unesite različit IMEI!");
					alert.showAndWait();
				}
				else {
					LocalDate datum=datumTxtField.getValue();
					
					
					String insertNewUser="INSERT INTO inventar(proizvodjac,model,boja,baterija,imei,pohrana,cijena,datum_nabavke,dostupnost,kompanija_id) VALUES('"+proizvodjacTextField.getText()+"','"+modelTxtField.getText()+"','"+bojaTxtField.getText()+"','"+batteryTxtField.getText()+"','"+imeiTxtField.getText()+"','"+gbTxtField.getText()+"',"+Float.parseFloat(cijenaTxtField.getText())+",'"+datum.toString()+"','"+dostupnostChoiceBox.getValue()+"',"+id+");";
					
					PreparedStatement  statement=connectDB.prepareStatement(insertNewUser);
					statement.execute();
					
					
						Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Uspješno");
							alert.setHeaderText("Uspješno dodavanje podataka!");
							alert.setContentText("Uspješno ste dodali novi telefon u bazu podataka!");
							alert.showAndWait();
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			inventoryTable.getItems().clear();
    		showInventoryTable();
		}
		
		public void updatePhone() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
		
			
			try {
				if(proizvodjacTextField.getText().isBlank()==true || modelTxtField.getText().isBlank()==true || bojaTxtField.getText().isBlank()==true ||batteryTxtField.getText().isBlank()==true || imeiTxtField.getText().isBlank()==true || gbTxtField.getText().isBlank()==true ||cijenaTxtField.getText().isBlank()==true || datumTxtField.getValue() ==null ||dostupnostChoiceBox.getValue().isBlank()==true ) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Greška");
					alert.setHeaderText("Niste popunili sva polja!");
					alert.setContentText("Molimo Vas popunite sva polja!");
					alert.showAndWait();
				}
				else {
					LocalDate datum=datumTxtField.getValue();
					
					
					String insertNewUser="UPDATE inventar SET proizvodjac='"+proizvodjacTextField.getText()+"', model='"+modelTxtField.getText()+"', boja='"+bojaTxtField.getText()+"',baterija='"+batteryTxtField.getText()+"',imei='"+imeiTxtField.getText()+"' , pohrana='"+gbTxtField.getText()+"', cijena='"+Float.parseFloat(cijenaTxtField.getText())+"', datum_nabavke='"+datum.toString()+"', dostupnost='"+dostupnostChoiceBox.getValue()+"' WHERE kompanija_id="+id+" AND telefon_id="+phoneIdTxtField.getText()+";";
					
					PreparedStatement  statement=connectDB.prepareStatement(insertNewUser);
					statement.execute();
					
					
						Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Uspješno");
							alert.setHeaderText("Uspješno ažuriranje podataka!");
							alert.setContentText("Uspješno ste ažurirali telefon u bazi podataka!");
							alert.showAndWait();
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			inventoryTable.getItems().clear();
    		showInventoryTable();
		}
		
		public void deletePhone() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			
			
			try {
				if(phoneIdTxtField.getText().isBlank()==true) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Greška");
					alert.setHeaderText("Niste unijeli postojeći ID telefona!");
					alert.setContentText("Molimo Vas unesite ispravan ID telefona!");
					alert.showAndWait();
				}
				else {
					
					
					
					String deletePhone="DELETE FROM inventar WHERE telefon_id="+phoneIdTxtField.getText()+" AND kompanija_id="+id+";";
					
					PreparedStatement  statement=connectDB.prepareStatement(deletePhone);
					statement.execute();
					
					
						Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Uspješno");
							alert.setHeaderText("Uspješno brisanje!");
							alert.setContentText("Uspješno ste obrisali telefon iz baze podataka!");
							alert.showAndWait();
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			inventoryTable.getItems().clear();
    		showInventoryTable();
		}

		public void clearPhoneFields() {
			phoneIdTxtField.setText(null);;
			proizvodjacTextField.setText(null);
			modelTxtField.setText(null);;
			bojaTxtField.setText(null);;
			batteryTxtField.setText(null);;
			imeiTxtField.setText(null);;
			gbTxtField.setText(null);;
			cijenaTxtField.setText(null);;
			datumTxtField.setValue(null);;
			dostupnostChoiceBox.setValue(null);;
		}
		
		public void selectPhone() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			String selectPhone="SELECT * FROM inventar WHERE telefon_id='"+phoneIdTxtField.getText()+"' AND kompanija_id='"+id+"'";
			
			try {
				
				Statement  statement=connectDB.createStatement();
				ResultSet queryResult= statement.executeQuery(selectPhone);
				
				while(queryResult.next()) {
					
					String dateString = queryResult.getString("datum_nabavke");
			        String pattern = "yyyy-MM-dd";
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			        LocalDate date = LocalDate.parse(dateString, formatter);
			        
						proizvodjacTextField.setText(queryResult.getString("proizvodjac"));
						modelTxtField.setText(queryResult.getString("model"));
						bojaTxtField.setText(queryResult.getString("boja"));
						batteryTxtField.setText(queryResult.getString("baterija"));
						imeiTxtField.setText(queryResult.getString("imei"));
						gbTxtField.setText(queryResult.getString("pohrana"));
						cijenaTxtField.setText(queryResult.getString("cijena"));
						datumTxtField.setValue(date);
						dostupnostChoiceBox.setValue(queryResult.getString("dostupnost"));
						
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		public void changeAvailibilitySold() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			String telefon_id=getPhoneId();
			
			try {
						
					String updateAvailibility="UPDATE inventar SET dostupnost='prodano' WHERE telefon_id="+telefon_id+" AND kompanija_id="+id+"";
					
					PreparedStatement  statement=connectDB.prepareStatement(updateAvailibility);
					statement.execute();
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public void changeAvailibilityAvailable() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			String telefon_id=getPhoneId();
			
			try {
						
					String updateAvailibility="UPDATE inventar SET dostupnost='na_stanju' WHERE telefon_id="+telefon_id+" AND kompanija_id="+id+"";
					
					PreparedStatement  statement=connectDB.prepareStatement(updateAvailibility);
					statement.execute();
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		//KRAJ TELEFONI
		
		//PODACI I UNOSENJE PODATAKA O KUPCIMA
		public  ObservableList<Customers> getDataCustomer(){
			DatabaseConnection sql=new DatabaseConnection();
			Connection conn= sql.getConnection();
			ObservableList<Customers> customerList=FXCollections.observableArrayList();
			String id=getKompanijaId();
			PreparedStatement ps;
			try {
				if(customerSearchTxtField.getText().isBlank()==true) {
					ps=conn.prepareStatement("SELECT * FROM kupci WHERE kompanija_id="+id+";");
				}else {
					ps=conn.prepareStatement("SELECT * FROM kupci WHERE (ime LIKE '%"+customerSearchTxtField.getText()+"%' OR prezime LIKE '%"+customerSearchTxtField.getText()+"%' OR pol LIKE '%"+customerSearchTxtField.getText()+"%' OR grad LIKE '%"+customerSearchTxtField.getText()+"%' or pr_broj LIKE '%"+customerSearchTxtField.getText()+"%' OR adresa LIKE '%"+customerSearchTxtField.getText()+"%' OR broj_tel LIKE '%"+customerSearchTxtField.getText()+"%' OR korisnicko_ime LIKE '%"+customerSearchTxtField.getText()+"%')  AND kompanija_id="+getKompanijaId()+";");
				}
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					customerList.add(new Customers(Integer.parseInt(rs.getString("kupac_id")), rs.getString("ime"), rs.getString("prezime"), rs.getString("pol"), rs.getString("grad"), rs.getString("pr_broj"), rs.getString("adresa"), rs.getString("broj_tel"), rs.getString("korisnicko_ime")));
				}
			} catch (Exception e) {
				 e.printStackTrace();
			}
			
			return customerList;
			
		}
		
		public void showCustomersTable() {
			
			
			ctID.setCellValueFactory(new PropertyValueFactory<Customers, Integer>("id"));
			ctFirstName.setCellValueFactory(new PropertyValueFactory<Customers, String>("firstName"));
			ctLastName.setCellValueFactory(new PropertyValueFactory<Customers, String>("lastName"));
			ctGender.setCellValueFactory(new PropertyValueFactory<Customers, String>("gender"));
			ctCity.setCellValueFactory(new PropertyValueFactory<Customers, String>("city"));
			ctPostalCode.setCellValueFactory(new PropertyValueFactory<Customers, String>("postalCode"));
			ctAddress.setCellValueFactory(new PropertyValueFactory<Customers, String>("address"));
			ctPhoneNumber.setCellValueFactory(new PropertyValueFactory<Customers, String>("phoneNumber"));
			ctUsername.setCellValueFactory(new PropertyValueFactory<Customers, String>("username"));
			
			listC=getDataCustomer();
			customerTable.setItems(listC);
			
		}
		
		public void insertNewCustomer() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			
			try {
				if(firstNameTxtField.getText().isBlank()==true || lastNameTxtField.getText().isBlank()==true || genderChoiceBox.getValue()==null || cityTxtField.getText().isBlank()==true || postalCodeTxtField.getText().isBlank()==true || addressTxtField.getText().isBlank()==true || phoneNumberTxtField.getText().isBlank()==true || usernameTxtField.getText().isBlank()==true) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Greška");
					alert.setHeaderText("Niste popunili sva polja!");
					alert.setContentText("Molimo Vas popunite sva polja!");
					alert.showAndWait();
				}
				else {
					
					String insertNewCustomer="INSERT INTO kupci(ime,prezime,pol,grad,pr_broj,adresa,broj_tel,korisnicko_ime,kompanija_id) VALUES('"+firstNameTxtField.getText()+"','"+lastNameTxtField.getText()+"','"+genderChoiceBox.getValue()+"','"+cityTxtField.getText()+"','"+postalCodeTxtField.getText()+"','"+addressTxtField.getText()+"','"+phoneNumberTxtField.getText()+"','"+usernameTxtField.getText()+"','"+id+"');";
					
					PreparedStatement  statement=connectDB.prepareStatement(insertNewCustomer);
					statement.execute();
					
					
						Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Uspješno");
							alert.setHeaderText("Uspješno dodavanje podataka!");
							alert.setContentText("Uspješno ste dodali novog kupca u bazu podataka!");
							alert.showAndWait();
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			customerTable.getItems().clear();
    		showCustomersTable();
		}
		
		public void updateCustomer() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
		
			
			try {
				if(customerIdTxtField.getText().isBlank()==true || firstNameTxtField.getText().isBlank()==true || lastNameTxtField.getText().isBlank()==true || genderChoiceBox.getValue()==null || cityTxtField.getText().isBlank()==true || postalCodeTxtField.getText().isBlank()==true || addressTxtField.getText().isBlank()==true || phoneNumberTxtField.getText().isBlank()==true || usernameTxtField.getText().isBlank()==true) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Greška");
					alert.setHeaderText("Niste popunili sva polja!");
					alert.setContentText("Molimo Vas popunite sva polja!");
					alert.showAndWait();
				}
				else {
							
					String updateCustomer="UPDATE kupci SET ime='"+firstNameTxtField.getText()+"',prezime='"+lastNameTxtField.getText()+"',pol='"+genderChoiceBox.getValue()+"',grad='"+cityTxtField.getText()+"',pr_broj='"+postalCodeTxtField.getText()+"',adresa='"+addressTxtField.getText()+"',broj_tel='"+phoneNumberTxtField.getText()+"',korisnicko_ime='"+usernameTxtField.getText()+"' WHERE kompanija_id="+id+" AND kupac_id="+customerIdTxtField.getText()+";";
					
					PreparedStatement  statement=connectDB.prepareStatement(updateCustomer);
					statement.execute();
					
					
						Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Uspješno");
							alert.setHeaderText("Uspješno mijenjanje podataka!");
							alert.setContentText("Uspješno ste izmjenili podatke u bazi podataka!");
							alert.showAndWait();
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			customerTable.getItems().clear();
    		showCustomersTable();
		}
		
		public void deleteCustomer() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			
			
			try {
				if(customerIdTxtField.getText().isBlank()==true) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Greška");
					alert.setHeaderText("Niste unijeli postojeći ID kupca!");
					alert.setContentText("Molimo Vas unesite ispravan ID kupca!");
					alert.showAndWait();
				}
				else {
					
					String deleteCustomer="DELETE FROM kupci WHERE kupac_id="+customerIdTxtField.getText()+" AND kompanija_id="+id+";";
					
					PreparedStatement  statement=connectDB.prepareStatement(deleteCustomer);
					statement.execute();
					
					
						Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Uspješno");
							alert.setHeaderText("Uspješno brisanje!");
							alert.setContentText("Uspješno ste obrisali kupca iz baze podataka!");
							alert.showAndWait();
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			customerTable.getItems().clear();
    		showCustomersTable();
		}

		public void clearCustomerFields() {
			customerIdTxtField.setText(null);
			firstNameTxtField.setText(null);
			lastNameTxtField.setText(null);
			genderChoiceBox.setValue(null);
			cityTxtField.setText(null);
			postalCodeTxtField.setText(null);
			addressTxtField.setText(null);
			phoneNumberTxtField.setText(null);
			usernameTxtField.setText(null);
			
		}
		
		public void selectCustomer() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			String selectCustomer="SELECT * FROM kupci WHERE kupac_id='"+customerIdTxtField.getText()+"' AND kompanija_id='"+id+"'";
			
			try {
				
				Statement  statement=connectDB.createStatement();
				ResultSet queryResult= statement.executeQuery(selectCustomer);
				
				while(queryResult.next()) {
			        
						firstNameTxtField.setText(queryResult.getString("ime"));
						lastNameTxtField.setText(queryResult.getString("prezime"));
						genderChoiceBox.setValue(queryResult.getString("pol"));
						cityTxtField.setText(queryResult.getString("grad"));
						postalCodeTxtField.setText(queryResult.getString("pr_broj"));
						addressTxtField.setText(queryResult.getString("adresa"));
						phoneNumberTxtField.setText(queryResult.getString("broj_tel"));
						usernameTxtField.setText(queryResult.getString("korisnicko_ime"));
						
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		
		//KRAJ KUPCI
		
		//NARUDZBE PODACI UNOSENJE PODATAKA O NARUDZBAMA
		
		public  ObservableList<Orders> getDataOrder(){
			DatabaseConnection sql=new DatabaseConnection();
			Connection conn= sql.getConnection();
			ObservableList<Orders> ordersList=FXCollections.observableArrayList();
			String id=getKompanijaId();
			PreparedStatement ps;
			try {
				if(orderSearchTxtField.getText().isBlank()==true) {
					ps=conn.prepareStatement("SELECT \r\n"
							+ "					    CONCAT(k.ime, ' ', k.prezime) AS kupac,\r\n"
							+ "                        i.model,\r\n"
							+ "					    i.imei,\r\n"
							+ "                        n.narudzba_id,\r\n"
							+ "					   n.datum_prodaje,\r\n"
							+ "					   n.cijena,\r\n"
							+ "					    n.dodatni_troskovi\r\n"
							+ "					FROM narudzbe n\r\n"
							+ "					JOIN kupci k ON n.kupac_id = k.kupac_id\r\n"
							+ "					JOIN inventar i ON n.telefon_id = i.telefon_id\r\n"
							+ "					WHERE n.kompanija_id ="+id+";\r\n"
							+ "					");
					
				}else {
					ps=conn.prepareStatement("SELECT \r\n"
							+ "										CONCAT(k.ime, ' ', k.prezime) AS kupac,\r\n"
							+ "										i.model,\r\n"
							+ "										i.imei,\r\n"
							+ "										n.narudzba_id,\r\n"
							+ "										n.datum_prodaje,\r\n"
							+ "										n.cijena,\r\n"
							+ "										n.dodatni_troskovi\r\n"
							+ "										FROM narudzbe n\r\n"
							+ "										JOIN kupci k ON n.kupac_id = k.kupac_id\r\n"
							+ "										JOIN inventar i ON n.telefon_id = i.telefon_id\r\n"
							+ "										WHERE (CONCAT(k.ime, ' ', k.prezime) LIKE '%"+orderSearchTxtField.getText()+"%' OR i.model LIKE '%"+orderSearchTxtField.getText()+"%' OR i.imei LIKE '%"+orderSearchTxtField.getText()+"%' OR n.cijena LIKE '%"+orderSearchTxtField.getText()+"%' OR n.dodatni_troskovi LIKE '%"+orderSearchTxtField.getText()+"%') AND n.kompanija_id ="+getKompanijaId()+";\r\n"
							+ "										");
					
				}
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					ordersList.add(new Orders(Integer.parseInt(rs.getString("narudzba_id")), rs.getString("kupac"), rs.getString("model"), rs.getString("imei"), rs.getString("datum_prodaje"), Float.parseFloat(rs.getString("cijena")), Float.parseFloat(rs.getString("dodatni_troskovi"))));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return ordersList;
			
		}
		
		public void showOrdersTable() {
			
			otID.setCellValueFactory(new PropertyValueFactory<Orders, Integer>("id"));
			otCustomer.setCellValueFactory(new PropertyValueFactory<Orders, String>("customer"));
			otPhone.setCellValueFactory(new PropertyValueFactory<Orders, String>("phone"));
			otImei.setCellValueFactory(new PropertyValueFactory<Orders, String>("imei"));
			otDate.setCellValueFactory(new PropertyValueFactory<Orders, String>("date"));
			otPrice.setCellValueFactory(new PropertyValueFactory<Orders, Float>("price"));
			otExpences.setCellValueFactory(new PropertyValueFactory<Orders, Float>("expences"));
			
			listO=getDataOrder();
			ordersTable.setItems(listO);
			
		}
		
		public void getCustomersList() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			String selectCustomer="SELECT CONCAT(ime, ' ', prezime) AS kupac FROM kupci WHERE kompanija_id="+id+";";
			
			customerChoiceBox.getItems().clear();;
			List<String> customerList = new ArrayList<>();
			try {
				
				Statement  statement=connectDB.createStatement();
				ResultSet queryResult= statement.executeQuery(selectCustomer);
				
				while(queryResult.next()) {
			        
					 customerList.add(queryResult.getString("kupac"));
						
				}
				String[] customerArray = new String[customerList.size()];
			    customerArray = customerList.toArray(customerArray);
			    customerChoiceBox.getItems().addAll(customerArray);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		public void getPhoneList() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			String selectPhone="SELECT imei FROM inventar  WHERE kompanija_id="+id+" AND dostupnost='na_stanju';";
			
			imeiChoiceBox.getItems().clear();
			
			List<String> PhoneList = new ArrayList<>();
			try {
				
				Statement  statement=connectDB.createStatement();
				ResultSet queryResult= statement.executeQuery(selectPhone);
				
				while(queryResult.next()) {
			        
					PhoneList.add(queryResult.getString("imei"));
						
				}
				String[] PhoneArray = new String[PhoneList.size()];
				PhoneArray = PhoneList.toArray(PhoneArray);
			    imeiChoiceBox.getItems().addAll(PhoneArray);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		public void selectOrder() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			String selectCustomer="SELECT \r\n"
					+ "    CONCAT(k.ime, ' ', k.prezime) AS kupac,\r\n"
					+ "    i.imei,\r\n"
					+ "    n.datum_prodaje,\r\n"
					+ "    n.cijena,\r\n"
					+ "    n.dodatni_troskovi\r\n"
					+ "FROM narudzbe n\r\n"
					+ "JOIN kupci k ON n.kupac_id = k.kupac_id\r\n"
					+ "JOIN inventar i ON n.telefon_id = i.telefon_id\r\n"
					+ "WHERE n.kompanija_id = "+id+";\r\n"
					+ "";
			
			try {
				
				Statement  statement=connectDB.createStatement();
				ResultSet queryResult= statement.executeQuery(selectCustomer);
				
				while(queryResult.next()) {
					String dateString = queryResult.getString("datum_prodaje");
			        String pattern = "yyyy-MM-dd";
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			        LocalDate date = LocalDate.parse(dateString, formatter);
			        
						customerChoiceBox.setValue(queryResult.getString("kupac"));
						imeiChoiceBox.setValue(queryResult.getString("imei"));
						orderDatePicker.setValue(date);
						orderPriceTxtField.setText(queryResult.getString("cijena"));
						extraCostTxtField.setText(queryResult.getString("dodatni_troskovi"));
						
						
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		public String getPhoneId() {
			
			String company_id=getKompanijaId();
			String id = "";
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			
			String getPhoneId="SELECT telefon_id FROM inventar WHERE imei='"+imeiChoiceBox.getValue()+"'AND kompanija_id="+company_id+";";
			
			try {
				
				Statement  statement=connectDB.createStatement();
				ResultSet queryGetID= statement.executeQuery(getPhoneId);
				
				while(queryGetID.next()) {
					id=String.valueOf(queryGetID.getInt(1));
				}
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return id;
			
		}

		public String getCustomerId() {
			
			String id = "";
			String company_id=getKompanijaId();
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			
			String fullName=customerChoiceBox.getValue();
			String[] nameParts = fullName.split(" ", 2); // Split the full name into two parts

                String firstName = nameParts[0];
                String lastName = nameParts[1];

            
			String getCustomerId="SELECT kupac_id FROM kupci WHERE ime='"+firstName+"' AND prezime='"+lastName+"' AND kompanija_id="+company_id+";";
			
			try {
				
				Statement  statement=connectDB.createStatement();
				ResultSet queryGetID= statement.executeQuery(getCustomerId);
				
				while(queryGetID.next()) {
					id=String.valueOf(queryGetID.getInt(1));
				}
					
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return id;
			
		}
		
		public void insertNewOrder() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			
			try {
				if(customerChoiceBox.getValue()==null || imeiChoiceBox.getValue()==null || orderDatePicker.getValue()==null || orderPriceTxtField.getText().isBlank()==true || extraCostTxtField.getText().isBlank()==true) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Greška");
					alert.setHeaderText("Niste popunili sva polja!");
					alert.setContentText("Molimo Vas popunite sva polja!");
					alert.showAndWait();
				}
				else {
					
					String kupac_id=getCustomerId();
					String telefon_id=getPhoneId();
					
					String insertNewOrder="INSERT INTO narudzbe(kupac_id,telefon_id,datum_prodaje,cijena,dodatni_troskovi,kompanija_id) VALUES('"+kupac_id+"','"+telefon_id+"','"+orderDatePicker.getValue().toString()+"','"+Float.parseFloat(orderPriceTxtField.getText())+"','"+Float.parseFloat(extraCostTxtField.getText())+"','"+id+"') ;";
					
					PreparedStatement  statement=connectDB.prepareStatement(insertNewOrder);
					statement.execute();
					
					
						Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Uspješno");
							alert.setHeaderText("Uspješno kreiranje narudžbe!");
							alert.setContentText("Uspješno ste dodali novu narudžbu u bazu podataka!");
							alert.showAndWait();
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			ordersTable.getItems().clear();
    		showOrdersTable();
    		changeAvailibilitySold();
    		getPhoneList();
		}
		
		public void updateOrder() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			
			
			try {
				if(orderIDtxtField.getText().isBlank()==true ||customerChoiceBox.getValue()==null || imeiChoiceBox.getValue()==null || orderDatePicker.getValue()==null || orderPriceTxtField.getText().isBlank()==true || extraCostTxtField.getText().isBlank()==true) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Greška");
					alert.setHeaderText("Niste popunili sva polja!");
					alert.setContentText("Molimo Vas popunite sva polja!");
					alert.showAndWait();
				}
				else {
						
					String kupac_id=getCustomerId();
					String telefon_id=getPhoneId();
					String updateOrder="UPDATE narudzbe SET kupac_id="+kupac_id+",telefon_id="+telefon_id+",datum_prodaje='"+orderDatePicker.getValue().toString()+"',cijena='"+Float.parseFloat(orderPriceTxtField.getText())+"',dodatni_troskovi='"+Float.parseFloat(extraCostTxtField.getText())+"',kompanija_id="+id+" WHERE narudzba_id="+orderIDtxtField.getText()+" AND kompanija_id="+id+";";
					
					PreparedStatement  statement=connectDB.prepareStatement(updateOrder);
					statement.execute();
					
					
						Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Uspješno");
							alert.setHeaderText("Uspješno mijenjanje podataka!");
							alert.setContentText("Uspješno ste izmjenili podatke narudžbe u bazi podataka!");
							alert.showAndWait();
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			ordersTable.getItems().clear();
    		showOrdersTable();
		}
		
		public void deleteOrder() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			
			
			try {
				if(orderIDtxtField.getText().isBlank()==true) {
					
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Greška");
					alert.setHeaderText("Niste unijeli postojeći ID kupca!");
					alert.setContentText("Molimo Vas unesite ispravan ID kupca!");
					alert.showAndWait();
				}
				else {
					
					String deleteCustomer="DELETE FROM narudzbe WHERE narudzba_id="+orderIDtxtField.getText()+" AND kompanija_id="+id+";";
					
					PreparedStatement  statement=connectDB.prepareStatement(deleteCustomer);
					statement.execute();
					
					
						Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Uspješno");
							alert.setHeaderText("Uspješno brisanje!");
							alert.setContentText("Uspješno ste obrisali narudžbu iz baze podataka!");
							alert.showAndWait();
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			ordersTable.getItems().clear();
    		showOrdersTable();
    		changeAvailibilityAvailable();
		}

		public void clearOrderFields() {
			orderIDtxtField.setText(null);
			customerChoiceBox.setValue(null);
			imeiChoiceBox.setValue(null);
			orderPriceTxtField.setText(null);
			extraCostTxtField.setText(null);
		
		}
		
		public void displayPhoneInfo(ActionEvent event) {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			String selectCustomer="SELECT model,boja,baterija,pohrana FROM inventar WHERE imei='"+imeiChoiceBox.getValue()+"' AND kompanija_id='"+id+"'";
			
			try {
				
				Statement  statement=connectDB.createStatement();
				ResultSet queryResult= statement.executeQuery(selectCustomer);
				
				while(queryResult.next()) {
			        
						modelOrderTxtField.setText(queryResult.getString("model"));
						colorOrderTxtField.setText(queryResult.getString("boja"));
						batteryOrderTxtField.setText(queryResult.getString("baterija"));
						storageOrderTxtField.setText(queryResult.getString("pohrana"));
						
						
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		
		//KRAJ NARUDZBE
		
		
		//MOJ PROFIL EDITOVANJE
		
		public void displayMyProfile() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			String selectCustomer="SELECT * FROM kompanija WHERE kompanija_id='"+id+"'";
			
			try {
				
				Statement  statement=connectDB.createStatement();
				ResultSet queryResult= statement.executeQuery(selectCustomer);
				
				while(queryResult.next()) {
			        
						profileCompanyName.setText(queryResult.getString("naziv"));
						profileCompanyUsername.setText(queryResult.getString("username"));
						companyNameLabel.setText(queryResult.getString("naziv"));
						
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		public void updateMyProfile() {
			DatabaseConnection connectNow= new DatabaseConnection();
			Connection connectDB= connectNow.getConnection();
			String id=getKompanijaId();
			String password = null;
			
			try {
				if(profileCompanyName.getText().isBlank()==false && profileCompanyUsername.getText().isBlank()==false && profileCompanyPass.getText().isBlank()==false &&profileCompanyPassRepeat.getText().isBlank()==true) {
					
					String selectCompany="SELECT * FROM kompanija WHERE kompanija_id='"+id+"'";
					
					try {
						
						Statement  statement=connectDB.createStatement();
						ResultSet queryResult= statement.executeQuery(selectCompany);
						
						while(queryResult.next()) {
								password=queryResult.getString("sifra");
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if(profileCompanyPass.getText().equals(password)) {
						
						//update samo ime i naziv
						String updateProfile="UPDATE kompanija SET username='"+profileCompanyUsername.getText()+"',naziv='"+profileCompanyName.getText()+"' WHERE kompanija_id="+id+";";
						
						PreparedStatement  statement=connectDB.prepareStatement(updateProfile);
						statement.execute();
						
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Uspješno");
						alert.setHeaderText("Uspješno ažuriranje profila!");
						alert.setContentText("Uspješno ažuriranje naziva i username-a!");
						alert.showAndWait();
						
						displayUsername(profileCompanyUsername.getText());
					}
					else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Greška");
						alert.setHeaderText("Pogrešna šifra");
						alert.setContentText("Unesite ispravnu šifru!");
						alert.showAndWait();
						
					}
					
				}
				else if(profileCompanyName.getText().isBlank()==false && profileCompanyUsername.getText().isBlank()==false && profileCompanyPass.getText().isBlank()==false && profileCompanyPassRepeat.getText().isBlank()==false) {
							
					
					String selectCompany="SELECT * FROM kompanija WHERE kompanija_id='"+id+"'";
					
					try {
						
						Statement  statement=connectDB.createStatement();
						ResultSet queryResult= statement.executeQuery(selectCompany);
						
						while(queryResult.next()) {
								password=queryResult.getString("sifra");
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					if(profileCompanyPass.getText().equals(password)) {
						
						//update sifru ime i naziv
						String updateProfile="UPDATE kompanija SET username='"+profileCompanyUsername.getText()+"',naziv='"+profileCompanyName.getText()+"',sifra='"+profileCompanyPassRepeat.getText()+"' WHERE kompanija_id="+id+";";
						
						PreparedStatement  statement=connectDB.prepareStatement(updateProfile);
						statement.execute();
						
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Uspješno");
						alert.setHeaderText("Uspješno ažuriranje profila!");
						alert.setContentText("Uspješno ažuriranje profila i nove šifre!");
						alert.showAndWait();
						
						displayUsername(profileCompanyUsername.getText());
						profileCompanyPassRepeat.setText(null);
					}
					else {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Greška");
						alert.setHeaderText("Pogrešna šifra");
						alert.setContentText("Unesite ispravnu staru šifru!");
						alert.showAndWait();
					}
					
					
				}else if(profileCompanyPass.getText().isBlank()==true){
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Greška");
					alert.setHeaderText("Prazna polja");
					alert.setContentText("Molimo unesite šifru!");
					alert.showAndWait();
				}
					
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//KRAJ MOJ PROFIL
		
		//logout start
		private Stage stage;
		private Scene scene;
		
		public void logout(ActionEvent event) throws IOException {
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("ODJAVA");
			alert.setHeaderText("Odjava sa profila!");
			alert.setContentText("Da li ste sigurni da se želite odjaviti?");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
				stage= (Stage)((Node)event.getSource()).getScene().getWindow();
				scene= new Scene(root);
				stage.setScene(scene);
				stage.show();
			} else {
			    // ... user chose CANCEL or closed the dialog
			}
		}
		//logout end
		
		
}
