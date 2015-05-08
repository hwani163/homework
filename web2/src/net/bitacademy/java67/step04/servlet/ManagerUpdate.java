package net.bitacademy.java67.step04.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.bitacademy.java67.step04.DBConnectionPool;
import net.bitacademy.java67.step04.dao.ManagerDao;
import net.bitacademy.java67.step04.vo.ManagerVo;

@WebServlet("/step04/ManagerUpdate")
public class ManagerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  ManagerDao managerDao = new ManagerDao();
	  managerDao.setDBConnectionPool(new DBConnectionPool());
	  List<ManagerVo> list = new ArrayList<ManagerVo>();	  
	  ManagerVo manager = new ManagerVo();
	  managerDao.update(manager);
	  
	  PrintWriter out = response.getWriter();
	  
	  out.println("<!DOCTYPE html>");
	  out.println("<html>");
	  out.println("<head>");
	  out.println("<meta charset=\"UTF-8\">");
	  out.println("<title>Insert title here</title>");
	  out.println("</head>");
	  out.println("<body>");
	  out.println("<form>");

	  out.println("번호 : <input type=\"text\"  name=\"no\">");
	  out.println("이름 : <input type=\"password\" name =\"name\" >");
	  out.println("비밀번호 : <input type=\"password\" name =\"password\" >");
	  out.println("이메일 : <input type=\"text\" name=\"email\">");
	  out.println("전화번호 : <input type=\"text\" name =\"tel\">");
	    
	  out.println("<button type=\"button\"onclick=\"location.href='Update'\">변경</button>");
	  out.println("<button type=\"reset\" >취소</button>");
	  out.println("<button type=\"button\">목록</button>");
	    

	  out.println("</form>");
	  out.println("</body>");
	  out.println("</html>");
	 
	  
	  
	  
	  
	}
}
