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
import gov.lct.model.Tpatentbasicinfo;
import gov.lct.model.Ttibet;
import gov.lct.service.TtibetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class TibetPatentController {

	private SolrServer solrServer;
	private static final String DEFAULT_URL = "http://or.clas.ac.cn/solr/";
	
	@Autowired
	private TtibetService tibetService;
	
	@RequestMapping(value="/TibetPatentFpaDisplay")
	public String TibetPatentFpaDisplay(HttpServletRequest request) {
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
		String content = "";
		if(request.getParameter("content")!=null)
		   content = request.getParameter("content");	
		
		SolrQuery query = null;
		Tpatentbasicinfo patent = null;
		Collection<Tpatentbasicinfo> patentItems = new ArrayList<Tpatentbasicinfo>();
		SolrDocumentList patentResults = new SolrDocumentList();
		
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
  	    qr = "rightsType:tibetpatent AND patentFpa:" + "\"" + content + "\""; 	
 		query = new SolrQuery(qr);
 		System.out.println(query);
	    query.setStart(start);
		query.setRows(perpage);
		query.setFacet(true);
		query.addFacetField("patentIcm1");
		query.setFacetSort("name");
	    
		QueryResponse response = null;

		try 
		{
			response = solrServer.query(query);
		} catch (SolrServerException e) 
		{
			e.printStackTrace();
		}	
		
		patentResults = response.getResults();		
		totalcount = (int)patentResults.getNumFound();
		System.out.println(totalcount);

		if (patentResults.size() > 0) 
		{
			for (int i = 0; i < patentResults.size(); i++) 
			{
				patent = new Tpatentbasicinfo();
				SolrDocument patentdocument = patentResults.get(i);
                if(patentdocument.getFieldValue("patentAn")!=null)
                	patent.setPatentAn(patentdocument.getFieldValue("patentAn").toString());
                
                if(patentdocument.getFieldValue("patentAds")!=null)
                	patent.setPatentAd(patentdocument.getFieldValue("patentAds").toString());
                
                if(patentdocument.getFieldValue("patentTi")!=null)
				    patent.setPatentTi(patentdocument.getFieldValue("patentTi").toString());
                
				if(patentdocument.getFieldValue("patentLspd")!=null)
					patent.setPatentLs(patentdocument.getFieldValue("patentLspd").toString());
				
				if(patentdocument.getFieldValue("patentIcm")!=null)
					patent.setPatentIcm(patentdocument.getFieldValue("patentIcm").toString());
				
				if(patentdocument.getFieldValue("patentId")!=null)
					patent.setId(Integer.parseInt(patentdocument.getFieldValue("patentId").toString()));
			
				System.out.println(patent.getPatentAn());
				patentItems.add(patent);
			}
		}
		docmentNum = (int) patentResults.getNumFound();
		if ((docmentNum % perpage) == 0)
			pagecount = docmentNum / perpage;
		else
			pagecount = docmentNum / perpage + 1;
	
		request.setAttribute("patentItems",patentItems);	
		request.setAttribute("totalcount", totalcount);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("content", content);
		
		return "unauth/statistic/tibetfpapartmessge";
	}
	
	@RequestMapping(value="/TibetPatentFpaAll")
	public String TibetPatentFpaAll(HttpServletRequest request) {

		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype");  
		String content = (String) request.getParameter("content");
		
		SolrQuery query = null;
		Tpatentbasicinfo patent = null;
		Collection<Tpatentbasicinfo> patentItems = new ArrayList<Tpatentbasicinfo>();
		SolrDocumentList patentResults = new SolrDocumentList();
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
 	    qr = "rightsType:tibetpatent AND patentFpa:" + "\"" + content + "\"";		
		System.out.println(qr);
 		query = new SolrQuery(qr);
		query.setSortField("patentAd",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);		
		
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}		
		
		System.out.println("获取专利信息");

		patentResults = response.getResults();		
		if (patentResults.size() > 0) 
		{
			for (int i = 0; i < patentResults.size(); i++) 
			{
				patent = new Tpatentbasicinfo();
				SolrDocument patentdocument = patentResults.get(i);
                if(patentdocument.getFieldValue("patentAn")!=null)
                	patent.setPatentAn(patentdocument.getFieldValue("patentAn").toString());
                
                if(patentdocument.getFieldValue("patentTi")!=null)
				    patent.setPatentTi(patentdocument.getFieldValue("patentTi").toString());

                if(patentdocument.getFieldValue("patentId")!=null)
					patent.setId(Integer.parseInt(patentdocument.getFieldValue("patentId").toString()));

                if(patentdocument.getFieldValue("patentAds")!=null)
					patent.setPatentAd(patentdocument.getFieldValue("patentAds").toString());
                
                if(patentdocument.getFieldValue("patentFpa")!=null)
					patent.setPatentFpa(patentdocument.getFieldValue("patentFpa").toString());
                
                if(patentdocument.getFieldValue("patentIcm")!=null)
					patent.setPatentIcm(patentdocument.getFieldValue("patentIcm").toString());

                System.out.println(patent.getPatentTi());
        		patentItems.add(patent);
			}
		}		
		request.setAttribute("patentItems",patentItems);	
		request.setAttribute("totalcount", patentResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("content", content);	
 	
		return "unauth/display/tibetpatentfpaall";
   }
	
	
	@RequestMapping(value="/TibetPatentIcmAll")
	public String TibetPatentIcmAll(HttpServletRequest request) {

		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype");  
		String content = (String) request.getParameter("content");
		
		SolrQuery query = null;
		Tpatentbasicinfo patent = null;
		Collection<Tpatentbasicinfo> patentItems = new ArrayList<Tpatentbasicinfo>();
		SolrDocumentList patentResults = new SolrDocumentList();
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
 	    qr = "rightsType:tibetpatent AND patentIcm1:" + "\"" + content + "\"";		
		System.out.println(qr);
 		query = new SolrQuery(qr);
		query.setSortField("patentAd",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);		
		
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}		
		
		System.out.println("获取专利信息");

		patentResults = response.getResults();		
		if (patentResults.size() > 0) 
		{
			for (int i = 0; i < patentResults.size(); i++) 
			{
				patent = new Tpatentbasicinfo();
				SolrDocument patentdocument = patentResults.get(i);
                if(patentdocument.getFieldValue("patentAn")!=null)
                	patent.setPatentAn(patentdocument.getFieldValue("patentAn").toString());
                
                if(patentdocument.getFieldValue("patentTi")!=null)
				    patent.setPatentTi(patentdocument.getFieldValue("patentTi").toString());

                if(patentdocument.getFieldValue("patentId")!=null)
					patent.setId(Integer.parseInt(patentdocument.getFieldValue("patentId").toString()));

                if(patentdocument.getFieldValue("patentAds")!=null)
					patent.setPatentAd(patentdocument.getFieldValue("patentAds").toString());
                
                if(patentdocument.getFieldValue("patentFpa")!=null)
					patent.setPatentFpa(patentdocument.getFieldValue("patentFpa").toString());
                
                if(patentdocument.getFieldValue("patentIcm")!=null)
					patent.setPatentIcm(patentdocument.getFieldValue("patentIcm").toString());

                System.out.println(patent.getPatentTi());
        		patentItems.add(patent);
			}
		}		
		request.setAttribute("patentItems",patentItems);	
		request.setAttribute("totalcount", patentResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("content", content);	
 	
		return "unauth/display/tibetpatenticmall";
   }
	
	
	@RequestMapping(value = "/TibetPatentIcmDisplay")	
	public String PatentIcmDisplay(HttpServletRequest request, Model model) {

		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
		String icm = "";
		if(request.getParameter("content")!=null)
		   icm = request.getParameter("content");	
		
		SolrQuery query = null;
		Tpatentbasicinfo patent = null;
		Collection<Tpatentbasicinfo> patentItems = new ArrayList<Tpatentbasicinfo>();
		SolrDocumentList patentResults = new SolrDocumentList();
		
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
  	    qr = "rightsType:tibetpatent AND patentIcm1:" + "\"" + icm + "\""; 	
 		query = new SolrQuery(qr);
 		System.out.println(query);
	    query.setStart(start);
		query.setRows(perpage);
		query.setFacet(true);
		query.addFacetField("patentIcm1");
		query.setFacetSort("name");
	    
		QueryResponse response = null;

		try 
		{
			response = solrServer.query(query);
		} catch (SolrServerException e) 
		{
			e.printStackTrace();
		}	
		
		patentResults = response.getResults();		
		totalcount = (int)patentResults.getNumFound();
		System.out.println(totalcount);

		if (patentResults.size() > 0) 
		{
			for (int i = 0; i < patentResults.size(); i++) 
			{
				patent = new Tpatentbasicinfo();
				SolrDocument patentdocument = patentResults.get(i);
                if(patentdocument.getFieldValue("patentAn")!=null)
                	patent.setPatentAn(patentdocument.getFieldValue("patentAn").toString());
                
                if(patentdocument.getFieldValue("patentAds")!=null)
                	patent.setPatentAd(patentdocument.getFieldValue("patentAds").toString());
                
                if(patentdocument.getFieldValue("patentTi")!=null)
				    patent.setPatentTi(patentdocument.getFieldValue("patentTi").toString());
                
				if(patentdocument.getFieldValue("patentLspd")!=null)
					patent.setPatentLs(patentdocument.getFieldValue("patentLspd").toString());
				
				if(patentdocument.getFieldValue("patentIcm")!=null)
					patent.setPatentIcm(patentdocument.getFieldValue("patentIcm").toString());
				
				if(patentdocument.getFieldValue("patentId")!=null)
					patent.setId(Integer.parseInt(patentdocument.getFieldValue("patentId").toString()));
			
				System.out.println(patent.getPatentAn());
				patentItems.add(patent);
			}
		}
		docmentNum = (int) patentResults.getNumFound();
		if ((docmentNum % perpage) == 0)
			pagecount = docmentNum / perpage;
		else
			pagecount = docmentNum / perpage + 1;
		
		
		solrServer = new HttpSolrServer(DEFAULT_URL);
        qr = "rightsType:tibetpatent";
 		query = new SolrQuery(qr);
 		System.out.println(query);
	    query.setStart(start);
		query.setRows(perpage);
		query.setFacet(true);
		query.addFacetField("patentIcm1");
		query.setFacetSort("name");
	    
		response = null;
		try 
		{
			response = solrServer.query(query);
		} catch (SolrServerException e) 
		{
			e.printStackTrace();
		}	
		
		patentResults = response.getResults();		
		
		List<FacetField> facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("patentIcm1")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] icmfacet = new String[facetEntries.size()];
 			      Integer[] icmfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 icmfacet[m] = fcount.getName();					 
						 icmfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(icmfacet[m]);
					     m++;							     
					 }
				  }		
				  request.setAttribute("icmfacet", icmfacet);
				  request.setAttribute("icmfacetcount", icmfacetcount);
				}					
			  }
		   }	
		
		
		request.setAttribute("patentItems",patentItems);	
		request.setAttribute("totalcount", totalcount);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("content", icm);
		
		return "unauth/statistic/tibetpartmessge";
	}
	
	
	@RequestMapping(value = "/TibetPatentIcmpie")  
	public String Patenticmpie(HttpServletRequest request, Model model) {

		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
		
		SolrQuery query = null;
		Tpatentbasicinfo patent = null;
		Collection<Tpatentbasicinfo> patentItems = new ArrayList<Tpatentbasicinfo>();
		SolrDocumentList patentResults = new SolrDocumentList();
		
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
        qr = "rightsType:tibetpatent";
 		query = new SolrQuery(qr);
 		System.out.println(query);
	    query.setStart(start);
		query.setRows(perpage);
		query.setFacet(true);
		query.addFacetField("patentIcm1");
		query.setFacetSort("name");
	    
		QueryResponse response = null;

		try 
		{
			response = solrServer.query(query);
		} catch (SolrServerException e) 
		{
			e.printStackTrace();
		}	
		
		patentResults = response.getResults();		
		totalcount = (int)patentResults.getNumFound();

		
		List<FacetField> facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("patentIcm1")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] icmfacet = new String[facetEntries.size()];
 			      Integer[] icmfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 icmfacet[m] = fcount.getName();					 
						 icmfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(icmfacetcount[m]);
					     m++;							     
					 }
				  }		
				  request.setAttribute("icmfacet", icmfacet);
				  request.setAttribute("icmfacetcount", icmfacetcount);
				}					
			  }
		   }	
		
		
		if (patentResults.size() > 0) 
		{
			for (int i = 0; i < patentResults.size(); i++) 
			{
				patent = new Tpatentbasicinfo();
				SolrDocument patentdocument = patentResults.get(i);
                if(patentdocument.getFieldValue("patentAn")!=null)
                	patent.setPatentAn(patentdocument.getFieldValue("patentAn").toString());
                
                if(patentdocument.getFieldValue("patentAds")!=null)
                	patent.setPatentAd(patentdocument.getFieldValue("patentAds").toString());
                
                if(patentdocument.getFieldValue("patentTi")!=null)
				    patent.setPatentTi(patentdocument.getFieldValue("patentTi").toString());
                
				if(patentdocument.getFieldValue("patentLspd")!=null)
					patent.setPatentLs(patentdocument.getFieldValue("patentLspd").toString());
				
				if(patentdocument.getFieldValue("patentIcm")!=null)
					patent.setPatentIcm(patentdocument.getFieldValue("patentIcm").toString());
				
				if(patentdocument.getFieldValue("patentId")!=null)
					patent.setId(Integer.parseInt(patentdocument.getFieldValue("patentId").toString()));
			
				System.out.println(patent.getPatentAn());
				patentItems.add(patent);
			}
		}
		docmentNum = (int) patentResults.getNumFound();
		if ((docmentNum % perpage) == 0)
			pagecount = docmentNum / perpage;
		else
			pagecount = docmentNum / perpage + 1;
		
		request.setAttribute("patentItems",patentItems);	
		request.setAttribute("totalcount", patentResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		
		return "unauth/statistic/tibetpatenticmpie";
	}

	
	@RequestMapping(value="/TibetPatentFacetDisplay")
	public String TibetPatentFacetDisplay(HttpServletRequest request) {

		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
        String facet = (String) request.getParameter("facet"); 
		String content = (String) request.getParameter("content");
		
		SolrQuery query = null;
		Ttibet patent = null;
		Collection<Ttibet> patentItems = new ArrayList<Ttibet>();
		SolrDocumentList patentResults = new SolrDocumentList();
		
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
		if(facet.equals("patentad"))
 	       qr = "rightsType:tibetpatent AND patentAd:" + "\"" + content + "\"";
		else if(facet.equals("patenticm"))
		   qr = "rightsType:tibetpatent AND patentIcm1:" + "\"" + content + "\"";
		else if(facet.equals("patentinst"))
		   qr = "rightsType:tibetpatent AND patentFpaMul:" + "\"" + content + "\"";
		
		System.out.println(qr);
 		query = new SolrQuery(qr);
		query.setSortField("patentAd",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);		
		
		QueryResponse response = null;
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}		
		
		System.out.println("获取专利信息");

		patentResults = response.getResults();		
		if (patentResults.size() > 0) 
		{
			for (int i = 0; i < patentResults.size(); i++) 
			{
				patent = new Ttibet();
				SolrDocument patentdocument = patentResults.get(i);
                if(patentdocument.getFieldValue("patentAn")!=null)
                	patent.setPatentAn(patentdocument.getFieldValue("patentAn").toString());
                
                if(patentdocument.getFieldValue("patentTi")!=null)
				    patent.setPatentTi(patentdocument.getFieldValue("patentTi").toString());

                if(patentdocument.getFieldValue("patentId")!=null)
					patent.setId(Integer.parseInt(patentdocument.getFieldValue("patentId").toString()));

                if(patentdocument.getFieldValue("patentAds")!=null)
					patent.setPatentAd(patentdocument.getFieldValue("patentAds").toString());
                
                if(patentdocument.getFieldValue("patentFpa")!=null)
					patent.setPatentFpa(patentdocument.getFieldValue("patentFpa").toString());
                
                if(patentdocument.getFieldValue("patentIcm")!=null)
					patent.setPatentIcm(patentdocument.getFieldValue("patentIcm").toString());

                System.out.println(patent.getPatentTi());
        		if(facet.equals("patentad"))
        			System.out.println(patent.getPatentAd());
       			else if(facet.equals("patenticm"))
       				System.out.println(patent.getPatentIcm());
       			else if(facet.equals("patentinst"))
       				System.out.println(patent.getPatentFpa());

        		patentItems.add(patent);
			}
		}		
		request.setAttribute("patentItems",patentItems);	
		request.setAttribute("totalcount", patentResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("facet", facet);
		request.setAttribute("content", content);	
 	
		return "unauth/facetdisplay/tibetpatentfacetdisplay";
   }
	
	
	@RequestMapping(value="/TibetPatentdisplay")
	public String PatentFacetDisplay(HttpServletRequest request) {
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
		
		SolrQuery query = null;
		Ttibet patent = null;
		Collection<Ttibet> patentItems = new ArrayList<Ttibet>();
		SolrDocumentList patentResults = new SolrDocumentList();
		
		String qr = null;
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

		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:tibetpatent";
 		query = new SolrQuery(qr);
		query.setSortField("patentAd",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);
		        
		query.setFacet(true);
		query.addFacetField("patentAd","patentFpaMul","patentType","patentIcm1");
		query.setFacetMinCount(1);
		query.setFacetSort("count");
		query.setFacetLimit(100);

		QueryResponse response = null;
		Calendar c1 = Calendar.getInstance();
		try {
			response = solrServer.query(query);
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
	
		
		patentResults = response.getResults();		
		totalcount = (int)patentResults.getNumFound();
		List<FacetField> facets = response.getFacetFields();
		
		for (FacetField facet : facets) 
		{
			if (facet.getName().equals("patentAd")) 
			{				
				List<FacetField.Count> facetEntries = facet.getValues();
				if(facetEntries!=null)
				{
				String[] adfacet = new String[facetEntries.size()];
				Integer[] adfacetcount = new Integer[facetEntries.size()];

				int i = 0;
				for (FacetField.Count fcount : facetEntries) 
				{
					adfacet[i] = fcount.getName();
					adfacetcount[i] = Integer.parseInt(String.valueOf(fcount.getCount()));
					System.out.println("adfacet[" + i + "]" + adfacet[i]);
					//fail("monthfacetcount[" + i + "]" + monthfacetcount[i]);
					i++;
				}  // end of for
				request.setAttribute("adfacet", adfacet);
				request.setAttribute("adfacetcount", adfacetcount);
			  }
			} // end of if
			
			if (facet.getName().equals("patentFpaMul")) 
			{				
				List<FacetField.Count> facetEntries = facet.getValues();
				if(facetEntries!=null)
				{
				String[] fpafacet = new String[facetEntries.size()];
				Integer[] fpafacetcount = new Integer[facetEntries.size()];

				int i = 0;
				for (FacetField.Count fcount : facetEntries) 
				{
					fpafacet[i] = fcount.getName();
					fpafacetcount[i] = Integer.parseInt(String.valueOf(fcount.getCount()));
					System.out.println("fpafacet[" + i + "]" + fpafacet[i]);
					//fail("monthfacetcount[" + i + "]" + monthfacetcount[i]);
					i++;
				}  // end of for
				request.setAttribute("fpafacet", fpafacet);
				request.setAttribute("fpafacetcount", fpafacetcount);
			  }
			} // end of if
			
			if (facet.getName().equals("patentType")) 
			{				
				System.out.println("111");
				List<FacetField.Count> facetEntries = facet.getValues();
				if(facetEntries!=null)
				{
				String[] typefacet = new String[facetEntries.size()];
				Integer[] typefacetcount = new Integer[facetEntries.size()];

				int i = 0;
				for (FacetField.Count fcount : facetEntries) 
				{
					typefacet[i] = fcount.getName();
					typefacetcount[i] = Integer.parseInt(String.valueOf(fcount.getCount()));
					System.out.println("typefacet[" + i + "]" + typefacet[i]);
					//fail("monthfacetcount[" + i + "]" + monthfacetcount[i]);
					i++;
				}  // end of for
				request.setAttribute("typefacet", typefacet);
				request.setAttribute("typefacetcount", typefacetcount);
			  }
			} // end of if

			if (facet.getName().equals("patentIcm1")) 
			{				
				System.out.println("111");
				List<FacetField.Count> facetEntries = facet.getValues();
				if(facetEntries!=null)
				{
				String[] icmfacet = new String[facetEntries.size()];
				Integer[] icmfacetcount = new Integer[facetEntries.size()];

				int i = 0;
				for (FacetField.Count fcount : facetEntries) 
				{
					icmfacet[i] = fcount.getName();
					icmfacetcount[i] = Integer.parseInt(String.valueOf(fcount.getCount()));
					System.out.println("icmfacet[" + i + "]" + icmfacet[i]);
					//fail("monthfacetcount[" + i + "]" + monthfacetcount[i]);
					i++;
				}  // end of for
				request.setAttribute("icmfacet", icmfacet);
				request.setAttribute("icmfacetcount", icmfacetcount);
			  }
			} // end of if

		}
		
		if (patentResults.size() > 0) 
		{
			for (int i = 0; i < patentResults.size(); i++) 
			{
				patent = new Ttibet();
				SolrDocument patentdocument = patentResults.get(i);
                if(patentdocument.getFieldValue("patentAn")!=null)
                	patent.setPatentAn(patentdocument.getFieldValue("patentAn").toString());
                
                if(patentdocument.getFieldValue("patentAds")!=null)
                	patent.setPatentAd(patentdocument.getFieldValue("patentAds").toString());
                
                if(patentdocument.getFieldValue("patentTi")!=null)
				    patent.setPatentTi(patentdocument.getFieldValue("patentTi").toString());
                
				if(patentdocument.getFieldValue("patentLspd")!=null)
					patent.setPatentLs(patentdocument.getFieldValue("patentLspd").toString());
				
				if(patentdocument.getFieldValue("patentIcm")!=null)
					patent.setPatentIcm(patentdocument.getFieldValue("patentIcm").toString());
				
				if(patentdocument.getFieldValue("patentId")!=null)
					patent.setId(Integer.parseInt(patentdocument.getFieldValue("patentId").toString()));
			
				System.out.println(patent.getPatentAn());
				patentItems.add(patent);
			}
		}
		docmentNum = (int) patentResults.getNumFound();
		if ((docmentNum % perpage) == 0)
			pagecount = docmentNum / perpage;
		else
			pagecount = docmentNum / perpage + 1;
		
		request.setAttribute("patentItems",patentItems);	
		request.setAttribute("totalcount", patentResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("searchtime", searchtime);
	
		return "unauth/display/tibetpatentdisplay";
	}
	
}
