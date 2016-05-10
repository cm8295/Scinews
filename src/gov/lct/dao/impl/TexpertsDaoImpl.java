package gov.lct.dao.impl;

import gov.lct.dao.TexpertsDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Texperts;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("texpertsDao")
public class TexpertsDaoImpl extends GenericDAOImpl<Texperts, String> implements TexpertsDao {
	@Autowired
	private SessionFactory sessionFactory;

}