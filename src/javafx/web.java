
package javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;




public class web extends Application {
    
    public void start(Stage s)
    {
//        Button w = new Button("GOOGLE");
         final WebView w = new WebView();
        final WebEngine we = w.getEngine();
        we.load("https://google.com");
        
        
        
        
        Scene sc = new Scene(w,600,600);
        s.setScene(sc);
        s.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
