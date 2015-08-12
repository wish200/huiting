package com.huiting.xml.picbookpublish.bl;

import java.sql.Timestamp;

import com.huiting.cache.SystemCache;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.PicBookDao;
import com.huiting.xml.dto.PicBookDto;
import com.huiting.xml.picbookpublish.bean.RequestBean;
import com.huiting.xml.picbookpublish.bean.ResponseBean;;

public class BLPicbookPublish   extends BLBaseAction{
	PicBookDao picBookDao ;
	
	public Object handleXML(RequestBean requestBean){
		
		ResponseBean resHuiTingBean = new ResponseBean();
		String error = ""; 
		PicBookDto picBookDto = new PicBookDto();
		String PicbookId="";
		String PicbookURL="";
		try{ 
			picBookDto.setUserID(requestBean.getUserID());
			picBookDto.setNickName(requestBean.getNickName());
			picBookDto.setPicbookName(requestBean.getPicbookName());
			picBookDto.setPicScene(requestBean.getPicScene());
			picBookDto.setPicBookSource(requestBean.getPicBookSource());
			picBookDto.setPicbookURL(requestBean.getPicbookURL());
			picBookDto.setPicbookStatus("1");
			picBookDto.setUploadTime(new Timestamp(System.currentTimeMillis()));
			picBookDto.setFlowerCnt(0);
			PicbookId = genPicbookID("P");
			picBookDto.setPicbookID(PicbookId);
			 
			
			if(picBookDao==null){
				picBookDao = (PicBookDao)com.huiting.common.SpringBeanFactory.lookup("picBookDao");
			}
			picBookDao.insert(picBookDto);
			 
			resHuiTingBean.setUserID(requestBean.getUserID());
			resHuiTingBean.setPicbookId(PicbookId);
			resHuiTingBean.setPicbookURL(requestBean.getPicbookURL());
			genResponseHeadXml(resHuiTingBean,requestBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			error ="UPLOAD_FAIL";
			genResponseHeadXml(resHuiTingBean,requestBean,"系统错误");
		}
		return resHuiTingBean;
	}

	public PicBookDao getPicBookDao() {
		return picBookDao;
	}

	public void setPicBookDao(PicBookDao picBookDao) {
		this.picBookDao = picBookDao;
	}

	

	
}
