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

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button btnTambah;
    RecyclerView rvAgenda;
    AgendaAdapter agendaAdapter;
    ArrayList<Agenda> agendaArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        agendaArrayList = new ArrayList<>();
        btnTambah = findViewById(R.id.btn_tambah);
        rvAgenda = findViewById(R.id.rv_Agenda);
        rvAgenda.setHasFixedSize(true);
        rvAgenda.setLayoutManager(new LinearLayoutManager(this));

        btnTambah.setOnClickListener(this);

        loadagenda();
    }
    private void loadagenda() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url.SHOW_PRODUCT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray productArr = new JSONArray(response);

                            for (int i=0; i < productArr.length(); i++){
                                JSONObject productObj = productArr.getJSONObject(i);

                                int id = productObj.getInt("id");
                                String title = productObj.getString("nama_agenda");
                                String spek = productObj.getString("keterangan");
                                String image = productObj.getString("gambar");
                                Agenda agenda = new Agenda(id, title, spek,  image);
                                agendaArrayList.add(agenda);

                            }
                            agendaAdapter = new AgendaAdapter(Main2Activity.this, agendaArrayList);
                            rvAgenda.setAdapter(agendaAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Main2Activity.this, error.getMessage() , Toast.LENGTH_LONG).show();

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
        Intent intent = new Intent(this, TambahAgenda.class);
        startActivity(intent);
        finish();
    }

    }

