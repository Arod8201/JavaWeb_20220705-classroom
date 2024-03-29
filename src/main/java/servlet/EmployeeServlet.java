package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/employee")
public class EmployeeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// UTF-8 編碼
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.println("HTTP 方法使用錯誤! 不支援 GET 請求 , 請使用 POST");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// UTF-8 編碼
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");

		// 接收 request 資訊 (瀏覽器傳來的表單資料)
		String empName = req.getParameter("empName");
		String empAge = req.getParameter("empAge");
		String empSex = req.getParameter("empSex");
		String empPos = req.getParameter("empPos");
		String empBirth = req.getParameter("empBirth");
		String[] empLang = req.getParameterValues("empLang");
		String empMemo = req.getParameter("empMemo");
		
		// 建立分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/employee_result.jsp");
		// 準備好要傳給 jsp 的資料
		req.setAttribute("empName", empName);
		req.setAttribute("empAge", empAge);
		req.setAttribute("empSex", empSex);
		req.setAttribute("empPos", empPos);
		req.setAttribute("empBirth", empBirth);
		req.setAttribute("empLang", Arrays.toString(empLang));
		req.setAttribute("empMemo", empMemo);
		// 轉發到目的地 /form/employee_result.jsp
		rd.forward(req, resp);
		
		// 直接回傳 response 給前端
		/*
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>員工資料表單回應</title><link rel=\"stylesheet\" href=\"https://unpkg.com/purecss@2.1.0/build/pure-min.css\"></head>");
		out.println("<body style=\"padding: 15px\">");
		out.println("<form class=\"pure-form\">");
		out.println("<fieldset>");
		out.println("<legend>員工資料表單</legend>");
		out.println("姓名: " + empName + "<p />");
		out.println("年齡: " + empAge + "<p />");
		out.println("性別: " + empSex + "<p />");
		out.println("階級: " + empPos + "<p />");
		out.println("生日: " + empBirth + "<p />");
		out.println("程式: " + Arrays.toString(empLang) + "<p />" );
		out.println("備註: " + empMemo + "<p />");
		out.println("<button type=\"button\" class=\"pure-button pure-button-primary\" onclick=\"history.back()\">返回</button>");
		out.println("</fieldset>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		*/
	}

}
