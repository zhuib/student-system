package sise.student.com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Picture extends JFrame {
	Picture(){
		super("Ð£Ô°Í¼Æ¬");
		this.setLayout(new GridLayout(2,2));
		JPanel panel1 =new JPanel(new BorderLayout());
		JPanel Panel1 =new JPanel(new BorderLayout());
		JPanel jp1 =new JPanel(new FlowLayout(FlowLayout.LEFT));
		ImageIcon iiIcon1 =new ImageIcon("src\\Picture\\4.jpg");
		JLabel label1 =new JLabel(iiIcon1);
		
		JPanel panel2 =new JPanel(new BorderLayout());
		JPanel Panel2 =new JPanel(new BorderLayout());
		JPanel jp2 =new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon iiIcon2 =new ImageIcon("src\\Picture\\5.jpg");
		JLabel label2 =new JLabel(iiIcon2);
		
		JPanel panel3 =new JPanel(new BorderLayout());
		JPanel Panel3 =new JPanel(new BorderLayout());
		JPanel jp3 =new JPanel(new FlowLayout(FlowLayout.LEFT));
		ImageIcon iiIcon3 =new ImageIcon("src\\Picture\\6.jpg");
		JLabel label3 =new JLabel(iiIcon3);
		
		JPanel panel4 =new JPanel(new BorderLayout());
		JPanel Panel4 =new JPanel(new BorderLayout());
		JPanel jp4 =new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ImageIcon iiIcon4 =new ImageIcon("src\\Picture\\7.jpg");
		JLabel label4 =new JLabel(iiIcon4);
		
		jp1.add(label1);
		panel1.add(jp1,"North");
		panel1.add(Panel1,"West");
		add(panel1,"North");
		jp2.add(label2);
		panel2.add(jp2,"North");
		panel2.add(Panel2,"East");
		add(panel2,"North");
		jp3.add(label3);
		
		panel3.add(jp3,"North");
		panel3.add(Panel3,"West");
		add(panel3,"Sorth");
		jp4.add(label4);
		panel4.add(jp4,"North");
		panel4.add(Panel4,"East");
		add(panel4,"Sorth");
		
		setSize(800,600);
		setBackground(Color.GREEN);
		setForeground(Color.GREEN);
		setVisible(true);
		setFont(new Font("ËÎÌå",Font.PLAIN,15));
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2 );
	}
//	public static void main(String[] args) {
//		
//		//Picture p=new Picture();
//	}

}
