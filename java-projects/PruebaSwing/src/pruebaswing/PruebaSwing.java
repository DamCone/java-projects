package pruebaswing;

import javax.swing.*;
public class PruebaSwing {
public static void main(String[ ] args) {
    JFrame frame = new JFrame("Mi marco");
    frame.setSize(400,300);
    ImageIcon g=new ImageIcon("./src/boleta.gif");
    frame.setTitle(frame.getTitle( )+": "+g.toString( )+""+g.getIconHeight( )+"x"+g.getIconWidth( ));
    frame.setIconImage(g.getImage( ));
    frame.setVisible(true);
    
}
}