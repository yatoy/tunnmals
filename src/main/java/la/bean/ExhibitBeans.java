package la.bean;

import java.io.Serializable;

public class ExhibitBeans implements Serializable {
	private int book_id;
	private String book_name;
	private String isbn;
	private int price;
	private String author;
	private String quality;
	private String category;
	private int seller_id;
	private String sell_date;
	private int buyer_id;
	private String buy_date;
	private String payment_method;

	public ExhibitBeans(int book_id, String book_name, String isbn, int price, String author, String quality,
			String category, int seller_id, String sell_date, int buyer_id, String buy_date,
			String payment_method) {
		setBook_id(book_id);
		setBook_name(book_name);
		setIsbn(isbn);
		setPrice(price);
		setAuthor(author);
		setQuality(quality);
		setCategory(category);
		setSeller_id(seller_id);
		setSell_date(sell_date);
		setBuyer_id(buyer_id);
		setBuy_date(buy_date);
		setPayment_method(payment_method);

	}

	public ExhibitBeans(int book_id, String book_name, String isbn, int price, String author, String quality,
			String category, int seller_id, String sell_date) {
		this(book_id, book_name, isbn, price, author, quality, category, seller_id, sell_date, 0, null,
				null);
	}

	public ExhibitBeans(String book_name, String isbn, int price, String author, String quality,
			String category, int seller_id, String sell_date) {
		this(0, book_name, isbn, price, author, quality, category, seller_id, sell_date, 0, null,
				null);
	}

	public ExhibitBeans() {
	}

	public int getBook_id() {
		return book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPrice() {
		return price;
	}

	public String getAuthor() {
		return author;
	}

	public String getQuality() {
		return quality;
	}

	public String getCategory() {
		return category;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public String getSell_date() {
		return sell_date;
	}

	public int getBuyer_id() {
		return buyer_id;
	}

	public String getBuy_date() {
		return buy_date;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public void setSell_date(String sell_date) {
		this.sell_date = sell_date;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

}
