package com.huiting.servlet;
 
import java.io.File; 
import java.io.IOException; 
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.huiting.action.HuiTingAction;
import com.huiting.cache.SystemCache;
import com.huiting.xml.bean.ResHeadBean;
import com.huiting.xml.dao.CcUploadFilesDao;
import com.huiting.xml.dto.CcUploadFilesDto;

public class UploadServlet extends HttpServlet{

	public UploadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
        doPost(request,response);
		 
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String resultjsonString = "";
		 boolean isMultipart = ServletFileUpload.isMultipartContent(request); 
		 String userid = request.getParameter("userid");
		 System.out.println("userid----------shangxingcanshu-------"+userid);
		 Map<String, String> paramMap = new HashMap<String, String>();
		 Map<String, String> uplaodparamMap = new HashMap<String, String>();
		 
		 String isorigin ="1";
		 String type ="pic";
		 String result="";
		 
		 String fileName ="";
		 String fieldName ="";
		 CcUploadFilesDto ccUploadFilesDto = new CcUploadFilesDto();
		 CcUploadFilesDao ccUploadFilesDao = (CcUploadFilesDao)com.huiting.common.SpringBeanFactory.lookup("ccUploadFilesDao");
		 
			
		 String httphead = "Encoding:"+request.getCharacterEncoding()+";ContentType:"+request.getContentType()+";ReqAddr:"+request.getRemoteAddr()+";ReqPort:"+request.getRemotePort()+";ReqURI:"+request.getRequestURI();
	       if (isMultipart) {    
	           FileItemFactory factory = new DiskFileItemFactory();    
	           ServletFileUpload upload = new ServletFileUpload(factory);   
	           
	           try {    
	               List items = upload.parseRequest(request);   
	               Iterator iter = items.iterator();    
	               while (iter.hasNext()) {    
	                   FileItem item = (FileItem) iter.next();
	                   System.out.println("itemname="+item.getFieldName());
	                   if (item.isFormField()) {    
	                       //普通文本信息处理    
	                       String paramName = item.getFieldName();    
	                       String paramValue = item.getString("utf-8");  
	                       paramMap.put(paramName, paramValue);
	                       System.out.println(paramName + ":" + paramValue);    
	                   } else {    
	                       //上传文件信息处理    
	                       fileName = item.getName();
	                       fieldName = item.getFieldName();
	                       if(item.getSize()>2*1024*1024){
	                    	   isorigin = "0";
	                       }
	                       if(SystemCache.getCache("audiopublish.inter")!=null&&SystemCache.getCache("audiopublish.inter").indexOf(paramMap.get("RequestType"))>-1){
	                    	   type = "audio";   
	                       }
	                       uplaodparamMap.put("isorigin", isorigin);
	                       uplaodparamMap.put("type", type);
	                       uplaodparamMap.put("UserID", paramMap.get("UserID"));
	                       
	                       result = new requestclient().toUploadSingleFile(item.getInputStream(),fieldName,fileName, SystemCache.getCache("upload.url"), uplaodparamMap);
	                       paramMap.putAll(JSON.parseObject(result, new TypeReference<Map<String, String>>() {}));
	                       
	                       try {
	                    	   ccUploadFilesDto.setFileid(UUID.randomUUID().toString());
	                    	   ccUploadFilesDto.setCreatetime(new Timestamp(System.currentTimeMillis()));
	                    	   ccUploadFilesDto.setCreateusercode(paramMap.get("UserID"));
	                    	   ccUploadFilesDto.setFilegroupid(new SimpleDateFormat("yyyyMMdd").format(new java.util.Date()));
 	               			 	ccUploadFilesDto.setModuleid(fieldName);
	                    	   ccUploadFilesDto.setSavepath(paramMap.get(fieldName));
	                    	   ccUploadFilesDto.setUploadcontenttype(fileName.substring(fileName.indexOf(".")+1));
	                    	   ccUploadFilesDto.setUploadfilename(fileName);
	                    	   ccUploadFilesDto.setUploadrealname(paramMap.get(fieldName)==null?"":paramMap.get(fieldName).substring(paramMap.get(fieldName).lastIndexOf("/")+1));
	                    	   ccUploadFilesDao.insert(ccUploadFilesDto);
						} catch (Exception e) {
							e.printStackTrace();
							// TODO: handle exception
						}
	                        
	                   }    
	               }   
	               //System.out.println(paramMap);
	               resultjsonString = new HuiTingAction().parseJson(JSON.toJSONString(paramMap), httphead);
	               System.out.println("resultjsonString--"+resultjsonString);
	           } catch (FileUploadException e) {    
	               e.printStackTrace();   
	               resultjsonString=genResponseHeadXml(paramMap,"系统错误");
	               
	           }  catch (Exception e1) {    
	               e1.printStackTrace();    
	               resultjsonString= genResponseHeadXml(paramMap,"系统错误");
	           }    
	       }  
	       response.setContentType("text/html;charset=UTF-8");
	       response.getWriter().write(resultjsonString); 
	       response.getWriter().close();
			
			
	}
	
	public String genResponseHeadXml(Map<String, String> map,String error){
		ResHeadBean resHeadBean = new ResHeadBean(); 
		resHeadBean.setRequestType(map.get("RequestType"));
		resHeadBean.setSendTime(new Timestamp(System.currentTimeMillis()));
		resHeadBean.setUUID(map.get("UUID"));
		resHeadBean.setErrorMessage(error);
		if(error!=null&&!"".equals(error)){
			resHeadBean.setResponseCode("1");
		}else{
			resHeadBean.setResponseCode("0");
		}
		
		return JSON.toJSONString(resHeadBean);
	}
	
	public String hashfile(String UserID){
		int hash = hash(UserID.hashCode());
		int i = hash & 1023;
		return i+"";
	}
	
	static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		System.out.println("-------------init--------------------");
		String v = this.getInitParameter("a"); 
		System.out.println("-------------a--------------------"+v);
        Enumeration e = this.getInitParameterNames(); 
        while(e.hasMoreElements()){ 
            System.out.println(">>haha>>"+e.nextElement()); 
        } 
		try {
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         
	}
}
