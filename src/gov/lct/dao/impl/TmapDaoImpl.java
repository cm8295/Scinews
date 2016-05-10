package gov.lct.dao.impl;

import gov.lct.dao.TmapDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Tmap;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tmapDao")
public class TmapDaoImpl extends GenericDAOImpl<Tmap, String> implements TmapDao{
	@Autowired
	private SessionFactory sessionFactory;

}