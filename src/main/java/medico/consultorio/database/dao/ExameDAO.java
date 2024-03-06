package medico.consultorio.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import medico.consultorio.model.Exame;
import medico.consultorio.model.Medico;

public class ExameDAO {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public ExameDAO() {
		emf = Persistence.createEntityManagerFactory("medico-consultorio");
		em = emf.createEntityManager();
	}
	
	
	public void cadastrarExame(Exame exame) {
		em.getTransaction().begin();
		em.persist(exame);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Exame> listarTodosExames(){
		String jpql = "select p from exame p";
		TypedQuery<Exame> queryExames = em.createQuery(jpql , Exame.class);
		List<Exame> listaExames = queryExames.getResultList();
		return listaExames;
	}
	
	public String descricaoPorNome(String nomeExame) {
		String jpql = "select p.descricao from exame p where p.nomeDoExame = :nomeDoExame";
		TypedQuery<String> query = em.createQuery(jpql, String.class);
		query.setParameter("nomeDoExame", nomeExame);
		return query.getSingleResult();
	}
	
}
