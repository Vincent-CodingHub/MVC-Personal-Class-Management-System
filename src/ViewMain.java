import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;


public class ViewMain extends JFrame {
    public JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
	
	public ViewMain() {
		getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(4,4,10,10));  
        setSize(605, 413);
        setLocationRelativeTo(null);
        
       
        
	}
	
}
