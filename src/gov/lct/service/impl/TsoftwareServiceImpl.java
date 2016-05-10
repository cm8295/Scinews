package gov.lct.service.impl;

import gov.lct.dao.TsoftwareDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Tsoftware;
import gov.lct.service.TsoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("tsoftwareService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TsoftwareServiceImpl extends GenericServiceImpl<Tsoftware, String> implements TsoftwareService {
	@Autowired
	private TsoftwareDao tsoftwareDao;
	
	
	public TsoftwareDao getTsoftwareDao() {
		return tsoftwareDao;
	}

	public void setTsoftwareDao(TsoftwareDao tsoftwareDao) {
		this.tsoftwareDao = tsoftwareDao;
		super.setGenericDao(tsoftwareDao);
	}
}