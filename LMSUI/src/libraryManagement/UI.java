package libraryManagement;

import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

//UI����JFrame������������������
public class UI extends JFrame implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 294713345582086338L;

	public void initUI() {
		UI ui = new UI();//����JFrame����
		
		ui.setLayout(new GridLayout(3, 1));//��������һ�еĲ��ֹ�����
		ui.setTitle("ͼ�����ϵͳ");//�������ϽǱ���
		Font font = new Font("����",Font.PLAIN,35);//����Button�������
			
		Button b1 = new Button("����ͼ�����Ա");
		Button b2 = new Button("�����û�");
		Button b3 = new Button("�˳�ϵͳ");
		
		b1.addActionListener(new ActionListener() {//����ͼ�����Ա��½����
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				ui.dispose();
				new ManagerLoginUI().initManagerLoginUI();
			}
		});
		b2.addActionListener(new ActionListener() {//�����û���¼����
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				ui.dispose();
				new UserLoginUI().initUserLoginUI();
			}
		});
		b3.addActionListener(new ActionListener() {//�˳�ϵͳ
			
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
