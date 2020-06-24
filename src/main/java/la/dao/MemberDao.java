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
			return null;

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
			return null;

		}

		return bean;
	}

	public MemberBeans add(MemberBeans bean) {

		String sql = "INSERT INTO member("
				+ "family_name, "
				+ "first_name,"
				+ "postal,"
				+ "address,"
				+ "tel,"
				+ "email,"
				+ "birthday,"
				+ "password,"
				+ "register_date"
				+ ") VALUES(?,?,?,?,?,?,?,?,?)";

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setString(1, bean.getFamily_name());
			st.setString(2, bean.getFirst_name());
			st.setString(3, bean.getPostal());
			st.setString(4, bean.getAddress());
			st.setString(5, bean.getTel());
			st.setString(6, bean.getEmail());
			st.setDate(7, Date.valueOf(bean.getBirthday()));
			st.setString(8, bean.getPassword());
			st.setDate(9, Date.valueOf(bean.getRegister_date()));

			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return searchById(max());
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
		String sql = "UPDATE member SET "
				+ "family_name=?,"
				+ "first_name=?,"
				+ "postal=?,"
				+ "address=?,"
				+ "tel=?,"
				+ "email=?,"
				+ "birthday=?,"
				+ "password=?,"
				+ "register_date=?,"
				+ "change_date=?"
				+ " WHERE id=?";

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setString(1, bean.getFamily_name());
			st.setString(2, bean.getFirst_name());
			st.setString(3, bean.getPostal());
			st.setString(4, bean.getAddress());
			st.setString(5, bean.getTel());
			st.setString(6, bean.getEmail());
			st.setDate(7, Date.valueOf(bean.getBirthday()));
			st.setString(8, bean.getPassword());
			st.setDate(9, Date.valueOf(bean.getRegister_date()));
			st.setDate(10, Date.valueOf(bean.getChange_date()));
			st.setInt(11, bean.getId());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return searchById(bean.getId());
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
			return null;
		}

		return list;
	}

	public int max() {
		String sql = "SELECT max(id) from member";
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

}
