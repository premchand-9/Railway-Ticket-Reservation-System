import java.sql.*;
public class RetrieveFile {
public static void main(String[] args) {
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","IT19121A1209","Prem");
Statement ps=con.createStatement();
ResultSet rs=ps.executeQuery("Select distinct(final_price,sources,destinations) from place");
while(rs.next()) {
	System.out.println(rs.getFloat("final_price")+"\t"+rs.getString("sources")+"\t"+rs.getString("destinations"));
}
con.close();
}catch (Exception e) {e.printStackTrace();	}
}
}