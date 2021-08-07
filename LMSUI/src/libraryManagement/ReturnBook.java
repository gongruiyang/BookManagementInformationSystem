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

public class ReturnBook extends JFrame{
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model = null;
	private JTable table = null;
	static final String driverName = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/dbbooksmanagement?useUnicode=true&characterEncoding=utf8";
	static final String user = "root";
	static final String password = "root";
	public ReturnBook() throws ClassNotFoundException {
		super("ReturnBook");
		this.setLayout(new BorderLayout());
		String[][] datas = {};
		String[] titles = {"����", "ISBN","����"};
		model = new DefaultTableModel(datas, titles);
		table = new JTable(model);
		this.setTitle("�黹ͼ��");
		Font font = new Font("����",Font.PLAIN,35);
		
		//���ݿ�ȡ����
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url,user,password);
			stmt = conn.createStatement();
			String sql = "select * from tbborrow";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				model.addRow(new Object[] 
						{ rs.getString(1), rs.getString(2),rs.getString(3)});
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
		
		JButton returnBook = new JButton(" �黹 ");
		JButton back =   new JButton(" ���� ");
		
		returnBook.setFont(font);
		back.setFont(font);
		returnBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				int selectRow = table.getSelectedRow();
				
				if(selectRow != -1) {
					String returnName = (String) model.getValueAt(selectRow, 0);
					String returnISBN = (String) model.getValueAt(selectRow, 1);
					String returnAuthor = (String) model.getValueAt(selectRow, 2);
					String returnState = "���Խ���";
					model.removeRow(selectRow);
					
					Connection conn = null;
					Statement stmt = null;
					try {
						Class.forName(driverName);
						conn = DriverManager.getConnection(url,user,password);
						stmt = conn.createStatement();
						String sql1 = "delete from tbborrow where bookISBN = '"+returnISBN+"'";
						String sql2 = "insert into tbbook(bookName,ISBN,author,bookState) values('"+returnName+"','"+returnISBN+"','"+returnAuthor+"','"+returnState+"')";
						int count1 = stmt.executeUpdate(sql1);
						int count2 = stmt.executeUpdate(sql2);
						if(count1 == 1 && count2 == 1) {
							JDialog jd = new JDialog();
							jd.setSize(400,100);
							jd.setLayout(new BorderLayout());
							JLabel wrongInf = new JLabel("�黹�ɹ�!");
							wrongInf.setFont(font);
							jd.add( wrongInf,BorderLayout.CENTER );
							jd.setVisible(true);
		                	jd.setLocationRelativeTo(null);
						}else {
							JDialog jd = new JDialog();
							jd.setSize(400,100);
							jd.setLayout(new BorderLayout());
							JLabel wrongInf = new JLabel("�黹ʧ��!");
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
		
		
		jp.add(returnBook);
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
		new ReturnBook();
	}

}
