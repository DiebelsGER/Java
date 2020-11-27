package z_test;

import javax.swing.*;

public class JInternalFrameExample {
 
  public static void main(String[] args) {
 
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("JInternalFrame Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,300);
 
    JDesktopPane desktop = new JDesktopPane();
 
    JInternalFrame if1 = new JInternalFrame("Frame 1", true, true, true, true );
    if1.setSize(200,200);
    desktop.add(if1);
 
    JInternalFrame if2 = new JInternalFrame("Frame 2", true, true, true, true );
    if2.setSize(200,200);
    desktop.add(if2);
 
    if1.setLocation(20,20);
    if1.setVisible(true);
    if2.setLocation(40,40);
    if2.setVisible(true);
 
    frame.add(desktop);
    frame.setVisible(true);
  }
}