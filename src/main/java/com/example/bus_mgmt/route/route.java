package com.example.bus_mgmt.route;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class route {
    @Id
    private int sid;
    private String sname;
    public route() {
    }

    public route(int sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
