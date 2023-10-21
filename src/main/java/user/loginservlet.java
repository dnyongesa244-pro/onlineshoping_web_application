package user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class loginservlet
 */
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("txtname");
		String pass = request.getParameter("txtpassword");
		HttpSession sesion = request.getSession();
		RequestDispatcher dispatcher = null;
		
		
		try {
			//Class.forName("con.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eshoping","root","");
			PreparedStatement pst = con.prepareStatement("select * from  customerdatails where Email = ? and Password = ?");
			pst.setString(1, username);
			pst.setString(2, pass);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
			  sesion.setAttribute("name",rs.getString("uname"));
			  dispatcher = request.getRequestDispatcher("homepage.jsp");
			} else {
				request.setAttribute("status", "Login failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
		} catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
