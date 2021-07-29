package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        TextView tvStars = rowView.findViewById(R.id.textViewStars);


        Song currentSong = SongList.get(position);


        tvTitle.setText(currentSong.getTitle());
        tvYear.setText(currentSong.getYearReleased() + "");
        tvSingers.setText(currentSong.getSingers());

        if(currentSong.getStars() == 1){
            tvStars.setText("*");
        } if (currentSong.getStars() == 2){
            tvStars.setText("* *");
        } if (currentSong.getStars() == 3){
            tvStars.setText("* * *");
        } if (currentSong.getStars() == 4){
            tvStars.setText("* * * *");
        } if (currentSong.getStars() == 5){
            tvStars.setText("* * * * *");
        }

        return rowView;
    }
}
