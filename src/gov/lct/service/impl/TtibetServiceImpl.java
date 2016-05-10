package gov.lct.service.impl;

import gov.lct.dao.TtibetDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Ttibet;
import gov.lct.service.TtibetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("tibetService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TtibetServiceImpl extends GenericServiceImpl<Ttibet, String> implements TtibetService {
	@Autowired
	private TtibetDao tibetDao;
	
	
	public TtibetDao getTtibetDao() {
		return tibetDao;
	}

	public void setTtibetDao(TtibetDao tibetDao) {
		this.tibetDao = tibetDao;
		super.setGenericDao(tibetDao);
	}
}