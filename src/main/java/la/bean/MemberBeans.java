package la.bean;

import java.io.Serializable;

public class MemberBeans implements Serializable {
	public MemberBeans(int id, String family_name, String first_name, String postal, String address, String tel,
			String email, String birthday, String password, String register_date, String change_date) {

		setId(id);
		setFamily_name(family_name);
		setFirst_name(first_name);
		setPostal(postal);
		setAddress(address);
		setTel(tel);
		setEmail(email);
		setBirthday(birthday);
		setPassword(password);
		setRegister_date(register_date);
		setChange_date(change_date);
	}

	public MemberBeans(String family_name, String first_name, String postal, String address, String tel,
			String email, String birthday, String password, String register_date) {
		this(0, family_name, first_name, postal, address, tel, email, birthday, password, register_date, null);
	}

	public MemberBeans(int id, String family_name, String first_name, String postal, String address, String tel,
			String email, String birthday, String password, String register_date) {
		this(id, family_name, first_name, postal, address, tel, email, birthday, password, register_date, null);
	}

	public MemberBeans() {
	}

	private int id;
	private String family_name;
	private String first_name;
	private String postal;
	private String address;
	private String tel;
	private String email;
	private String birthday;
	private String password;
	private String register_date;
	private String change_date;

	public int getId() {
		return id;
	}

	public String getFamily_name() {
		return family_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getPostal() {
		return postal;
	}

	public String getAddress() {
		return address;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getPassword() {
		return password;
	}

	public String getRegister_date() {
		return register_date;
	}

	public String getChange_date() {
		return change_date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;

	}

	public void setChange_date(String change_date) {
		this.change_date = change_date;
	}

}
