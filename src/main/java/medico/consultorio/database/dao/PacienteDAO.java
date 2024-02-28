package medico.consultorio.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import medico.consultorio.model.Paciente;

public class PacienteDAO {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	private Paciente paciente = null;
	
	public PacienteDAO() {
		emf = Persistence.createEntityManagerFactory("medico-consultorio");
		em = emf.createEntityManager();
	}
	
	public void salvarPaciente(Paciente paciente) {
		em.getTransaction().begin();
		
		em.persist(paciente);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public Paciente consultaClientePorCPF(String cpf) {
		paciente = em.find(Paciente.class, cpf);
		em.close();
		return paciente;
	}
	
	public List<Paciente> listarTodosOsPacientes(){
		String jpql = "select p from paciente p";
		TypedQuery<Paciente> pacienteQuery = em.createQuery(jpql, Paciente.class);
		List<Paciente> pacientes = pacienteQuery.getResultList();
		em.close();
		return pacientes;
	}
	
	
}
