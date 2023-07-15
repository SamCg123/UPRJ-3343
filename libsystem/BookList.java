package libsystem;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BookList {

	
	private static ArrayList<Book> booklist;

	private static BookList instance = new BookList();

	public static BookList getInstance() {
		return instance;
	}
	
	
	private BookList()
	{
		booklist = new ArrayList<Book>();
	}

	UserList userlist = UserList.getInstance();

	
	public Book Get_book(String id) {
		
		for (Book x : booklist) {
			if (x.getBookID().equals(id)) {
				return x;
			}
		}
		return null;
	}

	public void Search_book(String[] cmdParts) throws ParseException {
		for (Book B : booklist) {
			boolean result = false;
			String[] titleName = B.getTitle().split(" ");
			String[] searchSimilar = cmdParts[1].split(" ");
			for (int i = 0; i < titleName.length; i++) {
				for (int j = 0; j < searchSimilar.length; j++) {
					if (titleName[i].equals(searchSimilar[j])) {
						result = true;
					}
					if (result) {
						System.out.printf("%s %-75s %-20s %-10s\n", B.getBookID(), B.getTitle(), B.getBorrowDate(),B.getBorrower());
						result = false;
						break;
					}
					
				}
			}
		}
	}

	
	public void Search_bookByID(String[] cmdParts) throws ParseException {
		for (Book B : booklist) {
//			boolean result = false;
			String bookid = B.getBookID();
			if(bookid.equals(cmdParts[1])) {
//				System.out.println(B.getBorrower());
//				System.out.println(bookid);
//				System.out.println(B.getTitle());
				System.out.printf("%s %-75s %-20s %-10s\n", "Book ID", "Book Name", "Boroow Date", "Borrower");
				System.out.printf("%s %-75s %-20s %-10s\n", B.getBookID(), B.getTitle(), B.getBorrowDate(),B.getBorrower());
				break;
			}
			 
		}
	}
	

	public void Renew_book(String bookid) throws Exception {
		Book book = Get_book(bookid);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
		String borrowDate = book.getBorrowDate();
		
		Date date = formatter.parse(borrowDate);  
//		book.setBorrowDate(date.toString());

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 21); 
        
        book.setReturnDate((formatter.format(cal.getTime())).toString());
		
        
		System.out.printf("The new return date of your book is %s\n",book.getReturnDate());

	}



//	class BookSort implements Comparator<Book> 
//	{ 
//    	public int compare(Book a, Book b) 
//    	{ 
//        	return a.getBorrowTimes().compareTo(b.getBorrowTimes()); 
//    	} 
//	} 
	public void View_bookRanking() {
//		ArrayList<Book> store = new ArrayList<>();
//		store = booklist;
//		for(Book b : store) {
//			store.setInteger.parseInt(b.getBorrowTimes());
//		}
//		
		//Collections.sort(store, new BookSort().reverseOrder()); 
		
//		Collections.sort(store, Collections.reverseOrder());
		
		List<Book> store = new ArrayList<>();
		store = booklist;
		Collections.sort(store, new Comparator<Book>(){
		  public int compare(Book o1, Book o2)
		  {
			 
		     return o2.getBorrowTimes().compareTo(o1.getBorrowTimes());
		  }
		});
		
		
		System.out.printf("%-2s. %-80s %s \n"," ","Book Name","Borrow Times");
		for (int i=0; i< 10; i++)
		{
			System.out.printf("%-2d. %-80s %s \n",i+1,store.get(i).getTitle(),store.get(i).getBorrowTimes());
		}
	}


	public void Return_book(String bookid, String sid) {
		for(Book x: booklist){
			String tem = x.getBorrower();
			if(tem == null) {
				tem = "N/A";
			}
			if(x.getBookID().equals(bookid)){
				if(tem.equals(sid)){
					x.setBorrowDate(null);
					x.setReturnDate(null);
					x.setBorrower(null);
					System.out.printf("%s BookID:%s BookName:%-75s \n", "the book is returned.", x.getBookID(), x.getTitle());
					
					int maxborrowtime = Integer.parseInt(userlist.getMaxBorrowtime(sid));
					int new_maxborrowtime = maxborrowtime + 1;
					if(new_maxborrowtime < 6) {
						userlist.setMaxborrowtime(sid, String.valueOf(new_maxborrowtime));
						System.out.printf("Now you have %d borrow quota.\n", new_maxborrowtime);
					}
				}else {
					System.out.printf("You did not borrow this book.\n");
				}
			}
		}
	}


	public void Borrow_book(String bookID) throws ParseException {
		Book book = Get_book(bookID);
		//String bookBorrower = book.getBorrower();
		if(book.getBorrower() == null)
		{

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
			Date date = new Date();  
			book.setBorrowDate(formatter.format(date));

	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.add(Calendar.DATE, 14); 
	        
	        book.setReturnDate((formatter.format(cal.getTime())).toString());
			
	        LMSystem lm = LMSystem.getInstance();
			book.setBorrower(lm.getId());
			
			int btimes;
			if(book.getBorrowTimes().equals("0")) {
				btimes = 1;
			}else {
				btimes = (Integer.parseInt(book.getBorrowTimes())+1);
			}
			book.setBorrowTimes(String.valueOf(btimes));
			
			int maxborrowtime;
			maxborrowtime = Integer.parseInt(userlist.getMaxBorrowtime(lm.getId()));
			if(maxborrowtime < 1) {
				System.out.print("You have borrowed 5 books alreday!\n");
			}else{
				maxborrowtime = maxborrowtime -1;
				userlist.setMaxborrowtime(lm.getId(), String.valueOf(maxborrowtime));
				System.out.printf("\nBorrower:%s\nBorrowDate:%s\nReturnDate:%s\n",book.getBorrower(),book.getBorrowDate(),book.getReturnDate());
				System.out.printf("You still have %s borrow quota.\n",maxborrowtime);
			}
			
			

		}else {
			System.out.print("This book is borrowed!\n");
		}
	}


	public void addBook(Book book) {
		// TODO - implement Book_list.Add_book
		booklist.add(book);
		
	}


	public void Delete_book(String id) {
		// TODO - implement Book_list.Delete_book
		Book book = Get_book(id);
		booklist.remove(book);
		System.out.println("\nDeleted book successfully!\n");
	}
	
	public static int getTotalBook() {
		System.out.println(booklist.size());
		return booklist.size();
	}

		
	public static void exportBookList() throws Exception {
		
		String sheetName = "booklist";
		String outputFile = "Booklist.xlsx";
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sh = workbook.createSheet(sheetName);
		
		int rownum = 0;
		for(Book i : booklist) {
			Row row = sh.createRow(rownum++);
			row.createCell(0).setCellValue(i.getTitle());
			row.createCell(1).setCellValue(i.getAuthor());
			row.createCell(2).setCellValue(i.getBookID());
			row.createCell(3).setCellValue(i.getCategory());
			row.createCell(4).setCellValue(i.getPublisher());
			row.createCell(5).setCellValue(i.getPubblishDate());
			row.createCell(6).setCellValue(i.getBorrowDate());
			row.createCell(7).setCellValue(i.getReturnDate());
			row.createCell(8).setCellValue(i.getBorrowTimes());
			row.createCell(9).setCellValue(i.getBorrower());
		}
		FileOutputStream fileout =  new FileOutputStream(outputFile);
		workbook.write(fileout);
		fileout.close();
		workbook.close();

	}
}

