package com.example.shakil.slidingdrawer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerLayout;
import com.wouterhabets.slidingcontentdrawer.widget.SlidingDrawerToggle;

public class MainActivity extends AppCompatActivity {

    SlidingDrawerLayout drawer;
    SlidingDrawerToggle toggle;

    Toolbar toolbar;

    TextView txtContactUs, txtAirTurnPedal, txtAboutUs, txtLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        toggle = new SlidingDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        drawerMenuClick();
    }

    private void drawerMenuClick() {
        txtContactUs.setOnClickListener(v -> {
            Intent contactIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.contact_us)));
            startActivity(contactIntent);
            if (drawer.isDrawerOpen()) {
                drawer.closeDrawer();
            }
        });

        txtAirTurnPedal.setOnClickListener(v -> {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            //alertDialog.setTitle("Alert Dialog");
            alertDialog.setMessage("To use your AirTurn pedal with Noviscore, just connect it vai Bluetooth.");

            alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            alertDialog.show();
        });

        txtAboutUs.setOnClickListener(v -> {
            Intent aboutIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about_us)));
            startActivity(aboutIntent);
            if (drawer.isDrawerOpen()) {
                drawer.closeDrawer();
            }
        });

        txtLogout.setOnClickListener(v -> {
            /*Intent contactIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.contact_us)));
            startActivity(contactIntent);*/
            if (drawer.isDrawerOpen()) {
                drawer.closeDrawer();
            }
        });

    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (SlidingDrawerLayout) findViewById(R.id.drawer_layout);

        txtContactUs = findViewById(R.id.txtContactUs);
        txtAirTurnPedal = findViewById(R.id.txtAirTurnPedal);
        txtAboutUs = findViewById(R.id.txtAboutUs);
        txtLogout = findViewById(R.id.txtLogout);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}