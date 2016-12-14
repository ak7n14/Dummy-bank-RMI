import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientServerGUI {
	Container panel;
	JFrame window;
	JPanel frame;
	JLabel amount;
	JLabel name;
	public ClientServerGUI(String name,int amount){
		this.amount=new JLabel(Integer.toString(amount));
		this.name = new JLabel(name);
		
	}
	public  void init(){
		window = new JFrame("Client");
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE) ;
        window.setSize(500,500);
    //Declaring a main container panel to contain text fields and buttons
        panel = window.getContentPane();
        panel.setLayout(new GridLayout(2,1));
        frame=new JPanel();
        frame.setLayout(new GridLayout(2,2));
        frame.setSize(600,500);
	//Creating Text fields and buttons
		JLabel label = new JLabel("Account Holder: ");
		JLabel label2 = new JLabel("Current Balance:");
        JPanel frame2 = new JPanel();
        frame2.setLayout(new FlowLayout());
   //Adding Text fields and buttons to the container
        frame.add(label);
        frame.add(name);
        frame.add(label2);
        frame.add(amount);
        panel.add(frame);

        JButton cancel = new JButton("close");
        frame2.add(cancel);
        panel.add(frame2);
        cancel.addActionListener(new CloseListener());
	

       	window.setVisible(true);
   //Setting maximum and minimum sizes to maintain the current layout of the GUI
       	window.setMinimumSize(new Dimension(300,100));
       	window.setMaximumSize(new Dimension(300,100));

	}
	
	public void setAmount(float amt){
		amount.setText(Float.toString(amt));
	}
}
