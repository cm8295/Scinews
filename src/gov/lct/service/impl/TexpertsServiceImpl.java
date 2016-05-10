package gov.lct.service.impl;

import gov.lct.dao.TexpertsDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Texperts;
import gov.lct.service.TexpertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("texpertsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TexpertsServiceImpl extends GenericServiceImpl<Texperts, String> implements TexpertsService {
	@Autowired
	private TexpertsDao texpertsDao;
	
	
	public TexpertsDao getTexpertsDao() {
		return texpertsDao;
	}

	public void setTexpertsDao(TexpertsDao texpertsDao) {
		this.texpertsDao = texpertsDao;
		super.setGenericDao(texpertsDao);
	}

}