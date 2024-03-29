package jpa.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jpa/person/query")
public class JPAQueryPersonServlet extends JPABaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		// out.println();
		// out.println("getPerson");
		// out.println(getJPAService().getPerson(1));
		// out.println();
		// out.println("queryAllPerson");
		// out.println(getJPAService().queryAllPerson());
		// out.println();
		// out.println("queryPersonByAge");
		// out.println(getJPAService().queryPersonByAge(30));
		out.println();
		out.println("findByName");
		out.println(getJPAService().findByName("%ch%"));
		out.println();
		out.println("findByAgeBetween");
		out.println(getJPAService().findByAgeBetween(28, 32));
	}

}
