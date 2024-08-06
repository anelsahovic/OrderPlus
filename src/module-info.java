module OrderPlus {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires java.sql;
	requires mysql.connector.j;
	requires fontawesomefx;
	
    

	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
