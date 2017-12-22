package jsg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
class win extends JFrame
{
Connection con;
JTextField txtId=new JTextField();
JButton bt=new JButton("Save");
PreparedStatement pst;
win()
{
con=connectFile.getConnection();
if(con==null)
JOptionPane.showMessageDialog(null, "Connection Error");
//else
//JOptionPane.showMessageDialog(null, "Connection Established");
setLayout(null);
txtId.setBounds(100, 100, 100, 50);
add(txtId);
bt.setBounds(100, 200, 100, 50);
add(bt);
bt.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
save();
//update();
}
});
setSize(400, 400);
setVisible(true);
}
void save()
{
try {
pst=con.prepareStatement("insert into students values(?,?,ece,?,CURRENT_DATE())");
pst.setInt(1,Integer.parseInt(txtId.getText()));
pst.setString(2, "Gabbar Singh");
pst.setFloat(3, 88.99f);
int count=pst.executeUpdate();
JOptionPane.showMessageDialog(null, count+" records Saved");
pst.close();
} 
catch (SQLException e) 
{
e.printStackTrace();
}
}
void update()
{
try {
pst=con.prepareStatement("update students set tname=?, per=? where tid=?");
pst.setInt(3,Integer.parseInt(txtId.getText()));
pst.setString(1, "Mugambo/Kalia");
pst.setFloat(2, 88.99f);
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
}
}
void fetchAll()
{
try{
pst=con.prepareStatement("select * from students");
ResultSet rs= pst.executeQuery();
while(rs.next())
{
int id=rs.getInt("rollno");
String tname=rs.getString("sname");
float per=rs.getFloat("per");
System.out.println(id+" "+tname+" "+per);
}
pst.close();
}
catch(Exception ex)
{}
}
void del()
{
try {
pst=con.prepareStatement("delete from students where tid=?");
pst.setInt(1, 101);
int count=pst.executeUpdate();
JOptionPane.showMessageDialog(null, count+" records Deleted");
pst.close();
} 
catch (SQLException e) 
{
e.printStackTrace();
}
}
}
public class CRUD2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		win w=new win();
		//w.save();
		//w.del();
		w.fetchAll();
	}

}
