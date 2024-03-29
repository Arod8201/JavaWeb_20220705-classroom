package jpa.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jpa.entity.Employee;
import jpa.util.DESEncryptService;

@WebServlet("/jpa/employee/add")
public class JPAAddEmployeeServlet extends JPABaseServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = "Bob";
		String password = "2222";
		String salary = "60000";

		try {
			// 將 password 進行 MD5 加密
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] result = md5.digest(password.getBytes()); // input 資料加密
			String md5_Password = String.format("%032X", new BigInteger(result));

			// 將 salary 進行 DES 加密
			String key_path = "C:/Users/MB-207/eclipse-workspace/JavaWeb_20220705/key/user.key";
			DESEncryptService des = new DESEncryptService(key_path);
			byte[] des_salary = des.encrytor(salary); // salary 加密

			// 建立 Employee 物件 , 並將加密資料注入
			Employee employee = new Employee();
			employee.setName(name);
			employee.setPassword(md5_Password);
			employee.setSalary(des_salary);

			// 儲存資料
			getJPAService().addEmployee(employee);

			resp.getWriter().print("Add ok : " + employee);
		} catch (Exception e) {
			resp.getWriter().print("Add error : " + e);
		}

	}

}
