package com.example.nbartol.foursquarevenues;

/**
 * Created by nbartol on 26/05/2015.
 */
public class Venue {
    public String name;

    public String url;

    public FoursquarePhoto bestPhoto;

    @Override
    public String toString() {
        return "Venue(name="+name+", photo= "+bestPhoto+")";
    }
}
