package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.Objects;

public class Configuration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuration_activity);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();

    }

    @Override
    public void onResume(){
        super.onResume();

        // Go back to the previous activity
        ImageView goBack = findViewById(R.id.fromConfigToMain);
        goBack.setOnClickListener(v -> finish());

        // Buy the premium version
        LinearLayout buyPremium = findViewById(R.id.linearLayout1);
        buyPremium.setOnClickListener(v -> {
            final String appPackageName = "com.robtopx.geometryjump";
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
        });

        // Review the application
        LinearLayout rateTheApp = findViewById(R.id.linearLayout2);
        rateTheApp.setOnClickListener(v -> {
            final String appPackageName = "com.robtopx.geometryjump";
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
        });

        // Report any bugs that were found
        LinearLayout report = findViewById(R.id.linearLayout3);
        report.setOnClickListener(v -> {
            Intent send = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","fernandohcab@gmail.com", null));
            send.putExtra(Intent.EXTRA_SUBJECT, "Bug found");
            startActivity(Intent.createChooser(send, "Send email"));
        });
    }

}