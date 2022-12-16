module by.bsuir.lab1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens by.bsuir.lab1 to javafx.fxml;
    exports by.bsuir.lab1;
}