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
		
		managerMenu.setLayout(new GridLayout(5, 1));//��������һ�еĲ��ֹ�����
		managerMenu.setTitle("ͼ�����Ա���ܲ˵�");//�������ϽǱ���
		Font font = new Font("����",Font.PLAIN,35);//����Button�������
		
		Button b1 = new Button("����ͼ����Ϣ");
		Button b2 = new Button("ɾ��ͼ����Ϣ");
		Button b3 = new Button("�޸�ͼ����Ϣ");
		Button b4 = new Button("��ʾͼ����Ϣ");
		Button b5 = new Button("�˳�ϵͳ");

		b1.setFont(font);
		b2.setFont(font);
		b3.setFont(font);
		b4.setFont(font);
		b5.setFont(font);
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				new AddBookInformation().addBookInformation();
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				try {
					new DeleteBookInformation();
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
					new ModifyBookInformation();
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
				try {
					new ShowBookInformation();
				} catch (ClassNotFoundException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				}
			}
		});
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}

}
