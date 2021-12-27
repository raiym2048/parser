package sample;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class noGame {

    @FXML
    private ResourceBundle resources;
    /*@FXML
    private Rectangle bullet;*/

    @FXML
    private URL location;

    @FXML
    private ImageView enemy1;

    @FXML
    private ImageView enemy2;

    @FXML
    private ImageView enemy3;

    @FXML
    private ImageView enemy4;

    @FXML
    private ImageView enemy5;

    @FXML
    private Button me;

    @FXML
    private ImageView player;

    @FXML
    void show(KeyEvent event) {
        switch (event.getCode()){
            case A:Left();break;
            case D:Right();break;
            case ENTER:Bullet();break;
        }
    }

    private void Right() {
        System.out.println("Right");



        int x = (int) player.getTranslateX();
        player.setTranslateX(x+15);
    }

    private void Bullet() {
        System.out.println("Bullet");
        Rectangle bullet = new Rectangle();
        bullet.setBounds(500, 10, 20, 20);

        /*Rectangle bullet2 = bullet;
        bullet2.setBounds(bullet.x, (int) Y,bullet.width,bullet.height);*/



        //Sprite s = new Sprite((int) who.getTranslateX() + 20, (int) who.getTranslateY(), 5, 20, who.type + "bullet", Color.BLACK);

    }

    private void Left() {
        System.out.println("Left");
        int x = (int) player.getTranslateX();
        player.setTranslateX(x-15);
    }

    @FXML
    void initialize() {

    }

}
