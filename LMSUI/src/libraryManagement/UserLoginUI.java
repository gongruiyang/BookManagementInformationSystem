package libraryManagement;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserLoginUI extends JFrame implements MouseListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9034907244642631742L;
	static JTextField userAccountTF = new JTextField();//设置输入账号的文本框
	static JTextField userPasswordTF = new JTextField();//设置输入密码的文本框
	
	public void initUserLoginUI(){
		UserLoginUI userLogin = new UserLoginUI();//创建JFrame容器
		userLogin.setLayout(new GridLayout(2, 1, 0, 0));
		Font font = new Font("宋体",Font.PLAIN,35);
		userLogin.setTitle("图书管理系统用户登陆界面");
		
		JPanel top = new JPanel();//容器上半部分放置输入账号密码
		top.setLayout(new GridLayout(2,1,0,0));
		
		JLabel UAccount = new JLabel("    用户账号:");
		UAccount.setFont(font);
		top.add(UAccount);
		userAccountTF.setSize(100,20);
		top.add(userAccountTF);
		
		JLabel UPassword = new JLabel("    用户密码:");
		UPassword.setFont(font);
		top.add(UPassword);
		userPasswordTF.setSize(100,20);
		top.add(userPasswordTF);
		
		JPanel buttom = new JPanel();//容器下半部分放置提交按钮
		buttom.setLayout(new FlowLayout());
		JButton submit = new JButton("确定");
		submit.setFont(font);
		submit.addMouseListener(userLogin);
		JButton reset = new JButton("重置");
		reset.setFont(font);
		reset.addMouseListener(userLogin);
		buttom.add(submit);
		buttom.add(reset);
		
		submit.addActionListener(new ActionListener() {//设置登录窗口确定按钮事件
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String MA = userAccountTF.getText();
				String MP = userPasswordTF.getText();
				if(MA.equals("123") && MP.equals("123")) {
					userLogin.dispose();
					new UserMenu().initUserMenu();
				}else {
					JDialog jd = new JDialog();
					
					jd.setSize(400,100);
					jd.setLayout(new BorderLayout());
					JLabel wrongInf = new JLabel("账号或密码错误!");
					wrongInf.setFont(font);
					jd.add( wrongInf,BorderLayout.CENTER );
					jd.setVisible(true);
                	jd.setLocationRelativeTo(null);
				}
			}
		});
		
		reset.addActionListener(new ActionListener() {//设置登录窗口重置按钮事件
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				userAccountTF.setText("");
				userPasswordTF.setText("");
			}
		});
		
		userLogin.add(top);
		userLogin.add(buttom);
		userLogin.setSize(600,200);
		userLogin.setLocationRelativeTo(null);
		userLogin.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new UserLoginUI().initUserLoginUI();
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
