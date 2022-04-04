/*import java.awt.*;  
import java.awt.event.*;
import java.sql.*;
public class Test extends Frame implements ActionListener,ItemListener {
	Frame f=new Frame();
	Choice c1;
	public Test() {
		c1=new Choice();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","IT19121A1209","Prem");
			Statement ps=con.createStatement();
			ResultSet rs=ps.executeQuery("Select * from places");
			while(rs.next()) {
				c1.add(rs.getString("place"));
			}
			con.close();
			}catch (Exception e) {e.printStackTrace();}
		c1.setBounds(320,200,150,10);
		f.add(c1);
		c1.addItemListener(this);
		f.setVisible(true);
		f.setSize(600,600);
	}
	private static final long serialVersionUID = 1L;
	public void actionPerformed(ActionEvent ae) {}
	public void itemStateChanged(ItemEvent ie) {}
	public static void main(String arr[]){
		new Test();
}
}
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

public class Date extends JFrame {

	private static final long serialVersionUID = 1L;
public static void main(String[] args) {
JFrame frame = new JFrame("JXPicker Example");
JPanel panel = new JPanel();
JXDatePicker picker = new JXDatePicker();
//picker.setDate(Calendar.getInstance());
picker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
panel.add(picker);
panel.setBackground(Color.BLACK);
panel.setBounds(100, 81,10,20);
panel.setBorder(BorderFactory.createTitledBorder(""));
contentPane.add(panel);
frame.add(panel);
panel.setLayout(null);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
boolean b=true;
while(b) {
	try {
	if(picker.getDate().toString()!=null) {
		b=false;
		System.out.println(picker.getDate());
		String str= picker.getDate().toString();
		SimpleDateFormat dateParser = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
		java.util.Date date = dateParser.parse(str);
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(dateFormatter.format(date));
	}
	}catch(Exception e) {}
}
}
}
*/
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.*;

import org.jdesktop.swingx.JXDatePicker;
public class Test {
	    public static void main(String args[])
	    {
	    	JFrame f= new JFrame("Panel Example");  
		    JPanel panel=new JPanel();
		    panel.setBounds(40,80,100,26);  
		    //panel.setBackground(Color.WHITE);
		    JXDatePicker picker = new JXDatePicker();
		    //picker.setDate(Calendar.getInstance());
		    picker.setFormats(new SimpleDateFormat("MM/yy"));
		    panel.add(picker);
		    f.add(panel);
		    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		    f.setLayout(null); 
		    f.setVisible(true); 
		    boolean b=true;
		    while(b) {
		    	try {
		    	if(picker.getDate().toString()!=null) {
		    		b=false;
		    		System.out.println(picker.getDate());
		    		String str= picker.getDate().toString();
		    		SimpleDateFormat dateParser = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
		    		java.util.Date date = dateParser.parse(str);
		    		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		    		System.out.println(dateFormatter.format(date));

		    		LocalDate currentdate = LocalDate.now();
		    		System.out.println(currentdate);
		    	}
		    	}catch(Exception e) {}
		    }
	    }
	}
