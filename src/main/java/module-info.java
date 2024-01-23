module com.example.gestionnairepersonnes {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.testng;


    opens com.example.gestionnairepersonnes to javafx.fxml;
    exports com.example.gestionnairepersonnes;
}