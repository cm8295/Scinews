package gov.lct.service.impl;

import gov.lct.dao.TpatentbasicinfoDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Tpatentbasicinfo;
import gov.lct.service.TpatentbasicinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("tpatentbasicinfoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TpatentbasicinfoServiceImpl extends GenericServiceImpl<Tpatentbasicinfo, String> implements TpatentbasicinfoService {
	@Autowired
	private TpatentbasicinfoDao tpatentbasicinfoDao;
	
	
	public TpatentbasicinfoDao getTpatentbasicinfoDao() {
		return tpatentbasicinfoDao;
	}

	public void setTpatentbasicinfoDao(TpatentbasicinfoDao tpatentbasicinfoDao) {
		this.tpatentbasicinfoDao = tpatentbasicinfoDao;
		super.setGenericDao(tpatentbasicinfoDao);
	}

}