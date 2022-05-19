
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcq;
import java.sql.*;
/**
 *
 * @author DIVYA
 */
public class Question3 {

    /** 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con; 
        CallableStatement st;         
        String query;   
       ResultSet rs;        
  try {    
        Class.forName("oracle.jdbc.driver.OracleDriver"); 
         con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr" ,"hr"); 
          int n = 0;         
    query="{call count_student(?)}";            
    st=con.prepareCall(query); 
          // st.setInt(1, n); 
           st.registerOutParameter(1, Types.INTEGER); 
//           rs=st.executeQuery(); 
           st.executeQuery(); 
           n=st.getInt(1); 
           System.out.println("Total no of students are "+n);} 
           catch (ClassNotFoundException ex) { 
            System.out.println(ex.getMessage()); 
        } catch (SQLException ex) { 
            System.out.println(ex.getMessage()); }}       }   
