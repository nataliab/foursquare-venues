package com.example.nbartol.foursquarevenues;

/**
 * Created by nbartol on 26/05/2015.
 */
public class FoursquarePhoto {
    public String prefix;
    public String suffix;
    public int width;
    public int height;

    public String url() {
        return prefix + "width" + width + suffix;
    }

    FoursquarePhoto() {
    }

    @Override
    public String toString() {
        return "FoursquarePhoto(url=" + url() + ")";
    }
}
