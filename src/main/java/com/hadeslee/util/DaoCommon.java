package com.hadeslee.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Project: HibernateTutorial
 * FileName: DaoCommon
 * Date: 2015-05-20
 * Time: 오후 4:07
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class DaoCommon<T> {


    private SessionFactory factory;
    private Class clazz;
    private String boardName;
    private static int numPerPage = 10;


    public DaoCommon(Class<?> clazz) {
        factory = HibernateTestUtil.getSessionFactory(clazz);
        this.clazz = clazz;
        this.boardName = clazz.getSimpleName();
    }


    public List<?> getPagingList(int requestPage) {
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query query = (Query) session.createQuery("from " + boardName + " order by id asc");

        query.setFirstResult((requestPage - 1) * numPerPage);
        query.setMaxResults(numPerPage);

        List<?> members = query.list();
        tx.commit();
        return members;
    }

    public List<?> selectList() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from " + boardName);

        List<?> list = query.list();
        session.getTransaction().commit();
        return list;
    }

    public void delete(T member) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.delete(member);
        session.getTransaction().commit();
    }

    public void update(T selectedMember) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.update(selectedMember);
        session.getTransaction().commit();
    }

    public T selectById(int id) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        T member = (T) session.get(clazz, id);
        session.getTransaction().commit();
        return member;
    }

    public void insert(T member) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(member);
        session.getTransaction().commit();
    }

}