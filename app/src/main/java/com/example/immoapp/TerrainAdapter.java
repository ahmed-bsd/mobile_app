package com.example.immoapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.immoapp.Entities.Terrain;

import java.util.List;

public class TerrainAdapter  extends BaseAdapter {

    private List<com.example.immoapp.Entities.Terrain> terrains;

    private Context context;

    public TerrainAdapter(List<com.example.immoapp.Entities.Terrain> terrains, Context context) {
        this.terrains = terrains;
        this.context = context;
    }

    @Override
    public int getCount() {
        return terrains.size();
    }

    @Override
    public Object getItem(int position) {
        return terrains.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.item_terrain, parent, false);
        }

        Terrain terrain = terrains.get(position);

        // recuperation des elements de vue
        ImageView imageViewTerrain = view.findViewById(R.id.imageTerrain);
        TextView textViewNom = view.findViewById(R.id.textViewNom);
        TextView textViewDescription = view.findViewById(R.id.textViewDescription);
        Button buttonReserver = view.findViewById(R.id.buttonReserver);

        // Configurer les données
        imageViewTerrain.setImageResource(terrain.getImageResourceId());
        textViewNom.setText(terrain.getNom());
        textViewDescription.setText(terrain.getDescription());

        buttonReserver.setOnClickListener(v -> {
            int terrainId = terrain.getIdTerrain();
            DetailFragment detailFragment = new DetailFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("terrainId", terrainId);
            detailFragment.setArguments(bundle);
            if (context instanceof AppCompatActivity) {
                ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, detailFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }
}

