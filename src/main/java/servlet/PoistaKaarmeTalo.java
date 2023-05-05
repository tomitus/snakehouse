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


@WebServlet("/poista")
public class PoistaKaarmeTalo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    	JDBCKaarmeTaloDao dao = new JDBCKaarmeTaloDao();
    	
    	String itemTitle = req.getParameter("poista");
    	
    	ArrayList<KaarmeTalo> ostosLista = null;
		try {
			ostosLista = (ArrayList<KaarmeTalo>) dao.getAllItems();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	
    	int Size = ostosLista.size() - 1;
		try {
			KaarmeTalo item = dao.getAllItems().get(Size);
			dao.removeSnake(item);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
       
		req.setAttribute("poista", itemTitle);
		resp.sendRedirect("/kaarmetalo");
        
    }
}
