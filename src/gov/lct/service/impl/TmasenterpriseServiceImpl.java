package gov.lct.service.impl;

import gov.lct.dao.TmasenterpriseDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Tmasenterprise;
import gov.lct.service.TmasenterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("TmasenterpriseService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TmasenterpriseServiceImpl extends GenericServiceImpl<Tmasenterprise, String> implements TmasenterpriseService {
	@Autowired
	private TmasenterpriseDao masenterpriseDao;
	
	
	public TmasenterpriseDao getTmasenterpriseDao() {
		return masenterpriseDao;
	}

	public void setTmasenterpriseDao(TmasenterpriseDao masenterpriseDao) {
		this.masenterpriseDao = masenterpriseDao;
		super.setGenericDao(masenterpriseDao);
	}
}