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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

class recordg extends JFrame
{
	Connection con;
	JPanel pnl1,pnl2,pnl3,pnl4;
	JLabel ttl,ttl1,ttl2,lbldelc,lbldelb,lblmissc,lblmissb,lblcurdate,lblcustIds,lblroutc,lblroutb,lblcow,lblbuffalo;
	JTextField txtroutc,txtroutb,txtdelvc,txtdelvb;
	JRadioButton rbmissc,rbmissb,rbdelc,rbdelb;
	JComboBox d,m,y;
	JList lst;
	DefaultListModel mod;
	JButton btsave,btclose;
	Border bdr,bdr1;
	ImageIcon ico,ico1,ico2;
	PreparedStatement pst;
	soundPlay s=new soundPlay();
	recordg()
	{
		con=connectFile.getConnection();
		if(con==null)
		JOptionPane.showMessageDialog(null, "Connection Error");
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Milk Delivery Record.....");
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		bdr=BorderFactory.createLineBorder(Color.WHITE,3);
		getContentPane().setBackground(Color.darkGray);
		setLayout(null);
		ico=new ImageIcon("record.png");
		ttl=new JLabel();
		ttl.setBounds(130,10,580 ,90);
		ttl.setIcon(ico);
		add(ttl);
		ico=new ImageIcon(new ImageIcon("milk1.png").getImage().
				getScaledInstance(70,70,Image.SCALE_SMOOTH));
		ttl1=new JLabel();
		ttl1.setIcon(ico);
		ttl1.setBounds(700, 10,90,90);
		add(ttl1);
		ttl2=new JLabel();
		ttl2.setIcon(ico);
		ttl2.setBounds(20, 10,90,90);
		add(ttl2);
		ico=new ImageIcon("curdate.png");
		lblcurdate=new JLabel();
		lblcurdate.setIcon(ico);
		lblcurdate.setBounds(20, 130,150,40);
		add(lblcurdate);
		ico=new ImageIcon("custids.png");
		lblcustIds=new JLabel();
		lblcustIds.setIcon(ico);
		lblcustIds.setBounds(50, 190,150,40);
		add(lblcustIds);
		ico=new ImageIcon("routine.png");
		lblroutc=new JLabel();
		lblroutc.setIcon(ico);
		lblroutc.setBounds(400, 160, 100,40);
		lblroutc.setVisible(false);
		add(lblroutc);
		ico=new ImageIcon("routine.png");
		lblroutb=new JLabel();
		lblroutb.setIcon(ico);
		lblroutb.setBounds(400, 380, 100,40);
		lblroutb.setVisible(false);
		add(lblroutb);
		ico=new ImageIcon("cowrec.png");
		lblcow=new JLabel();
		lblcow.setIcon(ico);
		lblcow.setBounds(510, 115,150,40);
		lblcow.setVisible(false);
		add(lblcow);
		ico=new ImageIcon("buffrec.png");
		lblbuffalo=new JLabel();
		lblbuffalo.setIcon(ico);
		lblbuffalo.setBounds(480, 340, 150,40);
		lblbuffalo.setVisible(false);
		add(lblbuffalo);
		ico1=new ImageIcon("delv.png");
		lbldelc=new JLabel();
		lbldelc.setIcon(ico1);
		lbldelc.setBounds(430, 220,120, 40);
		lbldelc.setVisible(false);
		add(lbldelc);
		ico2=new ImageIcon("miss.png");
		lblmissc=new JLabel();
		lblmissc.setIcon(ico2);
		lblmissc.setBounds(610, 220,100, 40);
		lblmissc.setVisible(false);
		add(lblmissc);
		ico1=new ImageIcon("delv.png");
		lbldelb=new JLabel();
		lbldelb.setIcon(ico1);
		lbldelb.setBounds(430, 440,120, 40);
		lbldelb.setVisible(false);
		add(lbldelb);
		ico2=new ImageIcon("miss.png");
		lblmissb=new JLabel();
		lblmissb.setIcon(ico2);
		lblmissb.setBounds(610, 440,100, 40);
		lblmissb.setVisible(false);
		add(lblmissb);
		txtroutc=new JTextField();
		txtroutc.setBounds(510,170, 80,20);
		txtroutc.setVisible(false);
		add(txtroutc);
		txtroutb=new JTextField();
		txtroutb.setBounds(510,390, 80,20);
		txtroutb.setVisible(false);
		add(txtroutb);
		txtdelvc=new JTextField();
		txtdelvc.setBounds(510,280, 80,20);
		txtdelvc.setVisible(false);
		add(txtdelvc);
		txtdelvb=new JTextField();
		txtdelvb.setBounds(510,500, 80,20);
		txtdelvb.setVisible(false);
		add(txtdelvb);
		mod=new DefaultListModel();
		lst=new JList(mod);
		JScrollPane scroll=new JScrollPane(lst);
		scroll.setBounds(50, 230, 200, 300);
		lst.addMouseListener(new MouseListener() {
			
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
				if(lst.getSelectedIndex()!=0)
				{
				 String id=lst.getSelectedValue().toString(); 
					fetchOne(id);
					lblroutc.setVisible(true);
					lblroutb.setVisible(true);
					lblcow.setVisible(true);
					lblbuffalo.setVisible(true);
					txtroutc.setVisible(true);
					txtroutb.setVisible(true);
					rbdelc.setVisible(true);
					lbldelc.setVisible(true);
					rbdelb.setVisible(true);
					lbldelb.setVisible(true);
					Float f=Float.parseFloat(txtroutc.getText());
					if(f!=0)
					{
						rbmissc.setVisible(true);
					    lblmissc.setVisible(true);
					}
					else
					{
						rbmissc.setVisible(false);
						lblmissc.setVisible(false);
					}
					Float ff=Float.parseFloat(txtroutb.getText());
					if(ff!=0)
					{
						rbmissb.setVisible(true);
					    lblmissb.setVisible(true);	
					}
					else
					{
						rbmissb.setVisible(false);
						lblmissb.setVisible(false);
					}
					pnl1.setBorder(bdr);
			        pnl2.setBorder(bdr);
				}
			}
		});
		add(scroll);
		String dd=curdate();
		int indx1=dd.indexOf('-');
		int indx2=dd.indexOf('-',indx1+1);
		String []days={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15"
				,"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		d=new JComboBox(days);
		d.setBounds(170,140, 50,20);
		d.insertItemAt("dd",0);
		d.setSelectedItem(dd.substring(indx2+1));
		add(d);
		String []month={"01","02","03","04","05","06","07","08","09","10","11","12"};
		m=new JComboBox(month);
		m.setBounds(230, 140, 50,20);
		m.insertItemAt("mm",0);
		m.setSelectedItem(dd.substring(indx1+1,dd.indexOf('-',indx1+1)));
		add(m);
		String []year={"2006","2007","2008","2009","2010","2011","2012","2013","2014","2015",
				        "2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};				
		y=new JComboBox(year);
		y.setBounds(290, 140, 60, 20);
		y.insertItemAt("yyyy",0);
		y.setSelectedItem(dd.substring(0,indx1));
		add(y);
		rbmissc=new JRadioButton();
		rbdelc=new JRadioButton();
		 final ButtonGroup grp=new ButtonGroup();
		 grp.add(rbmissc);
		 grp.add(rbdelc);
		rbdelc.setBounds(420, 230,20,20);
		rbmissc.setBounds(600, 230,20,20);
		rbdelc.setBackground(Color.darkGray);
		rbmissc.setBackground(Color.darkGray);
		rbdelc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(rbdelc.isSelected())
				txtdelvc.setVisible(true);
		    
			}
		});
		rbmissc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rbmissc.isSelected())
					txtdelvc.setVisible(false);
			}
		});
		rbdelc.setVisible(false);
		rbmissc.setVisible(false);
		add(rbmissc);
		add(rbdelc);
		rbmissb=new JRadioButton();
		rbdelb=new JRadioButton();
		 final ButtonGroup grp1=new ButtonGroup();
		 grp1.add(rbmissb);
		 grp1.add(rbdelb);
		rbdelb.setBounds(420, 450,20,20);
		rbmissb.setBounds(600, 450,20,20);
		rbdelb.setBackground(Color.darkGray);
		rbmissb.setBackground(Color.darkGray);
		rbdelb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(rbdelb.isSelected())
				txtdelvb.setVisible(true);
			}
		});
		rbmissb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(rbmissb.isSelected())
				txtdelvb.setVisible(false);
			}
		});
		rbdelb.setVisible(false);
		rbmissb.setVisible(false);
		add(rbmissb);
		add(rbdelb);
		pnl1=new JPanel();
		pnl1.setBounds(400, 150, 300,170);
		pnl1.setBackground(Color.darkGray);
		pnl1.setLayout(null);
		add(pnl1);
		pnl2=new JPanel();
		pnl2.setBounds(400, 370, 300,170);
		pnl2.setBackground(Color.darkGray);
		pnl2.setLayout(null);
		add(pnl2);
		pnl3=new JPanel();
		pnl3.setBounds(0, 0, 789,110);
		pnl3.setBackground(Color.gray);
		pnl3.setLayout(null);
		pnl3.setBorder(bdr);
		add(pnl3);
		pnl4=new JPanel();
		pnl4.setBounds(0, 562, 789,105);
		pnl4.setBackground(Color.gray);
		pnl4.setLayout(null);
		pnl4.setBorder(bdr);
		add(pnl4);
		/*update =new JButton("update");
		update.setBounds(350, 580, 100,50);
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		     update();
			}
		} );
		add(update);*/
		ico=new ImageIcon("cclose.png");
		btclose=new JButton("close");
		btclose.setIcon(ico);
		btclose.setBorder(bdr1);
		btclose.setBackground(Color.GRAY);
		btclose.setBounds(600,30,100,50);
		btclose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//s.click.play();
			dispose();	
			}
		});
		add(btclose);
		pnl4.add(btclose);
		ico=new ImageIcon("csave.png");
		btsave=new JButton();
		btsave.setIcon(ico);
		btsave.setBounds(100, 30, 100,50);
		btsave.setBorder(bdr1);
		btsave.setBackground(Color.GRAY);
		btsave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//s.click.play();
				if(lst.getSelectedIndex()==0)
					JOptionPane.showMessageDialog(null,"please select id");
				else
			save();	
			}
		});
		add(btsave);
		pnl4.add(btsave);
		setSize(800,700);
		setVisible(true);
		setLocationRelativeTo(null);
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
	void fetchIds()
	{
	mod.removeAllElements();
	mod.addElement("Select Id");
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
	void fetchOne( String id)
	{
		try{
			pst=con.prepareStatement("select * from milkman where custId=?");
			pst.setString(1,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Float n=rs.getFloat("qtyc");
				Float a=rs.getFloat("qtyb");
				txtroutc.setText(String.valueOf(n));
				txtroutb.setText(a.toString());
			}
			pst.close();
		}
		catch(SQLException e)
		{}
	}
	void save()
	{
		try {
			pst=con.prepareStatement("insert into variations values(?,?,?,?,?,?)");
			pst.setString(1,String.valueOf(lst.getSelectedValue()));
			/*if(morec.isSelected())
			pst.setFloat(3,Float.parseFloat(txt3.getText()));
			else 
			pst.setFloat(3,0.0f);
		    if(lessc.isSelected())
			pst.setFloat(4,Float.parseFloat(txt3.getText()));
			else if(missc.isSelected())
				pst.setFloat(4,Float.parseFloat(txt1.getText()));
			else
			pst.setFloat(4,0.0f);
			if(moreb.isSelected())
			pst.setFloat(5,Float.parseFloat(txt4.getText()));
			else 
			pst.setFloat(5,0.0f);
		    if(lessb.isSelected())
			pst.setFloat(6,Float.parseFloat(txt4.getText()));
		    else if(missb.isSelected())
		    	pst.setFloat(6,Float.parseFloat(txt2.getText()));
		    else
			pst.setFloat(6,0.0f);*/
			if(rbdelc.isSelected())
			{
				Float r=Float.parseFloat(txtroutc.getText());
				Float t=Float.parseFloat(txtdelvc.getText());
				if(r<t)
				{
					Float s=t-r;
					pst.setFloat(3,s);
				}
				else 
					pst.setFloat(3,0.0f);
				if(r>t)
				{
					Float s=r-t;
					pst.setFloat(4,s);
				}
				else
					pst.setFloat(4,0.0f);
			}
			else if(rbmissc.isSelected())
			{
					pst.setFloat(4,Float.parseFloat(txtroutc.getText()));
					pst.setFloat(3,0.0f);
			}
			else 
			{
					pst.setFloat(3,0.0f);
					pst.setFloat(4,0.0f);
			}
			if(rbdelb.isSelected())
				{
					Float r1=Float.parseFloat(txtroutb.getText());
					Float t1=Float.parseFloat(txtdelvb.getText());
					if(r1<t1)
					{
						Float s1=t1-r1;
						pst.setFloat(5,s1);
					}
					else 
						pst.setFloat(5,0.0f);
					if(r1>t1)
					{
						Float s1=r1-t1;
						pst.setFloat(6,s1);
					}
					else
						pst.setFloat(6,0.0f);
				}
			else if(rbmissb.isSelected())
					{
						pst.setFloat(6,Float.parseFloat(txtdelvb.getText()));
						pst.setFloat(5,0.0f);
					}
					else 
					{
						pst.setFloat(5,0.0f);
						pst.setFloat(6,0.0f);
					}
		    String full=d.getSelectedItem()+"-"+m.getSelectedItem()+"-"+y.getSelectedItem();
			DateFormat format=new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date ud=format.parse(full);
			java.sql.Date sdate=new java.sql.Date(ud.getTime());
			pst.setDate(2, sdate);
			int count=pst.executeUpdate();
			JOptionPane.showMessageDialog(null, count+" records Saved");
			pst.close();
			} 
			catch (SQLException e) 
			{
			e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
public class milkDeliveryRecord {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
recordg r=new recordg();
r.fetchIds();
	}

}
