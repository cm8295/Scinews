package gov.lct.dao.impl;

import gov.lct.dao.TpatentbasicinfoDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Tpatentbasicinfo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tpatentbasicinfoDao")
public class TpatentbasicinfoDaoImpl extends GenericDAOImpl<Tpatentbasicinfo, String> implements TpatentbasicinfoDao {
	@Autowired
	private SessionFactory sessionFactory;

}