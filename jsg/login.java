package jsg;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
class userlogin extends JFrame
{
Connection con;
JLabel lblun,lblpwd,lbl1,lbl2;
JTextField txtun;
JPasswordField pwd;
Border bdr,bdr1;
JPanel pnl1,pnl2,pnl3;
JButton login,chngepwd,forgetpwd;
ImageIcon ico;
PreparedStatement pst;
soundPlay s=new soundPlay();
String id,pw,mb,pass,mob,uid,password;
public userlogin()
{
progress.main(new String[]{});
con=connectFile.getConnection();
if(con==null)
JOptionPane.showMessageDialog(null, "Connection Error");
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLayout(null);
setTitle("LOGIN.....");
setUndecorated(true);
getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
bdr=BorderFactory.createLineBorder(Color.white,3);
getContentPane().setBackground(Color.darkGray);
pnl2=new JPanel();
pnl2.setLayout(null);
pnl2.setBackground(Color.gray);
pnl2.setBorder(bdr);
pnl2.setBounds(0, 0, 490, 110);
add(pnl2);
pnl3=new JPanel();
pnl3.setLayout(null);
pnl3.setBackground(Color.gray);
pnl3.setBorder(bdr);
pnl3.setBounds(0,380, 490, 86);
add(pnl3);
pnl1=new JPanel();
pnl1.setLayout(null);
pnl1.setBorder(bdr);
pnl1.setBackground(Color.DARK_GRAY);
pnl1.setBounds(290, 120, 180, 180);
add(pnl1);
ico=new ImageIcon("ac.png");
lbl2=new JLabel();
lbl2.setIcon(ico);
lbl2.setBounds(40,10, 400, 90);
pnl2.add(lbl2);
ico=new ImageIcon(new ImageIcon("userlogin.png").getImage().
		getScaledInstance(150,150,Image.SCALE_SMOOTH));
lbl1=new JLabel();
lbl1.setIcon(ico);
lbl1.setBounds(50, 170, 150, 150);
add(lbl1);
ico=new ImageIcon("uid.png");
lblun=new JLabel();
lblun.setIcon(ico);
lblun.setBounds(0, 10, 110, 40);
pnl1.add(lblun);
txtun=new JTextField();
txtun.setBounds(20,50,150,20);
pnl1.add(txtun);
ico=new ImageIcon("pwd.png");
lblpwd=new JLabel("Password");
lblpwd.setIcon(ico);
lblpwd.setBounds(0, 90, 110, 40);
pnl1.add(lblpwd);
pwd=new JPasswordField();
pwd.setBounds(20,130,150,20);
pwd.addFocusListener(new FocusListener() {
	
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		s.click.play();
		String exp="(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
		char pw[]= pwd.getPassword();
		String ss=new String(pw);
		if(ss.matches(exp))
		{}
		else
		{
			JOptionPane.showMessageDialog(null,"enter valid password");
			pwd.setText(null);
		}
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
});
pnl1.add(pwd);
ico=new ImageIcon("btlogin.png");
login=new JButton();
login.setIcon(ico);
login.setBackground(Color.DARK_GRAY);
login.setBorder(bdr1);
login.setBounds(320, 320,100,50);
add(login);
login.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
s.click.play();
showhomepage();
openhomepage();
}
});
ico=new ImageIcon(new ImageIcon("chgpwd.png").getImage().
		getScaledInstance(155,50,Image.SCALE_SMOOTH));
chngepwd=new JButton();
chngepwd.setIcon(ico);
chngepwd.setBackground(Color.gray);
chngepwd.setBorder(bdr1);
chngepwd.setBounds(50, 20,150,50);
add(chngepwd);
pnl3.add(chngepwd);
chngepwd.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
	s.click.play();
updatepwd.main(new String[]{});
}
});
ico=new ImageIcon(new ImageIcon("frgt.png").getImage().
		getScaledInstance(105,50,Image.SCALE_SMOOTH));
forgetpwd=new JButton();
forgetpwd.setIcon(ico);
forgetpwd.setBackground(Color.gray);
forgetpwd.setBorder(bdr1);
forgetpwd.setBounds(300,20,100,50);
add(forgetpwd);
pnl3.add(forgetpwd);
forgetpwd.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
	s.click.play();
forgotPwd();

}
});
setSize(500, 500);
setVisible(true);
setResizable(false);
setLocationRelativeTo(null);
repaint();
}
void forgotPwd()
{
try
{
pst=con.prepareStatement("select password,mobile from login where custId=? ");
uid=txtun.getText();
pst.setString(1, uid);
ResultSet rs=pst.executeQuery();
while(rs.next())
{
pass=rs.getString("password");
mob=rs.getString("mobile");
}
String msg=SST_SMS.bceSunSoftSend(mob,pass);
if(msg.equals("Your message is successfully sent to:91"+mob))
JOptionPane.showMessageDialog(null, msg);
else
JOptionPane.showMessageDialog(null,"com/internetcon. problem");
}
catch (Exception e)
{
// TODO: handle exception
}
}
public void showhomepage()
{
uid=txtun.getText();
char pas[]=pwd.getPassword();
password=String.valueOf(pas);
try
{
pst=con.prepareStatement("select * from login ");
ResultSet rs=pst.executeQuery();
while(rs.next())
{
id=rs.getString("custId");
pw=rs.getString("password");
mb=rs.getString("mobile");
}
}
catch (Exception e)
{
// TODO: handle exception
}
}
public void openhomepage()
{
if(uid.equals(id) && password.equals(pw))
{
homepage.main(new String[]{});
}
else
{
JOptionPane.showMessageDialog(null, "wrong password or username");
}
}
}
public class login
{
public static void main(String args[])
{
 userlogin ul=new userlogin();
}
}
