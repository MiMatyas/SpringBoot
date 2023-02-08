package com.matyas.Shop.db.service.api.request;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class UpdateMerchantRequest {
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String city;
    @NonNull
    private String street;
    @NonNull
    private int houseNumber;
    @NonNull
    private int zipcode;


    public UpdateMerchantRequest(@NonNull String name, @NonNull String email, @NonNull String city, @NonNull String street, int houseNumber, int zipcode) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    @NonNull
    public String getCity() {
        return city;
    }

    @NonNull
    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getZipcode() {
        return zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateMerchantRequest that = (UpdateMerchantRequest) o;
        return houseNumber == that.houseNumber && zipcode == that.zipcode && name.equals(that.name) && email.equals(that.email) && city.equals(that.city) && street.equals(that.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, city, street, houseNumber, zipcode);
    }
}
