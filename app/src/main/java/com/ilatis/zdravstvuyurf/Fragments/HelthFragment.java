package com.ilatis.zdravstvuyurf.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.ilatis.zdravstvuyurf.R;

public class HelthFragment extends Fragment {
    public HelthFragment() { }
    public static HelthFragment newInstace(){
        return new HelthFragment();
    }

    private ImageButton imButT;
    private ImageButton imButW;
    private ImageButton imButS;
    private ImageButton imButCh;
    private ImageButton imBut;
    private static final int REQWEST_DATA = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.helth_fragment, container, false);

        imButT = (ImageButton)mView.findViewById(R.id.actionAddT);
        imButW = (ImageButton)mView.findViewById(R.id.actionAddW);
        imButS = (ImageButton)mView.findViewById(R.id.actionAddS);
        imButCh = (ImageButton)mView.findViewById(R.id.actionAddCh);
        imBut = (ImageButton)mView.findViewById(R.id.actionAdd);

        imButT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                DialogFragment dialog = new DialogFragment();
                dialog.setTargetFragment(HelthFragment.this, REQWEST_DATA);
                dialog.show(fragmentManager,"DialogFragment");
            }
        });

        imButW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                DialogFragment dialog = new DialogFragment();
                dialog.setTargetFragment(HelthFragment.this, REQWEST_DATA);
                dialog.show(fragmentManager,"DialogFragment");
            }
        });

        imButCh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                DialogFragment dialog = new DialogFragment();
                dialog.setTargetFragment(HelthFragment.this, REQWEST_DATA);
                dialog.show(fragmentManager,"DialogFragment");
            }
        });

        imButS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                DialogFragment dialog = new DialogFragment();
                dialog.setTargetFragment(HelthFragment.this, REQWEST_DATA);
                dialog.show(fragmentManager,"DialogFragment");
            }
        });

        imBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                DialogFragment dialog = new DialogFragment();
                dialog.setTargetFragment(HelthFragment.this, REQWEST_DATA);
                dialog.show(fragmentManager,"DialogFragment");
            }
        });

        return mView;
    }
}
