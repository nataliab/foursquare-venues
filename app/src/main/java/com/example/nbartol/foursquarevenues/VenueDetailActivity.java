package com.example.nbartol.foursquarevenues;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;
import hugo.weaving.DebugLog;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class VenueDetailActivity extends Activity {

    @InjectView(R.id.details_image)
    ImageView detailImage;
    @InjectView(R.id.details_venue_name)
    TextView venueTitle;
    @InjectView(R.id.details_open_in_browser_button)
    Button openInBrowser;

    private FoursquareApi foursquareApi;


    @DebugLog
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_detail);
        ButterKnife.inject(this);
        //initButtons();
        //initImage();
        initRestAdapter();
    }

    private void initRestAdapter() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.foursquare.com/v2/")
                .build();
        foursquareApi = restAdapter.create(FoursquareApi.class);
    }

    private void initImage() {
        Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(detailImage);
    }

    @DebugLog
    @Override
    protected void onStart() {
        super.onStart();
    }

    @DebugLog
    @Override
    protected void onResume() {
        super.onResume();
        foursquareApi.getVenues(ApiConstants.CLIENT_ID, ApiConstants.CLIENT_SECRET, ApiConstants.VERSION_DATE, "4c2b5abe355cef3bdd3fcd56", getVenueCallback());
    }

    private Callback<FoursquareResponseWrapper<Venue>> getVenueCallback() {
        return new Callback<FoursquareResponseWrapper<Venue>>() {
            @DebugLog
            @Override
            public void success(final FoursquareResponseWrapper<Venue> venueFoursquareResponseWrapper, Response response) {
                FoursquarePhoto photo = venueFoursquareResponseWrapper.response.venue.bestPhoto;
                Picasso.with(VenueDetailActivity.this).load(photo.url()).into(detailImage);
                venueTitle.setText(venueFoursquareResponseWrapper.response.venue.name);
                openInBrowser.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(venueFoursquareResponseWrapper.response.venue.url));
                        startActivity(intent);
                    }
                });
            }

            @DebugLog
            @Override
            public void failure(RetrofitError error) {

            }
        };
    }

    @DebugLog
    @Override
    protected void onStop() {
        super.onStop();
    }

    @DebugLog
    @Override
    protected void onPause() {
        super.onPause();
    }

    @DebugLog
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initButtons() {
        openInBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.gilt.com"));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_venue_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
