package hadeslee.main;

import com.hadeslee.crud.Member;
import com.hadeslee.main.BoardArticle;
import com.hadeslee.util.DaoCommon;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

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
    DaoCommon<BoardArticle> daoBoard = new DaoCommon<BoardArticle>(BoardArticle.class);
    DaoCommon<Member> daomember = new DaoCommon<Member>(Member.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void test() {

        BoardArticle boardArticle = new BoardArticle(hadeslee, "hello", new Date());
        daoBoard.insert(boardArticle);

        BoardArticle getBoardArticle = daoBoard.selectById(1);
        assertEquals(hadeslee, getBoardArticle.getUserId());
    }

}
