package la.member.servlet;

import java.io.IOException;

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
 * Servlet implementation class MemberResignServlet
 */
@WebServlet("/MemberResignServlet")
public class MemberResignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberResignServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		String password = request.getParameter("password");

		HttpSession logoutsession = request.getSession(false);
		int id = (int) logoutsession.getAttribute("id");

		// MemberDAOから呼び出し
		MemberDao dao = new MemberDao();
		MemberBeans bean = new MemberBeans();
		bean = dao.searchByIdPassword(id, password);

		if(bean!=null) {
			logoutsession.setAttribute("password", password);

			RequestDispatcher rd = request.getRequestDispatcher("/Member/DeleteMemberCheck.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doComplete(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doComplete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		int id = (int) session.getAttribute("id");
		String password = (String) session.getAttribute("password");

		// MemberDAOから呼び出し
		MemberDao dao = new MemberDao();
		dao.delete(id, password);

		RequestDispatcher rd = request.getRequestDispatcher("/Member/DeleteMemberComplete.jsp");
		rd.forward(request, response);
	}

}
