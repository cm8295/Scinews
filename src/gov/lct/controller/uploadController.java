package gov.lct.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.application.Application;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.hp.hpl.jena.sparql.pfunction.library.listIndex;

import antlr.collections.List;
import gov.lct.model.Tupload;
import gov.lct.service.TuploadService;

@Controller
@RequestMapping(value = "file")
public class uploadController {
	
	@Autowired
	private TuploadService tuploadService;
	
	@RequestMapping("/upload")
	public String upload(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
		String loginname = null;
		try {
			HttpSession session = request.getSession();	
			//String realname = session.getAttribute("realname").toString();
			loginname = session.getAttribute("loginname").toString();		
			//System.out.println(realname);
			//System.out.println(loginname);
	        //System.out.println(file);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//保存所有文件名
		ArrayList<String> files = new ArrayList<String>();
		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames(); 
            while(iter.hasNext()){  
                //记录上传过程起始时的时间，用来计算上传时间  
                int pre = (int) System.currentTimeMillis(); 
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){  
                    //取得当前上传文件的文件名称  
                    String myFileName = file.getOriginalFilename();  
                    //如果名称不为"",说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !=""){  
                        System.out.println(myFileName);  
                        //重命名上传后的文件名  
                        String fileName = file.getOriginalFilename();  
                        System.out.println(file.getName());
                        //定义上传路径  request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
                        String dir = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/" + loginname);
                        File fileDir = new File(dir);
                        if (!fileDir.exists() && !fileDir.isDirectory()) {
							fileDir.mkdirs();
						}
                        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/upload/" + loginname) + File.separator + fileName;
                        System.out.println(path);
                        File localFile = new File(path);  
                        file.transferTo(localFile);  
                    }  
                }  
                //记录上传该文件后的时间  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre);
                //存储上传文件
                Tupload tupload = new Tupload();
                tupload.setLoginname(loginname);
                tupload.setFile1(request.getParameter("file1"));
                tupload.setFile2(request.getParameter("file2"));
                tupload.setFile3(request.getParameter("file3"));
                tupload.setFile4(request.getParameter("file4"));
                tupload.setFile5(request.getParameter("file5"));
                tupload.setFile6(request.getParameter("file6"));
                tupload.setFile7(request.getParameter("file7"));
                tupload.setFile8(request.getParameter("file8"));
                tupload.setFile9(request.getParameter("file9"));
                tupload.setFile10(request.getParameter("file10"));
                tupload.setFile11(request.getParameter("file11"));
                tupload.setFile12(request.getParameter("file12"));
                tupload.setFile13(request.getParameter("file13"));
                tupload.setFile14(request.getParameter("file14"));
                tupload.setUploadtime(Integer.toString(finaltime));
                tuploadService.save(tupload);
            }  
        }  
        return "unauth/manage/upload";
	}
	
	@RequestMapping("toupload")
	public String toupload(){
		
		return "unauth/manage/upload";
	}
	
	@RequestMapping("/download")
	public String download(HttpServletRequest request,
            HttpServletResponse response){
		response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        String fileName = request.getParameter("fileName");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + fileName);
        try {
           // String path = Thread.currentThread().getContextClassLoader()
           //         .getResource("").getPath()
           //         + "download";//这个download目录为啥建立在classes下的
        	String path = "G:/";
            InputStream inputStream = new FileInputStream(new File(path
                    + File.separator + fileName));
 
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
 
             // 这里主要关闭。
            os.close();
 
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return "unauth/manage/download";
	}
	
	@RequestMapping("todownload")
	public String todownload(){
		return "unauth/manage/download";
	}

}
