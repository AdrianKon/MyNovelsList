package gui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainScene extends Scene {

    public MainScene(Parent root) {
        super(root);
        Button confirmButton = new Button("Confirm");
        root.getChildrenUnmodifiable().add(confirmButton);
    }
}
