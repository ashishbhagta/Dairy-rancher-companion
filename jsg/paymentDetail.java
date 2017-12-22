package jsg;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

class detail extends JFrame
{ 
	Connection con;
	JRadioButton rbfulpaid,rbbalance;
	JPanel pnl1,pnl2;
	JLabel ttl,ttl1,ttl2,lblfulpaid,lblbalance,lblmnth,lblyr,lblmsg,lblmbl;
	JTextField txtmsg,txtmbl;
	JComboBox m,y;
	JButton close,send;
	PreparedStatement pst;
	JTable table;
	Border bdr,bdr1;
	ImageIcon ico;
	soundPlay s=new soundPlay();
	static String id,mb,mnth,yr;
	static float pl,bl;
	static int status,r,c;
	detail()
	{
		con=connectFile.getConnection();
		if(con==null)
		JOptionPane.showMessageDialog(null, "Connection Error");
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		setLayout(null);
		getContentPane().setBackground(Color.DARK_GRAY);
		bdr=BorderFactory.createLineBorder(Color.white,3);
		pnl1=new JPanel();
		pnl1.setBounds(0,0,589,110);
		pnl1.setLayout(null);
		pnl1.setBackground(Color.GRAY);
		pnl1.setBorder(bdr);
		add(pnl1);
		pnl2=new JPanel();
		pnl2.setBounds(100,250,380,200);
		pnl2.setLayout(null);
		pnl2.setBackground(Color.darkGray);
		pnl2.setBorder(bdr);
		add(pnl2);
		ico=new ImageIcon("payd.png");
		ttl=new JLabel();
		ttl.setBounds(100,10,500 ,90);
		ttl.setIcon(ico);
		pnl1.add(ttl);
		ico=new ImageIcon(new ImageIcon("Billpay.png").getImage().
				getScaledInstance(70,70,Image.SCALE_SMOOTH));
		ttl1=new JLabel();
		ttl1.setIcon(ico);
		ttl1.setBounds(500, 10,90,90);
		pnl1.add(ttl1);
		ttl2=new JLabel();
		ttl2.setIcon(ico);
		ttl2.setBounds(20, 10,90,90);
		pnl1.add(ttl2);
		ico=new ImageIcon("mnth.png");
		lblmnth=new JLabel();
		lblmnth.setIcon(ico);
		lblmnth.setBounds(110,120,100,40);
		add(lblmnth);
		ico=new ImageIcon("year.png");
		lblyr=new JLabel();
		lblyr.setIcon(ico);
		lblyr.setBounds(280,120,100,40);
		add(lblyr);
		ico=new ImageIcon("fullp.png");
		lblfulpaid=new JLabel();
		lblfulpaid.setIcon(ico);
		lblfulpaid.setBounds(110, 190,150,40);
		add(lblfulpaid);
		ico=new ImageIcon("bal.png");
		lblbalance=new JLabel();
		lblbalance.setIcon(ico);
		lblbalance.setBounds(410, 190,100,40);
		add(lblbalance);
		ico=new ImageIcon("msg.png");
		lblmsg=new JLabel();
		lblmsg.setIcon(ico);
		lblmsg.setBounds(50, 490,100,40);
		lblmsg.setVisible(false);
		add(lblmsg);
		ico=new ImageIcon("4.png");
		lblmbl=new JLabel();
		lblmbl.setIcon(ico);
		lblmbl.setBounds(280, 490,150,40);
		lblmbl.setVisible(false);
		add(lblmbl);
		txtmsg=new JTextField();
		txtmsg.setBounds(150,500,100,20);
		txtmsg.setVisible(false);
		add(txtmsg);
		txtmbl=new JTextField();
		txtmbl.setBounds(400,500,100,20);
		txtmbl.setVisible(false);
		add(txtmbl);
		String []month={"01","02","03","04","05","06","07","08","09","10","11","12"};
		m=new JComboBox(month);
		m.setBounds(200, 130, 50,20);
		m.insertItemAt("mm",0);
		m.setSelectedIndex(0);
		add(m);
		String []year={"2006","2007","2008","2009","2010","2011","2012","2013","2014","2015",
				        "2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};				
		y=new JComboBox(year);
		y.setBounds(350, 130, 60, 20);
		y.insertItemAt("yyyy",0);
		y.setSelectedIndex(0);
		add(y);
		rbfulpaid=new JRadioButton();
		rbfulpaid.setBounds(100,200,20,20);
		rbfulpaid.setBackground(Color.darkGray);
	    rbfulpaid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(rbfulpaid.isSelected()){
				filltable();
				//lblmsg.setVisible(false);
				//lblmbl.setVisible(false);
				//txtmsg.setVisible(false);
				//txtmbl.setVisible(false);
			}
			}
		});
		add(rbfulpaid);
		rbbalance=new JRadioButton();
		rbbalance.setBounds(400,200,20,20);
		rbbalance.setBackground(Color.darkGray);
		rbbalance.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(rbbalance.isSelected())
			{
				filltable1();
				//lblmsg.setVisible(true);
				//lblmbl.setVisible(true);
				//txtmsg.setVisible(true);
				//txtmbl.setVisible(true);
				
			}
			}
		});
		add(rbbalance);
		 final ButtonGroup grp=new ButtonGroup();
		 grp.add(rbfulpaid);
		 grp.add(rbbalance);
		 ico=new ImageIcon(new ImageIcon("cclose.png").getImage().
					getScaledInstance(110,55,Image.SCALE_SMOOTH));
		 //ico=new ImageIcon("cclose.png");
		 close=new JButton("close");
		 close.setIcon(ico);
			close.setBorder(bdr1);
			close.setBackground(Color.darkGray);
		 close.setBounds(450,580,100,50);
		 close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			s.click.play();
			delete();
			dispose();
			}
		});
		 add(close);
		 ico=new ImageIcon(new ImageIcon("send.png").getImage().
					getScaledInstance(110,55,Image.SCALE_SMOOTH));
		 //ico=new ImageIcon("send.png");
		 send=new JButton();
		 send.setIcon(ico);
		 send.setBackground(Color.DARK_GRAY);
		 send.setBorder(bdr1);
		 send.setBounds(230,580,100,60);
		 send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s.click.play();
				String msg=SST_SMS.bceSunSoftSend(txtmbl.getText(),txtmsg.getText());
				/*if(msg.equals("sent"))
				JOptionPane.showMessageDialog(null, msg);
				else
				JOptionPane.showMessageDialog(null,"com/internetcon. problem");	
				//soundPlay.main(new String[]{});*/
				if(msg.equals("Your message is successfully sent to:91"+txtmbl.getText()))
					JOptionPane.showMessageDialog(null, msg);
					else
					JOptionPane.showMessageDialog(null,"com/internetcon. problem");
					
			}
		});
		 add(send);
		setSize(600,700);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	void fetch1()
	{
		try{
		pst=con.prepareStatement("select month,year,totbill,paymentStatus from bill where custId=?");
		pst.setString(1,id);
		ResultSet rs= pst.executeQuery();
		while(rs.next())
		{
		   mnth=rs.getString("month");
		   yr=rs.getString("year");
		   bl=rs.getFloat("totbill");
		   status=rs.getInt("paymentStatus");
		   save();
		}
		pst.close();
		}
		catch(Exception ex)
		{}
	}
	void fetch()
	{
		try{
		pst=con.prepareStatement("select custId,mobile,paymentLeft from milkman");
		ResultSet rs= pst.executeQuery();
		while(rs.next())
		{
		   id=rs.getString("custId");
		   mb=rs.getString("mobile");
		   pl=rs.getFloat("paymentLeft");
		   fetch1();
		}
		
		pst.close();
		}
		catch(Exception ex)
		{}
	}
	void save()
	{
		try{
			pst=con.prepareStatement("insert into details values(?,?,?,?,?,?,?)");
			pst.setString(1,id);
			pst.setString(2,mnth);
			pst.setString(3,yr);
			pst.setString(4,mb);
			pst.setFloat(5,bl);
			pst.setFloat(6,pl);
			pst.setInt(7,status);
			int count=pst.executeUpdate();
			//JOptionPane.showMessageDialog(null, count+" records Saved");
			pst.close();
		}
		catch(Exception e){}
	}
	void filltable()
	{
		try {
			String sql = "Select custId,month,year,mobile,amount from details where paymentStatus=1 " +
					              "and paymentLeft=0 and month=? and year=?" ;
			pst = con.prepareStatement(sql);
			pst.setString(1,m.getSelectedItem().toString());
			pst.setString(2,y.getSelectedItem().toString());
			ResultSet rs=pst.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			Vector<String> columnNames = new Vector<String>();
			int columns = md.getColumnCount();
			for (int i = 1; i <= columns; i++)
			{
			columnNames.addElement( md.getColumnName(i) );
			}
			//---------------------
			Vector<Object> data = new Vector<Object>();
			while (rs.next())
			{
			Vector<Object> row = new Vector<Object>(columns);
			for (int i = 1; i <= columns; i++)
			{
			row.addElement( rs.getObject(i) );
			}
			data.addElement(row);
			}
			rs.close();
			pst.close();
			table = new JTable(data,columnNames);
			JScrollPane scrollPane = new JScrollPane( table );
            table.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
				int r=table.getSelectedRow();
				int c=table.getSelectedColumn();
				if(c==3)
				{
				String abc=String.valueOf(table.getValueAt(r, c));
				lblmsg.setVisible(true);
				lblmbl.setVisible(true);
				txtmsg.setVisible(true);
				txtmsg.setText("thanks for bill payment");
				txtmbl.setVisible(true);
				txtmbl.setText(abc);}
				}
			});
			table.setBackground(Color.green);
			table.setSelectionBackground(Color.yellow);
			table.getTableHeader().setBackground(Color.cyan);
			scrollPane.getViewport().setBackground(Color.gray);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			scrollPane.setBounds(100, 250, 380, 200);
			add( scrollPane );
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	void filltable1()
	{
		try {
			String sql = "Select custId,month,year,mobile,amount from details where (paymentStatus=0 " +
					              "or paymentLeft!=0) and month=? and year=?";
			pst = con.prepareStatement(sql);
			pst.setString(1,m.getSelectedItem().toString());
			pst.setString(2,y.getSelectedItem().toString());
			ResultSet rs=pst.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			Vector<String> columnNames = new Vector<String>();
			int columns = md.getColumnCount();
			for (int i = 1; i <= columns; i++)
			{
			columnNames.addElement( md.getColumnName(i) );
			}
			//---------------------
			Vector<Object> data = new Vector<Object>();
			while (rs.next())
			{
			Vector<Object> row = new Vector<Object>(columns);
			for (int i = 1; i <= columns; i++)
			{
			row.addElement( rs.getObject(i) );
			}
			data.addElement(row);
			}
			rs.close();
			pst.close();
			table = new JTable(data,columnNames);
			JScrollPane scrollPane = new JScrollPane( table );
			table.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
				int r=table.getSelectedRow();
				int c=table.getSelectedColumn();
				if(c==3)
				{
				String abc=String.valueOf(table.getValueAt(r, c));
				lblmsg.setVisible(true);
				lblmbl.setVisible(true);
				txtmsg.setVisible(true);
				txtmsg.setText("Pay Bill Please");
				txtmbl.setVisible(true);
				txtmbl.setText(abc);
				}}
			});
			table.setBackground(Color.green);
			table.setSelectionBackground(Color.yellow);
			table.getTableHeader().setBackground(Color.cyan);
			scrollPane.getViewport().setBackground(Color.gray);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			scrollPane.setBounds(100, 250, 380, 200);
			add( scrollPane );
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	void delete()
	{
	try {
	pst=con.prepareStatement("delete from details");
	int count=pst.executeUpdate();
	//JOptionPane.showMessageDialog(null, count+" records Deleted");
	pst.close();
	} 
	catch (SQLException e) 
	{
	e.printStackTrace();
	}
	}
	
}
public class paymentDetail 
{
	public static void main(String[] args)
	{
detail d=new detail();
d.fetch();
	}
}
