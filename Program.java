import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
public class Program extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	final JLabel l4;
    static JTextField t1;
    JButton b1;
	JButton b2;
    JFrame f=new JFrame();
    static String str;
    static boolean p=false;
    JPasswordField t2 = new JPasswordField();
    public Program(){
    	f.setTitle("LOGIN FORM");
        l1=new JLabel("Username");
        l2=new JLabel("Password");
        t1=new JTextField();
        b1=new JButton("Login");
        b2=new JButton("Register");
        l3=new JLabel("Welcome To Login Portal");
        l3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        l4=new JLabel("");
        l1.setBounds(450,110,100,20);
        t1.setBounds(550,100,200,30);
        l2.setBounds(450,120,100,100);
        t2.setBounds(550,150,200,30);
        b1.setBounds(450,250,100,30);
        b2.setBounds(650,250,100,30);
        l4.setBounds(550,280,300,100);
        l3.setBounds(550,20,300,100);
        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(b1);
        f.add(b2);
        f.add(l3);
        f.add(l4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        f.setLayout(null);
        f.setVisible(true);
    	f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==b1){
    		String s1=t1.getText();
			String s2=String.valueOf(t2.getPassword());
            if(show1(s1,s2)) {
            p=true;
            l4.setText("Login Succesfull Redirecting....");
            int delay =5000;
            Timer timer = new Timer( delay, new ActionListener(){
            	  @Override
            	  public void actionPerformed( ActionEvent ae ){
            		  str=t1.getText();
            		  new A();
            		  f.dispose();
            	  }
            	} );
            	timer.setRepeats( false );
            	timer.start();
            }
            else {
            l4.setText("Please enter Valid Credentials");
            t1.setText("");
            t2.setText("");
            }
    	}
    	if(ae.getSource()==b2){
    		String s1=t1.getText();
			String s2=String.valueOf(t2.getPassword());
			if(s2.length()>=8) {
    		if(show2(s1,s2)) {
    			l4.setText("Registration Succesfull Please Continue to Login");
                t1.setText("");
                t2.setText("");
    		}else {
    			l4.setText("Username Exists Please try again");
    			t1.setText("");
    			t2.setText("");
    		}
    		}else {
				l4.setText("Password must more than eight characters");
			}
    	}
    }
	public boolean show1(String s1, String s2){
    	boolean b = false;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "IT19121A1209", "Prem");
            PreparedStatement s = con.prepareStatement("select * from login where username=? and password=?");
            s.setString(1,s1);
            s.setString(2,s2);
            ResultSet rs = s.executeQuery();
            if (rs.next()){
            	b=true;
            }
            else{
            	b=false;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
		return  b;
    }
    public boolean show2(String s1, String s2){
    	boolean b=false;
    	try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "IT19121A1209", "Prem");
            Statement s=con.createStatement();
            ResultSet rs=s.executeQuery("SELECT username FROM login WHERE username LIKE '"+s1+"'");
            if(rs.next()){
            	b=false;
            }
            else{
            	s.executeUpdate("INSERT INTO login VALUES('"+s1+"','"+s2+"')");
            	b=true;
            }
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}return b;
    }
    public static String user() {
    	return str;
    }
    public static void main(String arr[]){
        new Program();
    }
}