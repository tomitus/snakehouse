package servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.JDBCKaarmeTaloDao;
import model.KaarmeTalo;



@WebServlet("/lampopiilo")
public class LampoPiilo extends HttpServlet {

	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
		 
		 JDBCKaarmeTaloDao dao = new JDBCKaarmeTaloDao();

			ArrayList<KaarmeTalo> kaarmeet = null;
			try {
				kaarmeet = (ArrayList<KaarmeTalo>) dao.getAllItems();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			req.setAttribute("lista", kaarmeet);
			req.getRequestDispatcher("/WEB-INF/kaarmelista.jsp").forward(req, resp);
	        
	          
	    }
}
