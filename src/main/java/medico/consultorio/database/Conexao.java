package medico.consultorio.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Conexao {
				
	
	EntityManagerFactory emf = null;
	 EntityManager em =null;

	
	public void conexao() {
		try {
			System.out.println("Antes de Criar o Entity Manager");
			emf = Persistence.createEntityManagerFactory("medico-consultorio");
			System.out.println("Ao criar o Entity Manager");
			em = emf.createEntityManager();
			System.out.println("Depois de criar o EntityManager");
			if(em!=null) {
				System.out.println("Conexao!");
			}else {
				System.out.println("Nao !! Tente Novamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em!=null && em.isOpen()) {
				em.close();
			}
			if(emf!=null && emf.isOpen()) {
				emf.close();
			}
		
		}
	}
}
