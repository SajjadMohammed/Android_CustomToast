package com.sajjadmohammed.customtoast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Toolbar mainToolbar;
    public TextView textFromSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainToolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);
        textFromSnackbar=findViewById(R.id.textFromSnackbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDefaultToast(View view) {
        Toast.makeText(view.getContext(), "Hi I am a default Toast", Toast.LENGTH_LONG).show();
    }

    public void positionedToast(View view) {
        Toast toast = Toast.makeText(view.getContext(), "Hi I am a default Toast", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.show();
    }

    public void customToast(View view) {
        Toast toast = Toast.makeText(view.getContext(), "Hi I am a default Toast", Toast.LENGTH_LONG);
        toast.setView(getLayoutInflater().inflate(R.layout.custom_toast, null));
        toast.show();
    }

    public void defaultSnackbar(View view) {
        Snackbar.make(view, "Hi I am a message from default snackbar", Snackbar.LENGTH_LONG).show();
    }

    public void actionSnackbar(View view) {
        Snackbar snackbar = Snackbar.make(view, "Hi I am a message from default snackbar", Snackbar.LENGTH_INDEFINITE);
//                .setAction("OK", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                    }
//                });
        snackbar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDefaultToast(v);
            }
        });

        snackbar.getView().setBackgroundColor(getResources().getColor( R.color.colorAccent));

        Button actionButton=snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_action);
        actionButton.setTextColor(Color.parseColor("#ffffff"));

        TextView snackText=snackbar.getView().findViewById(com.google.android.material.R.id.snackbar_text);
        snackText.setTextColor(getResources().getColor( R.color.colorPrimary));

        snackbar.show();
    }

    public void customSnackbar(View view) {
        Snackbar snackbar = Snackbar.make(view, "", Snackbar.LENGTH_INDEFINITE);
        ((ViewGroup)snackbar.getView()).removeAllViews();

        View customView=getLayoutInflater().inflate(R.layout.custom_snackbar,null);
        ((ViewGroup)snackbar.getView()).addView(customView);
        snackbar.getView().setBackgroundColor(getResources().getColor( R.color.colorAccent));


        Button snackButton=snackbar.getView().findViewById(R.id.snackButton);
        EditText snackEditText=snackbar.getView().findViewById(R.id.snackEditText);


        ListenersModel listenersModel=new ListenersModel(this);

        snackButton.setOnClickListener(listenersModel.snackButtonListener);
        snackEditText.addTextChangedListener(listenersModel.textChangedListener);

        snackbar.show();
    }
}