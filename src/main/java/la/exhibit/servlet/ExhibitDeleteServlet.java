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

@WebServlet("/ExhibitDeleteServlet")
public class ExhibitDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		try {
			RequestDispatcher rd = request.getRequestDispatcher("/Member/DeleteMember.jsp");
			rd.forward(request, response);
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

		// actionリクエストパラメータの読込
		String action = request.getParameter("action");

		if ("check".equals(action)) {
			doCheck(request, response);
		}
		if ("complete".equals(action)) {
			doComplete(request, response);
		}
	}

	protected void doCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("id") != null) {
			int book_id = Integer.parseInt(request.getParameter("book_id"));

			// ExhibitDAOから呼び出し
			ExhibitDao dao = new ExhibitDao();
			ExhibitBeans bean = new ExhibitBeans();
			bean = dao.searchByBookId(book_id);

			if (bean != null) {
				session.setAttribute("exhibit", bean);

				RequestDispatcher rd = request.getRequestDispatcher("/Exhibit/DeleteExhibitionCheck.jsp");
				rd.forward(request, response);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/Member/MemberLogin.jsp");
			rd.forward(request, response);
		}

	}

	protected void doComplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null && session.getAttribute("id") != null) {

			ExhibitBeans bean = (ExhibitBeans) session.getAttribute("exhibit");
			ExhibitDao dao = new ExhibitDao();
			dao.delete(bean.getBook_id());

			RequestDispatcher rd = request.getRequestDispatcher("/Exhibit/DeleteExhibitionComplete.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/Member/MemberLogin.jsp");
			rd.forward(request, response);
		}

	}
}
