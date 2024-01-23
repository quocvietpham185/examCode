Phần đăng nhập: 
	- Gồm 2 chức năng chính: Đăng nhập và Thêm tài khoản
		+Login ở Model: để cài đặt những thuộc tính gồm 3 thuộc tính là Username, password và userType (usertype có tác dụng để phân biệt nhân viên và Admin)
		+Login ở View: là nơi thiết kế giao diện phần đăng nhập và kết nối tới Database 
			. Trong phần Login có cài đặt thêm 1 nút nhấn để chuyển qua class Account có tác dụng để đăng ký thêm tài khoản. Class Account cũng là nơi thiết kế giao diện cho người dùng và kết nối Database để đăng ký thêm tài khoản.

Customer: 
	- Gồm 4 chức năng chính: Thêm, sửa, xóa và tìm kiếm thông tin khách hàng.
		+ Customer ở Model: Để cài đặt thuộc tính gồm 5 thuộc tính: Mã KH, Tên KH, ĐT, Giới Tính, Ngày Sinh.
		+ CustomerView: Là nơi thiết kế giao diện và những thao tác liên quan đến hiển thị. 
			.FillInputForm: Phương thức này dùng để điền dữ liệu từ hàng được chọn trong bảng lên các trường nhập liệu. Nếu có hàng được được chọn thì phương thức sẽ lấy dữ liệu.
			.ShowListKhachHang: Phương thức này dùng để hiển thị thông tin lên bảng. Nhận danh sách khách hàng và cập nhật dữ liệu thông qua tableModel.setData
			.FindTimKiem: phương thức này trả về giá trị lúc nhập, phương thức này dùng để tìm kiếm khách hàng.
			.addTableSelectionListener: Phương thức lắng nghe sự kiện cho việc chọn hàng trong bảng
			.Edit, Delete, Add, Search: Phương thức này lắng nghe người dùng khi nhấn vào những nút trên. 
			.ShowMessage: Phương thức này hiển thị hộp thoại thông báo với nội dung được truyền vào
			.GetKhachHangData: Phương thức này trả về đối tượng Customer được tạo từ dữ liệu nhập liệu trên giao diện.
		+CustomerDAO: dùng để kết nối với Database và dùng câu lệnh để thực hiện.
			.CustomerDAO(): phương thức dùng để kết nối với Database 
			.public boolean insert, update, delete: sử dụng câu lệnh SQL để có thể thêm, cập nhật và xóa. Chuẩn bị đối tượng PreparedStatement để thực thi câu lệnh SQL.set đúng kiểu và thứ tự trong mySQL để định vị đúng vị trí trong mySQL. Đóng đối tượng và xử lý ngoại lệ nếu có. Trả về true nếu cập nhật thành công và false nếu không làm được. 
			.Phương thức selectById: dùng để lấy thông tin khách hàng dựa trên mã khách hàngg. Nó thực hiện câu lệnh SQL Select để truy vấn dữ liệu từ bảng customer dựa trên mã khách hàng. Kết quả trả về đối tượng.  
			.Phương thức selectByCondition: phương thức được sử dụng để lấy danh sách khách hàng dựa. 
			.Phương thức selectByTenKH: phương thức này dùng để lấy danh sách khách hàng dựa trên tên khách hàng. Kết quả truy vấn để trả về khách hàng.
		+TableCustomer: dùng để cung cấp dữ liệu cho một bảng trong giao diện người dùng. 
			.Phương thức setData: sử dụng để cập nhật dữ liệu khách hàng trong customer. Mỗi khi dữ liệu của tableModel được cập nhật qua setData thì tableModel sẽ thông báo cho table trong View để cập nhật
			.Getrowcount và getColumnCount trả về số lượng dòng và cột. getColumnName trả về tên của cột tại vị trí column. GetValueAt trả về giá trị tại vị trí trong bảng.
		+CustomerController: dùng để quản lý các sự kiện và tương tác với giao diện người dùng.
			.Trong hàm khởi tạo, ta khởi tạo CustomerDAO để tương tác với cở sở dữ liệu. Đăng kí các ActionListener để khi các nút được nháy, nó sẽ lấy dữ lieeuk khách hàng từ giao diện, thực hiện cập nhật vào cơ sở dữ liệu thông qua.
			.Phương thức showCustomerView được sử dụng để hiển thị giao diện người dùng. Trước khi hiển thị, nó đọc dữ liệu khách hàng từ csdl thông qua customerDAO.selectAll, sau đó cập nhật danh sách khách hàng và hiển thị giao diện.
