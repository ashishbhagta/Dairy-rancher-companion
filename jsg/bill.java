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
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

class calcbill extends JFrame
{
	Connection con;
	JPanel pnl1,pnl2,pnl3;
	JLabel tyr,tdy,ttl,ttl1,ttl2,lblcustIds,lblmnth,lblyr,lbldy,tdelc,tdelb,ttotbl,
	        lbldelc,lbldelb,lblltrc,lblltrb,lblrate,lblratec,lblrateb,lblpltrc,lblpltrb,lbltotbl;
	JTextField txtratec,txtrateb;
	JList lst;
	DefaultListModel mod;
	JComboBox m;
	JButton md,gb,save,sms,print; 
	Border bdr,bdr1;
	String mm,mnth;
	ImageIcon ico;
	soundPlay s=new soundPlay();
	PreparedStatement pst;
	static float tc=0,tb=0,tot=1,mc,lc,mb,lb;
	calcbill()
	{
		con=connectFile.getConnection();
		if(con==null)
		JOptionPane.showMessageDialog(null, "Connection Error");
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Monthly Bill.....");
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		bdr=BorderFactory.createLineBorder(Color.WHITE,3);
		getContentPane().setBackground(Color.darkGray);
		setLayout(null);
		String dd=curdate();
		int indx1=dd.indexOf('-');
		int indx2=dd.indexOf('-',indx1+1);
		pnl1=new JPanel();
		pnl1.setBounds(0,0, 789,110);
		pnl1.setBackground(Color.gray);
		pnl1.setLayout(null);
		pnl1.setBorder(bdr);
		add(pnl1);
		pnl2=new JPanel();
		pnl2.setBounds(330,230,400,170);
		pnl2.setBackground(Color.darkGray);
		pnl2.setLayout(null);
		pnl2.setBorder(bdr);
		add(pnl2);
		ico=new ImageIcon("mnthbill.png");
		ttl=new JLabel();
		ttl.setIcon(ico);
		ttl.setBounds(220,10,580,90);
		add(ttl);
		pnl1.add(ttl);
		ico=new ImageIcon(new ImageIcon("Billpaid.png").getImage().
				getScaledInstance(90,90,Image.SCALE_SMOOTH));
		ttl1=new JLabel();
		ttl1.setIcon(ico);
		ttl1.setBounds(70, 10,90,90);
		pnl1.add(ttl1);
		//***********************
		ttl2=new JLabel();
		ttl2.setIcon(ico);
		ttl2.setBounds(620, 10,90,90);
		pnl1.add(ttl2);
		//************************
		ico=new ImageIcon("custids.png");
		lblcustIds=new JLabel();
		lblcustIds.setIcon(ico);
		lblcustIds.setBounds(70,110,150,40);
		add(lblcustIds);
		ico=new ImageIcon("mnth.png");
		lblmnth=new JLabel();
		lblmnth.setIcon(ico);
		lblmnth.setBounds(350,130,100,40);
		add(lblmnth);
		ico=new ImageIcon("year.png");
		lblyr=new JLabel();
		lblyr.setIcon(ico);
		lblyr.setBounds(550,130,100,40);
		add(lblyr);
		ico=new ImageIcon("days.png");
		lbldy=new JLabel();
		lbldy.setIcon(ico);
		lbldy.setBounds(470, 180, 100,40);
		add(lbldy);
		ico=new ImageIcon("cow.png");
		lbldelc=new JLabel();
		lbldelc.setIcon(ico);
		lbldelc.setBounds(20, 70,100,40);
		add(lbldelc);
		pnl2.add(lbldelc);
		lblratec=new JLabel();
		lblratec.setIcon(ico);
		lblratec.setBounds(350, 420,100,40);
		add(lblratec);
		ico=new ImageIcon("buffalo.png");
		lbldelb=new JLabel();
		lbldelb.setIcon(ico);
		lbldelb.setBounds(20, 110, 120,40);
		add(lbldelb);
		pnl2.add(lbldelb);
		lblrateb=new JLabel();
		lblrateb.setIcon(ico);
		lblrateb.setBounds(350, 460,120,40);
		add(lblrateb);
		ico=new ImageIcon("lite.png");
		lblltrc=new JLabel();
		lblltrc.setIcon(ico);
		lblltrc.setBounds(250, 70, 100,40);
		add(lblltrc);
		pnl2.add(lblltrc);
		lblltrb=new JLabel();
		lblltrb.setIcon(ico);
		lblltrb.setBounds(250, 110, 100,40);
		add(lblltrb);
		pnl2.add(lblltrb);
		ico=new ImageIcon("rate.png");
		lblrate=new JLabel("rate");
		lblrate.setIcon(ico);
		lblrate.setBounds(250, 440,100,40);
		add(lblrate);
		ico=new ImageIcon("perlitre.png");
		lblpltrc=new JLabel();
		lblpltrc.setIcon(ico);
		lblpltrc.setBounds(600, 415,100,40);
		add(lblpltrc);
		lblpltrb=new JLabel();
		lblpltrb.setIcon(ico);
		lblpltrb.setBounds(600, 458, 100,40);
		add(lblpltrb);
		add(lblpltrb);
		ico=new ImageIcon("totbl.png");
		lbltotbl=new JLabel("total bill");
		lbltotbl.setIcon(ico);
		lbltotbl.setBounds(350, 600, 120,40);
		add(lbltotbl);
		String []month={"01","02","03","04","05","06","07","08","09","10","11","12"};
	    m=new JComboBox(month);
	    m.setBounds(450, 140, 50, 20);
	    m.setSelectedItem(dd.substring(indx1+1,dd.indexOf('-',indx1+1)));
	    add(m);
	    m.addActionListener(new ActionListener() 
	    {
			public void actionPerformed(ActionEvent e)
			{
				Calendar c=Calendar.getInstance();
				int year=Integer.parseInt(tyr.getText());
				int mnth=m.getSelectedIndex();
				int date=1;
				c.set(year,mnth,date);
				int days=c.getActualMaximum(Calendar.DAY_OF_MONTH);
				tdy.setText(String.valueOf(days));
			}
		});
		mod=new DefaultListModel();
		lst=new JList(mod);
		JScrollPane scroll=new JScrollPane(lst);
		scroll.setBounds(50, 150, 200, 300);
		add(scroll);
		tyr=new JLabel();
		tyr.setBounds(625, 138,100, 30);
		tyr.setText(dd.substring(0,indx1));
		tyr.setForeground(Color.cyan);
		add(tyr);
		Calendar c=Calendar.getInstance();
		int year=Integer.parseInt(tyr.getText());
		int mnth=m.getSelectedIndex();
		int date=1;
		c.set(year,mnth,date);
		int days=c.getActualMaximum(Calendar.DAY_OF_MONTH);
		tdy=new JLabel();
		tdy.setBounds(550, 190,100,20);
		tdy.setText(String.valueOf(days));
		tdy.setForeground(Color.cyan);
		add(tdy);
		tdelc=new JLabel();
		tdelc.setBounds(150, 80, 100,20);
		tdelc.setForeground(Color.cyan);
		pnl2.add(tdelc);
		tdelb=new JLabel();
		tdelb.setBounds(150, 120, 100,20);
		tdelb.setForeground(Color.cyan);
		pnl2.add(tdelb);
		txtratec=new JTextField();
		txtratec.setBounds(500,430,100,20);
		txtratec.setText("40");
		add(txtratec);
		txtrateb=new JTextField();
		txtrateb.setBounds(500, 470,100,20);
		txtrateb.setText("45");
		add(txtrateb);
		ttotbl=new JLabel();
		ttotbl.setBounds(480, 610, 100, 20);
		ttotbl.setForeground(Color.cyan);
		add(ttotbl);
		ico=new ImageIcon(new ImageIcon("mdv.png").getImage().
				getScaledInstance(140,55,Image.SCALE_SMOOTH));
		md=new JButton();
		md.setIcon(ico);
		md.setBorder(bdr1);
		md.setBackground(Color.DARK_GRAY);
		md.setBounds(130,10,130,50);
		md.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				s.click.play();
				tc=0;
				tb=0;
			 String id=lst.getSelectedValue().toString(); 
				fetchOne(id);
				fetchOne1(id);
			tdelc.setText(String.valueOf(tc));
			tdelb.setText(String.valueOf(tb));
			}
		});
		add(md);
		pnl2.add(md);
		ico=new ImageIcon(new ImageIcon("gnbl.png").getImage().
				getScaledInstance(140,55,Image.SCALE_SMOOTH));
		gb=new JButton();
		gb.setIcon(ico);
		gb.setBorder(bdr1);
		gb.setBackground(Color.DARK_GRAY);
		gb.setBounds(460, 530, 130, 50);
		gb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				s.click.play();
			Float dc=Float.parseFloat(tdelc.getText());
			Float db=Float.parseFloat(tdelb.getText());
			Float rc=Float.parseFloat(txtratec.getText());
			Float rb=Float.parseFloat(txtrateb.getText());
			tot=1;
		    tot=tot*(dc*rc+db*rb);
		    ttotbl.setText(String.valueOf(tot));
			}
		});
		add(gb);
		ico=new ImageIcon("csave.png");
		save=new JButton();
		save.setIcon(ico);
		save.setBorder(bdr1);
		save.setBackground(Color.DARK_GRAY);
		save.setBounds(100, 500, 100,50);
		save.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{	
				s.click.play();
				 String id=lst.getSelectedValue().toString(); 
				fetchOne2(id);
			}
		});
		add(save);
		setSize(800,700);
		setVisible(true);
		setLocationRelativeTo(null);
		repaint();
	}
	void fetchIds()
	{
	mod.removeAllElements();
	mod.addElement("Ids");
	try{
	pst=con.prepareStatement("select custId from milkman");
	ResultSet rs= pst.executeQuery();
	while(rs.next())
	{
	String id=rs.getString("custId");
	mod.addElement(id+"");
	}
	pst.close();
	}
	catch(Exception ex)
	{}
	}
	String curdate() {
   	 String v="";
			try
			{
				pst=con.prepareStatement("select current_date() as cdate");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					v=rs.getDate("cdate").toString();
				}
			}
			catch(Exception e){}
			return v;
		
	}
	void fetchOne(String id)
	{
		 
	try{
		pst=con.prepareStatement("select * from milkman where custId=?");
		pst.setString(1,id);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
		    Float c=rs.getFloat("qtyc");
			Float b=rs.getFloat("qtyb");
			tc=tc+c;
			tb=tb+b;
		}
			Integer i=Integer.parseInt(tdy.getText());
		    tc=tc*i;
		    tb=tb*i;
		pst.close();
	}
	catch(SQLException e){}
	}
	void fetchOne1(String id)
	{
		 
	try{
		pst=con.prepareStatement("select sum(qtyPlusC) as s1,sum(qtyMinusC) as s2,sum(qtyPlusB) as s3," +
				               "sum(qtyMinusB) as s4 from variations where custId=? and month(vdate)=?");
		pst.setString(1,id);
		pst.setString(2,m.getSelectedItem().toString());
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
		    mc=rs.getFloat("s1");
			lc=rs.getFloat("s2");
			mb=rs.getFloat("s3");
			lb=rs.getFloat("s4");
		}
			tc=tc+mc-lc;
			tb=tb+mb-lb;
		pst.close();
	}
	catch(SQLException e){}
	}
	void fetchOne2(String id)
	{
		try{
			pst=con.prepareStatement("select distinct month from bill where custId=?");
			pst.setString(1,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				 mm=rs.getString("month");
				 mnth=(String) m.getSelectedItem();
			}
			if(mm.equals(mnth))
				JOptionPane.showMessageDialog(null,"Already Exist");
			else
				save();
		}
		catch(Exception ex){}
	}
	void save()
	{
	try{
		pst=con.prepareStatement("insert into bill values(?,?,?,?,?,?,?,?,?,?)");
		pst.setString(1,String.valueOf(lst.getSelectedValue()));
		pst.setFloat(2,Float.parseFloat(tdelc.getText()));
		pst.setFloat(3,Float.parseFloat(tdelb.getText()));
		pst.setFloat(4,Float.parseFloat(txtratec.getText()));
		pst.setFloat(5,Float.parseFloat(txtrateb.getText()));
		pst.setFloat(6,Float.parseFloat(ttotbl.getText()));
		pst.setInt(7,0);
		pst.setString(8,(String)m.getSelectedItem());
		pst.setString(9,tyr.getText());
		pst.setString(10,null);
		int count=pst.executeUpdate();
		JOptionPane.showMessageDialog(null, count+" records Saved");
		pst.close();
	}
	catch(SQLException ex){}
	}
}
public class bill
{
	public static void main(String[] args) 
	{
calcbill cb=new calcbill();
cb.fetchIds();
	}

}
