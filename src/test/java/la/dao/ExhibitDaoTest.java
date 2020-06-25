package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import la.bean.ExhibitBeans;

class ExhibitDaoTest extends ExhibitDao {

	@Test
	void testAdd() {
		ExhibitDao dao = new ExhibitDao();

		ExhibitBeans bean = new ExhibitBeans(
				"亀とウサギ",
				"4444444444444",
				4444,
				"亀",
				"中古",
				"社会学部系",
				4,
				"2019-08-20");

		bean = dao.add(bean);

		Assertions.assertEquals("亀とウサギ", bean.getBook_name());
		Assertions.assertEquals("4444444444444", bean.getIsbn());
		Assertions.assertEquals(4444, bean.getPrice());
		Assertions.assertEquals("亀", bean.getAuthor());
		Assertions.assertEquals("中古", bean.getQuality());
		Assertions.assertEquals("社会学部系", bean.getCategory());
		Assertions.assertEquals(4, bean.getSeller_id());
		Assertions.assertEquals("2019-08-20", bean.getSell_date());
		Assertions.assertEquals(0, bean.getBuyer_id());
		Assertions.assertEquals(null, bean.getBuy_date());
		Assertions.assertEquals(null, bean.getPayment_method());
	}

	@Test
	void testDelete() {
		ExhibitDao dao = new ExhibitDao();

		dao.delete(1);

		ExhibitBeans bean = dao.searchByBookId(1);
		Assertions.assertEquals(null, bean);
	}

	@Test
	void testUpdate() {
		ExhibitDao dao = new ExhibitDao();

		ExhibitBeans bean = new ExhibitBeans(
				3,
				"亀とウサギと私",
				"4444444444444",
				4444,
				"亀",
				"新品!!!!!",
				"社会学部系",
				4,
				"2019-08-20",
				3,
				"2019-08-20",
				"銀行");

		bean = dao.buy(bean);

		Assertions.assertEquals(3, bean.getBook_id());
		Assertions.assertEquals("亀とウサギと私", bean.getBook_name());
		Assertions.assertEquals("4444444444444", bean.getIsbn());
		Assertions.assertEquals(4444, bean.getPrice());
		Assertions.assertEquals("亀", bean.getAuthor());
		Assertions.assertEquals("新品!!!!!", bean.getQuality());
		Assertions.assertEquals("社会学部系", bean.getCategory());
		Assertions.assertEquals(4, bean.getSeller_id());
		Assertions.assertEquals("2019-08-20", bean.getSell_date());
		Assertions.assertEquals(3, bean.getBuyer_id());
		Assertions.assertEquals("2019-08-20", bean.getBuy_date());
		Assertions.assertEquals("銀行", bean.getPayment_method());
	}

	@Test
	void testSearchAll() {
		ExhibitDao dao = new ExhibitDao();

		List<ExhibitBeans> list = dao.searchAll();

		Assertions.assertEquals(1, list.get(0).getBook_id());
		Assertions.assertEquals("猿も木から落ちる", list.get(0).getBook_name());
		Assertions.assertEquals("1111111111111", list.get(0).getIsbn());
		Assertions.assertEquals(111, list.get(0).getPrice());
		Assertions.assertEquals("猿", list.get(0).getAuthor());
		Assertions.assertEquals("新品", list.get(0).getQuality());
		Assertions.assertEquals("文学部系", list.get(0).getCategory());
		Assertions.assertEquals(1, list.get(0).getSeller_id());
		Assertions.assertEquals("2020-11-12", list.get(0).getSell_date());
		Assertions.assertEquals(0, list.get(0).getBuyer_id());
		Assertions.assertEquals(null, list.get(0).getBuy_date());
		Assertions.assertEquals(null, list.get(0).getPayment_method());

		Assertions.assertEquals(2, list.get(1).getBook_id());
		Assertions.assertEquals("豚に真珠", list.get(1).getBook_name());
		Assertions.assertEquals("2222222222222", list.get(1).getIsbn());
		Assertions.assertEquals(222, list.get(1).getPrice());
		Assertions.assertEquals("豚", list.get(1).getAuthor());
		Assertions.assertEquals("中古", list.get(1).getQuality());
		Assertions.assertEquals("教育学部系", list.get(1).getCategory());
		Assertions.assertEquals(2, list.get(1).getSeller_id());
		Assertions.assertEquals("2020-10-12", list.get(1).getSell_date());
		Assertions.assertEquals(0, list.get(1).getBuyer_id());
		Assertions.assertEquals(null, list.get(1).getBuy_date());
		Assertions.assertEquals(null, list.get(1).getPayment_method());

	}

	@Test
	void testSearchByBuyerId() {
		ExhibitDao dao = new ExhibitDao();

		List<ExhibitBeans> list = dao.searchByBuyerId(1);

		Assertions.assertEquals(4, list.get(0).getBook_id());
		Assertions.assertEquals("ぴょんぴょん", list.get(0).getBook_name());
		Assertions.assertEquals("4444444444444", list.get(0).getIsbn());
		Assertions.assertEquals(444, list.get(0).getPrice());
		Assertions.assertEquals("ウサギを狩る", list.get(0).getAuthor());
		Assertions.assertEquals("未使用", list.get(0).getQuality());
		Assertions.assertEquals("法学部系", list.get(0).getCategory());
		Assertions.assertEquals(3, list.get(0).getSeller_id());
		Assertions.assertEquals("2020-08-12", list.get(0).getSell_date());
		Assertions.assertEquals(1, list.get(0).getBuyer_id());
		Assertions.assertEquals("2020-09-12", list.get(0).getBuy_date());
		Assertions.assertEquals("銀行振込", list.get(0).getPayment_method());

		Assertions.assertEquals(5, list.get(1).getBook_id());
		Assertions.assertEquals("ぴょぴょぴょん", list.get(1).getBook_name());
		Assertions.assertEquals("5555555555555", list.get(1).getIsbn());
		Assertions.assertEquals(555, list.get(1).getPrice());
		Assertions.assertEquals("亀を狩る", list.get(1).getAuthor());
		Assertions.assertEquals("未使用", list.get(1).getQuality());
		Assertions.assertEquals("法学部系", list.get(1).getCategory());
		Assertions.assertEquals(3, list.get(1).getSeller_id());
		Assertions.assertEquals("2020-07-12", list.get(1).getSell_date());
		Assertions.assertEquals(1, list.get(1).getBuyer_id());
		Assertions.assertEquals("2020-09-12", list.get(1).getBuy_date());
		Assertions.assertEquals("銀行振込", list.get(1).getPayment_method());

	}

	@Test
	void testSeachAllBuy() {
		ExhibitDao dao = new ExhibitDao();

		List<ExhibitBeans> list = dao.seachAllBuy();

		Assertions.assertEquals(4, list.get(0).getBook_id());
		Assertions.assertEquals("ぴょんぴょん", list.get(0).getBook_name());
		Assertions.assertEquals("4444444444444", list.get(0).getIsbn());
		Assertions.assertEquals(444, list.get(0).getPrice());
		Assertions.assertEquals("ウサギを狩る", list.get(0).getAuthor());
		Assertions.assertEquals("未使用", list.get(0).getQuality());
		Assertions.assertEquals("法学部系", list.get(0).getCategory());
		Assertions.assertEquals(3, list.get(0).getSeller_id());
		Assertions.assertEquals("2020-08-12", list.get(0).getSell_date());
		Assertions.assertEquals(1, list.get(0).getBuyer_id());
		Assertions.assertEquals("2020-09-12", list.get(0).getBuy_date());
		Assertions.assertEquals("銀行振込", list.get(0).getPayment_method());

		Assertions.assertEquals(5, list.get(1).getBook_id());
		Assertions.assertEquals("ぴょぴょぴょん", list.get(1).getBook_name());
		Assertions.assertEquals("5555555555555", list.get(1).getIsbn());
		Assertions.assertEquals(555, list.get(1).getPrice());
		Assertions.assertEquals("亀を狩る", list.get(1).getAuthor());
		Assertions.assertEquals("未使用", list.get(1).getQuality());
		Assertions.assertEquals("法学部系", list.get(1).getCategory());
		Assertions.assertEquals(3, list.get(1).getSeller_id());
		Assertions.assertEquals("2020-07-12", list.get(1).getSell_date());
		Assertions.assertEquals(1, list.get(1).getBuyer_id());
		Assertions.assertEquals("2020-09-12", list.get(1).getBuy_date());
		Assertions.assertEquals("銀行振込", list.get(1).getPayment_method());

		Assertions.assertEquals(6, list.get(2).getBook_id());
		Assertions.assertEquals("私がぴょん", list.get(2).getBook_name());
		Assertions.assertEquals("6666666666666", list.get(2).getIsbn());
		Assertions.assertEquals(666, list.get(2).getPrice());
		Assertions.assertEquals("不吉ねを狩る", list.get(2).getAuthor());
		Assertions.assertEquals("未使用", list.get(2).getQuality());
		Assertions.assertEquals("法学部系", list.get(2).getCategory());
		Assertions.assertEquals(2, list.get(2).getSeller_id());
		Assertions.assertEquals("2020-07-12", list.get(2).getSell_date());
		Assertions.assertEquals(2, list.get(2).getBuyer_id());
		Assertions.assertEquals("2020-12-12", list.get(2).getBuy_date());
		Assertions.assertEquals("銀行振込", list.get(2).getPayment_method());

	}

	@Test
	void testMax() {
		ExhibitDao dao = new ExhibitDao();

		Assertions.assertEquals(6, dao.max());
	}

	@Test
	void testSeachNotSellerId() {
		ExhibitDao dao = new ExhibitDao();

		List<ExhibitBeans> list = dao.searchByNotSellerId(3);

		Assertions.assertEquals(1, list.get(0).getBook_id());
		Assertions.assertEquals("猿も木から落ちる", list.get(0).getBook_name());
		Assertions.assertEquals("1111111111111", list.get(0).getIsbn());

		Assertions.assertEquals(2, list.get(1).getBook_id());
		Assertions.assertEquals("豚に真珠", list.get(1).getBook_name());
		Assertions.assertEquals("2222222222222", list.get(1).getIsbn());

	}

	@BeforeEach
	void prepare() {
		String url = "jdbc:postgresql:textbookbsdb";
		String user = "student";
		String pass = "himitu";

		String sql = "DELETE FROM exhibit";
		String sql2 = "INSERT INTO exhibit VALUES(?,?,?,?,?,?,?,?,?)";
		String sql3 = "INSERT INTO exhibit VALUES(?,?,?,?,?,?,?,?,?)";
		String sql4 = "INSERT INTO exhibit VALUES(?,?,?,?,?,?,?,?,?)";
		String sql5 = "INSERT INTO exhibit VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql6 = "INSERT INTO exhibit VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql7 = "INSERT INTO exhibit VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				PreparedStatement st2 = con.prepareStatement(sql2);
				PreparedStatement st3 = con.prepareStatement(sql3);
				PreparedStatement st4 = con.prepareStatement(sql4);
				PreparedStatement st5 = con.prepareStatement(sql5);
				PreparedStatement st6 = con.prepareStatement(sql6);
				PreparedStatement st7 = con.prepareStatement(sql7);) {

			st2.setInt(1, 1);
			st2.setString(2, "猿も木から落ちる");
			st2.setString(3, "1111111111111");
			st2.setInt(4, 111);
			st2.setString(5, "猿");
			st2.setString(6, "新品");
			st2.setString(7, "文学部系");
			st2.setInt(8, 1);
			st2.setDate(9, Date.valueOf("2020-11-12"));

			st3.setInt(1, 2);
			st3.setString(2, "豚に真珠");
			st3.setString(3, "2222222222222");
			st3.setInt(4, 222);
			st3.setString(5, "豚");
			st3.setString(6, "中古");
			st3.setString(7, "教育学部系");
			st3.setInt(8, 2);
			st3.setDate(9, Date.valueOf("2020-10-12"));

			st4.setInt(1, 3);
			st4.setString(2, "心がぴょんぴょん");
			st4.setString(3, "3333333333333");
			st4.setInt(4, 333);
			st4.setString(5, "ウサギ");
			st4.setString(6, "未使用");
			st4.setString(7, "法学部系");
			st4.setInt(8, 3);
			st4.setDate(9, Date.valueOf("2020-09-12"));

			st5.setInt(1, 4);
			st5.setString(2, "ぴょんぴょん");
			st5.setString(3, "4444444444444");
			st5.setInt(4, 444);
			st5.setString(5, "ウサギを狩る");
			st5.setString(6, "未使用");
			st5.setString(7, "法学部系");
			st5.setInt(8, 3);
			st5.setDate(9, Date.valueOf("2020-08-12"));
			st5.setInt(10, 1);
			st5.setDate(11, Date.valueOf("2020-09-12"));
			st5.setString(12, "銀行振込");

			st6.setInt(1, 5);
			st6.setString(2, "ぴょぴょぴょん");
			st6.setString(3, "5555555555555");
			st6.setInt(4, 555);
			st6.setString(5, "亀を狩る");
			st6.setString(6, "未使用");
			st6.setString(7, "法学部系");
			st6.setInt(8, 3);
			st6.setDate(9, Date.valueOf("2020-07-12"));
			st6.setInt(10, 1);
			st6.setDate(11, Date.valueOf("2020-09-12"));
			st6.setString(12, "銀行振込");

			st7.setInt(1, 6);
			st7.setString(2, "私がぴょん");
			st7.setString(3, "6666666666666");
			st7.setInt(4, 666);
			st7.setString(5, "不吉ねを狩る");
			st7.setString(6, "未使用");
			st7.setString(7, "法学部系");
			st7.setInt(8, 2);
			st7.setDate(9, Date.valueOf("2020-07-12"));
			st7.setInt(10, 2);
			st7.setDate(11, Date.valueOf("2020-12-12"));
			st7.setString(12, "銀行振込");

			st.executeUpdate();
			st2.executeUpdate();
			st3.executeUpdate();
			st4.executeUpdate();
			st5.executeUpdate();
			st6.executeUpdate();
			st7.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
