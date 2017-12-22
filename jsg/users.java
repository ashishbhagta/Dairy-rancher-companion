package jsg;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.FileChooserUI;

class userId extends JFrame
{
	Connection con;
	JLabel lbl,lbl1,lbl2,lbl3,lbl4;
	JTextField txt1,txt2,txt3,txt4;
	JButton save,New,close,browser;
	Border bdr;
	ImageIcon ico;
	PreparedStatement pst;
	userId()
	{
		con=connectFile.getConnection();
		if(con==null)
		JOptionPane.showMessageDialog(null, "Connection Error");
		setLayout(null);
		getContentPane().setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bdr=BorderFactory.createLineBorder(Color.YELLOW,3);
		lbl=new JLabel(ico);
		lbl.setBounds(250,30 , 200, 200);
		lbl.setBorder(bdr);
		add(lbl);
		lbl1=new JLabel("userID");
		lbl1.setBounds(30, 30,80, 60);
		add(lbl1);
		lbl2=new JLabel("password");
		lbl2.setBounds(30, 100,80, 60);
		add(lbl2);
		lbl3=new JLabel("Mobile");
		lbl3.setBounds(30, 180,80, 60);
		add(lbl3);
		lbl4=new JLabel("Picpath");
		lbl4.setBounds(30, 300,80, 60);
		add(lbl4);
		txt1=new JTextField();
		txt1.setBounds(100, 50, 80, txt1.getPreferredSize().height);
		add(txt1);
		txt2=new JTextField();
		txt2.setBounds(100, 120, 80, txt1.getPreferredSize().height);
		add(txt2);
		txt3=new JTextField();
		txt3.setBounds(100, 200, 80, txt1.getPreferredSize().height);
		add(txt3);
		txt4=new JTextField();
		txt4.setBounds(100, 320, 300, txt1.getPreferredSize().height);
		add(txt4);
		save=new JButton("SAVE");
		save.setBounds(30, 400,120,50);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			save();	
			}
		});
		add(save);
		New=new JButton("NEW");
		New.setBounds(180, 400, 120, 50);
		New.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			txt1.setText(null);
			txt2.setText(null);
			txt3.setText(null);
			txt4.setText(null);
			}
		});
		add(New);
		close=new JButton("CLOSE");
		close.setBounds(330, 400, 120, 50);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			dispose();	
			}
		});
		add(close);
		browser=new JButton("BROWSER");
		browser.setBounds(290,250 ,120, 50);
		browser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fc=new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fc.setAcceptAllFileFilterUsed(false);
				int a=fc.showOpenDialog(null);
				if(a==JFileChooser.APPROVE_OPTION)
				{
					txt4.setText(fc.getSelectedFile().toString());
				}
			Image im=new ImageIcon(txt4.getText()).getImage();
			Image immg=im.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			ico=new ImageIcon(immg);
			lbl.setIcon(ico);
			}
		});
		add(browser);
		setSize(500,500);
		setVisible(true);
		setLocationRelativeTo(null);
	}
		void save()
		{
		try {
		pst=con.prepareStatement("insert into users1 values(?,?,?,?)");
		pst.setString(1,txt1.getText());
		pst.setString(2,txt2.getText());
		pst.setInt(3,Integer.parseInt(txt3.getText()));
		pst.setString(4,txt4.getText());
		int count=pst.executeUpdate();
		JOptionPane.showMessageDialog(null, count+" records Saved");
		pst.close();
		} 
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
		}
	
	
}
public class users
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
userId ui=new userId();
	}

}
