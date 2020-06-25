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

		try {
			HttpSession session = request.getSession(false);

			if (session != null && session.getAttribute("id") != null) {

				int id = (int) session.getAttribute("id");

				MemberDao dao = new MemberDao();
				MemberBeans bean = new MemberBeans();
				bean = dao.searchById(id);
				request.setAttribute("member", bean);

				gotoPage(request, response, "/Member/MemberUpdate.jsp");
			} else {

				gotoPage(request, response, "/Member/MemberLogin.jsp");
			}

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
			return;
		}
		if ("complete".contentEquals(type)) {
			doComplete(request, response);
			return;
		}

		doGet(request, response);
	}

	protected void doCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String family_name = request.getParameter("family_name");
		String first_name = request.getParameter("first_name");
		String postal = request.getParameter("postal");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String register_date = request.getParameter("register_date");

		if (family_name == null || "".equals(family_name)
				|| first_name == null || "".equals(first_name)
				|| postal == null || "".equals(postal)
				|| address == null || "".equals(address)
				|| tel == null || "".equals(tel)
				|| birthday == null || "".equals(birthday)
				|| email == null || "".equals(email)
				|| password1 == null || "".equals(password1)
				|| password2 == null || "".equals(password2)) {

			doGet(request, response);
			return;
		}

		if (!password1.equals(password2)) {
			gotoPage(request, response, "/Member/MemberUpdate.jsp");
			return;
		}

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("id") != null) {
			Calendar cal = Calendar.getInstance();
			String change_date = cal.get(Calendar.YEAR)
					+ "-"
					+ (cal.get(Calendar.MONTH) + 1)
					+ "-"
					+ cal.get(Calendar.DATE);

			MemberBeans bean = new MemberBeans(
					(int) session.getAttribute("id"),
					family_name,
					first_name,
					postal,
					address,
					tel,
					email,
					birthday,
					password1,
					register_date,
					change_date);

			session.setAttribute("member", bean);

			gotoPage(request, response, "/Member/MemberUpdateCheck.jsp");
			return;
		} else {

			gotoPage(request, response, "/Member/MemberLogin.jsp");
			return;
		}

	}

	protected void doComplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("id") != null && session.getAttribute("member") != null) {

			MemberDao dao = new MemberDao();

			MemberBeans bean = dao.update((MemberBeans) session.getAttribute("member"));

			if (bean == null) {
				request.setAttribute("message", "内部エラーが発生しました。");
				gotoPage(request, response, "/errInternal.jsp");

			}

			gotoPage(request, response, "/Member/MemberUpdateComplete.jsp");
		} else {

			gotoPage(request, response, "/Member/MemberLogin.jsp");
			return;
		}
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}