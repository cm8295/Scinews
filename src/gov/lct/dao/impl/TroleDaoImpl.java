package gov.lct.dao.impl;

import gov.lct.dao.TroleDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Trole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("troleDao")
public class TroleDaoImpl extends GenericDAOImpl<Trole, String> implements TroleDao{
	@Autowired
	private SessionFactory sessionFactory;

}