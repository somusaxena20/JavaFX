package javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.event.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;


public class checkBoc_radioButton_practice extends Application implements EventHandler<ActionEvent> 
{
    Text t;
    RadioButton r1,r2,r3;
    CheckBox c1,c2,c3;
    ChoiceBox <String>cb;
    HBox hb1,hb2,hb3,hb4;
    VBox vb;
    
    
    
    @Override
    public void start(Stage s)
    {
        t = new Text("SOMU SAXENA");
        t.setStyle("-fx-text-fill:red;-fx-font-size:18px");
        hb1 = new HBox();
        hb1.getChildren().add(t);
        hb1.setSpacing(20);
        hb1.setPadding(new Insets(15,15,15,15));
        
        r1 = new RadioButton("RED");
        
        r2 = new RadioButton("GREEN");
        r3 = new RadioButton("BLUE");
        ToggleGroup tg = new ToggleGroup();
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        r3.setToggleGroup(tg);
        hb2 = new HBox();
        hb2.getChildren().addAll(r1,r2,r3);
        hb2.setSpacing(20);
        hb2.setPadding(new Insets(15,15,15,15));
        
        c1 = new CheckBox("NORMAL");
        c2 = new CheckBox("BOLD");
        c3 = new CheckBox("ITALIC");
        hb3 = new HBox();
        hb3.getChildren().addAll(c1,c2,c3);
        hb3.setSpacing(20);
        hb3.setPadding(new Insets(15,15,15,15));
        
        cb = new ChoiceBox<>();
        cb.getItems().addAll("10","20","30","50");
        cb.setValue("10");
        
        vb = new VBox();
        vb.getChildren().addAll(hb1,hb2,hb3,cb);
        vb.setPadding(new Insets(15,15,15,15));
        
        r1.setOnAction(this);
        r2.setOnAction(this);
        r3.setOnAction(this);
        c1.setOnAction(this);
        c2.setOnAction(this);
        c3.setOnAction(this);
        cb.setOnAction(this);
        
        
        Scene sc = new Scene(vb,600,600);
        s.setScene(sc);
        s.show();
    }
    
    public void handle(ActionEvent e)
    {
        FontWeight fw = FontWeight.NORMAL;
        FontPosture fp = FontPosture.REGULAR;
        if (r1.isSelected()) {
            t.setFill(Paint.valueOf("RED"));
        }
        if (r2.isSelected()) {
            t.setFill(Paint.valueOf("GREEN"));
        }
        if (r3.isSelected()) {
            t.setFill(Paint.valueOf("BLUE"));
        }
        if (c2.isSelected()) {
            fw = FontWeight.BOLD;
        }
        if (c3.isSelected()) {
            fp = FontPosture.ITALIC;
        }
        t.setFont(Font.font("TIMES NEW ROMAN",fw,fp,Integer.valueOf(cb.getValue())));
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
