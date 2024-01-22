package View;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import Controllers.CustomerController;
import Model.Employee;
import Table.TableEmployee;
import Controllers.FoodItemController;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class EmployeeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
		private JTextField txtMaNV;
		private JTextField txtTenNV;
		private JTextField txtDienThoai;
		private JTextField txtNgaySinh;
		private JButton btnAdd;
		private JButton btnEdit;
		private JButton btnDelete;
		private JRadioButton rdoNam;
		private JRadioButton rdoNu;
		private JTextField txtStartDate;
		private JTable table;
		private JScrollPane scrollPane;
		private JTextField txtSalary;
		private TableEmployee tableModel;
		private JPanel panel_1;
		private JComboBox cbbGT;
		private JTextField txtSearchTen;
		private JButton btnSearch;
		private JLabel lblSearchTen;
		private JButton btnThoat;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeView frame = new EmployeeView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 696);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(188, 236, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Admin\r\n");
		lblNewLabel.setBounds(10, 12, 145, 35);
		lblNewLabel.setBackground(new Color(176, 255, 176));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		 
		JButton btnNhVn = new JButton("Quản lý nhân viên");
		btnNhVn.setBackground(new Color(192, 169, 190));
		btnNhVn.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNhVn.setBounds(10, 57, 173, 46);
		contentPane.add(btnNhVn);
		
		JButton btnNewButton_2 = new JButton("Quản lý mặt hàng");
		btnNewButton_2.setBackground(new Color(192, 169, 190));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FoodItemView mathang = new FoodItemView();
				mathang.setLocationRelativeTo(null);
				FoodItemController controller = new FoodItemController(mathang);
				controller.showFoodItemView();
			}
		});
		btnNewButton_2.setBounds(10, 144, 173, 46);
		contentPane.add(btnNewButton_2);
		
		JButton btnKHag = new JButton("Quản lý khách hàng");
		btnKHag.setBackground(new Color(192, 169, 190));
		btnKHag.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnKHag.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerView khachhang = new CustomerView();
				khachhang.setLocationRelativeTo(null);
				CustomerController controller = new CustomerController(khachhang);
				controller.showCustomerView();
			}
		});
		btnKHag.setBounds(10, 99, 173, 46);
		contentPane.add(btnKHag);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(148, 198, 199));
		panel_1.setBounds(193, 12, 353, 306);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
	

		JLabel lblNewLabel_3 = new JLabel("Mã NV:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(10, 10, 81, 25);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tên NV:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(10, 47, 81, 25);
		panel_1.add(lblNewLabel_3_1);
		
		
		JLabel lblNewLabel_3_3 = new JLabel("Số điện thoại:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(10, 82, 101, 25);
		panel_1.add(lblNewLabel_3_3);

		
		
        
        
        
		txtMaNV = new JTextField();
		txtMaNV.setBounds(121, 13, 169, 21);
		panel_1.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(121, 50, 169, 21);
		panel_1.add(txtTenNV);
	
		
		txtDienThoai = new JTextField();
		txtDienThoai.setColumns(10);
		txtDienThoai.setBounds(977, 74, 169, 21);
		panel_1.add(txtDienThoai);
		
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Giới tính:");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1_1.setBounds(891, 177, 81, 25);
		panel_1.add(lblNewLabel_3_1_1);
		
		rdoNam = new JRadioButton("Nam");
		rdoNam.setBackground(new Color(119, 136, 153));
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoNam.setBounds(977, 180, 52, 21);
		panel_1.add(rdoNam);
		
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBackground(new Color(119, 136, 153));
		rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoNu.setBounds(1098, 180, 52, 21);
		panel_1.add(rdoNu);
		
		
		btnAdd = new JButton("Thêm");
		btnAdd.setBounds(10, 242, 81, 32);
		panel_1.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBackground(new Color(0, 255, 0));
		
		btnEdit = new JButton("Sửa");
		btnEdit.setBounds(136, 242, 81, 32);
		panel_1.add(btnEdit);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEdit.setBackground(new Color(255, 255, 51));
		
		btnDelete = new JButton("Xóa");
		btnDelete.setBounds(264, 242, 81, 32);
		panel_1.add(btnDelete);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(new Color(255, 51, 51));
		
		JLabel lblNewLabel_7 = new JLabel("Ngày bắt đầu:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(10, 152, 101, 28);
		panel_1.add(lblNewLabel_7);
		
		txtStartDate = new JTextField();
		txtStartDate.setBounds(121, 158, 169, 19);
		panel_1.add(txtStartDate);
		txtStartDate.setColumns(10);
		
		txtDienThoai = new JTextField();
		txtDienThoai.setBounds(121, 88, 169, 19);
		panel_1.add(txtDienThoai);
		txtDienThoai.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Giới tính:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 117, 88, 25);
		panel_1.add(lblNewLabel_1);
		
		cbbGT = new JComboBox();
		cbbGT.setModel(new DefaultComboBoxModel<>(new String[]{"Nam", "Nữ"}));
		cbbGT.setBounds(121, 117, 73, 21);
		panel_1.add(cbbGT);
		
		JLabel lblNewLabel_2 = new JLabel("Lương: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(10, 190, 88, 32);
		panel_1.add(lblNewLabel_2);
		
		txtSalary = new JTextField();
		txtSalary.setBounds(121, 198, 169, 19);
		panel_1.add(txtSalary);
		txtSalary.setColumns(10);
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(193, 328, 823, 321);
		contentPane.add(scrollPane);
		
		table = new JTable();
		tableModel = new TableEmployee();
		table.setModel(tableModel);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(200, 145, 94));
		panel.setBounds(556, 12, 460, 123);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtSearchTen = new JTextField();
		txtSearchTen.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				fillInputForm();
			}
		});
		txtSearchTen.setBounds(142, 11, 308, 33);
		panel.add(txtSearchTen);
		txtSearchTen.setColumns(10);
		
		btnSearch = new JButton("Tìm kiếm\r\n");
		btnSearch.setBounds(172, 74, 117, 41);
		panel.add(btnSearch);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		lblSearchTen = new JLabel("Tên Nhân Viên:");
		lblSearchTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSearchTen.setBounds(10, 10, 112, 33);
		panel.add(lblSearchTen);
		
		btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThoat.setBounds(70, 21, 85, 21);
		contentPane.add(btnThoat);
		// Gắn tableModel cho table
		
		
	
	}
	public void showListNhanVien(List<Employee> employee) {
		tableModel.setData(employee);
   }
	public void addTableSelectionListener(ListSelectionListener listener) {
		table.getSelectionModel().addListSelectionListener(listener);
	}
	public void fillInputForm() {
		int row = table.getSelectedRow();
		if(row >= 0)
		{
			txtMaNV.setText(table.getValueAt(row, 0).toString());
			txtTenNV.setText(table.getValueAt(row, 1).toString());
			txtDienThoai.setText(table.getValueAt(row, 2).toString());
			txtStartDate.setText(table.getValueAt(row, 4).toString());
			txtSalary.setText(table.getValueAt(row, 5).toString());
 
			String gioiTinh = table.getValueAt(row, 3).toString();
			if(gioiTinh.equals("Nam"))
			{
				rdoNam.setSelected(true);
			}
			else if(gioiTinh.equals("Nữ"))
			{
				rdoNu.setSelected(true);
			}
			
		}
	}
	public void editAddNhanVienListener(ActionListener listener) {
		btnEdit.addActionListener(listener);
	}
	public void searchAddNhanVienListener(ActionListener listener) {
		btnSearch.addActionListener(listener);
	}
	
	public String findTimKiem() {
		String tenNV = txtSearchTen.getText();
		return tenNV;
	}
	
	
	public void deleteAddNhanVienListener(ActionListener listener) {
	    btnDelete.addActionListener(listener);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void addAddNhanVienListener(ActionListener actionListener) {
		btnAdd.addActionListener(actionListener);
		
	}

	public Employee getNhanVienData() {
	        
	        String maNV = txtMaNV.getText();

	        String tenNV = txtTenNV.getText();
	        String dienThoai = txtDienThoai.getText();

	        // Kiểm tra và chuyển đổi ngày bắt đầu
	        String startDate = txtStartDate.getText();

	        // Kiểm tra và chuyển đổi lương
	        double salary = 0;
	        try {
				 salary = Double.parseDouble(txtSalary.getText());
			} catch (Exception e) {
				// TODO: handle exception
			}
	         
	        String gioiTinh = cbbGT.getSelectedItem().toString();

	        if (validateEmployeeData(maNV, tenNV, dienThoai, gioiTinh, startDate, salary)==false) {
	            showMessage("Thông tin không hợp lệ!");
	            return null;
	        }

	        Employee nhanvien = new Employee(maNV, tenNV, dienThoai, gioiTinh, startDate, salary);
	        return nhanvien;
	   
	}

	private boolean validateEmployeeData(String maNV, String tenNV, String dienThoai, String gioiTinh, String startDate,double salary) {
		if(maNV.length()==0 ||dienThoai.length()==0 || gioiTinh.length() ==0 || tenNV.length()==0 || startDate.length() == 0 || salary == 0 )
		{
			return false;
		}
		return true;
	}
}
