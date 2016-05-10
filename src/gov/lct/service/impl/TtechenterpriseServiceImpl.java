package gov.lct.service.impl;

import gov.lct.dao.TtechenterpriseDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Ttechenterprise;
import gov.lct.service.TtechenterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("TtechenterpriseService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TtechenterpriseServiceImpl extends GenericServiceImpl<Ttechenterprise, String> implements TtechenterpriseService {
	@Autowired
	private TtechenterpriseDao techenterpriseDao;
	
	
	public TtechenterpriseDao getTtechenterpriseDao() {
		return techenterpriseDao;
	}

	public void setTtechenterpriseDao(TtechenterpriseDao techenterpriseDao) {
		this.techenterpriseDao = techenterpriseDao;
		super.setGenericDao(techenterpriseDao);
	}
}