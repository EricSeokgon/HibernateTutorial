package hadeslee.hql;

import org.junit.Before;
import org.junit.Test;

/**
 * Project: HibernateTutorial
 * FileName: HqlLeaningTest
 * Date: 2015-05-23
 * Time: 오전 2:38
 * Author: hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class HqlLeaningTest {

    @Before
    public void Setup() throws Exception{

    }

    @Test
    public void test() {
        DaoCommon<UserDetail> daoUserDetail = new DaoCommon<UserDetail>(UserDetail.class);

        for(int i=0; i<10;i++){
            daoUserDetail.insert(new UserDetail("User"+i));
        }
        SessionFactory factory = HibernateTestUtil.getSessionFactory(UserDetail.class);
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        //String minUserid= "5 or 1=1";
        //Query query = session.createQuery("from UserDetail where id> "+minUserid);
        /*Query query = session.createQuery("from UserDetail where id> ? and userName = ?");
        String minUserid= "5";
        query.setInteger(0, Integer.parseInt(minUserid));
        query.setString(1, "User9");*/

        String minUserid= "5";
        Query query = session.createQuery("from UserDetail where id> :userId and userName = :userName");
        query.setInteger("userId", Integer.parseInt(minUserid));
        query.setString("userName", "User9");

        List<UserDetail> list = query.list();
        session.getTransaction().commit();

        for (UserDetail userDetail : list) {
            System.out.println(userDetail);
        }
    }

}
