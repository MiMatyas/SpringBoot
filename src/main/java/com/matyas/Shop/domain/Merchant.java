package com.matyas.Shop.domain;

import org.springframework.lang.Nullable;
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
    private Integer houseNumber;
    @NonNull
    private Integer zipcode;

    public Merchant() {
    }

    public Merchant(@NonNull String name, @NonNull String email, @NonNull String city, @NonNull String street, @NonNull Integer houseNumber, @NonNull Integer zipcode) {
        // id se bude tvorit v databazi, ne vzdy ho budeme mit k dispozici pri tvoreni prodejce
        this.name = name;
        this.email = email;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getCity() {
        return city;
    }

    public void setCity(@NonNull String city) {
        this.city = city;
    }

    @NonNull
    public String getStreet() {
        return street;
    }

    public void setStreet(@NonNull String street) {
        this.street = street;
    }

    @NonNull
    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(@NonNull Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    @NonNull
    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(@NonNull Integer zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Merchant merchant = (Merchant) o;
        return Objects.equals(id, merchant.id) && name.equals(merchant.name) && email.equals(merchant.email) && city.equals(merchant.city) && street.equals(merchant.street) && houseNumber.equals(merchant.houseNumber) && zipcode.equals(merchant.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, city, street, houseNumber, zipcode);
    }
}
