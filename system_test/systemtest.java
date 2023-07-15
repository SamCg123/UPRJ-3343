package system_test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import libsystem.*;

import org.junit.jupiter.api.Test;

class systemtest {
	
	LMSystem lm = LMSystem.getInstance();
	BookList bookList = BookList.getInstance();
	UserList userList = UserList.getInstance();
	@Test
	public void testQ1() throws Exception{
		DataExtraction.extractBookList();
		DataExtraction.extractUserlist();
		bookList.Get_book("9780191905209");
		String[] cmdParts = {"Search","Dictionary"};
		bookList.Search_book(cmdParts);
	}
	@Test
	public void testQ2() throws Exception{
		userList.searchAdmin("1");
		userList.searchCustomer("56225263");
		userList.searchCustomer("5622526zz");
		String n = UserList.getMaxBorrowtime("56225263");
		userList.getTotalmember();
		userList.manageUser("Name","avis","56225263");
		userList.setMaxborrowtime("56225263","5");
		userList.getCustomerList();
    }
	@Test
	public void testQ3() throws Exception{
		String[] cmdParts2 = {"Search","9780191727283"};
		bookList.Search_bookByID(cmdParts2);
	}
	@Test
	public void testQ4() throws Exception{
		bookList.View_bookRanking();
	}
	@Test
	public void testQ5() throws Exception{
		bookList.getTotalBook();
	}
	@Test
	public void testQ6() throws Exception{
		Book b = new Book("a","a","a","a","a","a","a","a","1","a");
		bookList.addBook(b);
	}
	@Test
	public void testQ7() throws Exception{
		bookList.Delete_book("a");
	}
	@Test
    public void testQ8() throws Exception {
        lm.setId("56225263");
        bookList.Borrow_book("9780199891580");
        bookList.Return_book("9780199891580","56225263");
    }
	
	@Test
    public void testQ9() throws Exception {
        bookList.Borrow_book("9780199891580");
        bookList.Renew_book("9780199891580");
        bookList.Return_book("9780199891580","56225263");
        bookList.Get_book("123");
        bookList.Borrow_book("9780199891580");
        bookList.Return_book("9780199891580","123");
        bookList.Borrow_book("9780191726644");
        bookList.Borrow_book("9780191726835");
        bookList.Borrow_book("9780191726460");
        bookList.Borrow_book("9780191726873");
        bookList.Borrow_book("9780191726934");
        bookList.Borrow_book("9780191726422");
        bookList.Borrow_book("9780191726644");
   }

}
