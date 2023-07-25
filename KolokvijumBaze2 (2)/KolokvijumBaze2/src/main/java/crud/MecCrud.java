package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Igrac;
import model.Mec;
import utils.PersistenceUtil;

public class MecCrud {

	
	//unos novog meca
	public void insertMec(Mec m) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			em.persist(m);
			
			em.flush();
			et.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if(et != null) {
				et.rollback();
			}
		} finally {
			if(em.isOpen() && em != null) {
				em.close();
			}
		}	
	}
	
	public void povezi(Mec m, Igrac i) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
		    m = em.merge(m);
		    i = em.merge(i);
		    
		    m.setIgrac1(i);
		    i.getMecs1().add(m);
		    
		    em.merge(m);
		    em.merge(i);
			
			em.flush();
			et.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if(et != null) {
				et.rollback();
			}
		} finally {
			if(em.isOpen() && em != null) {
				em.close();
			}
		}	
	}
	
	
	
	public List<Mec> igraniMecevi(Igrac i) {
		EntityManager em = PersistenceUtil.getEntityManager();
		String upit = "select m from Mec m where m.igrac1=:x";
		Query q = em.createQuery(upit);
		q.setParameter("x", i);
		List<Mec> mecevi = q.getResultList();
		em.close();
		return mecevi;
	}
}
