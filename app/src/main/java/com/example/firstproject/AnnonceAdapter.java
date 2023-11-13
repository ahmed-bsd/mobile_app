package com.example.firstproject;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AnnonceAdapter extends ArrayAdapter<String> {

    public AnnonceAdapter(Context context, int resource, List<String> annonces) {
        super(context, resource, annonces);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        // Personnalisez la vue pour afficher les détails de l'annonce
        TextView textView = view.findViewById(R.id.productName);
        textView.setText(getItem(position));

        return view;
    }
}

