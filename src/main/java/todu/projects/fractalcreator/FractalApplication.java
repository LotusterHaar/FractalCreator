package todu.projects.fractalcreator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class FractalApplication extends Application {
    int order = 6;

    @Override
    public void start(Stage stage) throws IOException {

        URL fxmlLocation = FractalApplication.class.getResource("/fractal-view.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);

        FractalController fc = new FractalController(order);
        fxmlLoader.setController(fc);
        FractalPane pane = fc.getPane();
        BorderPane mainPane = fxmlLoader.load();
        System.out.println("changed");
        fc.setFractalPane((int) mainPane.getWidth(), (int) mainPane.getHeight());
        mainPane.setCenter(pane);

        Scene scene = new Scene(mainPane, mainPane.getWidth(), mainPane.getHeight());
        stage.setTitle("The Fractal Creator");
        stage.setScene(scene);
        stage.show();

        pane.widthProperty().addListener(ov -> pane.paint(order));
        pane.heightProperty().addListener(ov -> pane.paint(order));



    }
}
