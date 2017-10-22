package com.mashko.andrei.moneytracker;

import java.util.Date;

/**
 * Created by АДМИН on 22.10.2017.
 */

public class Transactions {
    private String title;
    private Integer sum;
    private Date date;

    public Transactions(String title, Date date, Integer sum) {
        this.title = title;
        this.sum = sum;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public Integer getSum() {
        return sum;
    }

    public Date getDate() {
        return date;
    }
}
