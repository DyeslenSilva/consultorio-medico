package medico.consultorio.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import medico.consultorio.model.Medico;


public class MedicoDAO {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Medico medico = null;
	
	public MedicoDAO() {
		emf= Persistence.createEntityManagerFactory("medico-consultorio");
		em = emf.createEntityManager();
	}
	
	public void cadastroMedico(Medico medico) {
		em.getTransaction().begin();
		em.persist(medico);
		em.getTransaction().commit();
		em.close();
	}
	
		public List<Medico> listarTodosOsMedicos(){
			String jpql = "select p from medico p";
			TypedQuery<Medico> queryLista = em.createQuery(jpql, Medico.class);
			List<Medico> todosOsMedicos = queryLista.getResultList();
			return todosOsMedicos;
		}
		
		public Medico buscaMedicoPorCRM(String crm) {
			medico = em.find(Medico.class, crm);
			em.close();
			return medico;
		}
		
		public List<Medico> buscaMedicoPorEstado(String estado){
			String jpql = "select p from medico  p where p.estado =:estado";
			TypedQuery<Medico> queryList = em.createQuery(jpql, Medico.class);
			List<Medico> medicoPorEstado = queryList.getResultList();
			return medicoPorEstado;
		}
		
}
