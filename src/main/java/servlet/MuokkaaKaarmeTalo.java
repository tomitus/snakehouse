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


@WebServlet("/muokkaa")
public class MuokkaaKaarmeTalo extends HttpServlet {

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JDBCKaarmeTaloDao dao = new JDBCKaarmeTaloDao();

        String itemTitle = req.getParameter("nimi");
        int itemAge = Integer.parseInt(req.getParameter("ika"));
        int itemWeight = Integer.parseInt(req.getParameter("paino"));
        System.out.println(itemTitle);
        System.out.println(itemAge);
        System.out.println(itemWeight);
        
        
            // Perform the necessary update logic here using the received data

            // Set the updated values as request attributes
            req.setAttribute("nimi", itemTitle);
            req.setAttribute("ika", itemAge);
            req.setAttribute("paino", itemWeight);

            // Forward the request to the MuokkaaKaarmeet.jsp file
            req.getRequestDispatcher("/WEB-INF/MuokkaaKaarmeet.jsp").forward(req, resp);
        
    }
	
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

	    // Get the edited item's nimi, ika, and paino from the request parameters
	    String editedNimi = req.getParameter("nimi");
	    int editedIka = Integer.parseInt(req.getParameter("ika"));
	    int editedPaino = Integer.parseInt(req.getParameter("paino"));

	    System.out.println(editedNimi);
        System.out.println(editedIka);
        System.out.println(editedPaino);
	    // Update the item in the database
	    try {
	        KaarmeTalo editedItem = new KaarmeTalo(editedNimi, editedIka, editedPaino);
	        System.out.println(editedItem);
	        dao.updateSnake(editedItem);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

		// lähetetään aika merkkijono JSP-sivulle attribuuttina
		req.setAttribute("lista", kaarmeet);

		resp.setHeader("Refresh", "0;URL=/kaarmetalo");
		// lähetä request edelleen .jsp sivulle
		req.getRequestDispatcher("/WEB-INF/kaarmeet.jsp").forward(req, resp);
	}
}