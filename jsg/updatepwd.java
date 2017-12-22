package jsg;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
public class updatepwd extends JFrame
{
Connection con;
JPanel pnl1;
JLabel lbl1,lblun,lbloldpwd,lblnewpwd;
JTextField txtun,txtoldpwd,txtnewpwd;
JButton update;
Border bdr,bdr1;
PreparedStatement pst;
ImageIcon ico;
soundPlay s=new soundPlay();
String newpwd;
public updatepwd()
{
	con=connectFile.getConnection();
	if(con==null)
	JOptionPane.showMessageDialog(null, "Connection Error");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
bdr=BorderFactory.createLineBorder(Color.white,3);
setTitle("Update Password.....");
setUndecorated(true);
getRootPane().setWindowDecorationStyle(JRootPane.QUESTION_DIALOG);
getContentPane().setBackground(Color.darkGray);
setLayout(null);
pnl1=new JPanel();
pnl1.setLayout(null);
pnl1.setBackground(Color.gray);
pnl1.setBorder(bdr);
pnl1.setBounds(0, 0, 490, 110);
add(pnl1);
ico=new ImageIcon("up.png");
lbl1=new JLabel();
lbl1.setIcon(ico);
lbl1.setBounds(30,10, 420, 90);
pnl1.add(lbl1);
ico=new ImageIcon("uid.png");
lblun=new JLabel();
lblun.setIcon(ico);
lblun.setBounds(70, 120, 150, 40);
add(lblun);
ico=new ImageIcon("opwd.png");
lbloldpwd=new JLabel();
lbloldpwd.setIcon(ico);
lbloldpwd.setBounds(70, 170, 150,40);
add(lbloldpwd);
ico=new ImageIcon("npwd.png");
lblnewpwd=new JLabel();
lblnewpwd.setIcon(ico);
lblnewpwd.setBounds(70, 220, 150, 40);
add(lblnewpwd);
txtun=new JTextField();
txtun.setBounds(230,130,150,20);
add(txtun);
txtoldpwd=new JTextField();
txtoldpwd.setBounds(230,180,150,20);
add(txtoldpwd);
txtnewpwd=new JTextField();
txtnewpwd.setBounds(230,230,150,20);
txtnewpwd.addFocusListener(new FocusListener() {
	
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		String exp="(?=^.{8,}$)(?=.*\\d)(?=.*[!@#$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
		String pw=txtnewpwd.getText();
		if(pw.matches(exp))
		{}
		else
		{
		JOptionPane.showMessageDialog(null,"enter valid password");
		txtnewpwd.setText(null);
		}
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
});
add(txtnewpwd);
ico=new ImageIcon("cupdate.png");
update=new JButton();
update.setBounds(190,330,120,60);
update.setIcon(ico);
update.setBorder(bdr1);
update.setBackground(Color.darkGray);
add(update);
update.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stuba
	s.click.play();
update();
}
});
setResizable(false);
setSize(500,500);
setVisible(true);
setLocationRelativeTo(null);
}
void update()
{
try
{
pst=con.prepareStatement("update login set password=? where custId=? and password=?");
pst.setString(1,txtnewpwd.getText());
pst.setString(2,txtun.getText());
pst.setString(3,txtoldpwd.getText());
int count=pst.executeUpdate();
if(count==0)
	JOptionPane.showMessageDialog(null, "Invalid id or password please enter valid one");
	else{
	JOptionPane.showMessageDialog(null," password Updated");
String mob=JOptionPane.showInputDialog("Enter Mobile No:");
String msg=SST_SMS.bceSunSoftSend(mob,newpwd);
if(msg.equals("sent"))
JOptionPane.showMessageDialog(null, msg);
else
JOptionPane.showMessageDialog(null,"com/internetcon. problem");}
	pst.close();
}
catch (Exception e)
{
// TODO: handle exception
}
}
public static void main(String[] args) {
	updatepwd up= new updatepwd();	
}
}