package javafx;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;

public class textArea_slider_practice extends Application {
    public int count = 0;
    public void start(Stage s)
    {
        TextArea ts = new TextArea();
//        ts.setMaxWidth(550);
        ts.setPrefSize(550, 400);
        ts.setStyle("-fx-background-color:grey;");
        ScrollPane sp = new ScrollPane(ts);
       
        Slider sl = new Slider(10,50,10);
        sl.setShowTickLabels(true);
        sl.setShowTickMarks(true);
        sl.setMajorTickUnit(5);
        
//        sl.setOnMouseClicked(e->ts.setFont(Font.font(sl.getValue())));
        sl.valueProperty().addListener(e->ts.setFont(Font.font(sl.getValue())));
        
        DatePicker dp = new DatePicker();
         
        
        dp.setOnAction(e->{
            if(!ts.getText().isEmpty())
            {
                if (count == 0 ) {
                   count++;
                   ts.setText("DATE : "+dp.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+"\n"+ts.getText());
                }
                else
                {
                    
                    ts.setText("DATE : "+dp.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+"\n"+ts.getText().substring(18));
                }
            }
                else{
                Alert a = new Alert(AlertType.ERROR,"PLEASE SLECT FILE");
                
                
                a.show();
            }
        });
        
        FileChooser fc = new FileChooser();
        fc.setTitle("OPEN FILE");
        Button b = new Button("OPEN FILE");
        
        b.setOnAction(e->{
            File file = fc.showOpenDialog(s);
            
            try(Scanner sc = new Scanner(file))
            {
                String str = "";
               while(sc.hasNext())
                   str = str+sc.nextLine()+"\n";
               ts.setText(str);
            }
            catch(Exception ex)
            {}
            
            
            
        });
        
        ColorPicker cp = new ColorPicker();
        
        cp.setOnAction(e->{
            ts.setStyle("-fx-text-fill:#"+cp.getValue().toString().substring(2,8));
        });
        
        Label l1 = new Label("CHOOSE DATE");
        Label l2 = new Label("CHOOSE COLOR");
        
        
        VBox vb = new VBox();
        vb.getChildren().addAll(ts,sl,l1,dp,l2,cp,b);
        vb.setSpacing(10);
        vb.setAlignment(Pos.TOP_CENTER);
        Scene sc = new Scene(vb,600,600);
        s.setScene(sc);
        s.setTitle("NOTE PAD");
//        s.setFullScreen(true);
        s.show();
               
    }
    
    
    public static void main(String[] args) {
        launch(args);
    }
}
