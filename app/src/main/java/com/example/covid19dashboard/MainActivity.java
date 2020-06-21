package com.example.covid19dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.json.JSONException;


public class MainActivity extends AppCompatActivity {

    // Object of TextView
    TextView tvCases, tvRecovered, tvDeaths, tvTodayCases, tvCritical, tvActive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvDeaths = findViewById(R.id.tvDeaths);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);

        fetchData();
    }

    private void fetchData() {
        String url = "https://disease.sh/v2/all";


        StringRequest request =
                new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response.toString());

                                    tvCases.setText(jsonObject.getString("cases"));
                                    tvRecovered.setText(jsonObject.getString("recovered"));
                                    tvCritical.setText(jsonObject.getString("critical"));
                                    tvActive.setText(jsonObject.getString("active"));
                                    tvDeaths.setText(jsonObject.getString("deaths"));
                                    tvTodayCases.setText(jsonObject.getString("todayCases"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(
                                MainActivity.this, error.getMessage(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}