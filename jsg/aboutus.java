package jsg;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

class mee extends JFrame
{
	Connection con;
  JLabel lbl1,lbl2,lbl3,lbl4;
  ImageIcon ico;
	mee()
	{
		con=connectFile.getConnection();
		if(con==null)
		JOptionPane.showMessageDialog(null, "Connection Error");
		setTitle("About Us.....");
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		getContentPane().setBackground(Color.darkGray);
		setLayout(null);
	//**********************************8
	ico=new ImageIcon("dev.gif");	
	lbl1=new JLabel(ico);	
	lbl1.setBounds(0, 0, 852, 100);
	add(lbl1);
	//******************
	ico=new ImageIcon(new ImageIcon("me.jpg").getImage().getScaledInstance(750,200,Image.SCALE_SMOOTH));	
	lbl2=new JLabel(ico);	
	lbl2.setBounds(0, 90, 800, 200);
	add(lbl2);
	//******************
	ico=new ImageIcon("under.gif");	
	lbl3=new JLabel(ico);	
	lbl3.setBounds(0, 280, 852, 100);
	add(lbl3);
	//******************
	ico=new ImageIcon(new ImageIcon("sir.jpg").getImage().getScaledInstance(800,280,Image.SCALE_SMOOTH));	
	lbl4=new JLabel(ico);	
	lbl4.setBounds(2, 380, 800, 280);
	add(lbl4);
	//******************
	
	setSize(820,700);
	setVisible(true);
	setLocationRelativeTo(null);
	}
}
public class aboutus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
mee m=new mee();
	}

}
