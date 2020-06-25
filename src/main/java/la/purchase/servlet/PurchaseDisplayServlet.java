package la.purchase.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.ExhibitBeans;
import la.dao.ExhibitDao;

/**
 * Servlet implementation class PurchaseDisplayServlet
 */
@WebServlet("/PurchaseDisplayServlet")
public class PurchaseDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseDisplayServlet() {
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
			//出品DAOの呼び出し
			ExhibitDao dao = new ExhibitDao();

			List<ExhibitBeans> list = dao.seachAllBuy();
			request.setAttribute("purchase_all", list);

			//出品表示
			RequestDispatcher rd = request.getRequestDispatcher("/Admin/AdminDisplayPurchase.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			RequestDispatcher rd = request.getRequestDispatcher("/errInternal.jsp");
			rd.forward(request, response);

		}
	}

}
