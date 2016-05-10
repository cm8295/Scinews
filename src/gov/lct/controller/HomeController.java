package gov.lct.controller;

import java.io.IOException;
import java.net.URLDecoder;
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
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import gov.lct.model.Tpatentbasicinfo;
import gov.lct.service.TpatentbasicinfoService;
import gov.lct.model.Ttibet;
import gov.lct.service.TtibetService;
import gov.lct.model.Tkjcg;
import gov.lct.service.TkjcgService;
import gov.lct.model.Texperts;
import gov.lct.service.TexpertsService;
import gov.lct.model.Tpolice;
import gov.lct.service.TpoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @date 2015-05-06
 * solr管理程序
 */
@Controller
public class HomeController {
	@Autowired
	private TpatentbasicinfoService tpatentbasicinfoService;
	@Autowired
	private TkjcgService tkjcgService;
	@Autowired
	private TexpertsService texpertsService;
	@Autowired
	private TpoliceService tpoliceService;
	@Autowired
	private TtibetService tibetService;
	
	
	private SolrServer solrServer;
	private static final String DEFAULT_URL = "http://or.clas.ac.cn/solr/";
		
	// 首页检索	
	@RequestMapping(value="/QuickSearch")
	public String QuickSearch(HttpServletRequest request) throws Exception {

		SolrQuery query = null;
		String qr = null;
		QueryResponse response = null;
		
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype");
		String resourcetype = (String) request.getParameter("resourcetype");
		String term = (String) request.getParameter("term");
		

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
			 
		Collection<Tpatentbasicinfo> patentItems = new ArrayList<Tpatentbasicinfo>();
		SolrDocumentList patentResults = new SolrDocumentList();
		Tpatentbasicinfo patent = null;
		
		Collection<Tkjcg> kjcgItems = new ArrayList<Tkjcg>();
		SolrDocumentList kjcgResults = new SolrDocumentList();
		Tkjcg kjcg = null;
		
		Collection<Texperts> expertItems = new ArrayList<Texperts>();
		SolrDocumentList expertResults = new SolrDocumentList();
		Texperts expert = null;
		
     
	//专利信息
     if(resourcetype.equals("patent"))
     {     			
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:patent AND (patentAn:" + term + " OR patentTi:" + term + ")";
 		query = new SolrQuery(qr);
 		query.setSortField("patentAd",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);
		        
		query.setFacet(true);
		query.addFacetField("patentFpaMul","patentIcm1","patentAd");
		query.setFacetSort("count");
		query.setFacetLimit(50);

		try {
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}		
		
		System.out.println("获取专利信息");
		
		List<FacetField> facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("patentFpaMul")) 
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
		   
		   if (facet.getName().equals("patentAd")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] adfacet = new String[facetEntries.size()];
 			      Integer[] adfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 adfacet[m] = fcount.getName();					 
						 adfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(adfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("adfacet", adfacet);
				  request.setAttribute("adfacetcount", adfacetcount);
				}					
		     }		   
		 }
					
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

                if(patentdocument.getFieldValue("patentAd")!=null)
					patent.setPatentAd(patentdocument.getFieldValue("patentAd").toString());
                
                if(patentdocument.getFieldValue("patentFpa")!=null)
					patent.setPatentFpa(patentdocument.getFieldValue("patentFpa").toString());
                
                if(patentdocument.getFieldValue("patentIcm")!=null)
					patent.setPatentIcm(patentdocument.getFieldValue("patentIcm").toString());

                System.out.println(patent.getPatentTi());
				patentItems.add(patent);
			}
		}		
		request.setAttribute("patentItems",patentItems);	
	}
		
          
	//获取科技成果信息
     if(resourcetype.equals("kjcg"))
     {     			     
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:kjcg AND (kjcgName:" + term + " OR kjcgInst:" + term + ")";
 		query = new SolrQuery(qr);
 		query.setSortField("kjcgYear",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);
		query.setFacet(true);
		query.addFacetField("kjcgInst","kjcgProv","item_34");
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
		   
		   if (facet.getName().equals("item_34")) 
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
                
				if(kjcgdocument.getFieldValue("kjcgInst")!=null)
					kjcg.setITEM_9(kjcgdocument.getFieldValue("kjcgInst").toString());

				if(kjcgdocument.getFieldValue("kjcgKeywords")!=null)
					kjcg.setITEM_14(kjcgdocument.getFieldValue("kjcgKeywords").toString());
								
				System.out.println(kjcg.getITEM_3());
				System.out.println(kjcg.getITEM_9());
				kjcgItems.add(kjcg);
			}
		}		
		request.setAttribute("kjcgItems",kjcgItems);	
     }
     
     
	//获取专家信息
     if(resourcetype.equals("expert"))
     {     			   
 		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:expert AND (expnameText:" + term + " OR expdomain:" + term + " OR expwork1:" + term + ")";
 		query = new SolrQuery(qr);
 		query.setSortField("kjcgYear",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);
		query.setFacet(true);
		query.addFacetField("expprovince","expwork1","expxknameMul");
		query.setFacetSort("count");
		query.setFacetLimit(50);
		
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
 			      String[] exprovfacet = new String[facetEntries.size()];
 			      Integer[] exprovfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 exprovfacet[m] = fcount.getName();					 
						 exprovfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(exprovfacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("exprovfacet", exprovfacet);
				  request.setAttribute("exprovfacetcount", exprovfacetcount);
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
                if(expertdocument.getFieldValue("expid")!=null)
                	expert.setId(Integer.parseInt(expertdocument.getFieldValue("expid").toString()));
                
                if(expertdocument.getFieldValue("expname")!=null)
                	expert.setExpname(expertdocument.getFieldValue("expname").toString());
                
                if(expertdocument.getFieldValue("expdomain")!=null)
				    expert.setExpdomain(expertdocument.getFieldValue("expdomain").toString());

                if(expertdocument.getFieldValue("expprovince")!=null)
				    expert.setExpprovince(expertdocument.getFieldValue("expprovince").toString());
                
                if(expertdocument.getFieldValue("expwork1")!=null)
				    expert.setExpwork(expertdocument.getFieldValue("expwork1").toString());

                if(expertdocument.getFieldValue("expxkname")!=null)
				    expert.setExpxkname(expertdocument.getFieldValue("expxkname").toString());

                
                System.out.println(expert.getExpname());
				System.out.println(expert.getExpdomain());
				System.out.println(expert.getExparea());
				expertItems.add(expert);
			}
		}		
		request.setAttribute("expertItems",expertItems);
     }
     
          
 	//获取科技成果信息
     if(resourcetype.equals("ALL"))
     {     			
    		//专利信息
    		solrServer = new HttpSolrServer(DEFAULT_URL);
     	    qr = "rightsType:patent AND (patentAn:" + term + " OR patentTi:" + term + ")";
     		query = new SolrQuery(qr);
     		query.setSortField("patentAd",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
    	    query.setStart(start);
    		query.setRows(perpage);
    		        
    		query.setFacet(true);
    		query.addFacetField("patentFpaMul","patentIcm1","patentAd");
    		query.setFacetSort("count");
    		query.setFacetLimit(50);

    		try {
    			response = solrServer.query(query);
    		} catch (SolrServerException e) {
    			e.printStackTrace();
    		}		
    		
    		System.out.println("获取专利信息");
    		
    		List<FacetField> facets = response.getFacetFields();		
    		for (FacetField facet : facets) 
    		{
    		   if (facet.getName().equals("patentFpaMul")) 
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
    		   
    		   if (facet.getName().equals("patentAd")) 
    		   {
    			  List<FacetField.Count> facetEntries = facet.getValues();
    			  if(facetEntries!=null)
    			  {
     			      String[] adfacet = new String[facetEntries.size()];
     			      Integer[] adfacetcount = new Integer[facetEntries.size()];
    				  int m = 0;
    				  for (FacetField.Count fcount : facetEntries) 
    				  {
    					 if(fcount.getName()!=null)
    					 {
    						 adfacet[m] = fcount.getName();					 
    						 adfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
    						 System.out.println(adfacet[m]);
    					     m++;							     
    					 }
    				  }				  			  
    				  request.setAttribute("adfacet", adfacet);
    				  request.setAttribute("adfacetcount", adfacetcount);
    				}					
    		     }		   
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

                    if(patentdocument.getFieldValue("patentAd")!=null)
    					patent.setPatentAd(patentdocument.getFieldValue("patentAd").toString());
                    
                    System.out.println(patent.getPatentTi());
    				patentItems.add(patent);
    			}
    		}		
    		request.setAttribute("patentItems",patentItems);	
    		
              
    	//获取科技成果信息
    		solrServer = new HttpSolrServer(DEFAULT_URL);
     	    qr = "rightsType:kjcg AND (kjcgName:" + term + " OR kjcgInst:" + term + ")";
     		query = new SolrQuery(qr);
     		query.setSortField("kjcgYear",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
    	    query.setStart(start);
    		query.setRows(perpage);
    		query.setFacet(true);
    		query.addFacetField("kjcgInst","kjcgProv","item_34");
    		query.setFacetSort("count");
    		query.setFacetLimit(50);

    		try {
    			response = solrServer.query(query);
    		} catch (SolrServerException e) {
    			e.printStackTrace();
    		}		
    		
    		System.out.println("获取科技成果信息");
    		
    		facets = response.getFacetFields();		
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
    		   
    		   if (facet.getName().equals("item_34")) 
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
                    
    				if(kjcgdocument.getFieldValue("kjcgInst")!=null)
    					kjcg.setITEM_9(kjcgdocument.getFieldValue("kjcgInst").toString());

    				if(kjcgdocument.getFieldValue("kjcgKeywords")!=null)
    					kjcg.setITEM_14(kjcgdocument.getFieldValue("kjcgKeywords").toString());
    								
    				System.out.println(kjcg.getITEM_3());
    				System.out.println(kjcg.getITEM_9());
    				kjcgItems.add(kjcg);
    			}
    		}		
    		request.setAttribute("kjcgItems",kjcgItems);	

          
    	//获取专家信息
     	    qr = "rightsType:expert AND (expname:" + term + " OR expdomain:" + term + " OR expwork1:" + term + ")";
     		query = new SolrQuery(qr);
     		query.setSortField("kjcgYear",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
    	    query.setStart(start);
    		query.setRows(perpage);
    		
    		query.setFacet(true);
    		query.addFacetField("expprovince","expwork1","expxkname");
    		query.setFacetSort("count");
    		query.setFacetLimit(50);
    		
    		try {
    			response = solrServer.query(query);
    		} catch (SolrServerException e) {
    			
    			e.printStackTrace();
    		}
    				
    		System.out.println("获取专家信息");

    		facets = response.getFacetFields();		
    		for (FacetField facet : facets) 
    		{
    		   if (facet.getName().equals("expprovince")) 
    		   {
    			  List<FacetField.Count> facetEntries = facet.getValues();
    			  if(facetEntries!=null)
    			  {
     			      String[] exprovfacet = new String[facetEntries.size()];
     			      Integer[] exprovfacetcount = new Integer[facetEntries.size()];
    				  int m = 0;
    				  for (FacetField.Count fcount : facetEntries) 
    				  {
    					 if(fcount.getName()!=null)
    					 {
    						 exprovfacet[m] = fcount.getName();					 
    						 exprovfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
    						 System.out.println(exprovfacet[m]);
    					     m++;							     
    					 }
    				  }				  			  
    				  request.setAttribute("exprovfacet", exprovfacet);
    				  request.setAttribute("exprovfacetcount", exprovfacetcount);
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
    		   
    		   if (facet.getName().equals("expxkname")) 
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
                    if(expertdocument.getFieldValue("expid")!=null)
                    	expert.setId(Integer.parseInt(expertdocument.getFieldValue("expid").toString()));
                    
                    if(expertdocument.getFieldValue("expname")!=null)
                    	expert.setExpname(expertdocument.getFieldValue("expname").toString());
                    
                    if(expertdocument.getFieldValue("expdomain")!=null)
    				    expert.setExpdomain(expertdocument.getFieldValue("expdomain").toString());

                    if(expertdocument.getFieldValue("expprovince")!=null)
    				    expert.setExpprovince(expertdocument.getFieldValue("expprovince").toString());
                    
                    if(expertdocument.getFieldValue("expwork1")!=null)
    				    expert.setExpwork(expertdocument.getFieldValue("expwork1").toString());

                    if(expertdocument.getFieldValue("expxkname")!=null)
    				    expert.setExpxkname(expertdocument.getFieldValue("expxkname").toString());

                    
                    System.out.println(expert.getExpname());
    				System.out.println(expert.getExpdomain());
    				System.out.println(expert.getExparea());
    				expertItems.add(expert);
    			}
    		}		
    		request.setAttribute("expertItems",expertItems);
     }
     
	  request.setAttribute("resourcetype",resourcetype);
	  request.setAttribute("term",term);
	  request.setAttribute("totalcount", kjcgResults.getNumFound());
	  request.setAttribute("pagecount", pagecount);
	  request.setAttribute("currentpage", currentpage);
      
	  if(resourcetype.equals("patent"))
	    return "unauth/search/patentsearchresult";
      if(resourcetype.equals("kjcg"))
  	    return "unauth/search/kjcgsearchresult";
      if(resourcetype.equals("expert"))
  	    return "unauth/search/expertsearchresult";
      if(resourcetype.equals("ALL"))
  	    return "unauth/search/searchresult";
      
      return "";
	}
	
	//首页
//	@RequestMapping(value="/Home")
//	public String HomeNew(HttpServletRequest request) throws Exception {	
//		System.out.println("111");
//        return "unauth/home/indexNew";
//	}
	
	@RequestMapping(value="/Home")
	public String HomeNew(HttpServletRequest request) throws Exception {	
		System.out.println("111222");
        return "unauth/home/index";
	}
	
	
	@RequestMapping(value="/test")
	public String HomeNew1(HttpServletRequest request) throws Exception {	
		//String id = URLDecoder.decode(request.getParameter("id"),"utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + " -- " + pwd);
        return "unauth/manage/require";
	}

	
	
	
}