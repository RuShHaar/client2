package com.example.client.service;

import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;


class ControllerServiceTest {

    @Test
    void getVaccineDate() throws ParseException {

        System.out.println(ControllerService.getVaccineDate("Hans"));
    }
}