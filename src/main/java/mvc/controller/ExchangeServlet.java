package mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.entity.Exchange;
import mvc.service.ExchangeService;

@WebServlet("/mvc/controller/exchange")
public class ExchangeServlet extends HttpServlet {

	private ExchangeService service = new ExchangeService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/exchange_form.html");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 抓取網頁表單內容
		String form_amount = req.getParameter("amount");
		String form_from = req.getParameter("from");
		String form_to = req.getParameter("to");
		// 資料整理/轉型
		Double amount = Double.parseDouble(form_amount);
		String from = form_from;
		String to = form_to;
		// 呼叫 ExchangeService 取得 Exchange 物件
		Exchange exchange = service.getExchange(amount, from, to);
		// 建立分派器
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/exchange_result.jsp");
		req.setAttribute("exchange", exchange);
		req.setAttribute("exchanges", service.queryAllExchanges());
		rd.forward(req, resp);
	}

}
