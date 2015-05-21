package com.hadeslee.paging;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
/**
 * Project: HibernateTutorial
 * FileName: FileReader_CVS
 * Date: 2015-05-21
 * Time: 오후 4:14
 * Author: Hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class FileReader_CVS {
    public static List<BoardArticle> getArticles() throws NumberFormatException, IOException, ParseException{
        BoardArticle boardArticle=null;
        StringTokenizer tokenizer;
        SimpleDateFormat transFormat = new SimpleDateFormat("MM/dd/yyyy");
        int id;
        String userId;
        String contents;
        Date dateWrite;

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/dbsample.csv"));
        ArrayList<BoardArticle> list = new ArrayList<BoardArticle>();
        String s;

        while((s=br.readLine())!=null){
            tokenizer = new StringTokenizer(s, ",");
            while(tokenizer.hasMoreElements()){
                id=Integer.parseInt(tokenizer.nextToken());
                userId = tokenizer.nextToken();
                contents=tokenizer.nextToken();
                dateWrite = transFormat.parse(tokenizer.nextToken());
                boardArticle = new BoardArticle(id, userId, contents, dateWrite);
                list.add(boardArticle);
            }
        }
        br.close();
        return list;
    }
}
