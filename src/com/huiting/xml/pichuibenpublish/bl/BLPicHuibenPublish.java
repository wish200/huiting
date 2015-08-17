package com.huiting.xml.pichuibenpublish.bl;

import java.sql.Timestamp;

import com.huiting.cache.SystemCache;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.AudioDao;
import com.huiting.xml.dao.AudioHuibenDao;
import com.huiting.xml.dao.HuibenDao;
import com.huiting.xml.dao.PicBookDao;
import com.huiting.xml.dao.PicHuibenDao;
import com.huiting.xml.dto.AudioDto;
import com.huiting.xml.dto.AudioHuibenDto;
import com.huiting.xml.dto.HuibenDto;
import com.huiting.xml.dto.PicBookDto;
import com.huiting.xml.dto.PicHuibenDto;
import com.huiting.xml.pichuibenpublish.bean.RequestBean;
import com.huiting.xml.pichuibenpublish.bean.ResponseBean;


public class BLPicHuibenPublish   extends BLBaseAction{
	AudioDao audioDao ;
	AudioHuibenDao audioHuibenDao;
	HuibenDao huibenDao;
	
	public Object handleXML(RequestBean requestBean){
		

		ResponseBean resHuiTingBean = new ResponseBean();
		String error = "";
		AudioDto audioDto = new AudioDto();
		AudioHuibenDto audioHuibenDto = new AudioHuibenDto();
		HuibenDto HuibenDto = new HuibenDto();
		String AudioId="";
		String AudioURL="";
		String huibenid="";
		
		try{ 
			audioDto.setUserID(requestBean.getUserID());
			audioDto.setNickName(requestBean.getNickName());
			audioDto.setAudioName(requestBean.getAudioName());
			audioDto.setAudioLength(requestBean.getAudioLength());
			audioDto.setAudioContent(requestBean.getAudioContent());
			audioDto.setUploadTime(new Timestamp(System.currentTimeMillis()));
			audioDto.setAudioStatus("1");
			audioDto.setFlowerCnt(0);
			AudioId = genAudioID("A");
			AudioURL=requestBean.getAudioURL();
			audioDto.setAudioID(AudioId);
			audioDto.setAudioURL(AudioURL);
			audioDto.setBackGoundPic(requestBean.getPicbookURL());
			
			if(requestBean.getPicbookUserID().equals(requestBean.getUserID())){
				huibenid =  genHuibenID("H");
				
				HuibenDto.setHuibenID(huibenid);
				HuibenDto.setPicbookID(requestBean.getPicbookID());
				HuibenDto.setPicbookName(requestBean.getPicbookName());
				HuibenDto.setPicbookURL(requestBean.getPicbookURL());
				HuibenDto.setPicScene(requestBean.getPicScene());
				HuibenDto.setUserID(requestBean.getUserID());
				HuibenDto.setNickName(requestBean.getNickName());
				HuibenDto.setUserPic(requestBean.getUserPic());
				HuibenDto.setAudioID(AudioId);
				HuibenDto.setAudioName(requestBean.getAudioName());
				HuibenDto.setAudioURL(AudioURL);
				HuibenDto.setAudioContent(requestBean.getAudioContent());
				HuibenDto.setAudioLength(requestBean.getAudioLength());
				HuibenDto.setFlowerCnt(0);
				HuibenDto.setStatus("1");
				HuibenDto.setCommentCnt(0);
				HuibenDto.setCreateTime(new Timestamp(System.currentTimeMillis()));
				if(huibenDao==null){
					huibenDao = (HuibenDao)com.huiting.common.SpringBeanFactory.lookup("huibenDao");
				}
				huibenDao.insert(HuibenDto);
			}else{
				huibenid =  genHuibenID("AH");
				
				audioHuibenDto.setHuibenID(huibenid);
				audioHuibenDto.setPicbookID(requestBean.getPicbookID());
				audioHuibenDto.setPicbookName(requestBean.getPicbookName());
				audioHuibenDto.setPicbookURL(requestBean.getPicbookURL());
				audioHuibenDto.setPicScene(requestBean.getPicScene());
				audioHuibenDto.setUserID(requestBean.getUserID());
				audioHuibenDto.setNickName(requestBean.getNickName());
				audioHuibenDto.setUserPic(requestBean.getUserPic());
				audioHuibenDto.setAudioID(AudioId);
				audioHuibenDto.setAudioName(requestBean.getAudioName());
				audioHuibenDto.setAudioContent(requestBean.getAudioContent());
				audioHuibenDto.setAudioLength(requestBean.getAudioLength());
				audioHuibenDto.setAudioURL(AudioURL);
				audioHuibenDto.setFlowerCnt(0);
				audioHuibenDto.setStatus("1");
				audioHuibenDto.setCommentCnt(0);
				audioHuibenDto.setCreateTime(new Timestamp(System.currentTimeMillis()));
				if(audioHuibenDao==null){
					audioHuibenDao = (AudioHuibenDao)com.huiting.common.SpringBeanFactory.lookup("audioHuibenDao");
				}
				audioHuibenDao.insert(audioHuibenDto);
			}
			
			
			
			if(audioDao==null){
				audioDao = (AudioDao)com.huiting.common.SpringBeanFactory.lookup("audioDao");
			}
			
			audioDao.insert(audioDto);
			
			
			resHuiTingBean.setUserID(requestBean.getUserID());
			resHuiTingBean.setAudioId(AudioId);
			resHuiTingBean.setAudioURL(AudioURL);
			genResponseHeadXml(resHuiTingBean,requestBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			error ="UPLOAD_FAIL";
			genResponseHeadXml(resHuiTingBean,requestBean,"系统错误");
		}
		return resHuiTingBean;
	}

	 

	
	public AudioDao getAudioDao() {
		return audioDao;
	}

	public void setAudioDao(AudioDao audioDao) {
		this.audioDao = audioDao;
	}

	public AudioHuibenDao getAudioHuibenDao() {
		return audioHuibenDao;
	}

	public void setAudioHuibenDao(AudioHuibenDao audioHuibenDao) {
		this.audioHuibenDao = audioHuibenDao;
	}

	public HuibenDao getHuibenDao() {
		return huibenDao;
	}

	public void setHuibenDao(HuibenDao huibenDao) {
		this.huibenDao = huibenDao;
	}

	 


	
}
