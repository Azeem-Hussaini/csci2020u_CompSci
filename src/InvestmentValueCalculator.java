//Author: Azeem Syed Hussaini: 100707191
//Date: March 5th 2020

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.DatePicker;
import java.text.DecimalFormat;

public class InvestmentValueCalculator extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.TOP_RIGHT);
        pane.setPadding(new Insets(10,10,10,10));

        //create textfields for inputs
        TextField investmentAmount = new TextField();
        investmentAmount.setAlignment(Pos.TOP_RIGHT);
        TextField years = new TextField();
        years.setAlignment(Pos.TOP_RIGHT);
        TextField annualInterestRate = new TextField();
        annualInterestRate.setAlignment(Pos.TOP_RIGHT);
        TextField futureValue = new TextField();
        futureValue.setAlignment(Pos.TOP_RIGHT);
        //make last textfield uneditable since it is only an output
        futureValue.setEditable(false);

        //add textfields to pane
        pane.add(new Label("Investment Amount: "),0,0);
        pane.add(investmentAmount, 1,0);
        pane.add(new Label("Years: "), 0 , 1);
        pane.add(years, 1 ,1);
        pane.add(new Label("Annual Interest Rate: "),0,2);
        pane.add(annualInterestRate, 1,2);
        pane.add(new Label("Future Value: "),0,3);
        pane.add(futureValue, 1,3);

        //create a button to calculate
        Button btCalc = new Button("Calculate");
        pane.add(btCalc, 1,6);
        GridPane.setHalignment(btCalc, HPos.LEFT);

        btCalc.setOnAction(e ->
                {


                   double investment = Double.parseDouble(investmentAmount.getText());
                   double years1 = Double.parseDouble(years.getText());
                   double interest = Double.parseDouble(annualInterestRate.getText());

                   //equation for Future Value
                   double num = investment * Math.pow(1 + (interest/12/100), years1 * 12);
                   num = Math.round(num*100.0)/100.0;
                   futureValue.setText(Double.toString(num));

                }
        );

        //display scene
        Scene scene = new Scene(pane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("InvestmentCalculator");
        primaryStage.show();
    }
}