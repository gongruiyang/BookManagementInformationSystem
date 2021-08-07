package libraryManagement;

import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class UserMenu extends JFrame implements MouseListener{
	private static final long serialVersionUID = -2631068172820963868L;

	public void initUserMenu() {
		UserMenu userMenu = new UserMenu();
		
		userMenu.setLayout(new GridLayout(4, 1));//设置四行一列的布局管理器
		userMenu.setTitle("图书用户功能菜单");//设置左上角标题
		Font font = new Font("宋体",Font.PLAIN,35);//设置Button组件字体
		
		Button b1 = new Button("显示图书信息");
		Button b2 = new Button("借阅图书");
		Button b3 = new Button("归还图书");
		Button b4 = new Button("退出系统");

		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);

		b1.addActionListener(new ActionListener() {
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
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				try {
					new BorrowBook();
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
					new ReturnBook();
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
				System.exit(0);
			}
		});
		
		userMenu.add(b1);
		userMenu.add(b2);
		userMenu.add(b3);
		userMenu.add(b4);

		userMenu.setSize(500,500);
		userMenu.setLocationRelativeTo(null);
		userMenu.setVisible(true);
			
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new UserMenu().initUserMenu();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

}
