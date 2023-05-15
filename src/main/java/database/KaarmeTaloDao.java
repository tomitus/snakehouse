package database;

import java.sql.SQLException;
import java.util.List;

import model.KaarmeTalo;

public interface KaarmeTaloDao {

    public List<KaarmeTalo> getAllItems() throws SQLException, ClassNotFoundException;

    public KaarmeTalo getSnake(String nimi) throws SQLException, ClassNotFoundException;

    public boolean addSnake(KaarmeTalo newItem) throws SQLException, ClassNotFoundException;

    public boolean removeSnake(KaarmeTalo item) throws SQLException, ClassNotFoundException;

	void updateSnake(KaarmeTalo updatedItem) throws SQLException, ClassNotFoundException;
    
    
    
}
