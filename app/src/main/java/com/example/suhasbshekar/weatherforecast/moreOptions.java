package com.example.suhasbshekar.weatherforecast;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class moreOptions extends AppCompatActivity {

    private ViewSwitcher viewSwitcher;
    private ViewSwitcher viewSwitcherplus;
    private View myFirstView;
    private TableLayout plusLay;
    private View myFirstViewplus;
    private View mySecondView;
    private View mySecondViewplus;
    private Button next7;
    private Button next24;
    private Button hr242btn;
    String city,states,degree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_options);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Bundle extras = getIntent().getExtras();
        String jsonString = "";
        if (extras != null) {
            jsonString = extras.getString("JSON_Object");
            city = extras.getString("city");
            states = extras.getString("states");
            degree = extras.getString("degree");
        }
        try {
//            JSONObject jsonObj = new JSONObject(getIntent().getStringExtra("Array"));
//            city = (EditText) findViewById(R.id.city_message);
//            state = (Spinner) findViewById(R.id.stateValue);
            TextView summary = (TextView) findViewById(R.id.summary);

            final JSONObject obj = new JSONObject(jsonString);
//            JSONObject cur = obj.getJSONObject("currently");
            summary.append(city);
            summary.append(", ");
            summary.append(states);
//            summary.setText("abcdkjfskjdkjkjsdjk");

            TextView tempForC = (TextView) findViewById(R.id.tab1temp);
            if (degree.equals("us")) {
                tempForC.append("\u2109");
            }else if (degree.equals("si")) {
                tempForC.append("\u2103");
            }
            tempForC.append(")");
            JSONObject lhdaily = obj.getJSONObject("hourly");
            JSONArray lhdata = lhdaily.getJSONArray("data");
            for (int i=0;i<48;i++) {
                String idtab11 = "hr"+i+"1";
                String idtab12 = "hr"+i+"1";
                String idtab13 = "hr"+i+"1";
                JSONObject lh = lhdata.getJSONObject(i);
                TextView time = (TextView) findViewById(R.id.hr11);
                ImageView wiconselected = (ImageView) findViewById(R.id.hr12);
                TextView temp = (TextView) findViewById(R.id.hr13);
                if (idtab11.equals("hr01")){
                    time = (TextView) findViewById(R.id.hr01);
                    wiconselected = (ImageView) findViewById(R.id.hr02);
                    temp = (TextView) findViewById(R.id.hr03);
                }
                else if (idtab11.equals("hr11")){
                     time = (TextView) findViewById(R.id.hr11);
                     wiconselected = (ImageView) findViewById(R.id.hr12);
                     temp = (TextView) findViewById(R.id.hr13);
                }
                else if (idtab11.equals("hr21")){
                    time = (TextView) findViewById(R.id.hr21);
                    wiconselected = (ImageView) findViewById(R.id.hr22);
                    temp = (TextView) findViewById(R.id.hr23);
                }
                else if (idtab11.equals("hr31")){
                    time = (TextView) findViewById(R.id.hr31);
                    wiconselected = (ImageView) findViewById(R.id.hr32);
                    temp = (TextView) findViewById(R.id.hr33);
                }
                else if (idtab11.equals("hr41")){
                    time = (TextView) findViewById(R.id.hr41);
                    wiconselected = (ImageView) findViewById(R.id.hr42);
                    temp = (TextView) findViewById(R.id.hr43);
                }
                else if (idtab11.equals("hr51")){
                    time = (TextView) findViewById(R.id.hr51);
                    wiconselected = (ImageView) findViewById(R.id.hr52);
                    temp = (TextView) findViewById(R.id.hr53);
                }
                else if (idtab11.equals("hr61")){
                    time = (TextView) findViewById(R.id.hr61);
                    wiconselected = (ImageView) findViewById(R.id.hr62);
                    temp = (TextView) findViewById(R.id.hr63);
                }
                else if (idtab11.equals("hr71")){
                    time = (TextView) findViewById(R.id.hr71);
                    wiconselected = (ImageView) findViewById(R.id.hr72);
                    temp = (TextView) findViewById(R.id.hr73);
                }
                else if (idtab11.equals("hr81")){
                    time = (TextView) findViewById(R.id.hr81);
                    wiconselected = (ImageView) findViewById(R.id.hr82);
                    temp = (TextView) findViewById(R.id.hr83);
                }
                else if (idtab11.equals("hr91")){
                    time = (TextView) findViewById(R.id.hr91);
                    wiconselected = (ImageView) findViewById(R.id.hr92);
                    temp = (TextView) findViewById(R.id.hr93);
                }
                else if (idtab11.equals("hr101")){
                    time = (TextView) findViewById(R.id.hr101);
                    wiconselected = (ImageView) findViewById(R.id.hr102);
                    temp = (TextView) findViewById(R.id.hr103);
                }
                else if (idtab11.equals("hr111")){
                    time = (TextView) findViewById(R.id.hr111);
                    wiconselected = (ImageView) findViewById(R.id.hr112);
                    temp = (TextView) findViewById(R.id.hr113);
                }
                else if (idtab11.equals("hr121")){
                    time = (TextView) findViewById(R.id.hr121);
                    wiconselected = (ImageView) findViewById(R.id.hr122);
                    temp = (TextView) findViewById(R.id.hr123);
                }
                else if (idtab11.equals("hr131")){
                    time = (TextView) findViewById(R.id.hr131);
                    wiconselected = (ImageView) findViewById(R.id.hr132);
                    temp = (TextView) findViewById(R.id.hr133);
                }
                else if (idtab11.equals("hr141")){
                    time = (TextView) findViewById(R.id.hr141);
                    wiconselected = (ImageView) findViewById(R.id.hr142);
                    temp = (TextView) findViewById(R.id.hr143);
                }
                else if (idtab11.equals("hr151")){
                    time = (TextView) findViewById(R.id.hr151);
                    wiconselected = (ImageView) findViewById(R.id.hr152);
                    temp = (TextView) findViewById(R.id.hr153);
                }
                else if (idtab11.equals("hr161")){
                    time = (TextView) findViewById(R.id.hr161);
                    wiconselected = (ImageView) findViewById(R.id.hr162);
                    temp = (TextView) findViewById(R.id.hr163);
                }
                else if (idtab11.equals("hr171")){
                    time = (TextView) findViewById(R.id.hr171);
                    wiconselected = (ImageView) findViewById(R.id.hr172);
                    temp = (TextView) findViewById(R.id.hr173);
                }
                else if (idtab11.equals("hr181")){
                    time = (TextView) findViewById(R.id.hr181);
                    wiconselected = (ImageView) findViewById(R.id.hr182);
                    temp = (TextView) findViewById(R.id.hr183);
                }
                else if (idtab11.equals("hr191")){
                    time = (TextView) findViewById(R.id.hr191);
                    wiconselected = (ImageView) findViewById(R.id.hr192);
                    temp = (TextView) findViewById(R.id.hr193);
                }
                else if (idtab11.equals("hr201")){
                    time = (TextView) findViewById(R.id.hr201);
                    wiconselected = (ImageView) findViewById(R.id.hr202);
                    temp = (TextView) findViewById(R.id.hr203);
                }
                else if (idtab11.equals("hr211")){
                    time = (TextView) findViewById(R.id.hr211);
                    wiconselected = (ImageView) findViewById(R.id.hr212);
                    temp = (TextView) findViewById(R.id.hr213);
                }
                else if (idtab11.equals("hr221")){
                    time = (TextView) findViewById(R.id.hr221);
                    wiconselected = (ImageView) findViewById(R.id.hr222);
                    temp = (TextView) findViewById(R.id.hr223);
                }
                else if (idtab11.equals("hr231")){
                    time = (TextView) findViewById(R.id.hr231);
                    wiconselected = (ImageView) findViewById(R.id.hr232);
                    temp = (TextView) findViewById(R.id.hr233);
                }
                else if (idtab11.equals("hr241")){
                    time = (TextView) findViewById(R.id.hr241);
                    wiconselected = (ImageView) findViewById(R.id.hr242);
                    temp = (TextView) findViewById(R.id.hr243);
                }
                else if (idtab11.equals("hr251")){
                    time = (TextView) findViewById(R.id.hr251);
                    wiconselected = (ImageView) findViewById(R.id.hr252);
                    temp = (TextView) findViewById(R.id.hr253);
                }
                else if (idtab11.equals("hr261")){
                    time = (TextView) findViewById(R.id.hr261);
                    wiconselected = (ImageView) findViewById(R.id.hr262);
                    temp = (TextView) findViewById(R.id.hr263);
                }
                else if (idtab11.equals("hr271")){
                    time = (TextView) findViewById(R.id.hr271);
                    wiconselected = (ImageView) findViewById(R.id.hr272);
                    temp = (TextView) findViewById(R.id.hr273);
                }
                else if (idtab11.equals("hr281")){
                    time = (TextView) findViewById(R.id.hr281);
                    wiconselected = (ImageView) findViewById(R.id.hr282);
                    temp = (TextView) findViewById(R.id.hr283);
                }
                else if (idtab11.equals("hr291")){
                    time = (TextView) findViewById(R.id.hr291);
                    wiconselected = (ImageView) findViewById(R.id.hr292);
                    temp = (TextView) findViewById(R.id.hr293);
                }
                else if (idtab11.equals("hr301")){
                    time = (TextView) findViewById(R.id.hr301);
                    wiconselected = (ImageView) findViewById(R.id.hr302);
                    temp = (TextView) findViewById(R.id.hr303);
                }
                else if (idtab11.equals("hr311")){
                    time = (TextView) findViewById(R.id.hr311);
                    wiconselected = (ImageView) findViewById(R.id.hr312);
                    temp = (TextView) findViewById(R.id.hr313);
                }
                else if (idtab11.equals("hr321")){
                    time = (TextView) findViewById(R.id.hr311);
                    wiconselected = (ImageView) findViewById(R.id.hr322);
                    temp = (TextView) findViewById(R.id.hr323);
                }
                else if (idtab11.equals("hr331")){
                    time = (TextView) findViewById(R.id.hr331);
                    wiconselected = (ImageView) findViewById(R.id.hr332);
                    temp = (TextView) findViewById(R.id.hr333);
                }
                else if (idtab11.equals("hr341")){
                    time = (TextView) findViewById(R.id.hr341);
                    wiconselected = (ImageView) findViewById(R.id.hr342);
                    temp = (TextView) findViewById(R.id.hr343);
                }
                else if (idtab11.equals("hr351")){
                    time = (TextView) findViewById(R.id.hr351);
                    wiconselected = (ImageView) findViewById(R.id.hr352);
                    temp = (TextView) findViewById(R.id.hr353);
                }
                else if (idtab11.equals("hr361")){
                    time = (TextView) findViewById(R.id.hr361);
                    wiconselected = (ImageView) findViewById(R.id.hr362);
                    temp = (TextView) findViewById(R.id.hr363);
                }
                else if (idtab11.equals("hr371")){
                    time = (TextView) findViewById(R.id.hr371);
                    wiconselected = (ImageView) findViewById(R.id.hr372);
                    temp = (TextView) findViewById(R.id.hr373);
                }
                else if (idtab11.equals("hr381")){
                    time = (TextView) findViewById(R.id.hr381);
                    wiconselected = (ImageView) findViewById(R.id.hr382);
                    temp = (TextView) findViewById(R.id.hr383);
                }
                else if (idtab11.equals("hr391")){
                    time = (TextView) findViewById(R.id.hr391);
                    wiconselected = (ImageView) findViewById(R.id.hr392);
                    temp = (TextView) findViewById(R.id.hr393);
                }
                else if (idtab11.equals("hr401")){
                    time = (TextView) findViewById(R.id.hr401);
                    wiconselected = (ImageView) findViewById(R.id.hr402);
                    temp = (TextView) findViewById(R.id.hr403);
                }
                else if (idtab11.equals("hr411")){
                    time = (TextView) findViewById(R.id.hr411);
                    wiconselected = (ImageView) findViewById(R.id.hr412);
                    temp = (TextView) findViewById(R.id.hr413);
                }
                else if (idtab11.equals("hr421")){
                    time = (TextView) findViewById(R.id.hr421);
                    wiconselected = (ImageView) findViewById(R.id.hr422);
                    temp = (TextView) findViewById(R.id.hr423);
                }
                else if (idtab11.equals("hr431")){
                    time = (TextView) findViewById(R.id.hr431);
                    wiconselected = (ImageView) findViewById(R.id.hr432);
                    temp = (TextView) findViewById(R.id.hr433);
                }
                else if (idtab11.equals("hr441")){
                    time = (TextView) findViewById(R.id.hr441);
                    wiconselected = (ImageView) findViewById(R.id.hr442);
                    temp = (TextView) findViewById(R.id.hr443);
                }
                else if (idtab11.equals("hr451")){
                    time = (TextView) findViewById(R.id.hr451);
                    wiconselected = (ImageView) findViewById(R.id.hr452);
                    temp = (TextView) findViewById(R.id.hr453);
                }
                else if (idtab11.equals("hr461")){
                    time = (TextView) findViewById(R.id.hr461);
                    wiconselected = (ImageView) findViewById(R.id.hr462);
                    temp = (TextView) findViewById(R.id.hr463);
                }
                else if (idtab11.equals("hr471")){
                    time = (TextView) findViewById(R.id.hr471);
                    wiconselected = (ImageView) findViewById(R.id.hr472);
                    temp = (TextView) findViewById(R.id.hr473);
                }




                String sunr = lh.getString("time");
                long usec = Long.parseLong(sunr);
                Date date = new Date(usec * 1000L);
                SimpleDateFormat sunrises = new SimpleDateFormat("hh:mm a");
                sunrises.setTimeZone(TimeZone.getTimeZone(obj.getString("timezone")));
                String srise = sunrises.format(date);
                time.setText(srise);

                String wicon = lh.getString("icon");

                if (wicon.equals("clear-day")) {
                    wiconselected.setImageResource(R.drawable.clear);
                } else if (wicon.equals("clear-night")) {
                    wiconselected.setImageResource(R.drawable.clear_night);
                } else if (wicon.equals("rain")) {
                    wiconselected.setImageResource(R.drawable.rain);
                } else if (wicon.equals("snow")) {
                    wiconselected.setImageResource(R.drawable.snow);
                } else if (wicon.equals("sleet")) {
                    wiconselected.setImageResource(R.drawable.sleet);
                } else if (wicon.equals("wind")) {
                    wiconselected.setImageResource(R.drawable.wind);
                } else if (wicon.equals("fog")) {
                    wiconselected.setImageResource(R.drawable.fog);
                } else if (wicon.equals("cloudy")) {
                    wiconselected.setImageResource(R.drawable.cloudy);
                } else if (wicon.equals("partly-cloudy-day")) {
                    wiconselected.setImageResource(R.drawable.cloud_day);
                } else if (wicon.equals("partly-cloudy-night")) {
                    wiconselected.setImageResource(R.drawable.cloud_night);
                }


                double temp24 = lh.getDouble("temperature");
                int temp24i= (int) temp24;
                temp.setText(Integer.toString(temp24i));

            }




            JSONObject daily = obj.getJSONObject("daily");
            JSONArray data = daily.getJSONArray("data");

            for (int i=1;i<8;i++) {
                int j=i-1;
                String idtab21 = "tab2"+j+"1";
                JSONObject dailyData = data.getJSONObject(i);
                String sunr = dailyData.getString("time");
                long usec = Long.parseLong(sunr);
                Date date = new Date(usec * 1000L);
                SimpleDateFormat sunrises = new SimpleDateFormat("EEEE");
                sunrises.setTimeZone(TimeZone.getTimeZone(obj.getString("timezone")));
                String srise = sunrises.format(date);
                TextView dailyTime = (TextView) findViewById(R.id.tab201);
                ImageView wiconselected = (ImageView) findViewById(R.id.tab202);
                TextView tempminmax = (TextView) findViewById(R.id.tab203);
                if (idtab21.equals("tab201")){
                    dailyTime = (TextView) findViewById(R.id.tab201);
                    wiconselected = (ImageView) findViewById(R.id.tab202);
                    tempminmax = (TextView) findViewById(R.id.tab203);
                }
                else if (idtab21.equals("tab211")){
                    dailyTime = (TextView) findViewById(R.id.tab211);
                    wiconselected = (ImageView) findViewById(R.id.tab212);
                    tempminmax = (TextView) findViewById(R.id.tab213);
                }
                else if (idtab21.equals("tab221")){
                    dailyTime = (TextView) findViewById(R.id.tab221);
                    wiconselected = (ImageView) findViewById(R.id.tab222);
                    tempminmax = (TextView) findViewById(R.id.tab223);
                }
                else if (idtab21.equals("tab231")){
                    dailyTime = (TextView) findViewById(R.id.tab231);
                    wiconselected = (ImageView) findViewById(R.id.tab232);
                    tempminmax = (TextView) findViewById(R.id.tab233);
                }
                else if (idtab21.equals("tab241")){
                    dailyTime = (TextView) findViewById(R.id.tab241);
                    wiconselected = (ImageView) findViewById(R.id.tab242);
                    tempminmax = (TextView) findViewById(R.id.tab243);
                }
                else if (idtab21.equals("tab251")){
                    dailyTime = (TextView) findViewById(R.id.tab251);
                    wiconselected = (ImageView) findViewById(R.id.tab252);
                    tempminmax = (TextView) findViewById(R.id.tab253);
                }
                else if (idtab21.equals("tab261")){
                    dailyTime = (TextView) findViewById(R.id.tab261);
                    wiconselected = (ImageView) findViewById(R.id.tab262);
                    tempminmax = (TextView) findViewById(R.id.tab263);
                }
                dailyTime.setText(srise);
                dailyTime.append(", ");
                sunrises = new SimpleDateFormat("MMM dd");
                sunrises.setTimeZone(TimeZone.getTimeZone(obj.getString("timezone")));
                srise = sunrises.format(date);
                dailyTime.append(srise);


                String wicon = dailyData.getString("icon");


                if (wicon.equals("clear-day")) {
                    wiconselected.setImageResource(R.drawable.clear);
                } else if (wicon.equals("clear-night")) {
                    wiconselected.setImageResource(R.drawable.clear_night);
                } else if (wicon.equals("rain")) {
                    wiconselected.setImageResource(R.drawable.rain);
                } else if (wicon.equals("snow")) {
                    wiconselected.setImageResource(R.drawable.snow);
                } else if (wicon.equals("sleet")) {
                    wiconselected.setImageResource(R.drawable.sleet);
                } else if (wicon.equals("wind")) {
                    wiconselected.setImageResource(R.drawable.wind);
                } else if (wicon.equals("fog")) {
                    wiconselected.setImageResource(R.drawable.fog);
                } else if (wicon.equals("cloudy")) {
                    wiconselected.setImageResource(R.drawable.cloudy);
                } else if (wicon.equals("partly-cloudy-day")) {
                    wiconselected.setImageResource(R.drawable.cloud_day);
                } else if (wicon.equals("partly-cloudy-night")) {
                    wiconselected.setImageResource(R.drawable.cloud_night);
                }



                double temp7 = dailyData.getDouble("temperatureMin");
                int temp7min= (int) temp7;
                tempminmax.append(Integer.toString(temp7min));
                if (degree.equals("us")) {
                    tempminmax.append("\u2109");
                }else if (degree.equals("si")) {
                    tempminmax.append("\u2103");
                }
                tempminmax.append(" | Max: ");
                double temp7m = dailyData.getDouble("temperatureMax");
                int temp7max= (int) temp7m;
                tempminmax.append(Integer.toString(temp7max));
                if (degree.equals("us")) {
                    tempminmax.append("\u2109");
                }else if (degree.equals("si")) {
                    tempminmax.append("\u2103");
                }

            }

            viewSwitcher =   (ViewSwitcher)findViewById(R.id.viewswitcher);
            myFirstView= findViewById(R.id.next24display);
            mySecondView = findViewById(R.id.next7display);
            next7 = (Button) findViewById(R.id.next7);
            next7.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    if (viewSwitcher.getCurrentView() != mySecondView) {

                        viewSwitcher.showNext();
//                        mySecondView.setBackgroundResource(getDrawable(R.drawable.next24hours));
//                        next7.setBackgroundColor(Color.BLUE);
                        next24.setBackground(getDrawable(R.drawable.next7hour));
                        next7.setBackground(getDrawable(R.drawable.next24hours));
                        RelativeLayout pluslayout = (RelativeLayout)findViewById(R.id.next24display);
                        pluslayout.getLayoutParams().height= 2500;
                        pluslayout.invalidate();

                    } else if (viewSwitcher.getCurrentView() != myFirstView) {

                        viewSwitcher.showPrevious();
                    }
                }
            });
            next24 = (Button) findViewById(R.id.next24);
            next24.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    if (viewSwitcher.getCurrentView() != myFirstView) {

                        viewSwitcher.showPrevious();
                        next24.setBackground(getDrawable(R.drawable.next24hours));
                        next7.setBackground(getDrawable(R.drawable.next7hour));
                        View b = findViewById(R.id.hr242btn);
                        if(b.getVisibility()==View.GONE){
                            RelativeLayout pluslayout = (RelativeLayout) findViewById(R.id.next24display);
                            pluslayout.getLayoutParams().height = 8600;
                            pluslayout.invalidate();
                        }
                        else{
                            RelativeLayout pluslayout = (RelativeLayout) findViewById(R.id.next24display);
                            pluslayout.getLayoutParams().height = 4900;
                            pluslayout.invalidate();
                        }

                    } else if (viewSwitcher.getCurrentView() != mySecondView) {

                        viewSwitcher.showNext();
                    }
                }
            });

            viewSwitcherplus =   (ViewSwitcher)findViewById(R.id.viewswitcherplus);
            myFirstViewplus= findViewById(R.id.next24displayplus);
            mySecondViewplus = findViewById(R.id.next24displayplusd);
            hr242btn = (Button) findViewById(R.id.hr242btn);
            hr242btn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    if (viewSwitcherplus.getCurrentView() != myFirstViewplus) {

                        viewSwitcherplus.showPrevious();
                    } else if (viewSwitcherplus.getCurrentView() != mySecondViewplus) {

                        viewSwitcherplus.showNext();
                        View b = findViewById(R.id.hr242btn);
                        b.setVisibility(View.GONE);
                        b = findViewById(R.id.hr241btn);
                        b.setVisibility(View.GONE);
                        b = findViewById(R.id.hr243btn);
                        b.setVisibility(View.GONE);

//                        plusLay= (TableLayout) findViewById(R.id.next24displaylay);
//                        plusLay.setLayoutParams(new TableLayout.LayoutParams.WRAP_CONTENT);
                        RelativeLayout pluslayout = (RelativeLayout)findViewById(R.id.next24display);
//                        RelativeLayout.LayoutParams params= new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
//                        pluslayout.setLayoutParams(params);
                        pluslayout.getLayoutParams().height= 8600;
                        pluslayout.invalidate();

                    }
                }
            });
        }
        catch (Exception e) {}
    }

}
