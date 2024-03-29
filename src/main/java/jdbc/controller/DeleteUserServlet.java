package jdbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.service.UserService;

@WebServlet("/user/delete")
public class DeleteUserServlet extends HttpServlet {

	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.valueOf(req.getParameter("id"));
		int rowcount = userService.delete(id);

		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user/success.jsp");
		req.setAttribute("action", "delete");
		req.setAttribute("rowcount", rowcount);
		rd.forward(req, resp);
	}

}
