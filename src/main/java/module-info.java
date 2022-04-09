module com.example.assignmentv1_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires eu.hansolo.tilesfx;

    opens com.example.assignmentv1_1 to javafx.fxml;
    exports com.example.assignmentv1_1;
    requires java.desktop;
}