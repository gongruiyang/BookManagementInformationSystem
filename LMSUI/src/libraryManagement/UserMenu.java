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
		
		userMenu.setLayout(new GridLayout(4, 1));//��������һ�еĲ��ֹ�����
		userMenu.setTitle("ͼ���û����ܲ˵�");//�������ϽǱ���
		Font font = new Font("����",Font.PLAIN,35);//����Button�������
		
		Button b1 = new Button("��ʾͼ����Ϣ");
		Button b2 = new Button("����ͼ��");
		Button b3 = new Button("�黹ͼ��");
		Button b4 = new Button("�˳�ϵͳ");

		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				try {
					new ShowBookInformation();
				} catch (ClassNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				try {
					new BorrowBook();
				} catch (ClassNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				try {
					new ReturnBook();
				} catch (ClassNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		new UserMenu().initUserMenu();
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
