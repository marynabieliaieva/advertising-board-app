package org.selenium.pom.objects;

public class AdData {
    private String description;
    private String city;
    private String address;
    private String price;

    public AdData(){}

    public AdData(String description, String city, String address, String price){
        this.description = description;
        this.city = city;
        this.address = address;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public AdData setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public AdData setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AdData setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AdData setCity(String city) {
        this.city = city;
        return this;
    }
}
