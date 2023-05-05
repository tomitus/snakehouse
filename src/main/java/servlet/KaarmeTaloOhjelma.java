package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


import database.JDBCKaarmeTaloDao;
import model.KaarmeTalo;


public class KaarmeTaloOhjelma {
		 
	 
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		JDBCKaarmeTaloDao dao = new JDBCKaarmeTaloDao();

		Scanner input = new Scanner(System.in);

		System.out.println("Tervetuloa Käärmetaloon!");
		System.out.println("Suoritettavat komennot: ");
		System.out.println(" käärmeet");
		System.out.println(" käärme");
		System.out.println(" uusi (käärmeen tiedot)");
		System.out.println(" poista (käärmeen nimi)");

		System.out.print("\n\n> ");
		String command = input.next();
		
		

		if (command.equals("käärmeet")) {
			System.out.println("Ostoslistan sisältö: ");
			for (KaarmeTalo item : dao.getAllItems()) {
				System.out.println(item.getNimi() + " " + item.getIka() + " " + item.getPaino());
			}
		}
		
		
		else if (command.equals("käärme")) {
			String nimi = input.next();
			
			KaarmeTalo item = dao.getSnake(nimi);
			System.out.println(item.getNimi() + " " + item.getIka() + " " + item.getPaino());
		}
		else if (command.equals("uusi")) {	
			String nimi = input.next();
			int ika = input.nextInt();
			int paino = input.nextInt();
			KaarmeTalo item = new KaarmeTalo();
			item.setNimi(nimi);
			item.setIka(ika);
			item.setpaino(paino);
			dao.addSnake(item);
		}
		else if (command.equals("poista")) {
			String nimi = input.next();
			
			KaarmeTalo item = new KaarmeTalo();
			item.setNimi(nimi);
			dao.removeSnake(item);
		}
	}
	}
