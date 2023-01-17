 package javafx;

 import javafx.stage.Stage;
 import javafx.scene.Scene;
 import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
 import javafx.scene.control.Button;
 import javafx.scene.layout.FlowPane;
 

public class diffrent_ways_implements_eventHandler extends Application {
    Button b;
    int c = 0;
    public void start(Stage s)
    {
        b = new Button("CLICK ME");
        b.setPrefSize(100, 30);
        b.setOnAction(e->{b.setText(""+(++c));});
        FlowPane f = new FlowPane();
        f.getChildren().add(b);
        Scene sc = new Scene(f,500,500);
        s.setScene(sc);
        s.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
