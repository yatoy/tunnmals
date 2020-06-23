package la.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberRegisterServlet")
public class MemberRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String type = request.getParameter("action");

		if ("check".contentEquals(type)) {
			doCheck(request, response);
		}
		if ("complete".contentEquals(type)) {
			doComplete(request);
		}

		doGet(request, response);
	}

	protected void doCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String family_name = request.getParameter("family_name");
		String first_name = request.getParameter("first_name");
		String postal = request.getParameter("postal");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		if (family_name == null || "".equals(family_name)) {
			doGet(request, response);
			return;
		}

		if (first_name == null || "".equals(first_name)) {
			doGet(request, response);
			return;
		}

		if (postal == null || "".equals(postal)) {
			doGet(request, response);
			return;
		}

		if (address == null || "".equals(address)) {
			doGet(request, response);
			return;
		}

		if (tel == null || "".equals(tel)) {
			doGet(request, response);
			return;
		}

		if (email == null || "".equals(email)) {
			email = "未登録";
		}

		if (password1 == null || "".equals(password1)) {
			doGet(request, response);
			return;
		}

		if (password2 == null || "".equals(password2)) {
			doGet(request, response);
			return;
		}

		if (password1.equals(password2)) {

		}

	}

	protected void doComplete(HttpServletRequest request) throws ServletException, IOException {
		//memberテーブルに追加
	}

}
