package com.sajjadmohammed.customtoast;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

class ListenersModel {

    private Activity context;
    ListenersModel(Activity context) {
        this.context=context;
    }

    Button.OnClickListener snackButtonListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"Hi",Toast.LENGTH_LONG).show();
        }
    };

    TextWatcher textChangedListener=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!s.toString().equals("")){
                ((MainActivity)context).textFromSnackbar.setText(s);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
