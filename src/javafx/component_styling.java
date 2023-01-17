package javafx;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;


public class component_styling extends Application
{
    @Override
    public void start(Stage s)
    {
        Button b = new Button("CLICK ME");
        b.setTooltip(new Tooltip("CLICK THIS BUTTON"));
        b.setDefaultButton(true);
     
        TextField tf = new TextField();
        
        FlowPane fp = new FlowPane();
        fp.getChildren().add(b);
        fp.getChildren().add(tf);
        
        
        
        Alert a = new Alert(AlertType.ERROR,"CLICK HERE IF YOU ARE NOT A ROBOT");
        a.setHeaderText("CONFORMATION BOX");
        a.setTitle("CONFIRM YOUR CHOISE");
        
        b.setOnAction(e->a.show());
        Scene sc = new Scene(fp,500,500);
        s.setScene(sc);
        s.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
