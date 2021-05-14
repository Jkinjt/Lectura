module es.joaquinjimenez.Lectura {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml.bind;
	requires com.sun.xml.txw2;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	

    opens es.joaquinjimenez.Lectura to javafx.fxml, java.xml.bind;
    opens es.joaquinjimenez.Lectura.utils to java.xml.bind;
    opens es.joaquinjimenez.Lectura.conexion to java.xml.bind;
    exports es.joaquinjimenez.Lectura;
    exports es.joaquinjimenez.Lectura.conexion;
    exports es.joaquinjimenez.Lectura.utils;
    
}