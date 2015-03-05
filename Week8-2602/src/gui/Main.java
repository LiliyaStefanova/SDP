package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by liliya on 26/02/2015.
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("hello world");
        //primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        
        Button btn = new Button();
        btn.setText("Hello");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                btn.setText("Goodbye");
            }
        });
        StackPane pane = new StackPane();
        pane.getChildren().add(btn);

        primaryStage.setScene(new Scene(pane, 500, 500));
    }
    
    public static void main(String [] arg){
        
        
    }
}
