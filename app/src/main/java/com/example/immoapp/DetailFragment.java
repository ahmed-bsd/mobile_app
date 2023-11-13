package com.example.immoapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.immoapp.Dao.AppDataBase;
import com.example.immoapp.Entities.Terrain;

import java.util.List;


public class DetailFragment extends Fragment {

    TextView nom,localisation,description;
    ImageView img;
    Button reserver;

    Terrain ter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        int terrainId = getArguments().getInt("terrainId", -1);
        AppDataBase appDataBase = null;
        Terrain terrain = null;
        if (terrainId != -1) {
            appDataBase = AppDataBase.getInstance(requireContext());
            terrain = appDataBase.daoTerrain().getTerrainById(terrainId);

            // on recupere les donnee a partir de xml
            nom = view.findViewById(R.id.nom);
            localisation = view.findViewById(R.id.localisation);
            description = view.findViewById(R.id.description);
            img = view.findViewById(R.id.imageterrain);
            //on affiche les donnees liee au terrain selectionné (changer le textView par le set )
            nom.setText(terrain.getNom());
            localisation.setText(terrain.getDescription());
            description.setText(terrain.getLocalisation());
            img.setImageResource(terrain.getImageResourceId());
        }

        //pour la liste des terrains en scroll view  on recupere la liste dans le nom est le meme
        List<Terrain> terrainsWithSameName = appDataBase.daoTerrain().getTerrainsByName(terrain.getNom());

        // recuperation de scrollView
        LinearLayout horizontalLinearLayout = view.findViewById(R.id.horizontalLinearLayout);

        if (!terrainsWithSameName.isEmpty()) {
            // on ajoute les terrains
            for (Terrain terrainWithSameName : terrainsWithSameName) {
                LinearLayout terrainLayout = new LinearLayout(requireContext());
                terrainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));
                terrainLayout.setOrientation(LinearLayout.VERTICAL);


                ImageView imageView = new ImageView(requireContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(
                        120, // Set width as needed
                        120  // Set height as needed
                ));
                imageView.setImageResource(terrainWithSameName.getImageResourceId());


                TextView nameTextView = new TextView(requireContext());
                nameTextView.setLayoutParams(new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                ));
                nameTextView.setText(terrainWithSameName.getNom());
                terrainLayout.addView(imageView);
                terrainLayout.addView(nameTextView);
                horizontalLinearLayout.addView(terrainLayout);
            }
        } else {
            TextView noTerrainTextView = new TextView(requireContext());
            noTerrainTextView.setText("Aucun terrain similaire trouvé.");
            horizontalLinearLayout.addView(noTerrainTextView);
        }

        reserver= view.findViewById(R.id.reserver);
        reserver.setOnClickListener(e->{
            TerrainReserverFragment reservationFragment = new TerrainReserverFragment();



            // on remplace le fragment actuel par le fragment de reservaation
            if (getActivity() != null) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame , reservationFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }

}