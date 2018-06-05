package com.ilatis.zdravstvuyurf.Fragments;


import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.ilatis.zdravstvuyurf.R;

import java.text.SimpleDateFormat;
import java.util.Locale;

import ru.tinkoff.decoro.MaskImpl;
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser;
import ru.tinkoff.decoro.slots.Slot;
import ru.tinkoff.decoro.watchers.FormatWatcher;
import ru.tinkoff.decoro.watchers.MaskFormatWatcher;

@RequiresApi(api = Build.VERSION_CODES.N)
public class DialogFragment extends android.support.v4.app.DialogFragment {



    EditText eText;
    EditText cText;
    Button button;

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //final MainFragment mainFragment = new MainFragment();
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_fragment, null);
        builder.setView(view);
        builder.setTitle(R.string.add);

        eText = (EditText)view.findViewById(R.id.date_dialog);
        cText = (EditText)view.findViewById(R.id.ist_dialog);
        button = (Button)view.findViewById(R.id.addNew);
        Slot[] slots = new UnderscoreDigitSlotsParser().parseSlots("____-__-__");
        FormatWatcher formatWatcher = new MaskFormatWatcher( // форматировать текст будет вот он
                MaskImpl.createTerminated(slots)
        );
        formatWatcher.installOn(eText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });



        AlertDialog alertDialog = builder.create();
        return alertDialog;
    }

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        eText.setText(sdf.format(myCalendar.getTime()));
    }
}
