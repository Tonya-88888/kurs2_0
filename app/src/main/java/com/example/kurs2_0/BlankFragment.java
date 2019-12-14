package com.example.kurs2_0;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;


public class BlankFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    Button currentDateTime;
    Button time;
    Button add;
    EditText name;
    EditText notificationText;
    ToggleButton everyDay;
    ToggleButton monday;
    ToggleButton tuesday;
    ToggleButton wednesday;
    ToggleButton thursday;
    ToggleButton friday;
    ToggleButton saturday;
    ToggleButton sunsday;

    Calendar dateAndTime=Calendar.getInstance();

    public final static String TAG = "com.example.kurs2_0.BlankFragment";
    private OnFragmentAddDataListener mListener;

    public static BlankFragment newInstance() {
        return new BlankFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {

        View v = inflater.inflate(R.layout.fragment_add, null);

        add = (Button)v.findViewById(R.id.addButton);
        add.setOnClickListener(this);
        name = v.findViewById(R.id.habitName);
        notificationText = v.findViewById(R.id.notification);

        if(name.getText().toString().length() != 0 && notificationText.getText().toString().length() !=0){
            add.setEnabled(true);
        }

        notificationText = v.findViewById(R.id.notification);

        currentDateTime=(Button)v.findViewById(R.id.timeButton);
        setInitialDateTime();


        time = (Button)v.findViewById(R.id.timeButton);
        time.setOnClickListener(this);



        everyDay = v.findViewById(R.id.everyDay);
        monday = v.findViewById(R.id.monday);
        tuesday = v.findViewById(R.id.tuesday);
        wednesday = v.findViewById(R.id.wednesday);
        thursday = v.findViewById(R.id.thursday);
        friday = v.findViewById(R.id.friday);
        saturday = v.findViewById(R.id.saturday);
        sunsday = v.findViewById(R.id.sunsday);

        everyDay.setOnCheckedChangeListener(this);
        monday.setOnCheckedChangeListener(this);
        tuesday.setOnCheckedChangeListener(this);
        wednesday.setOnCheckedChangeListener(this);
        thursday.setOnCheckedChangeListener(this);
        friday.setOnCheckedChangeListener(this);
        saturday.setOnCheckedChangeListener(this);
        sunsday.setOnCheckedChangeListener(this);

        notificationText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                if(name.getText().length() !=0){
                    add.setEnabled(true);}
            }
        });
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.timeButton:
                setTime(view);
                break;

            case R.id.addButton:

               /*toActivity((name.getText().toString())+"%"+(notificationText.getText().toString())
                       +"%"+Long.toString(dateAndTime.getTimeInMillis())+"%"+Integer.toString(1));

                getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();*/
               String str = (name.getText().toString())+"%"+(notificationText.getText().toString())
                       +"%"+Long.toString(dateAndTime.getTimeInMillis())+"%"+Integer.toString(1);
                toActivity(str);

                getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
              //  mListener.onOpenFragmentHome(str);

                break;
            case R.id.everyDay:
                if(monday.isChecked() && tuesday.isChecked() &&  wednesday.isChecked() &&
                        thursday.isChecked() && friday.isChecked() && saturday.isChecked() &&
                        sunsday.isChecked()){
                    everyDay.setChecked(true);
                }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentAddDataListener) {
            mListener = (OnFragmentAddDataListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragment1DataListener");
        }
    }
    public void toActivity(String data) {
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing() && activity instanceof MainActivity) {
            ((MainActivity) activity).fromFragmentData(data);
        }
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (monday.isChecked() && tuesday.isChecked() && wednesday.isChecked() &&
                thursday.isChecked() && friday.isChecked() && saturday.isChecked() &&
                sunsday.isChecked()) {

            everyDay.setChecked(true);
            monday.setChecked(false);
            tuesday.setChecked(false);
            wednesday.setChecked(false);
            thursday.setChecked(false);
            friday.setChecked(false);
            saturday.setChecked(false);
            sunsday.setChecked(false);
        }

        if(everyDay.isChecked()){
            monday.setChecked(false);
            tuesday.setChecked(false);
            wednesday.setChecked(false);
            thursday.setChecked(false);
            friday.setChecked(false);
            saturday.setChecked(false);
            sunsday.setChecked(false);
        }
        if(monday.isChecked() || tuesday.isChecked() || wednesday.isChecked() ||
                thursday.isChecked() || friday.isChecked() || saturday.isChecked() ||
                sunsday.isChecked()){
            everyDay.setChecked(false);
        }
        if((monday.isChecked() || tuesday.isChecked() || wednesday.isChecked() ||
                thursday.isChecked() || friday.isChecked() || saturday.isChecked() ||
                sunsday.isChecked())&& everyDay.isChecked()){
            monday.setChecked(false);
            tuesday.setChecked(false);
            wednesday.setChecked(false);
            thursday.setChecked(false);
            friday.setChecked(false);
            saturday.setChecked(false);
            sunsday.setChecked(false);
        }
    }


    // отображаем диалоговое окно для выбора времени
    public void setTime(View v) {

        new TimePickerDialog(getActivity(), t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }
    // установка начальных даты и времени
    private void setInitialDateTime() {

        currentDateTime.setText(DateUtils.formatDateTime(getContext(),
                dateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME));
    }

    // установка обработчика выбора времени
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }
    };

    // установка обработчика выбора даты
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
