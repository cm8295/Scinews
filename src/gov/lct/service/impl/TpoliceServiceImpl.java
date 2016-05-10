package gov.lct.service.impl;

import gov.lct.dao.TpoliceDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Tpolice;
import gov.lct.service.TpoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("tpoliceService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TpoliceServiceImpl extends GenericServiceImpl<Tpolice, String> implements TpoliceService {
	@Autowired
	private TpoliceDao tpoliceDao;
	
	
	public TpoliceDao getTpoliceDao() {
		return tpoliceDao;
	}

	public void setTpoliceDao(TpoliceDao tpoliceDao) {
		this.tpoliceDao = tpoliceDao;
		super.setGenericDao(tpoliceDao);
	}
}