package medico.cirurgias.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import medico.cirurgias.model.Cirurgias;

public class CirurugiaDAO {

		private EntityManagerFactory emf = null;
		private EntityManager em = null;
		
		public CirurugiaDAO() {
			emf = Persistence.createEntityManagerFactory("medico-consultorio");
			em = emf.createEntityManager();
		}
		
		public void cadastrarCirurgia(Cirurgias cirurgias) {
			em.getTransaction().begin();
			em.persist(cirurgias);
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Cirurgias> listaTodasAsCirurgias(){
			String jpql = "select c from cirurgia c";
			TypedQuery<Cirurgias> query = em.createQuery(jpql, Cirurgias.class);
			List<Cirurgias> todasAsCirurgias = query.getResultList();
			return todasAsCirurgias;
		}
}
