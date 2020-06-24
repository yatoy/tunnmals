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
 * Servlet implementation class MemberDisplayServlet
 */
@WebServlet("/MemberDisplayServlet")
public class MemberDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberDisplayServlet() {
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
			int id = (int) session.getAttribute("id");

			MemberDao dao = new MemberDao();
			MemberBeans bean = new MemberBeans();

			bean = dao.searchById(id);
			request.setAttribute("member", bean);

			RequestDispatcher rd = request.getRequestDispatcher("/Member/MemberDisplayInfo.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);

		}
	}
}
