package game;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Game extends Application{
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Group players = new Group();
        Rectangle player = new Rectangle(100, 460, 40, 40);
        players.getChildren().add(player);

        Rectangle reticle = new Rectangle(118, 440, 5, 20);
        reticle.setFill(Color.GREEN);
        players.getChildren().add(reticle);

        Group root = new Group();
        root.getChildren().add(players);
        Scene scene = new Scene(root, 600, 500);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            String lastKeyPressed = "";
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.RIGHT) {
                    player.setLayoutX(player.getLayoutX() + 5);
                    reticle.setLayoutX(reticle.getLayoutX() + 5);
                }
                if(ke.getCode() == KeyCode.LEFT){
                    player.setLayoutX(player.getLayoutX() - 5);
                    reticle.setLayoutX(reticle.getLayoutX() - 5);
                }
                if(ke.getCode() == KeyCode.UP){
                    player.setLayoutY(player.getLayoutY() - 5);
                    reticle.setLayoutY(reticle.getLayoutY() - 5);
                }
                if(ke.getCode() == KeyCode.A && !(lastKeyPressed.equals("A"))){
                    reticle.setRotate(0);
                    reticle.setRotate(90);
                    reticle.setLayoutY(reticle.getLayoutY() + 30);
                    reticle.setLayoutX(reticle.getLayoutX() - 30);
                    lastKeyPressed = "A";
                }
                if(ke.getCode() == KeyCode.S && !(lastKeyPressed.equals("S"))){
                    reticle.setRotate(0);
                    reticle.setLayoutY(reticle.getLayoutY() + 60);
                    lastKeyPressed = "S";
                }
            }
        });  
        stage.setTitle("Loading an image");  
        stage.setScene(scene);
        scene.setFill(Color.WHITE);
        stage.show(); 
        
    }
    
    
}
