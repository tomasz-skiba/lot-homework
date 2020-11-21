package pl.skiba.host.ipapi.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class IpDate model.
 * 
 * @author Tomasz Skiba
 */
@Entity
@Table(name = IpDate.TNAME)
public class IpDate {

	/** The Constant for this model table name. */
	public static final String TNAME = "ipDate";

	/** The Constant for this model ID column name. */
	public static final String ID_CNAME = TNAME + "ID";

	/** The Constant for this model ip column name. */
	public static final String IP_CNAME = "ip";

	/** The Constant for this model registerDate column name. */
	public static final String REGISTER_DATE_CNAME = "registerDate";

	/** The ID. */
	@Id
	@GeneratedValue
	@Column(name = IpDate.ID_CNAME, nullable = false)
	private Long ipDateID;

	/** The IP. */
	@Column(name = IpDate.IP_CNAME, nullable = false)
	private String ip;

	/** The register date. */
	@Column(name = IpDate.REGISTER_DATE_CNAME, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date registerDate;

	/**
	 * Gets the ID.
	 *
	 * @return the ID
	 */
	public Long getIpDateID() {
		return ipDateID;
	}

	/**
	 * Sets the ID.
	 *
	 * @param ip2DateID the new ID
	 */
	public void setIpDateID(Long ip2DateID) {
		this.ipDateID = ip2DateID;
	}

	/**
	 * Gets the ip.
	 *
	 * @return the ip
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 * Sets the ip.
	 *
	 * @param ip the new ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Gets the register date.
	 *
	 * @return the register date
	 */
	public Date getRegisterDate() {
		return registerDate;
	}

	/**
	 * Sets the register date.
	 *
	 * @param registerDate the new register date
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "IpDate [ipDateID=" + ipDateID + ", ip=" + ip + ", registerDate=" + registerDate + "]";
	}

}
