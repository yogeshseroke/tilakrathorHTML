

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class stuSer
 */
@WebServlet("/stuSer")
public class stuSer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public stuSer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		try {
		Class.forName("com.mysql.jdbc.driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb,root,root");
		Statement st = con.createStatement();
		int x = st.executeUpdate("insert into stu(id, name) values('"+request.getParameter("txt1")+"','"+request.getParameter("txt2")+"')");

		if(x != 0) {
			response.sendRedirect("student.jsp?q=insert successfully");
		}else {
			response.sendRedirect("student.jsp?q=fail to insert");
		}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
