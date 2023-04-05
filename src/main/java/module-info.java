module com.example.job {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.job to javafx.fxml;
    exports com.example.job;
}