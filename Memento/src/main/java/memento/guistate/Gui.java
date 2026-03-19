package memento.guistate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Gui extends Application {
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    @Override
    public void start(Stage stage) {
        controller = new Controller(this);

        Insets insets = new Insets(10, 10, 10, 10);

        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);
        HBox.setMargin(colorBox1.getRectangle(), insets);
        HBox.setMargin(colorBox2.getRectangle(), insets);
        HBox.setMargin(colorBox3.getRectangle(), insets);

        Label label = new Label("Press Ctrl-Z to undo the last change, Ctrl-Y to redo undoed change and Ctrl-H " +
                "to see history.");
        label.setPadding(insets);

        VBox vBox = new VBox(hBox, checkBox, label);

        checkBox.setOnAction(event -> controller.setIsSelected(checkBox.isSelected()));

        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                System.out.println("Undo key combination pressed");
                controller.undo();
            } else if (event.isControlDown()&& event.getCode() == KeyCode.Y) {
                System.out.println("Redo key combination pressed");
                controller.redo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.H) {
                System.out.println("History window combination pressed");
                openHistoryWindow();

            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    private void openHistoryWindow() {
        Stage historyStage = new Stage();
        historyStage.setTitle("History");

        ListView<String> listView = new ListView<>();

        List<IMemento> history = controller.showHistory();

        for (int i = 0; i < history.size(); i++) {
            IMemento memento = history.get(i);
            listView.getItems().add(i+1 + ": " + memento.getDescription());
        }

        listView.setOnMouseClicked(event -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                controller.restoreFromHistory(selectedIndex);
                historyStage.close();
            }
        });

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(new Label("Select a state to restore:"), listView);

        Scene scene = new Scene(root, 350, 300);
        historyStage.setScene(scene);
        historyStage.show();
    }
}
