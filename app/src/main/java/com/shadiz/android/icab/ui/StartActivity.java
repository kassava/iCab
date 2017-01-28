package com.shadiz.android.icab.ui;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.shadiz.android.icab.R;
import com.shadiz.android.icab.ui.main.views.MainFragment;

public class StartActivity extends AppCompatActivity {

    private Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        if (savedInstanceState == null) {
            // first creation of activity - add fragment to container
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fmt_container, new MainFragment());
            transaction.commit();
        }
    }
}
