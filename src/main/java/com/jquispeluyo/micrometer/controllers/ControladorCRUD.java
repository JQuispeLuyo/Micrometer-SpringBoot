package com.jquispeluyo.micrometer.controllers;

import java.util.ArrayList;
import java.util.List;


import com.jquispeluyo.micrometer.Cassandra.IUsu;
import com.jquispeluyo.micrometer.Cassandra.Usu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/crud")

public class ControladorCRUD {

    @Autowired
    IUsu iUsu;

    @GetMapping("/customers")
    public List<Usu> getAllUsu() {
        System.out.println("Get all Customers...");

        List<Usu> customers = new ArrayList<>();
        iUsu.findAll().forEach(customers::add);
        return customers;
    }


}
