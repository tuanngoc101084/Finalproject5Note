package com.example.finalpro.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.finalpro.R;
import com.example.finalpro.viewmodel.GetLanguageForText2Speech;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar ;
    Button btPlay,btSave;
    EditText editTextInput;
    GetLanguageForText2Speech text2Speech;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Mapping();
        Initilial();
        DrawToolbar();
        Event_Text2Speech();
        Event_Navigation();
    }

    private void Initilial() {
        text2Speech= new GetLanguageForText2Speech(getApplicationContext());
    }

    private void Event_Text2Speech() {
      btPlay.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            //  Toast.makeText(getApplicationContext(),spinner.getSelectedItem().toString().replace('x',' '),Toast.LENGTH_LONG).show();
              text2Speech.SetspeechRate( Float.valueOf(spinner.getSelectedItem().toString().replace('x',' ')));
              text2Speech.SpeakOut(editTextInput.getText().toString());

          }
      });

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

    private void Mapping() {
        drawerLayout= findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigation);
        toolbar= findViewById(R.id.toolbar);
        btPlay=findViewById(R.id.buttonPlay);
        btSave=findViewById(R.id.buttonSave);
        editTextInput= findViewById(R.id.textInput);
        spinner= findViewById(R.id.spinnerSpeechRate);
    }
}
