package gov.lct.dao.impl;

import gov.lct.dao.TitemsDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Titems;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("titemsDao")
public class TitemsDaoImpl extends GenericDAOImpl<Titems, String> implements TitemsDao{
	@Autowired
	private SessionFactory sessionFactory; 

}