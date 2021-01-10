package com.example.ezyfoody;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 *
 */
public  class DrinkFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView drinkRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_drink, container, false);

        String[] drinkNames = new String[Drink.drinks.length];
        for (int i = 0; i < drinkNames.length; i++) {
            drinkNames[i] = Drink.drinks[i].getName();
        }

        int[] drinkImages = new int[Drink.drinks.length];
        for (int i = 0; i < drinkImages.length; i++) {
            drinkImages[i] = Drink.drinks[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(drinkNames, drinkImages);
        drinkRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        drinkRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), DrinkActivity.class);
                intent.putExtra(DrinkActivity.Drink_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return drinkRecycler;
    }


}