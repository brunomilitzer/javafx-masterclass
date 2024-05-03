module com.brunomilitzer.props {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.brunomilitzer.props to javafx.fxml;
    exports com.brunomilitzer.props;
}