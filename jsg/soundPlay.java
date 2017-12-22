package jsg;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
public class soundPlay extends JFrame 
{
AudioClip click;
JButton btn=new JButton("play");
JButton stop=new JButton("stop");
public soundPlay() {
setLayout(null);
URL urlClick = soundPlay.class.getResource("click_one.wav");
click = Applet.newAudioClip(urlClick);
btn.setBounds(100, 100, 100, 50);
add(btn);
btn.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e)
{
click.play();
URL urlClick = soundPlay.class.getResource("click_one.wav");
AudioClip click2 = Applet.newAudioClip(urlClick);
click2.play();
}
});
stop.setBounds(220, 100, 100, 50);
add(stop);
stop.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) 
{
click.stop();
URL urlClick = soundPlay.class.getResource("click_one.wav");
AudioClip click2 = Applet.newAudioClip(urlClick);
click2.play();

}
});
this.setSize(400, 400);
this.setTitle("Mouse Clicker");
//this.setVisible(true);
}
public static void main(String[] args) {
new soundPlay();
}
}
