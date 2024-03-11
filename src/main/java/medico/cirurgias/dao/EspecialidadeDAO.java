package medico.cirurgias.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import medico.cirurgias.model.Especialidades;

public class EspecialidadeDAO {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	
	public EspecialidadeDAO() {
		emf = Persistence.createEntityManagerFactory("medico-consultorio");
		em = emf.createEntityManager();
	}
	
	public void cadastrarEspecialidade(Especialidades espec) {
		em.getTransaction().begin();
		em.persist(espec);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Especialidades> listaTodasEspecialidades(){
		String query = "select p from especialidades p";
		TypedQuery<Especialidades> listaEspec = em.createQuery(query, Especialidades.class);
		return listaEspec.getResultList();
		
	}
	
}
