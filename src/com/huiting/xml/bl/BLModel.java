package com.huiting.xml.bl;


import com.huiting.xml.dao.AudioHuibenDao;
import com.huiting.xml.dao.HuibenDao;
import com.huiting.xml.dao.PicHuibenDao;
import com.huiting.xml.dao.ProgramDao;
import com.huiting.xml.dto.AudioHuibenDto;
import com.huiting.xml.dto.HuibenDto;
import com.huiting.xml.dto.ModelDto;
import com.huiting.xml.dto.PicHuibenDto;
import com.huiting.xml.dto.ProgramDto;

public class BLModel {
	AudioHuibenDao audioHuibenDao;
	HuibenDao huibenDao;
	PicHuibenDao picHuibenDao;
	ProgramDao programDao ;
	
	
	public ModelDto handle(String modular, String id){
		ModelDto modelDto = new ModelDto();
		
		
		if("B01".equals(modular)){
			PicHuibenDto pichuibenDto = new PicHuibenDto();
			pichuibenDto = picHuibenDao.selectbyid(id);
			modelDto.setName(pichuibenDto.getAudioName());
			modelDto.setAudiourl(pichuibenDto.getAudioURL());
			modelDto.setPicurl(pichuibenDto.getPicbookURL());
			modelDto.setContent(pichuibenDto.getAudioContent());
			
		}else if("B02".equals(modular)){
			AudioHuibenDto audioHuibenDto = new AudioHuibenDto();
			audioHuibenDto = audioHuibenDao.selectbyid(id);
			modelDto.setName(audioHuibenDto.getAudioName());
			modelDto.setAudiourl(audioHuibenDto.getAudioURL());
			modelDto.setPicurl(audioHuibenDto.getPicbookURL());
			modelDto.setContent(audioHuibenDto.getAudioContent());
		}else if("B03".equals(modular)){
			HuibenDto huibenDto = new HuibenDto();
			huibenDto = huibenDao.selectbyid(id);
			modelDto.setName(huibenDto.getAudioName());
			modelDto.setAudiourl(huibenDto.getAudioURL());
			modelDto.setPicurl(huibenDto.getPicbookURL());
			modelDto.setContent(huibenDto.getAudioContent());
		}else if("P01".equals(modular)){
			ProgramDto programDto = new ProgramDto();
			programDto = programDao.selectById(id);
			modelDto.setName(programDto.getProgramName());
			modelDto.setAudiourl(programDto.getProgramURL());
			modelDto.setPicurl(programDto.getProgramPic());
			modelDto.setContent(programDto.getDescription());
		}
		
		return modelDto;
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


	public PicHuibenDao getPicHuibenDao() {
		return picHuibenDao;
	}


	public void setPicHuibenDao(PicHuibenDao picHuibenDao) {
		this.picHuibenDao = picHuibenDao;
	}


	public ProgramDao getProgramDao() {
		return programDao;
	}


	public void setProgramDao(ProgramDao programDao) {
		this.programDao = programDao;
	}
	
	
}
