package gov.lct.dao.impl;

import gov.lct.dao.TrequireDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Trequire;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("trequireDao")
public class TrequireDaoImpl extends GenericDAOImpl<Trequire, String> implements TrequireDao{
	@Autowired
	private SessionFactory sessionFactory;

}