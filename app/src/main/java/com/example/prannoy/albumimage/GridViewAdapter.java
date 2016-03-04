package com.example.prannoy.albumimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Prannoy on 2/29/2016.
 */
public class GridViewAdapter extends ArrayAdapter {
    private Context context;



    public GridViewAdapter(Context context,ArrayList data) {
        super(context, 0, data);


    }

    private static class ViewHolder
    {
        ImageView imgholder;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        ViewHolder holder=null;

        if (row == null) {
            row = LayoutInflater.from(getContext()).inflate(R.layout.image_gallery, parent, false);


        }
        holder=new ViewHolder();
        holder.imgholder=(ImageView)row.findViewById(R.id.galleryImage);
        row.setTag(holder);

        Bitmap img=(Bitmap)getItem(position);
        holder.imgholder.setImageBitmap(img);



        return row;
    }
}
