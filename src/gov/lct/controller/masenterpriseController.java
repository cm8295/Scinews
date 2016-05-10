package gov.lct.controller;

import gov.lct.model.Tmasenterprise;
import gov.lct.model.Tpatentbasicinfo;
import gov.lct.service.TmasenterpriseService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class masenterpriseController {
	@Autowired
	private TmasenterpriseService masenterpriseService;
	private Collection availableItems;
	
	private SolrServer solrServer;
	private static final String DEFAULT_URL = "http://localhost/solr/";
	
	
	@RequestMapping(value="/masenterprisedisplay")
	public String masenterprisedisplay(HttpServletRequest request) {
	
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
		
		SolrQuery query = null;
		Tmasenterprise enterprise = null;
		Collection<Tmasenterprise> enterpriseItems = new ArrayList<Tmasenterprise>();
		SolrDocumentList enterpriseResults = new SolrDocumentList();
		
		String qr = null;
		int start = 0;
		int perpage = 15;
		int pagenumber = 0;
		int pagecount = 0;
		int docmentNum = 0;
		
		if (pagetype.equals("init")) {
			start = 0;
			currentpage = currentpage + 1;
		}
		if (pagetype.equals("next")) {
			start = currentpage * perpage + 1;
			currentpage = currentpage + 1;
		}
		if (pagetype.equals("previous")) {
			if (currentpage == 2) {
				start = (currentpage - 2) * perpage;
				currentpage = currentpage - 1;
			} else {
				start = (currentpage - 2) * perpage + 1;
				currentpage = currentpage - 1;
			}
		}
		if (pagetype.equals("last")) {
			if ((totalcount % perpage) == 0)
				pagecount = totalcount / perpage;
			else
				pagecount = totalcount / perpage + 1;
			start = (pagecount-1) * perpage + 1;
			currentpage = pagecount;
		}		
		if (pagetype.equals("jump")) {
			pagenumber = Integer.parseInt(request.getParameter("pagenumber"));
			if (pagenumber > 1) {
				start = (pagenumber - 1) * perpage + 1;
				currentpage = pagenumber;
			}
			if (pagenumber == 1 || pagenumber == 0) {
				start = 0;
				currentpage = pagenumber;
			}
		}

		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:masenterprise";
 		query = new SolrQuery(qr);
		query.setSortField("mentcity",org.apache.solr.client.solrj.SolrQuery.ORDER.asc);
	    query.setStart(start);
		query.setRows(perpage);
		        
		QueryResponse enterpriseresponse = null;
		Calendar c1 = Calendar.getInstance();
		try {
			enterpriseresponse = solrServer.query(query);
		} catch (SolrServerException e) {
			
			e.printStackTrace();
		}
		
		Calendar c2 = Calendar.getInstance();
        long difference=c2.getTimeInMillis()-c1.getTimeInMillis();
        double searchtime = 0;
		if((difference/1000)>1)
		  searchtime = difference/1000;		
		else
		  searchtime = (Math.round(difference)/1000.0);

		enterpriseResults = enterpriseresponse.getResults();		
		if (enterpriseResults.size() > 0) 
		{
			for (int i = 0; i < enterpriseResults.size(); i++) 
			{
				enterprise = new Tmasenterprise();
				SolrDocument enterprisedocument = enterpriseResults.get(i);

				if(enterprisedocument.getFieldValue("mid")!=null)
					enterprise.setId(Integer.parseInt(enterprisedocument.getFieldValue("mid").toString()));
			
                if(enterprisedocument.getFieldValue("mentname")!=null)
                	enterprise.setName(enterprisedocument.getFieldValue("techentname").toString());
                
                if(enterprisedocument.getFieldValue("menttype")!=null)
                	enterprise.setEntertype(enterprisedocument.getFieldValue("menttype").toString());
                
                if(enterprisedocument.getFieldValue("mentcity")!=null)
				    enterprise.setCity(enterprisedocument.getFieldValue("mentcity").toString());
                
                if(enterprisedocument.getFieldValue("mentrange")!=null)
				    enterprise.setRange(enterprisedocument.getFieldValue("mentrange").toString());

                if(enterprisedocument.getFieldValue("mentyear")!=null)
					enterprise.setTypeyear(enterprisedocument.getFieldValue("mentyear").toString());
				
				enterpriseItems.add(enterprise);
			}
		}
		
		request.setAttribute("enterpriseItems",enterpriseItems);	
		request.setAttribute("totalcount", enterpriseResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("searchtime", searchtime);
	
		return "unauth/display/masenterprisedisplay";
	}
	
	
	@RequestMapping(value="/maslocalenterprisedisplay")
	public String maslocalenterprisedisplay(HttpServletRequest request) {
	
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
		String local = (String) request.getParameter("local");
		
		SolrQuery query = null;
		Tmasenterprise enterprise = null;
		Collection<Tmasenterprise> enterpriseItems = new ArrayList<Tmasenterprise>();
		SolrDocumentList enterpriseResults = new SolrDocumentList();
		
		String qr = null;
		int start = 0;
		int perpage = 15;
		int pagenumber = 0;
		int pagecount = 0;
		int docmentNum = 0;
		
		if (pagetype.equals("init")) {
			start = 0;
			currentpage = currentpage + 1;
		}
		if (pagetype.equals("next")) {
			start = currentpage * perpage + 1;
			currentpage = currentpage + 1;
		}
		if (pagetype.equals("previous")) {
			if (currentpage == 2) {
				start = (currentpage - 2) * perpage;
				currentpage = currentpage - 1;
			} else {
				start = (currentpage - 2) * perpage + 1;
				currentpage = currentpage - 1;
			}
		}
		if (pagetype.equals("last")) {
			if ((totalcount % perpage) == 0)
				pagecount = totalcount / perpage;
			else
				pagecount = totalcount / perpage + 1;
			start = (pagecount-1) * perpage + 1;
			currentpage = pagecount;
		}		
		if (pagetype.equals("jump")) {
			pagenumber = Integer.parseInt(request.getParameter("pagenumber"));
			if (pagenumber > 1) {
				start = (pagenumber - 1) * perpage + 1;
				currentpage = pagenumber;
			}
			if (pagenumber == 1 || pagenumber == 0) {
				start = 0;
				currentpage = pagenumber;
			}
		}

		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:masenterprise";
 		query = new SolrQuery(qr);
		query.setSortField("mentcity",org.apache.solr.client.solrj.SolrQuery.ORDER.asc);
	    query.setStart(start);
		query.setRows(perpage);
		
		query.setFacet(true);
		query.addFacetField("menttype","mentcity");
		query.setFacetSort("count");
		query.setFacetLimit(50);

		QueryResponse enterpriseresponse = null;
		try {
			enterpriseresponse = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}		
		
		System.out.println("获取中小型企业信息");
		
		List<FacetField> facets = enterpriseresponse.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("menttype")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] typefacet = new String[facetEntries.size()];
 			      Integer[] typefacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 typefacet[m] = fcount.getName();					 
						 typefacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(typefacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("typefacet", typefacet);
				  request.setAttribute("typefacetcount", typefacetcount);
				}					
			  }
		   
		   if (facet.getName().equals("mentcity")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] cityfacet = new String[facetEntries.size()];
 			      Integer[] cityfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 cityfacet[m] = fcount.getName();					 
						 cityfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(cityfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("cityfacet", cityfacet);
				  request.setAttribute("cityfacetcount", cityfacetcount);
				}					
		     }	
		   
		 }
					
		
 	    qr = "rightsType:masenterprise AND mentcity:" + local;		
 		query = new SolrQuery(qr);
		query.setSortField("mid",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);
		        		
		try {
			enterpriseresponse = solrServer.query(query);
		} catch (SolrServerException e) {
			
			e.printStackTrace();
		}
		
		enterpriseResults = enterpriseresponse.getResults();		
		if (enterpriseResults.size() > 0) 
		{
			for (int i = 0; i < enterpriseResults.size(); i++) 
			{
				enterprise = new Tmasenterprise();
				SolrDocument enterprisedocument = enterpriseResults.get(i);

				if(enterprisedocument.getFieldValue("mid")!=null)
					enterprise.setId(Integer.parseInt(enterprisedocument.getFieldValue("mid").toString()));
			
                if(enterprisedocument.getFieldValue("mentname")!=null)
                	enterprise.setName(enterprisedocument.getFieldValue("mentname").toString());
                
                if(enterprisedocument.getFieldValue("menttype")!=null)
                	enterprise.setEntertype(enterprisedocument.getFieldValue("menttype").toString());
                
                if(enterprisedocument.getFieldValue("mentcity")!=null)
				    enterprise.setCity(enterprisedocument.getFieldValue("mentcity").toString());
                
                if(enterprisedocument.getFieldValue("mentrange")!=null)
				    enterprise.setRange(enterprisedocument.getFieldValue("mentrange").toString());

                if(enterprisedocument.getFieldValue("mentyear")!=null)
					enterprise.setTypeyear(enterprisedocument.getFieldValue("mentyear").toString());
				
				enterpriseItems.add(enterprise);
			}
		}
		
		request.setAttribute("enterpriseItems",enterpriseItems);	
		request.setAttribute("totalcount", enterpriseResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("local", local);
	
		return "unauth/display/maslocalenterprisedisplay";
	}
	
	
	@RequestMapping(value="/masxjrenterprisedisplay")
	public String masxjrenterprisedisplay(HttpServletRequest request) {

		return "unauth/display/masxjrdisplay";
	}

	@RequestMapping(value="/masbqenterprisedisplay")
	public String masbqenterprisedisplay(HttpServletRequest request) {

		return "unauth/display/masbqdisplay";
	}
	
	@RequestMapping(value="/xjr1")
	public String xjr1(HttpServletRequest request) {

		return "unauth/display/xjr1";
	}

//	@RequestMapping(value="/mastypeenterprisedisplay")
//	public String mastypeenterprisedisplay(HttpServletRequest request) {
//	
//		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
//        int totalcount = 0;
//		if(request.getParameter("totalcount")!=null)
//		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
//		String pagetype = (String) request.getParameter("pagetype"); 
//		String type = (String) request.getParameter("type");
//		
//		SolrQuery query = null;
//		Tmasenterprise enterprise = null;
//		Collection<Tmasenterprise> enterpriseItems = new ArrayList<Tmasenterprise>();
//		SolrDocumentList enterpriseResults = new SolrDocumentList();
//		
//		String qr = null;
//		int start = 0;
//		int perpage = 15;
//		int pagenumber = 0;
//		int pagecount = 0;
//		
//		if (pagetype.equals("init")) {
//			start = 0;
//			currentpage = currentpage + 1;
//		}
//		if (pagetype.equals("next")) {
//			start = currentpage * perpage + 1;
//			currentpage = currentpage + 1;
//		}
//		if (pagetype.equals("previous")) {
//			if (currentpage == 2) {
//				start = (currentpage - 2) * perpage;
//				currentpage = currentpage - 1;
//			} else {
//				start = (currentpage - 2) * perpage + 1;
//				currentpage = currentpage - 1;
//			}
//		}
//		if (pagetype.equals("last")) {
//			if ((totalcount % perpage) == 0)
//				pagecount = totalcount / perpage;
//			else
//				pagecount = totalcount / perpage + 1;
//			start = (pagecount-1) * perpage + 1;
//			currentpage = pagecount;
//		}		
//		if (pagetype.equals("jump")) {
//			pagenumber = Integer.parseInt(request.getParameter("pagenumber"));
//			if (pagenumber > 1) {
//				start = (pagenumber - 1) * perpage + 1;
//				currentpage = pagenumber;
//			}
//			if (pagenumber == 1 || pagenumber == 0) {
//				start = 0;
//				currentpage = pagenumber;
//			}
//		}
//
//		solrServer = new HttpSolrServer(DEFAULT_URL);
// 	    qr = "rightsType:masenterprise";
// 		query = new SolrQuery(qr);
//		query.setSortField("mentcity",org.apache.solr.client.solrj.SolrQuery.ORDER.asc);
//	    query.setStart(start);
//		query.setRows(perpage);
//		
//		query.setFacet(true);
//		query.addFacetField("menttype","mentcity");
//		query.setFacetSort("count");
//		query.setFacetLimit(50);
//
//		QueryResponse enterpriseresponse = null;
//		try {
//			enterpriseresponse = solrServer.query(query);
//		} catch (SolrServerException e) {
//			e.printStackTrace();
//		}		
//		
//		System.out.println("获取中小型企业信息");
//		
//		List<FacetField> facets = enterpriseresponse.getFacetFields();		
//		for (FacetField facet : facets) 
//		{
//		   if (facet.getName().equals("menttype")) 
//		   {
//			  List<FacetField.Count> facetEntries = facet.getValues();
//			  if(facetEntries!=null)
//			  {
// 			      String[] typefacet = new String[facetEntries.size()];
// 			      Integer[] typefacetcount = new Integer[facetEntries.size()];
//				  int m = 0;
//				  for (FacetField.Count fcount : facetEntries) 
//				  {
//					 if(fcount.getName()!=null)
//					 {
//						 typefacet[m] = fcount.getName();					 
//						 typefacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
//						 System.out.println(typefacet[m]);
//					     m++;							     
//					 }
//				  }				  			  
//				  request.setAttribute("typefacet", typefacet);
//				  request.setAttribute("typefacetcount", typefacetcount);
//				}					
//			  }
//		   
//		   if (facet.getName().equals("mentcity")) 
//		   {
//			  List<FacetField.Count> facetEntries = facet.getValues();
//			  if(facetEntries!=null)
//			  {
// 			      String[] cityfacet = new String[facetEntries.size()];
// 			      Integer[] cityfacetcount = new Integer[facetEntries.size()];
//				  int m = 0;
//				  for (FacetField.Count fcount : facetEntries) 
//				  {
//					 if(fcount.getName()!=null)
//					 {
//						 cityfacet[m] = fcount.getName();					 
//						 cityfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
//						 System.out.println(cityfacet[m]);
//					     m++;							     
//					 }
//				  }				  			  
//				  request.setAttribute("cityfacet", cityfacet);
//				  request.setAttribute("cityfacetcount", cityfacetcount);
//				}					
//		     }	
//		   
//		 }
//					
//		
//		if(type.equals("小巨人企业"))
// 	      qr = "rightsType:masenterprise AND menttype:小巨人企业";
//		if(type.equals("成长型企业"))
// 	      qr = "rightsType:masenterprise AND menttype:成长型企业";
//		if(type.equals("国家示范平台"))
//	 	  qr = "rightsType:masenterprise AND menttype:国家示范平台";
//		if(type.equals("省级示范平台"))
//	 	  qr = "rightsType:masenterprise AND menttype:省级示范平台";
//		if(type.indexOf("100")!=-1)
//	 	  qr = "rightsType:masenterprise AND menttype:*100*";
//		if(type.equals("创业基地"))
//	 	  qr = "rightsType:masenterprise AND menttype:创业基地";
//		
// 		query = new SolrQuery(qr);
//		query.setSortField("mid",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
//	    query.setStart(start);
//		query.setRows(perpage);
//		        		
//		Calendar c1 = Calendar.getInstance();
//		try {
//			enterpriseresponse = solrServer.query(query);
//		} catch (SolrServerException e) {
//			
//			e.printStackTrace();
//		}
//		
//		Calendar c2 = Calendar.getInstance();
//        long difference=c2.getTimeInMillis()-c1.getTimeInMillis();
//        double searchtime = 0;
//		if((difference/1000)>1)
//		  searchtime = difference/1000;		
//		else
//		  searchtime = (Math.round(difference)/1000.0);
//
//		enterpriseResults = enterpriseresponse.getResults();		
//		if (enterpriseResults.size() > 0) 
//		{
//			for (int i = 0; i < enterpriseResults.size(); i++) 
//			{
//				enterprise = new Tmasenterprise();
//				SolrDocument enterprisedocument = enterpriseResults.get(i);
//
//				if(enterprisedocument.getFieldValue("mid")!=null)
//					enterprise.setId(Integer.parseInt(enterprisedocument.getFieldValue("mid").toString()));
//			
//                if(enterprisedocument.getFieldValue("mentname")!=null)
//                	enterprise.setName(enterprisedocument.getFieldValue("mentname").toString());
//                
//                if(enterprisedocument.getFieldValue("menttype")!=null)
//                	enterprise.setEntertype(enterprisedocument.getFieldValue("menttype").toString());
//                
//                if(enterprisedocument.getFieldValue("mentcity")!=null)
//				    enterprise.setCity(enterprisedocument.getFieldValue("mentcity").toString());
//                
//                if(enterprisedocument.getFieldValue("mentrange")!=null)
//				    enterprise.setRange(enterprisedocument.getFieldValue("mentrange").toString());
//
//                if(enterprisedocument.getFieldValue("mentyear")!=null)
//					enterprise.setTypeyear(enterprisedocument.getFieldValue("mentyear").toString());
//				
//				enterpriseItems.add(enterprise);
//			}
//		}
//		
//		request.setAttribute("enterpriseItems",enterpriseItems);	
//		request.setAttribute("totalcount", enterpriseResults.getNumFound());
//		request.setAttribute("pagecount", pagecount);
//		request.setAttribute("currentpage", currentpage);
//		request.setAttribute("searchtime", searchtime);
//		request.setAttribute("type", type);
//	
//		return "unauth/display/mastypeenterprisedisplay";
//	}
	
	
}