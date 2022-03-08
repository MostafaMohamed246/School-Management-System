/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.app;
import java.util.*;
import java.sql.*;
import static java.util.Arrays.sort;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
    public  class Teacher extends Person {
    private String Graduation_Degree;
    private int Salary;
    private String Graduation_Year;
    private int Years_oF_Experince;
    private String Sudject_He_Teaches;
    public String pass;
    public final String maneger_usernamr="admin";
   public final String maneger_Password="admin";
    public String Supervisor="";
   public Student st;
    private int class_no;
    public int getClass_no() {
        return class_no;
    }
    public void setClass_no(int class_no) {
        this.class_no = class_no;
    }
    public Teacher(){ }
    public Teacher(int id,String N,int age,String Graduation_Degree,int Salary,String Graduation_Year,int Years_oF_ExperincYears,String Sudject_He_Teaches){
super(id,N,age);
this.Graduation_Degree=Graduation_Degree;
this.Salary=Salary;
this.Graduation_Year=Graduation_Year;
this.Years_oF_Experince= Years_oF_ExperincYears;
this. Sudject_He_Teaches= Sudject_He_Teaches;

}
    public Connection getConnection(){
try{
    Connection con=null;
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String conect="jdbc:sqlserver://localhost:1433;databaseName=oopProject;user=sa;password=0123 ";
    try{
        con=DriverManager.getConnection(conect);
     //   JOptionPane.showMessageDialog(null, "connected");
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, "did not connected");
    }
    return con;
}
catch(ClassNotFoundException ex){
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE,null, ex);
}
        return null;
}
    public  Connection con = getConnection();
    public String getGraduation_Degree() {
        return Graduation_Degree;
    }
    public double getSalary() {
        return Salary;
    }
    public String getGraduation_Year() {
        return Graduation_Year;
    }
    public String getSudject_He_Teaches() {
        return Sudject_He_Teaches;
    }
    public int getYears_oF_Experince() {
        return Years_oF_Experince;
    }
    public void setGraduation_Degree(String Graduation_Degree) {
        this.Graduation_Degree = Graduation_Degree;
    }
    public void setGraduation_Year(String Graduation_Year) {
        this.Graduation_Year = Graduation_Year;
    }
    public void setSalary(int Salary) {
        this.Salary = Salary;
    }
    public void setSudject_He_Teaches(String Sudject_He_Teaches) {
        this.Sudject_He_Teaches = Sudject_He_Teaches;
    }
    public void setYears_oF_Experince(int Years_oF_Experince) {
        this.Years_oF_Experince = Years_oF_Experince;
    }
    @Override
    public void Add() {
try{

PreparedStatement Add=con.prepareStatement("insert into teacher values(?,?,?,?,?,?,?,?,?,?,?)");
Add.setInt(1, super.getId());
Add.setString(2, super.getName());
Add.setInt(3, super.getAge());
Add.setString(4, Graduation_Degree);
Add.setInt(5,Salary);
Add.setString(6, Graduation_Year);
Add.setInt(7,Years_oF_Experince);
Add.setString(8,Sudject_He_Teaches);
Add.setString(9, pass);
Add.setString(10,Supervisor);
Add.setInt(11,class_no);
Add.executeUpdate();
           } 
catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,  ex.getMessage());
           }

    }
    @Override
   public ArrayList<Teacher> Display() { 
    ArrayList<Teacher> arr=new ArrayList<Teacher>();
  try{
PreparedStatement sel=con.prepareStatement("select * from teacher");
ResultSet res=sel.executeQuery();
   while(res.next()){
Teacher te =new Teacher(res.getInt(1),res.getString(2),Integer.valueOf(res.getString(3)),res.getString(4),Integer.valueOf(res.getString(5)),res.getString(6),Integer.valueOf(res.getString(7)),res.getString(8));
//te.pass=res.getString(9);
te.Supervisor=res.getString(10);
te.class_no=res.getInt(11);
arr.add(te);
   }
              sel.executeUpdate();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,  ex.getMessage());
           }
   return arr;    
   }
    @Override
    public void Edit() {
try{
PreparedStatement update=con.prepareStatement("UPDATE teacher SET Name=?,age=?,Graduation_Degree=?,Salary=?,Graduation_Year=?,years_of_experince=?,Sudject=?,Id_class=? where Id_teacher=?");
update.setString(1, super.getName());
update.setInt(2, super.getAge());
update.setString(3, Graduation_Degree);
update.setInt(4,Salary);
update.setString(5, Graduation_Year);
update.setInt(6,Years_oF_Experince);
update.setString(7,Sudject_He_Teaches);
update.setInt(8, class_no);
update.setInt(9, super.getId());
update.executeUpdate();
           } 
catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,  ex.getMessage());
           } 
        
    }
    @Override
public void Remove() {
     try{
PreparedStatement sel=con.prepareStatement("DELETE  from teacher where Id_teacher=?");
sel.setInt(1,super.getId());
              sel.executeUpdate();
       
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,  ex.getMessage());
           }

            }
public boolean login(int i,String s){
      boolean bool =false;
   try{
PreparedStatement sel=con.prepareStatement("select * from teacher where Id_teacher=? and Passwrd=?");
  sel.setInt(1, i);
  sel.setString(2, s);
  
ResultSet res=sel.executeQuery();
   if(res.next()){
   JOptionPane.showMessageDialog(null, " Wellcome Teacher (: ");
   
   bool=true;
   } 
              sel.executeUpdate();           
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,  ex.getMessage());
           }
    return bool;
  } 
public void SoperVisor(){
   ArrayList<Teacher> arr=new ArrayList<Teacher>();
   ArrayList<Teacher> Academic1=new ArrayList<>();
   ArrayList<Teacher> Academic2=new ArrayList<>();
   int max=0;
  

try{
    if(class_no==1||class_no==2){         
PreparedStatement update=con.prepareStatement("update teacher set Supervisor=? where Id_class=? and Sudject=?");
update.setString(1,"" );
update.setInt(2, 1);
update.setString(3,Sudject_He_Teaches );
update.executeUpdate();
PreparedStatement update1=con.prepareStatement("update teacher set Supervisor=? where Id_class=? and Sudject=?");
update1.setString(1,"");
update1.setInt(2, 2);
update1.setString(3,Sudject_He_Teaches );
update1.executeUpdate();
   }
  else if(class_no==3||class_no==4){         
PreparedStatement update2=con.prepareStatement("update teacher set Supervisor=? where Id_class=?");
update2.setString(1,"" );
update2.setInt(2, 3);
update2.executeUpdate();
PreparedStatement update3=con.prepareStatement("update teacher set Supervisor=? where Id_class=?");
update3.setString(1,"");
update3.setInt(2, 4);
update3.executeUpdate();
   }
}
  catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
  if(Supervisor=="super"){
  try{
PreparedStatement update=con.prepareStatement("update teacher set Supervisor=? where Id_teacher=?");
update.setString(1, "Super");
update.setInt(2,super.getId());
update.executeUpdate();
}
  catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  else{
  try{
PreparedStatement sel=con.prepareStatement("select * from teacher where Sudject=? ");
sel.setString(1, Sudject_He_Teaches);
ResultSet res=sel.executeQuery();
   while(res.next()){
Teacher te =new Teacher(res.getInt(1),res.getString(2),Integer.valueOf(res.getString(3)),res.getString(4),Integer.valueOf(res.getString(5)),res.getString(6),Integer.valueOf(res.getString(7)),res.getString(8));
te.setClass_no(res.getInt(11));
te.Supervisor=res.getString(10);
te.pass=res.getString(9);
arr.add(te);
   }
   }    catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
   for(int i=0;i<arr.size();i++){
       if(arr.get(i).getClass_no()==1||arr.get(i).getClass_no()==2){
       Academic1.add(arr.get(i));
       }
       else if(arr.get(i).getClass_no()==3||arr.get(i).getClass_no()==4){
       Academic2.add(arr.get(i));
       }
     }
   
        if(class_no==1||class_no==2){
        for(int i=0;i<Academic1.size();i++){
        if(max<Academic1.get(i).getYears_oF_Experince())
            max=Academic1.get(i).getYears_oF_Experince();
        }
        }
        else{
        for(int i=0;i<Academic2.size();i++){
        if(max<Academic2.get(i).getYears_oF_Experince())
            max=Academic2.get(i).getYears_oF_Experince();
        }}
try{
PreparedStatement update=con.prepareStatement("update teacher set Supervisor=? where years_of_experince=?");
update.setString(1, "Super");
update.setInt(2,max );
update.executeUpdate();
}
  catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
  }  
   }
public Teacher Displaypersonaldetails(int id){
       Teacher te =new Teacher();
  try{
PreparedStatement sel=con.prepareStatement("select * from teacher  where Id_teacher=?");
sel.setInt(1, id);
ResultSet res=sel.executeQuery();
   if(res.next()){
 te =new Teacher(res.getInt(1),res.getString(2),Integer.valueOf(res.getString(3)),res.getString(4),Integer.valueOf(res.getString(5)),res.getString(6),Integer.valueOf(res.getString(7)),res.getString(8));
//te.pass=res.getString(9);
te.Supervisor=res.getString(10);
te.class_no=res.getInt(11);

   }
              sel.executeUpdate();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,  ex.getMessage());
           }
       
   return te;
   }
public ArrayList Set_student_degree(int id,int Id_student ,int Degree){
       String acdmic=" ";
       Teacher te =new Teacher();
te=te.Displaypersonaldetails(id);
    st= new Student();
       ArrayList<Student> st_arr=new ArrayList<>();
      if(te.getClass_no()==1||te.getClass_no()==2){
          acdmic="Frist Year";
      }
      else if(te.getClass_no()==3||te.getClass_no()==4){
          acdmic="Scound Year";
      }   
st.setAcademic_year(acdmic);
st.setClass_no(te.getClass_no());
st_arr=st.Display();
if(te.getClass_no()==1)
     setDegree_class1(te,st_arr,Id_student , Degree);

     else if(te.getClass_no()==2) 
         setDegree_class2(te,st_arr,Id_student , Degree);
else if(te.getClass_no()==3) 
    setDegree_class3(te,st_arr,Id_student , Degree);
else if(te.getClass_no()==4) 
    setDegree_class4(te,st_arr,Id_student , Degree);


   return st_arr; 
   }
public ArrayList<Student>  setDegree_class1(Teacher te,ArrayList<Student> st_arr,int Id_student,int Degree){
        switch (te.getSudject_He_Teaches()) {
            case "Arabic":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_arabic(Degree);
                        st_arr.get(i).Edit();
                    }
                }               break;
            case "English":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_english(Degree);
                        st_arr.get(i).Edit();
                    }
                }               break;
            case "History":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_history(Degree);
                        st_arr.get(i).Edit();
                        
                    }}              break;
            case "Social":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_social(Degree);
                        st_arr.get(i).Edit();}}
                break;
            case "Science":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_science(Degree);
                        st_arr.get(i).Edit();
                    }}              break;
            case "Math":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_math(Degree);
                        st_arr.get(i).Edit();  
                        
                    }}              break;
            default:
                break;
        }
        return st_arr;
}
public ArrayList<Student>  setDegree_class2(Teacher te,ArrayList<Student> st_arr,int Id_student,int Degree){
        switch (te.getSudject_He_Teaches()) {
            case "Arabic":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_arabic(Degree);
                        st_arr.get(i).Edit();
                    }
                }               break;
            case "English":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_english(Degree);
                        st_arr.get(i).Edit();
                    }
                }               break;
            case "History":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_history(Degree);
                        st_arr.get(i).Edit();
                        
                    }}              break;
            case "Social":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_social(Degree);
                        st_arr.get(i).Edit();}}
                break;
            case "Science":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_science(Degree);
                        st_arr.get(i).Edit();
                    }}              break;
            case "Math":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_math(Degree);
                        st_arr.get(i).Edit();  
                        
                    }}              break;
            default:
                break;
        }
        return st_arr;
}
public ArrayList<Student>  setDegree_class3(Teacher te,ArrayList<Student> st_arr,int Id_student,int Degree){
        switch (te.getSudject_He_Teaches()) {
            case "Arabic":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_arabic(Degree);
                        st_arr.get(i).Edit();
                    }
                }               break;
            case "English":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_english(Degree);
                        st_arr.get(i).Edit();
                    }
                }               break;
            case "History":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_history(Degree);
                        st_arr.get(i).Edit();
                        
                    }}              break;
            case "Social":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_social(Degree);
                        st_arr.get(i).Edit();}}
                break;
            case "Science":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_science(Degree);
                        st_arr.get(i).Edit();
                    }}              break;
            case "Math":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_math(Degree);
                        st_arr.get(i).Edit();  
                        
                    }}              break;
            default:
                break;
        }
        return st_arr;
}
public ArrayList<Student>  setDegree_class4(Teacher te,ArrayList<Student> st_arr,int Id_student,int Degree){
        switch (te.getSudject_He_Teaches()) {
            case "Arabic":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_arabic(Degree);
                        st_arr.get(i).Edit();
                    }
                }               break;
            case "English":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_english(Degree);
                        st_arr.get(i).Edit();
                    }
                }               break;
            case "History":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_history(Degree);
                        st_arr.get(i).Edit();
                        
                    }}              break;
            case "Social":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_social(Degree);
                        st_arr.get(i).Edit();}}
                break;
            case "Science":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_science(Degree);
                        st_arr.get(i).Edit();
                    }}              break;
            case "Math":
                for(int i=0;i<st_arr.size();i++){
                    if(st_arr.get(i).getId()==Id_student){
                        st_arr.get(i).setGradeof_math(Degree);
                        st_arr.get(i).Edit();  
                        
                    }}              break;
            default:
                break;
        }
        return st_arr;
}
public boolean CheckTeacher_Class(String Subject,int classnum){ 
   ArrayList <Teacher> ListTeacher =new ArrayList<>();
  try{
      PreparedStatement sel=con.prepareStatement("select * from teacher");
  
ResultSet res=sel.executeQuery();
   while(res.next()){
Teacher te =new Teacher(res.getInt(1),res.getString(2),Integer.valueOf(res.getString(3)),res.getString(4),Integer.valueOf(res.getString(5)),res.getString(6),Integer.valueOf(res.getString(7)),res.getString(8));
te.pass=res.getString(9);
te.Supervisor=res.getString(10);
te.class_no=res.getInt(11);
ListTeacher.add(te);
   } 
   for(int i=0;i<ListTeacher.size();i++){
   if(ListTeacher.get(i).getSudject_He_Teaches().equals(Subject)&&ListTeacher.get(i).getClass_no()==classnum) 
       return false;   
   }
  }
    catch (SQLException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
  return true;
}
    }
  