package com.example.finalpro.Utiliti;

import android.os.Environment;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ListView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MakeFolder {

    private  static String link5note;

    public static String getLink5note() {
        return link5note;
    }
    private static String random;

    public static String getRandom() {
        return random;
    }

    public  static  void Makefolder5note()
    {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ "/5Note/");
        link5note= file.getAbsolutePath();
        if(!file.exists())
            file.mkdirs();
    }
    public  static  void  MarkNewFolderExternal()
    {
        random=  UUID.randomUUID().toString();
        Makefolder5note();
    }
    public  static String[] GetFullFolder()
    {
        File file= new File(Environment.getExternalStorageDirectory().getAbsolutePath()+ "/5Note/");
        for ( String item:file.list()) {
            Log.d("BBB",item+ "\n");
        }
        return file.list();

    }

}
