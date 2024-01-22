package Main;



import java.util.ArrayList;

import Controllers.CustomerController;

import Controllers.EmployeeController;
import Controllers.FoodItemController;
import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import Model.Customer;
import Model.Employee;
import View.CustomerView;
import View.EmployeeView;
import View.FoodItemView;
import View.Login;


public class Run {

   public static void main(String[] args) {
//	
	   
//	  EmployeeView  a = new EmployeeView();
//	  EmployeeController c = new EmployeeController(a);
//	  c.showEmployeeView();
	   
	   /*
	   ArrayList<Employee> s = EmployeeDAO.getInstance().selectByTenNV("Thông");
	   System.out.println(s);*/
//	  	  
//	  CustomerView b = new CustomerView();
//	  CustomerController d = new CustomerController(b);
//	  d.showCustomerView();
//	   FoodItemView a = new FoodItemView();
//	   FoodItemController c = new FoodItemController(a);
//	   c.showFoodItemView(); 
	   
	   Login a = new Login();
	   a.setLocationRelativeTo(null);
	   a.setVisible(true);
//	  
	   /*
	   CustomerView b = new CustomerView();
	  CustomerController d = new CustomerController(b);
		  d.showCustomerView();
	   */


}
}