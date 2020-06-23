package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import la.bean.MemberBeans;

class MemberDaoTest extends MemberDao {

	@Test
	void testSearchById() {
		MemberDao dao = new MemberDao();

		MemberBeans bean = dao.searchById(1);

		Assertions.assertEquals(1, bean.getId());
		Assertions.assertEquals("加藤", bean.getFamily_name());
		Assertions.assertEquals("ねこ", bean.getFirst_name());
		Assertions.assertEquals("1111111", bean.getPostal());
		Assertions.assertEquals("東京都", bean.getAddress());
		Assertions.assertEquals("03-1111-1111", bean.getTel());
		Assertions.assertEquals("katou@text.net", bean.getEmail());
		Assertions.assertEquals("2013-09-04", bean.getBirthday());
		Assertions.assertEquals("12345678", bean.getPassword());
		Assertions.assertEquals("2020-09-04", bean.getRegister_date());
		Assertions.assertEquals(null, bean.getChange_date());
	}

	@Test
	void testSearchByIdPassword() {
		MemberDao dao = new MemberDao();

		MemberBeans bean = dao.searchByIdPassword(1, "12345678");

		Assertions.assertEquals(1, bean.getId());
		Assertions.assertEquals("加藤", bean.getFamily_name());
		Assertions.assertEquals("ねこ", bean.getFirst_name());
		Assertions.assertEquals("1111111", bean.getPostal());
		Assertions.assertEquals("東京都", bean.getAddress());
		Assertions.assertEquals("03-1111-1111", bean.getTel());
		Assertions.assertEquals("katou@text.net", bean.getEmail());
		Assertions.assertEquals("2013-09-04", bean.getBirthday());
		Assertions.assertEquals("12345678", bean.getPassword());
		Assertions.assertEquals("2020-09-04", bean.getRegister_date());
		Assertions.assertEquals(null, bean.getChange_date());
	}

	@Test
	void testAdd() {
		MemberDao dao = new MemberDao();

		MemberBeans bean = new MemberBeans("佐藤", "かめ", "4444444", "鳥取県", "03-4444-4444", "satou@text.net",
				"2020-04-30", "12345678", "2022-03-21");

		bean = dao.add(bean);

		Assertions.assertEquals("佐藤", bean.getFamily_name());
		Assertions.assertEquals("かめ", bean.getFirst_name());
		Assertions.assertEquals("4444444", bean.getPostal());
		Assertions.assertEquals("鳥取県", bean.getAddress());
		Assertions.assertEquals("03-4444-4444", bean.getTel());
		Assertions.assertEquals("satou@text.net", bean.getEmail());
		Assertions.assertEquals("2020-04-30", bean.getBirthday());
		Assertions.assertEquals("12345678", bean.getPassword());
		Assertions.assertEquals("2022-03-21", bean.getRegister_date());
		Assertions.assertEquals(null, bean.getChange_date());
	}

	@Test
	void testUpdate() {
		MemberDao dao = new MemberDao();

		MemberBeans bean = new MemberBeans(
				3,
				"佐藤",
				"かめごろう",
				"4444444",
				"鳥取県",
				"03-4444-4444",
				"satou@text.net",
				"2020-04-30",
				"12345678",
				"2022-03-21",
				"2022-03-21");

		bean = dao.update(bean);

		Assertions.assertEquals(3, bean.getId());
		Assertions.assertEquals("佐藤", bean.getFamily_name());
		Assertions.assertEquals("かめごろう", bean.getFirst_name());
		Assertions.assertEquals("4444444", bean.getPostal());
		Assertions.assertEquals("鳥取県", bean.getAddress());
		Assertions.assertEquals("03-4444-4444", bean.getTel());
		Assertions.assertEquals("satou@text.net", bean.getEmail());
		Assertions.assertEquals("2020-04-30", bean.getBirthday());
		Assertions.assertEquals("12345678", bean.getPassword());
		Assertions.assertEquals("2022-03-21", bean.getRegister_date());
		Assertions.assertEquals("2022-03-21", bean.getChange_date());
	}

	@Test
	void testDelete() {
		MemberDao dao = new MemberDao();

		dao.delete(1, "12345678");

		MemberBeans bean = dao.searchById(1);
		Assertions.assertEquals(null, bean);
	}

	@Test
	void testMax() {
		MemberDao dao = new MemberDao();

		Assertions.assertEquals(3, dao.max());
	}

	@BeforeEach
	void prepare() {
		String url = "jdbc:postgresql:textbookbsdb";
		String user = "student";
		String pass = "himitu";

		String sql = "DELETE FROM member";
		String sql2 = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?,?)";
		String sql3 = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?,?)";
		String sql4 = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?,?)";

		try (Connection con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st = con.prepareStatement(sql);
				PreparedStatement st2 = con.prepareStatement(sql2);
				PreparedStatement st3 = con.prepareStatement(sql3);
				PreparedStatement st4 = con.prepareStatement(sql4);) {

			st2.setInt(1, 1);
			st2.setString(2, "加藤");
			st2.setString(3, "ねこ");
			st2.setString(4, "1111111");
			st2.setString(5, "東京都");
			st2.setString(6, "03-1111-1111");
			st2.setString(7, "katou@text.net");
			st2.setDate(8, Date.valueOf("2013-09-04"));
			st2.setString(9, "12345678");
			st2.setDate(10, Date.valueOf("2020-09-04"));

			st3.setInt(1, 2);
			st3.setString(2, "田中");
			st3.setString(3, "子豚");
			st3.setString(4, "2222222");
			st3.setString(5, "東京都");
			st3.setString(6, "03-2222-2222");
			st3.setString(7, "tanaka@text.net");
			st3.setDate(8, Date.valueOf("2013-09-04"));
			st3.setString(9, "12345678");
			st3.setDate(10, Date.valueOf("2020-09-04"));

			st4.setInt(1, 3);
			st4.setString(2, "鈴木");
			st4.setString(3, "うさぎ");
			st4.setString(4, "3333333");
			st4.setString(5, "茨城県");
			st4.setString(6, "03-3333-3333");
			st4.setString(7, "suzuki@text.net");
			st4.setDate(8, Date.valueOf("2013-09-04"));
			st4.setString(9, "12345678");
			st4.setDate(10, Date.valueOf("2020-09-04"));

			st.executeUpdate();
			st2.executeUpdate();
			st3.executeUpdate();
			st4.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
