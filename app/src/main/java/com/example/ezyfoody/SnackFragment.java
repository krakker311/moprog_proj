package com.example.ezyfoody;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class SnackFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        RecyclerView snackRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_snack, container, false);

        String[] snackNames = new String[Snacks.snacks.length];
        for (int i = 0; i < snackNames.length; i++) {
            snackNames[i] = Snacks.snacks[i].getName();
        }

        int[] snackImages = new int[Snacks.snacks.length];
        for (int i = 0; i < snackImages.length; i++) {
            snackImages[i] = Snacks.snacks[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(snackNames, snackImages);
        snackRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        snackRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), SnackActivity.class);
                intent.putExtra(SnackActivity.Snack_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return snackRecycler;
    }
}
