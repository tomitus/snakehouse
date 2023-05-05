package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.KaarmeTalo;

/**
 * TODO: Complete the implementation of this DAO-class by implementing database
 * operations for each of the CRUD methods.
 */
public class JDBCKaarmeTaloDao implements KaarmeTaloDao {

	// METODIN MÄÄRITYS
	@Override
	public List<KaarmeTalo> getAllItems() throws SQLException, ClassNotFoundException {
		// CONNECTION STRINGIN MÄÄRITYS
		final String URL = "jdbc:sqlite:.\\snakedb.sqlite";
		// AVATAAN TIETOKANTAYHTEYS
		Class.forName("org.sqlite.JDBC");
		Connection yhteys = DriverManager.getConnection(URL);
		// LUODAAN SQL KYSELY, JOKA HAKEE KAIKKI TUOTTEET TIETOKANNASTA
		PreparedStatement lista = yhteys.prepareStatement("SELECT * FROM Kaarme");
		// SUORITETAAN SQL KYSELY, JOKA EI OLE TIETOKANTAA PÄIVITTÄVÄ
		// ELI EXECUTEQUERY, JOKA PALAUTTAA TIETOKANNASTA TULOSRIVIT
		ResultSet tulokset = lista.executeQuery();
		// LUODAAN LISTA, JOHON LAITETAAN KYSELYN TULOKSET
		ArrayList<KaarmeTalo> kaarmeet = new ArrayList<KaarmeTalo>();
		// LOOPATAAN LÄPI TULOKSET

		while (tulokset.next()) {
			String nimi = tulokset.getString("nimi");
			int ika = tulokset.getInt("ika");
			int paino = tulokset.getInt("paino");
			// TUOTE VOIDAAN LUODA PARAMETRILLISELLÄ KONSTRUKTORILLA
			KaarmeTalo kaarme = new KaarmeTalo(nimi, ika, paino);
			// LISÄTÄÄN LISTAAN YSKITELLEN TUOTTEITA
			kaarmeet.add(kaarme);
		}

		
		tulokset.close();
		lista.close();
		yhteys.close();

		if (kaarmeet.isEmpty()) {
			return new ArrayList<>();
		} else {
			return kaarmeet;
		}

	}

	@Override
    public KaarmeTalo getSnake(String nimi) throws SQLException, ClassNotFoundException {
    	final String URL = "jdbc:sqlite:.\\snakedb.sqlite";    	
    	Class.forName("org.sqlite.JDBC");
		Connection yhteys = DriverManager.getConnection(URL);
		
		PreparedStatement yksiTuote = yhteys.prepareStatement("SELECT * FROM Kaarme WHERE nimi LIKE ?");
		yksiTuote.setString(1, nimi);
		ResultSet tulokset = yksiTuote.executeQuery();
		
		nimi = tulokset.getString("nimi");
		int ika = tulokset.getInt("ika");
		int paino = tulokset.getInt("paino");
		KaarmeTalo kaarme = new KaarmeTalo(nimi, ika, paino);
		
		tulokset.close();
		yksiTuote.close();
		yhteys.close();
    	return kaarme;
    	
    }

	@Override
	public boolean addSnake(KaarmeTalo newItem) throws SQLException, ClassNotFoundException {
		final String URL = "jdbc:sqlite:.\\snakedb.sqlite";
		Class.forName("org.sqlite.JDBC");
		Connection yhteys = DriverManager.getConnection(URL);
		
		
		String nimi = newItem.getNimi();
		int ika = newItem.getIka();
		int paino = newItem.getPaino();
		
		PreparedStatement lisaa = yhteys.prepareStatement("INSERT INTO Kaarme (nimi, ika, paino) VALUES (?, ?, ?)");
		
			lisaa.setString(1, nimi);
			lisaa.setInt(2, ika);
			lisaa.setInt(3, paino);
			lisaa.executeUpdate();
		
			 

		lisaa.close();
		yhteys.close();
		return true;
	}

	@Override
	public boolean removeSnake(KaarmeTalo item) throws SQLException, ClassNotFoundException {
		final String URL = "jdbc:sqlite:.\\snakedb.sqlite";
		Class.forName("org.sqlite.JDBC");
		Connection yhteys = DriverManager.getConnection(URL);
		
		String nimi = item.getNimi();
		
		PreparedStatement poista = yhteys.prepareStatement("DELETE FROM Kaarme WHERE nimi LIKE ?;");
		
		poista.setString(1, nimi);
		int rivit = poista.executeUpdate();

		poista.close();
		yhteys.close();
		return true;
	}

}