package gov.lct.dao.impl;

import gov.lct.dao.TmasenterpriseDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Tmasenterprise;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("TmasenterpriseDao")
public class TmasenterpriseDaoImpl extends GenericDAOImpl<Tmasenterprise, String> implements TmasenterpriseDao{
	@Autowired
	private SessionFactory sessionFactory;

}