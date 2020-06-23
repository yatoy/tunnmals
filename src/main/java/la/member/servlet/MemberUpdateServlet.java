package la.member.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.MemberBeans;
import la.dao.MemberDao;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//		String type = request.getParameter("action");

		try {
			HttpSession session = request.getSession(false);
			int id = (int) session.getAttribute("id");

			MemberDao dao = new MemberDao();
			MemberBeans bean = new MemberBeans();
			bean = dao.searchById(id);
			request.setAttribute("member", bean);

			gotoPage(request, response, "/Member/MemberUpdate.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("action");

		if ("check".contentEquals(type)) {
			doCheck(request, response);
		}
		if ("complete".contentEquals(type)) {
			doComplete(request, response);
		}

		doGet(request, response);
	}

	protected void doCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String family_name = request.getParameter("family_name");
		String first_name = request.getParameter("first_name");
		String postal = request.getParameter("postal");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String password = request.getParameter("password");

		if (email == null || "".equals(email)) {
			email = "未登録";
		}

		if (family_name == null || "".equals(family_name)
				|| first_name == null || "".equals(first_name)
				|| postal == null || "".equals(postal)
				|| address == null || "".equals(address)
				|| tel == null || "".equals(tel)
				|| birthday == null || "".equals(birthday)
				|| password == null || "".equals(password)) {

			doGet(request, response);
			return;
		}

		MemberDao dao = new MemberDao();
		MemberBeans bean = new MemberBeans();
		bean = dao.searchById(id);

		if (password1.equals(password2) && password.equals(bean.getPassword())) {
			request.setAttribute("member", bean);
			gotoPage(request, response, "/Member/MemberRegisterCheck.jsp");
		}

	}

	protected void doComplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String family_name = request.getParameter("family_name");
		String first_name = request.getParameter("first_name");
		String postal = request.getParameter("postal");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String password = request.getParameter("password");
		String register_date = request.getParameter("register_date");

		//memberテーブルに追加
		MemberDao dao = new MemberDao();
		Calendar cal = Calendar.getInstance(); //[1]

		String change_date = cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DATE);
		MemberBeans bean = new MemberBeans(id, family_name, first_name, postal, address, tel, email,
				birthday, password, register_date, change_date);
		dao.update(bean);
		gotoPage(request, response, "/Member/MemberRegisterComplete.jsp");
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}