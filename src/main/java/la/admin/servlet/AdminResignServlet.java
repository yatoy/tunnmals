package la.admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import la.bean.AdminBeans;
import la.bean.MemberBeans;
import la.dao.AdminDao;
import la.dao.MemberDao;

/**
 * Servlet implementation class AdminResignServlet
 */
@WebServlet("/AdminResignServlet")
public class AdminResignServlet extends HttpServlet {
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

		if ("Admincheck".equals(action)) {
			doAdminCheck(request, response);
			return;
		}

		if ("check".equals(action)) {
			doCheck(request, response);
			return;

		}

		if ("complete".equals(action)) {
			doComplete(request, response);
			return;

		}
	}

	protected void doAdminCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));

			HttpSession session = request.getSession(false);
			MemberDao dao = new MemberDao();
			MemberBeans bean = dao.searchById(id);

			session.setAttribute("member", bean);

			RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminCheck.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doCheck(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");

		// AdminDAOから呼び出し
		AdminDao admindao = new AdminDao();
		AdminBeans bean = new AdminBeans();
		bean = admindao.searchByIdPassword(id, password);

		if (bean != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminDeleteMember.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doComplete(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doComplete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {

			MemberBeans bean = (MemberBeans) session.getAttribute("member");

			// MemberDAOから呼び出し
			MemberDao dao = new MemberDao();
			dao.delete(bean.getId(), bean.getPassword());

			session.removeAttribute("member");

			RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminDeleteMemberComplete.jsp");
			rd.forward(request, response);
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminLogin.jsp");
			rd.forward(request, response);
		}
	}

}
