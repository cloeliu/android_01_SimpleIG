package com.yahoo.cloeliu.simpleig;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by cloeliu on 2015/7/28.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {
    // what data do we need from Activity
    // Context, Data Source
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    // what item looks like
    // use template to display each photo
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get data
        InstagramPhoto photo = getItem(position);
        // check if we are using a recycled view
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }
        // lookup the view
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        // insert data to items
        tvCaption.setText(photo.username + " - " + photo.caption);
        // clear before insert if it was recycled
        ivPhoto.setImageResource(0);
        // * picasso
        Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);
        // return
        return convertView;
    }
}
