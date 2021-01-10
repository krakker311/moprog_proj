package com.example.ezyfoody;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;


public class TopupFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView topupRecycler = (RecyclerView)inflater.inflate(
                R.layout.fragment_food, container, false);

        String[] topupNames = new String[TopUp.topups.length];
        for (int i = 0; i < topupNames.length; i++) {
            topupNames[i] = TopUp.topups[i].getName();
        }

        int[] topupImages = new int[TopUp.topups.length];
        for (int i = 0; i < topupImages.length; i++) {
            topupImages[i] = TopUp.topups[i].getImageResourceId();
        }
        CaptionedImagesAdapter adapter = new CaptionedImagesAdapter(topupNames, topupImages);
        topupRecycler.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        topupRecycler.setLayoutManager(layoutManager);
        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), TopupActivity.class);
                intent.putExtra(TopupActivity.TopUp_ID, position);
                getActivity().startActivity(intent);
            }
        });
        return topupRecycler;
    }
}