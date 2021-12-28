package sample;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

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
    void show(KeyEvent event) throws IOException {
        switch (event.getCode()){
            case A:Left();break;
            case D:Right();break;
            case ENTER:Bullet();break;
            case X:back();break;
        }
    }

    private void back() throws IOException {

            player.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("sample.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
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
    private Stage stage; //x go back
    private Scene scene;
    private Parent root;
    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
