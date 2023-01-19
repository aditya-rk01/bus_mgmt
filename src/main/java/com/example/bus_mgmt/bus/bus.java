package com.example.bus_mgmt.bus;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class bus {
    @Id
    private int number; //bus number
    private String src; //source place
    private String dest; //destination place
    private int capacity; //seating capacity
    private int available; //available seats

    public bus(int number, String src, String dest, int capacity, int available) {
        this.number = number;
        this.src = src;
        this.dest = dest;
        this.capacity = capacity;
        this.available = available;
    }

    public bus() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

}
