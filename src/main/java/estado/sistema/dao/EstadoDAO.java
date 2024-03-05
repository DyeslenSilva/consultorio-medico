package estado.sistema.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import estado.sistema.model.Estado;

public class EstadoDAO {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Estado estado = null;
	
	public EstadoDAO() {
		emf = Persistence.createEntityManagerFactory("medico-consultorio");
		em = emf.createEntityManager();
	}
	
	
	public void cadastroEstado(Estado estado) {
		em.getTransaction().begin();
		em.persist(estado);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Estado> listaTodosEstados(){
		String jpql = "select p  from estado p";
		TypedQuery<Estado> query = em.createQuery(jpql,Estado.class);
		List<Estado> listaEstado = query.getResultList();
		return listaEstado;
	}
	
	
	public List<String> siglaEstado(){
		String jpql = "SELECT e.uf FROM estado e";
		TypedQuery<String> query = em.createQuery(jpql, String.class);
		return query.getResultList();
	
	}
}
