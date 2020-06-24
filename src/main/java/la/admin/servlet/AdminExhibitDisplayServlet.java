package la.admin.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ExhibitDisaplayServlet
 */
@WebServlet("/AdminExhibitDisplayServlet")
public class AdminExhibitDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//セッションの確認
			HttpSession session = request.getSession(false);

			//出品DAOの呼び出し
			ExhibitDao dao = new ExhibitDao();

			//セッション管理でログインの有無確認
			if (session != null && session.getAttribute("admin_id") != null) {

				List<ExhibitBeans> list = dao.searchAll();
				request.setAttribute("exhibits", list);

				RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminDisplayExhibition.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminLogin.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);

		}
	}

}
