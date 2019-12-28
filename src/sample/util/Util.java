package sample.util;


import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Util {

    public static void showMessage(String message) {
        StackPane stackPane = new StackPane();
        Label label = new Label(message);
        stackPane.getChildren().add(label);
        Stage stage = new Stage();
        stage.setScene(new Scene(stackPane, 300, 50));
        stage.show();
    }
}
