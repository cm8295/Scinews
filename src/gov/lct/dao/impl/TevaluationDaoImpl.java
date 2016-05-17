package gov.lct.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gov.lct.dao.TevaluationDao;
import gov.lct.generic.GenericDAOImpl;
import gov.lct.model.Tevaluation;

@Repository("tevaluationdao")
public class TevaluationDaoImpl extends GenericDAOImpl<Tevaluation, String> implements TevaluationDao{
	@Autowired
	private SessionFactory sessionFactory;

}
