package com.matyas.Shop.db.service.api.request;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class UpdateCustomerRequest {
    @NonNull
    private String name;
    @NonNull
    private String surname;
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
    @Nullable
    private Integer age;
    @Nullable
    private int phone;

    public UpdateCustomerRequest(@NonNull String name, @NonNull String surname, @NonNull String email, @NonNull String city, @NonNull String street, @NonNull Integer houseNumber, @NonNull Integer zipcode, @Nullable Integer age, int phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipcode = zipcode;
        this.age = age;
        this.phone = phone;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getSurname() {
        return surname;
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

    @NonNull
    public Integer getHouseNumber() {
        return houseNumber;
    }

    @NonNull
    public Integer getZipcode() {
        return zipcode;
    }

    @Nullable
    public Integer getAge() {
        return age;
    }

    public int getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateCustomerRequest that = (UpdateCustomerRequest) o;
        return phone == that.phone && name.equals(that.name) && surname.equals(that.surname) && email.equals(that.email) && city.equals(that.city) && street.equals(that.street) && houseNumber.equals(that.houseNumber) && zipcode.equals(that.zipcode) && Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, city, street, houseNumber, zipcode, age, phone);
    }
}
