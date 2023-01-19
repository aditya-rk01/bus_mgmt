package com.example.bus_mgmt.passenger;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class passenger {
    @Id
    private int pid;
    private String name;
    private int phno;

    public passenger() {
    }

    public passenger(int pid, String name, int phno) {
        this.pid = pid;
        this.name = name;
        this.phno = phno;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhno() {
        return phno;
    }

    public void setPhno(int phno) {
        this.phno = phno;
    }
}
