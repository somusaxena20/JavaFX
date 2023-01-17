package javafx;

import javafx.scene.web.WebEngine;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Camera;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class layout_pane extends Application  {
    @Override
    public void start(Stage s)throws Exception
    {
        ImageView iv1,iv2,iv3;
        
        iv1 = new ImageView(new Image(new FileInputStream("C:\\Users\\HOME\\Downloads\\google.gif")));
        
       
        
        Tab t1 = new Tab("GOOGLE",iv1);
        
        TabPane bp = new TabPane(); 
        bp.getTabs().add(t1);
         
        Scene sc= new Scene(bp,600,600);
       
       
        sc.setFill(Color.web("#81c483"));
        s.setScene(sc);
        s.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
