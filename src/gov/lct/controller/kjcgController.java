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
import gov.lct.service.TkjcgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class kjcgController {
	@Autowired	
	private TkjcgService tkjcgService;	
	private SolrServer solrServer;
	private static final String DEFAULT_URL = "http://or.clas.ac.cn/solr/";
	
	@RequestMapping(value = "/KjcgAllInstDisplay")  
	public String KjcgAllInstDisplay(HttpServletRequest request, Model model) {

		SolrQuery query = null;
		String qr = null;
		QueryResponse response = null;
		int start = 0;
		int perpage = 50;
		
		//获取科技成果信息
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:kjcg NOT kjcgInst:中国科学院云南天文台";
 		query = new SolrQuery(qr);
 		query.setSortField("kjcgYear",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);
		query.addFacetField("kjcgInst");
		query.setFacetSort("count");
		query.setFacetLimit(500);

		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}		
		
		System.out.println("获取科技成果信息");
		
		List<FacetField> facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("kjcgInst")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] instfacet = new String[facetEntries.size()];
 			      Integer[] instfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null && fcount.getName().trim().length()>5)
					 {
						 instfacet[m] = fcount.getName();					 
						 instfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(instfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("instfacet", instfacet);
				  request.setAttribute("instfacetcount", instfacetcount);
				}					
		     }	
		 }	
		
		return "unauth/display/kjcgallinst";
	}	
	
	@RequestMapping(value = "/KjcgAllProvDisplay")  
	public String KjcgAllProvDisplay(HttpServletRequest request, Model model) {

		SolrQuery query = null;
		String qr = null;
		QueryResponse response = null;
		int start = 0;
		int perpage = 50;
		
		Collection<Tkjcg> kjcgItems = new ArrayList<Tkjcg>();
		SolrDocumentList kjcgResults = new SolrDocumentList();
		Tkjcg kjcg = null;	
		
		//获取科技成果信息
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:kjcg NOT kjcgInst:中国科学院云南天文台";
 		query = new SolrQuery(qr);
 		query.setSortField("kjcgYear",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);
		//query.addFacetField("kjcgInst","kjcgProv");
		query.addFacetField("kjcgProv");
		query.setFacetSort("count");
		query.setFacetLimit(50);

		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}		
		
		System.out.println("获取科技成果信息");
		
		List<FacetField> facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("kjcgProv")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] provfacet = new String[facetEntries.size()];
 			      Integer[] provfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null && fcount.getName().trim()!="")
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
		
		return "unauth/display/kjcgallprov";
	}
		
	@RequestMapping(value = "/KjcgFacetDisplay")  
	public String KjcgFacetDisplay(HttpServletRequest request, Model model) {

		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 
        String facet = (String) request.getParameter("facet"); 
		String content = (String) request.getParameter("content");
		String term = (String) request.getParameter("term"); 
		
		SolrQuery query = null;
		Tkjcg kjcg = null;
		Collection<Tkjcg> kjcgItems = new ArrayList<Tkjcg>();
		SolrDocumentList kjcgResults = new SolrDocumentList();
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
		if(facet.equals("kjcgyear"))
 	       qr = "rightsType:kjcg NOT kjcgInst:中国科学院云南天文台  AND item_121:" + "\"" + content + "\"";
		else if(facet.equals("kjcgprov"))
		   qr = "rightsType:kjcg NOT kjcgInst:中国科学院云南天文台   AND kjcgProv:" + "\"" + content + "\"";
		else if(facet.equals("kjcginst"))
		   qr = "rightsType:kjcg NOT kjcgInst:中国科学院云南天文台   AND kjcgInst:" + "\"" + content + "\"";
		
 		query = new SolrQuery(qr);
		query.setSortField("item_121",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);		
		
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}		
		
		System.out.println("获取科技成果信息");		
	
		kjcgResults = response.getResults();		
		if (kjcgResults.size() > 0) 
		{
			for (int i = 0; i < kjcgResults.size(); i++) 
			{
				kjcg = new Tkjcg();
				SolrDocument kjcgdocument = kjcgResults.get(i);
                if(kjcgdocument.getFieldValue("kjcgName")!=null)
                	kjcg.setITEM_3(kjcgdocument.getFieldValue("kjcgName").toString());
                
                if(kjcgdocument.getFieldValue("kjcgId")!=null)
                	kjcg.setId(Integer.parseInt(kjcgdocument.getFieldValue("kjcgId").toString()));
                
                if(kjcgdocument.getFieldValue("kjcgKeywords")!=null)
                	kjcg.setITEM_14(kjcgdocument.getFieldValue("kjcgKeywords").toString());
                
				if(kjcgdocument.getFieldValue("kjcgInst")!=null)
					kjcg.setITEM_9(kjcgdocument.getFieldValue("kjcgInst").toString());
				
				if(kjcgdocument.getFieldValue("kjcgYear")!=null)
					kjcg.setKjcgtime(kjcgdocument.getFieldValue("kjcgYear").toString());
										
				if(kjcgdocument.getFieldValue("kjcgfinishperson")!=null)
					kjcg.setKjcgfinishperson(kjcgdocument.getFieldValue("kjcgfinishperson").toString());
				
				
				System.out.println(kjcg.getITEM_3());
				System.out.println(kjcg.getITEM_9());
				kjcgItems.add(kjcg);
			}
		}

		request.setAttribute("kjcgItems",kjcgItems);	
		request.setAttribute("totalcount", kjcgResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("facet", facet);
		request.setAttribute("content", content);			
			
		return "unauth/facetdisplay/kjcgfacetdisplay";
	}
	
	   //科技成果浏览 或者首页更多科技成果
	@RequestMapping(value = "/KjcgInstdisplay")  
	public String KjcgInstdisplay(HttpServletRequest request, Model model) {
				
		SolrQuery query = null;
		Tkjcg kjcg = null;
		Collection<Tkjcg> kjcgItems = new ArrayList<Tkjcg>();
		SolrDocumentList kjcgResults = new SolrDocumentList();
		
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
 	    qr = "rightsType:kjcg NOT kjcgInst:中国科学院云南天文台 AND kjcgInst:" + "\"" + inst + "\"";
 		query = new SolrQuery(qr);
	    query.setStart(start);
		query.setRows(perpage);
		
 		query.setFacet(true);
		query.addFacetField("kjcgInst");
		query.setFacetSort("count");
		query.setFacetLimit(40);

		QueryResponse response = null;
		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
		List<FacetField> facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("kjcgInst")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] instfacet = new String[facetEntries.size()];
 			      Integer[] instfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null && fcount.getName().length()>3)
					 {
						 instfacet[m] = fcount.getName().trim();					 
						 instfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 //System.out.println(instfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("instfacet", instfacet);
				  request.setAttribute("instfacetcount", instfacetcount);
				}					
			  }		   
		   }			
		
		kjcgResults = response.getResults();		
		if (kjcgResults.size() > 0) 
		{
			for (int i = 0; i < kjcgResults.size(); i++) 
			{
				kjcg = new Tkjcg();
				SolrDocument kjcgdocument = kjcgResults.get(i);
                if(kjcgdocument.getFieldValue("kjcgName")!=null)
                	kjcg.setITEM_3(kjcgdocument.getFieldValue("kjcgName").toString());
                
                if(kjcgdocument.getFieldValue("kjcgId")!=null)
                	kjcg.setId(Integer.parseInt(kjcgdocument.getFieldValue("kjcgId").toString()));
                
                if(kjcgdocument.getFieldValue("kjcgKeywords")!=null)
                	kjcg.setITEM_14(kjcgdocument.getFieldValue("kjcgKeywords").toString());
                
				if(kjcgdocument.getFieldValue("kjcgInst")!=null)
					kjcg.setITEM_9(kjcgdocument.getFieldValue("kjcgInst").toString());
				
				if(kjcgdocument.getFieldValue("kjcgYear")!=null)
					kjcg.setKjcgtime(kjcgdocument.getFieldValue("kjcgYear").toString());
										
				if(kjcgdocument.getFieldValue("kjcgfinishperson")!=null)
					kjcg.setKjcgfinishperson(kjcgdocument.getFieldValue("kjcgfinishperson").toString());
				
				
				System.out.println(kjcg.getITEM_3());
				System.out.println(kjcg.getITEM_9());
				kjcgItems.add(kjcg);
			}
		}
		
		request.setAttribute("kjcgItems",kjcgItems);	
		request.setAttribute("totalcount", kjcgResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("inst", inst);

       return "unauth/display/kjcginstdisplay";	
	}
	
    //科技成果所属省份浏览
	@RequestMapping(value = "/KjcgProvdisplay")  
	public String KjcgProvdisplay(HttpServletRequest request, Model model) {
				
		SolrQuery query = null;
		Tkjcg kjcg = null;
		Collection<Tkjcg> kjcgItems = new ArrayList<Tkjcg>();
		SolrDocumentList kjcgResults = new SolrDocumentList();
		
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
 	    qr = "rightsType:kjcg NOT kjcgInst:中国科学院云南天文台 AND kjcgProv:" + "\"" + prov + "\"";
 		query = new SolrQuery(qr);
	    query.setStart(start);
		query.setRows(perpage);
		
 		query.setFacet(true);
		query.addFacetField("kjcgProv");
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
		   if (facet.getName().equals("kjcgProv")) 
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
		
		kjcgResults = response.getResults();		
		if (kjcgResults.size() > 0) 
		{
			for (int i = 0; i < kjcgResults.size(); i++) 
			{
				kjcg = new Tkjcg();
				SolrDocument kjcgdocument = kjcgResults.get(i);
                if(kjcgdocument.getFieldValue("kjcgName")!=null)
                	kjcg.setITEM_3(kjcgdocument.getFieldValue("kjcgName").toString());
                
                if(kjcgdocument.getFieldValue("kjcgId")!=null)
                	kjcg.setId(Integer.parseInt(kjcgdocument.getFieldValue("kjcgId").toString()));
                
                if(kjcgdocument.getFieldValue("kjcgKeywords")!=null)
                	kjcg.setITEM_14(kjcgdocument.getFieldValue("kjcgKeywords").toString());
                
				if(kjcgdocument.getFieldValue("kjcgInst")!=null)
					kjcg.setITEM_9(kjcgdocument.getFieldValue("kjcgInst").toString());
				
				if(kjcgdocument.getFieldValue("kjcgYear")!=null)
					kjcg.setKjcgtime(kjcgdocument.getFieldValue("kjcgYear").toString());
										
				System.out.println(kjcg.getITEM_3());
				System.out.println(kjcg.getITEM_9());
				kjcgItems.add(kjcg);
			}
		}
		
		request.setAttribute("kjcgItems",kjcgItems);	
		request.setAttribute("totalcount", kjcgResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		
       return "unauth/display/kjcgprovdisplay";	
	}
	
    //科技成果浏览 或者首页更多科技成果
	@RequestMapping(value = "/Kjcgdisplay")  
	public String Kjcgdisplay(HttpServletRequest request, Model model) {
				
		SolrQuery query = null;
		Tkjcg kjcg = null;
		Collection<Tkjcg> kjcgItems = new ArrayList<Tkjcg>();
		SolrDocumentList kjcgResults = new SolrDocumentList();
		
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 

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
	
 		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:kjcg NOT kjcgInst:中国科学院云南天文台";
 		query = new SolrQuery(qr);
 		query.setSortField("kjcgProv", org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);

 		query.setFacet(true);
		query.addFacetField("kjcgInst","kjcgProv", "item_121");
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
		   if (facet.getName().equals("kjcgInst")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] instfacet = new String[facetEntries.size()];
 			      Integer[] instfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 instfacet[m] = fcount.getName();					 
						 instfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(instfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("instfacet", instfacet);
				  request.setAttribute("instfacetcount", instfacetcount);
				}					
			  }
		   
		   if (facet.getName().equals("kjcgProv")) 
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

		   if (facet.getName().equals("item_121")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] yearfacet = new String[facetEntries.size()];
 			      Integer[] yearfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 yearfacet[m] = fcount.getName();					 
						 yearfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(yearfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("yearfacet", yearfacet);
				  request.setAttribute("yearfacetcount", yearfacetcount);
				}					
			  }			   
		   }	
		
		
		kjcgResults = response.getResults();		
		if (kjcgResults.size() > 0) 
		{
			for (int i = 0; i < kjcgResults.size(); i++) 
			{
				kjcg = new Tkjcg();
				SolrDocument kjcgdocument = kjcgResults.get(i);
                if(kjcgdocument.getFieldValue("kjcgName")!=null)
                	kjcg.setITEM_3(kjcgdocument.getFieldValue("kjcgName").toString());
                
                if(kjcgdocument.getFieldValue("kjcgId")!=null)
                	kjcg.setId(Integer.parseInt(kjcgdocument.getFieldValue("kjcgId").toString()));
                
                if(kjcgdocument.getFieldValue("kjcgKeywords")!=null)
                	kjcg.setITEM_14(kjcgdocument.getFieldValue("kjcgKeywords").toString());
                
				if(kjcgdocument.getFieldValue("kjcgInst")!=null)
					kjcg.setITEM_9(kjcgdocument.getFieldValue("kjcgInst").toString());
				
				if(kjcgdocument.getFieldValue("kjcgYear")!=null)
					kjcg.setKjcgtime(kjcgdocument.getFieldValue("kjcgYear").toString());
										
				System.out.println(kjcg.getITEM_3());
				System.out.println(kjcg.getITEM_9());
				kjcgItems.add(kjcg);
			}
		}
		
		request.setAttribute("kjcgItems",kjcgItems);	
		request.setAttribute("totalcount", kjcgResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);
		
       return "unauth/display/kjcgdisplay";	
	}
	
	
	@RequestMapping(value="/kjcgdetail")
	public String patentdetail(HttpServletRequest request) {
		
		SolrQuery query = null;
		Tkjcg kjcg = null;
		Collection<Tkjcg> kjcgItems = new ArrayList<Tkjcg>();
		SolrDocumentList kjcgResults = new SolrDocumentList();
        String kjcgid = request.getParameter("kjcgid");
		
		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:kjcg AND kjcgId:" + kjcgid;
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
		
		kjcgResults = confresponse.getResults();		
		if (kjcgResults.size() > 0) 
		{
			for (int i = 0; i < kjcgResults.size(); i++) 
			{
				kjcg = new Tkjcg();
				SolrDocument kjcgdocument = kjcgResults.get(i);
                if(kjcgdocument.getFieldValue("kjcgId")!=null)
                	kjcg.setId(Integer.parseInt(kjcgdocument.getFieldValue("kjcgId").toString()));
                
                if(kjcgdocument.getFieldValue("kjcgName")!=null)
                	kjcg.setITEM_3(kjcgdocument.getFieldValue("kjcgName").toString());
                
                if(kjcgdocument.getFieldValue("kjcgKeywords")!=null)
				    kjcg.setITEM_14(kjcgdocument.getFieldValue("kjcgKeywords").toString());
                
                
                if(kjcgdocument.getFieldValue("kjcgFinishPerson")!=null)
                	kjcg.setKjcgfinishperson(kjcgdocument.getFieldValue("kjcgFinishPerson").toString());
                
                if(kjcgdocument.getFieldValue("kjcgZt")!=null)
				    kjcg.setITEM_12(kjcgdocument.getFieldValue("kjcgZt").toString());

                if(kjcgdocument.getFieldValue("kjcgApp")!=null)
                	kjcg.setITEM_125(kjcgdocument.getFieldValue("kjcgApp").toString());
                
                if(kjcgdocument.getFieldValue("kjcgYear")!=null)
				    kjcg.setKjcgtime(kjcgdocument.getFieldValue("kjcgYear").toString());

                if(kjcgdocument.getFieldValue("kjcgType")!=null)
                	kjcg.setKjcgtype(kjcgdocument.getFieldValue("kjcgType").toString());
                
                if(kjcgdocument.getFieldValue("kjcgFruit")!=null)
				    kjcg.setITEM_13(kjcgdocument.getFieldValue("kjcgFruit").toString());

                if(kjcgdocument.getFieldValue("kjcgInst")!=null)
				    kjcg.setITEM_9(kjcgdocument.getFieldValue("kjcgInst").toString());
                
                if(kjcgdocument.getFieldValue("kjcgSource")!=null)
				    kjcg.setKjcgsource(kjcgdocument.getFieldValue("kjcgSource").toString());
                

				System.out.println(kjcg.getITEM_3());
				System.out.println(kjcg.getITEM_9());
				kjcgItems.add(kjcg);
			}
		}
		
		request.setAttribute("kjcgItems",kjcgItems);	
		request.setAttribute("searchtime", searchtime);
		
		return "unauth/detail/kjcgdetail";
	}
	
}