package com.example.finalpro.Utiliti;
import android.Manifest;
import android.app.Activity;
import androidx.core.app.ActivityCompat;

public class CheckPermissionExternal {
    public  static  Boolean WriteExternalPermission(Activity mActivity)
    {
        ActivityCompat.requestPermissions(mActivity,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        return  true;
    }
    public  static  Boolean ReadExternalPermission(Activity mActivity)
    {
        ActivityCompat.requestPermissions(mActivity,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},2);
        return  true;
    }
}
