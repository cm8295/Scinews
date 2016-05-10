package gov.lct.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import gov.lct.model.Tsplit;
import gov.lct.service.TsplitService;
import gov.lct.model.Ttechenterprise;
import gov.lct.service.TtechenterpriseService;
import gov.lct.model.Tmasenterprise;
import gov.lct.service.TmasenterpriseService;
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
public class SolrController {
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
	@Autowired
	private TsplitService tsplitService;
	@Autowired
	private TtechenterpriseService techenterpriseService;	
	@Autowired
	private TmasenterpriseService masenterpriseService;	
	
	private static String provs = "安徽%北京%福建%甘肃%广东%广西%贵州%海南%河北%河南%黑龙江%湖北%湖南%吉林%江苏%江西%辽宁%内蒙古%宁夏%青海%山东%山西%陕西%上海%四川%天津%西藏%新疆%云南%浙江%重庆%";
	
	private SolrServer solrServer;
	private static final String DEFAULT_URL = "http://or.clas.ac.cn/solr/";
	

	//中小型企业
	@RequestMapping(value="/masenterpriseidx")
	public ModelAndView masenterpriseidx(ModelMap model) throws Exception {

		solrServer = new HttpSolrServer("http://localhost/solr");	
		Collection<SolrInputDocument> docs = null;
		Collection availableItems = null;

		try 
		{	   
		    solrServer.deleteByQuery("rightsType:masenterprise");         
		    solrServer.commit(true, true);
		} catch (SolrServerException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}  
		
		int splitnum = masenterpriseService.getRows(Tmasenterprise.class);
		int i=0;
			docs = new ArrayList<SolrInputDocument>();
			System.out.println("Add Tmasenterprise...");
			availableItems = masenterpriseService.findAll(Tmasenterprise.class);
			for(Tmasenterprise  enterprise : (List<Tmasenterprise>)availableItems)
			{
				SolrInputDocument doc = new SolrInputDocument();
				doc.addField("id", UUID.randomUUID().toString());
				doc.addField("rightsType", "masenterprise");
				doc.addField("mid", enterprise.getId());
				doc.addField("mentname", enterprise.getName());
				doc.addField("menttype", enterprise.getEntertype());
				doc.addField("mentcity", enterprise.getCity());
				doc.addField("mentrange", enterprise.getRange());
				doc.addField("mentyear", enterprise.getTypeyear());
				doc.addField("mentseries", enterprise.getSeries());
				docs.add(doc);
				System.out.println("当前已索引数量:"+ (i+1));
			}
			solrServer.add(docs);    
			solrServer.commit();
//		}
		model.addAttribute("info","重建中小型企业索引成功！");
		return new ModelAndView(new RedirectView("solrmanages.html"));
	}


	
	//技术性企业
	@RequestMapping(value="/techenterpriseidx")
	public ModelAndView techenterpriseidx(ModelMap model) throws Exception {

		solrServer = new HttpSolrServer(DEFAULT_URL);	
		Collection<SolrInputDocument> docs = null;
		Collection availableItems = null;

		try 
		{	   
		    solrServer.deleteByQuery("rightsType:techenterprise"); // ɾ������        
		    solrServer.commit(true, true);
		} catch (SolrServerException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}  
		
		int splitnum = techenterpriseService.getRows(Ttechenterprise.class);
		int i=0;
//		for(int i = 0; i < splitnum; i++)
//		{			
			docs = new ArrayList<SolrInputDocument>();
			System.out.println("Add Ttechenterprise...");
			availableItems = techenterpriseService.findAll(Ttechenterprise.class);
			for(Ttechenterprise  enterprise : (List<Ttechenterprise>)availableItems)
			{
				SolrInputDocument doc = new SolrInputDocument();
				doc.addField("id", UUID.randomUUID().toString());
				doc.addField("rightsType", "techenterprise");
				doc.addField("techentId", enterprise.getId());
				doc.addField("techentname", enterprise.getName());
				doc.addField("techentprov", enterprise.getProvince());
				doc.addField("techentcity", enterprise.getCity());
				doc.addField("techentclass", enterprise.getEclass());
				docs.add(doc);
				System.out.println("当前已索引数量:"+ (i+1));
			}
			solrServer.add(docs);    
			solrServer.commit();
//		}
		model.addAttribute("info","重建技术型企业索引成功！");
		return new ModelAndView(new RedirectView("solrmanages.html"));
	}

	
	
	///////专利
	@RequestMapping(value="/patentidx")
	public ModelAndView sadd3(ModelMap model) throws Exception {

		solrServer = new HttpSolrServer(DEFAULT_URL);	
		Collection<SolrInputDocument> docs = null;
		Collection availableItems = null;

		try 
		{	   
		    solrServer.deleteByQuery("rightsType:patent"); // ɾ������        
		    solrServer.commit(true, true);
		} catch (SolrServerException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}  
		
		int patentnum = tpatentbasicinfoService.getRows(Tpatentbasicinfo.class);
		System.out.println(patentnum);
		for(int i = 0; i < patentnum/1000+1; i++)
		{			
			docs = new ArrayList<SolrInputDocument>();
			System.out.println("Add index:Tpatent...");
			System.out.println("当前已索引数量："+i * 1000);
			availableItems = tpatentbasicinfoService.findAll(Tpatentbasicinfo.class, 1000, i*1000);
			//solrServer.add(addindex1((List<Tpatentbasicinfo>)availableItems, docs,"patent"));
			for(Tpatentbasicinfo  tPatentBasicInfo : (List<Tpatentbasicinfo>)availableItems)
			{
				SolrInputDocument doc = new SolrInputDocument();
				doc.addField("id", UUID.randomUUID().toString());
				doc.addField("rightsType", "patent");
				doc.addField("patentId", tPatentBasicInfo.getId());
				doc.addField("patentTi", tPatentBasicInfo.getPatentTi());
				String temp0 = tPatentBasicInfo.getPatentAn();
//				doc.addField("patentAn", temp0.contains(".")?temp0.substring(2,temp0.length()-2):temp0.substring(2));
				doc.addField("patentAn", tPatentBasicInfo.getPatentAn());
				String temp = (String)tPatentBasicInfo.getPatentAd();
				doc.addField("patentAds", temp.replaceAll("\\.", "-"));//申请日
				if(temp.length() > 4){
					try{
						temp = temp.substring(0,4);
						doc.addField("patentAd", Integer.parseInt(temp));//申请年
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(tPatentBasicInfo.getPatentPn() != null && tPatentBasicInfo.getPatentPn().length()>1){
					doc.addField("patentPn", tPatentBasicInfo.getPatentPn());	
				}
				
				
				if(tPatentBasicInfo.getPatentPd() != null && tPatentBasicInfo.getPatentPd().length()>1){
					temp = (String)tPatentBasicInfo.getPatentPd();
					doc.addField("patentPds",  temp.replaceAll("\\.", "-"));//公开日
					if(temp.length() > 4){
						try{
							temp = temp.substring(0,4);
							doc.addField("patentPd", Integer.parseInt(temp));//公开年
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
								
				doc.addField("patentFpa", tPatentBasicInfo.getPatentFpa());
				if(tPatentBasicInfo.getPatentFpa().length() > 2){
					for(String ssss:tPatentBasicInfo.getPatentFpa().split(";")){
						doc.addField("patentFpaMul", ssss.trim());//单位编码
					}
				}
				//doc.addField("patentPaAd", tPatentBasicInfo.getPatentPaAd());
				doc.addField("patentIn", tPatentBasicInfo.getPatentIn());
				doc.addField("patentType", tPatentBasicInfo.getPatentType());
				doc.addField("patentIcm", tPatentBasicInfo.getPatentIcm());//ipc主分类号
				String icm = tPatentBasicInfo.getPatentIcm();
				if(icm.length() >7){
					doc.addField("patentIcm1", tPatentBasicInfo.getPatentIcm().substring(0, 1));//部
					doc.addField("patentIcm2", tPatentBasicInfo.getPatentIcm().substring(0, 3));//大类
					doc.addField("patentIcm3", tPatentBasicInfo.getPatentIcm().substring(0, 4));//小类
				}
				doc.addField("patentLs", tPatentBasicInfo.getPatentLs());
				doc.addField("patentLspd", tPatentBasicInfo.getPatentLspd());
				doc.addField("patentLsinfo", tPatentBasicInfo.getPatentLsinfo());
				if(tPatentBasicInfo.getPatentProvince() != null){
					String provin= tPatentBasicInfo.getPatentProvince();
					if(provin.contains(";")){
						doc.addField("patentProvince",provin.substring(0,provin.indexOf(";")));
					}
				}

				doc.addField("patentAb", tPatentBasicInfo.getPatentAb());
				doc.addField("patentCl", tPatentBasicInfo.getPatentCl());
				
				if(!tPatentBasicInfo.getPatentLs().trim().equals("")){
					List<String> al = null;
					String[] ss2 = null;
					String[] str2 = null;
					
					String auth= null;//：专利授权/未授权；
					String lstype= null;//：专利最终法律状态；
					String lspd= null;//：专利最终法律状态日期；
					String lsauthpd= null;//：专利授权日期；
		        	String ls = tPatentBasicInfo.getPatentLs().trim();
		        	String lspdall = tPatentBasicInfo.getPatentLspd().trim();
		        	lspd = lspdall.substring(2,12);
		        	
		        	if(ls.substring(2,ls.length()).contains("&&")){
		        		lstype = ls.substring(2,ls.substring(2,ls.length()).indexOf("&&")+2);
		        	}else{
		        		lstype = ls.substring(2, ls.length());
		        	}
		        	if(ls.contains("&&授权")){
		        		auth = "授权";
		        		ss2 = ls.split("&&");
		        		str2 = lspdall.split("&&");
		        		al = new ArrayList<String>();
		        		al = Arrays.asList(ss2);
		        		lsauthpd = str2[al.indexOf("授权")];
		        		al= null;
		        		if(lstype.contains("专利权的终止")){
			        		lstype = "专利权的终止";
			        	}else if(lstype.contains("转移")){
			        		lstype = "专利申请权、专利权的转移";
			        	}else if(lstype.contains("备案")){
			        		lstype = "专利实施许可合同的备案";
			        	}else if(!lstype.contains("专利权的终止") && !lstype.contains("转移") && !lstype.contains("备案") &&!lstype.contains("专利权的终止")&& !lstype.startsWith("授权")&& ls.contains("授权")){
			        		lstype = "授权后的其他有关事项";
			        	}
		        	}else{
		        		auth = "未授权";
		        		lsauthpd = "";
		        		if(lstype.contains("撤回")){
			        		lstype = "申请的撤回";
			        	}else if(!lstype.contains("实质审查的生效") && !lstype.contains("撤回") && !lstype.contains("公开") &&!ls.contains("&&授权")){
			        		lstype = "未授权的其他有关事项";
			        	}
		        	}
		        	doc.addField("patentAuth", auth);//授权与否
		        	doc.addField("patentLstype", lstype);//最终法律状态
		        	doc.addField("patentLstypepd", lspd);//最终法律状态日期
		        	doc.addField("patentLsauthpd", lsauthpd);//授权状态
		        	if(lspd.length() > 4){
		        		doc.addField("patentLstypepdyear", lspd.substring(0,4));//授权状态2
		        	}else{
		        		doc.addField("patentLstypepdyear", "");//授权状态2
		        	}
		        	if(lsauthpd.length() > 4){
		        		doc.addField("patentLsauthpdyear", lsauthpd.substring(0,4));//授权状态2
		        	}else{
		        		doc.addField("patentLsauthpdyear", "");//授权状态2
		        	}
				}
				docs.add(doc);
			}
			solrServer.add(docs);    
			solrServer.commit();
		}
		model.addAttribute("info","重建专利索引成功！");
		return new ModelAndView(new RedirectView("solrmanages.html"));
	}

	
	@RequestMapping(value="/kjcgidx")
	public ModelAndView kjcgidx(ModelMap model) throws Exception {

		solrServer = new HttpSolrServer(DEFAULT_URL);	
		Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>(); 

		try 
		{	   
		    solrServer.deleteByQuery("rightsType:kjcg"); // ɾ������        
		    solrServer.commit(true, true);
		} catch (SolrServerException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}  
		

		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(34, "安徽");
		hm.put(11, "北京");
		hm.put(50, "重庆");
		hm.put(35, "福建");
		hm.put(62, "甘肃");
		hm.put(44, "广东");
		hm.put(45, "广西");
		hm.put(52, "贵州");
		hm.put(23, "黑龙江");
		hm.put(41, "河南");
		hm.put(42, "湖北");
		hm.put(43, "湖南");
		hm.put(32, "江苏");
		hm.put(36, "江西");
		hm.put(22, "吉林");
		hm.put(21, "辽宁");
		hm.put(15, "内蒙古");
		hm.put(64, "宁夏");
		hm.put(63, "青海");
		hm.put(37, "山东");
		hm.put(31, "上海");
		hm.put(14, "山西");
		hm.put(61, "陕西");
		hm.put(51, "四川");
		hm.put(12, "天津");
		hm.put(65, "新疆");
		hm.put(54, "西藏");
		hm.put(53, "云南");
		hm.put(46, "海南");
		hm.put(13, "河北");
		hm.put(33, "浙江");
		
	    int m = 0 ;
		int patentnum = tkjcgService.getRows(Tkjcg.class);
		System.out.println(patentnum);
		for(int i = 0; i < patentnum/1000+1; i++){
			System.out.println("Add index:Tkjcg...");
			System.out.println("当前已索引数量："+i * 1000);
			for(Tkjcg tkjcg : tkjcgService.findAll(Tkjcg.class, 1000, i*1000)){
				SolrInputDocument doc = new SolrInputDocument();
				doc.addField("id", UUID.randomUUID().toString());
				doc.addField("rightsType", "kjcg");
				doc.addField("kjcgId", tkjcg.getId());//id
				if(tkjcg.getITEM_13()!=null || tkjcg.getKjcgintro()!=null){
					doc.addField("kjcgFruit", tkjcg.getITEM_13()!=null?tkjcg.getITEM_13():tkjcg.getKjcgintro());//成果公报内容
				}
				if(tkjcg.getITEM_14()!=null || tkjcg.getKjcgkeyword()!=null){//主题词
					if(tkjcg.getITEM_14()!=null){
						for(String ss : tkjcg.getITEM_14().split(";")){
							if(!ss.trim().equals("") && !ss.trim().equals("null")){
								doc.addField("kjcgKeywords", ss.trim());//
							}
						}
					}else if(tkjcg.getKjcgkeyword()!=null){
						for(String ss : tkjcg.getKjcgkeyword().split("%")){
							if(!ss.trim().equals("") && !ss.trim().equals("null")){
								doc.addField("kjcgKeywords", ss.trim());//
							}
						}
					}
				}
				if(tkjcg.getITEM_3()!=null || tkjcg.getKjcgname()!=null){
					doc.addField("kjcgName", tkjcg.getITEM_3()!=null?tkjcg.getITEM_3():tkjcg.getKjcgname());//成果名称 
				}
	//			doc.addField("kjcgInst", tkjcg.getITEM_9());//单位名称，完成单位
				if(tkjcg.getITEM_9()!=null || tkjcg.getKjcgfinishinst()!=null){
					String tmp = tkjcg.getITEM_9()!=null?tkjcg.getITEM_9():tkjcg.getKjcgfinishinst();
					for(String ss : tmp.split("%")){
						if(!ss.trim().equals("") && !ss.trim().equals("null")){
							doc.addField("kjcgInst", ss.trim());//完成单位
						}
					}
				}
				if(tkjcg.getKjcgfinishperson()!=null || tkjcg.getKjcgfinishperson()!=null){
					String tmp = tkjcg.getKjcgfinishperson();
					for(String ss : tmp.split("%")){
						if(!ss.trim().equals("") && !ss.trim().equals("null")){
							doc.addField("kjcgFinishPerson", ss.trim());//完成人
						}
					}
				}
				if(tkjcg.getWfid()!= null  && tkjcg.getWfid().trim().length()!=0){
					doc.addField("kjcgWfid", tkjcg.getWfid().trim());//wfid
//					System.out.println(tkjcg.getWfid());
				}
				if(tkjcg.getITEM_12()!= null  && tkjcg.getITEM_12().trim().length()!=0){
					doc.addField("kjcgZt", tkjcg.getITEM_12().trim());//中图分类号全部
					doc.addField("kjcgZtFirst", tkjcg.getITEM_12().replaceAll("[0-9]", "").trim());//中图分类号前一位或前两位字母
				}
				if(tkjcg.getITEM_37()!= null  && tkjcg.getITEM_37().trim().length()!=0){
					doc.addField("kjcgAddress", tkjcg.getITEM_37().trim());//地址
				}
				
				if(tkjcg.getITEM_125()!= null  && tkjcg.getITEM_125().trim().length()!=0){
					for(String ss : tkjcg.getITEM_125().split(";")){
						if(!ss.trim().equals("") && !ss.trim().equals("null")){
							doc.addField("kjcgApp", ss.trim());//应用行业
						}
					}
				}
				
				if(tkjcg.getITEM_124_1()!= null  && tkjcg.getITEM_124_1().trim().length()!=0){
					for(String ss : tkjcg.getITEM_124_1().split(";")){
						if(!ss.trim().equals("") && !ss.trim().equals("null")){
							doc.addField("kjcgHt", ss.trim());//高新技术
						}
					}
				}
				if(tkjcg.getITEM_140()!= null  && tkjcg.getITEM_140().trim().length()!=0){
					for(String ss : tkjcg.getITEM_140().split(";")){
						if(!ss.trim().equals("") && !ss.trim().equals("null")){
							doc.addField("kjcgPlan", ss.trim());//科技计划
						}
					}
				}
				if(tkjcg.getKjcgsource()!= null  && tkjcg.getKjcgsource().trim().length()!=0 && !tkjcg.getKjcgsource().trim().equals("null")){
					doc.addField("kjcgSource", tkjcg.getKjcgsource().trim());//课题来源
				}
				if(tkjcg.getKjcgtime()!= null  && tkjcg.getKjcgtime().trim().length()!=0 && !tkjcg.getKjcgtime().trim().equals("null")){
					doc.addField("kjcgYear", tkjcg.getKjcgtime().trim());//时间
				}
				if(tkjcg.getdATE()!= null  && tkjcg.getdATE().trim().length()!=0 && !tkjcg.getdATE().trim().equals("null")){
					doc.addField("kjcgDate", tkjcg.getdATE().trim());//时间
				}
				if(tkjcg.getKjcgtype()!= null  && tkjcg.getKjcgtype().trim().length()!=0 && !tkjcg.getKjcgtype().trim().equals("null")){
					doc.addField("kjcgType", tkjcg.getKjcgtype().trim());//type
				}
				if(tkjcg.getfITCLASS()!= null  && tkjcg.getfITCLASS().trim().length()!=0 && !tkjcg.getfITCLASS().trim().equals("null")){
					doc.addField("fltClass", tkjcg.getfITCLASS().trim());//class
				}
				if(tkjcg.getKjcgpublish()!= null  && tkjcg.getKjcgpublish().trim().length()!=0 && !tkjcg.getKjcgpublish().trim().equals("null")){
					doc.addField("kjcgPublish", tkjcg.getKjcgpublish().trim());//publish
				}
				if(tkjcg.gettZCID()!= null  && tkjcg.gettZCID().trim().length()!=0){
					for(String ss : tkjcg.gettZCID().split("%")){
						if(!ss.trim().equals("") && !ss.trim().equals("null")){
							doc.addField("firstid", ss.trim());//tzcid
						}
					}
				}
				if(tkjcg.getzCID()!= null  && tkjcg.getzCID().trim().length()!=0){
					for(String ss : tkjcg.getzCID().split("%")){
						if(!ss.trim().equals("") && !ss.trim().equals("null")){
							doc.addField("secondid", ss.trim());//zcid
						}
					}
				}
//				if(tkjcg.getExt_Region()!=null || tkjcg.getKjcgfinishinst()!=null){
//					if(tkjcg.getExt_Region()!=null && tkjcg.getExt_Region().trim().length()>0){
//						doc.addField("kjcgProv", hm.get(tkjcg.getExt_Region()));//省份
//					}else if(tkjcg.getKjcgfinishinst()!=null&& tkjcg.getKjcgfinishinst().trim().length()>2){
//						String tmp = tkjcg.getKjcgfinishinst();
//						if(provs.contains(tmp.substring(0,2)+"%")){
//							doc.addField("kjcgProv", tmp.substring(0,2));//省份
//						}else if(provs.contains(tmp.substring(0,3)+"%")){
//							doc.addField("kjcgProv", tmp.substring(0,3));//省份
//						}
//					}
//				}
				if(tkjcg.getExt_Region() != null  && tkjcg.getExt_Region().trim().length()!=0){
					doc.addField("kjcgProv", tkjcg.getExt_Region());//省份
				}

				if(tkjcg.getITEM_34() != null  && tkjcg.getITEM_34().trim().length()!=0){
					doc.addField("item_34", tkjcg.getITEM_34().substring(0,4));//年份
					System.out.println(tkjcg.getITEM_34().substring(0,4));
				}

//				doc.addField("kjcgitem2", tkjcg.getITEM_125());//应用行业
				
				m++;
				//System.out.println("m===" + m);
				docs.add(doc);
			}
			solrServer.add(docs);
			solrServer.commit();
			System.out.println("OK");
		}
		model.addAttribute("info","重建科技成果索引成功！");
		return new ModelAndView(new RedirectView("solrmanages.html"));
	}

	
	@RequestMapping(value="/expertsidx")
	public String expertsidx(ModelMap model) throws Exception {

		solrServer = new HttpSolrServer(DEFAULT_URL);	
		 
		
		try 
		{	   
		    solrServer.deleteByQuery("rightsType:expert"); // ɾ������        
		    solrServer.commit(true, true);
		} catch (SolrServerException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}  
		
		int patentnum = texpertsService.getRows(Texperts.class);
		System.out.println(patentnum);
		for(int i = 0; i < patentnum/50+1; i++)
		{
		  Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
		  System.out.println("当前已索引数量："+i * 50);
	      for(Texperts texperts : texpertsService.findAll(Texperts.class, 50, i*50))			
		  {
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", UUID.randomUUID().toString());
			doc.addField("rightsType", "expert");
			doc.addField("expid", texperts.getId());
			doc.addField("expname", texperts.getExpname());
			doc.addField("expwork", texperts.getExpwork());
			doc.addField("expprovince", texperts.getExpprovince());
			doc.addField("exptitle", texperts.getExptitle());
			doc.addField("expaddress", texperts.getExpaddress());
			doc.addField("expdomain", texperts.getExpdomain());
			doc.addField("expwork1", texperts.getExpwork1());
			doc.addField("expxkname", texperts.getExpxkname());
			doc.addField("expnameText", texperts.getExpname());
			doc.addField("expxknameMul", texperts.getExpxkname());
			
			doc.addField("expcity", texperts.getExpcity());
			doc.addField("expcounty", texperts.getExpcounty());
			doc.addField("exparea", texperts.getExparea());
			doc.addField("exphonor", texperts.getExpeexphonor());
			doc.addField("expgender", texperts.getExpgender());
			doc.addField("expjob", texperts.getExpjob());
			
			docs.add(doc);
		  }
			solrServer.add(docs);
			solrServer.commit();
	    }
			System.out.println("OK");
		return "";
	}
	
	
	@RequestMapping(value="/policeidx")
	public String policeidx(ModelMap model) throws Exception {

		solrServer = new HttpSolrServer(DEFAULT_URL);	
		Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>(); 

		try 
		{	   
		    solrServer.deleteByQuery("rightsType:policy"); // ɾ������        
		    solrServer.commit(true, true);
		} catch (SolrServerException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}  

		List<Tpolice> Lsn = new ArrayList<Tpolice>();
		Lsn = tpoliceService.findAll(Tpolice.class);
		if(Lsn!=null)
		{
		  for(Tpolice tpolice : Lsn)
		  {
//			System.out.println(tPlant.getPlantName());
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", UUID.randomUUID().toString());
			doc.addField("rightsType", "policy");
			doc.addField("ppid", tpolice.getId());
			doc.addField("ptitle", tpolice.getTitle());
			doc.addField("pinstitute", tpolice.getInstitute());
			doc.addField("pcountry", tpolice.getCountry());
			doc.addField("pprovince", tpolice.getProvince());
			doc.addField("ppublishdate", tpolice.getPublishdate());
			doc.addField("purl", tpolice.getUrl());
			docs.add(doc);
		  }
			solrServer.add(docs);
			solrServer.commit();
			System.out.println("OK");
		}
		return "";
	}
	
	
	@RequestMapping(value="/tibetpatentidx")
	public ModelAndView Ttibetpatentidx(ModelMap model) throws Exception {

		solrServer = new HttpSolrServer(DEFAULT_URL);	
		Collection<SolrInputDocument> docs = null;
		Collection availableItems = null;

		try 
		{	   
		    solrServer.deleteByQuery("rightsType:tibetpatent"); // ɾ������        
		    solrServer.commit(true, true);
		} catch (SolrServerException e1) {
			
			e1.printStackTrace();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}  
		
		int patentnum = tibetService.getRows(Ttibet.class);
		System.out.println(patentnum);
		for(int i = 0; i < patentnum/100+1; i++)
		{			
			docs = new ArrayList<SolrInputDocument>();
			System.out.println("Add index:Tibetpatent...");
			System.out.println("当前已索引数量："+i * 100);
			availableItems = tibetService.findAll(Ttibet.class, 100, i*100);
			//solrServer.add(addindex1((List<Tpatentbasicinfo>)availableItems, docs,"patent"));
			for(Ttibet  tibet : (List<Ttibet>)availableItems)
			{
				SolrInputDocument doc = new SolrInputDocument();
				doc.addField("id", UUID.randomUUID().toString());
				doc.addField("rightsType", "tibetpatent");
				doc.addField("patentId", tibet.getId());
				doc.addField("patentTi", tibet.getPatentTi());
				String temp0 = tibet.getPatentAn();
//				doc.addField("patentAn", temp0.contains(".")?temp0.substring(2,temp0.length()-2):temp0.substring(2));
				doc.addField("patentAn", tibet.getPatentAn());
				String temp = (String)tibet.getPatentAd();
				doc.addField("patentAds", temp.replaceAll("\\.", "-"));//申请日
				if(temp.length() > 4){
					try{
						temp = temp.substring(0,4);
						doc.addField("patentAd", Integer.parseInt(temp));//申请年
					}catch (Exception e) {
						e.printStackTrace();
					}
				}

				if(tibet.getPatentPn() != null && tibet.getPatentPn().length()>1){
					doc.addField("patentPn", tibet.getPatentPn());	
				}
				
				
				if(tibet.getPatentPd() != null && tibet.getPatentPd().length()>1){
					temp = (String)tibet.getPatentPd();
					doc.addField("patentPds",  temp.replaceAll("\\.", "-"));//公开日
					if(temp.length() > 4){
						try{
							temp = temp.substring(0,4);
							doc.addField("patentPd", Integer.parseInt(temp));//公开年
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
								
				doc.addField("patentFpa", tibet.getPatentFpa());
				if(tibet.getPatentFpa().length() > 2){
					for(String ssss:tibet.getPatentFpa().split(";")){
						doc.addField("patentFpaMul", ssss.trim());//单位编码
					}
				}
				
				//doc.addField("patentPaAd", tibet.getPatentPaAd());
				doc.addField("patentIn", tibet.getPatentIn());
				doc.addField("patentType", tibet.getPatentType());
				doc.addField("patentIcm", tibet.getPatentIcm());//ipc主分类号
				String icm = tibet.getPatentIcm();
				if(icm.length() >7){
					doc.addField("patentIcm1", tibet.getPatentIcm().substring(0, 1));//部
					doc.addField("patentIcm2", tibet.getPatentIcm().substring(0, 3));//大类
					doc.addField("patentIcm3", tibet.getPatentIcm().substring(0, 4));//小类
				}
				doc.addField("patentLs", tibet.getPatentLs());
				doc.addField("patentLspd", tibet.getPatentLspd());
				doc.addField("patentLsinfo", tibet.getPatentLsinfo());
				if(tibet.getPatentProvince() != null){
					String provin= tibet.getPatentProvince();
					if(provin.contains(";")){
						doc.addField("patentProvince",provin.substring(0,provin.indexOf(";")));
					}
				}
//				
			
				doc.addField("patentAb", tibet.getPatentAb());
				doc.addField("patentCl", tibet.getPatentCl());
				
				if(!tibet.getPatentLs().trim().equals("")){
					List<String> al = null;
					String[] ss2 = null;
					String[] str2 = null;
					
					String auth= null;//：专利授权/未授权；
					String lstype= null;//：专利最终法律状态；
					String lspd= null;//：专利最终法律状态日期；
					String lsauthpd= null;//：专利授权日期；
		        	String ls = tibet.getPatentLs().trim();
		        	String lspdall = tibet.getPatentLspd().trim();
		        	lspd = lspdall.substring(2,12);
		        	
		        	if(ls.substring(2,ls.length()).contains("&&")){
		        		lstype = ls.substring(2,ls.substring(2,ls.length()).indexOf("&&")+2);
		        	}else{
		        		lstype = ls.substring(2, ls.length());
		        	}
		        	if(ls.contains("&&授权")){
		        		auth = "授权";
		        		ss2 = ls.split("&&");
		        		str2 = lspdall.split("&&");
		        		al = new ArrayList<String>();
		        		al = Arrays.asList(ss2);
		        		lsauthpd = str2[al.indexOf("授权")];
		        		al= null;
		        		if(lstype.contains("专利权的终止")){
			        		lstype = "专利权的终止";
			        	}else if(lstype.contains("转移")){
			        		lstype = "专利申请权、专利权的转移";
			        	}else if(lstype.contains("备案")){
			        		lstype = "专利实施许可合同的备案";
			        	}else if(!lstype.contains("专利权的终止") && !lstype.contains("转移") && !lstype.contains("备案") &&!lstype.contains("专利权的终止")&& !lstype.startsWith("授权")&& ls.contains("授权")){
			        		lstype = "授权后的其他有关事项";
			        	}
		        	}else{
		        		auth = "未授权";
		        		lsauthpd = "";
		        		if(lstype.contains("撤回")){
			        		lstype = "申请的撤回";
			        	}else if(!lstype.contains("实质审查的生效") && !lstype.contains("撤回") && !lstype.contains("公开") &&!ls.contains("&&授权")){
			        		lstype = "未授权的其他有关事项";
			        	}
		        	}
		        	doc.addField("patentAuth", auth);//授权与否
		        	doc.addField("patentLstype", lstype);//最终法律状态
		        	doc.addField("patentLstypepd", lspd);//最终法律状态日期
		        	doc.addField("patentLsauthpd", lsauthpd);//授权状态
		        	if(lspd.length() > 4){
		        		doc.addField("patentLstypepdyear", lspd.substring(0,4));//授权状态2
		        	}else{
		        		doc.addField("patentLstypepdyear", "");//授权状态2
		        	}
		        	if(lsauthpd.length() > 4){
		        		doc.addField("patentLsauthpdyear", lsauthpd.substring(0,4));//授权状态2
		        	}else{
		        		doc.addField("patentLsauthpdyear", "");//授权状态2
		        	}
				}
				
				
				
				
				
				
				docs.add(doc);
			}
			solrServer.add(docs);    
			solrServer.commit();
			System.out.println("OOKK");
		}
		model.addAttribute("info","重建专利索引成功！");
		return new ModelAndView(new RedirectView("solrmanages.html"));
	}
}