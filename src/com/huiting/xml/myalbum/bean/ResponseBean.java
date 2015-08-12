package com.huiting.xml.myalbum.bean;

 

import java.util.ArrayList;

import com.huiting.xml.bean.ResHeadBean;

public class ResponseBean extends ResHeadBean{
	
	private ArrayList<AlbumListBean> AlbumList = new  ArrayList<AlbumListBean>();

	public ArrayList<AlbumListBean> getAlbumList() {
		return AlbumList;
	}

	public void setAlbumList(ArrayList<AlbumListBean> albumList) {
		AlbumList = albumList;
	}
	

}
