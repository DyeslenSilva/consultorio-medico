package especialidade.sistema.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import especialidade.sistema.model.Especialidades;

public class EspecialidadeDAO {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public EspecialidadeDAO() {
		emf = Persistence.createEntityManagerFactory("medico-consultorio");
		em = emf.createEntityManager();
	}
	
	
	public void cadastrarEspecialidade(Especialidades esp) {
		em.getTransaction().begin();
		em.persist(esp);
		em.getTransaction().commit();
		em.close();
	}
}
