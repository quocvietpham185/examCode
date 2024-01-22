package View;

import java.awt.EventQueue;
import java.sql.PreparedStatement;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JDBCUtil.DatabaseConnector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Color;
import View.Login;
public class Account extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JButton btnThem;
	private Connection conn;  // Thêm trường này

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    // Tạo đối tượng Account với đối số Connection
                    Connection conn = DatabaseConnector.getConnection();  // Lấy kết nối từ lớp DatabaseConnection
                    Account frame = new Account();
                    frame.setVisible(true);
                }  catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Account() {
		this.conn = conn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 436, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 73, 436, 129);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 10, 83, 25);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 60, 83, 39);
		panel_1.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(140, 12, 286, 25);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(140, 69, 286, 25);
		panel_1.add(password);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 200, 436, 53);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
	
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(162, 10, 139, 33);
		panel_2.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy thông tin từ các trường nhập liệu
                String newUsername = username.getText();
                String newPassword = new String(password.getPassword());

            
                // Tạo đối tượng UserAuthentication
                Login userAuth = new Login();

                // Kiểm tra xem tài khoản đã tồn tại hay chưa
                // Thêm tài khoản vào cơ sở dữ liệu
                try {
                    // Giả sử conn là đối tượng Connection đã được thiết lập
                	String sql = "INSERT INTO loginadmin (username, password, user_type) VALUES (?, ?, ?)";
                    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                        preparedStatement.setString(1, newUsername);
                        preparedStatement.setString(2, newPassword);
                        preparedStatement.setString(3, "EMPLOYEE");
                        preparedStatement.executeUpdate();
                    }

                    // Hiển thị thông báo thành công
                    JOptionPane.showMessageDialog(null, "Thêm tài khoản thành công");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Lỗi khi thêm tài khoản");
                }
                // Đóng cửa sổ Account sau khi thêm tài khoản
                dispose();
            }
        });

	}
}
