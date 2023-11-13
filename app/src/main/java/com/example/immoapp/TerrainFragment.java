package com.example.immoapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SearchView;

import com.example.immoapp.Dao.AppDataBase;

import java.util.List;

public class TerrainFragment extends Fragment {

    private GridView gridView;
    private TerrainAdapter terrainAdapter;
    private List<com.example.immoapp.Entities.Terrain> terrainList;
    Button show , insert ;
    private AppDataBase appDataBase;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terrain, container, false);

        insert = view.findViewById(R.id.insert);

        // on recpere la liste des terrains
        appDataBase = AppDataBase.getInstance(requireContext());
        terrainList = appDataBase.daoTerrain().getAll();

        // on doit configurer RecyclerView
        gridView = view.findViewById(R.id.gridView);
        terrainAdapter = new TerrainAdapter(terrainList,getActivity());
        gridView.setAdapter(terrainAdapter);

        insert.setOnClickListener(e->{
           Intent intent = new Intent(getActivity(), AddTerrainActivity.class);
            startActivity(intent);
        });


        return view;
    }


}