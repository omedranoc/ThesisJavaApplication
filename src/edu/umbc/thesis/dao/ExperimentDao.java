package edu.umbc.thesis.dao;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import edu.umbc.thesis.domain.Experiment;
import edu.umbc.thesis.util.HibernateUtil;


public class ExperimentDao {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	public void createExperiment(Experiment experiment) {
			Session session = sf.openSession();
			session.beginTransaction();		
			session.save(experiment);			
			session.getTransaction().commit();			
			session.close();		
			
		
	}
	public Experiment retrieveAuthorsByCriteriaName(Long id) {
		Session session = sf.openSession();
		session.beginTransaction();
		Experiment experiment = (Experiment)session.createCriteria(Experiment.class).add(Restrictions.like("EXPERIMENTID", id));
		session.getTransaction().commit();
		session.close();
		return experiment;
	}

	
}
