package com.example.bus_mgmt.ticket;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ticket {
    @Id
    private int tid;
    private int pid;
    private String src;
    private String dest;
    private int bno;
    private int fare;

    public ticket() {
    }

    public ticket(int tid, int pid, String src, String dest, int bno, int fare) {
        this.tid = tid;
        this.pid = pid;
        this.src = src;
        this.dest = dest;
        this.bno = bno;
        this.fare = fare;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}
