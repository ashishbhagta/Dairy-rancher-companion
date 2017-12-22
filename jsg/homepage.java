package jsg;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.Border;
class Mainpage extends JFrame
{
	Connection con;
JLabel ttl,lblcust,lbl1,lblrecord,lbl2,lblbill,lbl3,lblpymnt,lbl4,lblenquiry,lbl5,lbldetail,lbl6,lbl7;
JPanel pnl1;
JButton baboutus,phn;
Border bdr,bdr1;
ImageIcon ico;
Mainpage()
{
	con=connectFile.getConnection();
	if(con==null)
	JOptionPane.showMessageDialog(null, "Connection Error");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
bdr=BorderFactory.createLineBorder(Color.white,3);
setTitle("Catalogue.....");
setUndecorated(true);
getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
getContentPane().setBackground(Color.darkGray);
setLayout(null);
pnl1=new JPanel();
pnl1.setLayout(null);
pnl1.setBackground(Color.GRAY);
pnl1.setBounds(0,0,590,110);
add(pnl1);
pnl1.setBorder(bdr);
ico=new ImageIcon(new ImageIcon("cat.png").getImage().
		getScaledInstance(400,100,Image.SCALE_SMOOTH));
//ico=new ImageIcon("cat.png");
ttl=new JLabel();
ttl.setIcon(ico);
ttl.setBounds(90, 5,450,100);
add(ttl);
pnl1.add(ttl);
ico=new ImageIcon(new ImageIcon("customer.png").getImage().
		getScaledInstance(90,90,Image.SCALE_SMOOTH));
lbl1=new JLabel();
lbl1.setIcon(ico);
lbl1.setBounds(80,130, 90, 90);
add(lbl1);
lbl1.addMouseListener(new MouseListener() {
@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
MilkMan.main(new String[]{});
}
});
ico=new ImageIcon("ce.png");
lblcust=new JLabel();
lblcust.setIcon(ico);
lblcust.setBounds(20,220,210,40);
add(lblcust);
lblcust.addMouseListener(new MouseListener() {
@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
MilkMan.main(new String[]{});
}
});
ico=new ImageIcon(new ImageIcon("milk3.png").getImage().
		getScaledInstance(90,90,Image.SCALE_SMOOTH));
lbl2=new JLabel();
lbl2.setIcon(ico);
lbl2.setBounds(430,130, 90, 90);
add(lbl2);
lbl2.addMouseListener(new MouseListener() {
@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
milkDeliveryRecord.main(new String[]{});
}
});
ico=new ImageIcon("rec.png");
lblrecord=new JLabel("milk Delivery Record");
lblrecord.setIcon(ico);
lblrecord.setBounds(350,220,230,40);
add(lblrecord);
lblrecord.addMouseListener(new MouseListener() {
@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
milkDeliveryRecord.main(new String[]{});
}
});
ico=new ImageIcon(new ImageIcon("INVOICE.png").getImage().
		getScaledInstance(90,90,Image.SCALE_SMOOTH));
lbl3=new JLabel();
lbl3.setIcon(ico);
lbl3.setBounds(80,290, 90, 90);
add(lbl3);
lbl3.addMouseListener(new MouseListener() {
@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
bill.main(new String[]{});
}
});
ico=new ImageIcon("bl.png");
lblbill=new JLabel();
lblbill.setIcon(ico);
lblbill.setBounds(40,380,210,40);
add(lblbill);
lblbill.addMouseListener(new MouseListener() {
@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
bill.main(new String[]{});
}
});
ico=new ImageIcon(new ImageIcon("billpayment.png").getImage().
		getScaledInstance(90,90,Image.SCALE_SMOOTH));
lbl4=new JLabel();
lbl4.setIcon(ico);
lbl4.setBounds(430,290, 90, 90);
add(lbl4);
lbl4.addMouseListener(new MouseListener() {
@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
billpayment.main(new String[]{});
}
});
ico=new ImageIcon("blpymnt.png");
lblpymnt=new JLabel("Bill Payment");
lblpymnt.setIcon(ico);
lblpymnt.setBounds(380,380,170,40);
add(lblpymnt);
lblpymnt.addMouseListener(new MouseListener() {
@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
billpayment.main(new String[]{});
}
});
ico=new ImageIcon(new ImageIcon("inquiry.png").getImage().
		getScaledInstance(90,90,Image.SCALE_SMOOTH));
lbl5=new JLabel();
lbl5.setIcon(ico);
lbl5.setBounds(80,430, 90, 90);
add(lbl5);
lbl5.addMouseListener(new MouseListener() {
@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
custEnquiry.main(new String[]{});
}
});
ico=new ImageIcon("ceq.png");
lblenquiry=new JLabel("Customer Enquiry");
lblenquiry.setIcon(ico);
lblenquiry.setBounds(20,520,210,40);
add(lblenquiry);
lblenquiry.addMouseListener(new MouseListener() {
@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
custEnquiry.main(new String[]{});
}
});
ico=new ImageIcon(new ImageIcon("Billpay.png").getImage().
		getScaledInstance(90,90,Image.SCALE_SMOOTH));
lbl6=new JLabel();
lbl6.setIcon(ico);
lbl6.setBounds(430,430, 90, 90);
add(lbl6);
lbl6.addMouseListener(new MouseListener() {
@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
paymentDetail.main(new String[]{});
}
});
ico=new ImageIcon("det.png");
lbldetail=new JLabel("Payment Detail");
lbldetail.setIcon(ico);
lbldetail.setBounds(380,520,200,40);
add(lbldetail);
lbldetail.addMouseListener(new MouseListener() {
@Override
public void mouseReleased(MouseEvent e) {
}
@Override
public void mousePressed(MouseEvent e) {
}
@Override
public void mouseExited(MouseEvent e) {
}
@Override
public void mouseEntered(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
paymentDetail.main(new String[]{});
}
});
ico=new ImageIcon(new ImageIcon("aboutus.png").getImage().
		getScaledInstance(90,90,Image.SCALE_SMOOTH));
lbl7=new JLabel();
lbl7.setIcon(ico);
lbl7.setBounds(250,480, 90, 90);
add(lbl7);
lbl7.addMouseListener(new MouseListener() {
	
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
		aboutus.main(new String[]{});	
	}
});
ico=new ImageIcon(new ImageIcon("about.png").getImage().
		getScaledInstance(140,50,Image.SCALE_SMOOTH));
baboutus=new JButton();
baboutus.setIcon(ico);
baboutus.setBackground(Color.DARK_GRAY);
baboutus.setBorder(bdr1);
baboutus.setBounds(230,580,140,50);
baboutus.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	aboutus.main(new String[]{});	
	}
});
add(baboutus);
setSize(600,700);
setVisible(true);
setResizable(false);
setLocationRelativeTo(null);
}
}
public class homepage
{
public static void main(String[] args)
{
Mainpage mp=new Mainpage();
}
}
