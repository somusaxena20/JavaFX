package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

public class fiirstApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        Button b = new Button("CLICK ME");
        TextField tf = new TextField();
        FlowPane fp = new FlowPane();
     
        fp.getChildren().add(tf);
        fp.getChildren().add(b);
        
        
        
        Scene s = new Scene(fp);
        stage.setScene(s);
        stage.show();

        stage.setHeight(600);
        stage.setWidth(600);
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    
}
