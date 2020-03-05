//Author: Azeem Syed Hussaini: 100707191
//Date: March 5th 2020

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DisplayCards extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));

        int random = 0;
        String string1 = "";
        String card = "";

        //a loop to add a random card to pane
        for (int i = 0; i < 3; i++) {
            random = (int) (Math.random() * 64 + 1);
            string1 = Integer.toString(random);
            card = "/Cards/" + string1 + ".png";
            Image image = new Image(card);
            ImageView imageView1 = new ImageView(image);
            pane.getChildren().add(imageView1);
        }


        //Display Scene
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("DisplayCards");
        primaryStage.show();



    }
}
