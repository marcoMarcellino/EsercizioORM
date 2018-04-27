package it.polito.tdp.esercizioorm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.esercizioorm.model.Studente;

public class StudenteDAO {

	public List<Studente> getTuttiStudenti()
	{

		String sql = "SELECT matricola, nome, cognome, cds FROM studente";

		List<Studente> result = new ArrayList<Studente>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				result.add(new Studente(res.getInt("matricola"), res.getString("nome"), res.getString("cognome"),
						res.getString("cds")));
			}

			conn.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return result;
	}
	public int getTotCreditiStudente(Studente s) {
		
		String sql = "SELECT SUM(c.crediti) FROM corso as c, iscrizione as i WHERE c.codins = i.codins and i.matricola = ? " ;
		int u=0;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,s.getMatricola());
			
			ResultSet res = st.executeQuery();

			res.next();
				
			u+= res.getInt("crediti");

			conn.close();
			return u;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	  
	}

}
