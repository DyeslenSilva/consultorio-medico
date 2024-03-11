package medico.cirurgias.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import medico.cirurgias.model.MedicoCirurgiao;

public class MedicoCirurgiaoDAO {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	public MedicoCirurgiaoDAO() {
		emf = Persistence.createEntityManagerFactory("medico-consultorio");
		em = emf.createEntityManager();
	}
	
	public void cadastrarMedicoCirurgia(MedicoCirurgiao mdcCir) {
		em.getTransaction().begin();
		em.persist(mdcCir);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<MedicoCirurgiao> listaMedicosCirurgia(){
		String jpql = "select p from MedicoCirurgiao p";
		TypedQuery<MedicoCirurgiao> medicoCir = em.createQuery(jpql, MedicoCirurgiao.class);
		List<MedicoCirurgiao> listMedCir = medicoCir.getResultList();
		return listMedCir;
	}
	
}
