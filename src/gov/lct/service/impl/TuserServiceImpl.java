package gov.lct.service.impl;

import gov.lct.dao.TuserDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Tuser;
import gov.lct.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("tuserService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TuserServiceImpl extends GenericServiceImpl<Tuser, String> implements TuserService {
	@Autowired
	private TuserDao tuserDao;
	
	
	public TuserDao getTuserDao() {
		return tuserDao;
	}

	public void setTuserDao(TuserDao tuserDao) {
		this.tuserDao = tuserDao;
		super.setGenericDao(tuserDao);
	}
}