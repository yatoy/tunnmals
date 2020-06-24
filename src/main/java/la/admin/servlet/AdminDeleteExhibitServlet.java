package la.admin.servlet;

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
 * Servlet implementation class AdminResignServlet
 */
@WebServlet("/AdminDeleteExhibitServlet")
public class AdminDeleteExhibitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// actionリクエストパラメータの読込
		String action = request.getParameter("action");

		if ("check".equals(action)) {
			doCheck(request, response);
			return;

		}

		if ("complete".equals(action)) {
			doComplete(request, response);
			return;

		}
	}

	protected void doCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("admin_id") != null) {

			ExhibitDao dao = new ExhibitDao();
			ExhibitBeans bean = dao.searchByBookId(id);

			if (bean != null) {
				session.setAttribute("exhibit", bean);
				RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminDeleteExhibit.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", "その商品はありません");
				RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
				rd.forward(request, response);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminLogin.jsp");
			rd.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doComplete(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doComplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("admin_id") != null) {

			ExhibitBeans bean = (ExhibitBeans) session.getAttribute("exhibit");

			// MemberDAOから呼び出し
			ExhibitDao dao = new ExhibitDao();
			dao.delete(bean.getBook_id());

			session.removeAttribute("exhibit");

			RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminDeleteExhibitComplete.jsp");
			rd.forward(request, response);
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminLogin.jsp");
			rd.forward(request, response);
		}
	}

}
