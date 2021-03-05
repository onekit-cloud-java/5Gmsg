package com.msg5g.maap.request;

import java.util.List;
@SuppressWarnings("unused")
public class ChatBotInfoRequest {
    private String serviceDescription;
    private List<String> category;
    private String callBackNumber;
    private String provider;
    private double longitude;
    private double latitude;
    private String themeColour;
    private String serviceWebsite;
    private String emailAddress;
    private String backgroundImage;
    private String address;
    private String cssStyle;


    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getCallBackNumber() {
        return callBackNumber;
    }

    public void setCallBackNumber(String callBackNumber) {
        this.callBackNumber = callBackNumber;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getThemeColour() {
        return themeColour;
    }

    public void setThemeColour(String themeColour) {
        this.themeColour = themeColour;
    }

    public String getServiceWebsite() {
        return serviceWebsite;
    }

    public void setServiceWebsite(String serviceWebsite) {
        this.serviceWebsite = serviceWebsite;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }
}
