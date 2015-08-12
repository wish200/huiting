package com.huiting.xml.down.bl;




import com.huiting.common.BeanUtil;
import com.huiting.xml.bl.BLBaseAction;
import com.huiting.xml.dao.DownDao;
import com.huiting.xml.dto.DownDto;
import com.huiting.xml.down.bean.RequestBean;
import com.huiting.xml.down.bean.ResponseBean;

public class BLDown  extends BLBaseAction{
	DownDao downDao;
	
	public Object handleXML(RequestBean reqHuiTingBean){
		DownDto DownDto = new DownDto();
		ResponseBean resHuiTingBean = new ResponseBean();
		String error="";
		try{
			BeanUtil.coverBean2Dto(reqHuiTingBean, DownDto);
			downDao.insert(DownDto);
			genResponseHeadXml(resHuiTingBean,reqHuiTingBean,error);
		}catch(Exception e ){
			e.printStackTrace();
			genResponseHeadXml(resHuiTingBean, reqHuiTingBean,"系统错误");
		}
		
		return resHuiTingBean;
	}

	public DownDao getDownDao() {
		return downDao;
	}

	public void setDownDao(DownDao downDao) {
		this.downDao = downDao;
	}
	  
	
	
}
