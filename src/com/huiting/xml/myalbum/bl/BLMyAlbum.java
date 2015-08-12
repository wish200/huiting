package com.huiting.xml.myalbum.bl;



import java.util.ArrayList;
import java.util.List;

import com.huiting.xml.myalbum.bean.AlbumListBean;
import com.huiting.xml.myalbum.bean.RequestBean;
import com.huiting.xml.myalbum.bean.ResponseBean;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.AlbumDao;

public class BLMyAlbum   extends BLBaseAction{
	AlbumDao albumDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		 
		ResponseBean resHuiTingBean = new ResponseBean();
		String error="";
		
		List<AlbumListBean> albumList = new ArrayList<AlbumListBean>();
		try{
			albumList = albumDao.queryListByUserID(reqHuiTingBean.getUserID(), reqHuiTingBean.getPage()*countperpage,countperpage);
			resHuiTingBean.setAlbumList((ArrayList<AlbumListBean>)albumList);
			 
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean, reqHuiTingBean,"系统错误");
		}
		
		
		return resHuiTingBean;
		
	} 

	public AlbumDao getAlbumDao() {
		return albumDao;
	}

	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}
	
}
