package com.example.admin.tobuy.models;

import com.orm.SugarRecord;

public class ToBuy extends SugarRecord {

    private String product;
    private int quantity;
    private boolean done;

    public ToBuy() {
    }

    public ToBuy(String product, int quantity, boolean done) {
        this.product = product;
        this.quantity = quantity;
        this.done = done;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
