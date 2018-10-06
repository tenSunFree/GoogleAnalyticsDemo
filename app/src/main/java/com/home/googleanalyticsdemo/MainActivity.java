package com.home.googleanalyticsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {

    private Tracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obtainTheSharedTrackerInstance();
    }

    private void obtainTheSharedTrackerInstance() {
        GADApplication application = (GADApplication) getApplication();
        tracker = application.getDefaultTracker();
    }

    @Override
    protected void onResume() {
        super.onResume();

        tracker.setScreenName("GoogleAnalyticsDemo, MainActivity");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
