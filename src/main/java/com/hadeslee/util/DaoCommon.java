package com.hadeslee.util;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Project: HibernateTutorial
 * FileName: DaoCommon
 * Date: 2015-05-20
 * Time: 오후 4:07
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class UserDetail {


    @Id
    @GeneratedValue
    private int id;

    private String userName;

    public UserDetail() {
    }

    public UserDetail(String userName) {
        super();
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserDetail [id=" + id + ", userName=" + userName + "]";
    }
}