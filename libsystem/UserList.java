package libsystem;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UserList {

	private static ArrayList<Customer> customerList;
	private static ArrayList<Admin> adminList;
	
	private static UserList instance = new UserList();	
	
	public static UserList getInstance() {return instance;}
	
	private UserList()
	{
		customerList = new ArrayList<Customer>();
		adminList = new ArrayList<Admin>();
	}
	
	public static ArrayList<Customer> getCustomerList(){
		return customerList;
	}

	public static ArrayList<Admin> getAdminList(){
		return adminList;
	}

	public static Customer searchCustomer(String Id) {
//		ArrayList<Customer> cList = UserList.getInstance().getCustomerList();
		for (Customer x: customerList){
			if(x.getId().equals(Id)){
				return x;
			}
		}
		return null;
	}
	
	public static Admin searchAdmin(String Id) {
		Admin result = null;
		for (Admin x: getInstance().getAdminList()){
			if(x.getId().equals(Id)){
				result = x;
			}
		}
		return result;
	}

	public void addCustomer(Customer customer) {
		customerList.add(customer);
		
	}
	
	public void addAdmin(Admin admin) {
		adminList.add(admin);
	}

	public void manageUser(String field, String info, String id) {
		Customer customer = UserList.searchCustomer(id);
		customer.Edit(field, info);
		System.out.printf("Change %s field of SID %s to \"%s\" Successfully\n",field,id,info);
	}
	
	public static String getMaxBorrowtime(String Id) {
		Customer customer = UserList.searchCustomer(Id);
		return customer.getMaxborrow();
	}
	
	public void setMaxborrowtime(String Id,String maxborrowtime) {
		Customer customer = UserList.searchCustomer(Id);
		customer.setMaxborrow(maxborrowtime);
	}

	public static int getTotalmember() {
		return customerList.size();
	}
	
	
public static void exportUserList() throws Exception {
		
		String sheetName = "userlist";
		String outputFile = "MemberList.xlsx";
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sh = workbook.createSheet(sheetName);
		
		int rownum = 0;
		for(Admin i : adminList) {
			Row row = sh.createRow(rownum++);
			row.createCell(0).setCellValue(i.getId());
			row.createCell(1).setCellValue(i.getName());
			row.createCell(2).setCellValue(i.getMajor());
			row.createCell(3).setCellValue(i.getRole());
			row.createCell(4).setCellValue(i.getPassword());
			row.createCell(5).setCellValue("0");
		}
		for(Customer c : customerList) {
			Row row = sh.createRow(rownum++);
			row.createCell(0).setCellValue(c.getId());
			row.createCell(1).setCellValue(c.getName());
			row.createCell(2).setCellValue(c.getMajor());
			row.createCell(3).setCellValue(c.getRole());
			row.createCell(4).setCellValue(c.getPassword());
			row.createCell(5).setCellValue(c.getMaxborrow());
		}
		FileOutputStream fileout =  new FileOutputStream(outputFile);
		workbook.write(fileout);
		fileout.close();
		workbook.close();

	}


}
	
