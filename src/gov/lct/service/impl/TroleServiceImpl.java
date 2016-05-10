package gov.lct.service.impl;

import gov.lct.dao.TroleDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Trole;
import gov.lct.service.TroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("troleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TroleServiceImpl extends GenericServiceImpl<Trole, String> implements TroleService {
	@Autowired
	private TroleDao troleDao;
	
	
	public TroleDao getTroleDao() {
		return troleDao;
	}

	public void setTroleDao(TroleDao troleDao) {
		this.troleDao = troleDao;
		super.setGenericDao(troleDao);
	}
}