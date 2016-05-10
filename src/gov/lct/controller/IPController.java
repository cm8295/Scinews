package gov.lct.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import gov.lct.model.Tsoftware;
import gov.lct.service.TsoftwareService;
import gov.lct.model.Tmap;
import gov.lct.service.TmapService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IPController {	
   
	@Autowired
	private TmapService tmapService;
	
	@Autowired
	private TsoftwareService tsoftService;

	HttpClient httpClient = new DefaultHttpClient();

	@RequestMapping(value="/getmapurl")	
	public String GetMapUrl(HttpServletRequest request) throws InterruptedException
	{
        return "unauth/test/mapurl";
	}
	
	@RequestMapping(value="/GetMap") //该第五页内容	
	public String GetMap(HttpServletRequest request) throws InterruptedException
	{
		  String html = null;
		  String URL = request.getParameter("url");
		  //String URL = "http://www.sipo.gov.cn/zwgs/zyqgg/201505/t20150522_1120961.html";
		  System.out.println(URL);
			try {
				httpClient = new DefaultHttpClient();  
				HttpParams params = httpClient.getParams();
				HttpConnectionParams.setConnectionTimeout(params, 120000);
				HttpConnectionParams.setSoTimeout(params, 120000);		
				//URL = URL.replace("\"", "%22");
				HttpGet httpget = new HttpGet(URL); 
				HttpResponse responce;
				responce = httpClient.execute(httpget);
				if (responce.getStatusLine().getStatusCode() == HttpStatus.SC_OK) 
				{   
				    HttpEntity entity = responce.getEntity();   
				    if (entity != null) 
				    {   
				        html = EntityUtils.toString(entity);
				        //if(html.indexOf("中国科学院")!=-1)
				        //{
				          int start = html.indexOf("</style>");			        
				          if(start!=-1)
				          {
				            html = html.substring(start+7);
				            html = html.trim();
				            int end = html.indexOf("</P></p>");
				            if(end!=-1)
				              html = html.substring(0, end);	
				          }
						
				          html = new String(html.getBytes("ISO-8859-1"),"GB2312");
				          //System.out.println(html);
					      entity = null;			        
					      AnalyseAndStore(html); 
				      //}
				        	
				    }   
				}
				if(html == null)
				{
					System.out.println(URL);
				}
			} catch (NumberFormatException e) {
				
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				
				e.printStackTrace();
			} catch (ParseException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	        return "unauth/test/mapurl";
	}
	
	public void AnalyseAndStore(String html) throws InterruptedException
	{
        String htmlnew = html;
        String mapName =null, mapBusiness=null, mapEndate=null, mapProxyer=null, mapProxy=null;
        String mapAddressCo=null, mapCountryCo=null, mapAddress=null, mapCountry=null, mapFunction=null;
        String mapTech=null, mapStructure=null, mapDesigner=null, mapInstituteCo=null, mapInstitute=null;
        String mapPn=null, mapPd=null, mapAd=null, mapRegnumber=null;
       
        int pos = 0;
        pos=html.indexOf("布图设计登记号");
        while(pos!=-1)
        {
          html=html.substring(pos+8);  
          pos = html.indexOf("布图设计登记号");
          if(pos!=-1)
          {
          htmlnew = html;
          html = html.substring(0, pos);
          pos = html.indexOf("<BR>");
          mapRegnumber = html.substring(0, pos);
          System.out.println("mapRegnumber==="+ mapRegnumber);
          html = html.substring(pos+4);
          
          pos = html.indexOf("布图设计申请日");
          html = html.substring(pos+8);
          pos = html.indexOf("<BR>");
          mapAd = html.substring(0, pos);
          System.out.println("mapAd==="+ mapAd);
          html = html.substring(pos+4);         
          
          pos = html.indexOf("公告日期");
          html = html.substring(pos+5);
          pos = html.indexOf("<BR>");
          mapPd = html.substring(0, pos);
          System.out.println("mapPd==="+ mapPd);
          html = html.substring(pos+4);         
 
          pos = html.indexOf("公告号");
          html = html.substring(pos+4);
          pos = html.indexOf("<BR>");
          mapPn = html.substring(0, pos);
          System.out.println("mapPn==="+ mapPn);
          html = html.substring(pos+4);         

          pos = html.indexOf("布图设计名称");
          html = html.substring(pos+7);
          pos = html.indexOf("<BR>");
          mapName = html.substring(0, pos);
          System.out.println("mapName==="+ mapName);
          html = html.substring(pos+4);   
          
          pos = html.indexOf("结构：");
          html = html.substring(pos+3);
          pos = html.indexOf("<BR>");
          mapStructure = html.substring(0, pos);
          System.out.println("mapStructure==="+ mapStructure);
          html = html.substring(pos+4);   

          pos = html.indexOf("技术：");
          html = html.substring(pos+3);
          pos = html.indexOf("<BR>");
          mapTech = html.substring(0, pos);
          System.out.println("mapTech==="+ mapTech);
          html = html.substring(pos+4);   
          
          pos = html.indexOf("功能：");
          html = html.substring(pos+3);
          pos = html.indexOf("<BR>");
          mapFunction = html.substring(0, pos);
          System.out.println("mapFunction==="+ mapFunction);
          html = html.substring(pos+4);   

          pos = html.indexOf("布图设计权利人");
          html = html.substring(pos+8);
          pos = html.indexOf("<BR>");
          mapInstitute = html.substring(0, pos);
          if(mapInstitute.length()>100)
        	  mapInstitute = mapInstitute.substring(0, 100); 
          System.out.println("mapInstitute==="+ mapInstitute);
          html = html.substring(pos+4);   

          pos = html.indexOf("布图设计权利人国籍");
          html = html.substring(pos+10);
          pos = html.indexOf("<BR>");
          mapCountry = html.substring(0, pos);
          System.out.println("mapCountry==="+ mapCountry);
          html = html.substring(pos+4);   
 
          pos = html.indexOf("布图设计权利人地址");
          html = html.substring(pos+10);
          pos = html.indexOf("<BR>");
          mapAddress = html.substring(0, pos);
          System.out.println("mapAddress==="+ mapAddress);
          html = html.substring(pos+4);   
           
          pos = html.indexOf("布图设计权利人");
          if(pos!=-1)
          {
          html = html.substring(pos+8);
          pos = html.indexOf("<BR>");
          mapInstituteCo = html.substring(0, pos);
          if(mapInstituteCo.length()>100)
        	  mapInstituteCo = mapInstituteCo.substring(0, 100); 
          System.out.println("mapInstituteCo==="+ mapInstituteCo);
          html = html.substring(pos+4);   
          }
          
          pos = html.indexOf("布图设计权利人国籍");
          if(pos!=-1)
          {
          html = html.substring(pos+10);
          pos = html.indexOf("<BR>");
          mapCountryCo = html.substring(0, pos);
          System.out.println("mapCountryCo==="+ mapCountryCo);
          html = html.substring(pos+4);   
          }
          
          pos = html.indexOf("布图设计权利人地址");
          if(pos!=-1)
          {          
          html = html.substring(pos+10);
          pos = html.indexOf("<BR>");
          mapAddressCo = html.substring(0, pos);
          System.out.println("mapAddressCo==="+ mapAddressCo);
          html = html.substring(pos+4);   
          }
          
          pos = html.indexOf("布图设计创作人");
          if(pos!=-1)
          {          
          html = html.substring(pos+8);
          pos = html.indexOf("<BR>");
          mapDesigner = html.substring(0, pos);
          System.out.println("mapDesigner==="+ mapDesigner);
          html = html.substring(pos+4);   
          }
          
          pos = html.indexOf("代理机构");
          if(pos!=-1)
          {          
       	  html = html.substring(pos+5);
          pos = html.indexOf("<BR>");
          mapProxy = html.substring(0, pos);
          System.out.println("mapProxy==="+ mapProxy);
          html = html.substring(pos+4);   
          }
          
          pos = html.indexOf("代理人");
          if(pos!=-1)
          {          
          html = html.substring(pos+4);
          pos = html.indexOf("<BR>");
          mapProxyer = html.substring(0, pos);
          System.out.println("mapProxyer==="+ mapProxyer);
          html = html.substring(pos+4);   
          }
          
          pos = html.indexOf("布图设计创作完成日");
          html = html.substring(pos+10);
          pos = html.indexOf("</P>");
          mapEndate = html.substring(0, pos);
          if(mapEndate.indexOf("<BR>")!=-1)
        	 mapEndate = mapEndate.substring(0,mapEndate.indexOf("<BR>"));
          System.out.println("mapEndate==="+ mapEndate);
          html = html.substring(pos+4);  
          

          Tmap map = new Tmap();
          if(mapAd!=null)
          map.setMapAd(mapAd.replaceAll("&nbsp;", ""));
          if(mapAddress!=null)
          map.setMapAddress(mapAddress.replaceAll("&nbsp;", ""));
          if(mapAddressCo!=null)
          map.setMapAddressCo(mapAddressCo.replaceAll("&nbsp;", ""));
          if(mapCountry!=null)
          map.setMapCountry(mapCountry.replaceAll("&nbsp;", ""));
          if(mapCountryCo!=null)
          map.setMapCountryCo(mapCountryCo.replaceAll("&nbsp;", ""));
          if(mapDesigner!=null)
          map.setMapDesigner(mapDesigner.replaceAll("&nbsp;", ""));
          if(mapEndate!=null)
          map.setMapEndate(mapEndate.replaceAll("&nbsp;", ""));
          if(mapFunction!=null)
          map.setMapFunction(mapFunction.replaceAll("&nbsp;", ""));
          if(mapInstitute!=null)
          map.setMapInstitute(mapInstitute.replaceAll("&nbsp;", ""));
          if(mapInstituteCo!=null)
          map.setMapInstituteCo(mapInstituteCo.replaceAll("&nbsp;", ""));
          if(mapName!=null)
          map.setMapName(mapName.replaceAll("&nbsp;", ""));
          if(mapPd!=null)
          map.setMapPd(mapPd.replaceAll("&nbsp;", ""));
          if(mapPn!=null)
          map.setMapPn(mapPn.replaceAll("&nbsp;", ""));
          if(mapProxy!=null)
          map.setMapProxy(mapProxy.replaceAll("&nbsp;", ""));
          if(mapProxyer!=null)
          map.setMapProxyer(mapProxyer.replaceAll("&nbsp;", ""));
          if(mapRegnumber!=null)
          map.setMapRegnumber(mapRegnumber.replaceAll("&nbsp;", ""));
          if(mapStructure!=null)
          map.setMapStructure(mapStructure.replaceAll("&nbsp;", ""));
          if(mapTech!=null)
          map.setMapTech(mapTech.replaceAll("&nbsp;", ""));
          tmapService.save(map);
          
          html = htmlnew;
          pos=html.indexOf("布图设计登记号");
        }
          else
          {
              pos = html.indexOf("<BR>");
              mapRegnumber = html.substring(0, pos);
              System.out.println("mapRegnumber==="+ mapRegnumber);
              html = html.substring(pos+4);
              
              pos = html.indexOf("布图设计申请日");
              html = html.substring(pos+8);
              pos = html.indexOf("<BR>");
              mapAd = html.substring(0, pos);
              System.out.println("mapAd==="+ mapAd);
              html = html.substring(pos+4);         
              
              pos = html.indexOf("公告日期");
              html = html.substring(pos+5);
              pos = html.indexOf("<BR>");
              mapPd = html.substring(0, pos);
              System.out.println("mapPd==="+ mapPd);
              html = html.substring(pos+4);         
     
              pos = html.indexOf("公告号");
              html = html.substring(pos+4);
              pos = html.indexOf("<BR>");
              mapPn = html.substring(0, pos);
              System.out.println("mapPn==="+ mapPn);
              html = html.substring(pos+4);         

              pos = html.indexOf("布图设计名称");
              html = html.substring(pos+7);
              pos = html.indexOf("<BR>");
              mapName = html.substring(0, pos);
              System.out.println("mapName==="+ mapName);
              html = html.substring(pos+4);   
              
              pos = html.indexOf("结构：");
              html = html.substring(pos+3);
              pos = html.indexOf("<BR>");
              mapStructure = html.substring(0, pos);
              System.out.println("mapStructure==="+ mapStructure);
              html = html.substring(pos+4);   

              pos = html.indexOf("技术：");
              html = html.substring(pos+3);
              pos = html.indexOf("<BR>");
              mapTech = html.substring(0, pos);
              System.out.println("mapTech==="+ mapTech);
              html = html.substring(pos+4);   
              
              pos = html.indexOf("功能：");
              html = html.substring(pos+3);
              pos = html.indexOf("<BR>");
              mapFunction = html.substring(0, pos);
              System.out.println("mapFunction==="+ mapFunction);
              html = html.substring(pos+4);   

              pos = html.indexOf("布图设计权利人");
              html = html.substring(pos+8);
              pos = html.indexOf("<BR>");
              mapInstitute = html.substring(0, pos);
              if(mapInstitute.length()>100)
            	  mapInstitute = mapInstitute.substring(0, 100); 
              System.out.println("mapInstitute==="+ mapInstitute);
              html = html.substring(pos+4);   

              pos = html.indexOf("布图设计权利人国籍");
              html = html.substring(pos+10);
              pos = html.indexOf("<BR>");
              mapCountry = html.substring(0, pos);
              System.out.println("mapCountry==="+ mapCountry);
              html = html.substring(pos+4);   
     
              pos = html.indexOf("布图设计权利人地址");
              html = html.substring(pos+10);
              pos = html.indexOf("<BR>");
              mapAddress = html.substring(0, pos);
              System.out.println("mapAddress==="+ mapAddress);
              html = html.substring(pos+4);   
               
              pos = html.indexOf("布图设计权利人");
              if(pos!=-1)
              {
              html = html.substring(pos+8);
              pos = html.indexOf("<BR>");
              mapInstituteCo = html.substring(0, pos);
              if(mapInstituteCo.length()>100)
            	  mapInstituteCo = mapInstituteCo.substring(0, 100); 
              System.out.println("mapInstituteCo==="+ mapInstituteCo);
              html = html.substring(pos+4);   
              }
              
              pos = html.indexOf("布图设计权利人国籍");
              if(pos!=-1)
              {
              html = html.substring(pos+10);
              pos = html.indexOf("<BR>");
              mapCountryCo = html.substring(0, pos);
              System.out.println("mapCountryCo==="+ mapCountryCo);
              html = html.substring(pos+4);   
              }
              
              pos = html.indexOf("布图设计权利人地址");
              if(pos!=-1)
              {          
              html = html.substring(pos+10);
              pos = html.indexOf("<BR>");
              mapAddressCo = html.substring(0, pos);
              System.out.println("mapAddressCo==="+ mapAddressCo);
              html = html.substring(pos+4);   
              }
              
              pos = html.indexOf("布图设计创作人");
              if(pos!=-1)
              {          
              html = html.substring(pos+8);
              pos = html.indexOf("<BR>");
              mapDesigner = html.substring(0, pos);
              System.out.println("mapDesigner==="+ mapDesigner);
              html = html.substring(pos+4);   
              }
              
              pos = html.indexOf("代理机构");
              if(pos!=-1)
              {          
           	  html = html.substring(pos+5);
              pos = html.indexOf("<BR>");
              mapProxy = html.substring(0, pos);
              System.out.println("mapProxy==="+ mapProxy);
              html = html.substring(pos+4);   
              }
              
              pos = html.indexOf("代理人");
              if(pos!=-1)
              {          
              html = html.substring(pos+4);
              pos = html.indexOf("<BR>");
              mapProxyer = html.substring(0, pos);
              System.out.println("mapProxyer==="+ mapProxyer);
              html = html.substring(pos+4);   
              }
              
              pos = html.indexOf("布图设计创作完成日");
              if(pos!=-1)
              {                        
              html = html.substring(pos+10);
              pos = html.indexOf("</P>");
              mapEndate = html.substring(0, pos);
              if(mapEndate.indexOf("<BR>")!=-1)
            	 mapEndate = mapEndate.substring(0,mapEndate.indexOf("<BR>"));
              System.out.println("mapEndate==="+ mapEndate);
              html = html.substring(pos+4);  
              }

              Tmap map = new Tmap();
              if(mapAd!=null)
                  map.setMapAd(mapAd.replaceAll("&nbsp;", ""));
                  if(mapAddress!=null)
                  map.setMapAddress(mapAddress.replaceAll("&nbsp;", ""));
                  if(mapAddressCo!=null)
                  map.setMapAddressCo(mapAddressCo.replaceAll("&nbsp;", ""));
                  if(mapCountry!=null)
                  map.setMapCountry(mapCountry.replaceAll("&nbsp;", ""));
                  if(mapCountryCo!=null)
                  map.setMapCountryCo(mapCountryCo.replaceAll("&nbsp;", ""));
                  if(mapDesigner!=null)
                  map.setMapDesigner(mapDesigner.replaceAll("&nbsp;", ""));
                  if(mapEndate!=null)
                  map.setMapEndate(mapEndate.replaceAll("&nbsp;", ""));
                  if(mapFunction!=null)
                  map.setMapFunction(mapFunction.replaceAll("&nbsp;", ""));
                  if(mapInstitute!=null)
                  map.setMapInstitute(mapInstitute.replaceAll("&nbsp;", ""));
                  if(mapInstituteCo!=null)
                  map.setMapInstituteCo(mapInstituteCo.replaceAll("&nbsp;", ""));
                  if(mapName!=null)
                  map.setMapName(mapName.replaceAll("&nbsp;", ""));
                  if(mapPd!=null)
                  map.setMapPd(mapPd.replaceAll("&nbsp;", ""));
                  if(mapPn!=null)
                  map.setMapPn(mapPn.replaceAll("&nbsp;", ""));
                  if(mapProxy!=null)
                  map.setMapProxy(mapProxy.replaceAll("&nbsp;", ""));
                  if(mapProxyer!=null)
                  map.setMapProxyer(mapProxyer.replaceAll("&nbsp;", ""));
                  if(mapRegnumber!=null)
                  map.setMapRegnumber(mapRegnumber.replaceAll("&nbsp;", ""));
                  if(mapStructure!=null)
                  map.setMapStructure(mapStructure.replaceAll("&nbsp;", ""));
                  if(mapTech!=null)
                  map.setMapTech(mapTech.replaceAll("&nbsp;", ""));
              tmapService.save(map);        	  
        	  
              pos=-1;
          }
      }        

 	}
	
	
	@RequestMapping(value="/GetSoftware")	
	public String GetSoftware(HttpServletRequest request) throws InterruptedException
	{
	  String html = null;
	  for(int i=107; i<108; i++)
	  {
		System.out.println("第"+i+"次采集");  
		Thread.sleep(5000);
		String URL = "http://www.ccopyright.com.cn/cpcc/RRegisterAction.do?method=list&no=fck&sql_name=&sql_regnum=&sql_author=%D6%D0%B9%FA%BF%C6%D1%A7%D4%BA&curPage="+i+"&count=50&sortOrder=&sortLabel=";
		System.out.println(URL);
		try {
			httpClient = new DefaultHttpClient();  
			HttpParams params = httpClient.getParams();
			HttpConnectionParams.setConnectionTimeout(params, 120000);
			HttpConnectionParams.setSoTimeout(params, 120000);		
			//URL = URL.replace("\"", "%22");
			HttpGet httpget = new HttpGet(URL); 
			HttpResponse responce;
			responce = httpClient.execute(httpget);
			if (responce.getStatusLine().getStatusCode() == HttpStatus.SC_OK) 
			{   
			    HttpEntity entity = responce.getEntity();   
			    if (entity != null) 
			    {   
			        html = EntityUtils.toString(entity);
			        int start = html.indexOf("登记日期");			        
			        if(start!=-1)
			        {
			           html = html.substring(start);
			           start = html.indexOf("</tr>");
			           html = html.substring(start+4);
			           html = html.trim();
			           int end = html.indexOf("记录总数");
			           if(end!=-1)
			           {
			             html = html.substring(0, end);	
			             html = "<table>  " + html;
			           }
			        }
			        	
			        entity = null;			        
			        JsoupAndStore(html);
			    }   
			}
			if(html == null)
			{
				System.out.println(URL);
			}
		} catch (NumberFormatException e) {
			
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  }// end of for
	  return "";		
	}
	
	public void JsoupAndStore(String html) throws InterruptedException {

	  String[] swclass= new String[51];
	  String[] swregnum = new String[51];
	  String[] swname = new String[51]; 
	  String[] swnameabb = new String[51]; 
	  String[] swver = new String[51]; 
	  String[] swauthor = new String[51]; 
	  String[] swpd = new String[51]; 
	  String[] swopen = new String[51]; 
	  
	  Document doc = Jsoup.parse(html);				
	  Elements tdlist = doc.select("td");        
	  Iterator<Element> td = tdlist.iterator();
	  int i=0,n=0;
	  
      while(td.hasNext())
	  {
		  Element software = td.next();	
          //System.out.println("i=="+ i + "====" + software.text());
          //Thread.sleep(1000);
          if(i==0)
	        swregnum[n] = software.text();
          if(i==1)
	        swclass[n] = software.text();
          if(i==2)
          {	  
	        swname[n] = software.text();
	        System.out.println(swname[n]); 
          }
          if(i==3)        	  
	        swnameabb[n]= software.text();
          if(i==4)
	        swver[n] = software.text();
          if(i==5)
	        swauthor[n] = software.text();
          if(i==6)
	        swopen[n] = software.text();
          if(i==7)
	        swpd[n] = software.text();
          
          i++;
          if(i%8==0)
          {
            n++;
            i=0;
          }
	   }

      //存储
      Tsoftware st = new Tsoftware();
      for(int m=0; m<swregnum.length; m++)
      {
        st.setSwName(swname[m]);
        st.setSwRegnumber(swregnum[m]);
        st.setSwClass(swclass[m]);
        st.setSwAuthor(swauthor[m]);
        st.setSwPd(swpd[m]);
        st.setSwOpen(swopen[m]);
        st.setSwVer(swver[m]);
        st.setSwNameAbb(swnameabb[m]);
        tsoftService.save(st);        
      }
	}
	
}