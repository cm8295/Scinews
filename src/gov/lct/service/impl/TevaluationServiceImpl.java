package gov.lct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import gov.lct.dao.TevaluationDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Tevaluation;
import gov.lct.service.TevaluationService;;

@Service("ttimesetService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TevaluationServiceImpl extends GenericServiceImpl<Tevaluation, String> implements TevaluationService{
	@Autowired
	private TevaluationDao tevaluationDao;

	public TevaluationDao getTuploadDao() {
		return tevaluationDao;
	}

	public void setTuploadDao(TevaluationDao tevaluationDao) {
		this.tevaluationDao = tevaluationDao;
		super.setGenericDao(tevaluationDao);
	}
	
	


}
