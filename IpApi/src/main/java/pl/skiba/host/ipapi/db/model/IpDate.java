package pl.skiba.host.ipapi.db.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class IpDate {

	@Id
	@GeneratedValue
	private Long ipDateID;
	private String Ip;
	private Date registerDate;

	public Long getIpDateID() {
		return ipDateID;
	}

	public void setIpDateID(Long ip2DateID) {
		this.ipDateID = ip2DateID;
	}

	public String getIp() {
		return Ip;
	}

	public void setIp(String ip) {
		Ip = ip;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

}
