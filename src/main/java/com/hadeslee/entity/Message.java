package com.hadeslee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Project: HibernateTutorial
 * FileName: Message
 * Date: 2016-01-19
 * Time: 오전 10:05
 * Author: redfo
 * Note:
 * To change this template use File | Settings | File Templates.
 */

@Entity
public class Message {

    private String messageText;
    private Integer id;

    private Message() {

    }

    public Message(String messageText) {
        this.messageText = messageText;

    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
