package gov.lct.controller;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
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
import gov.lct.service.TpatentbasicinfoService;
import gov.lct.model.Tkjcg;
import gov.lct.service.TkjcgService;
import gov.lct.model.Texperts;
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
public class StatisticController {
	@Autowired
	private TpatentbasicinfoService tpatentbasicinfoService;
	@Autowired
	private TkjcgService tkjcgService;
	@Autowired
	private TexpertsService texpertService;
	
	private SolrServer solrServer;
	private static final String DEFAULT_URL = "http://or.clas.ac.cn/solr/";
	
	
	@RequestMapping(value = "/StatisticHome")	
	public String StatisticHome(HttpServletRequest request, Model model) {
		return "unauth/statistic/stahome";
	}

	
	@RequestMapping(value="/PatentIcmAll")
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
 	    qr = "rightsType:patent AND patentIcm1:" + "\"" + content + "\"";		
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
 	
		return "unauth/display/patenticmall";
   }
	
	
	@RequestMapping(value="/PatentFpaAll")
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
 	    qr = "rightsType:patent AND patentFpa:" + "\"" + content + "\"";		
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
 	
		return "unauth/display/patentfpaall";
   }
	
	@RequestMapping(value="/StatisticByFpa")
	public String PatentFpaSta(HttpServletRequest request) {
		SolrQuery query = null;
		
		int displaycount = 0;
		if(request.getParameter("count")==null)
			displaycount = 30;
		else
			displaycount = Integer.parseInt(request.getParameter("count"));

		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:patent";
 		query = new SolrQuery(qr);

 		query.setFacet(true);
		query.addFacetField("patentFpaMul");
		query.setFacetSort("count");
		query.setFacetLimit(displaycount);
		System.out.println(displaycount);

		QueryResponse patentresponse = null;
		try {
			patentresponse = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
		List<FacetField> facets = patentresponse.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("patentFpaMul")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] fpafacet = new String[facetEntries.size()];
 			      Integer[] fpafacetcount = new Integer[facetEntries.size()];
 			      Integer[] facetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 fpafacet[m] = fcount.getName();					 
						 fpafacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 facetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
					     m++;							     
					 }
				  }				  			 
//				//年代逆序排序
//				  if(fpafacet!=null)
//				  {
//				    for (int i=0; i<fpafacet.length-1; i++ )
//				    {
//				      int min=i;
//				      for (int j=i+1; j<fpafacet.length; j++ )
//				      {
//				        if ((fpafacet[min].compareTo(fpafacet[j]))>0) //如果这里是>0，则为顺序排
//				        {
//				            min=j;
//				        }
//				      }
//				      if (min!=i)
//				      {
//				        String temp=fpafacet[i];
//				        fpafacet[i]=fpafacet[min];
//				        fpafacet[min]=temp;
//				        
//				        int temp1 = fpafacetcount[i];
//				        fpafacetcount[i] = fpafacetcount[min];
//				        fpafacetcount[min]=temp1;
//				      }
//				    }
//				  }				  
				  request.setAttribute("fpafacet", fpafacet);
				  request.setAttribute("fpafacetcount", fpafacetcount);				  
				  CreateFpaJson(fpafacet,fpafacetcount);
				}					
			  }
		   }	   
       return "unauth/statistic/stabypatentfpa";		
	}
	
	@RequestMapping(value="/PatentFpaDisplay")
	public String PatentFpaDisplay(HttpServletRequest request) {
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
  	    qr = "rightsType:patent AND patentFpa:" + "\"" + content + "\""; 	
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
		
		return "unauth/statistic/patentfpapartmessage";
	}
	
	@RequestMapping(value="/StatisticByTibetFpa")
	public String TibetPatentFpaSta(HttpServletRequest request) {
		SolrQuery query = null;
		
		int displaycount = 0;
		if(request.getParameter("count")==null)
			displaycount = 30;
		else
			displaycount = Integer.parseInt(request.getParameter("count"));

		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:tibetpatent";
 		query = new SolrQuery(qr);

 		query.setFacet(true);
		query.addFacetField("patentFpaMul");
		query.setFacetSort("count");
		query.setFacetLimit(displaycount);
		System.out.println(displaycount);

		QueryResponse patentresponse = null;
		try {
			patentresponse = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
		List<FacetField> facets = patentresponse.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("patentFpaMul")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] fpafacet = new String[facetEntries.size()];
 			      Integer[] fpafacetcount = new Integer[facetEntries.size()];
 			      Integer[] facetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 fpafacet[m] = fcount.getName();					 
						 fpafacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 facetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
					     m++;							     
					 }
				  }				  			 
//				//年代逆序排序
//				  if(fpafacet!=null)
//				  {
//				    for (int i=0; i<fpafacet.length-1; i++ )
//				    {
//				      int min=i;
//				      for (int j=i+1; j<fpafacet.length; j++ )
//				      {
//				        if ((fpafacet[min].compareTo(fpafacet[j]))>0) //如果这里是>0，则为顺序排
//				        {
//				            min=j;
//				        }
//				      }
//				      if (min!=i)
//				      {
//				        String temp=fpafacet[i];
//				        fpafacet[i]=fpafacet[min];
//				        fpafacet[min]=temp;
//				        
//				        int temp1 = fpafacetcount[i];
//				        fpafacetcount[i] = fpafacetcount[min];
//				        fpafacetcount[min]=temp1;
//				      }
//				    }
//				  }				  
				  request.setAttribute("fpafacet", fpafacet);
				  request.setAttribute("fpafacetcount", fpafacetcount);				  
				  CreateFpaJson(fpafacet,fpafacetcount);
				}					
			  }
		   }	   
       return "unauth/statistic/stabytibetpatentfpa";		
	}
	
	
	public void CreateFpaJson(String[] fpafacet, Integer[] fpafacetcount) 
	{
		String rssPath = null;
		try {
			rssPath = "G:/tomcat7/webapps/rssfeed/tibetfpa.json";
			OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(rssPath),"UTF-8"); 
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("{");
			bw.write("\r\n");
			bw.write("\"name\":" + " \"FPA\"" + ",");
			bw.write("\r\n");
			bw.write("\"children\":  [");	
			bw.write("\r\n");
			bw.write("{");
			
			int count = 0;
            if(fpafacet.length>=10)
            {
              //开始写美洲国家			
			  bw.write("\r\n");
			  bw.write("\"name\":" + " \"TOP 10\"" + ",");
			  bw.write("\r\n");
			  bw.write("\"children\":");
			  bw.write("  [");
			  bw.write("\r\n");
			
			  for (int m=0; m<10; m++) 
			  {
			   if(m<=8)	
			      bw.write("        {\"name\":  \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "},");
			   else
			   {
				  bw.write("        {\"name\": \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "}");				  
			   }
			     bw.write("\r\n");			     
			  }
			    bw.write("]");
			    bw.write("\r\n");
				if(fpafacet.length>10)
				   bw.write("},");
				if(fpafacet.length==10)
				   bw.write("}");            
			} 
			  
              
            if(fpafacet.length>=20)	
            {
		      bw.write("\r\n");
		      bw.write("{");
		      bw.write("\r\n");
			  bw.write("\"name\":" + " \"TOP 20\"" + ",");
			  bw.write("\r\n");
			  bw.write("\"children\":");
			  bw.write("  [");
			  bw.write("\r\n");
			  
			  for (int m=10; m<20; m++) 
			  {
				   if(m<=18)	
				      bw.write("        {\"name\":  \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "},");
				   else
				   {
					  bw.write("        {\"name\": \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "}");				  
				   }
				  bw.write("\r\n");			     
			  }
			    bw.write("]");
			    bw.write("\r\n");
				if(fpafacet.length>20)
				   bw.write("},");
				if(fpafacet.length==20)
				   bw.write("}");            
            } 
			 
            
            if(fpafacet.length>=30)	
            {			  
		      bw.write("\r\n");
		      bw.write("{");
		      bw.write("\r\n");
			  bw.write("\"name\":" + " \"Top 30\"" + ",");
			  bw.write("\r\n");
			  bw.write("\"children\":");
			  bw.write("  [");
			  bw.write("\r\n");
			  
				for (int m=20; m<30; m++) 
				{
				   if(m<=28)	
				      bw.write("        {\"name\":  \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "},");
				   else
				   {
					  bw.write("        {\"name\": \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "}");				  
				   }
				  bw.write("\r\n");			     
			  }
			   bw.write("]");
			   bw.write("\r\n");
			   if(fpafacet.length>30)
				  bw.write("},");
			   if(fpafacet.length==30)
				  bw.write("}");            
            } 
            
            
            if(fpafacet.length>=40)	
            {			  
		      bw.write("\r\n");
		      bw.write("{");
		      bw.write("\r\n");
			  bw.write("\"name\":" + " \"Top 40\"" + ",");
			  bw.write("\r\n");
			  bw.write("\"children\":");
			  bw.write("  [");
			  bw.write("\r\n");
			  
				for (int m=30; m<40; m++) 
				{
				   if(m<=38)	
				      bw.write("        {\"name\":  \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "},");
				   else
				   {
					  bw.write("        {\"name\": \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "}");				  
				   }
				  bw.write("\r\n");			     
			   }
			    bw.write("]");
			    bw.write("\r\n");
				if(fpafacet.length>40)
				   bw.write("},");
				if(fpafacet.length==40)
				   bw.write("}");            
            }
			  
            if(fpafacet.length>=50)	
            {			  
		      bw.write("\r\n");
		      bw.write("{");
		      bw.write("\r\n");
			  bw.write("\"name\":" + " \"Top 50\"" + ",");
			  bw.write("\r\n");
			  bw.write("\"children\":");
			  bw.write("  [");
			  bw.write("\r\n");
			  
				for (int m=40; m<50; m++) 
				{
				   if(m<=48)	
				      bw.write("        {\"name\":  \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "},");
				   else
				   {
					  bw.write("        {\"name\": \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "}");				  
				   }
				  bw.write("\r\n");			     
			   }
			   bw.write("]");
			   bw.write("\r\n");
			   if(fpafacet.length>50)
			      bw.write("},");
			   if(fpafacet.length==50)
				  bw.write("}");
            }
			  
            
            if(fpafacet.length>=60)	
            {			  	          
		      bw.write("\r\n");
		      bw.write("{");
		      bw.write("\r\n");
			  bw.write("\"name\":" + " \"Top 60\"" + ",");
			  bw.write("\r\n");
			  bw.write("\"children\":");
			  bw.write("  [");
			  bw.write("\r\n");
			  
				for (int m=50; m<60; m++) 
				{
				   if(m<=58)	
				      bw.write("        {\"name\":  \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "},");
				   else
				   {
					  bw.write("        {\"name\": \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "}");				  
				   }
				  bw.write("\r\n");			     
				}
			  bw.write("]");
			  bw.write("\r\n");
			  if(fpafacet.length>60)
				 bw.write("},");
			  if(fpafacet.length==60)
				 bw.write("}");            
            }
            
            
            if(fpafacet.length>=70)	
            {			  
		      bw.write("\r\n");
		      bw.write("{");
		      bw.write("\r\n");
			  bw.write("\"name\":" + " \"Top 70\"" + ",");
			  bw.write("\r\n");
			  bw.write("\"children\":");
			  bw.write("  [");
			  bw.write("\r\n");
			  
				for (int m=60; m<70; m++) 
				{
				   if(m<=68)	
				      bw.write("        {\"name\":  \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "},");
				   else
				   {
					  bw.write("        {\"name\": \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "}");				  
				   }
				  bw.write("\r\n");			     
			  }
			   bw.write("]");
			   bw.write("\r\n");
			   if(fpafacet.length>70)
				  bw.write("},");
			   if(fpafacet.length==70)
				  bw.write("}");            
            }
			  
			  
            if(fpafacet.length>=80)	
            {			  	         
		      bw.write("\r\n");
		      bw.write("{");
		      bw.write("\r\n");
			  bw.write("\"name\":" + " \"Top 80\"" + ",");
			  bw.write("\r\n");
			  bw.write("\"children\":");
			  bw.write("  [");
			  bw.write("\r\n");
			  
				for (int m=70; m<80; m++) 
				{
				   if(m<=78)	
				      bw.write("        {\"name\":  \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "},");
				   else
				   {
					  bw.write("        {\"name\": \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "}");				  
				   }
				  bw.write("\r\n");			     
			    }
			    bw.write("]");
			    bw.write("\r\n");
				if(fpafacet.length>80)
				   bw.write("},");
			    if(fpafacet.length==80)
				   bw.write("}");            
            }
			  

            if(fpafacet.length>=90)	
            {			  	         
		      bw.write("\r\n");
		      bw.write("{");
		      bw.write("\r\n");
			  bw.write("\"name\":" + " \"Top 80\"" + ",");
			  bw.write("\r\n");
			  bw.write("\"children\":");
			  bw.write("  [");
			  bw.write("\r\n");
			  
				for (int m=80; m<90; m++) 
				{
				   if(m<=88)	
				      bw.write("        {\"name\":  \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "},");
				   else
				   {
					  bw.write("        {\"name\": \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "}");				  
				   }
				  bw.write("\r\n");			     
			    }
			     bw.write("]");
			     bw.write("\r\n");
				 if(fpafacet.length>90)
					bw.write("},");
			     if(fpafacet.length==90)
				    bw.write("}");            
				   
            }  

            if(fpafacet.length>90)	
            {			  	                     
		      bw.write("\r\n");
		      bw.write("{");
		      bw.write("\r\n");
			  bw.write("\"name\":" + " \"Top 90\"" + ",");
			  bw.write("\r\n");
			  bw.write("\"children\":");
			  bw.write("  [");
			  bw.write("\r\n");
			  
				for (int m=90; m<fpafacet.length; m++) 
				{
				   if(m<=(fpafacet.length-2))	
				      bw.write("        {\"name\":  \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "},");
				   else
				   {
					  bw.write("        {\"name\": \"" + fpafacet[m] + "\"," + "\"size\": " + fpafacetcount[m] + "}");				  
				   }
				  bw.write("\r\n");			     
			    }
			     bw.write("]");
			     bw.write("\r\n");
			     bw.write("}");	
            }
			  
		  bw.write("\r\n");			     
		  bw.write("]");
		  bw.write("\r\n");
		  bw.write("}");
		  
			 bw.close();  
			 fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}    				
	}
	
	
	@RequestMapping(value = "/StatisticByAd")	
	public String StatisticByAd(HttpServletRequest request, Model model) {

		SolrQuery query = null;
		
        int yearspan = 0;
        if(request.getParameter("yearspan")!=null)
        	yearspan = Integer.parseInt(request.getParameter("yearspan"));
           	
 		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:patent";
 		query = new SolrQuery(qr);

 		query.setFacet(true);
		query.addFacetField("patentAd");
		query.setFacetSort("name");
		query.setFacetMinCount(0);
//		if(yearspan>0)
// 	       query.setFacetLimit(yearspan); 
//		else
//		   query.setFacetLimit(100);
			
		QueryResponse patentresponse = null;
		try {
			patentresponse = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
		List<FacetField> facets = patentresponse.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("patentAd")) 
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
		
		request.setAttribute("yearspan", yearspan);
       return "unauth/statistic/stabyad";		
	} 
	
	@RequestMapping(value = "/PatentIcmDisplay")	
	public String PatentIcmDisplay(HttpServletRequest request, Model model) {

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
  	    qr = "rightsType:patent AND patentIcm1:" + "\"" + content + "\""; 	
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

//		
//		List<FacetField> facets = response.getFacetFields();		
//		for (FacetField facet : facets) 
//		{
//		   if (facet.getName().equals("patentIcm1")) 
//		   {
//			  List<FacetField.Count> facetEntries = facet.getValues();
//			  if(facetEntries!=null)
//			  {
// 			      String[] icmfacet = new String[facetEntries.size()];
// 			      Integer[] icmfacetcount = new Integer[facetEntries.size()];
//				  int m = 0;
//				  for (FacetField.Count fcount : facetEntries) 
//				  {
//					 if(fcount.getName()!=null)
//					 {
//						 icmfacet[m] = fcount.getName();					 
//						 icmfacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
//						 System.out.println(icmfacetcount[m]);
//					     m++;							     
//					 }
//				  }		
//				  request.setAttribute("icmfacet", icmfacet);
//				  request.setAttribute("icmfacetcount", icmfacetcount);
//				}					
//			  }
//		   }	
//		
		
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
        qr = "rightsType:patent";
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
						 System.out.println(icmfacetcount[m]);
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
		request.setAttribute("content", content);
		
		return "unauth/statistic/partmessge";
	}
	
	
	@RequestMapping(value = "/PatentIcmpie")  
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
        qr = "rightsType:patent";
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
		
		return "unauth/statistic/patenticmpie";
	}

	
	@RequestMapping(value = "/Patenticmbsunburst")  
	public String PatentIcmbSunburst(HttpServletRequest request, Model model) {
		//return "unauth/statistic/test";
		return "unauth/statistic/patenticmsunburst";
	}
	
	@RequestMapping(value = "/CreatePatentBubbleJson")  
	public String CirculationBubble(HttpServletRequest request, Model model) {
		SolrQuery query = null;
//		SolrDocumentList cirResults = new SolrDocumentList();
//		TCirclation circulation = null;
		Collection<Tpatentbasicinfo> cirItems = new ArrayList<Tpatentbasicinfo>();
		String[] icm = null;
		String[] icm1 = null;
		String[] icm2 = null;
		Integer[] icmcount = null;
		Integer[] icm1count = null;
		Integer[] icm2count = null;
		
		String qr = null;
		int start = 0;
		int perpage = 1000;		
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:patent";
 		query = new SolrQuery(qr);
 		System.out.println(query);
	    query.setStart(start);
		query.setRows(perpage);
		query.setFacet(true);
		query.addFacetField("patentIcm1");
		query.setFacetSort("name");
	    query.setFacetLimit(1000);
	    
		QueryResponse response = null;

		try 
		{
			response = solrServer.query(query);
		} catch (SolrServerException e) 
		{
			e.printStackTrace();
		}	
		
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
						 //System.out.println(icmfacet[m]);
					     m++;							     
					 }
				  }		
				  icm = new String[icmfacet.length];
				  icmcount = new Integer[icmfacet.length];
				  for(int i=0; i<icmfacet.length; i++)
				  {
					if(icmfacet[i]!=null)
					{
					  icm[i] = icmfacet[i];
					  System.out.println("icm1==" + icm[i]);
					  icmcount[i] = icmfacetcount[i];
					}
				  }
				}					
			  }
		   }	   
				
 	    qr = "rightsType:patent";
 		query = new SolrQuery(qr);
 		System.out.println(query);
	    query.setStart(start);
		query.setRows(perpage);
		query.setFacet(true);
		query.addFacetField("patentIcm2");
		query.setFacetSort("name");
		query.setFacetLimit(1000);
	    
		try 
		{
			response = solrServer.query(query);
		} catch (SolrServerException e) 
		{
			e.printStackTrace();
		}	
		
		facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("patentIcm2")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] icm1facet = new String[facetEntries.size()];
 			      Integer[] icm1facetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 icm1facet[m] = fcount.getName().replace("-", "");					 
						 icm1facetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 //System.out.println(icm1facet[m]);
					     m++;							     
					 }
				  }		
				  icm1 = new String[icm1facet.length];
				  icm1count = new Integer[icm1facet.length];
				  for(int i=0; i<icm1facet.length; i++)
				  {
					if(icm1facet[i]!=null)
					{
					  icm1[i] = icm1facet[i];
					  System.out.println("icm2==" + icm1[i]);
					  icm1count[i] = icm1facetcount[i];
					}
				  }
				}					
			  }
		   }		
		
		
 	    qr = "rightsType:patent";
 		query = new SolrQuery(qr);
 		System.out.println(query);
	    query.setStart(start);
		query.setRows(perpage);
		query.setFacet(true);
		query.addFacetField("patentIcm3");
		query.setFacetSort("name");
		query.setFacetLimit(1000);
	    
		try 
		{
			response = solrServer.query(query);
		} catch (SolrServerException e) 
		{
			e.printStackTrace();
		}	
		
		facets = response.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("patentIcm3")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] icm2facet = new String[facetEntries.size()];
 			      Integer[] icm2facetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 icm2facet[m] = fcount.getName();					 
						 icm2facetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 //System.out.println(icm2facet[m]);
					     m++;							     
					 }
				  }	
				  icm2 = new String[icm2facet.length];
				  icm2count = new Integer[icm2facet.length];
				  for(int i=0; i<icm2facet.length; i++)
				  {
					if(icm2facet[i]!=null)
					{
					  icm2[i] = icm2facet[i];
					  System.out.println("icm3==" + icm2[i]);
					  icm2count[i] = icm2facetcount[i];
					}
				  }

				}					
			  }
		   }		
		   Integer[] count = new Integer[icm.length];
		   int totalcount = 0;
		   for(int m=0; m<icm.length; m++)
		   {
			 for(int n=0; n<icm1.length; n++)
			 {
			    if(icm1[n].substring(0, 1).equals(icm[m]))
			    {
			       totalcount ++; 	
			    }
			 }
			 count[m] = totalcount;
			 System.out.println("count[m]==" + count[m]);
			 totalcount = 0;
		   }
		   
		   System.out.println("");
		   
		   Integer[] count1 = new Integer[icm1.length];
		   int totalcount1 = 0;
		   for(int m=0; m<icm1.length; m++)
		   {
			 for(int n=0; n<icm2.length; n++)
			 {
				if(icm2[n].length()==3)
				{
				  if(icm2[n].substring(0, 2).equals(icm1[m]))   
                    totalcount1 ++;
				}
				if(icm2[n].length()==4)
				{
				  if(icm2[n].indexOf("-")!=-1)	
				  {
				    if(icm2[n].substring(0, 2).equals(icm1[m]))   
				      totalcount1 ++;
				  }
				  else
				  {
					if(icm2[n].substring(0, 3).equals(icm1[m]))   
					  totalcount1 ++;	
				  }
				}
			  }
			 count1[m] = totalcount1;
			 System.out.println("count1[m]==" + count1[m]);
			 totalcount1 = 0;
		   }
		   
		   CreateICMJson(icm, icm1, icm2, icmcount, icm1count, icm2count, count, count1);
		
		  return "";
	    }


	
	public void CreateICMJson(String[] icm, String[] icm1, String[] icm2, Integer[] icmcount, Integer[] icm1count, Integer[] icm2count, Integer[] count, Integer[] count1){
		String rssPath = null;
		OutputStreamWriter fw = null;
		BufferedWriter bw = null;
		int whole = 0;
        System.out.println("icm.length==" + icm.length);
		    try {
				rssPath = "G:/tomcat7/webapps/rssfeed/patenticm.json";
				fw = new OutputStreamWriter(new FileOutputStream(rssPath, true),"UTF-8"); 
				bw = new BufferedWriter(fw);
			
			    bw.write("{");
				bw.write("\r\n");
				bw.write("\"name\": \"ICM\",");
				bw.write("\r\n");
				bw.write("\"children\":[");	
				bw.write("\r\n");
				
				for(int i=0; i<icm.length; i++) //开始ICM 第一层循环
				{
				  bw.write("{");
				  bw.write("\r\n");
				  bw.write("\"name\":\"" + icm[i] + "\",");
				  bw.write("\r\n");
				  bw.write("\"children\":[");	
				  bw.write("\r\n");
				  //bw.write("count[m]===" + count[i]);
				  for(int m=0; m<icm1.length; m++)
				  {
					if(icm1[m].substring(0, 1).equals(icm[i]))
					{
					  bw.write("{"); 
					  bw.write("\r\n");						
				      bw.write("\"name\":\"" + icm1[m] + "\",");
					  bw.write("\r\n");
					  bw.write("\"children\":[");	
					  bw.write("\r\n");			
					  int temp = 0;
					  for(int n=0; n<icm2.length; n++, temp++)					  
					  {					  						  
						if(icm2[n].length()==3)
						{
						  if(icm2[n].substring(0, 2).equals(icm1[m]))   
						  { 
							if(temp==count1[m]-1)  
							{	 
							  bw.write("{\"name\":" + "\"" + icm2[n] + "\"" + ", \"size\":" + icm2count[n] + "}");					         
							}
							else
							{
								bw.write("{\"name\":" + "\"" + icm2[n] + "\"" + ", \"size\":" + icm2count[n] + "},");
							}
						    bw.write("\r\n");
						  }
						}
						if(icm2[n].length()==4)
						{
						  if(icm2[n].indexOf("-")!=-1)	
						  {
						    if(icm2[n].substring(0, 2).equals(icm1[m]))   
						    {	
								if(temp==count1[m]-1)  
								{	
								  bw.write("{\"name\":" + "\"" + icm2[n] + "\"" + ", \"size\":" + icm2count[n] + "}");					         
								}
								else
								{
									bw.write("{\"name\":" + "\"" + icm2[n] + "\"" + ", \"size\":" + icm2count[n] + "},");
								}
						      bw.write("\r\n");
						    }
						  }
						  else
						  {
							if(icm2[n].substring(0, 3).equals(icm1[m]))   
							{	
								if(temp==count1[m]-1)  
								{	
								  bw.write("{\"name\":" + "\"" + icm2[n] + "\"" + ", \"size\":" + icm2count[n] + "}");					         
								}
								else
								{
									bw.write("{\"name\":" + "\"" + icm2[n] + "\"" + ", \"size\":" + icm2count[n] + "},");
								}
							  bw.write("\r\n");
							}
						  } // end of else							  
						} // end of if(icm2[n].length()==4)						
					  }  // end of for(int n=0; n<icm2.length; n++)
					  
					  bw.write("]");
					  bw.write("\r\n");
					  if(m==count[i]-1)
					    bw.write("}");
					  else
						bw.write("},");	  
					  bw.write("\r\n");
					} // end of if(icm1[m].substring(0, 1).equals(icm[i])) 	
				  } // end of for(int m=0; m<icm1.length; m++)
				  bw.write("\r\n");
				  bw.write("]");
				  bw.write("\r\n");
				  bw.write("},");	
				  bw.write("\r\n");
               }
				  //bw.write("\r\n");
				  bw.write("]");
				  bw.write("}");
				  
				  bw.close();  
				  fw.close();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
	}
	
	
	@RequestMapping(value = "/sta/Patentprovsummary")  
	public String PatentProvSummary(HttpServletRequest request, Model model) {
				
		SolrQuery query = null;
		
 		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:patent";
 		query = new SolrQuery(qr);

 		query.setFacet(true);
		query.addFacetField("patentProvince");
		query.setFacetSort("count");
		query.setFacetMinCount(0);

		QueryResponse patentresponse = null;
		try {
			patentresponse = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
		List<FacetField> facets = patentresponse.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("patentProvince")) 
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
       return "unauth/statistic/patentprovsummary";		
	}
	
	@RequestMapping(value = "/sta/PatentIcmDeatilSummary")  
	public String PatentIcmDeatilSummary(HttpServletRequest request, Model model) {
				
		SolrQuery query = null;
		Tpatentbasicinfo patent = null;

		String icm = request.getParameter("icm");
		
 		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:patent AND patentIcm1:" + "\"" + icm + "\"";
 		query = new SolrQuery(qr);

 		query.setFacet(true);
		query.addFacetField("patentIcm2");
		query.setFacetSort("count");
		query.setFacetMinCount(0);

		QueryResponse patentresponse = null;
		try {
			patentresponse = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
		List<FacetField> facets = patentresponse.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("patentIcm2")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] icmfacet = new String[facetEntries.size()];
 			      Integer[] icmfacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null && fcount.getName().substring(0, 1).equals(icm))
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
       return "unauth/statistic/patenticmdetailsummary";		
	}

	@RequestMapping(value = "/sta/Patentfpasummary")  
	public String PatentFpaSummary(HttpServletRequest request, Model model) {
				
		SolrQuery query = null;
		Tpatentbasicinfo patent = null;

		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:patent";
 		query = new SolrQuery(qr);

 		query.setFacet(true);
		query.addFacetField("patentFpaMul");
		query.setFacetSort("count");
		query.setFacetMinCount(0);

		QueryResponse patentresponse = null;
		try {
			patentresponse = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
		List<FacetField> facets = patentresponse.getFacetFields();		
		for (FacetField facet : facets) 
		{
		   if (facet.getName().equals("patentFpaMul")) 
		   {
			  List<FacetField.Count> facetEntries = facet.getValues();
			  if(facetEntries!=null)
			  {
 			      String[] fpafacet = new String[facetEntries.size()];
 			      Integer[] fpafacetcount = new Integer[facetEntries.size()];
				  int m = 0;
				  for (FacetField.Count fcount : facetEntries) 
				  {
					 if(fcount.getName()!=null)
					 {
						 fpafacet[m] = fcount.getName();					 
						 fpafacetcount[m] = Integer.parseInt(String.valueOf(fcount.getCount()));
						 System.out.println(fpafacet[m]);
					     m++;							     
					 }
				  }				  			  
				  request.setAttribute("fpafacet", fpafacet);
				  request.setAttribute("fpafacetcount", fpafacetcount);
				}					
			  }
		   }	   
       return "unauth/statistic/patentfpasummary";		
	}
	
	@RequestMapping(value = "/sta/patenticmsummary")  
	public String Patenticmsummary(HttpServletRequest request, Model model) {
				
		SolrQuery query = null;
		Tpatentbasicinfo patent = null;

 		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:patent";
 		query = new SolrQuery(qr);

 		query.setFacet(true);
		query.addFacetField("patentIcm1");
		query.setFacetSort("count");
		query.setFacetMinCount(0);

		QueryResponse patentresponse = null;
		try {
			patentresponse = solrServer.query(query);
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		
		List<FacetField> facets = patentresponse.getFacetFields();		
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
       return "unauth/statistic/patenticmsummary";		
	}

}