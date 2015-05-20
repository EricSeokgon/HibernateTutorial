package hadeslee.crud;

import com.hadeslee.crud.Member;
import com.hadeslee.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static org.junit.Assert.assertEquals;

/**
 * Project: HibernateTutorial
 * FileName: Member
 * Date: 2015-05-20
 * Time: 오후 3:03
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */

public class MemberTest {

    SessionFactory factory = HibernateUtil.getSessionFactory();

    @Test
    public void test() {
        System.out.println("삽입 작업");

        //Insert
        String hadeslee = "hadeslee";
        String message = "hello world";
        Member member = new Member(hadeslee, message);
        insert(member);

        //Select One
        Member selectedMember = selectById(1);
        assertEquals(hadeslee, selectedMember.getMessage());

        assertEquals(1, 1);
    }

    private Member selectById(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Member selectedMember = (Member) session.get(Member.class, id);
        session.getTransaction().commit();
        return selectedMember;

    }

    private void insert(Member member) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(member);
        session.getTransaction().commit();
    }

}