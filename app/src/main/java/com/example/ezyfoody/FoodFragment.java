package com.example.ezyfoody;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class FoodFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView foodRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_food, container, false);

        String[] foodNames = new String[Foods.foods.length];
        for (int i = 0; i < foodNames.length; i++) {
            foodNames[i] = Foods.foods[i].getName();
        }

        int[] foodImages = new int[Foods.foods.length];
        for (int i = 0; i < foodImages.length; i++) {
            foodImages[i] = Foods.foods[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(foodNames, foodImages);
        foodRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        foodRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), FoodActivity.class);
                intent.putExtra(FoodActivity.Food_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return foodRecycler;

    }
}