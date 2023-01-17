

package javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

class customer implements Serializable
{
    private int cusId;
    private String name;
    private String add;
    
    public customer(){}
    
    public customer(int c,String s,String a)
    {
        this.add = a;
        this.name = s;
        this.cusId = c;
        
    }
    
    public int getId(){return cusId;}
    public String getAdd(){return add;}
    public String getName(){return name;}
}

public class comboBox_listBox extends Application{
    int count = 1;
    customer cs;
    HashMap <Integer,customer> hm = new HashMap<>();
    @Override
    public void start(Stage stage) throws Exception {
    
     Font f = new Font("TIMES NEW ROMAN",20);
        
     Label l1 = new Label("CUSTOMER ID ");
     l1.setFont(f);
     Label l2 = new Label("NAME ");
     l2.setFont(f);
     Label l3 = new Label("ADDRESS");
     l3.setFont(f);
     
     ComboBox<Integer> cust = new ComboBox<>();
     TextField name = new TextField();
     cust.setValue(count);
     name.setTooltip(new Tooltip("ENTER YOUR NAME"));
     TextField add = new TextField();
     add.setTooltip(new Tooltip("ENTER YOUR ADDRESS"));
     
     name.setFont(f);
     add.setFont(f);
     name.setPrefColumnCount(15);
     add.setPrefColumnCount(20);
    
     Button create = new Button("CREATE");
     Button save = new Button("SAVE");
     save.setDefaultButton(true);
     create.setOnAction(e->{
         cust.getItems().add(++count);
         cust.setValue(count);
         name.setText("");
         add.setText("");
     });
     
     save.setOnAction(e->{
         cs = new customer(cust.getValue(),name.getText(),add.getText());
         hm.put(cs.getId(), cs);
         try(PrintStream ps = new PrintStream(new FileOutputStream("Customer.txt")))
         {
            for(customer ct : hm.values())
            {
                ps.println(ct.getId());
                ps.println(ct.getName());
                ps.println(ct.getAdd());
            }
            cust.getItems().add(++count);
         cust.setValue(count);
         name.setText("");
         add.setText("");
         Alert at = new Alert(AlertType.INFORMATION,"INFORMATION IS SAVED");
         at.show();
            
         }catch(Exception ex){}
     });
     
     create.setFont(f);
     save.setFont(f);
     
     HBox hb1 = new HBox();
     HBox hb2 = new HBox();
     HBox hb3 = new HBox();
     HBox hb4 = new HBox();
     
     hb1.getChildren().addAll(l1,cust);
     hb1.setAlignment(Pos.CENTER);
     hb1.setSpacing(5);
     hb2.getChildren().addAll(l2,name);
     hb2.setSpacing(5);
     hb2.setAlignment(Pos.CENTER);
     hb3.getChildren().addAll(l3,add);
     hb3.setSpacing(5);
     hb3.setAlignment(Pos.CENTER);
     hb4.getChildren().addAll(create,save);
     hb4.setSpacing(5);
     hb4.setAlignment(Pos.CENTER);
    
     VBox vb = new VBox();
     vb.setSpacing(10);
     vb.setAlignment(Pos.CENTER);
     vb.getChildren().addAll(hb1,hb2,hb3,hb4);
    
     cust.valueProperty().addListener(e->{
         int c = cust.getValue();
         customer c1 = hm.get(c);
         name.setText(c1.getName());
         add.setText(c1.getAdd());
     });
     
//     try
//         {
//            FileInputStream fis = new FileInputStream("Customer.txt");
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            
//            cs = (customer)ois.readObject();
//            
//            hm.put(cs.getId(),cs);
//             if (cs.getId()>count) {
//                 count = cs.getId();
//             }
//             cust.getItems().add(cs.getId());
//             
//            
//            ois.close();
//            fis.close();
//         }
//         catch(Exception ex)
//         {}
     
//     cust.valueProperty().addListener(e->{
//         cs = hm.get(cust.getValue());
//         name.setText(cs.getName());
//         add.setText(cs.getAdd());
//     });
     
    try(Scanner scan = new Scanner(new FileInputStream("Customer.txt")))
         {
             int c;
             String n;
             String a;
             while(scan.hasNext())
             {
                 c = scan.nextInt();
                 n = scan.next();
                 a = scan.next();
                 hm.put(c, new customer(c,n,a));
                 if (c>count) {
                     count = c;
                 }
                 cust.getItems().add(c);
             }
            
         }catch(Exception ex){}

     Scene sc = new Scene(vb,600,600);
    
     stage.setScene(sc);
     stage.show();
    
    
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    
}
