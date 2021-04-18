module es.joaquinjimenez.Lectura {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.joaquinjimenez.Lectura to javafx.fxml;
    exports es.joaquinjimenez.Lectura;
}