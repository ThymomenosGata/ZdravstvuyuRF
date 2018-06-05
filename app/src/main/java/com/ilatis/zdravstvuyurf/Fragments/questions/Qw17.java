package com.ilatis.zdravstvuyurf.Fragments.questions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ilatis.zdravstvuyurf.MainActivity;
import com.ilatis.zdravstvuyurf.R;
import com.ilatis.zdravstvuyurf.TestActivity;

public class Qw17 extends Fragment {

    public Qw17() {

    }
    public static Qw17 newInstace(){
        return new Qw17();
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
        mView = inflater.inflate(R.layout.quest17_fragment, container, false);
        button = (Button)mView.findViewById(R.id.Qw17);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });
        return mView;
    }
}

