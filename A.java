import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jdesktop.swingx.JXDatePicker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.*;
public class A extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f;
	static JLabel l1,l2,l3,l4,l5,l6,l7;
	static JTextField t1,t2;
	JPanel t3;
	JButton b,v;
	JComboBox<String> c1,c2,c3;
	static float price;
	static String s,str,k,user;
	static String[] data=new String[10];
	final static JXDatePicker pick = new JXDatePicker();
	public A() {
		boolean t=true;
		try {
		user=Program.user();
		}catch(Exception e){
			t=false;
		}
		if(t || Program.p || C.p || V.p) {
		f=new JFrame();
		f.getContentPane().setBackground(Color.CYAN);
		f.getContentPane().setForeground(Color.RED);
		l1=new JLabel("NAME");
		l2=new JLabel("SEATS REQUIRED");
		l3=new JLabel("DATE OF JOURNEY");
		l4=new JLabel("TYPE");
		l5=new JLabel("SOURCE");
		l6=new JLabel("DESTINATION");
		l7=new JLabel("");
		t1=new JTextField();
		t2=new JTextField();
		t3=new JPanel();
		t3.setBackground(Color.cyan);
	    t3.setBounds(320,150,100,30);
	    pick.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
	    t3.add(pick);
	    t3.setSize(150, 30);
		c1=new JComboBox<String>();
		c2=new JComboBox<String>();
		c3=new JComboBox<String>();
		b=new JButton("SUBMIT");
		v=new JButton("VIEW TICKETS");
		v.setBounds(1000,50,120,20);
		l1.setBounds(200,110,100,10);
		l2.setBounds(700,110,100,20);
		l3.setBounds(200,140,150,60);
		l4.setBounds(700,140,100,60);
		l5.setBounds(200,170,100,110);
		l6.setBounds(700,170,100,110);
		l7.setBounds(500,300,250,110);
		t1.setBounds(340,110,110,20);
		t2.setBounds(840,110,110,20);
		c3.addItem("--SELECT--");
		c2.addItem("--SELECT--");
		c1.addItem("--SELECT--");
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","IT19121A1209","Prem");
			Statement ps=con.createStatement();
			ResultSet rs=ps.executeQuery("Select distinct(destinations) from place");
			while(rs.next()) {
				String s=rs.getString("destinations");
				c2.addItem(s);
				c3.addItem(s);
			}rs=ps.executeQuery("Select distinct(type) from place");
			while(rs.next()) {
				String s=rs.getString("type");
				c1.addItem(s);
			}
			con.close();
			}catch (Exception e1) {e1.printStackTrace();	}
		c1.setBounds(840,160,110,20);
		c2.setBounds(340,220,110,20);
		c3.setBounds(840,220,110,20);
		b.setBounds(500,450,100,20);
		b.addActionListener(this);
		v.addActionListener(this);
		f.add(v);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(l7);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(c1);
		f.add(c2);
		f.add(c3);
		f.add(b);
		f.setLayout(null);
		f.setVisible(true);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	f.setResizable(false);
		}else {
			new Program();
			dispose();
		}
	}
	public static String getPrice() {
		return k;
	}
	public boolean Date() throws ParseException {
		boolean b=false;
		try {
		s=A.pick.getDate().toString();
		}catch(Exception e) {
			return false;
		}
		SimpleDateFormat dateParser = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
		java.util.Date date = dateParser.parse(s);
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		str = dateFormatter.format(date);
		int day=Integer.parseInt(str.substring(0,2));
		int month=Integer.parseInt(str.substring(3,5));
		int year=Integer.parseInt(str.substring(6,10));
		LocalDate currentdate = LocalDate.now();
		String strc=currentdate.toString();
		int cday = Integer.parseInt(strc.substring(8,10));
	    int cmonth =Integer.parseInt(strc.substring(5,7));
	    int cyear =Integer.parseInt(strc.substring(0,4));
	    if(cyear<year) {b=true;}
	    else if(cyear==year) {
	    	if(month>cmonth) {
	    		b=true;
	    	}else if(month==cmonth){
	    		if(day>=cday) {
	    			b=true;
	    		}
	    	}else {
	    		b=false;
	    	}
	    }else {b=false;}
	    return b;
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==v) {
			new V();
			f.dispose();
		}
		if(ae.getSource()==b){
			if(t1.getText().isEmpty() || !t1.getText().matches("^[a-zA-Z' ']*$")) {
				l7.setText("please enter valid Name");
			}else {
				if(t2.getText().isEmpty()) {
					l7.setText("Enter Valid number of Passengers");
					}
					else if(!(t2.getText().matches("[0-9]+"))) {
						l7.setText("Enter Valid number of Passengers");
					}else if(Integer.parseInt(t2.getText())<=0) {
							l7.setText("Enter Valid number of Passengers");
					}else {
						try {
							if(!Date()) {
								l7.setText("Enter Valid Date");
							}
							else {
								if(!c1.getSelectedItem().equals("--SELECT--")) {
									if(!(c2.getSelectedItem().equals("--SELECT--") || c3.getSelectedItem().equals("--SELECT--"))) {
										if(c2.getSelectedItem().equals(c3.getSelectedItem())) {
											l7.setText("Source and Destination must be different");
										}else {
											String os = System.getProperty("os.name");
											k="Select final_price from place where sources='"+c2.getSelectedItem()+"' and destinations='"+c3.getSelectedItem()+"' and type='"+c1.getSelectedItem()+"'";
											data[0]=user;
											data[1]=t1.getText();
											data[2]=t2.getText();
											data[3]=str;
											data[4]=c1.getSelectedItem().toString();
											data[5]=c2.getSelectedItem().toString();
											data[6]=c3.getSelectedItem().toString();
											data[7]=os;
											new B(); 
											f.dispose();
										}
									}
									else {
										l7.setText("Please select valid source and destination");
									}
								}else {
									l7.setText("Please select Valid Type");
								}
							}
						} catch (Exception e) {}
					}
			}
		}
		}		
	public static void main(String args[]){
		new A();
	}
}