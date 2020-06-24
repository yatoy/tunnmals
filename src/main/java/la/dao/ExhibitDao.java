package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.ExhibitBeans;

public class ExhibitDao {
	private final String url = "jdbc:postgresql:textbookbsdb";
	private final String user = "student";
	private final String pass = "himitu";

	public ExhibitDao() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ExhibitBeans searchByBookId(int book_id) {

		String sql = "SELECT * FROM exhibit WHERE book_id=?";
		ExhibitBeans bean = null;

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, book_id);

			try (ResultSet rs = st.executeQuery();) {

				while (rs.next()) {
					bean = new ExhibitBeans(
							rs.getInt("book_id"),
							rs.getString("book_name"),
							rs.getString("isbn"),
							rs.getInt("price"),
							rs.getString("author"),
							rs.getString("quality"),
							rs.getString("class"),
							rs.getInt("seller_id"),
							rs.getString("sell_date"),
							rs.getInt("buyer_id"),
							rs.getString("buy_date"),
							rs.getString("payment_method"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

		return bean;
	}

	public ExhibitBeans add(ExhibitBeans bean) {

		String sql = "INSERT INTO exhibit("
				+ "book_name, "
				+ "isbn,"
				+ "price,"
				+ "author,"
				+ "quality,"
				+ "class,"
				+ "seller_id,"
				+ "sell_date"
				+ ") VALUES(?,?,?,?,?,?,?,?)";

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setString(1, bean.getBook_name());
			st.setString(2, bean.getIsbn());
			st.setInt(3, bean.getPrice());
			st.setString(4, bean.getAuthor());
			st.setString(5, bean.getQuality());
			st.setString(6, bean.getCategory());
			st.setInt(7, bean.getSeller_id());
			st.setDate(8, Date.valueOf(bean.getSell_date()));

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

		return searchByBookId(max());
	}

	public void delete(int book_id) {

		String sql = "DELETE FROM exhibit WHERE book_id=?";

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, book_id);

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ExhibitBeans update(ExhibitBeans bean) {
		String sql = "UPDATE exhibit SET "
				+ "book_name=?,"
				+ "isbn=?,"
				+ "price=?,"
				+ "author=?,"
				+ "quality=?,"
				+ "class=?,"
				+ "seller_id=?,"
				+ "sell_date=?,"
				+ "buyer_id=?,"
				+ "buy_date=?,"
				+ "payment_method=?"
				+ " WHERE book_id=?";

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setString(1, bean.getBook_name());
			st.setString(2, bean.getIsbn());
			st.setInt(3, bean.getPrice());
			st.setString(4, bean.getAuthor());
			st.setString(5, bean.getQuality());
			st.setString(6, bean.getCategory());
			st.setInt(7, bean.getSeller_id());
			st.setDate(8, Date.valueOf(bean.getSell_date()));
			st.setInt(9, bean.getBuyer_id());
			st.setDate(10, Date.valueOf(bean.getBuy_date()));
			st.setString(11, bean.getPayment_method());
			st.setInt(12, bean.getBook_id());

			st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

		return searchByBookId(bean.getBook_id());
	}

	public int max() {
		String sql = "SELECT max(book_id) from exhibit";
		int max = 0;

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {
			try (ResultSet rs = st.executeQuery();) {
				rs.next();
				max = rs.getInt("max");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;

		}

		return max;
	}

	public List<ExhibitBeans> searchAll() {

		String sql = "SELECT * FROM exhibit";
		List<ExhibitBeans> list = new ArrayList<ExhibitBeans>();

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {

			while (rs.next()) {
				ExhibitBeans bean = new ExhibitBeans(
						rs.getInt("book_id"),
						rs.getString("book_name"),
						rs.getString("isbn"),
						rs.getInt("price"),
						rs.getString("author"),
						rs.getString("quality"),
						rs.getString("class"),
						rs.getInt("seller_id"),
						rs.getString("sell_date"),
						rs.getInt("buyer_id"),
						rs.getString("buy_date"),
						rs.getString("payment_method"));

				list.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

		return list;
	}

	public List<ExhibitBeans> searchByBuyerId(int buyer_id) {

		String sql = "SELECT * FROM exhibit WHERE buyer_id=?";

		List<ExhibitBeans> list = new ArrayList<ExhibitBeans>();

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, buyer_id);

			try (ResultSet rs = st.executeQuery();) {

				while (rs.next()) {
					ExhibitBeans bean = new ExhibitBeans(
							rs.getInt("book_id"),
							rs.getString("book_name"),
							rs.getString("isbn"),
							rs.getInt("price"),
							rs.getString("author"),
							rs.getString("quality"),
							rs.getString("class"),
							rs.getInt("seller_id"),
							rs.getString("sell_date"),
							rs.getInt("buyer_id"),
							rs.getString("buy_date"),
							rs.getString("payment_method"));

					list.add(bean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

		return list;
	}

	public List<ExhibitBeans> searchBySellerId(int seller_id) {

		String sql = "SELECT * FROM exhibit WHERE seller_id=?";

		List<ExhibitBeans> list = new ArrayList<ExhibitBeans>();

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, seller_id);

			try (ResultSet rs = st.executeQuery();) {

				while (rs.next()) {
					ExhibitBeans bean = new ExhibitBeans(
							rs.getInt("book_id"),
							rs.getString("book_name"),
							rs.getString("isbn"),
							rs.getInt("price"),
							rs.getString("author"),
							rs.getString("quality"),
							rs.getString("class"),
							rs.getInt("seller_id"),
							rs.getString("sell_date"),
							rs.getInt("buyer_id"),
							rs.getString("buy_date"),
							rs.getString("payment_method"));

					list.add(bean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

		return list;
	}

	public List<ExhibitBeans> seachAllBuy() {

		String sql = "SELECT * FROM exhibit WHERE buyer_id > 0";

		List<ExhibitBeans> list = new ArrayList<ExhibitBeans>();

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();) {

			while (rs.next()) {
				ExhibitBeans bean = new ExhibitBeans(
						rs.getInt("book_id"),
						rs.getString("book_name"),
						rs.getString("isbn"),
						rs.getInt("price"),
						rs.getString("author"),
						rs.getString("quality"),
						rs.getString("class"),
						rs.getInt("seller_id"),
						rs.getString("sell_date"),
						rs.getInt("buyer_id"),
						rs.getString("buy_date"),
						rs.getString("payment_method"));

				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}

		return list;
	}

}
