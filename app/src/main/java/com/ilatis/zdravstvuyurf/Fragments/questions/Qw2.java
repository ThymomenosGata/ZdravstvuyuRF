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
import android.widget.EditText;

import com.ilatis.zdravstvuyurf.R;

import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser;
import ru.tinkoff.decoro.slots.Slot;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

public class Qw2 extends Fragment {

    public Qw2() {

    }
    public static Qw2 newInstace(){
        return new Qw2();
    }

    private View mView;
    private Button button;
    private EditText eText;

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.test_content, fragment);
        ft.commit();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.quest2_fragment, container, false);
        button = (Button)mView.findViewById(R.id.Qw2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(Qw3.newInstace());
            }
        });
        eText = (EditText)mView.findViewById(R.id.test_date);
        //Форматированный ввод для даты. Можно сказать маска ввода.
        Slot[] slots = new UnderscoreDigitSlotsParser().parseSlots("____-__-__");
        FormatWatcher formatWatcher = new MaskFormatWatcher( // форматировать текст будет вот он
                MaskImpl.createTerminated(slots)
        );
        formatWatcher.installOn(eText);
        return mView;
    }
}

