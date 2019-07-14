package sise.student.com;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;


public class ScoreManageSystem  extends JFrame{
//private java.awt.Image image;
	ScoreManageSystem(){
		//设置菜单栏
		super("学生成绩管理系统");
		MenuBar menubar=new MenuBar ();
		Menu fatorMenu=new Menu("【参数设置】");
		Menu baseManageMenu=new Menu("【基本信息】");
		Menu systemSelectMenu=new Menu("【系统查询】");
		Menu systemManage=new Menu("【系统管理】");
		
		MenuItem gradeSet=new MenuItem("年级设置");
		MenuItem classSet=new MenuItem("班级设置");
		MenuItem exaMenuItem=new MenuItem("考试科目");
		MenuItem examKindItem=new MenuItem("考试类别");
		
		MenuItem studentInfo=new MenuItem("学生信息");
		MenuItem teacherInfo=new MenuItem("教师信息");
		MenuItem examScore=new MenuItem("考试成绩");
		
		MenuItem baseInfo=new MenuItem("基本信息");
		MenuItem ScoreInfo=new MenuItem("成绩信息");
		MenuItem sumInfo=new MenuItem("汇总信息");
		
		MenuItem userPair=new MenuItem("用户维护");
		MenuItem existSys=new MenuItem("退出系统");
		
		
		fatorMenu.add(gradeSet);
		fatorMenu.add(classSet);
		fatorMenu.add(exaMenuItem);
		fatorMenu.add(examKindItem);
		baseManageMenu.add(studentInfo);
		baseManageMenu.add(teacherInfo);
		baseManageMenu.add(examScore);
		systemSelectMenu.add(baseInfo);
		systemSelectMenu.add(ScoreInfo);
		systemSelectMenu.add(sumInfo);
		systemManage.add(userPair);
		systemManage.add(existSys);
		menubar.add(fatorMenu);
		menubar.add(baseManageMenu);
		menubar.add(systemSelectMenu);
		menubar.add(systemManage);
		setMenuBar(menubar);
		menubar.setFont(new Font("宋体",Font.PLAIN,15));
		
		JPanel panel =new JPanel(new BorderLayout());
		JPanel panel1 =new JPanel(new BorderLayout());
		JPanel panelBar =new JPanel(new FlowLayout(FlowLayout.LEFT));
		//添加图片
		ImageIcon iiIcon26 =new ImageIcon("src\\Picture\\26.jpg");
		JLabel paint1 =new JLabel(iiIcon26);
		ImageIcon iiIcon27 =new ImageIcon("src\\Picture\\27.jpg");
		JLabel paint2 =new JLabel(iiIcon27);
		ImageIcon iiIcon28 =new ImageIcon("src\\Picture\\28.jpg");
		JLabel paint3 =new JLabel(iiIcon28);
		ImageIcon iiIcon29 =new ImageIcon("src\\Picture\\29.jpg");
		JLabel paint4 =new JLabel(iiIcon29);
		ImageIcon iiIcon0000 =new ImageIcon("src\\Picture\\0000.jpg");
		final JLabel paint5 =new JLabel(iiIcon0000);
		ImageIcon iiIcon00 =new ImageIcon("src\\Picture\\000.jpg");
		JLabel paint6 =new JLabel(iiIcon00);
		panelBar.add(paint1);
		panelBar.add(paint2);
		panelBar.add(paint3);
		panelBar.add(paint4);
		panelBar.add(paint5);
		panelBar.add(paint6);
		panel.add(panelBar,"North");
		panel.add(panel1,"West");
		add(panel,"North");
	    //设置面板前景色和背景色
		panel.setBackground(Color.RED);
		panel.setForeground(Color.GREEN);
		
		ImageIcon iiIcon =new ImageIcon("src\\Picture\\3.jpg");
		JLabel label =new JLabel(iiIcon);
		label.setSize(900,700);
		this.add(label,"South");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900,700);
		setBackground(Color.GREEN);
		setForeground(Color.GREEN);
		setVisible(true);
		setFont(new Font("宋体",Font.PLAIN,15));
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2 );
		
		//图标的鼠标监听器
		
		paint1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				new StudentBaseSystem();
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		paint4.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "该功能开发中.....！");	
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		paint6.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				new Picture();
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		paint2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				new TeacherBaseSystem();
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		paint3.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				new ScoreInfomation() ;
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		paint5.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
			int i = JOptionPane.showConfirmDialog(null,"确定退出系统吗？","提示",JOptionPane.YES_NO_OPTION);
				 if(i==0){//是==0，否执行else
					    System.exit(0);
					 }
					 else;
				
				}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		//用户维护
		userPair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "该功能开发中.....！");				}});
		//成绩信息
		ScoreInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ScoreInfomation() ;
				}
			
		});
		//汇总信息
		 sumInfo.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new SumOfInformation();
					}
				
			});
		 //考试成绩
		examScore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GradeSet();
				}
			
		});
		//考试类型
		examKindItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new sise.student.com.ExamKindSet();
				}
			
		});
		//课程信息
		exaMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ExamCourseSet();
				}
			
		});
		//班级信息
		classSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ClassManageSet();
				}
			
		});
		//年级信息
		gradeSet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GradeManageSet();
				}
			
		});
		//教师信息
		teacherInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new TeacherBaseSystem();
				}
			
		});
		//学生信息
		studentInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StudentBaseSystem();
				}
			
		});
		//基本信息查询
		baseInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Query1();
				}
			
		});
		//退出界面按钮
		 existSys.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null,"确定退出系统吗？","提示",JOptionPane.YES_NO_OPTION);
				 if(i==0){//是==0，否执行else
					 System.exit(0);
				 }
				 else;
			}
			
		});
	}
	
//	public static void main(String[] args) {
//	ScoreManageSystem s=new ScoreManageSystem();
//	// Yonghudenglu y=new  Yonghudenglu();
//	//GradeSet g=new GradeSet();
//	}

}
