package com.example.immoapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    Button terrain ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_home, container, false);
        terrain = v.findViewById(R.id.terrain);

        terrain.setOnClickListener(e ->{
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame, new TerrainFragment()).commit();
        });
        return v ;
    }
}