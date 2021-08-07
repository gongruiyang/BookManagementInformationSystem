package libraryManagement;

import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

//UI既是JFrame容器，又是鼠标监听器
public class UI extends JFrame implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 294713345582086338L;

	public void initUI() {
		UI ui = new UI();//创建JFrame容器
		
		ui.setLayout(new GridLayout(3, 1));//设置三行一列的布局管理器
		ui.setTitle("图书管理系统");//设置左上角标题
		Font font = new Font("宋体",Font.PLAIN,35);//设置Button组件字体
			
		Button b1 = new Button("我是图书管理员");
		Button b2 = new Button("我是用户");
		Button b3 = new Button("退出系统");
		
		b1.addActionListener(new ActionListener() {//启动图书管理员登陆窗口
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				ui.dispose();
				new ManagerLoginUI().initManagerLoginUI();
			}
		});
		b2.addActionListener(new ActionListener() {//启动用户登录窗口
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				ui.dispose();
				new UserLoginUI().initUserLoginUI();
			}
		});
		b3.addActionListener(new ActionListener() {//退出系统
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		
		ui.add(b1);
		ui.add(b2);
		ui.add(b3);
		
		ui.setSize(500,500);
		ui.setLocationRelativeTo(null);
		ui.setVisible(true);
		
	}
	public static void main(String[] args) {
		new UI().initUI();
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
