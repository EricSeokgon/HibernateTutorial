package chapter01.pojo;

/**
 * Project: HibernateTutorial
 * FileName: Message
 * Date: 2016-01-19
 * Time: 오전 10:20
 * Author: redfo
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class Message {
    String text;
    Integer id;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
