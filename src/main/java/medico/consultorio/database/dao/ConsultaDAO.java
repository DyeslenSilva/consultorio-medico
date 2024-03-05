package medico.consultorio.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import medico.consultorio.model.ConsultaMedica;

public class ConsultaDAO {

	private EntityManagerFactory emf= null;
	private EntityManager em = null;
	private ConsultaDAO consDAO = null;
	
	
	public ConsultaDAO() {
		emf = Persistence.createEntityManagerFactory("medico-consultorio");
		em = emf.createEntityManager();
	}
	
	public void cadastroDeConsulta(ConsultaMedica consultaMedica) {
		em.getTransaction().begin();
		em.persist(consultaMedica);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public List<ConsultaMedica> listaTodasAsConsultas(){
		String jpql = "select p from consulta p";
		TypedQuery<ConsultaMedica> consultaQuery = em.createQuery(jpql, ConsultaMedica.class);
		List<ConsultaMedica> listaConsulta = consultaQuery.getResultList();
		em.close();
		return listaConsulta;
	}
	
	public List<ConsultaMedica> listaConsultaPorMedico(String medico){
		String jpql = "select p from consulta p where p.nomeMedico =: nomeMedico";
		TypedQuery<ConsultaMedica> consQuery = em.createQuery(jpql, ConsultaMedica.class);
		consQuery.setParameter("nomeMedico", medico);
		List<ConsultaMedica> listaConsultas = consQuery.getResultList();
		return listaConsultas;
	}
	
	public List<ConsultaMedica> listaConsultaPorEspecialidade(String especialidade){
		String jpql = "select p from consulta p where p.especialidade =: especialidade";
		TypedQuery<ConsultaMedica> especQuery = em.createQuery(jpql, ConsultaMedica.class);
		especQuery.setParameter("especialidade", especialidade);
		List<ConsultaMedica> listaConsEspec= especQuery.getResultList();
		return listaConsEspec;
	}
	
	
	
	
}
