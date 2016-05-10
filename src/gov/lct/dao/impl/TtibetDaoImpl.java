package gov.lct.dao.impl;

import gov.lct.dao.TtibetDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Ttibet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("TtibetDao")
public class TtibetDaoImpl extends GenericDAOImpl<Ttibet, String> implements TtibetDao{
	@Autowired
	private SessionFactory sessionFactory;

}