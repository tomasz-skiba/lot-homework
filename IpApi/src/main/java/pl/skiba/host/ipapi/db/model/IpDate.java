package pl.skiba.host.ipapi.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = IpDate.TNAME)
public class IpDate {
	public static final String TNAME = "ipDate";
	public static final String ID_CNAME = TNAME + "ID";
	public static final String IP_CNAME = "ip";
	public static final String REGISTER_DATE_CNAME = "registerDate";
	@Id
	@GeneratedValue
	@Column(name = IpDate.ID_CNAME, nullable = false)
	private Long ipDateID;
	@Column(name = IpDate.IP_CNAME, nullable = false)
	private String ip;
	@Column(name = IpDate.REGISTER_DATE_CNAME, nullable = false)
	@Temporal(TemporalType.DATE)
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
