package gov.lct.generic;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unchecked")
@Repository("genericDao")
public class GenericDAOImpl<T, ID extends Serializable> extends HibernateDaoSupport implements GenericDAO<T, ID> {
    @Autowired  
    public void setSessionFactoryOverride(SessionFactory sessionFactory)  
    {  
        super.setSessionFactory(sessionFactory);  
    }  
	//-----------------------------------------------
	public void deleteEntity(T entity) {
		this.getHibernateTemplate().delete(entity);
	}
	public void saveEntity(T entity) {
		this.getHibernateTemplate().save(entity);
	}
	public void updateEntity(T entity) {
		this.getHibernateTemplate().update(entity);
	}
	
	public void updateEntity(String entityClass,String fieldname, String value, String fieldname1, String value1){
		String sql = "update " + entityClass + " set " + fieldname + "='" + value + "' where " + fieldname1 + "='" + value + "'";
		
	}

	
	public List<T> findAllEntity(Class<T> entityClass) {
		String entityname = entityClass.getName();
		return this.getHibernateTemplate().find("FROM " + entityname);
	}
	public List<T> findAllEntity(Class<T> entityClass, int pageSize, int startRow) {
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		final String entityname = entityClass.getName();
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("FROM " + entityname);
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	
	public List<T> findAllEntity(Class<T> entityClass, int pageSize, int startRow, String sorts) {
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		final String entityname = entityClass.getName();
		final String sort = sorts;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List doInHibernate(Session session) throws HibernateException, SQLException {
				//Query query = session.createQuery("FROM " + entityname + " order by " + sort + " desc");
				Query query = session.createQuery("FROM " + entityname + " order by " + sort);
				query.setFirstResult(startRow1);
				query.setMaxResults(pageSize1);
				return query.list();
			}
		});
	}
	
	public List<T> findAllEntity(Class<T> entityClass, String sorts) {
		final String entityname = entityClass.getName();
		final String sort = sorts;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("FROM " + entityname + " order by " + sort);
				return query.list();
			}
		});
	}
	
	public List<T> findAllEntity(Class<T> entityClass, String sorts, String sortmethod) {
		final String entityname = entityClass.getName();
		final String sort = sorts;
		final String method = sortmethod;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("FROM " + entityname + " order by " + sort + " " + method);
				return query.list();
			}
		});
	}	
	
	//NEW  @Auther:GAO SiCong   2013.3.29
	//���������Ӳ�ѯ,comlumnName��Ҫ��ѡ���ֶ���linkName�����������������ֶ���valueName��ԭʼ����ֶ���value��ԭʼ�ֶ����ֵ
	public List<String> findTwoTableColumnName(String entityClass1,String entityClass2,String columnName,String linkName,String valueName,String value) {
		String sql="SELECT "+columnName+" FROM "+entityClass1+" WHERE "+linkName+"=(SELECT "+linkName+" FROM "+entityClass2+" WHERE "+valueName+"=?)" ;
		
		//System.out.println("SQL:"+sql);
		List<String> list=getHibernateTemplate().find(sql,value);
		
		//System.out.println("list:"+list.size());
		
		return this.getHibernateTemplate().find(sql,value);
		
	}
	
	
	
	//------------------------------------------------------------------��������
	public int getEntityRows(Class<T> entityClass) {
		 String hql = "select count(*) from " + entityClass.getSimpleName();
		 Long count = (Long)getHibernateTemplate().find(hql).listIterator().next();
		 Integer temp = new Integer(String.valueOf(count));
		 return temp.intValue();
	}
	/*
	 * matchmethod���������Σ�like , not like , = , <>
	 */
	public int getEntityRows(Class<T> entityClass, String fieldname, String value, String matchmethod) {
		String entityname = entityClass.getName();
		String method = matchmethod;
		String hql = "";
		if (fieldname == null || fieldname.equals("") || value == null || value.equals(""))
			hql = " FROM " + entityname;
		else{
			if(method == "is not")
  		      hql = " FROM " + entityname + " WHERE " + fieldname + " is not " + value;			
			if(method == "not like")
			  hql = " FROM " + entityname + " WHERE " + fieldname + " not like '%" + value + "%'";
			if (method == "=")
			  hql = " FROM " + entityname + " WHERE " + fieldname + " = '" + value + "'";
			if (method == "<>")		
			  hql = " FROM " + entityname + " WHERE " + fieldname + " <> '" + value + "'";
			if (method == "like")
			  hql = " FROM " + entityname + " WHERE " + fieldname + " like '%" + value + "%'";
			//Add by Jiangenbo at 2013-11-30 
			if (method == "distinct")
			  hql = "select count(distinct " + fieldname + ") as count from " + entityname; 	
		}
		////System.out.println("hql===" + hql);
		return this.getHibernateTemplate().find(hql).size();
	}

	
	public int getEntityRows(Class<T> entityClass, ArrayList<String> fieldnameList, ArrayList<String> valueList, 
			ArrayList<String> conditionList, ArrayList<String> relationList){
		final String entityname = entityClass.getName();
		if((valueList!=null && valueList!=null) && fieldnameList.size()!=valueList.size()) return 0;
		String hql = "";
		if (fieldnameList == null || fieldnameList.size()==0 || valueList == null || valueList.size()==0 ||
				conditionList == null || conditionList.size() ==0 ||relationList == null || relationList.size() == 0)
		    hql = "FROM " + entityname;
		else
		{
		   if(conditionList.get(0).toString().equals("like"))
 			  hql = "FROM " + entityname + " where "+fieldnameList.get(0) + " "+conditionList.get(0)+" '%"+ valueList.get(0) +"%'";
		   if(conditionList.get(0).toString().equals("is") && conditionList.get(0).toString().equals("is not"))
	 		  hql = "FROM " + entityname + " where "+fieldnameList.get(0) + " "+conditionList.get(0) + " " + valueList.get(0);
		   if(conditionList.get(0).toString().equals("="))
  		      hql = "FROM " + entityname + " where "+fieldnameList.get(0) + " "+conditionList.get(0) + " '" + valueList.get(0) + "'";
	    }
		    System.out.println("1111");
			for(int i=1; i<fieldnameList.size(); i++)
			{
				if(conditionList.get(i).toString().contains("like"))
				{
					hql += " "+relationList.get(i-1) + " "+fieldnameList.get(i) + " "+conditionList.get(i)+" '%"+ valueList.get(i) +"%'";
				}
				if(conditionList.get(i).toString().equals("is"))
				{
					hql += " "+relationList.get(i-1) + " " + fieldnameList.get(i) + " " + conditionList.get(i) + " " + valueList.get(i);
				}
				if(conditionList.get(i).toString().equals("is not"))
				{
					hql += " "+relationList.get(i-1) + " " + fieldnameList.get(i) + " " + conditionList.get(i) + " " + valueList.get(i);
				}
				if(conditionList.get(i).toString().equals("="))
			    {
				   hql += " "+relationList.get(i-1) + " "+fieldnameList.get(i) + " "+conditionList.get(i)+" '"+ valueList.get(i) + "'"; 
			    }
			}
		return this.getHibernateTemplate().find(hql).size();
	}
	

	public int getEntityRows(Class<T> entityClass, ArrayList<String> fieldnameList, ArrayList<String> valueList, ArrayList<String> conditionList){
		final String entityname = entityClass.getName();
		if((valueList!=null&&valueList!=null)&&fieldnameList.size()!=valueList.size()) return 0;
		String hql = "";
		if (fieldnameList == null || fieldnameList.size()==0 || valueList == null || valueList.size()==0 || conditionList == null || conditionList.size() ==0)
			hql = "FROM " + entityname;
		else{
				if(conditionList.get(0).toString().contains("like")){
					hql = "FROM " + entityname + " where "+fieldnameList.get(0) + " "+conditionList.get(0)+" '%"+ valueList.get(0) +"%'";
				}
				if(conditionList.get(0).toString().equals("=")){
					hql = "FROM " + entityname + " where "+fieldnameList.get(0) + " "+conditionList.get(0)+" '"+ valueList.get(0) +"'";
				}
				
				for(int i=1; i<fieldnameList.size(); i++)
				{	
				  if(conditionList.get(i).toString().equals("like")){
						hql += " and " + " "+fieldnameList.get(i) + " "+conditionList.get(i)+" '%"+ valueList.get(i) +"%'";
				  }
				  if(conditionList.get(i).toString().equals("=")){
						hql += " and "+ " "+fieldnameList.get(i) + " "+conditionList.get(i)+" '"+ valueList.get(i) +"'";
				  }
				  //System.out.println("hql===" + hql);
				}
			}	
		return this.getHibernateTemplate().find(hql).size();
	}
	
	public List<T> queryEntityItems(Class<T> entityClass, String fieldname, String value, String matchmethod, String sorts, int pageSize, int startRow) 
	{
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		final String entityname = entityClass.getName();
		final String queryName = fieldname;
		final String queryValue = value;
		final String method = matchmethod;
		
		String hql = "";
		if (queryName == null || queryName.equals("") || queryValue.equals(""))
			hql = "FROM " + entityname;
		else
		{
			if(method.equals("is not"))
  		      hql = " FROM " + entityname + " WHERE " + fieldname + " is not " + value;
			if(method.equals("is"))
  		      hql = " FROM " + entityname + " WHERE " + fieldname + " is " + value;
			if(method.equals("not like"))
			  hql = " FROM " + entityname + " WHERE " + fieldname + " not like '%" + value + "%'";
			if (method.equals("="))
			  hql = " FROM " + entityname + " WHERE " + fieldname + " = '" + value + "'";				
			if (method.equals("<>"))		
			  hql = " FROM " + entityname + " WHERE " + fieldname + " <> '" + value + "'";
			if  (method.equals("like"))
			  hql = " FROM " + entityname + " WHERE " + fieldname + " like '%" + value + "%'";

		   hql+=" ORDER BY " + sorts + " desc";
		   //System.out.println(hql);
		}
		////System.out.println("queryEntityItems hql===" + hql);
		final String hql1 = hql;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql1);
				if (startRow1 >= 0 && pageSize1 >= 0) {
					query.setFirstResult(startRow1);
					query.setMaxResults(pageSize1);
				}
				return query.list();
			}
		});
	}

	public List<T> queryEntityInItems(String entityClass, String infield, String newtable, String subclause, String sortfield, String sortmethod, int pageSize, int startRow) {
		final String param1 = entityClass;
		final String param2 = infield;
		final String param3 = newtable;
		final String param4 = subclause;
		
		final String param5 = sortfield;
		final String param6 = sortmethod;
		final int param7 = pageSize;
		final int param8 = startRow;
 	    
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
		  public List doInHibernate(Session session) throws HibernateException, SQLException {
			Query query1 = null;
			//Query query = session.createQuery(hql1);
			query1 = session.createSQLQuery("select Scinews_ID,Scinews_sTitle,Scinews_Author,Scinews_sDate,NewsSource_ID,Scinews_URL,Scinews_Brief,Scinews_pubtime FROM " + param1 + " where "  + param2  + " in (select " + param2 + " from " + param3 + " where "  + param4 + ") order by " + param5 + " " + param6);
			query1.setFirstResult(7);  
			query1.setMaxResults(8);
			return query1.list();	
			}
		});
	}
	
	
	
	public List<T> queryEntityItems(Class<T> entityClass, String sorts, ArrayList<String> fieldnameList, ArrayList<String> valueList,
			ArrayList<String> conditionList, ArrayList<String> relationList,  int pageSize, int startRow){
		final int pageSize1 = pageSize;
		final int startRow1 = startRow;
		final String entityname = entityClass.getName();
		if((valueList!=null&&valueList!=null)&&fieldnameList.size()!=valueList.size()) return null;
		String hql = "";
		if (fieldnameList == null || fieldnameList.size()==0 || valueList == null || valueList.size()==0 ||
				conditionList == null || conditionList.size() ==0 ||relationList == null || relationList.size() == 0){
			if(sorts.trim() == "")
			{
				hql = "FROM " + entityname;
			}
			else
			{
				hql = "FROM " + entityname + " ORDER BY " + sorts + " DESC";
			}
		}
		else
		{
		   if(conditionList.get(0).toString().contains("like"))
 			  hql = "FROM " + entityname + " where "+fieldnameList.get(0) + " "+conditionList.get(0)+" '%"+ valueList.get(0) +"%'";
		   if(conditionList.get(0).toString().equals("is") && conditionList.get(0).toString().equals("is not"))
	 		  hql = "FROM " + entityname + " where "+fieldnameList.get(0) + " "+conditionList.get(0) + " " + valueList.get(0);
		   if(conditionList.get(0).toString().equals("="))
  		      hql = "FROM " + entityname + " where "+fieldnameList.get(0) + " "+conditionList.get(0) + " '" + valueList.get(0) + "'";
	    }
			  
		for(int i=1; i<fieldnameList.size(); i++)
		{
			if(conditionList.get(i).toString().equals("like"))
			{
				hql += " "+relationList.get(i-1) + " "+fieldnameList.get(i) + " "+conditionList.get(i)+" '%"+ valueList.get(i) +"%'";
			}
			if(conditionList.get(i).toString().equals("is"))
			{
				hql += " "+relationList.get(i-1) + " " + fieldnameList.get(i) + " " + conditionList.get(i) + " " + valueList.get(i);
			}
			if(conditionList.get(i).toString().equals("is not"))
			{
				hql += " "+relationList.get(i-1) + " " + fieldnameList.get(i) + " " + conditionList.get(i) + " " + valueList.get(i);
			}
			if(conditionList.get(i).toString().equals("="))
		    {
			   hql += " "+relationList.get(i-1) + " "+fieldnameList.get(i) + " "+conditionList.get(i)+" '"+ valueList.get(i) + "'"; 
		    }
		}
				hql+=" ORDER BY " + sorts + " DESC";
				
		System.out.println("list hql===" + hql);
		final String hql1 = hql;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql1);
				if (startRow1 >= 0 && pageSize1 >= 0) {
					query.setFirstResult(startRow1);
					query.setMaxResults(pageSize1);
				}
				return query.list();
			}
		});
	}
	


	public List<T> queryEntityItems(Class<T> entityClass, ArrayList<String> fieldnameList, ArrayList<String> valueList, ArrayList<String> conditionList){
		final String entityname = entityClass.getName();
		if((valueList!=null&&valueList!=null)&&fieldnameList.size()!=valueList.size()) return null;
		String hql = "";
		if (fieldnameList == null || fieldnameList.size()==0 || valueList == null || valueList.size()==0 || conditionList == null || conditionList.size()==0)
		{
			hql = "FROM " + entityname;
		}
		else
		{
			if(conditionList.get(0).toString().contains("like")){
				hql = "FROM " + entityname + " where "+fieldnameList.get(0) + " "+conditionList.get(0)+" '%"+ valueList.get(0) +"%'";
			}else{
				hql = "FROM " + entityname + " where "+fieldnameList.get(0) + " "+conditionList.get(0)+" '"+ valueList.get(0) +"'";
			}			
			
			for(int i=1; i<fieldnameList.size(); i++){
				if(conditionList.get(i).toString().equals("like"))
				{
					hql += " and "+ fieldnameList.get(i) + " "+ conditionList.get(i) + " '%"+ valueList.get(i) +"%'";
				}
				if(conditionList.get(i).toString().equals("="))
				{				
					hql += " and " + fieldnameList.get(i) + " " + conditionList.get(i) + " '"+ valueList.get(i) +"'";
				}
			}
		}
		System.out.println("list hql===" + hql);
		final String hql1 = hql;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery(hql1);
				return query.list();
			}
		});
	}
	
		
	//������ͳ��
	public List<T> statistic(final Class<T> entityClass, final String fieldname, String groupby, String whereby, String orderby, String sortby, int returncount){
		final String entityname = entityClass.getName();
		//System.out.println(entityname);		
		String group = groupby;
		String where = whereby;
		String order = orderby;
 		String sort = sortby;	
 		final int count = returncount;
	    String hql = "select " + fieldname + " as newsid" + ", count(" + fieldname + ") as count from " + entityname + " " + where + group + order + sort;
	    final String hql1 = hql;
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public List doInHibernate(Session session) throws HibernateException, SQLException {
				  ////System.out.println(hql1);
				  Query query = session.createQuery(hql1);
				  query.setFirstResult(0);  
				  query.setMaxResults(count);	
				  return query.list();
			 }
        }); 
    }

}
