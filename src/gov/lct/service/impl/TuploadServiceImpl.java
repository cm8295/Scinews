package gov.lct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import gov.lct.dao.TuploadDao;
import gov.lct.generic.GenericServiceImpl;
import gov.lct.model.Tupload;
import gov.lct.service.TuploadService;

@Service("tuploadService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TuploadServiceImpl extends GenericServiceImpl<Tupload, String> implements TuploadService{
	@Autowired
	private TuploadDao tuploadDao;

	public TuploadDao getTuploadDao() {
		return tuploadDao;
	}

	public void setTuploadDao(TuploadDao tuploadDao) {
		this.tuploadDao = tuploadDao;
		super.setGenericDao(tuploadDao);
	}
	
	


}
