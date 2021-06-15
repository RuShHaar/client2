package com.example.client.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class ControllerService {

    public static String getVaccineDate(String name) throws ParseException {
    Integer month = randomMonth();
    Integer day = randomDay(month);
    Integer hour = randomHour();

    return name + ", dein Termin ist am: " + generateDate(month,day,hour);

    }

    public static Date generateDate(Integer month, Integer day, Integer hour) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String dateInString = day +"-" + month + "-"+ "2021 " + hour + ":00:00";
        Date date = sdf.parse(dateInString);
        return date;
    }

    public static Integer randomDay(Integer month) {

        Random random = new Random();
        if (month % 2 != 0 || month == 7) {
            Integer number = random.nextInt(30);
            number += 1;
            return number;
        } else {
            Integer number = random.nextInt(39);
            number += 1;
            return number;
        }
    }

    public static Integer randomMonth() {

        Random random = new Random();
        Integer number = random.nextInt(5);
        number += 7;
        return number;

    }

    public static Integer randomHour() {

        Random random = new Random();
        Integer number = random.nextInt(14);
        number += 6;
        return number;
    }

    public BigDecimal convertCurrency(BigDecimal usd){

        BigDecimal euro = usd.multiply(new BigDecimal(0.8250)).setScale(2, RoundingMode.CEILING);

        return euro;

    }
}

