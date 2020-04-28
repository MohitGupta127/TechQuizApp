/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytechapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mytechapp.dbutil.DBConnection;
import mytechapp.pojo.QuestionPojo;
import mytechapp.pojo.QuestionStore;

/**
 *
 * @author HP
 */
public class QuestionDao {
    public static void addQuestions(QuestionStore qstore)throws SQLException
    {
       String qry=("insert into questions values(?,?,?,?,?,?,?,?,?)");
       ArrayList<QuestionPojo> questionList=qstore.getAllQuestions();
       
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement(qry);
       for(QuestionPojo obj:questionList)
       {
           ps.setString(1,obj.getExamid());
          ps.setInt(2,obj.getQno());
            ps.setString(9,obj.getLanguage());
           ps.setString(4,obj.getAnswer1());
          ps.setString(5,obj.getAnswer2());
           ps.setString(6,obj.getAnswer3());
           ps.setString(7,obj.getAnswer4());
          ps.setString(8,obj.getCorrectAnswer());
           ps.setString(3,obj.getQuestion());
ps.executeUpdate();
        }
       
       
    }
    public static void updateQuestion(QuestionStore qstore)throws SQLException{
    String qry="update questions set answer1=?,answer2=?,answer3=?,answer4=?,correctanswer=?,question=? where examid=? and qno=?";
    ArrayList<QuestionPojo> questionlist=qstore.getAllQuestions();
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement(qry);
    for(QuestionPojo x:questionlist)
        {  
        ps.setString(1,x.getAnswer1());
        ps.setString(2,x.getAnswer2());
        ps.setString(3,x.getAnswer3());
        ps.setString(4,x.getAnswer4());
        ps.setString(5,x.getCorrectAnswer());
        ps.setString(6,x.getQuestion());
        ps.setString(7,x.getExamid());
        ps.setInt(8,x.getQno());
        ps.executeUpdate();
        }
    
    
    
    
    
    }
    public static ArrayList<QuestionPojo> getQuestionByExamId(String examid)throws SQLException{
        String qry="Select * from questions where examid=? order by qno asc";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,examid);
        ResultSet rs=ps.executeQuery();
        ArrayList<QuestionPojo> questionlist=new ArrayList<>();
        while(rs.next())
        {
        int qno=rs.getInt(2);
        String question=rs.getString(3);
        String option1=rs.getString(4);
        String option2=rs.getString(5);
        String option3=rs.getString(6);
        String option4=rs.getString(7);
        String correctanswer=rs.getString(8);
        String language=rs.getString(9);
        QuestionPojo  q=new QuestionPojo(examid,qno,language,option1,option2,option3,option4,correctanswer,question);
        questionlist.add(q);
        }
    return questionlist;
    }
}
