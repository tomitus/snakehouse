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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    	JDBCKaarmeTaloDao dao = new JDBCKaarmeTaloDao();

        String itemTitle = req.getParameter("nimi"); // Retrieve the "nimi" parameter

        try {
            ArrayList<KaarmeTalo> ostosLista = (ArrayList<KaarmeTalo>) dao.getAllItems();
            KaarmeTalo itemToRemove = null;

            for (KaarmeTalo item : ostosLista) {
                if (item.getNimi().equals(itemTitle)) {
                    itemToRemove = item;
                    break;
                }
            }

            if (itemToRemove != null) {
                dao.removeSnake(itemToRemove);
                System.out.println("Snake removed: " + itemToRemove.getNimi());
            } else {
                System.out.println("Snake not found with the given name: " + itemTitle);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("poista", itemTitle);
        resp.sendRedirect("/kaarmetalo");
        
    }
}