package gov.lct.dao.impl;

import gov.lct.dao.TipDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Tip;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tipDao")
public class TipDaoImpl extends GenericDAOImpl<Tip, String> implements TipDao{
	@Autowired
	private SessionFactory sessionFactory;

}