package tests.learning;

import data.Novel;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Tests extends Application {

    private TableView<Novel> table = new TableView<Novel>();
    private final ObservableList<Novel> data =
            FXCollections.observableArrayList(
                    new Novel("tgr", "https://www.wuxiaworld.com/novel/the-great-ruler", "27.10.2019", "1500"));
    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(1920);
        stage.setHeight(1070);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);
        table.setMinSize(scene.getWidth(),scene.getHeight());

        TableColumn titleCol0 = new TableColumn("Title");
        titleCol0.setMinWidth(100);
        titleCol0.setCellValueFactory(
                new PropertyValueFactory<Novel, String>("title"));

        TableColumn linkCol1 = new TableColumn("Link");
        linkCol1.setMinWidth(300);
        linkCol1.setCellValueFactory(
                new PropertyValueFactory<Novel, String>("link"));

        TableColumn lastUpdateDateCol2 = new TableColumn("Last update date");
        lastUpdateDateCol2.setMinWidth(50);
        lastUpdateDateCol2.setCellValueFactory(
                new PropertyValueFactory<Novel, String>("lastUpdateDate"));

        TableColumn chapterCol3 = new TableColumn("Chapter");
        chapterCol3.setMaxWidth(50);
        chapterCol3.setCellValueFactory(
                new PropertyValueFactory<Novel, String>("chapter"));

        table.setItems(data);
        table.getColumns().addAll(titleCol0, linkCol1, lastUpdateDateCol2, chapterCol3);

        final TextField addTitleTF = new TextField();
        addTitleTF.setPromptText("Title");
        addTitleTF.setMaxWidth(titleCol0.getPrefWidth());
        final TextField addLastUpdateDateTF = new TextField();
        addLastUpdateDateTF.setPromptText("Last update date");
        addLastUpdateDateTF.setMaxWidth(linkCol1.getPrefWidth());
        final TextField addLinkTF = new TextField();
        addLinkTF.setPromptText("link");
        addLinkTF.setMaxWidth(lastUpdateDateCol2.getPrefWidth());
        final TextField addChapterTF = new TextField();
        addChapterTF.setPromptText("Chapter number");
        addChapterTF.setMaxWidth(chapterCol3.getPrefWidth());

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Novel(
                        addTitleTF.getText(),
                        addLinkTF.getText(),
                        addLastUpdateDateTF.getText(),
                        addChapterTF.getText()));
                addTitleTF.clear();
                addLastUpdateDateTF.clear();
                addLinkTF.clear();
                addChapterTF.clear();
            }
        });

        hb.getChildren().addAll(addTitleTF,addLinkTF, addLastUpdateDateTF, addChapterTF, addButton);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}