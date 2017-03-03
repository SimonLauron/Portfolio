package fr.imerir.portfolio_meteoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.imerir.portfolio_meteoapp.Models.Weather;

public class MainActivity extends AppCompatActivity implements ApiClient.OnWeatherReceivedListener, View.OnClickListener {

    TextView city;
    TextView temperature;
    TextView apparent_temperature;
    TextView cloud_cover;
    TextView precip_intensity;
    TextView wind_speed;
    Button buttonRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = (TextView) findViewById(R.id.city);
        temperature = (TextView) findViewById(R.id.temperature);
        apparent_temperature = (TextView) findViewById(R.id.apparent_temperature);
        cloud_cover = (TextView) findViewById(R.id.cloud_cover);
        precip_intensity = (TextView) findViewById(R.id.precip_intensity);
        wind_speed = (TextView) findViewById(R.id.wind_speed);

        buttonRefresh = (Button) findViewById(R.id.button_refresh);

        city.setText("Perpignan");

        ApiClient api = ApiClient.getInstance(this);
        api.getWeather(this);

        buttonRefresh.setOnClickListener(this);
    }

    @Override
    public void onWeatherReceived(Weather weather) {
        this.temperature.setText(String.valueOf(weather.getTemperature())+"°C");
        this.apparent_temperature.setText(String.valueOf(weather.getApparentTemperature())+"°C");
        this.cloud_cover.setText(String.valueOf(weather.getCloudCover())+"%");
        this.precip_intensity.setText(String.valueOf(weather.getPrecipIntensity())+" mm/h");
        this.wind_speed.setText(String.valueOf(weather.getWindSpeed())+" m/s");
    }

    @Override
    public void onWeatherError(String errorMessage) {
        //TODO
    }

    @Override
    public void onClick(View view) {
        ApiClient api = ApiClient.getInstance(this);
        api.getWeather(this);
    }
}
