package gov.lct.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@SuppressWarnings("unchecked")
public class GenericServiceImpl<T, ID extends Serializable> implements GenericService<T, ID> {
	
	private GenericDAO genericDao;
	@Autowired
	public void setGenericDao(@Qualifier("genericDao")GenericDAO genericDao) {
		this.genericDao = genericDao;
	}
	//------------------------------------------------
	public void delete(T entity) {
		this.genericDao.deleteEntity(entity);
	}
	public void save(T entity) {
		this.genericDao.saveEntity(entity);
	}

	public void update(T entity) {
		this.genericDao.updateEntity(entity);
	}
	
	public List<T> findAll(Class<T> entityClass) {
		return this.genericDao.findAllEntity(entityClass);
	}

	public List<T> findAll(Class<T> entityClass, int pageSize, int startRow, String sort) {
		return this.genericDao.findAllEntity(entityClass, pageSize, startRow, sort);
	}
	
	public List<T> findAll(Class<T> entityClass, int pageSize, int startRow) {
		return this.genericDao.findAllEntity(entityClass, pageSize, startRow);
	}
	
	public List<T> findAll(Class<T> entityClass, String sort){
		return this.genericDao.findAllEntity(entityClass, sort);
	}
	
	public List<T> findAll(Class<T> entityClass, String sort, String sortmethod){
		return this.genericDao.findAllEntity(entityClass, sort, sortmethod);
	}
	
	//------------------------------------------------
	public int getRows(Class<T> entityClass) {
		return this.genericDao.getEntityRows(entityClass);
	}
	public int getRows(Class<T> entityClass, String fieldname, String value, String matchmethod){
		return this.genericDao.getEntityRows(entityClass, fieldname, value, matchmethod);
	}
	public int getRows(Class<T> entityClass, ArrayList<String> fieldnameList, ArrayList<String> valueList, ArrayList<String> conditionList, ArrayList<String> relationList){
		return this.genericDao.getEntityRows(entityClass, fieldnameList, valueList, conditionList, relationList);
	}
	public int getRows(Class<T> entityClass, ArrayList<String> fieldnameList, ArrayList<String> valueList, ArrayList<String> conditionList){
		return this.genericDao.getEntityRows(entityClass, fieldnameList, valueList, conditionList);
	}
	public List<T> queryItems(Class<T> entityClass, String fieldname, String value, String matchmethod, String sort, int pageSize, int startRow) {
		return this.genericDao.queryEntityItems(entityClass, fieldname, value, matchmethod, sort, pageSize, startRow);
	}
	public List<T> queryItems(Class<T> entityClass, String sort, ArrayList<String> fieldnameList, ArrayList<String> valueList, ArrayList<String> conditionList, ArrayList<String> relationList, int pageSize, int startRow){
		return this.genericDao.queryEntityItems(entityClass, sort, fieldnameList, valueList, conditionList, relationList, pageSize, startRow);
	}
	public List<T> queryItems(Class<T> entityClass, ArrayList<String> fieldnameList, ArrayList<String> valueList, ArrayList<String> conditionList){
		return this.genericDao.queryEntityItems(entityClass, fieldnameList, valueList, conditionList);
	}
	
	

	public List<T> statistic(Class<T> entityClass, String fieldname, String groupby, String whererby, String orderby, String sortby, int returncount){
		return this.genericDao.statistic(entityClass, fieldname, groupby, whererby, orderby, sortby, returncount);
	}	
	
	
	//NEW  @Auther:GAO SiCong   2013.3.29
	//���������Ӳ�ѯ,comlumnName��Ҫ��ѡ���ֶ���linkName�����������������ֶ���valueName��ԭʼ����ֶ���value��ԭʼ�ֶ����ֵ
	public List<String> findTwoTableColumnName(String entityClass1,String entityClass2,String columnName,String linkName,String valueName,String value)
	{
		return this.genericDao.findTwoTableColumnName(entityClass1, entityClass2, columnName, linkName, valueName, value);
	}
	
	public List<T> queryInItems(String entityClass, String infield, String newtable, String subclause, String sortfield, String sortmethod, int pageSize, int startRow) // �ú���in�������
	{
		return this.genericDao.queryEntityInItems(entityClass, infield, newtable, subclause, sortfield, sortmethod, pageSize, startRow);
	}
	
}
