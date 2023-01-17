

package javafx;

import java.awt.FlowLayout;
import javafx.application.Application;

import javafx.stage.Stage;
import java.sql.*;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;


public class student_management extends Application {
    TextField tf;
    public void start(Stage s)throws Exception
    {
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:C://sqlite//univ.db");
        PreparedStatement p = con.prepareStatement("select * from students");
        
        ResultSet rs = p.executeQuery();
        
        tf = new TextField();
           tf.setText("NOTHING IS HERE");
        while(rs.next())
        {
            tf.setText(String.valueOf(rs.getInt("rollNo")));
            tf.setText(String.valueOf(rs.getInt("rollNo")));
            
        }
        
        ComboBox<String> cb = new ComboBox<>();
        cb.setValue("ROLL NO.");
        cb.valueProperty().addListener(e->
        {
          tf.setText(cb.getValue());
        });
           FlowPane f = new FlowPane();
           f.getChildren().addAll(tf,cb);
         
           
        Scene sc = new Scene(f,200,200);
        s.setScene(sc);
        s.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
