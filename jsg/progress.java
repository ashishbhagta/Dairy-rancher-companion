package jsg;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.border.Border;
public class progress extends JFrame
{ 
JProgressBar progressBar;
JLabel icon;
progress()
{ setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
icon=new JLabel(); 
icon.setIcon(new ImageIcon("progress.gif"));
add(icon);
//---------------------------
progressBar = new JProgressBar(0,100);
progressBar.setValue(1);
progressBar.setStringPainted(true);
progressBar.setIndeterminate(true);
add(progressBar, BorderLayout.AFTER_LAST_LINE);
progressBar.setBackground(Color.pink);
progressBar.setForeground(Color.black);
setUndecorated(true);
setSize(399, 150);
setVisible(true); 
setLocation(520,250);//screen location
runn();
}
public void runn()
{
for(int i=1;i<=100;i++)
{
progressBar.setValue(i);
try {
Thread.sleep(30);
} catch (Exception e) { }
}
setVisible(false);
dispose();
}
public static void main(String args[])
{
new progress();
}
}