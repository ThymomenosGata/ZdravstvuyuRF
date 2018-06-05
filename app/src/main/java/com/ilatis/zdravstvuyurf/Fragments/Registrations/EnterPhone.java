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
import android.widget.EditText;

import com.ilatis.zdravstvuyurf.R;

import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser;
import ru.tinkoff.decoro.slots.Slot;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

public class EnterPhone extends Fragment{
    public EnterPhone() { }
    public static EnterPhone newInstace(){
        return new EnterPhone();
    }
    private View mView;
    private Button button;
    private EditText mPhoneView;

    private void loadFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.regContainer, fragment);
        ft.commit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.number_enter_fragment, container, false);
        button = (Button)mView.findViewById(R.id.enterNumber);
        mPhoneView = (EditText)mView.findViewById(R.id.enterPhone);
        Slot[] slots = new UnderscoreDigitSlotsParser().parseSlots("+7 (___) ___-__-__");
        FormatWatcher formatWatcher = new MaskFormatWatcher( // форматировать текст будет вот он
                MaskImpl.createTerminated(slots)
        );
        formatWatcher.installOn(mPhoneView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(EnterCode.newInstace());
            }
        });
        return mView;
    }
}
