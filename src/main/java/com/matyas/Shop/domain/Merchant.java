package com.matyas.Shop.domain;

import jakarta.annotation.Nullable;
import org.springframework.lang.NonNull;

import java.util.Objects;

public class Merchant {
    @Nullable //rika Springu ze parametr muze byt null
    private Integer id;
    @NonNull //rika Springu ze parametr nemuze byt null
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

    public Merchant() {
    }

    public Merchant(String name, String email, String city, String street, int houseNumber, int zipcode) {
        // id se bude tvorit v databazi, ne vzdy ho budeme mit k dispozici pri tvoreni prodejce
        this.name = name;
        this.email = email;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Merchant merchant = (Merchant) o;
        return houseNumber == merchant.houseNumber && zipcode == merchant.zipcode && Objects.equals(id, merchant.id) && Objects.equals(name, merchant.name) && Objects.equals(email, merchant.email) && Objects.equals(city, merchant.city) && Objects.equals(street, merchant.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, city, street, houseNumber, zipcode);
    }
}
