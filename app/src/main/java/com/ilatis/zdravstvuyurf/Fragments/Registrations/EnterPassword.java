package com.ilatis.zdravstvuyurf.Fragments.Registrations;

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

public class EnterPassword extends Fragment {
    public EnterPassword() { }
    public static EnterPassword newInstace(){
        return new EnterPassword();
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
        mView = inflater.inflate(R.layout.enter_pass_fragment, container, false);
        button = (Button)mView.findViewById(R.id.endREG);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(EndRegInfo.newInstace());
            }
        });
        return mView;
    }
}
