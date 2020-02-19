import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

 class LoginDao {

	public static String returnFullname(String usr, String pass) {
		String result=null;
		try { 
			Connection con = null;
			String driver = "com.mysql.jdbc.Driver";
			Class.forName(driver);		

			String dbUrl = "jdbc:mysql://remotemysql.com";
			String dbUsr = "twPzrpEuap";
			String dbPass = "fBu2Z5rKs5";
			
			con = DriverManager.getConnection(dbUrl,dbUsr,dbPass);
			String querry = " select description from twPzrpEuap.users where email=\'" + usr + "\' and pass=\'" + pass+ "\'";
			PreparedStatement statement = con.prepareStatement(querry);	
			ResultSet res = statement.executeQuery(querry);
			res = statement.executeQuery(querry);
			res.next();
			String tempRes = res.getString("description");
			System.out.println(tempRes);
			if (tempRes != "" && tempRes != null) 
				result = tempRes;
			statement.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}	
}