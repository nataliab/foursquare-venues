package com.example.nbartol.foursquarevenues;

/**
 * Created by nbartol on 26/05/2015.
 */
public class FoursquareResponseWrapper<T> {
    public VenueResponse response;

    FoursquareResponseWrapper() {
    }

    @Override
    public String toString() {
        return "FoursquareResponseWrapper(response=" + response + ")";
    }
}
