import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXDatePicker;

public class Date extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public static void main(String[] args) {
JFrame frame = new JFrame("JXPicker Example");
JPanel panel = new JPanel();
JXDatePicker picker = new JXDatePicker();
//picker.setDate(Calendar.getInstance());
picker.setFormats(new SimpleDateFormat("dd/MM/yyyy"));
panel.add(picker);
//panel.setBounds(100,100,10,10);
frame.add(panel);
frame.setVisible(true);
frame.setSize(1280,690);
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