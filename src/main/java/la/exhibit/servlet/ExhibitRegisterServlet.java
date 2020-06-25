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
		String price = request.getParameter("price");
		String author = request.getParameter("author");
		String quality = request.getParameter("quality");
		String book_class = request.getParameter("class");

		if (book_name == null || "".equals(book_name)
				|| isbn == null || "".equals(isbn)
				|| price == null || "".equals(price)
				|| author == null || "".equals(author)
				|| quality == null || "".equals(quality)
				|| book_class == null || "".equals(book_class)) {

			doGet(request, response);
			return;
		}

		gotoPage(request, response, "/Exhibit/ExhibitRegisterCheck.jsp");

	}

	protected void doComplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String book_name = request.getParameter("book_name");
		String isbn = request.getParameter("isbn");
		int price = Integer.parseInt(request.getParameter("price"));
		String author = request.getParameter("author");
		String quality = request.getParameter("quality");
		String book_class = request.getParameter("class");

		//exhibitテーブルに追加
		HttpSession session = request.getSession(false);
		int seller_id = (int) session.getAttribute("id");

		Calendar cal = Calendar.getInstance(); //[1]
		String sell_date = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-"
				+ cal.get(Calendar.DATE);

		ExhibitDao dao = new ExhibitDao();
		ExhibitBeans bean = new ExhibitBeans(book_name, isbn, price, author, quality, book_class,
				seller_id, sell_date);
		bean = dao.add(bean);
		int id = bean.getBook_id();
		request.setAttribute("book_id", id);
		gotoPage(request, response, "/Exhibit/ExhibitRegisterComplete.jsp");
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
