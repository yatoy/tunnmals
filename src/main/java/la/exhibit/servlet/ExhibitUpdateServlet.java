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

/**
 * Servlet implementation class ExhibitUpdateServlet
 */
@WebServlet("/ExhibitUpdateServlet")
public class ExhibitUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExhibitUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			HttpSession session = request.getSession(false);
			int id = (int) session.getAttribute("book_id");

			ExhibitDao dao = new ExhibitDao();
			ExhibitBeans bean = new ExhibitBeans();
			bean = dao.searchByBookId(id);
			request.setAttribute("exhibition", bean);

			gotoPage(request, response, "/Exhibit/UpdateExhibition.jsp");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);

		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	@SuppressWarnings("unlikely-arg-type")
	protected void doCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int book_id = Integer.parseInt(request.getParameter("book_id"));
		String book_name = request.getParameter("book_name");
		String isbn = request.getParameter("isbn");
		int price= Integer.parseInt(request.getParameter("price"));
		String author = request.getParameter("author");
		String quality = request.getParameter("quality");
		String book_class = request.getParameter("class");
		int seller_id;
		String sell_date;

		ExhibitDao dao = new ExhibitDao();
		ExhibitBeans bean = dao.searchByBookId(book_id);

		if("".equals(book_name)) {
			book_name = bean.getBook_name();
		}
		if("".equals(isbn)) {
			isbn = bean.getIsbn();
		}
		if("".equals(price)) {
			price= bean.getPrice();
		}
		if("".equals(author)) {
			author = bean.getAuthor();
		}
		if("".equals(quality)) {
			quality = bean.getQuality();
		}
		if("".equals(book_class)) {
			book_class = bean.getCategory();
		}

		seller_id = bean.getSeller_id();
		sell_date = bean.getSell_date();

		ExhibitBeans updatebean = new ExhibitBeans(book_id, book_name, isbn, price, author, quality, book_class,
				seller_id, sell_date);

		request.setAttribute("exhibition", updatebean);
		HttpSession session = request.getSession(false);
		session.setAttribute("exhibition", updatebean);
		gotoPage(request, response, "/Member/UpdateExhibitionCheck.jsp");

	}

	protected void doComplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		ExhibitBeans bean = (ExhibitBeans) session.getAttribute("exhibition");

		ExhibitDao dao = new ExhibitDao();
		int id = bean.getBook_id();
		bean = dao.update(bean);

		request.setAttribute("book_id", id);
		gotoPage(request, response, "/Exhibit/UpdateExhibitionComplete.jsp");
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
