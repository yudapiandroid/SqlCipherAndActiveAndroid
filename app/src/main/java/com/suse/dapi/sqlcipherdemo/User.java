package com.suse.dapi.sqlcipherdemo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Administrator on 2018/1/4.
 */

@Table(name = "user")
public class User extends Model {

    @Column(name = "name")
    private String name;


    @Column(name = "number")
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
