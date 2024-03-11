package medico.cirurgias.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import medico.cirurgias.model.AgendaCirurgias;

public class AgendaCirurgiaDAO {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public AgendaCirurgiaDAO() {
		emf = Persistence.createEntityManagerFactory("medico-consultorio");
		em = emf.createEntityManager();
	}
	
	
	public void agendarCirurgia(AgendaCirurgias ageCir) {
		em.getTransaction().begin();
		em.persist(ageCir);
		em.getTransaction().commit();
		em.close();
	}
	
}
