package gov.lct.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gov.lct.dao.TtimesetDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Ttimeset;;

@Repository("ttimesetdao")
public class TtimesetDaoImpl extends GenericDAOImpl<Ttimeset, String> implements TtimesetDao{
	@Autowired
	private SessionFactory sessionFactory;

}
