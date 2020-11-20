package pl.skiba.host.ipapi.db.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class IpDate {

	@Id
	@GeneratedValue
	private Long ipDateID;
	private String ip;
	private Date registerDate;

	public Long getIpDateID() {
		return ipDateID;
	}

	public void setIpDateID(Long ip2DateID) {
		this.ipDateID = ip2DateID;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "IpDate [ipDateID=" + ipDateID + ", ip=" + ip + ", registerDate=" + registerDate + "]";
	}

}
