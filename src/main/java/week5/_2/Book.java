package week5._2;

public class Book {
	private Integer bookId;
	private String bookName;
	private Double price;
	private String publisher;
	public Book(Integer bookId, String bookName, Double price, String publisher) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.publisher = publisher;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", price=" + price + ", publisher=" + publisher
				+ "]";
	}
}
