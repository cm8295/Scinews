package gov.lct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import gov.lct.dao.TitemsDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Titems;
import gov.lct.service.TitemsService;

@Service("titemsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TitemsServiceImpl extends GenericServiceImpl<Titems, String> implements TitemsService{
	@Autowired
	private TitemsDao titemsDao;

	public TitemsDao getTitemsDao() {
		return titemsDao;
	}

	public void setTitemsDao(TitemsDao titemsDao) {
		this.titemsDao = titemsDao;
		super.setGenericDao(titemsDao);
	}
}
