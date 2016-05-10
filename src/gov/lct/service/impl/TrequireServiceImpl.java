package gov.lct.service.impl;

import gov.lct.dao.TrequireDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Trequire;
import gov.lct.service.TrequireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("trequireService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TrequireServiceImpl extends GenericServiceImpl<Trequire, String> implements TrequireService {
	@Autowired
	private TrequireDao trequireDao;
	
	
	public TrequireDao getTrequireDao() {
		return trequireDao;
	}

	public void setTrequireDao(TrequireDao trequireDao) {
		this.trequireDao = trequireDao;
		super.setGenericDao(trequireDao);
	}
}