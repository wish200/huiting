package com.huiting.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

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
import com.alibaba.fastjson.JSONObject;
import com.huiting.common.SpringBeanFactory;
import com.huiting.xml.bl.BLModel;
import com.huiting.xml.dto.ModelDto;

public class ModelServlet extends HttpServlet{

	public ModelServlet() {
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
		
		String modular = request.getParameter("m");
		String id = request.getParameter("i");
		String sign = request.getParameter("s");
		
		ModelDto modeldto =  new ModelDto();
		
		
		BLModel blModel = (BLModel)SpringBeanFactory.lookup("blModel");
		modeldto = blModel.handle(modular, id);
		request.setCharacterEncoding("utf-8");
		request.setAttribute("name", modeldto.getName());
		request.setAttribute("picurl", modeldto.getPicurl());
		request.setAttribute("audiourl", modeldto.getAudiourl());
		request.setAttribute("content", modeldto.getContent());
		
		request.getRequestDispatcher("./m/m1.jsp").forward(request, response);
		 
			
	}


	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	/*public void init() throws ServletException {
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
         
	}*/
}
