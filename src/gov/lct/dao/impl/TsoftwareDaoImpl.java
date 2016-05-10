package gov.lct.dao.impl;

import gov.lct.dao.TsoftwareDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Tsoftware;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tsoftwareDao")
public class TsoftwareDaoImpl extends GenericDAOImpl<Tsoftware, String> implements TsoftwareDao{
	@Autowired
	private SessionFactory sessionFactory;

}