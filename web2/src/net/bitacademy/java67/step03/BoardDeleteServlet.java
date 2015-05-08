package net.bitacademy.java67.step03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/step03/Delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	  
	  BoardVo board = new BoardVo();
	  
	  board.setNo(Integer.parseInt(request.getParameter("no")));
	  board.setTitle(request.getParameter("title"));
	  board.setContent(request.getParameter("content"));
	  
	  
	  
	}

	

}
