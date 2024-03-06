package medico.consultorio.database.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import medico.consultorio.model.MarcaExame;

public class AgendaExameDAO {

	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	
	public AgendaExameDAO() {
		emf = Persistence.createEntityManagerFactory("medico-consultorio");
		em = emf.createEntityManager();
	}
	
	public void agendarExame(MarcaExame me) {
		em.getTransaction().begin();
		em.persist(me);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
}
