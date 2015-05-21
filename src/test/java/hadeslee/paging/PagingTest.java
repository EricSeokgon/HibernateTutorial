package hadeslee.paging;

import com.hadeslee.paging.BoardArticle;
import com.hadeslee.paging.FileReader_CVS;
import com.hadeslee.util.DaoCommon;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Project: HibernateTutorial
 * FileName: PagingTest
 * Date: 2015-05-21
 * Time: 오후 4:18
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class PagingTest {
    @Before
    public void serUp() throws Exception {
    }

    @Test
    public void test() throws NumberFormatException, IOException, ParseException {
        DaoCommon<BoardArticle> daoBoard = new DaoCommon<BoardArticle>(BoardArticle.class);
        List<BoardArticle> list = FileReader_CVS.getArticles();
        for (BoardArticle boardArticle : list) {
            daoBoard.insert(boardArticle);
        }

        List<BoardArticle> pagingList1 = (List<BoardArticle>) daoBoard.getPagingList(1);
        System.out.println("첫번째 페이지");
        for (BoardArticle boardArticle : pagingList1) {
            System.out.println(boardArticle);
        }

        List<BoardArticle> pagingList2 = (List<BoardArticle>) daoBoard.getPagingList(2);
        System.out.println("두번째 페이지");
        for (BoardArticle boardArticle : pagingList2) {
            System.out.println(boardArticle);
        }
    }

}
