package gov.lct.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gov.lct.dao.TuploadDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Tupload;

@Repository("tuploadDao")
public class TuploadDaoImpl extends GenericDAOImpl<Tupload, String> implements TuploadDao{
	@Autowired
	private SessionFactory sessionFactory;

}
