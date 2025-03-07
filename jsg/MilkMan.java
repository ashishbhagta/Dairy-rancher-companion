package jsg;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.EventHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.Image;
class Customer extends JFrame
{
	Connection con;
	JPanel pnl1,pnl2,pnl3,pnl4;
	JLabel ttl,ttl1,ttl2,lblcustid,lblname,lbladdr,lblmbl,lbltypofmilk,lblqty,lblltrc,lblltrb,lbldos,lbl10,lbl11,lblcow,lblbuff,
	          lblb1,lblb2,lblb3,lblb4,lblb5,lblb6,lblerr;
	JTextField txtname,txtmbl,txtqtyc,txtqtyb;
	JButton save,update,New,delete,close,search;
	JTextArea addr;
	JCheckBox cow,buffalo;
	JComboBox ids,d,m,y;
	ImageIcon ico,ico1,ico2,ico3,ico4,ico5,ico6,ico7,ico8,ico9,ico10,ico11,ico12,ico13,ico14,
	                 ico15,ico16,ico17,ico18;
	Border bdr,bdr1;
	soundPlay s=new soundPlay();
	PreparedStatement pst;
	Customer()
	{
		con=connectFile.getConnection();
		if(con==null)
		JOptionPane.showMessageDialog(null, "Connection Error");
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Customer Enrollment.....");
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		bdr1=BorderFactory.createLineBorder(Color.WHITE,3);
		getContentPane().setBackground(Color.DARK_GRAY);
		setLayout(null);
		pnl3=new JPanel();
		pnl3.setBounds(0,0, 789,110);
		pnl3.setLayout(null);
		pnl3.setBackground(Color.GRAY);
		pnl3.setBorder(bdr1);
		add(pnl3);
		ico1=new ImageIcon("custenroll.png");
		ttl=new JLabel();
		ttl.setIcon(ico1);
		ttl.setBounds(100, 10,580,90);
		add(ttl);
		pnl3.add(ttl);
		ico=new ImageIcon(new ImageIcon("cust.png").getImage().
				getScaledInstance(90,90,Image.SCALE_SMOOTH));
		ttl1=new JLabel();
		ttl1.setIcon(ico);
		ttl1.setBounds(680, 10,90,90);
		add(ttl1);
		pnl3.add(ttl1);
		ttl2=new JLabel();
		ttl2.setIcon(ico);
		ttl2.setBounds(20, 10,90,90);
		add(ttl2);
		pnl3.add(ttl2);
		ico8=new ImageIcon("1.png");
		lblcustid=new JLabel();
		lblcustid.setIcon(ico8);
		lblcustid.setBounds(50,120,100,40);
		add(lblcustid);
		lblb1=new JLabel();
		ico18=new ImageIcon(new ImageIcon("milk.png").getImage().
				getScaledInstance(40,40,Image.SCALE_SMOOTH));
		lblb1.setIcon(ico18);
		lblb1.setBounds(30, 120,40,40);
		add(lblb1);
		lblname=new JLabel();
		ico10=new ImageIcon("2.png");
		lblname.setIcon(ico10);
		lblname.setBounds(50,180,100,40);
		add(lblname);
		lblb2=new JLabel();
		ico18=new ImageIcon(new ImageIcon("milk.png").getImage().
				getScaledInstance(40,40,Image.SCALE_SMOOTH));
		lblb2.setIcon(ico18);
		lblb2.setBounds(30, 180,40,40);
		add(lblb2);
		lbladdr=new JLabel();
		ico11=new ImageIcon("3.png");
		lbladdr.setIcon(ico11);
		lbladdr.setBounds(50,240,100,40);
		add(lbladdr);
		lblb3=new JLabel();
		ico18=new ImageIcon(new ImageIcon("milk.png").getImage().
				getScaledInstance(40,40,Image.SCALE_SMOOTH));
		lblb3.setIcon(ico18);
		lblb3.setBounds(30, 240,40,40);
		add(lblb3);
		lblmbl=new JLabel();
		ico12=new ImageIcon("4.png");
		lblmbl.setIcon(ico12);
		lblmbl.setBounds(50, 350,130,40);
		add(lblmbl);
		lblb4=new JLabel();
		ico18=new ImageIcon(new ImageIcon("milk.png").getImage().
				getScaledInstance(40,40,Image.SCALE_SMOOTH));
		lblb4.setIcon(ico18);
		lblb4.setBounds(30, 350,40,40);
		add(lblb4);
		ico8=new ImageIcon("tom1.png");
		lbltypofmilk=new JLabel();
		lbltypofmilk.setIcon(ico8);
		lbltypofmilk.setBounds(220, 400,300, 40);
		add(lbltypofmilk);
		lblqty=new JLabel();
		ico15=new ImageIcon("quantity.png");
		lblqty.setIcon(ico15);
		lblqty.setBounds(50, 480,100,40);
		lblqty.setVisible(false);
		add(lblqty);
		lblb5=new JLabel();
		ico18=new ImageIcon(new ImageIcon("milk.png").getImage().
				getScaledInstance(40,40,Image.SCALE_SMOOTH));
		lblb5.setIcon(ico18);
		lblb5.setBounds(30, 480,40,40);
		lblb5.setVisible(false);
		add(lblb5);
		lblltrc=new JLabel();
		ico16=new ImageIcon("lite.png");
		lblltrc.setIcon(ico16);
		lblltrc.setBounds(270, 480, 100, 40);
		add(lblltrc);
		lblltrc.setVisible(false);
		lblltrb=new JLabel();
		ico16=new ImageIcon("lite.png");
		lblltrb.setIcon(ico16);
		lblltrb.setBounds(450, 480, 100, 40);
		add(lblltrb);
		lblltrb.setVisible(false);
		lbldos=new JLabel();
		ico17=new ImageIcon("dos.png");
		lbldos.setIcon(ico17);
		lbldos.setBounds(50, 540, 150, 40);
		add(lbldos);
		lblb6=new JLabel();
		ico18=new ImageIcon(new ImageIcon("milk.png").getImage().
				getScaledInstance(40,40,Image.SCALE_SMOOTH));
		lblb6.setIcon(ico18);
		lblb6.setBounds(30, 540,40,40);
		add(lblb6);
		ico9=new ImageIcon(new ImageIcon("milk3.png").getImage().
				getScaledInstance(50,50,Image.SCALE_SMOOTH));
		lbl10=new JLabel();
		lbl10.setIcon(ico9);
		lbl10.setBounds(170, 390,50,50);
		add(lbl10);
		ico9=new ImageIcon(new ImageIcon("milk3.png").getImage().
				getScaledInstance(50,50,Image.SCALE_SMOOTH));
		lbl11=new JLabel();
		lbl11.setIcon(ico9);
		lbl11.setBounds(470, 390,50,50);
		add(lbl11);
		lblcow=new JLabel();
		ico13=new ImageIcon("cow.png");
		lblcow.setIcon(ico13);
		lblcow.setBounds(200, 440,100,40);
		add(lblcow);
		lblbuff=new JLabel();
		ico14=new ImageIcon("buffalo.png");
		lblbuff.setIcon(ico14);
		lblbuff.setBounds(380, 440,130,40);
		add(lblbuff);
		lblerr=new JLabel();
		lblerr.setBounds(350, 350,100,40);
		lblerr.setForeground(Color.red);
		add(lblerr);
		ids=new JComboBox();
		ids.setBounds(180, 130,150,20);
		ids.setEditable(true);
		add(ids);
		ids.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ids.requestFocus();
			}
		});
		txtname=new JTextField();
		txtname.setBounds(180, 190,150,20);
		add(txtname);
		txtname.addFocusListener(new FocusListener() {
	    	@Override
	    	public void focusLost(FocusEvent e) {
	    	if(txtname.getText().length()==0)
	    	{
	    	txtname.requestFocus();
	    	txtname.setBackground(Color.yellow);
	    	}
	    	else
	    	txtname.setBackground(Color.WHITE);
	    	}
	    	@Override
	    	public void focusGained(FocusEvent e) {
	    	}
	    	});
		txtname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			addr.requestFocusInWindow();	
			}
		});
		txtmbl=new JTextField();
		txtmbl.setBounds(180, 360,150,20);
		add(txtmbl);
		txtmbl.addFocusListener(new FocusListener() {
	    	@Override
	    	public void focusLost(FocusEvent e) {
	    		String mobile="^[789]\\[1-9]\\d{9}$";
	    		boolean b=txtmbl.getText().matches(mobile);
	    		if(b==false)
	    		{
	    		lblerr.setText("Invalid...");
	    		txtmbl.requestFocus();
	    		txtmbl.setBackground(Color.yellow);
	    		}
	    		else
	    		{
	    		lblerr.setText("");
	    		txtmbl.setBackground(Color.WHITE);
	    		}
	    	}
	    	public void focusGained(FocusEvent e) {
	    	}
	    	});
		txtqtyc=new JTextField();
		txtqtyc.setBounds(180, 490, 100, 20);
		add(txtqtyc);
		txtqtyc.addFocusListener(new FocusListener() {
	    	@Override
	    	public void focusLost(FocusEvent e) {
	    	if(txtqtyc.getText().length()==0)
	    	{
	    	txtqtyc.requestFocus();
	    	txtqtyc.setBackground(Color.YELLOW);
	    	}
	    	else
	    	txtqtyc.setBackground(Color.WHITE);
	    	
	    	}
	    	@Override
	    	public void focusGained(FocusEvent e) {
	    	}
	    	});
		txtqtyc.setVisible(false);
		txtqtyb=new JTextField();
		txtqtyb.setBounds(360, 490, 100, 20);
		add(txtqtyb);
		txtqtyb.addFocusListener(new FocusListener() {
	    	@Override
	    	public void focusLost(FocusEvent e) {
	    	if(txtqtyb.getText().length()==0)
	    	{
	    	txtqtyb.requestFocus();
	    	txtqtyb.setBackground(Color.YELLOW);
	    	}
	    	else
	    	txtqtyb.setBackground(Color.WHITE);
	    	
	    	}
	    	@Override
	    	public void focusGained(FocusEvent e) {
	    	}
	    	});
		txtqtyb.setVisible(false);
		addr=new JTextArea(50,50);
		JScrollPane scroll=new JScrollPane(addr);
		scroll.setBounds(180, 250, 200,70);
		add(scroll);
		addr.addFocusListener(new FocusListener() {
	    	@Override
	    	public void focusLost(FocusEvent e) {
	    	if(addr.getText().length()==0)
	    	{
	    	addr.requestFocus();
	    	addr.setBackground(Color.YELLOW);
	    	}
	    	else
	    	addr.setBackground(Color.WHITE);
	    	}
	    	@Override
	    	public void focusGained(FocusEvent e) {
	    	}
	    	});
		cow=new JCheckBox();
		//ico13=new ImageIcon("cow.png");
		//cow.setIcon(ico13);
		cow.setBounds(180, 450, 30, 20);
		cow.setBackground(Color.DARK_GRAY);
	    
		cow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(cow.isSelected())
			{
				txtqtyc.setVisible(true);
				lblltrc.setVisible(true);
				lblqty.setVisible(true);
				lblb6.setVisible(true);
				txtqtyc.requestFocus();
			}
			else
			{
				txtqtyc.setVisible(false);
				lblltrc.setVisible(false);
				if(buffalo.isSelected())
				{
					lblqty.setVisible(true);
					lblb6.setVisible(true);
				}
				else
				{
				lblqty.setVisible(false);
				lblb6.setVisible(false);
				}
			}
			}
		});
		add(cow);
		buffalo=new JCheckBox();
		//ico14=new ImageIcon("buffalo.png");
		//buffalo.setIcon(ico14);
		buffalo.setBounds(360, 450, 30, 20);
		buffalo.setBackground(Color.DARK_GRAY);
		buffalo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			if(buffalo.isSelected())
			{
				txtqtyb.setVisible(true);
				lblltrb.setVisible(true);
				lblqty.setVisible(true);
				lblb6.setVisible(true);
				txtqtyb.requestFocus();
			}
			else
			{
				txtqtyb.setVisible(false);
				lblltrb.setVisible(false);
				if(cow.isSelected())
				{
				    lblqty.setVisible(true);
				    lblb6.setVisible(true);
				}
				else
				{
					lblqty.setVisible(false);
					lblb6.setVisible(false);
			    }
			}
			}});
		add(buffalo);
		String []days={"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15"
				,"16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		d=new JComboBox(days);
		d.setBounds(200, 550, 50,20);
		d.insertItemAt("dd",0);
		d.setSelectedIndex(0);
		add(d);
		String []month={"01","02","03","04","05","06","07","08","09","10","11","12"};
		m=new JComboBox(month);
		m.setBounds(260, 550, 50,20);
		m.insertItemAt("mm",0);
		m.setSelectedIndex(0);
		add(m);
		String []year={"2006","2007","2008","2009","2010","2011","2012","2013","2014","2015",
				        "2016","2017","2018","2019","2020","2021","2022","2023","2024","2025"};				
		y=new JComboBox(year);
		y.setBounds(320, 550, 60, 20);
		y.insertItemAt("yyyy",0);
		y.setSelectedIndex(0);
		add(y);
		
		pnl1=new JPanel();
		pnl1.setBounds(30,390, 650,150);
		pnl1.setLayout(null);
		pnl1.setBackground(Color.DARK_GRAY);
		pnl1.setBorder(bdr1);
		add(pnl1);
		pnl2=new JPanel();
		pnl2.setBounds(0,592, 789,75);
		pnl2.setLayout(null);
		pnl2.setBackground(Color.GRAY);
		pnl2.setBorder(bdr1);
		add(pnl2);
		ico2=new ImageIcon(new ImageIcon("csave.png").getImage().
				getScaledInstance(110,55,Image.SCALE_SMOOTH));
		//ico2=new ImageIcon("csave.png");
		save=new JButton();
		save.setIcon(ico2);
		save.setBorder(bdr);
		save.setBackground(Color.GRAY);
		save.setBounds(50, 10, 100, 50);
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//if(ids.getSelectedItem().toString().length()==0)
				//s.click.play();
				if(ids.getSelectedIndex()==0)
				JOptionPane.showMessageDialog(null,"please enter id");
				if(d.getSelectedIndex()==0)
					JOptionPane.showMessageDialog(null,"please enter day");
				if(m.getSelectedIndex()==0)
					JOptionPane.showMessageDialog(null,"please enter month");
				if(y.getSelectedIndex()==0)
					JOptionPane.showMessageDialog(null,"please enter year");
				else
			save();
			}
		}); 
		add(save);
		pnl2.add(save);
		ico3=new ImageIcon(new ImageIcon("cnew.png").getImage().
				getScaledInstance(110,55,Image.SCALE_SMOOTH));
		//ico3=new ImageIcon("cnew.png");
		New=new JButton();
		New.setIcon(ico3);
		New.setBorder(bdr);
		New.setBackground(Color.GRAY);
		New.setBounds(180, 10,100, 50);
		New.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//s.click.play();
			ids.setSelectedItem(null);
			txtname.setText(null);
			txtmbl.setText(null);
			txtqtyc.setText(null);
			txtqtyb.setText(null);
			addr.setText(null);
			cow.setSelected(false);
			buffalo.setSelected(false);
			txtqtyb.setVisible(false);
			lblltrb.setVisible(false);
			lblqty.setVisible(false);
			txtqtyc.setVisible(false);
			lblltrc.setVisible(false);
			d.setSelectedIndex(0);
			m.setSelectedIndex(0);
			y.setSelectedIndex(0);
			}
		});
		add(New);
		pnl2.add(New);
		ico4=new ImageIcon(new ImageIcon("cupdate.png").getImage().
				getScaledInstance(110,55,Image.SCALE_SMOOTH));
		//ico4=new ImageIcon("cupdate.png");
		update=new JButton();
		update.setIcon(ico4);
		update.setBorder(bdr);
		update.setBackground(Color.GRAY);
		update.setBounds(310, 10,100, 50);
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//s.click.play();
			update();	
			}
		});
		add(update);
		pnl2.add(update);
		ico5=new ImageIcon(new ImageIcon("cdelete.png").getImage().
				getScaledInstance(110,55,Image.SCALE_SMOOTH));
		//ico5=new ImageIcon("cdelete.png");
		delete=new JButton();
		delete.setIcon(ico5);
		delete.setBorder(bdr);
		delete.setBackground(Color.GRAY);
		delete.setBounds(460, 10, 100, 50);
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	s.click.play();
			delete();	
			}
		});
		add(delete);
		pnl2.add(delete);
		ico6=new ImageIcon(new ImageIcon("cclose.png").getImage().
				getScaledInstance(110,55,Image.SCALE_SMOOTH));
		//ico6=new ImageIcon("cclose.png");
		close=new JButton();
		close.setIcon(ico6);
		close.setBorder(bdr);
		close.setBackground(Color.GRAY);
		close.setBounds(600, 10,100, 50);
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			//	s.click.play();
			dispose();	
			}
		});
		add(close);
		pnl2.add(close);
		ico7=new ImageIcon(new ImageIcon("csearch.png").getImage().
				getScaledInstance(110,55,Image.SCALE_SMOOTH));
		//ico7=new ImageIcon("csearch.png");
		search=new JButton();
		search.setIcon(ico7);
		search.setBorder(bdr);
		search.setBackground(Color.DARK_GRAY);
		search.setBounds(600, 150, 120, 50);
        search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			//	s.click.play();
				if(ids.getSelectedIndex()!=0)
				{
				 String id=ids.getSelectedItem().toString(); 
					search(id);
				}
			}
		});
		add(search);
		setSize(800,700);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	void save()
	{
	try {
	pst=con.prepareStatement("insert into milkman values(?,?,?,?,?,?,?,?)");
	pst.setString(1,(String)ids.getSelectedItem());
	if(txtname.getText().length()==0)
		pst.setString(2,null);
	else
	    pst.setString(2,txtname.getText());
	if(addr.getText().length()==0)
	    pst.setString(3,null);
	else
	    pst.setString(3, addr.getText());
	if(txtmbl.getText().length()==0)
		pst.setString(4,null);
	else
	    pst.setString(4,txtmbl.getText());
	if(cow.isSelected())
	pst.setFloat(5,Float.parseFloat(txtqtyc.getText()));
	else
		pst.setFloat(5,0.0f);
	if(buffalo.isSelected())
	pst.setFloat(6,Float.parseFloat(txtqtyb.getText()));
	else
		pst.setFloat(6,0.0f);
	String full=d.getSelectedItem()+"-"+m.getSelectedItem()+"-"+y.getSelectedItem();
	DateFormat format=new SimpleDateFormat("dd-MM-yyyy");
	java.util.Date ud=format.parse(full);
	java.sql.Date sdate=new java.sql.Date(ud.getTime());
	pst.setDate(7, sdate);
	pst.setFloat(8,0.0f);
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
	void update()
	{
	try {
	pst=con.prepareStatement("update milkman set name=?, mobile=?,address=?,dos=?,qtyc=?," +
			                    "qtyb=? where custId=?");
	pst.setString(7,(String)ids.getSelectedItem());
	pst.setString(1,txtname.getText());
	pst.setString(2,txtmbl.getText());
	pst.setString(3, addr.getText());
	pst.setFloat(5,Float.parseFloat(txtqtyc.getText()));
	pst.setFloat(6,Float.parseFloat(txtqtyb.getText()));
	String full=d.getSelectedItem()+"-"+m.getSelectedItem()+"-"+y.getSelectedItem();
	DateFormat format=new SimpleDateFormat("dd-MM-yyyy");
	java.util.Date ud=format.parse(full);
	java.sql.Date sdate=new java.sql.Date(ud.getTime());
	pst.setDate(4, sdate);
	int count=pst.executeUpdate();
	if(count==0)
	JOptionPane.showMessageDialog(null, "Invalid id");
	else
	JOptionPane.showMessageDialog(null, count+" records Updated");
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

	void search( String id)
	{
		try{
			pst=con.prepareStatement("select * from milkman where custId=?");
			pst.setString(1,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String n=rs.getString("name");
				String a=rs.getString("address");
				String mb=rs.getString("mobile");
				Float qc=rs.getFloat("qtyc");
				Float qb=rs.getFloat("qtyb");
				Date dt=rs.getDate("dos");
				DateFormat dm=new SimpleDateFormat("MM");
				DateFormat dd=new SimpleDateFormat("dd");
				DateFormat dy=new SimpleDateFormat("yyyy");
				String month=dm.format(dt);
				String day=dd.format(dt);
				String year=dy.format(dt);
				txtname.setText(n);
				txtmbl.setText(mb);
				addr.setText(a);
				txtqtyc.setText(String.valueOf(qc));
				txtqtyc.setVisible(true);
				txtqtyb.setText(String.valueOf(qb));
				txtqtyb.setVisible(true);
			    d.setSelectedItem(day);
			    m.setSelectedItem(month);
			    y.setSelectedItem(year);
			}
			pst.close();
		}
		catch(SQLException e)
		{}
	}
	void delete()
	{
	try {
	pst=con.prepareStatement("delete from milkman where custId=?");
	pst.setString(1,(String)ids.getSelectedItem());
	int count=pst.executeUpdate();
	JOptionPane.showMessageDialog(null, count+" records Deleted");
	pst.close();
	} 
	catch (SQLException e) 
	{
	e.printStackTrace();
	}
	}
	void fetchIds()
	{
	ids.removeAllItems();
	ids.addItem("  ");
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
}
public class MilkMan {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Customer c=new Customer();
c.fetchIds();
	}

}
