package com.example.suhasbshekar.weatherforecast;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    private EditText streetAddress;
    private EditText city;
    private Spinner state;
    private RadioGroup radioButton;
    private RadioButton radioFar;
    private String states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);

        streetAddress = (EditText) findViewById(R.id.street_message);
        city = (EditText) findViewById(R.id.city_message);
        state = (Spinner) findViewById(R.id.stateValue);
        radioButton = (RadioGroup) findViewById(R.id.radioGroup);
        radioFar = (RadioButton) findViewById(R.id.us);
        final TextView errorText = (TextView)findViewById(R.id.errorText);


        findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

//                final String stAddress = streetAdress.getText().toString().length();
                if (streetAddress.getText().length()==0) {
                    errorText.setText("Please enter a street");
                    errorText.setTextColor(Color.parseColor("#FF0000"));
                }

                if (streetAddress.getText().length()!=0) {
                    if (city.getText().length() == 0) {
                        errorText.setText("Please enter a city");
                        errorText.setTextColor(Color.parseColor("#FF0000"));
                    }
                }
                if (streetAddress.getText().length()!=0 && city.getText().length() != 0) {
                    if (state.getSelectedItem().toString().trim().equals("Select a State")) {
                        errorText.setText("Please select a state");
                        errorText.setTextColor(Color.parseColor("#FF0000"));
                    }
                }



                if (streetAddress.getText().length()!=0) {
                    if (city.getText().length() != 0) {
                        if (!state.getSelectedItem().toString().trim().equals("Select a State")) {

                            errorText.setText("");
                            class GetForecastData extends AsyncTask<Void, Void, String> {

                                final EditText streetAddress = (EditText) findViewById(R.id.street_message);
                                final EditText city = (EditText) findViewById(R.id.city_message);
                                final Spinner state = (Spinner) findViewById(R.id.stateValue);
                                String street = streetAddress.getText().toString();
                                String citytext = city.getText().toString();
                                String states = state.getSelectedItem().toString();
                                final RadioGroup radGroup = (RadioGroup) findViewById(R.id.radioGroup);
                                //                    int selectedId = radGroup.getCheckedRadioButtonId();
                                final RadioButton radButton = (RadioButton) findViewById(radGroup.getCheckedRadioButtonId());

                                String degree = "";
                                String jsonString = "";

                                @Override
                                protected String doInBackground(Void... params) {

                                    try {


                                        if (radButton.getText().toString().equals("Fahrenheit")) {
                                            degree = "us";
                                        } else {
                                            degree = "si";
                                        }
                                        String queryString = "&address=" + URLEncoder.encode(street, "UTF-8") + "&city=" + URLEncoder.encode(citytext, "UTF-8") + "&state=" + states + "&degree=" + degree;
                                        //String queryString_encode = URLEncoder.encode(queryString,"UTF-8");
                                        URL url = new URL("http://cs-server.usc.edu:28658/index.php?" + queryString);
                                        URLConnection conn = url.openConnection();

                                        HttpURLConnection httpConn = (HttpURLConnection) conn;
                                        httpConn.setAllowUserInteraction(false);
                                        httpConn.setInstanceFollowRedirects(true);
                                        httpConn.setRequestMethod("GET");

                                        httpConn.connect();

                                        InputStream is = httpConn.getInputStream();
                                        jsonString = convertinputStreamToString(is);
                                        if (jsonString.equals("")){
                                            cancel(true);
                                            errorText.setText("Please enter a valid address");
                                            errorText.setTextColor(Color.parseColor("#FF0000"));
                                            errorText.invalidate();
                                        }

//                                        if (isCancelled()){
////                                            TextView errorText = (TextView) findViewById(R.id.errorText);
//                                            errorText.setText("Please enter a valid address");
//                                            errorText.setTextColor(Color.parseColor("#FF0000"));
//
//                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }



                                    return jsonString;
                                }

                                private String convertinputStreamToString(InputStream ists)
                                        throws IOException {
                                    if (ists != null) {
                                        StringBuilder sb = new StringBuilder();
                                        String line;

                                        try {
                                            BufferedReader r1 = new BufferedReader(new InputStreamReader(
                                                    ists, "UTF-8"));
                                            while ((line = r1.readLine()) != null) {
                                                sb.append(line).append("\n");
                                            }
                                        } finally {
                                            ists.close();
                                        }
                                        return sb.toString();
                                    } else {
                                        return "";
                                    }
                                }

                                @Override
                                protected void onPostExecute(String jsonString) {

//                        try {
//                            Intent intent = new Intent(MainActivity.this, moreOptions.class);
//                            intent.putExtra("JSON_Object", jsonString);
//                            startActivity(intent);
//                        } catch (Exception e) {
//                        }
                                    try {
                                        Intent intent = new Intent(MainActivity.this, JSONdata.class);
                                        intent.putExtra("JSON_Object", jsonString);
                                        intent.putExtra("city", citytext);
                                        intent.putExtra("states", states);
                                        intent.putExtra("degree", degree);
                                        startActivity(intent);
                                    } catch (Exception e) {
                                    }


                                }

                            }
                            new GetForecastData().execute();
                        }
                    }
                }
            }
        });

        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

//                final String stAddress = streetAdress.getText().toString().length();

                    streetAddress.setText("");
                    city.setText("");
                    state.setSelection(0);
                    radioButton.check(radioFar.getId());
                errorText.setText("");

            }
        });


    }

    CallbackManager callbackManager;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayAbout(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, displayAbout.class);
        startActivity(intent);
    }



}
