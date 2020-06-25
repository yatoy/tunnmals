package la.exhibit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.ExhibitBeans;
import la.dao.ExhibitDao;

@WebServlet("/ExhibitUpdateServlet")
public class ExhibitUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			HttpSession session = request.getSession(false);

			if (session != null && session.getAttribute("id") != null) {

				int id = Integer.parseInt(request.getParameter("book_id"));
				ExhibitDao dao = new ExhibitDao();
				ExhibitBeans bean = new ExhibitBeans();
				bean = dao.searchByBookId(id);
				request.setAttribute("exhibit", bean);

				gotoPage(request, response, "/Exhibit/UpdateExhibition.jsp");

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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
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

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("id") != null) {
			String book_id_string = request.getParameter("book_id");
			String book_name = request.getParameter("book_name");
			String isbn = request.getParameter("isbn");
			String price_string = request.getParameter("price");
			String author = request.getParameter("author");
			String quality = request.getParameter("quality");
			String book_class = request.getParameter("class");
			int seller_id = (int) session.getAttribute("id");
			String sell_date = request.getParameter("sell_date");
			int book_id;
			int price;

			if (book_name == null || "".equals(book_name)
					|| isbn == null || "".equals(isbn)
					|| price_string == null || "".equals(price_string)
					|| author == null || "".equals(author)
					|| quality == null || "".equals(quality)
					|| book_class == null || "".equals(book_class)) {

				doGet(request, response);
				return;
			}

			try {
				book_id = Integer.parseInt(book_id_string);
				price = Integer.parseInt(price_string);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "内部エラーが発生しました。");
				RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
				rd.forward(request, response);
				return;
			}

			ExhibitBeans bean = new ExhibitBeans(
					book_id,
					book_name,
					isbn,
					price,
					author,
					quality,
					book_class,
					seller_id,
					sell_date);

			session.setAttribute("exhibit", bean);
			gotoPage(request, response, "/Exhibit/UpdateExhibitionCheck.jsp");
			return;
		} else {
			gotoPage(request, response, "/Member/MemberLogin.jsp");
			return;
		}

	}

	protected void doComplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("id") != null) {
			ExhibitBeans bean = (ExhibitBeans) session.getAttribute("exhibit");

			ExhibitDao dao = new ExhibitDao();
			bean = dao.update(bean);

			if (bean != null) {

				gotoPage(request, response, "/Exhibit/UpdateExhibitionComplete.jsp");
			} else {

				gotoPage(request, response, "/Exhibit/UpdateExhibition.jsp");
				return;
			}
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
