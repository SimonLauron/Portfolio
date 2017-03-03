package fr.imerir.portfolio_meteoapp.Models;

import org.json.JSONObject;

/**
 * Created by student on 24/02/2017.
 */

public class Weather {

    double time;
    String summary;
    String icon;
    double precipIntensity;         // mm/h
    double precipProbability;       // %
    String precipType;
    double temperature;             // °C
    double apparentTemperature;     // °C
    double dewPoint;                // °C
    double humidity;                // %
    double windSpeed;               // m/s
    double windBearing;             // orientation du vent en ° par rapport au NORD
    double visibility;              // km
    double cloudCover;              // %
    double pressure;                // hP
    double ozone;

    public Weather(JSONObject jsonObject) {
        this.time = jsonObject.optDouble("time");
        this.summary = jsonObject.optString("summary");
        this.icon = jsonObject.optString("icon");
        this.precipIntensity = jsonObject.optDouble("precipIntensity");
        this.precipProbability = jsonObject.optDouble("precipProbability");
        this.precipType = jsonObject.optString("precipType");
        this.temperature = jsonObject.optDouble("temperature");
        this.apparentTemperature = jsonObject.optDouble("apparentTemperature");
        this.dewPoint = jsonObject.optDouble("dewPoint");
        this.humidity = jsonObject.optDouble("humidity");
        this.windSpeed = jsonObject.optDouble("windSpeed");
        this.windBearing = jsonObject.optDouble("windBearing");
        this.visibility = jsonObject.optDouble("visibility");
        this.cloudCover = jsonObject.optDouble("cloudCover");
        this.pressure = jsonObject.optDouble("pressure");
        this.ozone = jsonObject.optDouble("ozone");
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(double windBearing) {
        this.windBearing = windBearing;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getOzone() {
        return ozone;
    }

    public void setOzone(double ozone) {
        this.ozone = ozone;
    }
}
