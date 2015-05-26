package com.example.nbartol.foursquarevenues;

/**
 * Created by nbartol on 26/05/2015.
 */
public class VenueResponse<T> {
    public Venue venue;

    @Override
    public String toString() {
        return "VenueResponse(venue="+venue+")";
    }
}
