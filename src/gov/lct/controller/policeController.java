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
import gov.lct.model.Tpolice;
import gov.lct.service.TpoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class policeController {
	@Autowired	
	private TpoliceService TpoliceService;	
	private SolrServer solrServer;
	private static final String DEFAULT_URL = "http://or.clas.ac.cn/solr/";
	
    //政策法规浏览或者首页更多政策法规
	@RequestMapping(value = "/Policydisplay")  
	public String Policydisplay(HttpServletRequest request, Model model) {
				
		SolrQuery query = null;
		String qr = null;
		QueryResponse response = null;
		int start = 0;
		int perpage = 15;
		int pagenumber = 0;
		int pagecount = 0;
		
		int currentpage = Integer.parseInt(request.getParameter("currentpage"));
        int totalcount = 0;
		if(request.getParameter("totalcount")!=null)
		   totalcount = Integer.parseInt(request.getParameter("totalcount"));
		String pagetype = (String) request.getParameter("pagetype"); 

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
		
		Collection<Tpolice> policyItems = new ArrayList<Tpolice>();
		SolrDocumentList policyResults = new SolrDocumentList();
		Tpolice policy = null;
			
		//获取政策法规信息
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:policy";
 		query = new SolrQuery(qr);
 		System.out.println(query);
 		query.setSortField("ppublishdate",org.apache.solr.client.solrj.SolrQuery.ORDER.desc);
	    query.setStart(start);
		query.setRows(perpage);
		
 		try 
 		{
			response = solrServer.query(query);
		} catch (SolrServerException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("获取政策法规信息");

		policyResults = response.getResults();		
		if (policyResults.size() > 0) 
		{
			for (int i = 0; i < policyResults.size(); i++) 
			{
				policy = new Tpolice();
				SolrDocument policedocument = policyResults.get(i);
                if(policedocument.getFieldValue("ppid")!=null)
                	policy.setId(Integer.parseInt(policedocument.getFieldValue("ppid").toString()));
                
                if(policedocument.getFieldValue("ptitle")!=null)
                	policy.setTitle(policedocument.getFieldValue("ptitle").toString());
                
                if(policedocument.getFieldValue("pinstitute")!=null)
				    policy.setInstitute(policedocument.getFieldValue("pinstitute").toString());
                
                if(policedocument.getFieldValue("pcountry")!=null)
				    policy.setCountry(policedocument.getFieldValue("pcountry").toString());
 
                if(policedocument.getFieldValue("ppublishdate")!=null)
				    policy.setPublishdate(policedocument.getFieldValue("ppublishdate").toString());
                
                if(policedocument.getFieldValue("purl")!=null)
				    policy.setUrl(policedocument.getFieldValue("purl").toString());

                System.out.println(policy.getTitle());
				System.out.println(policy.getInstitute());
				policyItems.add(policy);
			}
		}		
		request.setAttribute("policyItems",policyItems);			
		request.setAttribute("totalcount", policyResults.getNumFound());
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("currentpage", currentpage);

	 return "unauth/display/policydisplay";
	}

	
	@RequestMapping(value="/policedetail")
	public String patentdetail(HttpServletRequest request) {
		
		SolrQuery query = null;
		Tpolice policy = null;
		Collection<Tpolice> policyItems = new ArrayList<Tpolice>();
		SolrDocumentList policyResults = new SolrDocumentList();
        String pid = request.getParameter("pid");
		
		String qr = null;
		solrServer = new HttpSolrServer(DEFAULT_URL);
 	    qr = "rightsType:policy AND ppid:" + pid;
 		query = new SolrQuery(qr);
 		System.out.println(query);
		        
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
		
		policyResults = confresponse.getResults();		
		if (policyResults.size() > 0) 
		{
			for (int i = 0; i < policyResults.size(); i++) 
			{
				policy = new Tpolice();
				SolrDocument policydocument = policyResults.get(i);
                if(policydocument.getFieldValue("ppid")!=null)
                	policy.setId(Integer.parseInt(policydocument.getFieldValue("ppid").toString()));
                
                if(policydocument.getFieldValue("ptitle")!=null)
                	policy.setTitle(policydocument.getFieldValue("ptitle").toString());
                
                if(policydocument.getFieldValue("pinstitute")!=null)
                	policy.setInstitute(policydocument.getFieldValue("pinstitute").toString());
                
                if(policydocument.getFieldValue("pcountry")!=null)
                	policy.setCountry(policydocument.getFieldValue("pcountry").toString());
 
                if(policydocument.getFieldValue("ppublishdate")!=null)
                	policy.setPublishdate(policydocument.getFieldValue("ppublishdate").toString());
                
                if(policydocument.getFieldValue("purl")!=null)
                	policy.setUrl(policydocument.getFieldValue("purl").toString());

                System.out.println(policy.getTitle());
				System.out.println(policy.getInstitute());
				policyItems.add(policy);
			}
		}
		
		request.setAttribute("policyItems",policyItems);	
		request.setAttribute("searchtime", searchtime);
		
		return "unauth/detail/policydetail";
	}
	
}