/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Student extends Person {
    private String academic_year;
    private int total_Degreelastyears;
    private int class_no;
    private int gradeof_arabic=0;
    private int gradeof_english=0;
    private int gradeof_history=0;
    private int gradeof_social=0;
    private int gradeof_science=0;
    private int gradeof_math=0;
    public Student(){}
    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }
    public void setTotal_Degreelastyears(int total_Degreelastyears) {
        this.total_Degreelastyears = total_Degreelastyears;
}
    public void setClass_no(int class_no) {
       this.class_no = class_no;
    }
    public void setGradeof_arabic(int gradeof_arabic) {
 
       this.gradeof_arabic = gradeof_arabic;
    
}  
    public void setGradeof_english(int gradeof_english) {
  
      this.gradeof_english = gradeof_english;

    }
    public void setGradeof_history(int gradeof_history) {

        this.gradeof_history = gradeof_history;
 
   }
    public void setGradeof_social(int gradeof_social) {

        this.gradeof_social = gradeof_social;

    }
    public void setGradeof_science(int gradeof_science) {
   
     this.gradeof_science = gradeof_science;
 
   }
    public void setGradeof_math(int gradeof_math) {

        this.gradeof_math = gradeof_math;
  
  }
    public String getAcademic_year() {
    
    return academic_year;
  
  }
    public int getTotal_Degreelastyears() {
    
    return total_Degreelastyears;
   
 }
    public int getClass_no() {
  
      return class_no;
 
   }
    public int getGradeof_arabic() {
     
   return gradeof_arabic;

    }  
    public int getGradeof_english() {
 
       return gradeof_english;
    
}
    public int getGradeof_history() {
 
       return gradeof_history;
    
}
    public int getGradeof_social() {
   
     return gradeof_social;
    
}
    public int getGradeof_science() {
      return gradeof_science; 
 }
    public int getGradeof_math() {
    return gradeof_math;
    }
    public Student( int id, String name, int age,String academic_year, int class_no) {
        super(id, name, age);
        this.academic_year = academic_year;
        this.class_no = class_no;
 } 
    @Override
    public void Add() {
 
 try{
Connection con=getConnection();
PreparedStatement Add ; 
String URL=" ";
if(academic_year.equals("Frist Year")) {
if(class_no==1)
    URL="insert into Student1 values(?,?,?,?,?,?,?,?,?,?,?,?)";
else if(class_no==2)
     URL="insert into Student2 values(?,?,?,?,?,?,?,?,?,?,?,?)";
    }
     if(academic_year.equals("Scound Year")) {
          if(class_no==1)
   URL="insert into Student3 values(?,?,?,?,?,?,?,?,?,?,?,?)";
    else if(class_no==2)
     URL="insert into Student4 values(?,?,?,?,?,?,?,?,?,?,?,?)";
     }
Add= con.prepareStatement(URL);
Add.setInt(1,super.getId());
Add.setString(2, super.getName());
Add.setInt(3, super.getAge());
Add.setString(4,academic_year);
Add.setInt(5, total_Degreelastyears);
Add.setInt(6, gradeof_arabic);
Add.setInt(7, gradeof_english);
Add.setInt(8, gradeof_history);
Add.setInt(9, gradeof_social);
Add.setInt(10, gradeof_science);
Add.setInt(11, gradeof_math);
Add.setInt(12, class_no);
Add.executeUpdate();
           }
 catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,  ex.getMessage());
           }
 }
    @Override
    public ArrayList Display(){ 
        ArrayList<Student> arr=new ArrayList<>();
  try{
Connection con=getConnection();
PreparedStatement sel=con.prepareStatement("select * from Student1");
if(academic_year.equals("Frist Year")) {
if(class_no==1)
    sel = con.prepareStatement("select *  from Student1 ");
if(class_no==2)
     sel = con.prepareStatement("select *  from Student2 ");
    }
     if(academic_year.equals("Scound Year")) {
if(class_no==1)
    sel= con.prepareStatement("select *  from Student3 ");
if(class_no==2)
     sel = con.prepareStatement("select *  from Student4 ");
     }
ResultSet res=sel.executeQuery();
   while(res.next()){
Student st =new Student(res.getInt(1),res.getString(2),res.getInt(3),res.getString(4),res.getInt(12));
st.setGradeof_arabic(res.getInt(6));
st.setTotal_Degreelastyears(res.getInt(5));
st.setGradeof_english(res.getInt(6));
st.setGradeof_history(res.getInt(8));
st.setGradeof_math(res.getInt(11));
st.setGradeof_science(res.getInt(10));
st.setGradeof_social(res.getInt(9));
arr.add(st);
   }
              sel.executeUpdate();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,  ex.getMessage());
           }
   return arr;
   }
      @Override
    public void Edit(){
 try{
Connection con=getConnection();
PreparedStatement Add ; 
String URL=" ";
if(academic_year.equals("Frist Year")) {
          if(class_no==1)
    URL="UPDATE Student1 SET Name=?,age=?,academic_year=?,total_Degreelastyears=?,gradeof_arabic=?,gradeof_english=?,gradeof_history=?,gradeof_social=?,gradeof_science=?,gradeof_math=?,Id_class=? where Id_student=?";
     else if(class_no==2)
    URL="UPDATE Student2 SET Name=?,age=?,academic_year=?,total_Degreelastyears=?,gradeof_arabic=?,gradeof_english=?,gradeof_history=?,gradeof_social=?,gradeof_science=?,gradeof_math=?,Id_class=? where Id_student=?";
}
     if(academic_year.equals("Scound Year")) {
          if(class_no==1)
     URL="UPDATE Student3 SET Name=?,age=?,academic_year=?,total_Degreelastyears=?,gradeof_arabic=?,gradeof_english=?,gradeof_history=?,gradeof_social=?,gradeof_science=?,gradeof_math=?,Id_class=? where Id_student=?";
     else if(class_no==2)
     URL="UPDATE Student4 SET Name=?,age=?,academic_year=?,total_Degreelastyears=?,gradeof_arabic=?,gradeof_english=?,gradeof_history=?,gradeof_social=?,gradeof_science=?,gradeof_math=?,Id_class=? where Id_student=?";
 }
//URL="UPDATE Student4 SET Name=?,age=?,academic_year=?,total_Degreelastyears=?,gradeof_arabic=?,gradeof_english=?,gradeof_history=?,gradeof_social=?,gradeof_science=?,gradeof_math=?,Id_class=? where Id_student=?";
Add= con.prepareStatement(URL);
Add.setString(1, super.getName());
Add.setInt(2, super.getAge());
Add.setString(3,(String)academic_year);
Add.setInt(4, total_Degreelastyears);
Add.setInt(5, gradeof_arabic);
Add.setInt(6, gradeof_english);
Add.setInt(7, gradeof_history);
Add.setInt(8, gradeof_social);
Add.setInt(9, gradeof_science);
Add.setInt(10, gradeof_math);
Add.setInt(11, class_no);
Add.setInt(12,super.getId());
Add.executeUpdate();
           }
 catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,  ex.getMessage());
           }
 }
    @Override
    public void Remove(){
   try{
Connection con=getConnection();
PreparedStatement sel=con.prepareStatement("DELETE  from Student1 where Id_student=?");
if(academic_year.equals("Frist Year")) {
if(class_no==1)
    sel = con.prepareStatement("DELETE  from Student1 where Id_student=?");
if(class_no==2)
     sel = con.prepareStatement("DELETE  from Student2 where Id_student=?");
    }
     if(academic_year.equals("Scound Year")) {
if(class_no==1)
    sel= con.prepareStatement("DELETE  from Student3 where Id_student=?");
if(class_no==2)
     sel = con.prepareStatement("DELETE  from Student4 where Id_student=?");
     }
sel.setInt(1,super.getId());
              sel.executeUpdate();
       JOptionPane.showMessageDialog(null, "Data Deleted");
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,  ex.getMessage());
           }

   
   }
    public Connection getConnection(){
try{
    Connection con=null;
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String conect="jdbc:sqlserver://localhost:1433;databaseName=oopProject;user=sa;password=0123 ";
    try{
        con=DriverManager.getConnection(conect);
       // JOptionPane.showMessageDialog(null, "connected");
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "did not connected");
    }
    return con;
}
catch(ClassNotFoundException ex){
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE,null, ex);
}
        return null;
}     
}









