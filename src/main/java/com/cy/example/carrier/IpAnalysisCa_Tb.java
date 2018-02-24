package com.cy.example.carrier;

public class IpAnalysisCa_Tb {

	/*
	 * 2. 响应信息：
		（json格式的）国家 、省（自治区或直辖市）、市（县）、运营商
		3. 返回数据格式：
		{"code":0,"data":{"ip":"210.75.225.254","country":"\u4e2d\u56fd","area":"\u534e\u5317",
		"region":"\u5317\u4eac\u5e02","city":"\u5317\u4eac\u5e02","county":"","isp":"\u7535\u4fe1",
		"country_id":"86","area_id":"100000","region_id":"110000","city_id":"110000",
		"county_id":"-1","isp_id":"100017"}}
		其中code的值的含义为，0：成功，1：失败。
	 */
	private int code;
	
	private Data data;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public class Data{
		private String ip;
		
		//国家
		private String country;
		
		private String area;
		
		private String region;
		
		private String city;
		
		private String county;
		
		private String isp;

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public String getRegion() {
			return region;
		}

		public void setRegion(String region) {
			this.region = region;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getCounty() {
			return county;
		}

		public void setCounty(String county) {
			this.county = county;
		}

		public String getIsp() {
			return isp;
		}

		public void setIsp(String isp) {
			this.isp = isp;
		}
	}
	
}
