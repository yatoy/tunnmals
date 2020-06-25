package la.exhibit.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.ExhibitBeans;
import la.dao.ExhibitDao;

/**
 * Servlet implementation class ExhibitRegisterServlet
 */
@WebServlet("/ExhibitRegisterServlet")
public class ExhibitRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			gotoPage(request, response, "/Exhibit/ExhibitRegister.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("action");

		if ("check".equals(type)) {
			doCheck(request, response);
			return;
		}
		if ("complete".equals(type)) {
			doComplete(request, response);
			return;
		}

		doGet(request, response);
	}

	protected void doCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String book_name = request.getParameter("book_name");
		String isbn = request.getParameter("isbn");
		String price_string = request.getParameter("price");
		String author = request.getParameter("author");
		String quality = request.getParameter("quality");
		String book_class = request.getParameter("class");

		Calendar cal = Calendar.getInstance();
		String sell_date = cal.get(Calendar.YEAR)
				+ "-"
				+ (cal.get(Calendar.MONTH) + 1)
				+ "-"
				+ cal.get(Calendar.DATE);

		if (book_name == null || "".equals(book_name)
				|| isbn == null || "".equals(isbn)
				|| price_string == null || "".equals(price_string)
				|| author == null || "".equals(author)
				|| quality == null || "".equals(quality)
				|| book_class == null || "".equals(book_class)) {

			doGet(request, response);
			return;
		}

		HttpSession session = request.getSession(false);

		if (session != null && (session.getAttribute("id")) != null) {
			int price = 0;
			try {
				price = Integer.parseInt(price_string);
			} catch (Exception e) {
				gotoPage(request, response, "/tunnmals/ExhibitRegisterServlet");
			}

			ExhibitBeans bean = new ExhibitBeans(
					book_name,
					isbn,
					price,
					author,
					quality,
					book_class,
					(int) session.getAttribute("id"),
					sell_date);

			session.setAttribute("exhibit", bean);
			gotoPage(request, response, "/Exhibit/ExhibitRegisterCheck.jsp");
		} else {
			gotoPage(request, response, "/Member/MemberLogin.jsp");

		}

	}

	protected void doComplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null && (session.getAttribute("id")) != null) {

			ExhibitDao dao = new ExhibitDao();

			ExhibitBeans bean = (ExhibitBeans) session.getAttribute("exhibit");
			bean = dao.add(bean);

			if (bean == null) {
				request.setAttribute("message", "内部エラーが発生しました。");
				gotoPage(request, response, "/errInternal.jsp");
			}

			session.removeAttribute("exhibit");
			gotoPage(request, response, "/Exhibit/ExhibitRegisterComplete.jsp");
		} else {
			gotoPage(request, response, "/Member/MemberLogin.jsp");
		}

	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		return;
	}

}
