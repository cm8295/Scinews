package gov.lct.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public interface GenericService<T, ID extends Serializable> {
	public void save(T entity); // ��Ӽ�¼
	public void update(T entity); // �޸ļ�¼
	public void delete(T entity); // ɾ���¼
	
	//������еļ�¼��
	public List<T> findAll(Class<T> entityClass); // ��ñ���������Ϣ��¼
	public List<T> findAll(Class<T> entityClass, int pageSize, int startRow); // ���ָ����ʼλ�õ�һ�μ�¼
	public List<T> findAll(Class<T> entityClass, int pageSize, int startRow, String sort); // ���ָ����ʼλ�õ�һ�μ�¼,������sort��������	
	public List<T> findAll(Class<T> entityClass, String sort); // ����sort��������
	public List<T> findAll(Class<T> entityClass, String sort, String sortmethod); // ����sort��������
	
	//�������
	public int getRows(Class<T> entityClass); // ������м�¼����
	public int getRows(Class<T> entityClass, String fieldname, String value, String condition); // ���������ѯ��������һ����������,not,like,equal
	public int getRows(Class<T> entityClass, ArrayList<String> fieldnameList, ArrayList<String> valueList, ArrayList<String> conditionList, ArrayList<String> relationList);// ���������ѯ������������������
	public int getRows(Class<T> entityClass, ArrayList<String> fieldnameList, ArrayList<String> valueList, ArrayList<String> conditionList);// ���������ѯ��������  2013-10-29
	
	public List<T> queryItems(Class<T> entityClass, String fieldname, String value, String matchmethod, String sort, int pageSize, int startRow); //  2011-03-03
	public List<T> queryItems(Class<T> entityClass, String sort, ArrayList<String> fieldnameList, ArrayList<String> valueList,  ArrayList<String> conditionList, ArrayList<String> relationList, int pageSize, int startRow);
	
	public List<T> queryItems(Class<T> entityClass, ArrayList<String> fieldnameList, ArrayList<String> valueList, ArrayList<String> conditionList);  // 2013-10-29

	public List<T> statistic(Class<T> entityClass, String fieldname, String groupby, String whereby, String orderby, String sortby, int returncount); //�����������ͳ�ơ����顢����
	
	//NEW  @Auther:GAO SiCong   2013.3.29
	//���������Ӳ�ѯ,comlumnName��Ҫ��ѡ���ֶ���linkName�����������������ֶ���valueName��ԭʼ����ֶ���value��ԭʼ�ֶ����ֵ
	public List<String> findTwoTableColumnName(String entityClass1,String entityClass2,String columnName,String linkName,String valueName,String value);
	
	public List<T> queryInItems(String entityClass, String infield, String newtable, String subclause, String sortfield, String sortmethod, int pageSize, int startRow); // �ú���in�������
}
