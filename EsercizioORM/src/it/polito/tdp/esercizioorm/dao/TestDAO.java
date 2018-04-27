
package it.polito.tdp.esercizioorm.dao;

import it.polito.tdp.esercizioorm.model.*;

public class TestDAO {

	public static void main(String[] args) {
		CorsoIdMap corsomap = new CorsoIdMap();
		Studente s =new Studente(146101, viggiano, claudio, cin1t3);
		CorsoDAO cdao = new CorsoDAO();
		/*for (Corso c : cdao.getTuttiCorsi(corsomap))
			System.out.println(c);*/
		
		StudenteDAO sdao = new StudenteDAO();
		/*for (Studente s : sdao.getTuttiStudenti()) 
			System.out.println(s);*/
		
		int c=sdao.getTotCreditiStudente(s);
		System.out.println(c);
	}
}