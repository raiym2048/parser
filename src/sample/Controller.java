package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.json.JSONObject;

public class Controller {

    @FXML
    private TextField city;

    @FXML
    private Text simple_text;

    @FXML
    private Button start_weather;

    @FXML
    private Text temp_info;


    public void initialize() {
        start_weather.setOnAction(event -> {
            String getUserCity = city.getText().trim();
if (!getUserCity.equals("")) {
                String output = getUrlContent("https://api.openweathermap.org/data/2.5/weather?q=" + getUserCity + "&appid=f51990e7149906aa689774767bf390da&unit=metric");
                if (!output.isEmpty()) {
                    JSONObject obj = new JSONObject(output);
                    double res = Math.floor(obj.getJSONObject("main").getDouble("temp")-273.15f);
                    temp_info.setText("Temperature is : " + res + "°C");
                    System.out.println(res);
                }
            }


        });

    }
    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("такого города нет");
        }
        return content.toString();
    }

}
