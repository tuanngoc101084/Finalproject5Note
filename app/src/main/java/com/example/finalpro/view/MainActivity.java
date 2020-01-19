package com.example.finalpro.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.finalpro.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar ;
    ImageView imageViewicon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        DrawToolbar();
        Event_Navigation();
    }

    private void Event_Navigation() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menu_item_home:
                    Toast.makeText(getApplicationContext(),"Ban chon home",Toast.LENGTH_LONG).show();
                    break;
                    case R.id.menu_item_practise:
                        Toast.makeText(getApplicationContext(),"Ban chon practise",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_item_setting:
                        Toast.makeText(getApplicationContext(),"Ban chon setting",Toast.LENGTH_LONG).show();
                        break;
                }
                drawerLayout.closeDrawer(Gravity.LEFT);
                return true;
            }
        });
    }

    private void DrawToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);// phai co de hien thi navigation
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_list_menu);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        navigationView.setItemIconTintList(null);
    }

    private void Anhxa() {
        drawerLayout= findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigation);
        toolbar= findViewById(R.id.toolbar);
    }
}
