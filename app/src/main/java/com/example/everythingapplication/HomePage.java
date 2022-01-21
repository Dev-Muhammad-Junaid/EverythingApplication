package com.example.everythingapplication;

import static android.content.ContentValues.TAG;

import static com.google.android.material.navigation.NavigationBarView.LABEL_VISIBILITY_SELECTED;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.everythingapplication.RestAPI.RestAPI_MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class HomePage extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        bottomNavigationView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_SELECTED);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home_page:
                        item.setChecked(true);
                        Products_Fragment products_fragment = new Products_Fragment();
                        FT.replace(R.id.frame_home,products_fragment);
                        FT.commit();
                        Toast.makeText(getApplicationContext(), "Home page", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onNavigationItemSelected: Home Page");
                        break;
                    case R.id.search_page:
                        item.setChecked(true);
                        Toast.makeText(getApplicationContext(), "Search Page", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onNavigationItemSelected: Search Page");

//                fragment = new SearchPage();

                        break;
                    case  R.id.profile_page:
                        item.setChecked(true);
                        Toast.makeText(getApplicationContext(), "Profile Page", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onNavigationItemSelected: Profile Page");
//                fragment = new ProductPage();

                        break;
                    case R.id.cart_page:
                        item.setChecked(true);
                        Toast.makeText(getApplicationContext(), "Cart Page", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onNavigationItemSelected: Cart Page");
//                fragment = new CartPage();

                        break;
                }
                return false;
            }
        });
//        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
//            @Override
//            public void onNavigationItemReselected(@NonNull MenuItem item) {
//
//            }
//        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        return false;
    }

    public void mycart_btn(View view) {
        startActivity(new Intent(this,Search_Products.class));
    }
}