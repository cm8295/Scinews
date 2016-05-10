package gov.lct.dao.impl;

import gov.lct.dao.TpoliceDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Tpolice;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tpoliceDao")
public class TpoliceDaoImpl extends GenericDAOImpl<Tpolice, String> implements TpoliceDao{
	@Autowired
	private SessionFactory sessionFactory;

}