package jsg;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

class enquiry extends JFrame
{
	Connection con;
	JPanel pnl1,pnl2;
	JComboBox ids,m,y;
	JLabel ttl,ttl1,ttl2,lblmnthbl,tmnthbl,lblids,lblmnth,lblyr;
	JButton fetch,print;
	PreparedStatement pst;
	JTable table;
	Border bdr,bdr1;
	ImageIcon ico;
	soundPlay s=new soundPlay();
	enquiry()
	{
		con=connectFile.getConnection();
		if(con==null)
		JOptionPane.showMessageDialog(null, "Connection Error");
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Customer Enquiry.....");
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		bdr=BorderFactory.createLineBorder(Color.WHITE,3);
		getContentPane().setBackground(Color.DARK_GRAY);
		pnl1=new JPanel();
		pnl1.setBounds(0,0, 789,110);
		pnl1.setLayout(null);
		pnl1.setBackground(Color.GRAY);
		pnl1.setBorder(bdr);
		add(pnl1);
		pnl2=new JPanel();
		pnl2.setBounds(200,300,380,200);
		pnl2.setLayout(null);
		pnl2.setBackground(Color.darkGray);
		pnl2.setBorder(bdr);
		add(pnl2);
		ico=new ImageIcon("cenq.png");
		ttl=new JLabel();
		ttl.setIcon(ico);
		ttl.setBounds(150, 10,580,95);
		add(ttl);
		pnl1.add(ttl);
		ico=new ImageIcon(new ImageIcon("inquiry.png").getImage().
				getScaledInstance(90,90,Image.SCALE_SMOOTH));
		ttl1=new JLabel();
		ttl1.setIcon(ico);
		ttl1.setBounds(680, 10,90,90);
		add(ttl1);
		pnl1.add(ttl1);
		ttl2=new JLabel();
		ttl2.setIcon(ico);
		ttl2.setBounds(20, 10,90,90);
		add(ttl2);
		pnl1.add(ttl2);
		ids=new JComboBox();
		ids.setBounds(180, 130,150,20);
		add(ids);
		String []month={"01","02","03","04","05","06","07","08","09","10","11","12"};
		m=new JComboBox(month);
		m.setBounds(500, 130, 50,20);
		m.insertItemAt("mm",0);
		m.setSelectedIndex(0);
		add(m);
		String []year={"2006","2007","2008","2009","2010","2011","2012","2013","2014","2015",
				        "2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};				
		y=new JComboBox(year);
		y.setBounds(660, 130, 60, 20);
		y.insertItemAt("yyyy",0);
		y.setSelectedIndex(0);
		add(y);
		ico=new ImageIcon("custids.png");
		lblids=new JLabel();
		lblids.setIcon(ico);
		lblids.setBounds(30,120,150,40);
		add(lblids);
		ico=new ImageIcon("mnth.png");
		lblmnth=new JLabel();
		lblmnth.setIcon(ico);
		lblmnth.setBounds(410,120,100,40);
		add(lblmnth);
		ico=new ImageIcon("year.png");
		lblyr=new JLabel();
		lblyr.setIcon(ico);
		lblyr.setBounds(590,120,100,40);
		add(lblyr);
		ico=new ImageIcon("totbl.png");
		lblmnthbl=new JLabel();
		lblmnthbl.setIcon(ico);
		lblmnthbl.setBounds(50,550, 130,40);
		add(lblmnthbl);
		tmnthbl=new JLabel();
		tmnthbl.setBounds(200,560,80,20);
		tmnthbl.setForeground(Color.green);
		add(tmnthbl);
		print=new JButton("Print");
		print.setBounds(500, 550,100,50);
		print.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			try {
				table.print();
			} catch (PrinterException e1) {
				// TODO Auto-generated catch block
				s.click.play();
				e1.printStackTrace();
			}	
			}
		});
		add(print);
		ico=new ImageIcon(new ImageIcon("fetch.png").getImage().
				getScaledInstance(110,55,Image.SCALE_SMOOTH));
		//ico=new ImageIcon("fetch.png");
		fetch=new JButton();
		fetch.setBounds(340, 200,100,50);
		fetch.setIcon(ico);
		fetch.setBackground(Color.DARK_GRAY);
		fetch.setBorder(bdr1);
		add(fetch);
		fetch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s.click.play();
				String mm=m.getSelectedItem().toString();
				String yy=y.getSelectedItem().toString();
				String id=ids.getSelectedItem().toString();
			    filltable(id);
			    fetchone(mm,yy,id);
			}
		});
		setLayout(null);
		setSize(800,700);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	void fetchIds()
	{
	ids.removeAllItems();
	ids.addItem("Select");
	try{
	pst=con.prepareStatement("select custId from milkman");
	ResultSet rs= pst.executeQuery();
	while(rs.next())
	{
	String id=rs.getString("custId");
	ids.addItem(id+"");
	}
	pst.close();
	}
	catch(Exception ex)
	{}
	}
	void fetchone(String mm,String yy,String id)
	{
		try {
			pst=con.prepareStatement("Select totbill from bill where month=? and year=? and custId=?");
			pst.setString(1,mm);
			pst.setString(2, yy);
			pst.setString(3,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Float f=rs.getFloat("totbill");
				tmnthbl.setText(String.valueOf(f));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	void filltable(String id)
	{
		try {
			String sql = "Select vdate,qtyPlusC,qtyMinusC,qtyPlusB,qtyMinusB from variations where custId=? " +
					              "and month(vdate)=? and year(vdate)=?";
			pst = con.prepareStatement(sql);
			pst.setString(1,id);
			pst.setString(2,m.getSelectedItem().toString());
			pst.setString(3,y.getSelectedItem().toString());
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
			table = new JTable((TableModel) data, (TableColumnModel) columnNames);
			JScrollPane scrollPane = new JScrollPane( table );
			table.setBackground(Color.green);
			table.setSelectionBackground(Color.yellow);
			table.getTableHeader().setBackground(Color.cyan);
			scrollPane.getViewport().setBackground(Color.white);
			//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			scrollPane.setBounds(200, 300, 380, 200);
			add( scrollPane );
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
public class custEnquiry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
enquiry e=new enquiry();
e.fetchIds();
	}

}
