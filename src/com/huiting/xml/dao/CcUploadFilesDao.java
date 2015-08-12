package com.huiting.xml.dao;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.huiting.xml.dto.AudioDto;
import com.huiting.xml.dto.CcUploadFilesDto;

public class CcUploadFilesDao extends SqlMapClientDaoSupport{
	public void insert(CcUploadFilesDto ccUploadFilesDto) {
        getSqlMapClientTemplate().insert("AttachInfo.insert", ccUploadFilesDto);
    }
	public void delete(AudioDto audioDto) {
        getSqlMapClientTemplate().delete("AttachInfo.delete", audioDto);
    }
	public CcUploadFilesDto selectById(String filegroupid) {
        return (CcUploadFilesDto)getSqlMapClientTemplate().queryForObject("AttachInfo.selectbyid", filegroupid);
    }
	public List queryList(CcUploadFilesDto CcUploadFilesDto,int skipResults, int maxResults) {
        return getSqlMapClientTemplate().queryForList("AttachInfo.querylist",CcUploadFilesDto, skipResults, maxResults);
    }
	public void update(CcUploadFilesDto CcUploadFilesDto) {
        getSqlMapClientTemplate().update("AttachInfo.update", CcUploadFilesDto);
    }
	
 
}
