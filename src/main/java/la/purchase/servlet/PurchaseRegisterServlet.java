package la.purchase.servlet;

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
import la.bean.MemberBeans;
import la.dao.ExhibitDao;
import la.dao.MemberDao;

/**
 * Servlet implementation class PurchaseRegisterServlet
 */
@WebServlet("/PurchaseRegisterServlet")
public class PurchaseRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseRegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {

			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("id") != null) {
				int book_id = Integer.parseInt(request.getParameter("book_id"));
				int buyer_id = (Integer) session.getAttribute("id");
				session.setAttribute("book_id", book_id);

				MemberDao memberdao = new MemberDao();
				MemberBeans memberbean = memberdao.searchById(buyer_id);

				ExhibitDao exhibitdao = new ExhibitDao();
				ExhibitBeans exhibitbean = exhibitdao.searchByBookId(book_id);

				session.setAttribute("purchase_buyer", memberbean);
				session.setAttribute("purchase_book", exhibitbean);

				gotoPage(request, response, "/Purchase/Purchase.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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

		String payment_method = request.getParameter("payment_method");
		if (payment_method.equals(null) || "".equals(payment_method)) {
			doGet(request, response);
			return;
		}
		HttpSession session = request.getSession(false);

		MemberBeans memberbean = (MemberBeans) session.getAttribute("purchase_buyer");
		ExhibitBeans exhibitbean = (ExhibitBeans) session.getAttribute("purchase_book");

		int book_id = exhibitbean.getBook_id();
		String book_name = exhibitbean.getBook_name();
		String isbn = exhibitbean.getIsbn();
		int price = exhibitbean.getPrice();
		String author = exhibitbean.getAuthor();
		String quality = exhibitbean.getQuality();
		String book_class = exhibitbean.getCategory();
		int seller_id = exhibitbean.getSeller_id();
		String sell_date = exhibitbean.getSell_date();

		int buyer_id = (int) session.getAttribute("id");

		Calendar cal = Calendar.getInstance(); //[1]
		String buy_date = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-"
				+ cal.get(Calendar.DATE);

		ExhibitBeans buybean = new ExhibitBeans(book_id, book_name, isbn, price, author, quality, book_class,
				seller_id, sell_date, buyer_id, buy_date, payment_method);

		session.setAttribute("purchase", buybean);
		gotoPage(request, response, "/Purchase/PurchaseCheck.jsp");

	}

	protected void doComplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		ExhibitBeans bean = (ExhibitBeans) session.getAttribute("purchase");

		ExhibitDao dao = new ExhibitDao();
		int id = bean.getBook_id();
		bean = dao.buy(bean);

		session.removeAttribute("book_id");
		request.setAttribute("book_id", id);
		gotoPage(request, response, "/Purchase/PurchaseComplete.jsp");
	}

	private void gotoPage(HttpServletRequest request, HttpServletResponse response, String page)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
