import java.sql.*;
public class StoreFile {
public static void main(String[] args) {/*
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection(
"jdbc:oracle:thin:@localhost:1521:xe","system","Prem");
String s1="prem",s2="123";
PreparedStatement ps=con.prepareStatement("select * from prem");
ps.executeUpdate("INSERT INTO prem VALUES('"+s1+"','"+s2+"')");
System.out.print("1");
con.close();
}catch (Exception e) {e.printStackTrace();}*/
	String[] data=new String[10];
	data[0]="prem";
	data[1]="kjbdv";
	data[2]="9";
	data[3]="10-12-2001";
	data[4]="AC Seater";
	data[5]="Hyderabad";
	data[6]="Secunderabad";
	data[7]="Windows";
	data[8]="9899";
	data[9]="true";
	String k="INSERT INTO data VALUES('"+data[0]+"','"+data[1]+"',"+Integer.parseInt(data[2])+",'"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"','"+data[7]+"',"+Float.parseFloat(data[8])+",'"+data[9]+"')";
	System.out.print(k);
}
}