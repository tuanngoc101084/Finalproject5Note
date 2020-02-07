package com.example.finalpro.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalpro.R;
import com.example.finalpro.Utiliti.MakeFolder;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button mbtnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mapping();

    }

    private void mapping() {
        mbtnAdd= findViewById(R.id.buttonAddnew);
        mbtnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonAddnew:
                MakeFolder.MarkNewFolderExternal();
                MakeFolder.GetFullFolder();
                Intent intent= new Intent(Main2Activity.this,MainActivity.class);
                intent.putExtra("NameFolder",MakeFolder.getRandom());
                startActivity(intent);
                break;
                default:
                    break;
        }
    }
}
