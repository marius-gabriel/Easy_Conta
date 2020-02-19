import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = { "/servlet1" })
public class LoginServlet extends HttpServlet {

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws IOException, ServletException {
	 * response.setContentType("text/html"); PrintWriter out = response.getWriter();
	 * 
	 * String username = request.getParameter("username"); String password =
	 * request.getParameter("passw");
	 * 
	 * if(username.equals("zxc") || password.equals("zxc")) {
	 * out.println("<!DOCTYPE><html><body><h2>RESPONSE!</h2></body></html>");
	 * //out.print("Success"); System.out.print("Success");
	 * 
	 * 
	 * RequestDispatcher rd = request.getRequestDispatcher("/login.html");
	 * rd.include(request, response);
	 * 
	 * } else {
	 * out.println("<!DOCTYPE><html><body><h2>RESPONSE!</h2></body></html>");
	 * out.print("Wrong credentials!"); System.out.print("Wrong");
	 * 
	 * RequestDispatcher rd = request.getRequestDispatcher("/login.html");
	 * rd.include(request, response);
	 * 
	 * } out.close(); }
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("passw");

		if (LoginDao.returnFullname(username, password) != null) {
			
			out.print("Success");
			System.out.println("Successfull login for user - \"" + username + "\"");

			  RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			  rd.include(request, response);
			 
		} else {
			
			out.print("<script type=\"text/javascript\">alert('Wrong credentials!');</script>");
			System.out.println("Wrong credential inserted: username - \"" + username + "\" and password - \"" + password + "\"");
			
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);
			 
		}
		out.close();
	}
}
