package com.example.quesomeesse;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
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
        TextView buyPremium = findViewById(R.id.buyPremium);
        buyPremium.setOnClickListener(v -> {
            final String appPackageName = "com.robtopx.geometryjump";
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
        });

        // Review the application
        TextView rateTheApp = findViewById(R.id.review);
        rateTheApp.setOnClickListener(v -> {
            final String appPackageName = "com.robtopx.geometryjump";
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
            }
        });

        // Change the language of the application
        TextView changeLanguage = findViewById(R.id.changeLanguage);
        changeLanguage.setOnClickListener(v -> {

        });

        // Report any bugs that were found
        TextView report = findViewById(R.id.reportBugs);
        report.setOnClickListener(v -> {
            Intent send = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","fernandohcab@gmail.com", null));
            send.putExtra(Intent.EXTRA_SUBJECT, "Bug found");
            startActivity(Intent.createChooser(send, "Send email"));
        });
    }

}