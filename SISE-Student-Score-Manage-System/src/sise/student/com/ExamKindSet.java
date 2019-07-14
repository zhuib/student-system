package sise.student.com;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.*;

public class ExamKindSet extends JFrame {
	static DefaultTableModel data;
	static JTable table;
	static JTextField examField,checkField;
	static String sql;
	public ExamKindSet() {
		super("考试类型设置");
		Container con =getContentPane();
		
		data=new DefaultTableModel();//添加JTable
		table=new JTable(data);
//		table.setEnabled(false);
		table.setPreferredScrollableViewportSize(new Dimension(500,300));
		table.setFont(new Font("宋体",Font.CENTER_BASELINE,15));
		Dimension size =table.getTableHeader().getPreferredSize();
		size.height=42;
		table.getTableHeader().setPreferredSize(size);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		table.setGridColor(Color.BLACK);
		table.setSelectionBackground(Color.darkGray);
		table.setSelectionForeground(Color.WHITE);
		table.setRowHeight(30);
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);//设置排序
		
		JScrollPane p1=new JScrollPane(table);
		p1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		p1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		con=getContentPane();
		con.add(p1,"Center");
		
			
		JPanel JPanel =new JPanel(new GridLayout(2,2));
		JLabel examJLabel =new JLabel("科目");
		examJLabel.setFont(new Font("宋体",Font.CENTER_BASELINE,20));
		examField =new JTextField(20);
		JLabel checkaJLabel =new JLabel("考试类型");
		checkaJLabel.setFont(new Font("宋体",Font.CENTER_BASELINE,20));
		checkField =new JTextField(20);
		
		JPanel butJPanel =new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton dropButton =new JButton("删除");
		JButton addButton =new JButton("添加");
		JButton saveButton =new JButton("存盘");
		JButton existButton =new JButton("退出");
		
		con.add(p1,"North");
		
		JPanel.add(examJLabel);
		JPanel.add(examField);
		JPanel.add(checkaJLabel);
		JPanel.add(checkField);
		con.add(JPanel,"Center");
		
		butJPanel.add(dropButton);
		butJPanel.add(addButton);
		butJPanel.add(saveButton);
		butJPanel.add(existButton);
		con.add(butJPanel,"South");
		
		AddExamKindTable.tableMove(); 
		AddExamKindTable.addGradeTable();
		String sqlString ="select * from tb_examkinds";
		DBHelper.select(sqlString);				
		try {
			while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
				ExamKindSet.data.addRow(AddExamKindTable.datarow(DBHelper.rs.getString("exam"),DBHelper.rs.getString("checka")));
			}
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
		
		setSize(600, 520);
		setFont(new Font("宋体",Font.PLAIN,15));
		setForeground(Color.black);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width-getWidth())/2,(screen.height-getHeight())/2 );
		
		
		dropButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object getDrop =e.getSource();
				if(getDrop==dropButton) {
					if(getDrop==dropButton) {
						
						int row=table.getSelectedRow();
						//判断是否选中
						if(row==-1) {
							JOptionPane.showMessageDialog(null,"请选择需要删除的数据！");
							System.out.println(row);
						}
						//重新选取
						else {int row1=table.getSelectedRow();
						String msg="Delect '"+data.getValueAt(row, 0)+"'?";
						if (JOptionPane.showConfirmDialog(null, msg,"提示",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE)
								==JOptionPane.YES_OPTION) {
							String sql="delete from tb_examkinds where exam='"+data.getValueAt(row,0).toString()+"';";
							System.out.println(data.getValueAt(row,0));
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
				}}
			});
			
	
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String exam=examField.getText();
				String checka=checkField.getText();
				
				
				String sql1 ="select * from tb_examkinds where exam = "+"'"+exam+"'";
				ResultSet rs = DBHelper.select(sql1);
				AddExamKindTable.tableMove();            //清楚table
				AddExamKindTable.addGradeTable();  //添加表头
			if(examField.getText().equals("")){
				JOptionPane.showMessageDialog(null,"请您完善填写信息！");
				String sqlString ="select * from tb_examkinds";
				DBHelper.select(sqlString);				
				
					try {
						while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
							ExamKindSet.data.addRow(AddExamKindTable.datarow(DBHelper.rs.getString("exam"),DBHelper.rs.getString("checka")));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}else if (checkField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"请您完善填写信息！");
					String sqlString ="select * from tb_examkinds";
					DBHelper.select(sqlString);				
					
						try {
							while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
								ExamKindSet.data.addRow(AddExamKindTable.datarow(DBHelper.rs.getString("exam"),DBHelper.rs.getString("checka")));
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					
		    } else
				try {
					if(rs.next()==true) {
						JOptionPane.showMessageDialog(null,"该信息已存在！");
						String sqlString ="select * from tb_examkinds";
						DBHelper.select(sqlString);				
						
							while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
								ExamKindSet.data.addRow(AddExamKindTable.datarow(DBHelper.rs.getString("exam"),DBHelper.rs.getString("checka")));
							}
					}
					

			else if(rs.next()==false){
				AddExamKindTable.tableMove();            //清楚table
				AddExamKindTable.addGradeTable(); 
				sql="insert into tb_examkinds (exam,checka)" +"values"+"("+"'"+exam+"'"+","+"'"+checka+"'"+")";
				System.out.println(sql);
				DBHelper.update(sql);
				String sqlString ="select * from tb_examkinds";
				DBHelper.select(sqlString);				
				
					while(DBHelper.rs.next()) {  //将数据放入datarow数组中后加到data表里
						ExamKindSet.data.addRow(AddExamKindTable.datarow(DBHelper.rs.getString("exam"),DBHelper.rs.getString("checka")));
					}
				}}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String getAdd =e.getActionCommand();
				if(getAdd.equals("存盘")) {
					SaveFile.setExamkinds();
				}
			}
			
		});
		
		existButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object getExist =e.getSource();
				if(getExist==existButton) {
					dispose();
				}
			}
		});
		
		
	}
	
	
//	public static void main(String[] args) {
//		ExamKindSet gms =new ExamKindSet();
//	}

}
