package sise.student.com;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Yonghudenglu extends JFrame {
	private JLabel label1, label2;
	private JTextField userName1;// 用户名
	private JPasswordField password1;// 密码输入框
	private JButton button1, button2;
	 String username=null;
	 String password=null;
	public Yonghudenglu() {
		super("系统用户登录");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new ImagePanel();
		getContentPane().add(panel);

		// 设置panel的布局方式为null
		panel.setLayout(null);

		// 添加两个“用户名”“密码”的label，通过字体的大小更改label的大小
		label1 = new JLabel("用户名:");
		label1.setFont(new Font("宋体", Font.BOLD, 26));
		label1.setForeground(Color.BLACK);
		label1.setBounds(475, 350, 100, 50);
		label2 = new JLabel("密  码:");
		label2.setFont(new Font("宋体", Font.BOLD, 26));
		label2.setForeground(Color.BLACK);
		label2.setBounds(475, 430, 100, 50);

		// 添加两个输入框，用于输入用户名和密码。用户名用JTextFied，密码用JPasswordField
		userName1 = new JTextField(17);
		userName1.setBounds(575, 350, 200, 50);
		userName1.setFont(new Font("宋体", Font.BOLD, 20));
		userName1.setColumns(100);

		password1 = new JPasswordField(17);
		password1.setBounds(575, 430, 200, 50);
		password1.setFont(new Font("宋体", Font.BOLD, 30));
		password1.setColumns(15);
		// char c = '#';
		// password.setEchoChar(c);

		// 添加两个按钮，用于显示登录和注销功能！！
		ImageIcon iiIcon =new ImageIcon("src\\Picture\\12.jpg");
		ImageIcon iiIcon1 =new ImageIcon("src\\Picture\\13.jpg");
		JButton button1=new	JButton("登陆",iiIcon);
		JButton button2=new	JButton("退出",iiIcon1);
		button1.setFont(new Font("宋体", Font.BOLD, 26));
		button1.setForeground(Color.black);
		button1.setBounds(475, 530, 100, 50);


	
		button2.setFont(new Font("宋体", Font.BOLD, 26));
		button2.setForeground(Color.black);
		button2.setBounds(675, 530, 100, 50);

		// 添加所需组件
		panel.add(label1);
		panel.add(userName1);
		panel.add(label2);
		panel.add(password1);
		panel.add(button1);
		panel.add(button2);
		
		button1.addActionListener(new ActionListener() {   
			public void actionPerformed(ActionEvent e) {
				
				String s1 =new String(password1.getPassword());;
				String sql1 ="select * from tb_user where username ="+"'"+userName1.getText()+"'"+" and "+"pwd ="+"'"+s1+"'" ;
				System.out.println(sql1);
				ResultSet rs=DBHelper.select(sql1);
				
				try {
					if(rs.next()==true){
					
					new ScoreManageSystem();
						dispose();
					
					}else
						if(userName1.getText().equals("")||password1.equals("")) {
							JOptionPane.showMessageDialog(null, "请先输入账号密码！");
					}
					else 
					
						JOptionPane.showMessageDialog(null, "请输入正确的账号密码！");
				} catch (HeadlessException e1) {
					
					e1.printStackTrace();
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
				
	}
				
				
		});
		 button2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					}
				
			});
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 700);// 窗体大下
		setLocation(100, 100);// 窗口初始位置
		setResizable(false);// 不可更改窗体大小
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 默认关闭方式
		setVisible(true);// 窗口可见
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2 );
	}

	class ImagePanel extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			ImageIcon icon = new ImageIcon("src\\Picture\\2.jpg");
			g.drawImage(icon.getImage(), 0, 0, null);
		}
	}
	public static void main(String[] args) {
		 Yonghudenglu y=new  Yonghudenglu();
		}
}
