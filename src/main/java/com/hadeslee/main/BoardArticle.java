package com.hadeslee.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Project: HibernateTutorial
 * FileName: BoardArticle
 * Date: 2015-05-20
 * Time: 오후 4:12
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class BoardArticle {

    @Id
    @GeneratedValue
    private int id;
    private String userId;
    private String message;
    private Date dateWrite;

    public BoardArticle(String userId, String message, Date dateWrite) {
        this.userId = userId;
        this.message = message;
        this.dateWrite = dateWrite;
    }

    public BoardArticle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateWrite() {
        return dateWrite;
    }

    public void setDateWrite(Date dateWrite) {
        this.dateWrite = dateWrite;
    }

    @Override
    public String toString() {
        return "BoardArticle{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", message='" + message + '\'' +
                ", dateWrite=" + dateWrite +
                '}';
    }
}
