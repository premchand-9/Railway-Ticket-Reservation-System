import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.awt.*;
public class B extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f=new JFrame();
	JLabel l7=new JLabel("CARD HOLDER NAME");
	JLabel l8=new JLabel("CARD NUMBER");
	JLabel l9=new JLabel("ENTER CVV");
	JLabel l10=new JLabel("EXPIRY DATE");
	static JLabel l11=new JLabel("");
	JButton b1=new JButton("NEXT");
	JTextField t7=new JTextField();
	JTextField t8=new JTextField();
	JTextField t9=new JTextField();
	JTextField t10=new JTextField();
	String r="Amount to be payed:";
	static String[] data=new String[10];
	static String amount;
	public B() {
		boolean b=true;
		try {
		amount=A.getPrice();
		data=A.data;
		if(amount==null) {
			b=false;
		}
		}catch(Exception e) {}
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","IT19121A1209","Prem");
			Statement ps=con.createStatement();
			ResultSet rs=ps.executeQuery(amount);
			while(rs.next()) {
				float f=rs.getFloat("final_price");
				data[8]=String.valueOf(f*Integer.parseInt(data[2]));
				r+=data[8];
			}
			con.close();
			}catch (Exception e) {}
		if(b) {
		f.getContentPane().setBackground(Color.CYAN);
		f.getContentPane().setForeground(Color.RED);
		l7.setBounds(400,150,150,20);
		l8.setBounds(400,200,150,20);
		l9.setBounds(400,250,150,20);
		l10.setBounds(400,300,150,20);
		l11.setBounds(600,350,250,30);
		f.add(l7);
		f.add(l8);
		f.add(l9);
		f.add(l10);
		f.add(l11);
		t7.setBounds(550,150,200,20);
		t8.setBounds(550,200,200,20);
		t9.setBounds(550,250,200,20);
		t10.setBounds(550,300,200,20);
		f.add(t7);
		f.add(t8);
		f.add(t9);
		f.add(t10);
		JLabel l12=new JLabel(r);
		l12.setBounds(500,100,300,50);
		f.add(l12);
		b1.setBounds(600,400,100,30);
		f.add(b1);
		b1.addActionListener(this);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	f.setResizable(false);
		f.setLayout(null);
		f.setVisible(true);
		}else {
			new Program();
			f.dispose();
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1) {
			l11.setText("");
			if(t7.getText().isEmpty() || !(t7.getText().matches("^[a-zA-Z' ']*$"))) {
				l11.setText("Please enter valid name");
			}else {
				if(t8.getText().isEmpty()) {
					l11.setText("Please enter Valid Card Number");
				}else if(!(t8.getText().matches("[0-9]+"))){
					l11.setText("Please enter Valid Card Number");
				}else if(t8.getText().length()!=16){
					l11.setText("Please enter Valid Card Number");
				}else {
					if(t10.getText().isEmpty()) {
						l11.setText("Please Enter Valid Expiry date");
					}else if(t10.getText().toString().length()!=5) {
						l11.setText("Please Enter Valid Expiry date");
					}else{
						char a[]=t10.getText().toString().toCharArray();
						if(a[2]!='/'  || (!Character.isDigit(a[0])) || (!Character.isDigit(a[1])) || (!Character.isDigit(a[3])) || (!Character.isDigit(a[4]))) {
							l11.setText("Expiry Date must be like mm/yy");
						}else {
							String ed=t10.getText().toString();
							LocalDate currentdate = LocalDate.now();
							String strc=currentdate.toString();
						    int cmonth =Integer.parseInt(strc.substring(5,7));
						    int cyear =Integer.parseInt(strc.substring(2,4));
						    int month=Integer.parseInt(ed.substring(0,2));
						    int year=Integer.parseInt(ed.substring(3,5));
						    if((cyear==year && cmonth>month)) {
						    	l11.setText("Please Enter Valid Expiry date");
						    }else if(month>12) {
						    	l11.setText("Please Enter Valid Expiry date");
						    }else if(cyear>year) {
						    	l11.setText("Please Enter Valid Expiry date");
						    }else {
						    	if(t9.getText().isEmpty() || !(t9.getText().matches("[0-9]+"))) {
						    		l11.setText("Please enter valid CVV");
						    	}else {
						    		if(!(t9.getText().length()==3)) {
						    			l11.setText("Please enter valid CVV");
						    		}else {
						    			try{
						    				Class.forName("oracle.jdbc.driver.OracleDriver");
						    				Connection con=DriverManager.getConnection(
						    				"jdbc:oracle:thin:@localhost:1521:xe","IT19121A1209","Prem");
						    				PreparedStatement ps=con.prepareStatement("select * from data");
						    				data[9]="true";
						    				ps.executeUpdate("INSERT INTO data VALUES('"+data[0]+"','"+data[1]+"',"+Integer.parseInt(data[2])+",'"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"','"+data[7]+"',"+Float.parseFloat(data[8])+",'"+data[9]+"')");
						    				con.close();
						    				}catch (Exception e) {}
						    			new C();
						    			f.dispose();
						    		}
						    	}
						    }
						}
					}
				}
			}
	}
	}
	public static void main(String args[]){
		new B();
	}
}	