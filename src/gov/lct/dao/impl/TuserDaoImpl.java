package gov.lct.dao.impl;

import gov.lct.dao.TuserDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Tuser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tuserDao")
public class TuserDaoImpl extends GenericDAOImpl<Tuser, String> implements TuserDao{
	@Autowired
	private SessionFactory sessionFactory;

}