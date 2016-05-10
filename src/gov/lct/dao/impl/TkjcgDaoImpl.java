package gov.lct.dao.impl;

import gov.lct.dao.TkjcgDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Tkjcg;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tkjcgDao")
public class TkjcgDaoImpl extends GenericDAOImpl<Tkjcg, String> implements TkjcgDao {
	@Autowired
	private SessionFactory sessionFactory;

}