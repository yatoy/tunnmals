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
import la.dao.AdminDao;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		try {
			HttpSession session = request.getSession(false);
			if (session != null && session.getAttribute("admin_id") != null) {

				RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminMenu.jsp");
				rd.forward(request, response);
				return;
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminLogin.jsp");
				rd.forward(request, response);
				return;
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

		// actionリクエストパラメータの読込
		String action = request.getParameter("action");

		try {
			// ログイン時
			if ("login".equals(action)) {
				int id = Integer.parseInt(request.getParameter("id"));
				String password = request.getParameter("password");

				// MemberDAOから呼び出し
				AdminDao dao = new AdminDao();
				AdminBeans bean = new AdminBeans();
				bean = dao.searchByIdPassword(id, password);

				// ユーザとパスワード一致でログイン処理
				if (bean != null) {

					// セッション管理
					HttpSession session = request.getSession();

					// ログイン済みの属性設定
					session.setAttribute("isLogin", "true");
					session.setAttribute("admin_id", id);

					// マイページへ戻る
					RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminMenu.jsp");
					rd.forward(request, response);
				} else {
					doGet(request, response);
				}
			}
			// ログアウト確認(ページ未実装)
			else if ("logout_check".equals(action)) {
				//ログアウト確認画面へ
				RequestDispatcher rd = request.getRequestDispatcher("/LogoutCheck.html");
				rd.forward(request, response);
			} else if ("logout".equals(action)) {
				HttpSession session = request.getSession(false);
				if (session != null) {
					//セッションの削除
					session.invalidate();

					//トップページに遷移
					RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminLogin.jsp");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminLogin.jsp");
			rd.forward(request, response);
			return;
		}
	}

}
