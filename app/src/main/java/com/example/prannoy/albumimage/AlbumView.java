package com.example.prannoy.albumimage;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AlbumView extends AppCompatActivity {

    private GridView gridView;
    private GridViewAdapter gridViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getData();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        gridView = (GridView) findViewById(R.id.gridView);
        gridViewAdapter = new GridViewAdapter(this, getData());
        gridView.setAdapter(gridViewAdapter);
    }
    private ArrayList<Bitmap> getData() {
        final ArrayList<Bitmap> imageItems = new ArrayList<>();





        Field[] fields = R.drawable.class.getFields();
        for (int i = 1; i <fields.length; i++) {
            int resID=getResources().getIdentifier("a" + i, "drawable", getPackageName());
            Log.i("Test", Integer.toString(resID));
            Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), resID);
            imageItems.add(bitmap);
        }
        return imageItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_album_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
