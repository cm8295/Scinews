package gov.lct.service.impl;

import gov.lct.dao.TmapDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Tmap;
import gov.lct.service.TmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("tmapService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TmapServiceImpl extends GenericServiceImpl<Tmap, String> implements TmapService {
	@Autowired
	private TmapDao tmapDao;
	
	
	public TmapDao getTmapDao() {
		return tmapDao;
	}

	public void setTmapDao(TmapDao tmapDao) {
		this.tmapDao = tmapDao;
		super.setGenericDao(tmapDao);
	}
}