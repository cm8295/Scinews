package gov.lct.service.impl;

import gov.lct.dao.TsplitDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Tsplit;
import gov.lct.service.TsplitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("tsplitService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TsplitServiceImpl extends GenericServiceImpl<Tsplit, String> implements TsplitService {
	@Autowired
	private TsplitDao tsplitDao;
	
	
	public TsplitDao getTsplitDao() {
		return tsplitDao;
	}

	public void setTsplitDao(TsplitDao tsplitDao) {
		this.tsplitDao = tsplitDao;
		super.setGenericDao(tsplitDao);
	}
}