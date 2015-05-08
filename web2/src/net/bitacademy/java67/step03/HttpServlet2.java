package net.bitacademy.java67.step03;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServlet2 extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void service(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    if ( req.getMethod().equals("GET")) {
      myGet(req, res);
    }
    else {
      myPost(req,res);
    }
  
  }
public void myGet(HttpServletRequest req , HttpServletResponse res){
  
}
public void myPost(HttpServletRequest req , HttpServletResponse res){
  
}
}
