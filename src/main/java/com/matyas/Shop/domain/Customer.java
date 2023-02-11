package com.matyas.Shop.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class Customer {

    @Nullable  //rika Springu ze parametr muze byt null
    private Integer id;
    @NonNull  //rika Springu ze parametr nemuze byt null
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
    private Integer phone;

    public Customer() {
    }

    public Customer(@NonNull String name, @NonNull String surname, @NonNull String email, @NonNull String city, @NonNull String street, @NonNull Integer houseNumber, @NonNull Integer zipcode, @Nullable Integer age,@Nullable Integer phone) {
        // id se bude tvorit v databazi, ne vzdy ho budeme mit k dispozici pri tvoreni zakaznika
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return phone == customer.phone && Objects.equals(id, customer.id) && name.equals(customer.name) && surname.equals(customer.surname) && email.equals(customer.email) && city.equals(customer.city) && street.equals(customer.street) && houseNumber.equals(customer.houseNumber) && zipcode.equals(customer.zipcode) && Objects.equals(age, customer.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, city, street, houseNumber, zipcode, age, phone);
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
    public String getSurname() {
        return surname;
    }

    public void setSurname(@NonNull String surname) {
        this.surname = surname;
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

    @Nullable
    public Integer getAge() {
        return age;
    }

    public void setAge(@Nullable Integer age) {
        this.age = age;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(@Nullable Integer phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", zipcode=" + zipcode +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }
}
