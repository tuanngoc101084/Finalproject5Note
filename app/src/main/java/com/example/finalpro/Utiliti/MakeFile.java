package com.example.finalpro.Utiliti;

import android.content.ContentProvider;
import android.content.Context;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.NonNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeFile {

    public  static void  SaveFile( String inputText, String fullLinkFolder,String nameFiletext)
    {

        FileOutputStream fileOutputStream =null;
        File file;
        file= new File(fullLinkFolder,nameFiletext+".txt");
        Log.d("BBB",nameFiletext);
        try {
            fileOutputStream= new FileOutputStream(file);
            fileOutputStream.write(inputText.getBytes());
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public  static  void LoadFile(String fullLinkFolde)
    {
        BufferedReader bf =null;
        String [] array_file;
        File folder =null;
        File file=null;
        folder= new File(fullLinkFolde);
        array_file =  folder.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        });
        try {
            file= new File(fullLinkFolde,array_file[0]);
            bf= new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            StringBuilder builder= new StringBuilder();
            while ((line=bf.readLine())!=null)
            {
                builder.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
