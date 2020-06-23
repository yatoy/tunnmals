package la.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import la.bean.AdminBeans;

public class AdminDao {
	private final String url = "jdbc:postgresql:textbookbsdb";
	private final String user = "student";
	private final String pass = "himitu";

	public AdminBeans searchByIdPassword(int id, String password) {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String sql = "SELECT * FROM admin WHERE id=? AND password=?";
		AdminBeans bean = null;

		try (Connection con = DriverManager.getConnection(this.url, this.user, this.pass);
				PreparedStatement st = con.prepareStatement(sql);) {

			st.setInt(1, id);
			st.setString(2, password);

			try (ResultSet rs = st.executeQuery();) {

				while (rs.next()) {
					bean = new AdminBeans(rs.getInt("id"), rs.getString("password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return bean;
	}
}
