import java.sql.*;

public class sqlTest
{
  public static void main(String[] args)
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Good to go");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","rapture");
      Statement stmt = conn.createStatement();
      //stmt.executeUpdate("INSERT INTO person VALUES(5,'Henriksen','Brian','400 Good-bye Rd.','Boston')");
      ResultSet rs = stmt.executeQuery("SELECT * FROM person");
      while(rs.next())
      {
        System.out.println(rs.getInt(1) + " " +
        rs.getString(2) + " " + 
        rs.getString(3) + " " + 
        rs.getString(4)+" "+
        rs.getString(5));
      }
      conn.close();
      stmt.close();
      rs.close();
    }
    catch(Exception e)
    {
      System.out.println("JDBC Driver Error "+e);
    }
  }
}