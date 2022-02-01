package it.beije.pascal.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.pascal.model.Contatto;

@Service
public class RubricaDbService {
	public static final String SELECT_ORDERBY = "SELECT * FROM contatti ORDER BY %s %s";

	
	Connection connection;

	public RubricaDbService(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection = null;
	}


	private List<Contatto> extractContattiFromResultSet(ResultSet rs) throws SQLException {
		Contatto contatto;
		List<Contatto> risultati = new ArrayList<>();

		contatto= new Contatto();
		while (rs.next()) {
			contatto= new Contatto();
			contatto.setId(rs.getInt("id"));
			contatto.setCognome(rs.getString("cognome"));
			contatto.setNome( rs.getString("nome"));
			contatto.setTelefono( rs.getString("telefono"));
			contatto.setEmail( rs.getString("email"));
			contatto.setNote( rs.getString("note"));
			risultati.add(contatto);
		}
		System.out.println("RubricaDbService: restituisco "+ risultati.size() + " contatti");
		return risultati;
	}

	public List<Contatto> listAllOrderedBy(String byWhat, boolean asc){
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rubrica?serverTimezone=CET", "root", "Lobbiani");
			Statement statement = connection.createStatement();
			String sql = String.format(SELECT_ORDERBY, byWhat, asc?"ASC":"DESC");

			ResultSet rs = statement.executeQuery(sql);
			//test
			System.out.println("RubricaDbService: executed query: select *");
			return extractContattiFromResultSet(rs);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (!connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("errore nella chiusura della connessione");
				e.printStackTrace();
			}
		}
		return null;
	}



}
