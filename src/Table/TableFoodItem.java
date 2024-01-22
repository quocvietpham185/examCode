package Table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Employee;
import Model.FoodItem;

public class TableFoodItem extends AbstractTableModel {
	private String[] columnNames = {"Mã món ăn", "Tên món ăn", "Giá", "Loại món"};
	private List<FoodItem> fooditem;
	
	public TableFoodItem() {
		fooditem = new ArrayList<FoodItem>();
	}
	
	public void setData(List<FoodItem> fooditem) {
		this.fooditem = fooditem;
		//Mõi khi dữ liệu của tableModel đc cập nhật qua setData thì tableModel sẽ thông báo cho table trong View cập nhật lại
		fireTableDataChanged();
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(this.fooditem != null) {
			return this.fooditem.size();
		} else {
		return 0;
			}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
				FoodItem mathang = fooditem.get(rowIndex);
				//Lấy cấy dối tượng tại vị trí rowIndex
				//Sau đó dùng switch để xác định columnIndex cần lấy
				switch(columnIndex)
				{
				case 0:
					return mathang.getMamonan();
				case 1:
					return mathang.getTenmon();
				case 2:
					return mathang.getGia();
				case 3:
					return mathang.getLoaimon();
				}
		return null;
	}
	
}
