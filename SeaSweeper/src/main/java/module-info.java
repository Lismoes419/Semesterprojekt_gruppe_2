module seasweeper.seasweeper {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens seasweeper.seasweeper to javafx.fxml;
    exports seasweeper.seasweeper;
}