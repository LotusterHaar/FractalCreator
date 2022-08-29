package todu.projects.fractalcreator;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FractalController implements Initializable {
    @FXML
    private Slider slider;

    @FXML
    private BorderPane borderPane;
    private int orderValue;
    private FractalPane pane;

    public FractalController(int orderValue) {
        this.orderValue = orderValue;
        this.pane = new FractalPane();
        this.pane.setStyle("-fx-background-color:  linear-gradient(#4568DC, #B06AB3);");
    }

    @FXML
    protected void onSliderChanged(){
        int orderValue = (int)slider.getValue();
        this.setOrderValue(orderValue);
        this.pane.paint(orderValue);
    }

    protected void setFractalPane(int width, int height){
        this.pane.setDimensions(width, height);
    }

    protected void setOrderValue(int orderValue){
        this.orderValue = orderValue;
    }

    public FractalPane getPane(){
        return this.pane;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        slider.setValue(this.orderValue);
    }
}