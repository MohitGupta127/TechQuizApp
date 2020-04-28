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
import mytechapp.pojo.PerformancePojo;
import mytechapp.pojo.StudentScore;

/**
 *
 * @author HP
 */
public class PerformanceDao {
   public static ArrayList<String> getAllStudents()throws SQLException{
    
    String qry="select distinct userid from performance";
    ArrayList<String> studentlist=new ArrayList<>();
    Connection conn=DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery(qry);
    while(rs.next())
    {
    String id=rs.getString(1);
    studentlist.add(id);
    }
    return studentlist;
    }
    
    
    public static ArrayList<String> getAllExamId(String studentid)throws SQLException{
    String qry="select examid from performance where userid=?";
    ArrayList<String> examidlist=new ArrayList<>();
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement(qry);
    ps.setString(1, studentid);
    ResultSet rs=ps.executeQuery();
    while(rs.next()){
    examidlist.add(rs.getString(1));
    }
    
  return examidlist;
    }

   public static StudentScore getScore(String studentid,String examid)throws SQLException{
   String qry="select language,per from performance where userid=? and examid=?";
   Connection conn=DBConnection.getConnection();
   PreparedStatement ps=conn.prepareStatement(qry);
   ps.setString(1,studentid);
   ps.setString(2,examid);
   ResultSet rs=ps.executeQuery();
   rs.next();
   StudentScore scoreObj=new StudentScore();
   scoreObj.setLanguage(rs.getString(1));
   scoreObj.setPer(rs.getDouble(2));
   return scoreObj;
   }
   public static void addPerformance(PerformancePojo performance)throws SQLException{
   String qry="Insert into performance values(?,?,?,?,?,?,?)";
   Connection conn=DBConnection.getConnection();
   PreparedStatement ps=conn.prepareStatement(qry);
   ps.setString(1,performance.getUserid());
   ps.setString(2,performance.getExamid());
   ps.setInt(3,performance.getRight());
   ps.setInt(4,performance.getWrong());
   ps.setInt(5,performance.getUnattempted());
   ps.setDouble(6,performance.getPer());
   ps.setString(7,performance.getLanguage());
   ps.executeUpdate();
   }
   
   public static ArrayList<PerformancePojo> getAllData()throws SQLException{
       String qry="select * from performance";
       ArrayList<PerformancePojo> performancelist=new ArrayList<>();
       Connection conn=DBConnection.getConnection();
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery(qry);
       while(rs.next()){
           String userid=rs.getString("userid");
           String examid=rs.getString("examid");
           int right=rs.getInt("right");
           int wrong=rs.getInt("wrong");
           int unattempted=rs.getInt("unattempted");
           double percentage=rs.getDouble("per");
           String language=rs.getString("language");
           PerformancePojo p=new PerformancePojo(examid,language,userid,right,wrong,unattempted,percentage);
           performancelist.add(p);
           
       }
   return performancelist;
   
   
   }
 
 
}
