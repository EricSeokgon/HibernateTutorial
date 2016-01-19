package chapter01.pojo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: HibernateTutorial
 * FileName: readMessageTest
 * Date: 2016-01-19
 * Time: 오전 10:33
 * Author: redfo
 * Note:
 * To change this template use File | Settings | File Templates.
 */
@Test(dependOnMethods = "saveMessage")
public class readMessageTest {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    List<Message> list = new ArrayList<>();
    try

    {
        connection = DriverManager.getConnection("jdbc:hsqldb:db1;shutdown=true");
        ps = connection.prepareStatement("SELECT id, text FROM messages ");

        rs = ps.executeQuery();
        while (rs.next()) {
            Message message = new Message();
            message.setId(rs.getLong(1));
        }
    }

}