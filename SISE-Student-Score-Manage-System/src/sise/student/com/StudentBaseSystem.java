package sise.student.com;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sise.student.com.DBHelper;

class StudentBaseSystem extends JFrame{

JPanel manegetar,manegeblock,manegeLeft,manegeRight;
JLabel grandeLabel,classLabel,sidJLabel,sNameJLabel,sexJLabel,
		sAddressJLabel,sgradeLabel,sclassJLabel,sAgeLabel,sPhoneLabel;
JComboBox gradeChoice,classChoice,sexChoice;
JButton updateButton,addButton,deleteButton,saveButton,existButton;
JTextField sidField,sNameField,sAddressField,sgradeField,sclassField,sAgeField,sPhoneField;
String sid,sName,sSex,sAddr,sgrade,sclass,sAge,stel;
static DefaultTableModel data;
static JTable table;
Container con;
	public StudentBaseSystem() {
		super("学生基本信息管理");
		con =getContentPane();
		manegetar =new JPanel(new FlowLayout());
		grandeLabel = new JLabel("所属年级:");
		String []grade= {"  ","初一","初二","初三"};
		gradeChoice =new JComboBox<String>(grade);
		classLabel = new JLabel("所属班级:");
		String []classl = {"  ","一班","二班","三班"};
		classChoice =new JComboBox<String>(classl);
		updateButton =new JButton("刷新");
		addButton =new JButton("添加");
		deleteButton =new JButton("删除");
		saveButton =new JButton("存盘");
		existButton =new JButton("退出");
		
		data=new DefaultTableModel();//添加JTable
		table=new JTable(data);
//		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(30);
		JScrollPane p=new JScrollPane(table);
		//设置滚动条
		p.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		p.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		con=getContentPane();
		con.add(p,"Center");
		
		manegeblock =new JPanel(new BorderLayout());
		manegeLeft =new JPanel(new GridLayout(4, 2));
		sidJLabel =new JLabel("学生编号");
		sidField =new JTextField(16);
		sNameJLabel =new JLabel("学生姓名");
		sNameField =new JTextField(16);
		sexJLabel =new JLabel("性别");
		String []sex = {"男","女"};
		sexChoice=new JComboBox<String>(sex);
		sAddressJLabel =new JLabel("家庭地址");
		sAddressField =new JTextField(16);
		
		manegeRight =new JPanel(new GridLayout(4, 2));
		sgradeLabel =new JLabel("年级");
		sgradeField =new JTextField();
		sclassJLabel =new JLabel("班级名称");
		sclassField =new JTextField(16);
		sAgeLabel =new JLabel("年龄");
		sAgeField =new JTextField();
		sPhoneLabel =new JLabel("联系电话");
		sPhoneField =new JTextField(16);
		//==========================================================
		//布局
		manegetar.add(grandeLabel);
		manegetar.add(gradeChoice);
		manegetar.add(classLabel);
		manegetar.add(classChoice);
		manegetar.add(updateButton);
		manegetar.add(addButton);
		manegetar.add(deleteButton);
		manegetar.add(saveButton);
		manegetar.add(existButton);
		con.add(manegetar,"North");
		
		//============================================================
		//布局
		manegeLeft.add(sidJLabel);
		manegeLeft.add(sidField);
		manegeLeft.add(sNameJLabel);
		manegeLeft.add(sNameField);
		manegeLeft.add(sexJLabel);
		manegeLeft.add(sexChoice);
		manegeLeft.add(sAddressJLabel);
		manegeLeft.add(sAddressField);
		
		manegeRight.add(sgradeLabel);
		manegeRight.add(sgradeField);
		manegeRight.add(sclassJLabel);
		manegeRight.add(sclassField);
		manegeRight.add(sAgeLabel);
		manegeRight.add(sAgeField);
		manegeRight.add(sPhoneLabel);
		manegeRight.add(sPhoneField);
		//==============================================================
		//布局
		manegeblock.add(manegeLeft,"West");
		manegeblock.add(manegeRight,"East");

		con.add(manegeblock,"South");
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setVisible(true);
		setFont(new Font("宋体",Font.PLAIN,28));
		//设置面板居中
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2 );
		
		
		//进行年级筛选
		gradeChoice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String gradeString=(String) e.getItem();
				
				if(gradeString.equals("初一")) {
					AddStudentJTable.tableMove(); 
					AddStudentJTable.addJTable(); //清楚table
					String sql="select * from tb_studentinfo where grade = "+"'"+gradeString+"'";
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
							StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if (gradeString.equals("初二")) {
					AddStudentJTable.tableMove(); 
					AddStudentJTable.addJTable(); //清楚table
					String sql="select * from tb_studentinfo where grade = "+"'"+gradeString+"'";
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
							StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				else if (gradeString.equals("初三")) {
					AddStudentJTable.tableMove(); 
					AddStudentJTable.addJTable(); //清楚table
					String sql="select * from tb_studentinfo where grade = "+"'"+gradeString+"'";
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
							StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
			
		
		//进行班级筛选
		classChoice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String as =(String) gradeChoice.getSelectedItem();
				String gradeString=(String) e.getItem();
				System.out.println(as);
				
				//年级中筛选班级
				if(as.equals("初一")) {
					System.out.println("ok");
				if(gradeString.equals("一班")) {
					AddStudentJTable.tableMove(); 
					AddStudentJTable.addJTable(); //清楚table
					String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '初一'";
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
							StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if (gradeString.equals("二班")) {
					AddStudentJTable.tableMove(); 
					AddStudentJTable.addJTable(); //清楚table
					String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '初一'";
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
							StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if (gradeString.equals("三班")) {
					AddStudentJTable.tableMove(); 
					AddStudentJTable.addJTable(); //清楚table
					String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '初一'";
					DBHelper.select(sql);
					System.out.println(sql);
					try {
						while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
							StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
									DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
						}
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}}
				
				
				else if(as.equals("初二")) {
					if(gradeString.equals("一班")) {
						AddStudentJTable.tableMove(); 
						AddStudentJTable.addJTable(); //清楚table
						String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '初二'";
						DBHelper.select(sql);
						System.out.println(sql);
						try {
							while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
								StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
					else if (gradeString.equals("二班")) {
						AddStudentJTable.tableMove(); 
						AddStudentJTable.addJTable(); //清楚table
						String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '初二'";
						DBHelper.select(sql);
						System.out.println(sql);
						try {
							while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
								StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
					else if (gradeString.equals("三班")) {
						AddStudentJTable.tableMove(); 
						AddStudentJTable.addJTable(); //清楚table
						String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '初二'";
						DBHelper.select(sql);
						System.out.println(sql);
						try {
							while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
								StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}}
				
				else if(as.equals("初三")) {
					if(gradeString.equals("一班")) {
						AddStudentJTable.tableMove(); 
						AddStudentJTable.addJTable(); //清楚table
						String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '初三'";
						DBHelper.select(sql);
						System.out.println(sql);
						try {
							while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
								StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
					else if (gradeString.equals("二班")) {
						AddStudentJTable.tableMove(); 
						AddStudentJTable.addJTable(); //清楚table
						String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '初三'";
						DBHelper.select(sql);
						System.out.println(sql);
						try {
							while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
								StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
					else if (gradeString.equals("三班")) {
						AddStudentJTable.tableMove(); 
						AddStudentJTable.addJTable(); //清楚table
						String sql="select * from tb_studentinfo where sclass = "+"'"+gradeString+"'"+"and grade = '初三'";
						DBHelper.select(sql);
						System.out.println(sql);
						try {
							while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
								StudentBaseSystem.data.addRow(AddStudentJTable.datarow(DBHelper.rs.getString("sid"),DBHelper.rs.getString("grade"),DBHelper.rs.getString("sclass"),DBHelper.rs.getString("sname"),DBHelper.rs.getString("gender"),DBHelper.rs.getString("age"),
										DBHelper.rs.getString("address"),DBHelper.rs.getString("phone")));
							}
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
				}}
			}
		});
		
		//更新数据
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddStudentJTable.tableMove();            //清楚table
				UpdataInfo.Alluser();
			}
		});
		
		//添加数据
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String getAdd =e.getActionCommand();
				if(getAdd.equals("添加")) {
					System.out.println("ok");
					sid=sidField.getText();
					sName=sNameField.getText();
					sSex=(String)sexChoice.getSelectedItem();
					sAddr=sAddressField.getText();
					sgrade=sgradeField.getText();
					sclass=sclassField.getText();
					sAge=sAgeField.getText();
					stel=sPhoneField.getText();
					String sql1 ="select * from tb_studentinfo where sid = "+"'"+sid+"'";
					ResultSet rs = DBHelper.select(sql1);
					if(sid.equals("")||sName.equals("")||sSex.equals("")||sAddr.equals("")||sgrade.equals("")||sclass.equals("")||sAge.equals("")||stel.equals("")) {
						JOptionPane.showMessageDialog(null,"请您完善填写信息！");
					} else
						try {
							if(rs.next()==true) {
											JOptionPane.showMessageDialog(null,"该信息已存在！");
											
										}

								else if(rs.next()==false){
								String sql=	"insert into tb_studentinfo (sid,grade,sclass,sname,gender,age,address,phone)" +"values" 
										+"("+"'"+sid+"'"+","+"'"+sgrade+"'"+","+"'"+sclass+"'"+","+"'"+sName+"'"+","+"'"+sSex+"'"+","+"'"+sAge+"'"+","+"'"+sAddr+"'"+","+"'"+stel+"'"+")";
										System.out.println(sql);
										int i =DBHelper.update(sql);
										if(i==0) {
											JOptionPane.showMessageDialog(null,"添加失败，请检查填写的编号是否为数字！");
										}
										else{JOptionPane.showMessageDialog(null,"添加成功！");}
							}
						} catch (HeadlessException | SQLException e1) {
							e1.printStackTrace();
						}
				}
			}
		});
		
		//删除监听
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String getdelete =e.getActionCommand();
				if(getdelete.equals("删除")) {
					
					int row=table.getSelectedRow();
					//判断是否选中
					if(row==-1) {
						JOptionPane.showMessageDialog(null,"请选择需要删除的数据！");
						System.out.println(row);
					}
					//重新选取
					else {int row1=table.getSelectedRow();
					System.out.println(row1);
//					String msg=;
					if(JOptionPane.showConfirmDialog(null, "Delect '"+data.getValueAt(row1, 0)+"'?","提示",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)
							==JOptionPane.YES_OPTION) {
						
						String sql="delete from tb_studentinfo where sid='"+data.getValueAt(row1,0)+"';";
						System.out.println(data.getValueAt(row1,0));
						System.out.println(sql);
						if (DBHelper.update(sql)==1) {
							JOptionPane.showMessageDialog(null,"删除成功","提示",JOptionPane.INFORMATION_MESSAGE);
							data.removeRow(row1);
						}else {
							JOptionPane.showMessageDialog(null,"删除失败","提示",JOptionPane.ERROR_MESSAGE);
						}
					}
					}
				}
			}
		});
		//存盘监听
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String getSave =e.getActionCommand();
				if(getSave.equals("存盘")) {
					SaveFile.setstudent();
//					JOptionPane.showMessageDialog(null,"保存成功！");
				}
			}
		});
		
		//退出监听
		existButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String getexist =e.getActionCommand();
				if(getexist.equals("退出")) {
					dispose();
				}
			}
		});
		
		
		
		
	}
	
//	public static void main(String []args) {
//		StudentBaseSystem sbS =new StudentBaseSystem(); 
//}
}