package View;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import Controllers.CustomerController;
import Controllers.EmployeeController;

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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import Model.Employee;
import Model.FoodItem;
import Table.TableEmployee;
import Table.TableFoodItem;

public class FoodItemView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtId;
	private JTextField txtTenmon;
	private JTextField txtGia;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JRadioButton rdoCaffe;
	private JRadioButton rdoGiaiKhat;
	private JRadioButton rdoPhaChe;
	private TableFoodItem tableModel;
	private JComboBox Loaimon1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodItemView frame = new FoodItemView();
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
	public FoodItemView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 696);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(188, 236, 241));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin\r\n");
		lblNewLabel.setBounds(10, 10, 150, 39);
		lblNewLabel.setBackground(new Color(176, 255, 176));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNewLabel);
		
		JButton btnThoat = new JButton("Thoát\r\n");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThoat.setBounds(59, 20, 85, 21);
		contentPane.add(btnThoat);
		
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
		btnNhVn.setBounds(0, 58, 171, 39);
		contentPane.add(btnNhVn);
		
		JButton btnMHg = new JButton("Quản lý mặt hàng");
		btnMHg.setBackground(new Color(192, 169, 190));
		btnMHg.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnMHg.setBounds(0, 93, 171, 39);
		contentPane.add(btnMHg);
		
		
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
		btnKHag.setBounds(0, 131, 171, 39);
		contentPane.add(btnKHag);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(216, 322, 810, 339);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		tableModel = new TableFoodItem();
		table.setModel(tableModel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(148, 198, 199));
		panel.setBounds(216, 9, 483, 285);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel jlabel1 = new JLabel("Mã món ăn:");
		jlabel1.setFont(new Font("Tahoma", Font.BOLD, 13));
		jlabel1.setBounds(10, 10, 90, 28);
		panel.add(jlabel1);
		
		JLabel jlabel2 = new JLabel("Tên món:");
		jlabel2.setFont(new Font("Tahoma", Font.BOLD, 13));
		jlabel2.setBounds(10, 48, 90, 28);
		panel.add(jlabel2);
		
		JLabel jlabel3 = new JLabel("Giá:");
		jlabel3.setFont(new Font("Tahoma", Font.BOLD, 13));
		jlabel3.setBounds(10, 94, 90, 28);
		panel.add(jlabel3);
		
		JLabel jlabel4 = new JLabel("Loại món:");
		jlabel4.setFont(new Font("Tahoma", Font.BOLD, 13));
		jlabel4.setBounds(10, 132, 90, 28);
		panel.add(jlabel4);
		rdoCaffe = new JRadioButton("Caffe");
		rdoCaffe.setBackground(new Color(119, 136, 153));
		rdoCaffe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoCaffe.setBounds(977, 180, 52, 21);
		panel.add(rdoCaffe);
		
		rdoGiaiKhat = new JRadioButton("Giải Khát");
		rdoGiaiKhat.setBackground(new Color(119, 136, 153));
		rdoGiaiKhat.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoGiaiKhat.setBounds(1098, 180, 52, 21);
		panel.add(rdoGiaiKhat);
		
		rdoPhaChe = new JRadioButton("Pha Chế");
		rdoPhaChe.setBackground(new Color(119, 136, 153));
		rdoPhaChe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		rdoPhaChe.setBounds(1219, 180, 52, 21);
		panel.add(rdoPhaChe);
		
		txtId = new JTextField();
		txtId.setBounds(136, 12, 253, 28);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtTenmon = new JTextField();
		txtTenmon.setColumns(10);
		txtTenmon.setBounds(136, 50, 253, 28);
		panel.add(txtTenmon);
		
		txtGia = new JTextField();
		txtGia.setColumns(10);
		txtGia.setBounds(136, 95, 253, 30);
		panel.add(txtGia);
		btnAdd = new JButton("Thêm");
		btnAdd.setBounds(83, 242, 81, 32);
		panel.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBackground(new Color(0, 255, 0));
		
		btnEdit = new JButton("Sửa");
		btnEdit.setBounds(217, 242, 81, 32);
		panel.add(btnEdit);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEdit.setBackground(new Color(255, 255, 51));
		
		btnDelete = new JButton("Xóa");
		btnDelete.setBounds(343, 242, 81, 32);
		panel.add(btnDelete);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBackground(new Color(255, 51, 51));
		
		Loaimon1 = new JComboBox();
		Loaimon1.setModel(new DefaultComboBoxModel<>(new String[] {"Caffe", "Giải Khát", "Pha Chế"}));
		Loaimon1.setFont(new Font("Tahoma", Font.BOLD, 10));
		Loaimon1.setBounds(136, 137, 126, 23);
		panel.add(Loaimon1);
	}
	public void showListMonAn(ArrayList<FoodItem> fooditem) {
		tableModel.setData(fooditem);
	}
	public void addTableSelectionListener(ListSelectionListener listener) {
		table.getSelectionModel().addListSelectionListener(listener);
	}
	public void fillInputForm() {
		int row = table.getSelectedRow();
		if(row >= 0)
		{
			txtId.setText(table.getValueAt(row, 0).toString());
			txtTenmon.setText(table.getValueAt(row, 1).toString());
			txtGia.setText(table.getValueAt(row, 2).toString());
			String Loaimon = table.getValueAt(row, 3).toString();
			if(Loaimon.equals("Caffe"))
			{
				rdoCaffe.setSelected(true);
			}
			else if(Loaimon.equals("Giải Khát"))
			{
				rdoGiaiKhat.setSelected(true);
			}
			else if(Loaimon.equals("Pha Chế")) {
				rdoPhaChe.setSelected(true);
			}
			
		}
		
	}
	public void editAddMonAnListener(ActionListener listener) {
		btnEdit.addActionListener(listener);
	}
	
	public void deleteAddMonAnListener(ActionListener listener) {
	    btnDelete.addActionListener(listener);
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void addAddMonAnListener(ActionListener actionListener) {
		btnAdd.addActionListener(actionListener);
		
	}
	public FoodItem getMatHangData() {
		try {
	        String maMonAnText = txtId.getText();
	        if (!maMonAnText.matches("\\d+")) {
	            showMessage("Mã món ăn phải là số nguyên!");
	            return null;
	        }
	        int maMonAn = Integer.parseInt(maMonAnText);

	        String tenMonAn = txtTenmon.getText();
	        
	        String giaText = txtGia.getText();
	        if (giaText.isEmpty()) {
	            // Xử lý khi chuỗi rỗng
	            showMessage("Giá không được để trống!");
	            return null;
	        }

	        float gia = Float.parseFloat(giaText);

	    
	        String loaimon = Loaimon1.getSelectedItem().toString();
	      

	        if (!validateMatHangData(maMonAn, tenMonAn, gia, loaimon)) {
	            showMessage("Thông tin không hợp lệ!");
	            return null;
	        }
	        FoodItem Mathang = new FoodItem(maMonAn, tenMonAn, gia, loaimon);
	        return Mathang;

	    } catch (IllegalArgumentException e) {
	        showMessage("Lỗi trả về: " + e.getMessage());
	        return null;
	    }
	
	}

	private boolean validateMatHangData(int maMonAn, String tenMonAn, float gia, String loaimon) {
		if(maMonAn==0 ||tenMonAn.length()==0 || gia ==0 || loaimon.length()==0 )
		{
			return false;
		}
		return true;
		
	}
	
}
