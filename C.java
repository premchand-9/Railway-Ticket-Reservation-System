import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
public class C extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f=new JFrame();
	JButton b2,b3;
	static String[] data=new String[10];
	static boolean p=false;
	public C(){
		boolean t=true;
		try {
			data=B.data;
			if(data[0]==null) {t=false;}
		}catch(Exception e) {t=false;}
		if(t) {
		f.getContentPane().setBackground(Color.CYAN);
		f.getContentPane().setForeground(Color.RED);
		String s="                          BOOKING DETAILS";
        JTextArea area=new JTextArea(); 
        area.setEditable(false);
        area.setBounds(450,150, 300,300);
		f.setTitle("TRANSACTION COMPLETED");
        f.add(area);  
		JLabel l12;
		l12=new JLabel("TRANSACTION SUCCESSFUL");
		l12.setBounds(500,100,200,50);
		f.add(l12);
		b2=new JButton("CLOSE");
		b2.setBounds(450,500,100,30);
		b3=new JButton("CONTINUE");
		b3.setBounds(650,500,100,30);
		b2.addActionListener(this);
		b3.addActionListener(this);
		f.add(b2);
		f.add(b3);
    	f.setLayout(null);
    	f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	f.setResizable(false);
    	f.setVisible(true);
		s+="\n\n\n";
		s+="NAME                            : "+data[1]+"\n\n";
		s+="SEATS                          : "+data[2]+"\n\n";
		s+="DATE OF JOURNEY  : "+data[3]+"\n\n";
		s+="CLASS TYPE               : "+data[4]+"\n\n";
		s+="SOURCE                     : "+data[5]+"\n\n";			
		s+="DESTINATION            : "+data[6]+"\n\n";			
		s+="AMOUNT PAID            : "+data[8];
		area.setText(s);
	}else {
		new Program();
		f.dispose();
	}
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b2){
			f.dispose();
		}
		if (ae.getSource()==b3) {
			p=true;
			new A();
			f.dispose();
		}
	}
	public static void main(String args[]) {
		new C();
	}
}