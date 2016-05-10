package gov.lct.service.impl;

import gov.lct.dao.TkjcgDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Tkjcg;
import gov.lct.service.TkjcgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("tkjcgService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TkjcgServiceImpl extends GenericServiceImpl<Tkjcg, String> implements TkjcgService {
	@Autowired
	private TkjcgDao tkjcgDao;
	
	
	public TkjcgDao getTkjcgDao() {
		return tkjcgDao;
	}

	public void setTkjcgDao(TkjcgDao tkjcgDao) {
		this.tkjcgDao = tkjcgDao;
		super.setGenericDao(tkjcgDao);
	}

}