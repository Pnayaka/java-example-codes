String url = "jdbc:odbc:CustomerInformation";
String userID = "jim";
String password = "keogh";
Statement DataRequest1, DataRequest2 ;
Connection Database;

try {
		Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver");
		Database = DriverManager.getConnection(url,userID,password);
	}
	catch (ClassNotFoundException error) {
		System.err.println("Unable to load the JDBC/ODBC bridge." +
			error);
		System.exit(1);
	}
	catch (SQLException error) {
		System.err.println("Cannot connect to the database." + error);
			System.exit(2);
	}
	try {
		Database .setAutoCommit(false)
		String query1 = "UPDATE Customers SET Street = '5 Main Street' " +
			"WHERE FirstName = 'Bob'";
		String query2 = "UPDATE Customers SET Street = '10 Main Street' " +
			"WHERE FirstName = 'Tim'";
		
		DataRequest1= Database.createStatement();
		Savepoint s1 = Database.setSavepoint ("sp1");
		DataRequest2= Database.createStatement();
		DataRequest.executeUpdate (query1);
		DataRequest.executeUpdate (query2);
		Database.commit();
		DataRequest1.close();
		DataRequest2.close();
		Database.releaseSavepoint ("sp1");
		Database.close();
	}
	catch ( SQLException error ){
		try {
			Database.rollback(sp1);
		}
		catch ( SQLException error ){
			System.err.println("rollback error." + error.getMessage());
				System.exit(3);
		}
		System.err.println("SQL error." + error. getMessage()););
		System.exit(4);
}