package todu.projects.fractalcreator;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class FractalPane extends Pane {

    FractalPane() {
    }

    public void setDimensions(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public void paint(int order){
        System.out.println(getWidth());
        // Select three points in proportion to the panel size
        Point2D p1 = new Point2D(getWidth() / 2, 10);
        Point2D p2 = new Point2D(10, getHeight() - 10);
        Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
        this.getChildren().clear(); // Clear the pane before redisplay
        displayTriangles(order, p1, p2, p3);

    }

    private void displayTriangles(int order, Point2D p1, Point2D p2, Point2D p3) {
        // Draw a triangle to connect the three points
        if (order == 0) {
            Polygon triangle = new Polygon();
            triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
            triangle.setStroke(Color.BLACK);
            triangle.setFill(Color.WHITE);
            this.getChildren().add(triangle);
        } else {
            Point2D p12 = p1.midpoint(p2);
            Point2D p23 = p2.midpoint(p3);
            Point2D p31 = p3.midpoint(p1);
            // Recursively display three triangles
            displayTriangles(order - 1, p1, p12, p31);
            displayTriangles(order - 1, p12, p2, p23);
            displayTriangles(order - 1, p31, p23, p3);
        }

    }

}

