package libsystem;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.*;

public class test {

	public static void main(String agrs[]) throws IOException {
			
			FileInputStream input = new FileInputStream("Booklist.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			
			for (Row row : sheet) { // For each Row.

				
				Cell cell  = row.getCell(0); 
				DataFormatter df = new DataFormatter();
				String Title = df.formatCellValue(cell);
				
				if(cell == null || cell.getCellType() == CellType.BLANK) {
					break;
				}	
				
				cell  = row.getCell(1); 
				df = new DataFormatter();
				String Author = df.formatCellValue(cell);

				cell  = row.getCell(2); 	
				df = new DataFormatter();
				String BookID = df.formatCellValue(cell);
				
				cell  = row.getCell(3); 	
				df = new DataFormatter();
				String Category = df.formatCellValue(cell);
				
				cell  = row.getCell(4); 
				df = new DataFormatter();
				String Publisher = df.formatCellValue(cell);
				
				cell  = row.getCell(6); 
				String BorrowDate;
				if(cell.getCellType() != CellType.BLANK) {
					df = new DataFormatter();
					BorrowDate = df.formatCellValue(cell); 
				} else {
					BorrowDate = "N/A";
				} 
				
				cell  = row.getCell(7); 
				String ReturnDate;
				if(cell.getCellType() != CellType.BLANK) {
					df = new DataFormatter();
					ReturnDate = df.formatCellValue(cell); 
				} else {
					ReturnDate = "N/A";
				} 

				
				cell  = row.getCell(5); 
				df = new DataFormatter();
				String PubblishDate = df.formatCellValue(cell);
				
				
				cell  = row.getCell(8); 
				df = new DataFormatter();
				String BorrowTimes = df.formatCellValue(cell); 

				cell  = row.getCell(9); 
				String Borrower;
				if(cell.getCellType() != CellType.BLANK) {
					df = new DataFormatter();
					Borrower = df.formatCellValue(cell); 
				} else {
					Borrower = "N/A";
				} 
				
				
				System.out.printf("%-75s %-18s %s %s %s %s %s %s %s %s \n",Title,Author,BookID,Category,Publisher,BorrowDate,ReturnDate,PubblishDate,BorrowTimes,Borrower);
		}
			
	}
}
//
//	
//		
//		
//
//
//
////FileInputStream input = new FileInputStream("MemberList.xlsx");
////XSSFWorkbook workbook = new XSSFWorkbook(input);






