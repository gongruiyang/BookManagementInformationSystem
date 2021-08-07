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
	static JTextField managerAccountTF = new JTextField();//���������˺ŵ��ı���
	static JTextField managerPasswordTF = new JTextField();//��������������ı���
	
	public void initManagerLoginUI(){
		ManagerLoginUI managerLogin = new ManagerLoginUI();//����JFrame����
		managerLogin.setLayout(new GridLayout(2, 1, 0, 0));
		Font font = new Font("����",Font.PLAIN,35);
		managerLogin.setTitle("ͼ�����ϵͳ����Ա��½����");
		
		JPanel top = new JPanel();//�����ϰ벿�ַ��������˺�����
		top.setLayout(new GridLayout(2,1,0,0));
		JLabel MAccount = new JLabel("    ����Ա�˺�:");
		MAccount.setFont(font);
		top.add(MAccount);
		managerAccountTF.setSize(100,20);
		top.add(managerAccountTF);
		JLabel MPassword = new JLabel("    ����Ա����:");
		MPassword.setFont(font);
		top.add(MPassword);
		managerPasswordTF.setSize(100,20);
		top.add(managerPasswordTF);
		
		JPanel buttom = new JPanel();//�����°벿�ַ����ύ��ť
		buttom.setLayout(new FlowLayout());
		JButton submit = new JButton("ȷ��");
		submit.setFont(font);
		submit.addMouseListener(managerLogin);
		JButton reset = new JButton("����");
		reset.setFont(font);
		reset.addMouseListener(managerLogin);
		buttom.add(submit);
		buttom.add(reset);
		
		submit.addActionListener(new ActionListener() {//���õ�¼����ȷ����ť�¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				String MA = managerAccountTF.getText();
				String MP = managerPasswordTF.getText();
				if(MA.equals("123") && MP.equals("123")) {
					managerLogin.dispose();
					new ManagerMenu().initManagerMenu();
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
		// TODO �Զ����ɵķ������
		new ManagerLoginUI().initManagerLoginUI();
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
