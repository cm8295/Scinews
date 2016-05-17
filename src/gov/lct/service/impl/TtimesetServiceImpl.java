package gov.lct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import gov.lct.dao.TtimesetDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Ttimeset;
import gov.lct.service.TexpertsService;
import gov.lct.service.TtimesetService;

@Service("ttimesetService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TtimesetServiceImpl extends GenericServiceImpl<Ttimeset, String> implements TtimesetService{
	@Autowired
	private TtimesetDao ttimesetDao;

	public TtimesetDao getTuploadDao() {
		return ttimesetDao;
	}

	public void setTuploadDao(TtimesetDao ttimesetDao) {
		this.ttimesetDao = ttimesetDao;
		super.setGenericDao(ttimesetDao);
	}
	
	


}
