package gov.lct.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gov.lct.dao.TitemsDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Titems;

@Repository("titemsdao")
public class TitemsDaoImpl extends GenericDAOImpl<TitemsDao, String> implements TitemsDao{
	@Autowired
	private SessionFactory sessionFactory;

}
