package medico.consultorio.database.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import medico.consultorio.model.Paciente;

public class PacienteDAO {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	
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
	
	
}
