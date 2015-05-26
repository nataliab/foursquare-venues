package com.example.nbartol.foursquarevenues;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by nbartol on 26/05/2015.
 */
public interface FoursquareApi {
    @GET("/venues/{id}")
    void getVenues(
            @Query("client_id") String clientId,
            @Query("client_secret") String clientSecret,
            @Query("v") String version,
            @Path("id") String venueId,
            Callback<FoursquareResponseWrapper<Venue>> callback);
}
