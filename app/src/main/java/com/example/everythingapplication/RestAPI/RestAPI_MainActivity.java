package com.example.everythingapplication.RestAPI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.everythingapplication.HomePage;
import com.example.everythingapplication.ProductsAdapter;
import com.example.everythingapplication.ProductsModel;
import com.example.everythingapplication.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestAPI_MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restapi_main);
    }
    public void gotohome(View view) {
        startActivity(new Intent(this,HomePage.class));
    }
}