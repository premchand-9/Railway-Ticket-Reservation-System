import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;
public class V  implements ActionListener{
	JFrame f;
	static String user;
	static int j;
	JButton b1,b2;
	static boolean p=false;
	public V() {
		boolean t=true;
		try {
			user=A.user;
			if(user==null) {t=false;}
		}catch(Exception e) {}
		if(t) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","IT19121A1209","Prem");
				Statement ps=con.createStatement();
				ResultSet n=ps.executeQuery("Select count(*) as count from data where username='"+user+"'");
				while(n.next()) {
					j=Integer.parseInt(n.getString("count"));
				}
				con.close();
			}catch(Exception e) {}
		f=new JFrame("Ticket Booked Details");
		String[][] data=new String[j][9];
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","IT19121A1209","Prem");
			Statement ps=con.createStatement();
			ResultSet rs=ps.executeQuery("Select * from data where username='"+user+"'");
			int k=0;
			while(rs.next()) {
				data[k][0]=rs.getString("username");
				data[k][1]=rs.getString("nameofpassenger");
				data[k][2]=String.valueOf(rs.getInt("noofpassengers"));
				data[k][3]=rs.getString("doj");
				data[k][4]=rs.getString("type");
				data[k][5]=rs.getString("sources");
				data[k][6]=rs.getString("destinations");
				data[k][7]=rs.getString("osname");
				data[k][8]=String.valueOf(rs.getFloat("price"));
				k+=1;
			}
			con.close();
		}catch(Exception e) {}
	    b1=new JButton("Exit");
	    b2=new JButton("Continue");
	    b1.setBounds(200,620,100,20);
	    b2.setBounds(400,620,100,20);
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    f.add(b1);
	    f.add(b2);
	    String column[]={"Username","Name","Passengers","DoJ","type","Source","Destination","OS","Price"};
	    JTable jt=new JTable(data,column);    
	    jt.setBounds(30,40,400,400);          
	    JScrollPane sp=new JScrollPane(jt);    
	    f.add(sp);  
	    f.setSize(1280,600);
	    f.setVisible(true); 
		f.setLayout(null);
    	f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	f.setResizable(false);
		}else {
			new Program();
		}
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
			f.dispose();
		}if(ae.getSource()==b2) {
			p=true;
			new A();
			f.dispose();
		}
	}
	public static void main(String[] args) {
		new V();
	}
}