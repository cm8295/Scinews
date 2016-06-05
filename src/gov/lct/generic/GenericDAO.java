package gov.lct.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	public void saveEntity(T entity); // ��Ӽ�¼
	public void updateEntity(T entity); // �޸ļ�¼
	public void deleteEntity(T entity); // ɾ���¼

	public void updateEntity(String entityClass,String fieldname, String value, String fieldname1, String value1);
	//������еļ�¼��
	public List<T> findAllEntity(Class<T> entityClass);  // ��ñ���������Ϣ��¼
	public List<T> findAllEntity(Class<T> entityClass, int pageSize,int startRow);  // ���ָ����ʼλ�õ�һ�μ�¼
	public List<T> findAllEntity(Class<T> entityClass, int pageSize, int startRow, String sort);  // ���ָ����ʼλ�õ�һ�μ�¼,������sort��������
	public List<T> findAllEntity(Class<T> entityClass, String sort);
	public List<T> findAllEntity(Class<T> entityClass, String sort, String sortmethod);
	
	//�������
	public int getEntityRows(Class<T> entityClass); 
	public int getEntityRows(Class<T> entityClass, String fieldname, String value, String matchmethod); // ������м�¼����
	public int getEntityRows(Class<T> entityClass, ArrayList<String> fieldnameList,ArrayList<String> valueList, ArrayList<String> conditionList, ArrayList<String> relationList);// ���������ѯ��������һ����������,not,like,equal
	public int getEntityRows(Class<T> entityClass, ArrayList<String> fieldnameList,ArrayList<String> valueList, ArrayList<String> conditionList);// ���������ѯ��������
	
	public List<T> queryEntityItems(Class<T> entityClass, String fieldname, String value, String matchmethod, String sort, int pageSize, int startRow);
	public List<T> queryEntityItems(Class<T> entityClass, String sort, ArrayList<String> fieldnameList, ArrayList<String> valueList, ArrayList<String> conditionList, ArrayList<String> relationList, int pageSize, int startRow);

	public List<T> queryEntityItems(Class<T> entityClass, ArrayList<String> fieldnameList, ArrayList<String> valueList, ArrayList<String> conditionList);
	
	public List<T> statistic(Class<T> entityClass, String fieldname, String groupby, String whereby, String orderby, String sortby, int returncount); //�����������ͳ�ơ����顢����
	
	
	//NEW  @Auther:GAO SiCong   2013.3.29
	//���������Ӳ�ѯ,comlumnName��Ҫ��ѡ���ֶ���linkName�����������������ֶ���valueName��ԭʼ����ֶ���value��ԭʼ�ֶ����ֵ
	public List<String> findTwoTableColumnName(String entityClass1,String entityClass2,String columnName,String linkName,String valueName,String value);
	
	public List<T> queryEntityInItems(String entityClass, String infield, String newtable, String subclause, String sortfield, String sortmethod, int pageSize, int startRow); // �ú���in�������
	
}
