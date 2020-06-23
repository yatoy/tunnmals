package la.bean;

import java.io.Serializable;

public class AdminBeans implements Serializable {
	private int id;
	private String password;

	public AdminBeans() {
	}

	public AdminBeans(int id, String password) {
		this.setId(id);
		this.setPassword(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
