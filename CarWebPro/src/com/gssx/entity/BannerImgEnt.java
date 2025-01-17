package com.gssx.entity;

public class BannerImgEnt {
	
	  private  int     bannerId;
	  private  String  bannerName;
	  private  String  bannerImg;
	  
	public int getBannerId() {
		return bannerId;
	}
	public void setBannerId(int bannerId) {
		this.bannerId = bannerId;
	}
	public String getBannerName() {
		return bannerName;
	}
	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}
	public String getBannerImg() {
		return bannerImg;
	}
	public void setBannerImg(String bannerImg) {
		this.bannerImg = bannerImg;
	}
	
	
	public BannerImgEnt(int bannerId, String bannerName, String bannerImg) {
		super();
		this.bannerId = bannerId;
		this.bannerName = bannerName;
		this.bannerImg = bannerImg;
	}
	
	
	public BannerImgEnt() {
		super();
	}
	@Override
	public String toString() {
		return "bannerimgEnt [bannerId=" + bannerId + ", bannerName=" + bannerName + ", bannerImg=" + bannerImg + "]";
	}
	public BannerImgEnt(String bannerName, String bannerImg) {
		super();
		this.bannerName = bannerName;
		this.bannerImg = bannerImg;
	}
	  

}
