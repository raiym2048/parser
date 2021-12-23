package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        String url = "https://www.gismeteo.by/weather-bishkek-5327/10-days/";

        try {
            Document d = Jsoup.connect(url).get();
           /* for(Element row : d.select(""));*/
            System.out.println(d.outerHtml());
        } catch (IOException e) {
            e.printStackTrace();
        }

        launch(args);
    }
}
