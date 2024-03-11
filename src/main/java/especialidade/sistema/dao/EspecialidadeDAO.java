package especialidade.sistema.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import especialidade.sistema.model.Especialidades;

public class EspecialidadeDAO {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Especialidades espec = null;
	
	
	public EspecialidadeDAO() {
		emf = Persistence.createEntityManagerFactory("medico-consultorio");
		em = emf.createEntityManager();
		espec = new Especialidades();
	}
	
	
	public void cadastrarEspecialidade(Especialidades esp) {
		em.getTransaction().begin();
		em.persist(esp);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<Especialidades> listaTodasEspecialidades(){
			String jpql = "select p from especialidade p";
			TypedQuery<Especialidades> especialidades = em.createQuery(jpql, Especialidades.class);
			List<Especialidades> todasEspec = especialidades.getResultList();
			return todasEspec;
	}
	
	public Especialidades especPorSigla(String sigla) {
		espec = em.find(Especialidades.class, sigla);
		em.close();
		return espec;
	}
	
}
