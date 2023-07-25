package utils;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("KolokvijumBaze2");
	
	public static EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}	
	

}

