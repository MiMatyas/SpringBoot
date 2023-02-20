package com.matyas.Shop.domain;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

public class BoughtProduct {
    private int productId;
    private int customerId;
    private int quantity;
    private Timestamp boughtAd;

    public BoughtProduct(int productId, int customerId, int quantity) {
        this.productId = productId;
        this.customerId = customerId;
        this.quantity = quantity;
        this.boughtAd = Timestamp.from(Instant.now());
    }

    public BoughtProduct() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoughtProduct that = (BoughtProduct) o;
        return productId == that.productId && customerId == that.customerId && quantity == that.quantity && Objects.equals(boughtAd, that.boughtAd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, customerId, quantity, boughtAd);
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getBoughtAd() {
        return boughtAd;
    }

    public void setBoughtAd(Timestamp boughtAd) {
        this.boughtAd = boughtAd;
    }
}
