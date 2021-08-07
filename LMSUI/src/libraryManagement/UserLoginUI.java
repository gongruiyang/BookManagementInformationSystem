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
	static JTextField userAccountTF = new JTextField();//���������˺ŵ��ı���
	static JTextField userPasswordTF = new JTextField();//��������������ı���
	
	public void initUserLoginUI(){
		UserLoginUI userLogin = new UserLoginUI();//����JFrame����
		userLogin.setLayout(new GridLayout(2, 1, 0, 0));
		Font font = new Font("����",Font.PLAIN,35);
		userLogin.setTitle("ͼ�����ϵͳ�û���½����");
		
		JPanel top = new JPanel();//�����ϰ벿�ַ��������˺�����
		top.setLayout(new GridLayout(2,1,0,0));
		
		JLabel UAccount = new JLabel("    �û��˺�:");
		UAccount.setFont(font);
		top.add(UAccount);
		userAccountTF.setSize(100,20);
		top.add(userAccountTF);
		
		JLabel UPassword = new JLabel("    �û�����:");
		UPassword.setFont(font);
		top.add(UPassword);
		userPasswordTF.setSize(100,20);
		top.add(userPasswordTF);
		
		JPanel buttom = new JPanel();//�����°벿�ַ����ύ��ť
		buttom.setLayout(new FlowLayout());
		JButton submit = new JButton("ȷ��");
		submit.setFont(font);
		submit.addMouseListener(userLogin);
		JButton reset = new JButton("����");
		reset.setFont(font);
		reset.addMouseListener(userLogin);
		buttom.add(submit);
		buttom.add(reset);
		
		submit.addActionListener(new ActionListener() {//���õ�¼����ȷ����ť�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String MA = userAccountTF.getText();
				String MP = userPasswordTF.getText();
				if(MA.equals("123") && MP.equals("123")) {
					userLogin.dispose();
					new UserMenu().initUserMenu();
				}else {
					JDialog jd = new JDialog();
					
					jd.setSize(400,100);
					jd.setLayout(new BorderLayout());
					JLabel wrongInf = new JLabel("�˺Ż��������!");
					wrongInf.setFont(font);
					jd.add( wrongInf,BorderLayout.CENTER );
					jd.setVisible(true);
                	jd.setLocationRelativeTo(null);
				}
			}
		});
		
		reset.addActionListener(new ActionListener() {//���õ�¼�������ð�ť�¼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		new UserLoginUI().initUserLoginUI();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO �Զ����ɵķ������
	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO �Զ����ɵķ������
		
	}

}
