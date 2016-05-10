package gov.lct.service.impl;

import gov.lct.dao.TipDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Tip;
import gov.lct.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("tipService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TipServiceImpl extends GenericServiceImpl<Tip, String> implements TipService {
	@Autowired
	private TipDao tipDao;
	
	
	public TipDao getTipDao() {
		return tipDao;
	}

	public void setTipDao(TipDao tipDao) {
		this.tipDao = tipDao;
		super.setGenericDao(tipDao);
	}
}