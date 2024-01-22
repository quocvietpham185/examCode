package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.FoodItemDAO;
import Model.Employee;
import Model.FoodItem;
import View.FoodItemView;

public class FoodItemController {
    private FoodItemView fooditemview;
    private FoodItemDAO fooditemDAO;

    public FoodItemController(FoodItemView fooditemview) {
        this.fooditemview = fooditemview;
        fooditemDAO = new FoodItemDAO();

        fooditemview.addAddMonAnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FoodItem mathang = fooditemview.getMatHangData(); // Sửa lỗi ở đây
                if (mathang != null) {
                    boolean success = fooditemDAO.insert(mathang);

                    if (success) {
                        ArrayList<FoodItem> mathangList = fooditemDAO.selectAll();
                        fooditemview.showListMonAn(mathangList);
                        fooditemview.showMessage("Thêm thành công");
                    } else {
                        fooditemview.showMessage("Thêm thất bại");
                    }
                }
            }
        });

		fooditemview.addTableSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				fooditemview.fillInputForm();
			}
		});	
		
		fooditemview.editAddMonAnListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FoodItem mathang = fooditemview.getMatHangData();
				if(mathang!=null)
				{
					boolean success = fooditemDAO.update(mathang);
					
					if(success)
					{
						fooditemview.showListMonAn(fooditemDAO.selectAll());
						fooditemview.showMessage("Sửa thành công");
					}
					else
					{
						fooditemview.showMessage("Sửa thất bại");
					}
				}
			}
		});
		fooditemview.deleteAddMonAnListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FoodItem mathang = fooditemview.getMatHangData();
				if(mathang!=null)
				{
					boolean success = fooditemDAO.delete(mathang);
					
					if(success)
					{
						fooditemview.showListMonAn(fooditemDAO.selectAll());
						fooditemview.showMessage("Xóa thành công");
					}
					else
					{
						fooditemview.showMessage("Xóa thất bại");
					}
				}
			}
		});
		
	}
	
	//Ta không hiển thị giao diện ở View mà ở controller, nên ta viết hàm này
	public void showFoodItemView() {
		
		//Trước khi hiển thị lên thì ta cần đọc cấy thông tin từ database để view vào cấy bảng
		ArrayList<FoodItem> Mathang = fooditemDAO.selectAll();
		
		//Cập nhật lại dữ liệu cho bảng bằng showListNhanVien ở bên ViewNhanVien
		fooditemview.showListMonAn(Mathang);
		
		//Hiển thị lên
		fooditemview.setVisible(true);
	}
	
	
}
