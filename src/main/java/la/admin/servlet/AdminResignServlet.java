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
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminResignServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//		PrintWriter out = response.getWriter();

		try {
			MemberBeans bean = (MemberBeans) request.getAttribute("bean");
			int memberid = bean.getId();
			String memberpassword = bean.getPassword();

			HttpSession session = request.getSession(false);

			session.setAttribute("member_id", memberid);
			session.setAttribute("member_password", memberpassword);

			RequestDispatcher rd = request.getRequestDispatcher("/Member/AdminLogin.jsp");
			rd.forward(request, response);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// actionリクエストパラメータの読込
		String action = request.getParameter("action");

		if("check".equals(action)) {
			doCheck(request, response);
		}if("complete".equals(action)) {
			doComplete(request, response);
		}
	}

	/**
	 * @see HttpServlet#doCheck(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");

		// AdminDAOから呼び出し
		AdminDao admindao = new AdminDao();
		AdminBeans bean = new AdminBeans();
		bean = admindao.searchByIdPassword(id, password);

		if(bean!=null) {
			RequestDispatcher rd = request.getRequestDispatcher("/AdminDeleteMember.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doComplete(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doComplete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("member_id");
		String password = (String) session.getAttribute("member_password");

		// MemberDAOから呼び出し
		MemberDao dao = new MemberDao();
		dao.delete(id, password);

		session.removeAttribute("member_id");
		session.removeAttribute("member_password");

		RequestDispatcher rd = request.getRequestDispatcher("/Member/AdminDeleteMemberComplete.jsp");
		rd.forward(request, response);
	}

}
