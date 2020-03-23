package com.example.uploadlihat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    Button btnTambah;
    RecyclerView rvFeedback;
    FeedbackAdapter feedbackAdapter;
    ArrayList<Feedback> feedbackArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        feedbackArrayList = new ArrayList<>();
        btnTambah = findViewById(R.id.btn_tambah);
        rvFeedback = findViewById(R.id.rv_Feedback);
        rvFeedback.setHasFixedSize(true);
        rvFeedback.setLayoutManager(new LinearLayoutManager(this));

        btnTambah.setOnClickListener(this);

        loadagenda();
    }
    private void loadagenda() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, UrlFeedback.SHOW_PRODUCT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray productArr = new JSONArray(response);

                            for (int i=0; i < productArr.length(); i++){
                                JSONObject productObj = productArr.getJSONObject(i);

                                int id = productObj.getInt("id");
                                String nama = productObj.getString("nama");
                                String komentar = productObj.getString("komentar");
                                String image = productObj.getString("gambar");
                                Feedback feedback = new Feedback(id, nama, komentar,  image);
                               feedbackArrayList.add(feedback);

                            }
                            feedbackAdapter = new FeedbackAdapter(Main3Activity.this, feedbackArrayList);
                            rvFeedback.setAdapter(feedbackAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Main3Activity.this, error.getMessage() , Toast.LENGTH_LONG).show();

            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tambah:
                sendToTambah();
        }
    }

    private void sendToTambah() {
        Intent intent = new Intent(this, TambahFeedback.class);
        startActivity(intent);
        finish();
    }

}

