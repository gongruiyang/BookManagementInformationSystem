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

public class ManagerLoginUI extends JFrame implements MouseListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7795864145119290285L;
	static JTextField managerAccountTF = new JTextField();//设置输入账号的文本框
	static JTextField managerPasswordTF = new JTextField();//设置输入密码的文本框
	
	public void initManagerLoginUI(){
		ManagerLoginUI managerLogin = new ManagerLoginUI();//创建JFrame容器
		managerLogin.setLayout(new GridLayout(2, 1, 0, 0));
		Font font = new Font("宋体",Font.PLAIN,35);
		managerLogin.setTitle("图书管理系统管理员登陆界面");
		
		JPanel top = new JPanel();//容器上半部分放置输入账号密码
		top.setLayout(new GridLayout(2,1,0,0));
		JLabel MAccount = new JLabel("    管理员账号:");
		MAccount.setFont(font);
		top.add(MAccount);
		managerAccountTF.setSize(100,20);
		top.add(managerAccountTF);
		JLabel MPassword = new JLabel("    管理员密码:");
		MPassword.setFont(font);
		top.add(MPassword);
		managerPasswordTF.setSize(100,20);
		top.add(managerPasswordTF);
		
		JPanel buttom = new JPanel();//容器下半部分放置提交按钮
		buttom.setLayout(new FlowLayout());
		JButton submit = new JButton("确定");
		submit.setFont(font);
		submit.addMouseListener(managerLogin);
		JButton reset = new JButton("重置");
		reset.setFont(font);
		reset.addMouseListener(managerLogin);
		buttom.add(submit);
		buttom.add(reset);
		
		submit.addActionListener(new ActionListener() {//设置登录窗口确定按钮事件
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String MA = managerAccountTF.getText();
				String MP = managerPasswordTF.getText();
				if(MA.equals("123") && MP.equals("123")) {
					managerLogin.dispose();
					new ManagerMenu().initManagerMenu();
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
				managerAccountTF.setText("");
				managerPasswordTF.setText("");
			}
		});
		
		managerLogin.add(top);
		managerLogin.add(buttom);
		managerLogin.setSize(600,200);
		managerLogin.setLocationRelativeTo(null);
		managerLogin.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new ManagerLoginUI().initManagerLoginUI();
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
