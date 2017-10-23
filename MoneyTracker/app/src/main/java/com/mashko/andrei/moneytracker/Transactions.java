package com.mashko.andrei.moneytracker;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created by АДМИН on 23.10.2017.
 */
@Table(name = "transactionsestb")
public class Transactions extends Model {

    @Column(name = "title_tr")
    private String title;
    @Column(name = "sum_tr")
    private String sum;
    @Column(name = "date_tr")
    private Date date;

    public Transactions(){
        date = new Date();
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
