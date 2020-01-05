import gui.MainScene;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) { launch(args); }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("My Novels List");

        StackPane stackPaneLayout = new StackPane();
        BorderPane borderPane = new BorderPane();
        Group group = new Group();
        Scene scene = new Scene(borderPane, Color.CRIMSON);
//        group.getChildren().add(line);
//        ObservableList observableList = group.getChildren();
        ObservableList<HBox> lines = FXCollections.emptyObservableList();

        HBox line = new HBox();
        Button button = new Button("test1");
        line.getChildren().add(button);
        line.getChildren().add(new Text("test text"));
//        lines.add(line);


        ObservableList<String> names = FXCollections.observableArrayList(
                "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
        ListView<String> listView = new ListView<String>(names);
        ListView<HBox> listView1 = new ListView<>(lines);
        borderPane.setCenter(line);

        window.setScene(scene);
        window.show();

    }
}
