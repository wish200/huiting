package com.huiting.xml.audiopublish.bl;

import java.sql.Timestamp;

import com.huiting.cache.SystemCache;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.AudioDao;
import com.huiting.xml.dto.AudioDto;
import com.huiting.xml.audiopublish.bean.RequestBean;
import com.huiting.xml.audiopublish.bean.ResponseBean;;

public class BLAudioPublish   extends BLBaseAction{
	AudioDao audioDao ;
	
	public Object handleXML(RequestBean requestBean){
		
		ResponseBean resHuiTingBean = new ResponseBean();
		String error = "";
		AudioDto audioDto = new AudioDto();
		String AudioId="";
		try{ 
			audioDto.setUserID(requestBean.getUserID());
			audioDto.setNickName(requestBean.getNickName());
			audioDto.setAudioName(requestBean.getAudioName());
			audioDto.setAudioSource(requestBean.getAudioSource());
			audioDto.setAudioLength(requestBean.getAudioLength());
			audioDto.setAudioContent(requestBean.getAudioContent());
			audioDto.setAudioURL(requestBean.getAudioURL());
			audioDto.setUploadTime(new Timestamp(System.currentTimeMillis()));
			audioDto.setAudioStatus("1");
			audioDto.setFlowerCnt(0);	
			
			AudioId = genAudioID("A");
			audioDto.setAudioID(AudioId);
			
			
			  
			
			if(audioDao==null){
				audioDao = (AudioDao)com.huiting.common.SpringBeanFactory.lookup("audioDao");
			}
			audioDao.insert(audioDto);
			 
			resHuiTingBean.setUserID(requestBean.getUserID());
			resHuiTingBean.setAudioId(AudioId);
			resHuiTingBean.setAudioURL(requestBean.getAudioURL());
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

	 


	
}
