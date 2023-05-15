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
@WebServlet("/kaarmetalo")
public class KaarmeTaloServlet extends HttpServlet {
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

		// lähetetään aika merkkijono JSP-sivulle attribuuttina
		req.setAttribute("lista", kaarmeet);

		// lähetä request edelleen index.jsp sivulle
		req.getRequestDispatcher("/WEB-INF/kaarmeet.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		JDBCKaarmeTaloDao dao = new JDBCKaarmeTaloDao();

		String itemTitle = req.getParameter("nimi");
		int itemAge = Integer.parseInt(req.getParameter("ika"));
		int itemWeight = Integer.parseInt(req.getParameter("paino"));
		try {
			KaarmeTalo item = new KaarmeTalo(itemTitle, itemAge, itemWeight);
			dao.addSnake(item);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		req.setAttribute("uusi", itemTitle);
		resp.sendRedirect("/kaarmetalo");
		
		

	}
}