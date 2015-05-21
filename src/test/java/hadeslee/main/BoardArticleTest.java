package hadeslee.main;

import com.hadeslee.crud.Member;
import com.hadeslee.main.BoardArticle;
import com.hadeslee.main.Comments;
import com.hadeslee.util.DaoCommon;
import com.hadeslee.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Project: HibernateTutorial
 * FileName: BoardArticle
 * Date: 2015-05-20
 * Time: 오후 4:12
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */

public class BoardArticleTest {
    private static final String hadeslee = "hadeslee";
    //SessionFactory factory = HibernateUtil.getSessionFactory();
    DaoCommon<BoardArticle> daoBoard = new DaoCommon<BoardArticle>(BoardArticle.class);
    DaoCommon<Member> daoMember = new DaoCommon<Member>(Member.class);
    DaoCommon<Comments> daoComments = new DaoCommon<Comments>(Comments.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test() {

        BoardArticle boardArticle = new BoardArticle(hadeslee, "hello", new Date());
        daoBoard.insert(boardArticle);
        BoardArticle getBoardArticle = daoBoard.selectById(1);
        assertEquals(hadeslee, getBoardArticle.getUserId());

        daoComments.insert(new Comments("hadeslee","Hello world"));
        assertEquals(hadeslee, getBoardArticle.getUserId());
    }

}
