package gov.lct.controller;

import gov.lct.model.Tmasenterprise;
import gov.lct.model.Ttechenterprise;
import gov.lct.service.TtechenterpriseService;

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
public class techenterpriseController {
	@Autowired
	private TtechenterpriseService techenterpriseService;
	private Collection availableItems;
	
	private SolrServer solrServer;
	private static final String DEFAULT_URL = "http://or.clas.ac.cn/solr/";
	
	
	@RequestMapping(value="/classenterprisedisplay")
	public String classenterprisedisplay(HttpServletRequest request) {
	
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
		String entclass = (String) request.getParameter("entclass");
		
		SolrQuery query = null;
		Ttechenterprise enterprise = null;
		Collection<Ttechenterprise> enterpriseItems = new ArrayList<Ttechenterprise>();
		SolrDocumentList enterpriseResults = new SolrDocumentList();
		
		String qr = null;
		int start = 0;
		int perpage = 15;
		int pagenumber = 0;
		int pagecount = 0;
		
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
 	    qr = "rightsType:techenterprise AND techentclass:" + entclass;
 		query = new SolrQuery(qr);
		query.setSortField("techentclass",org.apache.solr.client.solrj.SolrQuery.ORDER.asc);
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
				enterprise = new Ttechenterprise();
				SolrDocument enterprisedocument = enterpriseResults.get(i);

				if(enterprisedocument.getFieldValue("techentId")!=null)
					enterprise.setId(Integer.parseInt(enterprisedocument.getFieldValue("techentId").toString()));
			
                if(enterprisedocument.getFieldValue("techentname")!=null)
                	enterprise.setName(enterprisedocument.getFieldValue("techentname").toString());
                
                if(enterprisedocument.getFieldValue("techentprov")!=null)
                	enterprise.setProvince(enterprisedocument.getFieldValue("techentprov").toString());
                
                if(enterprisedocument.getFieldValue("techentcity")!=null)
				    enterprise.setCity(enterprisedocument.getFieldValue("techentcity").toString());
                
				if(enterprisedocument.getFieldValue("techentclass")!=null)
					enterprise.setEclass(enterprisedocument.getFieldValue("techentclass").toString());
				
				enterpriseItems.add(enterprise);
			}
		}
		

		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:techenterprise";
 		query = new SolrQuery(qr);
		query.setSortField("techentclass",org.apache.solr.client.solrj.SolrQuery.ORDER.asc);
	    query.setStart(start);
		query.setRows(perpage);
		        
		query.setFacet(true);
		query.addFacetField("techentcity","techentclass");
		query.setFacetMinCount(1);
		query.setFacetSort("count");
		query.setFacetLimit(100);

		enterpriseresponse = null;
		try {
			enterpriseresponse = solrServer.query(query);
		} catch (SolrServerException e) {
			
			e.printStackTrace();
		}
		
		enterpriseResults = enterpriseresponse.getResults();		
		List<FacetField> facets = enterpriseresponse.getFacetFields();

		for (FacetField facet : facets) 
		{
			if (facet.getName().equals("techentcity")) 
			{				
				List<FacetField.Count> facetEntries = facet.getValues();
				if(facetEntries!=null)
				{
				String[] cityfacet = new String[facetEntries.size()];
				Integer[] cityfacetcount = new Integer[facetEntries.size()];

				int i = 0;
				for (FacetField.Count fcount : facetEntries) 
				{
					cityfacet[i] = fcount.getName();
					cityfacetcount[i] = Integer.parseInt(String.valueOf(fcount.getCount()));					
					i++;
				}  // end of for
				request.setAttribute("cityfacet", cityfacet);
				request.setAttribute("cityfacetcount", cityfacetcount);
			  }
			} // end of if
			
			if (facet.getName().equals("techentclass")) 
			{				
				List<FacetField.Count> facetEntries = facet.getValues();
				if(facetEntries!=null)
				{
				String[] classfacet = new String[facetEntries.size()];
				Integer[] classfacetcount = new Integer[facetEntries.size()];

				int i = 0;
				for (FacetField.Count fcount : facetEntries) 
				{
					classfacet[i] = fcount.getName();
					classfacetcount[i] = Integer.parseInt(String.valueOf(fcount.getCount()));
					i++;
				}  // end of for
				request.setAttribute("classfacet", classfacet);
				request.setAttribute("classfacetcount", classfacetcount);
			  }
			} // end of if
		}

		
		request.setAttribute("enterpriseItems",enterpriseItems);	
		request.setAttribute("totalcount", enterpriseResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("searchtime", searchtime);
		request.setAttribute("entclass", entclass);
	
		return "unauth/display/techenterpriseclassdisplay";
	}

	
	@RequestMapping(value="/cityenterprisedisplay")
	public String cityenterprisedisplay(HttpServletRequest request) {
	
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
		String city = (String) request.getParameter("city");
		
		SolrQuery query = null;
		Ttechenterprise enterprise = null;
		Collection<Ttechenterprise> enterpriseItems = new ArrayList<Ttechenterprise>();
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
 	    qr = "rightsType:techenterprise AND techentcity:" + city;
 		query = new SolrQuery(qr);
		query.setSortField("techentclass",org.apache.solr.client.solrj.SolrQuery.ORDER.asc);
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
				enterprise = new Ttechenterprise();
				SolrDocument enterprisedocument = enterpriseResults.get(i);

				if(enterprisedocument.getFieldValue("techentId")!=null)
					enterprise.setId(Integer.parseInt(enterprisedocument.getFieldValue("techentId").toString()));
			
                if(enterprisedocument.getFieldValue("techentname")!=null)
                	enterprise.setName(enterprisedocument.getFieldValue("techentname").toString());
                
                if(enterprisedocument.getFieldValue("techentprov")!=null)
                	enterprise.setProvince(enterprisedocument.getFieldValue("techentprov").toString());
                
                if(enterprisedocument.getFieldValue("techentcity")!=null)
				    enterprise.setCity(enterprisedocument.getFieldValue("techentcity").toString());
                
				if(enterprisedocument.getFieldValue("techentclass")!=null)
					enterprise.setEclass(enterprisedocument.getFieldValue("techentclass").toString());
				
				enterpriseItems.add(enterprise);
			}
		}
		

		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:techenterprise";
 		query = new SolrQuery(qr);
		query.setSortField("techentclass",org.apache.solr.client.solrj.SolrQuery.ORDER.asc);
	    query.setStart(start);
		query.setRows(perpage);
		        
		query.setFacet(true);
		query.addFacetField("techentcity","techentclass");
		query.setFacetMinCount(1);
		query.setFacetSort("count");
		query.setFacetLimit(100);

		enterpriseresponse = null;
		try {
			enterpriseresponse = solrServer.query(query);
		} catch (SolrServerException e) {
			
			e.printStackTrace();
		}
		
		enterpriseResults = enterpriseresponse.getResults();		
		List<FacetField> facets = enterpriseresponse.getFacetFields();

		for (FacetField facet : facets) 
		{
			if (facet.getName().equals("techentcity")) 
			{				
				List<FacetField.Count> facetEntries = facet.getValues();
				if(facetEntries!=null)
				{
				String[] cityfacet = new String[facetEntries.size()];
				Integer[] cityfacetcount = new Integer[facetEntries.size()];

				int i = 0;
				for (FacetField.Count fcount : facetEntries) 
				{
					cityfacet[i] = fcount.getName();
					cityfacetcount[i] = Integer.parseInt(String.valueOf(fcount.getCount()));					
					i++;
				}  // end of for
				request.setAttribute("cityfacet", cityfacet);
				request.setAttribute("cityfacetcount", cityfacetcount);
			  }
			} // end of if
			
			if (facet.getName().equals("techentclass")) 
			{				
				System.out.println("111");
				List<FacetField.Count> facetEntries = facet.getValues();
				if(facetEntries!=null)
				{
				String[] classfacet = new String[facetEntries.size()];
				Integer[] classfacetcount = new Integer[facetEntries.size()];

				int i = 0;
				for (FacetField.Count fcount : facetEntries) 
				{
					classfacet[i] = fcount.getName();
					classfacetcount[i] = Integer.parseInt(String.valueOf(fcount.getCount()));
					i++;
				}  // end of for
				request.setAttribute("classfacet", classfacet);
				request.setAttribute("classfacetcount", classfacetcount);
			  }
			} // end of if
		}

		
		request.setAttribute("enterpriseItems",enterpriseItems);	
		request.setAttribute("totalcount", enterpriseResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("searchtime", searchtime);
		request.setAttribute("city", city);
	
		return "unauth/display/techenterprisecitydisplay";
	}

	
	@RequestMapping(value="/Techenterprisedisplay")
	public String Techenterprisedisplay(HttpServletRequest request) {
	
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
		
		SolrQuery query = null;
		Ttechenterprise enterprise = null;
		Collection<Ttechenterprise> enterpriseItems = new ArrayList<Ttechenterprise>();
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
 	    qr = "rightsType:techenterprise";
 		query = new SolrQuery(qr);
		query.setSortField("techentclass",org.apache.solr.client.solrj.SolrQuery.ORDER.asc);
	    query.setStart(start);
		query.setRows(perpage);
		        
		query.setFacet(true);
		query.addFacetField("techentcity","techentclass");
		query.setFacetMinCount(1);
		query.setFacetSort("count");
		query.setFacetLimit(100);

		
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
		
		List<FacetField> facets = enterpriseresponse.getFacetFields();

		for (FacetField facet : facets) 
		{
			if (facet.getName().equals("techentcity")) 
			{				
				List<FacetField.Count> facetEntries = facet.getValues();
				if(facetEntries!=null)
				{
				String[] cityfacet = new String[facetEntries.size()];
				Integer[] cityfacetcount = new Integer[facetEntries.size()];

				int i = 0;
				for (FacetField.Count fcount : facetEntries) 
				{
					cityfacet[i] = fcount.getName();
					cityfacetcount[i] = Integer.parseInt(String.valueOf(fcount.getCount()));					
					i++;
				}  // end of for
				request.setAttribute("cityfacet", cityfacet);
				request.setAttribute("cityfacetcount", cityfacetcount);
			  }
			} // end of if
			
			if (facet.getName().equals("techentclass")) 
			{				
				System.out.println("111");
				List<FacetField.Count> facetEntries = facet.getValues();
				if(facetEntries!=null)
				{
				String[] classfacet = new String[facetEntries.size()];
				Integer[] classfacetcount = new Integer[facetEntries.size()];

				int i = 0;
				for (FacetField.Count fcount : facetEntries) 
				{
					classfacet[i] = fcount.getName();
					classfacetcount[i] = Integer.parseInt(String.valueOf(fcount.getCount()));
					i++;
				}  // end of for
				request.setAttribute("classfacet", classfacet);
				request.setAttribute("classfacetcount", classfacetcount);
			  }
			} // end of if
		}

		
		if (enterpriseResults.size() > 0) 
		{
			for (int i = 0; i < enterpriseResults.size(); i++) 
			{
				enterprise = new Ttechenterprise();
				SolrDocument enterprisedocument = enterpriseResults.get(i);

				if(enterprisedocument.getFieldValue("techentId")!=null)
					enterprise.setId(Integer.parseInt(enterprisedocument.getFieldValue("techentId").toString()));
			
                if(enterprisedocument.getFieldValue("techentname")!=null)
                	enterprise.setName(enterprisedocument.getFieldValue("techentname").toString());
                
                if(enterprisedocument.getFieldValue("techentprov")!=null)
                	enterprise.setProvince(enterprisedocument.getFieldValue("techentprov").toString());
                
                if(enterprisedocument.getFieldValue("techentcity")!=null)
				    enterprise.setCity(enterprisedocument.getFieldValue("techentcity").toString());
                
				if(enterprisedocument.getFieldValue("techentclass")!=null)
					enterprise.setEclass(enterprisedocument.getFieldValue("techentclass").toString());
				
				enterpriseItems.add(enterprise);
			}
		}
		
		request.setAttribute("enterpriseItems",enterpriseItems);	
		request.setAttribute("totalcount", enterpriseResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("searchtime", searchtime);
	
		return "unauth/display/techenterprisedisplay";
	}
}