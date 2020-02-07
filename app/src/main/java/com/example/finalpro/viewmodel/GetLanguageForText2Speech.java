package com.example.finalpro.viewmodel;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

public class GetLanguageForText2Speech {
    TextToSpeech textToSpeech;
    Activity mActivity;
    Context context;
    Boolean Ready=false;
    private String envPath = Environment.getDataDirectory().getAbsolutePath() + "/Text2Speech";
    private Uri fileUri;
    public GetLanguageForText2Speech(Context contextInput,Activity activity)
    {
        context= contextInput;
        mActivity= activity;
        textToSpeech = new TextToSpeech(contextInput, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
               Set_Language();
            }
        });
        textToSpeech.setSpeechRate(1);
    }
    public void fileCreate(String text,String namefolder) {
        if (isCheckWriteExternal()&& isCheckpermission(Manifest.permission.WRITE_EXTERNAL_STORAGE))
        {
            Log.d("nnn",namefolder);
            File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ "/5Note" + "/"+namefolder+"/");
            dir.mkdir();
            if (dir.exists())
            {
                File file = new File(dir, "Text2Speech" + new Random().nextDouble() +".mp3");
                int test = textToSpeech.synthesizeToFile((CharSequence) text, null, file, "tts");
                Toast.makeText(context,"fileCreate "+ " Successfully !",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(context,"fileCreate "+ "Not Exist",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            showpermission();
            Toast.makeText(context,"fileCreate "+ "Not Permission",Toast.LENGTH_LONG).show();
        }


    }

    private void showpermission()
    {
      if(ActivityCompat.shouldShowRequestPermissionRationale(mActivity,Manifest.permission.WRITE_EXTERNAL_STORAGE))
      {
          new AlertDialog.Builder(context)
                  .setTitle("Permission needed")
                  .setMessage("This permission is needed because of this and that")
                  .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          ActivityCompat.requestPermissions(mActivity,
                                  new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                      }
                  })
                  .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          dialog.dismiss();
                      }
                  })
                  .create().show();
      }
      else
      {
           ActivityCompat.requestPermissions(mActivity,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.BLUETOOTH},1);
      }
    }

    private  Boolean isCheckWriteExternal()
    {
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()))
        {
            Toast.makeText(context,"External  "+ "Enable",Toast.LENGTH_LONG).show();
            return  true;
        }
        else
        {
            Toast.makeText(context,"External  "+ "Disable",Toast.LENGTH_LONG).show();
            return  false;
        }
    }
    private  Boolean isCheckpermission(String Permission)
    {
        int check= ContextCompat.checkSelfPermission(context,Permission);
        return (check== PackageManager.PERMISSION_GRANTED);

    }

    public void SpeakOut(String inputtext) {
        if(!Ready)
        {
            Toast.makeText(context,"Text to speech not ready",Toast.LENGTH_LONG).show();
            return;
        }
        textToSpeech.speak(inputtext,TextToSpeech.QUEUE_FLUSH,null,UUID.randomUUID().toString());
    }

    public  void SetspeechRate( float speechRate)
    {
        textToSpeech.setSpeechRate(speechRate);
    }
    private void Set_Language()
    {

        int result = textToSpeech.setLanguage(Locale.ENGLISH);
        if (result==TextToSpeech.LANG_MISSING_DATA)
        {
            this.Ready=false;
            Toast.makeText(context,"LANG_MISSING_DATA",Toast.LENGTH_LONG).show();
            return;
        }
        else  if(result==TextToSpeech.LANG_NOT_SUPPORTED)
        {
            this.Ready=false;
            Toast.makeText(context,"LANG_NOT_SUPPORTED",Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            this.Ready=true;
            Locale currentLanguage= textToSpeech.getVoice().getLocale();
            Toast.makeText(context,"Language "+ currentLanguage,Toast.LENGTH_LONG).show();
        }

    }

}
