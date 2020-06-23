package la.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import la.bean.MemberBeans;

public class MemberDao {
	private final String url = "jdbc:postgresql:textbookbsdb";
	private final String user = "student";
	private final String pass = "himitu";

	public MemberDao() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberBeans searchById(int id) {

		String sql = "SELECT * FROM member WHERE id=?";
		MemberBeans bean = null;

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, id);

			try (ResultSet rs = st.executeQuery();) {

				while (rs.next()) {
					bean = new MemberBeans(
							rs.getInt("id"),
							rs.getString("family_name"),
							rs.getString("first_name"),
							rs.getString("postal"),
							rs.getString("address"),
							rs.getString("tel"),
							rs.getString("email"),
							rs.getString("birthday"),
							rs.getString("password"),
							rs.getString("register_date"),
							rs.getString("change_date"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bean;
	}

	public MemberBeans searchByIdPassword(int id, String password) {

		String sql = "SELECT * FROM member WHERE id=? AND password=?";
		MemberBeans bean = null;

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, id);
			st.setString(2, password);

			try (ResultSet rs = st.executeQuery();) {

				while (rs.next()) {
					bean = new MemberBeans(
							rs.getInt("id"),
							rs.getString("family_name"),
							rs.getString("first_name"),
							rs.getString("postal"),
							rs.getString("address"),
							rs.getString("tel"),
							rs.getString("email"),
							rs.getString("birthday"),
							rs.getString("password"),
							rs.getString("register_date"),
							rs.getString("change_date"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bean;
	}

	public MemberBeans add(MemberBeans bean) {

		String sql = "INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?,?)";

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, bean.getId());
			st.setString(2, bean.getFamily_name());
			st.setString(3, bean.getFirst_name());
			st.setString(4, bean.getPostal());
			st.setString(5, bean.getAddress());
			st.setString(6, bean.getTel());
			st.setString(7, bean.getEmail());
			st.setDate(8, Date.valueOf(bean.getBirthday()));
			st.setString(9, bean.getPassword());
			st.setDate(10, Date.valueOf(bean.getRegister_date()));

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return searchById(bean.getId());
	}

	public void delete(int id, String password) {

		String sql = "DELETE FROM member WHERE id=? AND password=?";

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, id);
			st.setString(2, password);

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public MemberBeans update(MemberBeans bean) {
		delete(bean.getId(), bean.getPassword());
		return add(bean);
	}

	public List<MemberBeans> searchAll() {

		String sql = "SELECT * FROM member";
		List<MemberBeans> list = new ArrayList<MemberBeans>();

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			try (ResultSet rs = st.executeQuery();) {

				while (rs.next()) {
					MemberBeans bean = new MemberBeans(
							rs.getInt("id"),
							rs.getString("family_name"),
							rs.getString("first_name"),
							rs.getString("postal"),
							rs.getString("address"),
							rs.getString("tel"),
							rs.getString("email"),
							rs.getString("birthday"),
							rs.getString("password"),
							rs.getString("register_date"),
							rs.getString("change_date"));

					list.add(bean);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
