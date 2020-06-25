package la.purchase.servlet;

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
 * Servlet implementation class PurchaseHistoryServlet
 */
@WebServlet("/PurchaseHistoryServlet")
public class PurchaseHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseHistoryServlet() {
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
			//セッションの確認
			HttpSession session = request.getSession(false);

			//出品DAOの呼び出し
			ExhibitDao dao = new ExhibitDao();

			//セッション管理でログインの有無確認
			if (session != null && session.getAttribute("id") != null) {

				//セッションから出品者IDの呼び出し
				int buyerid = (Integer) session.getAttribute("id");

				//自分が出品した本の設定
				List<ExhibitBeans> mylist = dao.searchByBuyerId(buyerid);
				request.setAttribute("purchase_history", mylist);
			}

			//出品表示
			RequestDispatcher rd = request.getRequestDispatcher("/Purchase/PurchaseHistory.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);

		}
	}
}
