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
import java.sql.Statement;
import java.util.ArrayList;
import mytechapp.dbutil.DBConnection;
import mytechapp.pojo.ExamPojo;

/**
 *
 * @author HP
 */
public class ExamDao {
 public static String getExamId() throws SQLException{
    String qry="Select count(*) as totalrows from exam";
    int rowcount=0;
    Connection conn=DBConnection.getConnection();
    Statement s=conn.createStatement();
    ResultSet rs=s.executeQuery(qry);
    if(rs.next())
        rowcount=rs.getInt(1);
    String newId="EX-"+(rowcount+1);
    return newId;
} 
public static boolean addExam(ExamPojo newExam)throws SQLException{
    String qry="insert into exam values(?,?,?)";
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1,newExam.getExamId());
    ps.setString(2,newExam.getLanguage());
    ps.setInt(3,newExam.getTotalQuestions());
    int ans=ps.executeUpdate();
    return ans==1;
}

public static boolean isPaperSet(String subject)throws SQLException{
    String qry="Select examid from Exam where language=?";
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1,subject);
    ResultSet rs=ps.executeQuery();
    return rs.next();
}

public static ArrayList<String> getExamIdByStudent(String userid,String subject)throws SQLException{
String qry="Select examid from exam where language=? minus select examid from performance where userid=?";
ArrayList<String> examlist=new ArrayList();
Connection conn=DBConnection.getConnection();
PreparedStatement ps=conn.prepareStatement(qry);
ps.setString(1,subject);
ps.setString(2,userid);
ResultSet rs=ps.executeQuery();
while(rs.next()){
examlist.add(rs.getString(1));
}
return examlist;

}

public static int getQuestionCountByExam(String examid)throws SQLException{
    String qry="Select total_question from exam where examid=?";
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1,examid);
    ResultSet rs=ps.executeQuery();
    rs.next();
    int rowcount=rs.getInt(1);
    return rowcount;
      

}
}














