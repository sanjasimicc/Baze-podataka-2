package crud;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import model.Igrac;
import model.Mec;
import utils.PersistenceUtil;

public class IgracCrud {
	
	//unos novog igraca
	public void insertIgrac(Igrac i) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			em.persist(i);
			
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
	
	
		
	
	//brisanje igraca
	public void deleteIgraca(Igrac i) {
		EntityManager em = PersistenceUtil.getEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			Query q = em.createQuery("select m from Mec m where m.igrac1=:x");
			q.setParameter("x", i);
			List<Mec> mecevi = q.getResultList();
			
			for(Mec m : mecevi) {
				i.removeMecs1(m);
				i.removeMecs2(m);
				em.remove(m);
			}
			
			i = em.merge(i);
			em.remove(i);
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
	
	
	
	
	//prikaz svih igraca
	public List<Igrac> listIgraci() {
		EntityManager em = PersistenceUtil.getEntityManager();
		String upit = "select i from Igrac i";
		Query q = em.createQuery(upit);
		List<Igrac> svi = q.getResultList();
		em.close();
		return svi;
	}
	
	public Igrac findIgraca(int id) {
		EntityManager em = PersistenceUtil.getEntityManager();
		Igrac i = em.find(Igrac.class, id);
		em.close();
		return i;
		
	}

}
