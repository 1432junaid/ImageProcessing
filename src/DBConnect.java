
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author concept
 */
public class DBConnect {
    
 private    PreparedStatement pst;
 private    Connection conn;
 private    ResultSet rs;
 private    Statement st;
    
    DBConnect() throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/imageprocessing","root","");
     
    }    
    
    public void setData(String name,int size) 
    {
        try{
        String query="insert into image (name , size) values (? ,?)";
        pst= conn.prepareStatement(query);
      pst.setString(1, name);
      pst.setInt(2, size);
      
      pst.executeUpdate();
    
        }catch(SQLException ex){System.err.println(""+ex);}
    }
    
    public void setDataGS(String name,int size) 
    {
        try{
        String query="insert into greyscale (name , size) values (? ,?)";
        pst= conn.prepareStatement(query);
      pst.setString(1, name);
      pst.setInt(2, size);
      
      pst.executeUpdate();
    
        }catch(SQLException ex){System.err.println(""+ex);}
    }
    
     public ResultSet getData()
     {
         try{
       st=conn.createStatement();
       rs = st.executeQuery("select * from image");
       rs=st.getResultSet();
         }catch(SQLException ex){System.err.println(""+ex);}
     
         return rs;
     }
    public ResultSet getDataGS()
     {
         try{
       st=conn.createStatement();
       rs = st.executeQuery("select * from greyscale");
       rs=st.getResultSet();
         }catch(SQLException ex){System.err.println(""+ex);}
     
         return rs;
     }

protected void finalize() throws SQLException
{
conn.close();;
st.close();
rs.close();
}

}
