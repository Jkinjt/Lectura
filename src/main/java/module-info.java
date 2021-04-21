module es.joaquinjimenez.Lectura {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml.bind;
	requires com.sun.xml.txw2;

    opens es.joaquinjimenez.Lectura to javafx.fxml, java.xml.bind;
    opens es.joaquinjimenez.utils to java.xml.bind;
    exports es.joaquinjimenez.Lectura;
}