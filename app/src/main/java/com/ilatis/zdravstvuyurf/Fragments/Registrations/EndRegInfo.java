package com.ilatis.zdravstvuyurf.Fragments.Registrations;

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

import com.ilatis.zdravstvuyurf.LoginActivity;
import com.ilatis.zdravstvuyurf.R;
import com.ilatis.zdravstvuyurf.TestActivity;

public class EndRegInfo extends Fragment {
    public EndRegInfo() { }
    public static EndRegInfo newInstace(){
        return new EndRegInfo();
    }
    private View mView;
    private Button button;

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.regContainer, fragment);
        ft.commit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.end_reg_fragment, container, false);
        button = (Button)mView.findViewById(R.id.goingTest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), TestActivity.class);
                startActivity(i);
                getActivity().finish();
            }
        });
        return mView;
    }
}
