package chapter01.pojo;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
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
    try {
        try {
            connection = DriverManager.getConnection("jdbc:hsqldb:db1;shutdown=true");
            ps = connection.prepareStatement("SELECT id, text FROM messages ");
            rs = ps.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            while (rs.next()) {
                Message message = new Message();
                message.setId((int) rs.getLong(1));
                message.setText(rs.getString(2));
                list.add(message);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        if (list.size() > 1) {
            Assert.fail("Message configuration in error; table should contain only one."
                    + " Set ddl to drop-create.");
        }
        if (list.size() == 0) {
            Assert.fail("Read of initial message failed; check saveMessage() for errors."
                    + " How did this test run?");
        }
        for (Message m : list) {
            System.out.println(m);
        }
// eagerly free resources
        try {
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
    catch( SQLException e )  {
        e.printStackTrace();
        throw new RuntimeException(e);
    } finally {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException ignored) {
        }
        try {
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException ignored) {
        }
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ignored) {
        }
    }
}