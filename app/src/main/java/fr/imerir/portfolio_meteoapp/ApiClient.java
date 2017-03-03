package fr.imerir.portfolio_meteoapp;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import fr.imerir.portfolio_meteoapp.Models.Weather;

/**
 * Created by student on 23/02/2017.
 */

public class ApiClient {

    private static ApiClient instance;

    Context context;
    RequestQueue queue;

    private  static void createInstance(Context context) {
        instance = new ApiClient(context);
    }

    public static ApiClient getInstance(Context context){
        if(instance == null)
            createInstance(context);
        else
            instance.context = context;

        return instance;
    }

    private ApiClient(Context context) {
        this.context = context;
        queue = Volley.newRequestQueue(context);
        queue.start();
    }

    public void getWeather(final OnWeatherReceivedListener listener){

        String apiKey = context.getString(R.string.DarkSkyKey);
        String url = "https://api.darksky.net/forecast/"+ apiKey +"/42.698611,2.895556?exclude=minutely,hourly,daily,alerts,flags&lang=fr&units=si";

        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject responseJSON = response.getJSONObject("currently");
                    Weather weather = new Weather(responseJSON);
                    listener.onWeatherReceived(weather);
                }catch (JSONException e){
                    e.printStackTrace();
                    listener.onWeatherError("BAM");
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }

    public interface OnWeatherReceivedListener {
        void onWeatherReceived(Weather weather);
        void onWeatherError(String errorMessage);
    }
}

