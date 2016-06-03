package com.vjs3.retrofit20usage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.vjs3.retrofit20usage.Model.MainModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.vjs3.retrofit20usage.RestApi.AppID;
import static com.vjs3.retrofit20usage.RestApi.city;

public class MainActivity extends AppCompatActivity {

    String url = "http://api.openweathermap.org";
    TextView txt_city, txt_status, txt_humidity, txt_pressure, txt_wind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_city = (TextView) findViewById(R.id.txt_city);
        txt_status = (TextView) findViewById(R.id.txt_status);
        txt_humidity = (TextView) findViewById(R.id.txt_humidity);
        txt_pressure = (TextView) findViewById(R.id.txt_press);
        txt_wind = (TextView) findViewById(R.id.txt_windspeed);


        getReport();
    }

    public void getReport(){
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    RestApi service = retrofit.create(RestApi.class);

    Call<MainModel> call = service.getWeatherReport(city,AppID);

    call.enqueue(new Callback<MainModel>() {

        @Override
        public void onResponse(Call<MainModel> call, Response<MainModel> response) {

            try {
                String city = response.body().getName();

                String status = response.body().getWeather().get(0).getDescription();

                String humidity = response.body().getMain().getHumidity().toString();

                String pressure = response.body().getMain().getPressure().toString();

                String wind = response.body().getWind().getSpeed().toString();

                txt_city.setText("city  :  " + city);
                txt_status.setText("status  :  " + status);
                txt_humidity.setText("humidity  : " + humidity);
                txt_pressure.setText("pressure  :  " + pressure);
              txt_wind.setText("windspeed : " + wind);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onFailure(Call<MainModel> call, Throwable t) {
        }


    });
}
}
