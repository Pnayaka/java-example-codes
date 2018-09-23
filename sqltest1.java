import java.sql.*;
import java.util.*;

class sqltest1{
	public static void main(String args[])throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/pariDB?user=root&password= ");
		
		//Statement st=con.createStatement();
		//ResultSet rs=st.executeQuery("select * from employees where id='105'");
		
		String query = "SELECT * FROM employees WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, "100");
		ResultSet rs = ps.executeQuery ();
		
		//Place code here to interact with the ResultSet
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getString(4));
		}
		rs.close();
		//st.close();
		con.close();
	}
}