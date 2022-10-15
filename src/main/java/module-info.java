module com.example.laboratorio_final {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    exports com.example.laboratorioFinal to javafx.fxml;
    exports com.example.laboratorioFinal.controller to javafx.fxml;
    exports com.example.laboratorioFinal.model to javafx.fxml;
    opens com.example.laboratorioFinal.model to javafx.base;
    opens com.example.laboratorioFinal.controller to javafx.fxml;
    opens com.example.laboratorioFinal to javafx.graphics;


}