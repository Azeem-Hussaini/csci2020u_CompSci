import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.control.Button;

public class Histogram extends Application{
    public void start(Stage stage) throws Exception{
        TextField txt = new TextField("test.txt");
        txt.setTranslateX(80);
        txt.setTranslateY(230);

        Label lbl = new Label("FileName");
        lbl.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(0.5))));
        lbl.setTranslateX(20);
        lbl.setTranslateY(230);


        Button btView = new Button("View");
        btView.setTranslateX(250);
        btView.setTranslateY(230);
        GridPane.setHalignment(btView, HPos.LEFT);

        btView.setOnAction(e ->
                {
                    java.io.File file = new java.io.File(txt.getText());

                    boolean done = false;
                    while (!done) {
                    try{
                    Scanner input = new Scanner(file);
                    int[] arr = new int[26];

                    while (input.hasNext()){
                        String word = input.next();
                        char char1 = ' ';
                        int num = 0;
                        for (int j = 0; j < word.length(); j++){
                            char1 = word.charAt(j);
                            char1 = Character.toLowerCase(char1);
                            num = (int)char1 - 97;
                            int num2 = (int)char1;
                            if (num2 >= 97 && num2 <= 122)
                                arr[num] = arr[num] + 1;
                        }

                    }

                    input.close();

                    stage.setTitle("Histogram");
                    Rectangle[] rec1 = new Rectangle[26];
                    Label[] labels = new Label[26];


                    for(int i = 0; i < 26; i++) {
                        int num2 = i + 65;
                        String string1 = Character.toString((char) num2);
                        labels[i] = new Label(string1);
                        labels[i].setTranslateY(205);
                        labels[i].setTranslateX(20 + i*15);
                    }

                    for (int i = 0; i < 26; i++){
                        rec1[i] = new Rectangle();
                        rec1[i].setX(20 + i*15);
                        rec1[i].setWidth(10);
                        rec1[i].setStroke(Color.BLACK);
                        rec1[i].setY(200 - arr[i]);
                        rec1[i].setHeight(arr[i]);
                        rec1[i].setFill(Color.WHITE);

                    }


                    Group group = new Group(rec1[0], rec1[1], rec1[2], rec1[3], rec1[4], rec1[5], rec1[6], rec1[7],
                            rec1[8], rec1[9], rec1[10], rec1[11], rec1[12], rec1[13], rec1[14], rec1[15],
                            rec1[16], rec1[17], rec1[18], rec1[19], rec1[20], rec1[21], rec1[22], rec1[23],
                            rec1[24], rec1[25],
                            labels[0], labels[1], labels[2], labels[3],labels[4], labels[5], labels[6], labels[7],
                            labels[8], labels[9], labels[10], labels[11],labels[12], labels[13], labels[14], labels[15],
                            labels[16], labels[17], labels[18], labels[19],labels[20], labels[21], labels[22], labels[23],
                            labels[24], labels[25], btView, txt, lbl);

                    Scene scene = new Scene(group, 500, 300);

                    stage.setScene(scene);


                    stage.show();

                    done = true;
                    } catch (FileNotFoundException f) {
                        System.out.println("FILE NOT FOUND");
                        done = true;
                    }
                    }

                }
        );

        Group group = new Group(btView, txt, lbl);

        Scene scene = new Scene(group, 500, 300);

        stage.setScene(scene);


        stage.show();


    }


    }