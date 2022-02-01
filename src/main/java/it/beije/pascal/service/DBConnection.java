package it.beije.pascal.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.beije.pascal.model.Contatto;

@Service
public class DBConnection {
	
	public List<Contatto> getListJDBC() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		List<Contatto> rubrica = new ArrayList<>();
		Contatto c = new Contatto();
		
		
		
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rubrica?serverTimezone=CET", "root", "ardente");

			System.out.println(!connection.isClosed());
			
			statement = connection.createStatement();
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contatti");
			
			rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				
				c.setId(rs.getInt("id"));
				c.setCognome(rs.getString("cognome"));
				c.setNome(rs.getString("nome"));
				c.setTelefono(rs.getString("telefono"));
				c.setEmail(rs.getString("email"));
				c.setNote(rs.getString("note"));
				
				rubrica.add(c);
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				//rs.close();
				statement.close();
				connection.close();
			} catch (Exception fEx) {
				fEx.printStackTrace();
			}
		}
		
		return rubrica;
	}
	
}
