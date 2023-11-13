package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class evenementAdapter extends ArrayAdapter<evenement> {
    private Context mContext;
    private int mResource;
    public evenementAdapter(@NonNull Context context, int resource, @NonNull ArrayList<evenement> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= LayoutInflater.from(mContext);
        convertView =layoutInflater.inflate(mResource, parent,false);
        ImageView imageView =convertView.findViewById(R.id.image);
        TextView txtName= convertView.findViewById(R.id.txtName);
        TextView txtDes= convertView.findViewById(R.id.txtDes);
        TextView txtDate = convertView.findViewById(R.id.txtDate); // TextView pour la date
        TextView txtLieu = convertView.findViewById(R.id.txtLieu); // TextView pour le lieu
        imageView.setImageResource(getItem(position).getImage());
        txtName.setText(getItem(position).getName());
        txtDes.setText(getItem(position).getDes());

        txtLieu.setText(getItem(position).getDate());
        txtLieu.setText(getItem(position).getLocation());
        return convertView;



    }
}
