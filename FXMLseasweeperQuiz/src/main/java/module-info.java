module fxmlseasweeperquiz {
    requires javafx.controls;
    requires javafx.fxml;

    opens fxmlseasweeperquiz to javafx.fxml;
    exports fxmlseasweeperquiz;
}