
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.input.MouseButton;

public class DraggingPoint extends Application {
    @Override
    public void start(Stage primaryStage) {

        Circle circle = new Circle(200, 200, 100);

        Line[] sides = new Line[3];
        Text[] angles = new Text[3];
        Circle[] points = new Circle[3];

        for (int i = 0; i < 3; i++) {

            double random = Math.random() * 2 * Math.PI;
            double xCord = circle.getCenterX() + 100 * Math.cos(random);
            double yCord = circle.getCenterY() + 100 * Math.sin(random);

            Circle point = new Circle(100 / 15);
            point.setFill(Color.RED);
            point.setStroke(Color.BLACK);
            point.setCenterX(xCord);
            point.setCenterY(yCord);

            point.setOnMouseDragged(e -> {
                if (e.getButton().equals(MouseButton.PRIMARY)) {
                    double angle = Math.atan2(e.getY() - circle.getCenterY(), e.getX() - circle.getCenterX());
                    Circle circle1 = (Circle)e.getSource();

                    circle1.setCenterX(circle.getCenterX() + 100 * Math.cos(angle));
                    circle1.setCenterY(circle.getCenterY() + 100 * Math.sin(angle));

                    for(int j = 0; j < 3; j++) {
                        Line side1 = sides[(j+1) % 3];
                        double startX1 = side1.getStartX();
                        double startY1 = side1.getStartY();
                        double endX1 = side1.getEndX();
                        double endY1 = side1.getEndY();
                        double line1 = Math.sqrt(Math.pow(startX1 - endX1, 2) + Math.pow(startY1 - endY1, 2));

                        Line side2 = sides[(j+2) % 3];
                        double startX2 = side2.getStartX();
                        double startY2 = side2.getStartY();
                        double endX2 = side2.getEndX();
                        double endY2 = side2.getEndY();
                        double line2 = Math.sqrt(Math.pow(startX2 - endX2, 2) + Math.pow(startY2 - endY2, 2));

                        Line side3 = sides[(j+3) % 3];
                        double startX3 = side3.getStartX();
                        double startY3 = side3.getStartY();
                        double endX3 = side3.getEndX();
                        double endY3 = side3.getEndY();
                        double line3 = Math.sqrt(Math.pow(startX3 - endX3, 2) + Math.pow(startY3 - endY3, 2));

                        angle = Math.toDegrees(Math.acos((line1 * line1 - line2 * line2 - line3 * line3) / (-2 * line2 * line3)));

                        angle = Math.round(angle*100.0)/100.0;
                        angles[j].setText(Double.toString(angle));
                    }
                }

            });
            points[i] = point;
    }

        for (int i = 0; i < 3; i++) {
            int num = 0;

            if (i == 2){
                num = 0;
            }
            else{
                num = i + 1;
            }

            Line line = new Line();
            Text text = new Text();

            line.startXProperty().bind(points[i].centerXProperty());
            line.startYProperty().bind(points[i].centerYProperty());
            line.endXProperty().bind(points[num].centerXProperty());
            line.endYProperty().bind(points[num].centerYProperty());
            text.xProperty().bind(points[i].centerXProperty());
            text.yProperty().bind(points[i].centerYProperty().subtract(100 / 20));

            sides[i] = line;
            angles[i] = text;

        }


        Pane pane = new Pane();

        pane.getChildren().add(circle);
        pane.getChildren().addAll(points[0], points[1], points[2], sides[0], sides[1], sides[2], angles[0], angles[1], angles[2]);

        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("DraggingPoint");
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}