package sise.student.com;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GradeSet extends JFrame {
	String sid,grade,sclass,sname,math,chinese,english,chemistry,politics,physics;
	JPanel jp1,jp2,jp3,jp4,jp6;
	JButton jb1,jb2,jb3,jb4,jb5;
	JTextField jtfSid,jtfGrade,jtfSclass,jtfSname;
	JTextField jtfChinese,jtfMath,jtfEnglish,jtfChemistry,jtfPolitics,jtfPhysics;
	JLabel jl1,jl2,jl3,jl4,jl5;
	JLabel jl6,jl7,jl8,jl9,jl10;
	static String sql=null;
	static String id=null;
    static JTable table;
	static DefaultTableModel data;
	
	GradeSet(){
		super("考试成绩");
		Container con =getContentPane();
		data=new DefaultTableModel();//添加JTable		
		table=new JTable(data);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);//设置排序
		table.setRowHeight(30);
		table.setSize(500,900);
		table.setBounds(0, 0, 900, 900);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(30);
		
		
		
		setLayout(new GridLayout(3,1));
		jp1=new JPanel ();
		jl1=new JLabel("学生编号");
		jl2=new JLabel("年级");
		jl3=new JLabel("班级");
		jl4=new JLabel("学生姓名");
		jtfSid=new JTextField(10);
		jtfGrade=new JTextField(10);
		jtfSclass=new JTextField(10);
		jtfSname=new JTextField(10);
		jp1.add(jl1);
		jp1.add(jtfSid);
		jp1.add(jl2);
		jp1.add(jtfGrade);
		jp1.add(jl3);
		jp1.add(jtfSclass);
		jp1.add(jl4);
		jp1.add(jtfSname);
		
		jp2=new JPanel ();
		
		jl5=new JLabel("数学:");
		jl6=new JLabel("语文:");
		jl7=new JLabel("英语:");
		jl8=new JLabel("政治:");
		jl9=new JLabel("化学:");
		jl10=new JLabel("物理:");
		jtfMath=new JTextField(5);
		jtfChinese=new JTextField(5);
		jtfEnglish=new JTextField(5);
		jtfChemistry=new JTextField(5);
		jtfPolitics=new JTextField(5);
		jtfPhysics=new JTextField(5);
		jp2.add(jl5);
		jp2.add(jtfMath);
		jp2.add(jl6);
		jp2.add(jtfChinese);
		jp2.add(jl7);
		jp2.add(jtfEnglish);
		jp2.add(jl8);
		jp2.add(jtfPolitics);
		jp2.add(jl9);
		jp2.add(jtfChemistry);
		jp2.add(jl10);
		jp2.add(jtfPhysics);
		jp3=new JPanel ();
		
		jp3.add(jp1);
		jp3.add(jp2);
	    con.add(jp3);

		jp4=new JPanel ();
	//===============================================================
		jp6=new JPanel ();
		
		JScrollPane tableScroll=new JScrollPane(table);
	  	tableScroll.setViewportView(table);
		con.add(tableScroll);
		//显示滚动条
		tableScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tableScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		jb1=new JButton("刷新");
		jb2=new JButton("添加");
		jb4=new JButton("删除");
		jb5=new JButton("退出");
		jp4.add(jb1);
		jp4.add(jb2);
		jp4.add(jb4);
		jp4.add(jb5);
		jp4.setLayout(new FlowLayout(FlowLayout.CENTER));
		con.add(jp4);

		setSize(800,600);
		setVisible(true);
		//窗口居中
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2);
		
		
		//刷新按钮
		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String getAdd =e.getActionCommand();
				if(getAdd.equals("刷新")) {
				AddJTableExamScore.tableMove(); 
				AddJTableExamScore.addJTable();
				String sqlString ="select * from tb_gradeinfo_sub";
				DBHelper.select(sqlString);				
				try {
					while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
						GradeSet.data.addRow(AddJTableExamScore.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),
								DBHelper.rs.getString("math"),DBHelper.rs.getString("chinese"),DBHelper.rs.getString("english"),DBHelper.rs.getString("chemistry"),DBHelper.rs.getString("politics"),
								DBHelper.rs.getString("physics")));
					}
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
				
				}
			}
			
		});
		

		//退出按钮
		jb5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			dispose();
				}
			
		});
		
		AddJTableExamScore.tableMove(); 
		AddJTableExamScore.addJTable();
		String sqlString ="select * from tb_gradeinfo_sub";
		DBHelper.select(sqlString);				
		try {
			while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
				GradeSet.data.addRow(AddJTableExamScore.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),
						DBHelper.rs.getString("math"),DBHelper.rs.getString("chinese"),DBHelper.rs.getString("english"),DBHelper.rs.getString("chemistry"),DBHelper.rs.getString("politics"),
						DBHelper.rs.getString("physics")));
			}
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
		

		
		//确定按钮的事件
		jb2.addActionListener(new ActionListener() {
			
			private ResultSet rs;

			public void actionPerformed(ActionEvent e) {
				String getAdd =e.getActionCommand();
				AddJTableExamScore.tableMove();
				AddJTableExamScore.addJTable();
				
				
				
				sid=jtfSid.getText();
				grade=jtfGrade.getText();
				sclass=jtfSclass.getText();
				sname=jtfSname.getText();
				math=jtfMath.getText();
				chinese=jtfChinese.getText();
				english=jtfEnglish.getText();
				politics=jtfPolitics.getText();
				chemistry=jtfChemistry.getText();
				physics=jtfPhysics.getText();
				String sql1 ="select * from tb_gradeinfo_sub where sid = "+"'"+sid+"'";
				rs=DBHelper.select(sql1);
				
				if(getAdd.equals("添加")) {
					if(sid.equals("")){
						JOptionPane.showMessageDialog(null,"请您完善填写信息！");
					}else if(grade.equals("")) {
						JOptionPane.showMessageDialog(null,"请您完善填写信息！");
					}else if(sclass.equals("")) {
						JOptionPane.showMessageDialog(null,"请您完善填写信息！");
					}else if(sname.equals("")) {
						JOptionPane.showMessageDialog(null,"请您完善填写信息！");
					}else if(math.equals("")) {
						JOptionPane.showMessageDialog(null,"请您完善填写信息！");
					}else if(chinese.equals("")) {
						JOptionPane.showMessageDialog(null,"请您完善填写信息！");
					}else if(english.equals("")) {
						JOptionPane.showMessageDialog(null,"请您完善填写信息！");
					}else if(politics.equals("")) {
						JOptionPane.showMessageDialog(null,"请您完善填写信息！");
					}else if(chemistry.equals("")) {
						JOptionPane.showMessageDialog(null,"请您完善填写信息！");
					}else if(physics.equals("")) {
						JOptionPane.showMessageDialog(null,"请您完善填写信息！");
					} else
						try {
							if(rs.next()==true) {
								JOptionPane.showMessageDialog(null,"学生编号已存在！");
							}

					else if(rs.next()==false){
								
								System.out.println("?????");
								String sql=	"insert into tb_gradeinfo_sub (sid,grade,sclass,sname,math,chinese,english,chemistry,politics,physics)" +"values" 
										+"("+"'"+sid+"'"+","+"'"+grade+"'"+","+"'"+sclass+"'"+","+"'"+sname+"'"+","+"'"+math+"'"+","+"'"+chinese+"'"+","+"'"+english+"'"+","
										+"'"+politics+"'"+","+"'"+chemistry+"'"+","+"'"+physics+"'"+")";
								System.out.println(sql);
								int i =DBHelper.update(sql);
								if(i==0) {
									JOptionPane.showMessageDialog(null,"添加失败，请您检查编号格式是否为数字！");
								}
								else{JOptionPane.showMessageDialog(null,"学生编号添加成功！");}
							}
						} catch (HeadlessException | SQLException e1) {
							e1.printStackTrace();
						}
				}}
		});
		
		
		//删除按钮
		jb4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object ob=e.getSource();
				
				if(ob==jb4) {
					
					  int row=table.getSelectedRow();
					  System.out.println(row);
					     if(row==-1) {
					         JOptionPane.showMessageDialog(null,"请选择需要删除的数据！");
					         System.out.println(row);
					        }
					        
					        else {int row1=table.getSelectedRow();
					  String msg="Delect '"+data.getValueAt(row, 0).toString()+"'?";
					  if (JOptionPane.showConfirmDialog(null, msg,"提示",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)
					    ==JOptionPane.YES_OPTION) {
					   String sql="delete from tb_gradeinfo_sub where sid='"+data.getValueAt(row,0).toString()+"';";
					   System.out.println(sql);
					   if (DBHelper.update(sql)==1) {
					    JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
					    data.removeRow(row);
					   }else {
					    JOptionPane.showMessageDialog(null,"删除失败","提示",JOptionPane.ERROR_MESSAGE);
				     }
				   }
				 }
     	       }
	         }
		});
				

		
	}
//		public static void main(String[] args) {
//			GradeSet g=new GradeSet();
//			}
	}

