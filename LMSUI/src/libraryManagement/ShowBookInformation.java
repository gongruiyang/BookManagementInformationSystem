package libraryManagement;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowBookInformation extends JFrame {
	private static final long serialVersionUID = 695172171681627805L;
	private DefaultTableModel model = null;
	private JTable table = null;
	static final String driverName = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/dbbooksmanagement?useUnicode=true&characterEncoding=utf8";
	static final String user = "root";
	static final String password = "root";
	
	public ShowBookInformation() throws ClassNotFoundException {
		super("ShowBookInformation");
		this.setLayout(new BorderLayout());
		String[][] datas = {};
		String[] titles = {"书名", "ISBN","作者","图书状态" };
		model = new DefaultTableModel(datas, titles);
		table = new JTable(model);
		this.setTitle("图书信息");
		
		
		//数据库取数据
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
		this.add(new JScrollPane(table),BorderLayout.CENTER);
		this.setResizable(false);
		
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		JButton back = new JButton(" 返回 ");
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dispose();
			}
		});
		jp.add(back);
		this.add(jp,BorderLayout.SOUTH);
		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO 自动生成的方法存根
		new ShowBookInformation();
	}
}
