package com.jquispeluyo.micrometer.Cassandra;


import org.springframework.data.cassandra.core.mapping.PrimaryKey;


public class Usu {

    @PrimaryKey
    private String user_id ;
    private String fname ;
    private String lname;


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
