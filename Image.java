import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class Image extends JFrame
{
    /**
	 * 
	 */
	JFrame f;
	private static final long serialVersionUID = 1L;
	private static final int SCALE_SMOOTH = 0;
	public Image() throws IOException
    {
		f=new JFrame();
    	BufferedImage img;
    	img = ImageIO.read(new File("logo.jpg"));
    	java.awt.Image dimg = img.getScaledInstance(1280,700, Image.SCALE_SMOOTH);
    	ImageIcon imageIcon = new ImageIcon(dimg);
    	f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    	f.setContentPane(new JLabel(imageIcon));
        f.setVisible(true);
        f.setResizable(false);
        f.setSize(1300,690);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) throws IOException 
    {
            new Image();
    }
}