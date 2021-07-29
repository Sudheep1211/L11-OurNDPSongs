package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> SongList;

    public CustomAdapter (Context context, int resource, ArrayList<Song> objects){
        super (context, resource, objects);

        parent_context = context;
        layout_id = resource;
        SongList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        TextView tvSingers = rowView.findViewById(R.id.tvSingers);

        RatingBar rbStars = rowView.findViewById(R.id.ratingBarStars);


        Song currentSong = SongList.get(position);


        tvTitle.setText(currentSong.getTitle());
        tvYear.setText(currentSong.getYearReleased() + "");
        tvSingers.setText(currentSong.getSingers());

        if(currentSong.getStars() == 1){
            rbStars.setRating(1);

        } if (currentSong.getStars() == 2){
            rbStars.setRating(2);

        } if (currentSong.getStars() == 3){
            rbStars.setRating(3);

        } if (currentSong.getStars() == 4){
            rbStars.setRating(4);

        } if (currentSong.getStars() == 5){
            rbStars.setRating(5);

        }

        ImageView ivNew = rowView.findViewById(R.id.imageViewNew);
        if(currentSong.getYearReleased() >= 2019){
            ivNew.setImageResource(R.drawable.new_image);
        } else{
            ivNew.setVisibility(View.INVISIBLE);
        }


        return rowView;
    }
}
