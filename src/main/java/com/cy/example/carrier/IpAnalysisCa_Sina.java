package com.cy.example.carrier;

public class IpAnalysisCa_Sina {

	/*
	 * 2. 响应信息：
		（json格式的）国家 、省（自治区或直辖市）、市（县）、运营商
		3. 返回数据格式：
		var remote_ip_info = {"ret":1,"start":-1,"end":-1,"country":"\u4e2d\u56fd"
		,"province":"\u4e0a\u6d77","city":"\u4e0a\u6d77","district":"","isp":"","type":"","desc":""};
		其中code的值的含义为，1成功
	 */
	private int ret;
	
	private String country;
	
	private String province;
	
	private String city;
	
	private String isp;
	
	private String type;
	
	private String desc;

	public int getRet() {
		return ret;
	}

	public void setRet(int ret) {
		this.ret = ret;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
