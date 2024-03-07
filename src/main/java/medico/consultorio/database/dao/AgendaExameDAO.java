package medico.consultorio.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import medico.consultorio.model.AgendaExames;

public class AgendaExameDAO {

	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	
	public AgendaExameDAO() {
		emf = Persistence.createEntityManagerFactory("medico-consultorio");
		em = emf.createEntityManager();
	}
	
	public void agendarExame(AgendaExames me) {
		em.getTransaction().begin();
		em.persist(me);
		em.getTransaction().commit();
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<AgendaExames> listaExamePorCPF(String cpf){
		String jpql = "select p from AgendaExames p where p.cpf =: cpf ";
		Query queryJPQL = em.createQuery(jpql);
		queryJPQL.setParameter("cpf", cpf);
		return queryJPQL.getResultList();
	}
	
	public List<AgendaExames> listaExamePorExame(String exame){
		String jpql = "select p from AgendaExames p where p.nomeDoExame =: nomeDoExame";
		TypedQuery<AgendaExames> typedQuery = em.createQuery(jpql, AgendaExames.class);
		typedQuery.setParameter("nomeDoExame", exame);
		List<AgendaExames> examePexame = typedQuery.getResultList();
		return examePexame;
	}
	
	public List<AgendaExames> listaExamePorNomePaciente(String nomePaciente){
		String jpql = "select p from AgendaExames p where p.nomePaciente =: nomePaciente";
		TypedQuery<AgendaExames> query = em.createQuery(jpql, AgendaExames.class);
		query.setParameter("nomePaciente", nomePaciente);
		List<AgendaExames> examePaciente = query.getResultList();
		return examePaciente;
	}
	
	public List<AgendaExames> listaExamesPorMedicoSolicitante(String medicoSolicitante){
		String jpql  = "select p from AgendaExames p where p.medicoSolicitante =: medicoSolicitante ";
		TypedQuery<AgendaExames> query = em.createQuery(jpql, AgendaExames.class);
		query.setParameter("medicoSolicitante",medicoSolicitante);
		List<AgendaExames> exame = query.getResultList();
		return exame;
	}
	
}
