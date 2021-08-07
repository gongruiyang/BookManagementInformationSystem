package libraryManagement;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddBookInformation extends JFrame implements MouseListener {
	private static final long serialVersionUID = 9002844771308662797L;
	static JTextField newBookNameTF = new JTextField();
	static JTextField newBookISBNTF = new JTextField();
	static JTextField newBookAuthorTF = new JTextField();
	static JTextField newBookStateTF = new JTextField();
	static final String driverName = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/dbbooksmanagement?useUnicode=true&characterEncoding=utf8";
	static final String user = "root";
	static final String password = "root";
	
	public void addBookInformation() {
		// TODO 自动生成的方法存根
		AddBookInformation frm = new AddBookInformation();
		frm.setLayout(new GridLayout(4, 1, 0, 0));
		Font font = new Font("宋体",Font.PLAIN,35);
		frm.setTitle("图书变动界面");
		
		JPanel top = new JPanel();//容器上半部分放置输入图书信息
		top.setLayout(new GridLayout(4,1,0,0));
		
		JLabel bName = new JLabel("    书名:");
		bName.setFont(font);
		top.add(bName);
		newBookISBNTF.setSize(100,20);
		top.add(newBookISBNTF);
		
		JLabel bISBN = new JLabel("    ISBN:");
		bISBN.setFont(font);
		top.add(bISBN);
		newBookNameTF.setSize(100,20);
		top.add(newBookNameTF);
		
		JLabel bAuthor = new JLabel("    作者:");
		bAuthor.setFont(font);
		top.add(bAuthor);
		newBookAuthorTF.setSize(100,20);
		top.add(newBookAuthorTF);
		
		JLabel bState = new JLabel("    图书状态:");
		bState.setFont(font);
		top.add(bState);
		newBookStateTF.setSize(100,20);
		top.add(newBookStateTF);
		
		
		JPanel buttom = new JPanel();//容器下半部分放置提交按钮
		buttom.setLayout(new FlowLayout());
		JButton submit = new JButton("确定");
		submit.setFont(font);
		submit.addMouseListener(frm);
		
		JButton reset = new JButton("重置");
		reset.setFont(font);
		reset.addMouseListener(frm);
		buttom.add(submit);
		buttom.add(reset);
		
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				String bookName = newBookNameTF.getText();
				String bookISBN = newBookISBNTF.getText();
				String bookAuthor = newBookAuthorTF.getText();
				String bookState = newBookStateTF.getText();
				Connection conn = null;
				Statement stmt = null;
				try {
					Class.forName(driverName);
					conn = DriverManager.getConnection(url,user,password);
					stmt = conn.createStatement();
					String sql = "insert into tbbook(ISBN,bookName,author,bookState) values('"+bookName+"','"+bookISBN+"','"+bookAuthor+"','"+bookState+"')";
					int count = stmt.executeUpdate(sql);
					if(count == 1) {
						JDialog jd = new JDialog();
						jd.setSize(400,100);
						jd.setLayout(new BorderLayout());
						JLabel wrongInf = new JLabel("插入成功!");
						wrongInf.setFont(font);
						jd.add( wrongInf,BorderLayout.CENTER );
						jd.setVisible(true);
	                	jd.setLocationRelativeTo(null);
					}else {
						JDialog jd = new JDialog();
						jd.setSize(400,100);
						jd.setLayout(new BorderLayout());
						JLabel wrongInf = new JLabel("插入失败!");
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
				newBookAuthorTF.setText("");
				newBookISBNTF.setText("");
				newBookNameTF.setText("");
				newBookStateTF.setText("");
			}
			
		});
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				newBookAuthorTF.setText("");
				newBookISBNTF.setText("");
				newBookNameTF.setText("");
				newBookStateTF.setText("");
			}
		});
	
		frm.add(top);
		frm.add(buttom);
		frm.setSize(1000,1000);
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new AddBookInformation().addBookInformation();
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
