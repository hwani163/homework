package net.bitacademy.java67.step03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/step03/Update")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  BoardVo board = new BoardVo();
	  BoardDao boardDao = new BoardDao();
	  boardDao.setDBConnectionPool(new DBConnectionPool());	  
	  boardDao.update(board);
	  
	  response.sendRedirect("List");
	  
	  
	  
	  
	}
	  
	}
 


	
	


