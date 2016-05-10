package gov.lct.dao.impl;

import gov.lct.dao.TsplitDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Tsplit;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("tsplitDao")
public class TsplitDaoImpl extends GenericDAOImpl<Tsplit, String> implements TsplitDao{
	@Autowired
	private SessionFactory sessionFactory;

}