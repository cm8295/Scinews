package gov.lct.dao.impl;

import gov.lct.dao.TtechenterpriseDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Ttechenterprise;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("TtechenterpriseDao")
public class TtechenterpriseDaoImpl extends GenericDAOImpl<Ttechenterprise, String> implements TtechenterpriseDao{
	@Autowired
	private SessionFactory sessionFactory;

}