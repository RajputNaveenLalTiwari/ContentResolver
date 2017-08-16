package com.example.workingoncontentresolver;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity
{

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File file = new File(getExternalFilesDir(null).toString());
        String path = file.getAbsolutePath();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB)
        {
            Uri uri = MediaStore.Files.getContentUri("external");
            Log.i(TAG,"Uri = "+uri);
            Log.i(TAG,"Path = "+path);
        }
    }

    private void getDataFromUri(String path)
    {
        Uri uri = Uri.parse("content://"+path);
        String[]    columns = {MediaStore.Images.Media.DATA,MediaStore.Images.Media.TITLE,MediaStore.Images.Media._ID};
        String      whereClause = null;
        String[]    whereArgs = null;
        String      sortingOrder = MediaStore.Images.Media.DATE_ADDED +" DESC";
        Cursor cursor = getContentResolver().query(uri,columns,whereClause,whereArgs,sortingOrder);
        if(cursor != null && cursor.moveToFirst())
        {
            do
            {

            }while (cursor.moveToNext());
        }


    }
}
