package jsg;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

class payment extends JFrame
{
	Connection con;
	JComboBox ids;
	JPanel pnl1;
	JTextField txtpymntdone;
	JLabel ttl,ttl1,ttl2,lblcustid,lblmnth,lblyr,lblmnthbl,lbloldbl,lbltotbl,lblpymntdone,
	         ttotbl,tmnthbl,toldbl,tmnth,tyr;
	JButton fetch,paid;
	Border bdr,bdr1;
	ImageIcon ico;
	PreparedStatement pst;
	soundPlay s=new soundPlay();
	static float tot=0,f,pl;
	payment()
	{
		con=connectFile.getConnection();
		if(con==null)
		JOptionPane.showMessageDialog(null, "Connection Error");
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Bill Payment.....");
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
		setLayout(null);
		getContentPane().setBackground(Color.DARK_GRAY);
		bdr=BorderFactory.createLineBorder(Color.white,3);
		pnl1=new JPanel();
		pnl1.setBounds(0,0,489,110);
		pnl1.setLayout(null);
		pnl1.setBackground(Color.GRAY);
		pnl1.setBorder(bdr);
		add(pnl1);
		ico=new ImageIcon("billp.png");
		ttl=new JLabel();
		ttl.setBounds(85,10,400 ,90);
		ttl.setIcon(ico);
		pnl1.add(ttl);
		ico=new ImageIcon(new ImageIcon("bp.png").getImage().
				getScaledInstance(70,70,Image.SCALE_SMOOTH));
		ttl1=new JLabel();
		ttl1.setIcon(ico);
		ttl1.setBounds(400, 10,90,90);
		pnl1.add(ttl1);
		ttl2=new JLabel();
		ttl2.setIcon(ico);
		ttl2.setBounds(20, 10,90,90);
		pnl1.add(ttl2);
		ids=new JComboBox();
		ids.setBounds(180, 130,150,20);
		add(ids);
		ico=new ImageIcon("1.png");
		lblcustid=new JLabel();
		lblcustid.setIcon(ico);
		lblcustid.setBounds(80,120, 100,40);
		add(lblcustid);
		ico=new ImageIcon("mnth.png");
		lblmnth=new JLabel();
		lblmnth.setIcon(ico);
		lblmnth.setBounds(30,190, 100,40);
		add(lblmnth);
		ico=new ImageIcon("year.png");
		lblyr=new JLabel();
		lblyr.setIcon(ico);
		lblyr.setBounds(30,240, 100,40);
		add(lblyr);
		ico=new ImageIcon("mbill.png");
		lblmnthbl=new JLabel();
		lblmnthbl.setIcon(ico);
		lblmnthbl.setBounds(30,290, 150,40);
		add(lblmnthbl);
		ico=new ImageIcon("bal.png");
		lbloldbl=new JLabel();
		lbloldbl.setIcon(ico);
		lbloldbl.setBounds(30,340, 100,40);
		add(lbloldbl);
		ico=new ImageIcon("totbl.png");
		lbltotbl=new JLabel();
		lbltotbl.setIcon(ico);
		lbltotbl.setBounds(30,390, 130,40);
		add(lbltotbl);
		ico=new ImageIcon("pa.png");
		lblpymntdone=new JLabel();
		lblpymntdone.setIcon(ico);
		lblpymntdone.setBounds(30,440, 150,40);
		add(lblpymntdone);
		tmnth=new JLabel();
		tmnth.setBounds(200,200,80,20);
		tmnth.setForeground(Color.green);
		add(tmnth);
		tyr=new JLabel();
		tyr.setBounds(200,250,80,20);
		tyr.setForeground(Color.green);
		add(tyr);
		tmnthbl=new JLabel();
		tmnthbl.setBounds(200,300,80,20);
		tmnthbl.setForeground(Color.green);
		add(tmnthbl);
		toldbl=new JLabel();
		toldbl.setBounds(200,350,80,20);
		toldbl.setForeground(Color.green);
		add(toldbl);
		ttotbl=new JLabel();
		ttotbl.setBounds(200,400,80,20);
		ttotbl.setForeground(Color.green);
		add(ttotbl);
		txtpymntdone=new JTextField();
		txtpymntdone.setBounds(200,450,100,20);
		add(txtpymntdone);
		ico=new ImageIcon(new ImageIcon("fetch.png").getImage().
				getScaledInstance(110,55,Image.SCALE_SMOOTH));
		fetch=new JButton();
		fetch.setIcon(ico);
		fetch.setBackground(Color.DARK_GRAY);
		fetch.setBorder(bdr1);
		fetch.setBounds(350, 180,100,50);
		add(fetch);
		fetch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s.click.play();
				String id=ids.getSelectedItem().toString(); 
				fetch(id);	
				fetch1(id);
				fetch2(id);
				ttotbl.setText(String.valueOf(tot));
			}
		});
		ico=new ImageIcon(new ImageIcon("pd.png").getImage().
				getScaledInstance(110,55,Image.SCALE_SMOOTH));
		paid=new JButton();
		paid.setIcon(ico);
		paid.setBackground(Color.DARK_GRAY);
		paid.setBorder(bdr1);
		paid.setBounds(200,500,100,50);
		add(paid);
		paid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s.click.play();
				if(txtpymntdone.getText().length()==0)
					JOptionPane.showMessageDialog(null, "No payment");
				else
				{
			        done();	
			        paid();
				}
			}
		});
		setSize(500,600);
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
	void fetch(String id)
	{
		try{
			pst=con.prepareStatement("select distinct month from bill where custId=? " +
					                      "and paymentStatus=0");
			pst.setString(1, id);
			ResultSet rs=pst.executeQuery();
			String ff="";
			while(rs.next())
			{
				String m=rs.getString("month");
				ff=ff+m+",";
					}
		ff=ff.substring(0, ff.length()-1);
		tmnth.setText(ff);
		}
		catch(Exception e){}
	}
	void fetch1(String id)
	{
		try{
			pst=con.prepareStatement("select sum(totbill) as totbl,year from bill" +
					              " where custId=? and paymentStatus=0");
			pst.setString(1,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				f=rs.getFloat("totbl");
				String y=rs.getString("year");
				tmnthbl.setText(String.valueOf(f));
				tyr.setText(y);
			}
			tot=f;
			pst.close();
		}
		catch(SQLException ex){}
	}
	void fetch2(String id)
	{
		try{
			pst=con.prepareStatement("select paymentLeft from milkman where custId=?");
			pst.setString(1,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				pl=rs.getFloat("paymentLeft");
				toldbl.setText(String.valueOf(pl));
			}
			tot=tot+pl;
			pst.close();
		}
		catch(Exception ex){}
	}
	void done()
	{
		try{
			pst=con.prepareStatement("update bill set paidDate=current_date,paymentStatus=1"  +
					" where custId=? and paymentStatus=0");
			pst.setString(1,(String)ids.getSelectedItem());
			int count=pst.executeUpdate();
			if(count==0)
			JOptionPane.showMessageDialog(null, "Invalid id");
			else
			JOptionPane.showMessageDialog(null, count+" records Updated");
			pst.close();
		}
		catch(Exception ex)
		{}
	}
	void paid()
	{
		try{
			pst=con.prepareStatement("update milkman set paymentLeft=? where custId=?");
			pst.setString(2,(String)ids.getSelectedItem());
			Float tb=Float.parseFloat(ttotbl.getText());
			Float pd=Float.parseFloat(txtpymntdone.getText());
			Float plft=tb-pd;
			    pst.setFloat(1,plft);
			int count=pst.executeUpdate();
			if(count==0)
			JOptionPane.showMessageDialog(null, "Invalid id");
			else
			JOptionPane.showMessageDialog(null, count+" records Updated");
			pst.close();
		}
		catch(Exception e){}
	}
}
public class billpayment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		payment pm=new payment();
		pm.fetchIds();
	}

}
