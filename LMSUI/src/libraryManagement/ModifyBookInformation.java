 package libraryManagement;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModifyBookInformation extends JFrame  {
	private static final long serialVersionUID = -198174477404666043L;
	private DefaultTableModel model = null;
	private JTable table = null;
	static final String driverName = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/dbbooksmanagement?useUnicode=true&characterEncoding=utf8";
	static final String user = "root";
	static final String password = "root";
	
	
	public ModifyBookInformation() throws ClassNotFoundException {
		super("ModifyBookInformation");
		this.setLayout(new BorderLayout());
		String[][] datas = {};
		String[] titles = {"����", "ISBN","����","ͼ��״̬" };
		model = new DefaultTableModel(datas, titles);
		table = new JTable(model);
		this.setTitle("�޸�ͼ����Ϣ");
		Font font = new Font("����",Font.PLAIN,35);
		
		//���ݿ�ȡ����
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url,user,password);
			stmt = conn.createStatement();
			String sql = "select * from tbbook";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				model.addRow(new Object[] 
						{ rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4)});
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt != null){
				try{
					stmt.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(conn != null){
				try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}	
		}
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		
		JButton modify = new JButton(" �޸� ");
		JButton back =   new JButton(" ���� ");
		modify.setFont(font);
		back.setFont(font);
		
		modify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				int selectRow = table.getSelectedRow();
				if(selectRow != -1) {
					String delISBN = (String) model.getValueAt(selectRow, 1);
					model.removeRow(selectRow);
					Connection conn = null;
					Statement stmt = null;
					try {
						Class.forName(driverName);
						conn = DriverManager.getConnection(url,user,password);
						stmt = conn.createStatement();
						String sql = "delete from tbbook where ISBN = '"+delISBN+"'";
						int count = stmt.executeUpdate(sql);
						if(count == 1) {
							new AddBookInformation().addBookInformation();
						}else {
							JDialog jd = new JDialog();
							jd.setSize(400,100);
							jd.setLayout(new BorderLayout());
							JLabel wrongInf = new JLabel("�޸�ʧ��!");
							wrongInf.setFont(font);
							jd.add( wrongInf,BorderLayout.CENTER );
							jd.setVisible(true);
		                	jd.setLocationRelativeTo(null);
						}
					}catch(SQLException | ClassNotFoundException e1){
						e1.printStackTrace();
					}finally{
						if(stmt != null){
							try{
								stmt.close();
							}catch(SQLException e1){
								e1.printStackTrace();
							}
						}
						if(conn != null){
							try{
								conn.close();
							}catch(SQLException e1){
								e1.printStackTrace();
							}
						}	
					}

				}else {
                	JDialog jd = new JDialog();
                	jd.setSize(100,60);
                	jd.setLayout(new BorderLayout());
                	jd.add( new JLabel("��ѡ��һ����¼"),BorderLayout.CENTER );
                	jd.setVisible(true);
                	jd.setLocationRelativeTo(null);
				}	
			}
		});
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				dispose();
			}
		});
		
		
		jp.add(modify);
		jp.add(back);
		this.add(jp,BorderLayout.SOUTH);
		this.add(new JScrollPane(table),BorderLayout.CENTER);
		this.setResizable(false);
		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		// TODO �Զ����ɵķ������
		new ModifyBookInformation();
	}

}
