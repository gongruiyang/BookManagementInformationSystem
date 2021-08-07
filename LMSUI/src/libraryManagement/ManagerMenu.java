package libraryManagement;

import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class ManagerMenu extends JFrame implements MouseListener{
	private static final long serialVersionUID = -7436297573503032839L;

	public void initManagerMenu() {
		ManagerMenu managerMenu = new ManagerMenu();
		
		managerMenu.setLayout(new GridLayout(5, 1));//设置五行一列的布局管理器
		managerMenu.setTitle("图书管理员功能菜单");//设置左上角标题
		Font font = new Font("宋体",Font.PLAIN,35);//设置Button组件字体
		
		Button b1 = new Button("增加图书信息");
		Button b2 = new Button("删除图书信息");
		Button b3 = new Button("修改图书信息");
		Button b4 = new Button("显示图书信息");
		Button b5 = new Button("退出系统");

		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		b5.setFont(font);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new AddBookInformation().addBookInformation();
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					new DeleteBookInformation();
				} catch (ClassNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					new ModifyBookInformation();
				} catch (ClassNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					new ShowBookInformation();
				} catch (ClassNotFoundException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				System.exit(0);
			}
		});
		
		
		
		managerMenu.add(b1);
		managerMenu.add(b2);
		managerMenu.add(b3);
		managerMenu.add(b4);
		managerMenu.add(b5);
		
		managerMenu.setSize(500,500);
		managerMenu.setLocationRelativeTo(null);
		managerMenu.setVisible(true);

	}

	public static void main(String[] args) {
		new ManagerMenu().initManagerMenu();
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO 自动生成的方法存根
		
	}

}
