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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnTambah;
    RecyclerView rvMobil;
    ProductAdapter productAdapter;

    ArrayList<Product> productArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productArrayList = new ArrayList<>();
        btnTambah = findViewById(R.id.btn_tambah);
        rvMobil = findViewById(R.id.rv_Mobil);
        rvMobil.setHasFixedSize(true);
        rvMobil.setLayoutManager(new LinearLayoutManager(this));

        btnTambah.setOnClickListener(this);

        loadproducts();
    }
    private void loadproducts() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, UrlPath.SHOW_PRODUCT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray productArr = new JSONArray(response);

                            for (int i=0; i < productArr.length(); i++){
                                JSONObject productObj = productArr.getJSONObject(i);

                                int id = productObj.getInt("id");
                                String title = productObj.getString("judul");
                                String spek = productObj.getString("deskripsi");
                                String image = productObj.getString("gambar");
                                Product product = new Product(id, title, spek,  image);
                                productArrayList.add(product);

                            }
                            productAdapter = new ProductAdapter(MainActivity.this, productArrayList);
                            rvMobil.setAdapter(productAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(MainActivity.this, error.getMessage() , Toast.LENGTH_LONG).show();

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
        Intent intent = new Intent(this, TambahActivity.class);
        startActivity(intent);
        finish();
    }
}
