package View;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.EmployeeController;
import JDBCUtil.DatabaseConnector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Button;
import View.Account;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField textField;
	private JButton btnLogin;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.

	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 345);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(0, 0, 444, 85);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đăng Nhập");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(160, 82, 45));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(169, 24, 115, 36);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 84, 444, 177);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblUsername = new JLabel("UserName: ");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblUsername.setBounds(10, 30, 109, 35);
        panel_1.add(lblUsername);

        passwordField = new JPasswordField();
        passwordField.setBounds(129, 88, 305, 35);
        panel_1.add(passwordField);

        JLabel lblPassword = new JLabel("Password: ");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPassword.setBounds(10, 91, 109, 25);
        panel_1.add(lblPassword);

        textField = new JTextField();
        textField.setBounds(129, 32, 305, 35);
        panel_1.add(textField);
        textField.setColumns(10);
		
		JButton btnThemtaikhoan = new JButton("Thêm tài khoản");
		btnThemtaikhoan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThemtaikhoan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open the Account frame to add a new account
                Account accountFrame = new Account();
                accountFrame.setLocationRelativeTo(null);
                accountFrame.setVisible(true);
            }
        });

		btnThemtaikhoan.setBounds(149, 142, 131, 25);
		panel_1.add(btnThemtaikhoan);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DatabaseConnector  conn = new DatabaseConnector();
				Connection connection = null;
				try {
						connection = conn.getConnection();
						String sql = " SELECT * FROM loginadmin WHERE username=? and password=?";
						PreparedStatement prepareStatement = connection.prepareStatement(sql);
						prepareStatement.setString(1, textField.getText());
						prepareStatement.setString(2, passwordField.getText());
					
						ResultSet resultSet = prepareStatement.executeQuery();
						if(resultSet.next()) {
							JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
							dispose();
							EmployeeView nhavien = new EmployeeView();
							nhavien.setLocationRelativeTo(null);
							EmployeeController controller = new EmployeeController(nhavien);
							controller.showEmployeeView();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!");
						}
				} catch (SQLException e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(Login.this, e2.toString());
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(157, 271, 118, 27);
		getContentPane().add(btnLogin);
	}
	
	public boolean authenticate(String username, String password) {
        // Your authentication logic here
        return true; // Replace with actual authentication logic
    }

}
