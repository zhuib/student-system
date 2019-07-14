package sise.student.com;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SaveFile {
	private static String sql;
	private static boolean key;
//保存年级数据
	public static void set() {
		File file=new File("tb_gradeinfo.txt");
		FileWriter fw=null;
		try {
			fw=new FileWriter(file);
			if(file.exists()) {
				fw.write(new String(""));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			file.createNewFile();
			fw=new FileWriter(file,true);
			fw.write("年级编号\t\t年级名称\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		sql="select * from tb_gradeinfo";
		DBHelper.select(sql);
		try {
			while(DBHelper.rs.next()) {
				String 年级编号=DBHelper.rs.getString("gid");
				String 年级名称=DBHelper.rs.getString("grade");
				try {
					fw.write(年级编号+"\t\t"+年级名称+"\n");
					fw.flush();
					key=true;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(key==true) {
				JOptionPane.showMessageDialog(null, "存盘成功！");
				key=false;
			}
			else {
				JOptionPane.showMessageDialog(null, "存盘失败！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(fw!=null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}}
		}
		
	//保存班级数据
		public static void setclass() {
			File file=new File("tb_classinfo.txt");
			FileWriter fw=null;
			try {
				fw=new FileWriter(file);
				if(file.exists()) {
					fw.write(new String(""));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				file.createNewFile();
				fw=new FileWriter(file,true);
				fw.write("班级编号\t\t班级名称\n");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			sql="select * from tb_classinfo";
			DBHelper.select(sql);
			try {
				while(DBHelper.rs.next()) {
					String 班级编号=DBHelper.rs.getString("cid");
					String 班级名称=DBHelper.rs.getString("sclass");
					try {
						fw.write(班级编号+"\t\t"+班级名称+"\n");
						fw.flush();
						key=true;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(key==true) {
					JOptionPane.showMessageDialog(null, "存盘成功！");
					key=false;
				}
				else {
					JOptionPane.showMessageDialog(null, "存盘失败！");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				if(fw!=null) {
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}}
			}
		//保存课程数据
			public static void setcourse() {
				File file=new File("tb_subject.txt");
				FileWriter fw=null;
				try {
					fw=new FileWriter(file);
					if(file.exists()) {
						fw.write(new String(""));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					file.createNewFile();
					fw=new FileWriter(file,true);
					fw.write("科目编号\t\t科目名称\n");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				sql="select * from tb_subject";
				DBHelper.select(sql);
				try {
					while(DBHelper.rs.next()) {
						String 科目编号=DBHelper.rs.getString("cid");
						String 科目名称=DBHelper.rs.getString("course");
						try {
							fw.write(科目编号+"\t\t"+科目名称+"\n");
							fw.flush();
							key=true;
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if(key==true) {
						JOptionPane.showMessageDialog(null, "存盘成功！");
						key=false;
					}
					else {
						JOptionPane.showMessageDialog(null, "存盘失败！");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					if(fw!=null) {
						try {
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}}
				}
			
			
			//保存考试类型
				public static void setExamkinds() {
					File file=new File("tb_examkinds.txt");
					FileWriter fw=null;
					try {
						fw=new FileWriter(file);
						if(file.exists()) {
							fw.write(new String(""));
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					try {
						file.createNewFile();
						fw=new FileWriter(file,true);
						fw.write("科目\t\t考试类型\n");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					sql="select * from tb_examkinds";
					DBHelper.select(sql);
					try {
						while(DBHelper.rs.next()) {
							String 科目=DBHelper.rs.getString("exam");
							String 科目类型=DBHelper.rs.getString("checka");
							try {
								fw.write(科目+"\t\t"+科目类型+"\n");
								fw.flush();
								key=true;
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						if(key==true) {
							JOptionPane.showMessageDialog(null, "存盘成功！");
							key=false;
						}
						else {
							JOptionPane.showMessageDialog(null, "存盘失败！");
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					finally {
						if(fw!=null) {
							try {
								fw.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}}
					}
		//保存教师信息
					public static void setTeacher() {
						File file=new File("tb_teacher.txt");
						FileWriter fw=null;
						try {
							fw=new FileWriter(file);
							if(file.exists()) {
								fw.write(new String(""));
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							file.createNewFile();
							fw=new FileWriter(file,true);
							fw.write("教师编号\t\t所教年级\t\t所教班级\t\t教师姓名\t\t性别\t\t所教课程\t\t联系电话\n");
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						sql="select * from tb_teacher";
						DBHelper.select(sql);
						try {
							while(DBHelper.rs.next()) {
								String 教师编号=DBHelper.rs.getString("tid");
								String 所教年级=DBHelper.rs.getString("tgrade");
								String 所教班级=DBHelper.rs.getString("tclass");
								String 教师姓名=DBHelper.rs.getString("tname");
								String 性别=DBHelper.rs.getString("gender");
								String 所教课程=DBHelper.rs.getString("course");
								String 联系电话=DBHelper.rs.getString("phone");
								try {
									fw.write(教师编号+"\t\t"+所教年级+"\t\t"+所教班级+"\t\t"+教师姓名+"\t\t"+性别+"\t\t"+所教课程+"\t\t"+联系电话+"\n");
									fw.flush();
									key=true;
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							if(key==true) {
								JOptionPane.showMessageDialog(null, "存盘成功！");
								key=false;
							}
							else {
								JOptionPane.showMessageDialog(null, "存盘失败！");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						finally {
							if(fw!=null) {
								try {
									fw.close();
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}
					}
						
						//保存学生数据
						public static void setstudent() {
							File file=new File("tb_studentinfo.txt");
							FileWriter fw=null;
							try {
								fw=new FileWriter(file);
								if(file.exists()) {
									fw.write(new String(""));
								}
							} catch (IOException e) {
								e.printStackTrace();
							}
							try {
								file.createNewFile();
								fw=new FileWriter(file,true);
								fw.write("学生编号\t\t年级\t\t班级名称\t\t学生姓名\t\t性别\t\t年龄\t\t家庭地址\t\t联系电话\n");
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							sql="select * from tb_studentinfo";
							DBHelper.select(sql);
							try {
								while(DBHelper.rs.next()) {
									String 学生编号=DBHelper.rs.getString("sid");
									String 年级=DBHelper.rs.getString("grade");
									String 班级名称=DBHelper.rs.getString("sclass");
									String 学生姓名=DBHelper.rs.getString("sname");
									String 性别=DBHelper.rs.getString("gender");
									String 年龄=DBHelper.rs.getString("age");
									String 家庭地址=DBHelper.rs.getString("address");
									String 联系电话=DBHelper.rs.getString("phone");
									try {
										fw.write(学生编号+"\t\t"+年级+"\t\t"+班级名称+"\t\t"+学生姓名+"\t\t"+性别+"\t\t"+年龄+"\t\t"+家庭地址+"\t\t"+联系电话+"\n");
										fw.flush();
										key=true;
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								if(key==true) {
									JOptionPane.showMessageDialog(null, "存盘成功！");
									key=false;
								}
								else {
									JOptionPane.showMessageDialog(null, "存盘失败！");
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
							finally {
								if(fw!=null) {
									try {
										fw.close();
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
