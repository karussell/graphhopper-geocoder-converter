package com.graphhopper.converter.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Robin Boldt
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenCageDataEntry {

    private String formatted;
    private OCDAnnoations annotations;
    private OCDGeometry geometry;
    private OCDComponents components;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OCDAnnoations {

        public OCDAnnoations() {
        }

        @JsonProperty("OSM")
        public OCDAnnotationOSM osm = new OCDAnnotationOSM();
    }

    public static class OCDAnnotationOSM {

        public OCDAnnotationOSM() {
        }

        @JsonProperty("edit_url")
        public String editUrl;
        public String url;
    }

    public static class OCDGeometry {

        public OCDGeometry() {
        }

        @JsonProperty("lat")
        public double lat;
        @JsonProperty("lng")
        public double lng;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class OCDComponents {

        public OCDComponents() {
        }

        @JsonProperty("country")
        public String country;
        @JsonProperty("country_code")
        public String countryCode;
        @JsonProperty("county")
        public String county;
        @JsonProperty("state")
        public String state;

        @JsonProperty("city")
        public String city;
        @JsonProperty("town")
        public String town;
        @JsonProperty("village")
        public String village;
        @JsonProperty("hamlet")
        public String hamlet;

        public String getGHCity() {
            if (city != null) {
                return city;
            }
            if (town != null) {
                return town;
            }
            if (village != null) {
                return village;
            }
            return hamlet;
        }
    }

    public OpenCageDataEntry() {
    }

    public OpenCageDataEntry(double lat, double lon, String displayName, OCDComponents components) {
        this.formatted = displayName;
        this.geometry = new OCDGeometry();
        this.geometry.lat = lat;
        this.geometry.lng = lon;
        this.components = components;
    }

    @JsonProperty("formatted")
    public String getFormatted() {
        return formatted;
    }

    @JsonProperty("formatted")
    public void setFormatted(String displayName) {
        this.formatted = displayName;
    }

    @JsonProperty("components")
    public OCDComponents getComponents() {
        return components;
    }

    @JsonProperty("components")
    public void setOCDComponents(OCDComponents comp) {
        this.components = comp;
    }

    @JsonProperty("geometry")
    public OCDGeometry getGeometry() {
        return geometry;
    }

    @JsonProperty("geometry")
    public void setGeometry(OCDGeometry geometry) {
        this.geometry = geometry;
    }

    @JsonProperty("annotations")
    public OCDAnnoations getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(OCDAnnoations annotations) {
        this.annotations = annotations;
    }
}
