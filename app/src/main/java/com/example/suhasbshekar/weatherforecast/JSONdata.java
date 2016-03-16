package com.example.suhasbshekar.weatherforecast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class JSONdata extends AppCompatActivity {

//    private EditText city;
//    private Spinner state;
String jsonString = "";
    String city,states,degree,lat,lon,image;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    Context abc;
    ShareDialog shareDialog;
    String fbDescription = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());//put this line before setcontentview

        setContentView(R.layout.activity_jsondata);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            jsonString = extras.getString("JSON_Object");
            city = extras.getString("city");
            states = extras.getString("states");
            degree = extras.getString("degree");
        }

        try {
//            city = (EditText) findViewById(R.id.city_message);
//            state = (Spinner) findViewById(R.id.stateValue);
            TextView summary = (TextView) findViewById(R.id.summary);
            TextView results = (TextView) findViewById(R.id.results);
            TextView lowhigh = (TextView) findViewById(R.id.lowhigh);
            final ImageView wiconselected = (ImageView) findViewById(R.id.imagep2);
            final JSONObject obj = new JSONObject(jsonString);
//            Intent intent = new Intent(JSONdata.this, moreOptions.class);
//
//            intent.putExtras("jsonObject", jsonString);
            //final JSONArray geodata = obj.getJSONArray("geodata");
//            results.setText(obj.getString("timezone"));
            final JSONObject cur = obj.getJSONObject("currently");
            String timezone = obj.getString("timezone");
            final String summaryjson = cur.getString("summary");
            lat = obj.getString("latitude");
            lon = obj.getString("longitude");
            final String wicon= cur.getString("icon");
            image = "";

            if(wicon.equals("clear-day")){
                wiconselected.setImageResource(R.drawable.clear);
                image = "http://cs-server.usc.edu:45678/hw/hw8/images/clear.png";
            }
            else if(wicon.equals("clear-night")){
                wiconselected.setImageResource(R.drawable.clear_night);
                image = "http://cs-server.usc.edu:45678/hw/hw8/images/clear_night.png";
            }
            else if(wicon.equals("rain")){
                wiconselected.setImageResource(R.drawable.rain);
                image = "http://cs-server.usc.edu:45678/hw/hw8/images/rain.png";
            }
            else if(wicon.equals("snow")){
                wiconselected.setImageResource(R.drawable.snow);
                image = "http://cs-server.usc.edu:45678/hw/hw8/images/snow.png";
            }
            else if(wicon.equals("sleet")){
                wiconselected.setImageResource(R.drawable.sleet);
                image = "http://cs-server.usc.edu:45678/hw/hw8/images/sleet.png";
            }
            else if(wicon.equals("wind")){
                wiconselected.setImageResource(R.drawable.wind);
                image = "http://cs-server.usc.edu:45678/hw/hw8/images/wind.png";
            }
            else if(wicon.equals("fog")){
                wiconselected.setImageResource(R.drawable.fog);
                image = "http://cs-server.usc.edu:45678/hw/hw8/images/fog.png";
            }
            else if(wicon.equals("cloudy")){
                wiconselected.setImageResource(R.drawable.cloudy);
                image = "http://cs-server.usc.edu:45678/hw/hw8/images/cloudy.png";
            }
            else if(wicon.equals("partly-cloudy-day")){
                wiconselected.setImageResource(R.drawable.cloud_day);
                image = "http://cs-server.usc.edu:45678/hw/hw8/images/cloud_day.png";
            }
            else if(wicon.equals("partly-cloudy-night")){
                wiconselected.setImageResource(R.drawable.cloud_night);
                image = "http://cs-server.usc.edu:45678/hw/hw8/images/cloud_night.png";
            }

            String a = (cur.getString("temperature")).substring(0,(cur.getString("temperature")).indexOf("."));
//            int ab = Math.round(Integer.parseInt(a));
//            a = String.valueOf(ab);
            summary.setText(cur.getString("summary"));
            summary.append(" in ");
            summary.append(city);
            summary.append(", ");
            summary.append(states);
//            results.setText(cur.getString("temperature"));
            results.setText(a);
            if (degree.equals("us")){
                results.append("\u2109");
            }
            else {
                results.append("\u2103");
            }
//            JSONArray lhdaily = obj.getJSONArray("daily");
//            JSONObject lh = lhdaily.getJSONObject(0);
            JSONObject lhdaily = obj.getJSONObject("daily");
            JSONArray lhdata = lhdaily.getJSONArray("data");
            JSONObject lh = lhdata.getJSONObject(0);
            lowhigh.setText("L: ");
            lowhigh.append((lh.getString("temperatureMin")).substring(0, (lh.getString("temperatureMin")).indexOf(".")));
            lowhigh.append("\u00B0");
            lowhigh.append(" | ");
            lowhigh.append("H: ");
            lowhigh.append((lh.getString("temperatureMax")).substring(0, (lh.getString("temperatureMax")).indexOf(".")));
            lowhigh.append("\u00B0");
            TextView precip = (TextView) findViewById(R.id.precip);
            double precips = Integer.parseInt(cur.getString("precipIntensity"));
            if (degree.equals("si")) {
                precips=precips* 0.0393701;
            }
            String precipDisplay="";
            if( (0<=precips) && (precips< 0.002))
                precipDisplay="None";
            if( (0.002<=precips) && (precips< 0.017))
                precipDisplay="Very Light";
            if( (0.017<=precips) && (precips< 0.1))
                precipDisplay="Light";
            if( (0.1<=precips) && (precips< 0.4))
                precipDisplay="Moderate";
            if( 0.4<= precips)
                precipDisplay="Heavy";


            precip.setText(precipDisplay);
            TextView cofrain = (TextView) findViewById(R.id.cofrain);
            cofrain.setText(cur.getString("precipProbability"));
            cofrain.append(" %");
            TextView windspeed = (TextView) findViewById(R.id.windspeed);
            windspeed.setText(cur.getString("windSpeed"));
            if (degree.equals("us")) {
                windspeed.append(" mph");
            } else if (degree.equals("si")) {
                windspeed.append(" m/s");
            }
            TextView dewp = (TextView) findViewById(R.id.dewp);
            dewp.setText((cur.getString("dewPoint")).substring(0, (cur.getString("dewPoint")).indexOf(".")));
            if (degree.equals("us")) {
                dewp.append(" \u2109");
            }else if (degree.equals("si")) {
                dewp.append(" \u2103");
            }
            TextView humid = (TextView) findViewById(R.id.humid);
            double abcs = cur.getDouble("humidity");
            double humidper= (abcs)*100;
            humid.setText((Double.toString(humidper)).substring(0, (Double.toString(humidper)).indexOf(".")));
//            humid.setText(cur.getString("humidity"));
            humid.append(" %");
            TextView visibility = (TextView) findViewById(R.id.visibility);
            visibility.setText(cur.getString("visibility"));
            if (degree.equals("us")) {
                visibility.append(" mi");
            }else if (degree.equals("si")) {
                visibility.append(" km");
            }
            TextView sunrise = (TextView) findViewById(R.id.sunrise);
            String sunr = lh.getString("sunriseTime");
            long usec = Long.parseLong(sunr);
            Date date = new Date(usec*1000L);
            SimpleDateFormat sunrises = new SimpleDateFormat("hh:mm a");
            sunrises.setTimeZone(TimeZone.getTimeZone(obj.getString("timezone")));
            String srise = sunrises.format(date);
            sunrise.setText(srise);
//            sunrise.append(" AM");
            TextView sunset = (TextView) findViewById(R.id.sunset);
            String suns = lh.getString("sunsetTime");
            long usecset = Long.parseLong(suns);
            Date dateset = new Date(usecset*1000L);
            SimpleDateFormat sunsets = new SimpleDateFormat("hh:mm a");
            sunsets.setTimeZone(TimeZone.getTimeZone(obj.getString("timezone")));
            String sset = sunrises.format(dateset);
            sunset.setText(sset);

            try{
//                String fbDescription = "";
                if (degree.equals("us")) {
                    fbDescription = summaryjson + ", " + (cur.getString("temperature")).substring(0, (cur.getString("temperature")).indexOf(".")) + "\u2109";
                }
                else if (degree.equals("si")) {
                    fbDescription = summaryjson + ", " + (cur.getString("temperature")).substring(0, (cur.getString("temperature")).indexOf(".")) + "\u2103";
                }
            callbackManager = CallbackManager.Factory.create();
            abc = this;
            findViewById(R.id.fb).setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (ShareDialog.canShow(ShareLinkContent.class)) {

//                        try {



    String fbTitleString = "Current Weather in " + city + ", " + states;

                            shareDialog = new ShareDialog((Activity) abc);
                            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                                    .setContentTitle(fbTitleString)
                                    .setImageUrl(Uri.parse(image))
                                    .setContentDescription(fbDescription)
                                    .setContentUrl(Uri.parse("http://forecast.io"))
                                    .build();


                            shareDialog.show(linkContent);

                            shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
                                @Override
                                public void onSuccess(Sharer.Result result) {
                                    Toast.makeText(getApplicationContext(),"Facebook Post Successful",Toast.LENGTH_LONG).show();
                                }
                                @Override
                                public void onCancel() {
                                    Toast.makeText(getApplicationContext(),"Posted Cancelled",Toast.LENGTH_LONG).show();
                                }
                                @Override
                                public void onError(FacebookException error) {
                                    Toast.makeText(getApplicationContext(),"Error in Posting",Toast.LENGTH_LONG).show();
                                }

                            });
//                        }catch(Exception e){}

//                        Toast.makeText(getApplicationContext(), "Facebook Post Successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Cannot Share",Toast.LENGTH_LONG).show();
                    }



                }


            });
            }catch(Exception e){}

            }
            catch (Exception e) {}
    }

//    public void moreOptions(View view) {
//        // Do something in response to button
//        Intent intent = new Intent(JSONdata.this, moreOptions.class);
//        startActivity(intent);
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    public void moreOptions(View v) {
        // Do something in response to button
        Intent intent = new Intent(JSONdata.this, moreOptions.class);
        intent.putExtra("JSON_Object", jsonString);
        intent.putExtra("city",city);
        intent.putExtra("states",states);
        intent.putExtra("degree",degree);
        startActivity(intent);
    }

    public void MapActivity(View v) {
        Intent intent = new Intent(JSONdata.this, MapActivity.class);
        intent.putExtra("lon", lon);
        intent.putExtra("lat", lat);
//        intent.setClass(JSONdata.this, MapActivity.class);
        startActivity(intent);
    }
}
