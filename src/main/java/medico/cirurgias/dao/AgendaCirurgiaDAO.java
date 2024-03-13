package medico.cirurgias.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import medico.cirurgias.model.AgendaCirurgias;
import medico.cirurgias.model.Cirurgias;

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
	
	
	public List<AgendaCirurgias> listaTodasCirurgias(){
		TypedQuery<AgendaCirurgias> query = em.createQuery("select p from  agendacirurgia p" , AgendaCirurgias.class);
		return query.getResultList();
	}
	
	
	
	
}
