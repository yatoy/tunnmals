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
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);

		try {
			if (session != null && session.getAttribute("id") != null) {
				RequestDispatcher rd = request.getRequestDispatcher("/Member/Mypage.jsp");
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request.getRequestDispatcher("/Member/MemberLogin.jsp");
				rd.forward(request, response);
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

		// actionリクエストパラメータの読込
		String action = request.getParameter("action");

		try {
			// ログイン時
			if ("login".equals(action)) {
				int id = Integer.parseInt(request.getParameter("id"));
				String password = request.getParameter("password");

				// MemberDAOから呼び出し
				MemberDao dao = new MemberDao();
				MemberBeans bean = new MemberBeans();
				bean = dao.searchByIdPassword(id, password);

				// ユーザとパスワード一致でログイン処理
				if (bean != null) {

					// セッション管理
					HttpSession loginsession = request.getSession();

					// セッション管理用の名前設定
					String name = bean.getFamily_name() + " " + bean.getFirst_name();

					// ログイン済みの属性設定
					loginsession.setAttribute("isLogin", "true");
					loginsession.setAttribute("id", id);
					loginsession.setAttribute("name", name);

					// マイページへ戻る
					RequestDispatcher rd = request.getRequestDispatcher("/Member/Mypage.jsp");
					rd.forward(request, response);
				} else {
					doGet(request, response);
				}
			}
			// ログアウト確認
			else if ("logout_check".equals(action)) {
				//ログアウト確認画面へ
				RequestDispatcher rd = request.getRequestDispatcher("/Member/LogoutCheck.html");
				rd.forward(request, response);
			} else if ("logout".equals(action)) {
				HttpSession session = request.getSession(false);
				if (session != null) {
					//セッションの削除
					session.invalidate();

					//トップページに遷移
					RequestDispatcher rd = request.getRequestDispatcher("/toppage.jsp");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);
		}
	}

}
