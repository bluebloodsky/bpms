package com.hust.zl.bpms;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hust.zl.bpms.gson.Forecast;
import com.hust.zl.bpms.gson.Weather;
import com.hust.zl.bpms.util.HttpUtil;
import com.hust.zl.bpms.util.Utility;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {

    public SwipeRefreshLayout swipeRefresh;
    private ScrollView weatherLayout;
    private TextView titleCity;
    private TextView titleUpdateTime;
    private TextView degreeText;
    private TextView weatherInfoText;
    private LinearLayout forecastLayout;
    private TextView aqiText;
    private TextView pm25Text;
    private TextView comfortText;
    private TextView carWashText;
    private TextView sportText;

    private ImageView bingPicImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            );
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_weather);
        weatherLayout = (ScrollView) findViewById(R.id.weather_layout);
        titleCity = (TextView) findViewById(R.id.title_city);
        titleUpdateTime = (TextView) findViewById(R.id.title_update_time);
        degreeText = (TextView) findViewById(R.id.degree_text);
        weatherInfoText = (TextView) findViewById(R.id.weather_info_text);
        forecastLayout = (LinearLayout) findViewById(R.id.forecast_layout);
        aqiText = (TextView) findViewById(R.id.aqi_text);
        pm25Text = (TextView) findViewById(R.id.pm25_text);
        comfortText = (TextView) findViewById(R.id.comfort_text);
        carWashText = (TextView) findViewById(R.id.car_wash_text);
        sportText = (TextView) findViewById(R.id.sport_text);

        bingPicImg = (ImageView) findViewById(R.id.bing_pic_img);

        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString = prefs.getString("weather", null);
        final String weatherId;
        if (weatherString != null) {
            Weather weather = Utility.handleWeatherResponse(weatherString);
            weatherId = weather.basic.weatherId;
            showWeatherInfo(weather);
        } else {
            weatherId = getIntent().getStringExtra("weather_id");
            weatherLayout.setVisibility(View.INVISIBLE);
            requestWeather(weatherId);
        }

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestWeather(weatherId);
            }
        });
        String bingPic = prefs.getString("bing_pic", null);
        if (bingPic != null) {
            Glide.with(this).load(bingPic).into(bingPicImg);
        } else {
            loadBingPic();
        }
    }

    public void requestWeather(final String weatherId) {
        String weatherUrl = "http://guolin.tech/api/weather?cityid=" + weatherId
                + "&key=bc0418b57b2d4918819d3974ac1285d9";
        HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(WeatherActivity.this, "获取天气信息失败"
                                , Toast.LENGTH_SHORT).show();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                String responseText = response.body().string();

                final String responseText = "{\"HeWeather\": [{\"basic\":{\"cid\":\"CN101200101\",\"location\":\"武汉\",\"parent_city\":\"武汉\",\"admin_area\":\"湖北\",\"cnty\":\"中国\",\"lat\":\"30.5843544\",\"lon\":\"114.29856873\",\"tz\":\"+8.00\",\"city\":\"武汉\",\"id\":\"CN101200101\",\"update\":{\"loc\":\"2018-07-31 19:48\",\"utc\":\"2018-07-31 11:48\"}},\"update\":{\"loc\":\"2018-07-31 19:48\",\"utc\":\"2018-07-31 11:48\"},\"status\":\"ok\",\"now\":{\"cloud\":\"0\",\"cond_code\":\"101\",\"cond_txt\":\"多云\",\"fl\":\"33\",\"hum\":\"91\",\"pcpn\":\"0.0\",\"pres\":\"1002\",\"tmp\":\"28\",\"vis\":\"10\",\"wind_deg\":\"55\",\"wind_dir\":\"东北风\",\"wind_sc\":\"1\",\"wind_spd\":\"4\",\"cond\":{\"code\":\"101\",\"txt\":\"多云\"}},\"daily_forecast\":[{\"date\":\"2018-07-31\",\"cond\":{\"txt_d\":\"小雨\"},\"tmp\":{\"max\":\"37\",\"min\":\"26\"}},{\"date\":\"2018-08-01\",\"cond\":{\"txt_d\":\"小雨\"},\"tmp\":{\"max\":\"35\",\"min\":\"26\"}},{\"date\":\"2018-08-02\",\"cond\":{\"txt_d\":\"小雨\"},\"tmp\":{\"max\":\"35\",\"min\":\"26\"}},{\"date\":\"2018-08-03\",\"cond\":{\"txt_d\":\"小雨\"},\"tmp\":{\"max\":\"35\",\"min\":\"26\"}},{\"date\":\"2018-08-04\",\"cond\":{\"txt_d\":\"小雨\"},\"tmp\":{\"max\":\"32\",\"min\":\"26\"}},{\"date\":\"2018-08-05\",\"cond\":{\"txt_d\":\"小雨\"},\"tmp\":{\"max\":\"34\",\"min\":\"26\"}},{\"date\":\"2018-08-06\",\"cond\":{\"txt_d\":\"小雨\"},\"tmp\":{\"max\":\"35\",\"min\":\"26\"}}],\"hourly\":[{\"cloud\":\"32\",\"cond_code\":\"101\",\"cond_txt\":\"多云\",\"dew\":\"27\",\"hum\":\"82\",\"pop\":\"20\",\"pres\":\"1000\",\"time\":\"2018-07-31 22:00\",\"tmp\":\"29\",\"wind_deg\":\"83\",\"wind_dir\":\"东风\",\"wind_sc\":\"1-2\",\"wind_spd\":\"3\"},{\"cloud\":\"7\",\"cond_code\":\"100\",\"cond_txt\":\"晴\",\"dew\":\"26\",\"hum\":\"92\",\"pop\":\"6\",\"pres\":\"1000\",\"time\":\"2018-08-01 01:00\",\"tmp\":\"26\",\"wind_deg\":\"93\",\"wind_dir\":\"东风\",\"wind_sc\":\"1-2\",\"wind_spd\":\"11\"},{\"cloud\":\"5\",\"cond_code\":\"101\",\"cond_txt\":\"多云\",\"dew\":\"26\",\"hum\":\"94\",\"pop\":\"7\",\"pres\":\"1000\",\"time\":\"2018-08-01 04:00\",\"tmp\":\"28\",\"wind_deg\":\"91\",\"wind_dir\":\"东风\",\"wind_sc\":\"1-2\",\"wind_spd\":\"2\"},{\"cloud\":\"76\",\"cond_code\":\"101\",\"cond_txt\":\"多云\",\"dew\":\"26\",\"hum\":\"89\",\"pop\":\"7\",\"pres\":\"1001\",\"time\":\"2018-08-01 07:00\",\"tmp\":\"30\",\"wind_deg\":\"87\",\"wind_dir\":\"东风\",\"wind_sc\":\"1-2\",\"wind_spd\":\"5\"},{\"cloud\":\"76\",\"cond_code\":\"305\",\"cond_txt\":\"小雨\",\"dew\":\"25\",\"hum\":\"80\",\"pop\":\"7\",\"pres\":\"1001\",\"time\":\"2018-08-01 10:00\",\"tmp\":\"31\",\"wind_deg\":\"140\",\"wind_dir\":\"东南风\",\"wind_sc\":\"1-2\",\"wind_spd\":\"2\"},{\"cloud\":\"76\",\"cond_code\":\"101\",\"cond_txt\":\"多云\",\"dew\":\"27\",\"hum\":\"79\",\"pop\":\"60\",\"pres\":\"1000\",\"time\":\"2018-08-01 13:00\",\"tmp\":\"34\",\"wind_deg\":\"169\",\"wind_dir\":\"东南风\",\"wind_sc\":\"1-2\",\"wind_spd\":\"4\"},{\"cloud\":\"93\",\"cond_code\":\"305\",\"cond_txt\":\"小雨\",\"dew\":\"26\",\"hum\":\"76\",\"pop\":\"49\",\"pres\":\"999\",\"time\":\"2018-08-01 16:00\",\"tmp\":\"34\",\"wind_deg\":\"119\",\"wind_dir\":\"东南风\",\"wind_sc\":\"1-2\",\"wind_spd\":\"1\"},{\"cloud\":\"95\",\"cond_code\":\"101\",\"cond_txt\":\"多云\",\"dew\":\"27\",\"hum\":\"72\",\"pop\":\"19\",\"pres\":\"999\",\"time\":\"2018-08-01 19:00\",\"tmp\":\"30\",\"wind_deg\":\"115\",\"wind_dir\":\"东南风\",\"wind_sc\":\"1-2\",\"wind_spd\":\"6\"}],\"aqi\":{\"city\":{\"aqi\":\"49\",\"pm25\":\"25\",\"qlty\":\"优\"}},\"suggestion\":{\"comf\":{\"type\":\"comf\",\"brf\":\"较不舒适\",\"txt\":\"今天夜间天气较热，虽然有雨，但仍然无法削弱较高气温给人们带来的暑意，这种天气会让您感到不很舒适。\"},\"sport\":{\"type\":\"sport\",\"brf\":\"较不宜\",\"txt\":\"有降水，推荐您在室内进行低强度运动；若坚持户外运动，须注意携带雨具。\"},\"cw\":{\"type\":\"cw\",\"brf\":\"不宜\",\"txt\":\"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。\"}}}]}";
                final Weather weather = Utility.handleWeatherResponse(responseText);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (weather != null && "ok".equals(weather.status)) {
                            SharedPreferences.Editor editor = PreferenceManager.
                                    getDefaultSharedPreferences(WeatherActivity.this).edit();
                            editor.putString("weather", responseText);
                            editor.apply();
                            showWeatherInfo(weather);
                        } else {
                            Toast.makeText(WeatherActivity.this, "获取天气信息失败"
                                    , Toast.LENGTH_SHORT).show();
                        }
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        });

        loadBingPic();
    }

    private void showWeatherInfo(Weather weather) {
        String cityName = weather.basic.cityName;
        String updateTime = weather.basic.update.updateTime.split(" ")[1];
        String degree = weather.now.temperature + "℃";
        String weatherInfo = weather.now.more.info;
        titleCity.setText(cityName);
        titleUpdateTime.setText(updateTime);
        degreeText.setText(degree);
        weatherInfoText.setText(weatherInfo);
        forecastLayout.removeAllViews();
        for (Forecast forecast : weather.forecastList) {
            View view = LayoutInflater.from(this).inflate(R.layout.forecast_item, forecastLayout, false);
            TextView dateText = (TextView) view.findViewById(R.id.date_text);
            TextView infoText = (TextView) view.findViewById(R.id.info_text);
            TextView maxText = (TextView) view.findViewById(R.id.max_text);
            TextView minText = (TextView) view.findViewById(R.id.min_text);
            dateText.setText(forecast.date);
            infoText.setText(forecast.more.info);
            maxText.setText(forecast.temperature.max);
            minText.setText(forecast.temperature.min);
            forecastLayout.addView(view);
        }
        if (weather.aqi != null) {
            aqiText.setText(weather.aqi.city.aqi);
            pm25Text.setText(weather.aqi.city.pm25);
        }

        String comfort = "舒适度：" + weather.suggestion.comfort.info;
        String carWash = "洗车指数：" + weather.suggestion.carWash.info;
        String sport = "运动建议：" + weather.suggestion.sport.info;
        comfortText.setText(comfort);
        carWashText.setText(carWash);
        sportText.setText(sport);
        weatherLayout.setVisibility(View.VISIBLE);
    }

    private void loadBingPic() {
        String requestBingPic = "http://guolin.tech/api/bing_pic";
        HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String bingPic = response.body().string();
                SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                editor.putString("bing_pic", bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(WeatherActivity.this).load(bingPic).into(bingPicImg);
                    }
                });
            }
        });
    }
}
