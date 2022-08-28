package todu.projects.fractalcreator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class FractalApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //URL fxmlLocation = FractalApplication.class.getResource("/hello-view.fxml");
       // FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
        FractalPane pane = new FractalPane();
       // Pane mainPane = fxmlLoader.load();

        TextField tfOrder = new TextField();
        tfOrder.setOnAction(
        e -> pane.setOrder(Integer.parseInt(tfOrder.getText())));
        tfOrder.setPrefColumnCount(4);
        tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

        //Pane to hold label, text field, and a button
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 320, 240);
        stage.setTitle("The Fractal Creator");
        stage.setScene(scene);
        stage.show();

        pane.widthProperty().addListener(ov -> pane.paint());
        pane.heightProperty().addListener(ov -> pane.paint());
    }
}
