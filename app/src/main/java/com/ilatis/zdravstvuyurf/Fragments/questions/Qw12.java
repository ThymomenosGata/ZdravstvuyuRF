package com.ilatis.zdravstvuyurf.Fragments.questions;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ilatis.zdravstvuyurf.R;

public class Qw12 extends Fragment {

    public Qw12() {

    }
    public static Qw12 newInstace(){
        return new Qw12();
    }

    private View mView;
    private Button button;

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.test_content, fragment);
        ft.commit();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.quest12_fragment, container, false);
        button = (Button)mView.findViewById(R.id.Qw12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(Qw13.newInstace());
            }
        });
        return mView;
    }
}

