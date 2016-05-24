package com.j.homePage;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Application;
import android.app.Service;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.Telephony;
import android.text.Editable;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.VideoView;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2015/9/2.
 */
public class Test extends Activity {
    Telephony telephony;
    Class aClass;
    Service service;
    Application application;
    ContextThemeWrapper contextThemeWrapper;
    ContextWrapper contextWrapper;
    PreferenceManager preferenceManager;
    Context context;
    View view;
    ContentObserver contentObserver;
    Connection connection;
    ThreadFactory threadFactory;
    Adapter adapter;
    BaseAdapter baseAdapter;
    SimpleAdapter simpleAdapter;
    Editable editable;
    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    Configuration configuration = getResources().getConfiguration();
    Runtime runtime;
    Drawable drawable;
    Bitmap bitmap;
    BitmapDrawable bitmapDrawable;
    BitmapFactory bitmapFactory;
    Canvas canvas;
    Paint paint;
    Path path;
    PathEffect pathEffect;
    Matrix matrix;
    Shader shader;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    SQLiteOpenHelper sqLiteOpenHelper;

    public static void main(String[] args) {
        Context context;
        ContentProvider contentProvider;
        ContentResolver contentResolver;
        ContentObserver contentObserver;
        Object object = null;
        object.getClass();
        final Class<Object> objectClass = Object.class;
        Class a;
        final Class<Integer> integerClass = int.class;
        View view;
        ViewGroup viewGroup;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = this.getSharedPreferences("", Context.MODE_PRIVATE);


        try {
            Context context = createPackageContext("", CONTEXT_IGNORE_SECURITY);
            context.openFileInput("");
            context.openFileOutput("", MODE_PRIVATE);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Environment environment;
        MediaPlayer mediaPlayer;
        SoundPool soundPool;
        VideoView videoView;
        MediaRecorder mediaRecorder;

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        LocationProvider locationProvider;
        Location location;

        InputMethodManager inputMethodManager;
        Runtime runtime;
        AccessibilityManager accessibilityManager;


    }


}
