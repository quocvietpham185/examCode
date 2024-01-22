package View;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import Controllers.CustomerController;
import Controllers.EmployeeController;
import Controllers.FoodItemController;
import Model.Customer;
import Model.Employee;
import Table.TableCustomer;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class CustomerView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table1;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnEdit;
	JScrollPane scrollPane = new JScrollPane();
	private TableCustomer tableModel;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtDienThoai;
	private JTextField txtNgaySinh;
	private JTable table;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JComboBox cbbGT;
	private JTextField txtSearch;
	private JButton btnSearch;
	private JLabel lblSearchten;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerView frame = new CustomerView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 696);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(188, 236, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin\r\n");
		lblNewLabel.setBounds(10, 9, 144, 39);
		lblNewLabel.setBackground(new Color(176, 255, 176));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JButton bthThoat = new JButton("Thoát\r\n");
		bthThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		bthThoat.setFont(new Font("Tahoma", Font.BOLD, 12));
		bthThoat.setBounds(59, 20, 85, 21);
		contentPane.add(bthThoat);
		
		JButton btnNhVn = new JButton("Quản lý nhân viên");
		btnNhVn.setBackground(new Color(192, 169, 190));
		btnNhVn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNhVn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeView nhanvien = new EmployeeView();
				nhanvien.setLocationRelativeTo(null);
				EmployeeController controller = new EmployeeController(nhanvien);
				controller.showEmployeeView();
			}
		});
		btnNhVn.setBounds(0, 58, 166, 51);
		contentPane.add(btnNhVn);
		
		JButton btnMHg = new JButton("Quản lý mặt hàng");
		btnMHg.setBackground(new Color(192, 169, 190));
		btnMHg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMHg.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMHg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FoodItemView mathang = new FoodItemView();
				mathang.setLocationRelativeTo(null);
				FoodItemController controller = new FoodItemController(mathang);
				controller.showFoodItemView();
			}
		});
		btnMHg.setBounds(0, 106, 166, 52);
		contentPane.add(btnMHg);
		
		JButton btnKHag = new JButton("Quản lý khách hàng");
		btnKHag.setBackground(new Color(192, 169, 190));
		btnKHag.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnKHag.setBounds(0, 156, 166, 51);
		contentPane.add(btnKHag);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(148, 198, 199));
		panel2.setBounds(176, 9, 372, 302);
		contentPane.add(panel2);
		panel2.setLayout(null);
		

		btnAdd = new JButton("Thêm");
		btnAdd.setBounds(10, 242, 81, 32);
		panel2.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBackground(new Color(0, 255, 0));
		
		btnEdit = new JButton("Sửa");
		btnEdit.setBounds(136, 242, 81, 32);
		panel2.add(btnEdit);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEdit.setBackground(new Color(255, 255, 51));
		
		btnDelete = new JButton("Xóa");
		btnDelete.setBounds(272, 242, 81, 32);
		panel2.add(btnDelete);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(new Color(255, 51, 51));
	
		JLabel lblNewLabel_1_1 = new JLabel("Mã Khách Hàng:\r\n");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(0, 0, 107, 27);
		panel2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên Khách Hàng:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(0, 37, 126, 27);
		panel2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Số Điện Thoại:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(0, 74, 107, 27);
		panel2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Ngày Sinh:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(0, 153, 107, 27);
		panel2.add(lblNewLabel_4_1);
		
		txtMaKH = new JTextField();
		txtMaKH.setColumns(10);
		txtMaKH.setBounds(136, 10, 166, 19);
		panel2.add(txtMaKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(136, 42, 166, 19);
		panel2.add(txtTenKH);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(136, 79, 166, 19);
		panel2.add(txtDienThoai);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(136, 158, 166, 19);
		panel2.add(txtNgaySinh);
		
		cbbGT = new JComboBox();
		cbbGT.setModel(new DefaultComboBoxModel<>(new String[]{"Nam", "Nữ"}));
		cbbGT.setBounds(136, 118, 65, 21);
		panel2.add(cbbGT);
		
		JLabel lblNewLabel_1 = new JLabel("Giới Tính:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(0, 111, 75, 32);
		panel2.add(lblNewLabel_1);
		
		rdoNam = new JRadioButton("Nam");
		rdoNam.setBackground(new Color(119, 136, 153));
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoNam.setBounds(977, 180, 52, 21);
		panel2.add(rdoNam);
		
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBackground(new Color(119, 136, 153));
		rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoNu.setBounds(1098, 180, 52, 21);
		panel2.add(rdoNu);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(176, 337, 629, 312);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		tableModel = new TableCustomer();
		table.setModel(tableModel);
		scrollPane_1.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(575, 10, 441, 138);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblSearchten = new JLabel("Tên Khách Hàng");
		lblSearchten.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSearchten.setBounds(10, 9, 114, 31);
		panel.add(lblSearchten);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(134, 10, 297, 31);
		panel.add(txtSearch);
		txtSearch.setColumns(10);
		
		btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(171, 97, 98, 31);
		panel.add(btnSearch);
	}
	public void fillInputForm() {
		int row = table.getSelectedRow();
		if(row > 0) {
			txtMaKH.setText(table.getValueAt(row, 0).toString());
			txtTenKH.setText(table.getValueAt(row, 1).toString());
			txtDienThoai.setText(table.getValueAt(row, 2).toString());
			txtNgaySinh.setText(table.getValueAt(row, 4).toString());
			String gioitinh = table.getValueAt(row, 3).toString();
			if(gioitinh.equals("Nam"))
			{
				rdoNam.setSelected(true);
			}
			else if(gioitinh.equals("Nữ"))
			{
				rdoNu.setSelected(true);
			}
		}
		
	
	}
	

	public void showListKhachHang(List<Customer> customer) {
		// TODO Auto-generated method stub
		tableModel.setData(customer);
	}
	public String findTimKiem() {
		String tenKH = txtSearch.getText();
		return tenKH;
	}
	
	public void addTableSelectionListener(ListSelectionListener listener) {
		table.getSelectionModel().addListSelectionListener(listener);
	}
	public void editAddKhachHangListener(ActionListener listener) {
		btnEdit.addActionListener(listener);
	}
	
	public void deleteAddKhachHangListener(ActionListener listener) {
	    btnDelete.addActionListener(listener);
	}
	public void searchAddKhachHangListener(ActionListener listener) {
	    btnSearch.addActionListener(listener);
	}

	public void addAddKhachHangListener(ActionListener actionListener) {
		btnAdd.addActionListener(actionListener);
		
	}
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public Customer getKhachHangData() {
		        int maKHText = 0;
		        try {
					maKHText = Integer.parseInt(txtMaKH.getText());
				} catch (NumberFormatException e) {
					// TODO: handle exception
				}
		        

		        String tenKH = txtTenKH.getText();
		        String dienThoai = txtDienThoai.getText();

		        // Kiểm tra và chuyển đổi ngày bắt đầu
		        String ngaysinh = txtNgaySinh.getText();
		        String gioiTinh = cbbGT.getSelectedItem().toString();
		        
		        
		        if (validateKhachHangData(maKHText, tenKH, dienThoai, gioiTinh,ngaysinh )==false) {
		            showMessage("Thông tin không hợp lệ!");
		            return null;
		        }
		        
		        Customer khachhang = new Customer(maKHText,  tenKH, dienThoai, gioiTinh, ngaysinh);
		        return khachhang;
		    
		}

	public boolean validateKhachHangData(int maKH, String tenKH, String dienThoai, String gioiTinh, String ngaysinh) {
		if(maKH==0 ||dienThoai.length()==0 || gioiTinh.length() ==0 || ngaysinh.length()==0 || tenKH.length() == 0 )
		{
			return false;
		}
		return true;
	
	}
}