package jpa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import jpa.entity.Person;
import jpa.service.JPAService;

/*
 * GET    /webapi/person/2 單筆查詢
 * GET    /webapi/person/  多筆查詢
 * POST   /webapi/person/  新增
 * PUT    /webapi/person/2 修改
 * DELETE /webapi/person/2 刪除
 * */

@WebServlet("/webapi/person/*")
public class PersonWebApi extends HttpServlet {

	private Gson gson = new Gson();
	private JPAService jpaService = new JPAService();

	private Integer getId(HttpServletRequest req) {
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo.replace("/", "");
		return pathInfo.matches("/[0-9]+") ? Integer.parseInt(pathInfo) : null;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = getId(req);
		if (id == null) { // 全部查詢
			List<Person> persons = jpaService.queryAllPerson();
			resp.getWriter().print(gson.toJson(persons));
			return;
		}
		Person person = jpaService.getPerson(id);
		resp.getWriter().print(gson.toJson(person));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jsonString = IOUtils.toString(req.getInputStream(), "utf-8");
		// 將 jsonString 轉 Person 物件
		Person person = gson.fromJson(jsonString, Person.class);
		jpaService.addPerson(person);
		resp.getWriter().print(gson.toJson(person));
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = getId(req);
		if (id == null) {
			resp.getWriter().print("null");
			return;
		}
		String jsonString = IOUtils.toString(req.getInputStream(), "utf-8");
		// 將 jsonString 轉 Person 物件
		Person person = gson.fromJson(jsonString, Person.class);
		person.setId(id); // 將 id 注入到 person 物件中
		jpaService.updatePerson(person);
		resp.getWriter().print(gson.toJson(person));
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = getId(req);
		if (id == null) {
			resp.getWriter().print("No id");
			return;
		}
		Person person = jpaService.getPerson(id);
		if (person == null) {
			resp.getWriter().print("None");
			return;
		}
		jpaService.deletePerson(id);
		resp.getWriter().print(id);
	}

}
