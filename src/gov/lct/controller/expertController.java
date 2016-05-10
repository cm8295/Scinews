package gov.lct.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import gov.lct.model.Texperts;
import gov.lct.model.Tkjcg;
import gov.lct.model.Tpatentbasicinfo;
import gov.lct.service.TexpertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class expertController {
	@Autowired	
	private TexpertsService texpertsService;	
	private SolrServer solrServer;
	private static final String DEFAULT_URL = "http://or.clas.ac.cn/solr/";
	

	@RequestMapping(value = "/ExpertAllProvDisplay")  
	public String ExpertAllProvDisplay(HttpServletRequest request, Model model) {

		SolrQuery query = null;
		String qr = null;
		QueryResponse response = null;
		int start = 0;
		int perpage = 50;
	
 		solrServer = new HttpSolrServer(DEFAULT_URL);
		//获取专家信息
 	    qr = "rightsType:expert";
 		query = new SolrQuery(qr);
 		query.setSortField("kjcgYear",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);
		
		//query.addFacetField("expprovince","expwork1");
		query.addFacetField("expprovince");
		query.setFacetSort("count");
		query.setFacetLimit(500);
		
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			
			e.printStackTrace();
		}
				
		System.out.println("获取专家信息");

		List<FacetField> facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
 	       if (facet.getName().equals("expprovince")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] provfacet = new String[facetEntries.size()];
 			      Integer[] provfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 provfacet[m] = fcount.getName();					 
						 provfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(provfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("provfacet", provfacet);
				  request.setAttribute("provfacetcount", provfacetcount);
				}					
			  }		
		}
			
		return "unauth/display/expertallprov";
	}
	
	@RequestMapping(value = "/ExpertAllInstDisplay")  
	public String ExpertAllInstDisplay(HttpServletRequest request, Model model) {

		SolrQuery query = null;
		String qr = null;
		QueryResponse response = null;
		int start = 0;
		int perpage = 50;
	
 		solrServer = new HttpSolrServer(DEFAULT_URL);
		//获取专家信息
 	    qr = "rightsType:expert";
 		query = new SolrQuery(qr);
 		query.setSortField("kjcgYear",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);
		
		//query.addFacetField("expprovince","expwork1");
		query.addFacetField("expwork1");
		query.setFacetSort("count");
		query.setFacetLimit(500);
		
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			
			e.printStackTrace();
		}
				
		System.out.println("获取专家信息");

		List<FacetField> facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
 	       if (facet.getName().equals("expwork1")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] workfacet = new String[facetEntries.size()];
 			      Integer[] workfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 workfacet[m] = fcount.getName();					 
						 workfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(workfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("workfacet", workfacet);
				  request.setAttribute("workfacetcount", workfacetcount);
				}					
			  }		
		}			
		return "unauth/display/expertallinst";
	}
	
	@RequestMapping(value = "/ExpertFacetDisplay")  
	public String ExpertFacetDisplay(HttpServletRequest request, Model model) {
	
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
        String facet = (String) request.getParameter("facet"); 
		String content = (String) request.getParameter("content"); 
		
		SolrQuery query = null;
		Texperts expert = null;
		Collection<Texperts> expertItems = new ArrayList<Texperts>();
		SolrDocumentList expertResults = new SolrDocumentList();
		QueryResponse response = null;
		
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
		if(facet.equals("expertprov"))
 	       qr = "rightsType:expert AND expprovince:" + "\"" + content + "\"";
		else if(facet.equals("expertwork"))
		   qr = "rightsType:expert AND expwork1:" + "\"" + content + "\"";
		else if(facet.equals("expertxk"))
		   qr = "rightsType:expert AND expxknameMul:" + "\"" + content + "\"";
		
 		query = new SolrQuery(qr);
		query.setSortField("expname",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);		
		
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}	
	
		expertResults = response.getResults();		
		if (expertResults.size() > 0) 
		{
			for (int i = 0; i < expertResults.size(); i++) 
			{
				expert = new Texperts();
				SolrDocument expertdocument = expertResults.get(i);
                if(expertdocument.getFieldValue("expname")!=null)
                	expert.setExpname(expertdocument.getFieldValue("expname").toString());
                
                if(expertdocument.getFieldValue("expid")!=null)
                	expert.setId(Integer.parseInt(expertdocument.getFieldValue("expid").toString()));
                
                if(expertdocument.getFieldValue("expwork1")!=null)
                	expert.setExpwork1(expertdocument.getFieldValue("expwork1").toString());
                
				if(expertdocument.getFieldValue("expaddress")!=null)
					expert.setExpaddress(expertdocument.getFieldValue("expaddress").toString());
				
				if(expertdocument.getFieldValue("expprovince")!=null)
					expert.setExpprovince(expertdocument.getFieldValue("expprovince").toString());
				
				if(expertdocument.getFieldValue("expdomain")!=null)
					expert.setExpdomain(expertdocument.getFieldValue("expdomain").toString());
						
				if(expertdocument.getFieldValue("exptitle")!=null)
					expert.setExptitle(expertdocument.getFieldValue("exptitle").toString());
				
				System.out.println(expert.getExpname());
				System.out.println(expert.getExpaddress());
				expertItems.add(expert);
			}
		}
		
		request.setAttribute("expertItems",expertItems);	
		request.setAttribute("totalcount", expertResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("facet", facet);
		request.setAttribute("content", content);			
		
		return "unauth/facetdisplay/expertfacetdisplay";
	}
	
	
    //专家所属省份浏览
	@RequestMapping(value = "/ExpertInstdisplay")  
	public String ExpertInstdisplay(HttpServletRequest request, Model model) {
				
		SolrQuery query = null;
		Texperts expert = null;
		Collection<Texperts> expertItems = new ArrayList<Texperts>();
		SolrDocumentList expertResults = new SolrDocumentList();
		
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
		String inst = (String) request.getParameter("inst");
		
		int start = 0;
		int perpage = 10;
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
		
 		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:expert AND expwork1:" + "\"" + inst + "\"";
 		query = new SolrQuery(qr);
	    query.setStart(start);
		query.setRows(perpage);
 		
 		query.setFacet(true);
		query.addFacetField("expwork1");
		query.setFacetSort("count");
		query.setFacetMinCount(0);

		QueryResponse response = null;
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
		List<FacetField> facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
			   if (facet.getName().equals("expwork1")) 
			   {
				  List<FacetField.Count> facetEntries = facet.getValues();
				  if(facetEntries!=null)
				  {
	 			      String[] workfacet = new String[facetEntries.size()];
	 			      Integer[] workfacetcount = new Integer[facetEntries.size()];
					  int m = 0;
					  for (FacetField.Count fcount : facetEntries) 
					  {
						 if(fcount.getName()!=null)
						 {
							 workfacet[m] = fcount.getName();					 
							 workfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
							 System.out.println(workfacet[m]);
						     m++;							     
						 }
					  }				  			  
					  request.setAttribute("workfacet", workfacet);
					  request.setAttribute("workfacetcount", workfacetcount);
					}					
				  }		
			}	
		
		
		expertResults = response.getResults();		
		if (expertResults.size() > 0) 
		{
			for (int i = 0; i < expertResults.size(); i++) 
			{
				expert = new Texperts();
				SolrDocument expertdocument = expertResults.get(i);
                if(expertdocument.getFieldValue("expname")!=null)
                	expert.setExpname(expertdocument.getFieldValue("expname").toString());
                
                if(expertdocument.getFieldValue("expid")!=null)
                	expert.setId(Integer.parseInt(expertdocument.getFieldValue("expid").toString()));
                
                if(expertdocument.getFieldValue("expwork1")!=null)
                	expert.setExpwork1(expertdocument.getFieldValue("expwork1").toString());
                
				if(expertdocument.getFieldValue("expaddress")!=null)
					expert.setExpaddress(expertdocument.getFieldValue("expaddress").toString());
				
				if(expertdocument.getFieldValue("expprovince")!=null)
					expert.setExpprovince(expertdocument.getFieldValue("expprovince").toString());
				
				if(expertdocument.getFieldValue("expdomain")!=null)
					expert.setExpdomain(expertdocument.getFieldValue("expdomain").toString());
						
				System.out.println(expert.getExpname());
				System.out.println(expert.getExpaddress());
				expertItems.add(expert);
			}
		}
		
		request.setAttribute("expertItems",expertItems);	
		request.setAttribute("totalcount", expertResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("inst", inst);
		
       return "unauth/display/expertinstdisplay";		
	}
	
    //专家所属省份浏览
	@RequestMapping(value = "/ExpertProvdisplay")  
	public String ExpertProvdisplay(HttpServletRequest request, Model model) {
				
		SolrQuery query = null;
		Texperts expert = null;
		Collection<Texperts> expertItems = new ArrayList<Texperts>();
		SolrDocumentList expertResults = new SolrDocumentList();
		
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
		String prov = (String) request.getParameter("prov");
		
		int start = 0;
		int perpage = 10;
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
		
 		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:expert AND expprovince:" + "\"" + prov + "\"";
 		query = new SolrQuery(qr);
	    query.setStart(start);
		query.setRows(perpage);
		
 		query.setFacet(true);
		query.addFacetField("expprovince");
		query.setFacetSort("count");
		query.setFacetMinCount(0);

		QueryResponse response = null;
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
		List<FacetField> facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("expprovince")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] provfacet = new String[facetEntries.size()];
 			      Integer[] provfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 provfacet[m] = fcount.getName();					 
						 provfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(provfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("provfacet", provfacet);
				  request.setAttribute("provfacetcount", provfacetcount);
				}					
			  }
		   }	
		
		
		expertResults = response.getResults();		
		if (expertResults.size() > 0) 
		{
			for (int i = 0; i < expertResults.size(); i++) 
			{
				expert = new Texperts();
				SolrDocument expertdocument = expertResults.get(i);
                if(expertdocument.getFieldValue("expname")!=null)
                	expert.setExpname(expertdocument.getFieldValue("expname").toString());
                
                if(expertdocument.getFieldValue("expid")!=null)
                	expert.setId(Integer.parseInt(expertdocument.getFieldValue("expid").toString()));
                
                if(expertdocument.getFieldValue("expwork1")!=null)
                	expert.setExpwork1(expertdocument.getFieldValue("expwork1").toString());
                
				if(expertdocument.getFieldValue("expaddress")!=null)
					expert.setExpaddress(expertdocument.getFieldValue("expaddress").toString());
				
				if(expertdocument.getFieldValue("expprovince")!=null)
					expert.setExpprovince(expertdocument.getFieldValue("expprovince").toString());
				
				if(expertdocument.getFieldValue("exptitle")!=null)
					expert.setExptitle(expertdocument.getFieldValue("exptitle").toString());
						
				System.out.println(expert.getExpname());
				System.out.println(expert.getExpaddress());
				expertItems.add(expert);
			}
		}
		
		request.setAttribute("expertItems",expertItems);	
		request.setAttribute("totalcount", expertResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("prov", prov);
		
       return "unauth/display/expertprovdisplay";		
	}
		
    //专家浏览 或者首页更多专家
	@RequestMapping(value = "/Expertdisplay")  
	public String Expertdisplay(HttpServletRequest request, Model model) {
				
		SolrQuery query = null;
		Texperts expert = null;
		Collection<Texperts> expertItems = new ArrayList<Texperts>();
		SolrDocumentList expertResults = new SolrDocumentList();
		
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 

		int start = 0;
		int perpage = 10;
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
		
 		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:expert";
 		query = new SolrQuery(qr);

 		query.setFacet(true);
		query.addFacetField("expprovince","expwork1","expxknameMul");
		query.setFacetSort("count");
		query.setFacetMinCount(0);

		QueryResponse response = null;
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
		List<FacetField> facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("expprovince")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] provfacet = new String[facetEntries.size()];
 			      Integer[] provfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 provfacet[m] = fcount.getName();					 
						 provfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(provfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("provfacet", provfacet);
				  request.setAttribute("provfacetcount", provfacetcount);
				}					
			  }
		   
		   if (facet.getName().equals("expwork1")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] workfacet = new String[facetEntries.size()];
 			      Integer[] workfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 workfacet[m] = fcount.getName();					 
						 workfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(workfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("workfacet", workfacet);
				  request.setAttribute("workfacetcount", workfacetcount);
				}					
			  }		   

		   if (facet.getName().equals("expxknameMul")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] xkfacet = new String[facetEntries.size()];
 			      Integer[] xkfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 xkfacet[m] = fcount.getName();					 
						 xkfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(xkfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("xkfacet", xkfacet);
				  request.setAttribute("xkfacetcount", xkfacetcount);
				}					
			  }			
		   }	
		
		
		expertResults = response.getResults();		
		if (expertResults.size() > 0) 
		{
			for (int i = 0; i < expertResults.size(); i++) 
			{
				expert = new Texperts();
				SolrDocument expertdocument = expertResults.get(i);
                if(expertdocument.getFieldValue("expname")!=null)
                	expert.setExpname(expertdocument.getFieldValue("expname").toString());
                
                if(expertdocument.getFieldValue("expid")!=null)
                	expert.setId(Integer.parseInt(expertdocument.getFieldValue("expid").toString()));
                
                if(expertdocument.getFieldValue("expwork1")!=null)
                	expert.setExpwork1(expertdocument.getFieldValue("expwork1").toString());
                
				if(expertdocument.getFieldValue("expaddress")!=null)
					expert.setExpaddress(expertdocument.getFieldValue("expaddress").toString());
				
				if(expertdocument.getFieldValue("expprovince")!=null)
					expert.setExpprovince(expertdocument.getFieldValue("expprovince").toString());
				
				if(expertdocument.getFieldValue("exptitle")!=null)
					expert.setExptitle(expertdocument.getFieldValue("exptitle").toString());
						
				if(expertdocument.getFieldValue("expdomain")!=null)
					expert.setExpdomain(expertdocument.getFieldValue("expdomain").toString());
				
				System.out.println(expert.getExpname());
				System.out.println(expert.getExpaddress());
				expertItems.add(expert);
			}
		}
		
		request.setAttribute("expertItems",expertItems);	
		request.setAttribute("totalcount", expertResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		
       return "unauth/display/expertdisplay";		
	}
	
	
	
	@RequestMapping(value="/expertdetail")
	public String patentdetail(HttpServletRequest request) {
		
		SolrQuery query = null;
		Texperts expert = null;
		Collection<Texperts> expertItems = new ArrayList<Texperts>();
		SolrDocumentList expertResults = new SolrDocumentList();
        String expertid = request.getParameter("expertid");
		
		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:expert AND expid:" + expertid;
 		query = new SolrQuery(qr);
		        
		QueryResponse confresponse = null;
		Calendar c1 = Calendar.getInstance();
		try {
			confresponse = solrServer.query(query);
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
		
		expertResults = confresponse.getResults();		
		if (expertResults.size() > 0) 
		{
			for (int i = 0; i < expertResults.size(); i++) 
			{
				expert = new Texperts();
				SolrDocument expertdocument = expertResults.get(i);
                if(expertdocument.getFieldValue("expid")!=null)
                	expert.setId(Integer.parseInt(expertdocument.getFieldValue("expid").toString()));
                
                if(expertdocument.getFieldValue("expname")!=null)
                	expert.setExpname(expertdocument.getFieldValue("expname").toString());
                
                if(expertdocument.getFieldValue("expdomain")!=null)
				    expert.setExpdomain(expertdocument.getFieldValue("expdomain").toString());
                
                if(expertdocument.getFieldValue("expaddress")!=null)
				    expert.setExpaddress(expertdocument.getFieldValue("expaddress").toString());
 
                if(expertdocument.getFieldValue("expgender")!=null)
                	expert.setExpgender(expertdocument.getFieldValue("expgender").toString());
                
                if(expertdocument.getFieldValue("expcity")!=null)
				    expert.setExpcity(expertdocument.getFieldValue("expcity").toString());
                
                if(expertdocument.getFieldValue("expcounty")!=null)
				    expert.setExpcounty(expertdocument.getFieldValue("expcounty").toString());
                
                if(expertdocument.getFieldValue("exphonor")!=null)
				    expert.setExpeexphonor(expertdocument.getFieldValue("exphonor").toString());
                
                if(expertdocument.getFieldValue("expjob")!=null)
				    expert.setExpjob(expertdocument.getFieldValue("expjob").toString());
 
                if(expertdocument.getFieldValue("exparea")!=null)
                	expert.setExparea(expertdocument.getFieldValue("exparea").toString());
                
                if(expertdocument.getFieldValue("exptitle")!=null)
                	expert.setExptitle(expertdocument.getFieldValue("exptitle").toString());
                                
                if(expertdocument.getFieldValue("expwork1")!=null)
                	expert.setExpwork1(expertdocument.getFieldValue("expwork1").toString());
                
                
				System.out.println(expert.getExpname());
				System.out.println(expert.getExpdomain());
				expertItems.add(expert);
			}
		}
		
		request.setAttribute("expertItems",expertItems);	
		request.setAttribute("searchtime", searchtime);
		
		return "unauth/detail/expertdetail";
	}
	
}