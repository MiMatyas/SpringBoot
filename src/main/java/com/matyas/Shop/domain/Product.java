package com.matyas.Shop.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public class Product {
    @Nullable
    private Integer id;
    @NonNull
    private int merchantId;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private double price;
    @NonNull
    private Timestamp createdAt;
    @NonNull
    private int avilable;

    public Product() {
    }

    public Product(int merchantId, @NonNull String name, @NonNull String description, double price, int avilable) {
        this.merchantId = merchantId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = Timestamp.from(Instant.now());
        this.avilable = avilable;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @NonNull
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getAvilable() {
        return avilable;
    }

    public void setAvilable(int avilable) {
        this.avilable = avilable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return merchantId == product.merchantId && Double.compare(product.price, price) == 0 && avilable == product.avilable && Objects.equals(id, product.id) && name.equals(product.name) && description.equals(product.description) && createdAt.equals(product.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, merchantId, name, description, price, createdAt, avilable);
    }
}