package libsystem;
public class Book {

	private String Title;
	private String Author;
	private String BookID;
	private String Category;
	private String Publisher;
	private String BorrowDate;
	private String ReturnDate;
	private String PubblishDate;
	private String BorrowTimes;
	private String Borrower;


	public Book(String Title, String Author, String BookID, String Category, String Publisher, String BorrowDate, 
			String ReturnDate, String PubblishDate, String BorrowTimes, String Borrower) {
		// TODO - implement Book.Book
		this.Title = Title;
		this.Author = Author;
		this.BookID = BookID;
		this.Category = Category;
		this.Publisher = Publisher;
//		this.Borrower = Borrower;
//		this.BorrowDate = BorrowDate;
//		this.ReturnDate = ReturnDate;
		this.PubblishDate = PubblishDate;
		this.BorrowTimes = BorrowTimes;
		
		Borrower = " ";
		BorrowDate = " ";
		ReturnDate = " ";
//		PubblishDate =;
//		BorrowTimes = "0";
	}

		// TODO Auto-generated constructor stub

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getBookID() {
		return BookID;
	}

	public void setBookID(String bookID) {
		BookID = bookID;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getBorrowDate() {
		return BorrowDate;
	}

	public void setBorrowDate(String borrowDate) {
		BorrowDate = borrowDate;
	}

	public String getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(String returnDate) {
		ReturnDate = returnDate;
	}

	public String getPubblishDate() {
		return PubblishDate;
	}

	public void setPubblishDate(String pubblishDate) {
		PubblishDate = pubblishDate;
	}

	public String getBorrowTimes() {
		return BorrowTimes;
	}

	public void setBorrowTimes(String borrowTimes) {
		BorrowTimes = borrowTimes;
	}
	
	public String getBorrower() {
		return Borrower;
	}

	public void setBorrower(String borrower) {
		Borrower = borrower;
	}

}