package jsg;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;

import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.table.*;
class showInTable extends JFrame
{ 
Connection con;
PreparedStatement pstmt;
ResultSet rs;
JButton loadAll=new JButton("load All & Send SMS");
JButton print=new JButton("Print");
JButton smsb=new JButton("Send SMS");
JTable table;
public showInTable() 
{
setLayout(null);
loadAll.setBounds(100, 10, 200, 50);
add( loadAll);
print.setBounds(300, 10, 200, 50);
add( print);
smsb.setBounds(520, 10, 200, 50);
add( smsb);
loadAll.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) 
{
fillTable();
}
});
print.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
try {
table.print();
} catch (PrinterException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
}
});
smsb.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
String mob=JOptionPane.showInputDialog("Enter Mobile No:");
String msg=SST_SMS.bceSunSoftSend(mob, "Hello Dear");
if(msg.equals("sent"))
JOptionPane.showMessageDialog(null, msg);
else
JOptionPane.showMessageDialog(null,"com/internet con. problem");
}
});
setSize(700,400);
setVisible(true);
}

void fillTable()
{
try {
con=connectFile.getConnection();
if(con==null)
JOptionPane.showMessageDialog(null, "Connection Error");
String sql = "Select * from milkman";
pstmt = con.prepareStatement(sql);
rs = pstmt.executeQuery();
ResultSetMetaData md = rs.getMetaData();
Vector<String> columnNames = new Vector<String>();
int columns = md.getColumnCount();
for (int i = 1; i <= columns; i++)
{
columnNames.addElement( md.getColumnName(i) );
}
//--------------------------------------------------
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
pstmt.close();
table = new JTable((TableModel) data, (TableColumnModel) columnNames);
JScrollPane scrollPane = new JScrollPane( table );
table.setBackground(Color.YELLOW);
table.setSelectionBackground(Color.red);
//table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
scrollPane.setBounds(100, 100, 400, 200);
add( scrollPane );
}
catch(Exception nex)
{
nex.printStackTrace();
}
}
}
public class jtable extends showInTable
{
public static void main(String args[])
{
new showInTable();
}
}
