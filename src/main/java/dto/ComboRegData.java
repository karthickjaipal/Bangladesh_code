package dto;

public class ComboRegData {
	
	String msisdn;
	String customername;
	Integer age;
	String gender;
	Integer offerid;
	String nomineerelationship;
	String nomineename;
	String nomineemsisdn;
	Integer healthtip;
	String healthtiplang;
	
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getOfferid() {
		return offerid;
	}
	public void setOfferid(Integer offerid) {
		this.offerid = offerid;
	}
	public String getNomineerelationship() {
		return nomineerelationship;
	}
	public void setNomineerelationship(String nomineerelationship) {
		this.nomineerelationship = nomineerelationship;
	}
	public String getNomineename() {
		return nomineename;
	}
	public void setNomineename(String nomineename) {
		this.nomineename = nomineename;
	}
	public String getNomineemsisdn() {
		return nomineemsisdn;
	}
	public void setNomineemsisdn(String nomineemsisdn) {
		this.nomineemsisdn = nomineemsisdn;
	}
	public Integer getHealthtip() {
		return healthtip;
	}
	public void setHealthtip(Integer healthtip) {
		this.healthtip = healthtip;
	}
	public String getHealthtiplang() {
		return healthtiplang;
	}
	public void setHealthtiplang(String healthtiplang) {
		this.healthtiplang = healthtiplang;
	}
	@Override
	public String toString() {
		return "ComboRegData [msisdn=" + msisdn + ", customername=" + customername + ", age=" + age + ", gender="
				+ gender + ", offerid=" + offerid + ", nomineerelationship=" + nomineerelationship + ", nomineename="
				+ nomineename + ", nomineemsisdn=" + nomineemsisdn + ", healthtip=" + healthtip + ", healthtiplang="
				+ healthtiplang + "]";
	}

	
	

}
