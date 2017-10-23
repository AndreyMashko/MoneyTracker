package com.mashko.andrei.moneytracker;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by АДМИН on 23.10.2017.
 */
@Table(name = "Categorys")
public class Category extends Model{
    @Column(name = "name_cat", unique = true, index = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
