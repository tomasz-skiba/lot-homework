package pl.skiba.host.ipapi.controller.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import pl.skiba.host.ipapi.db.model.IpDate;
import pl.skiba.host.ipapi.utils.SimpleRegex;

/**
 * The Class IpDateDTO. This is data transfer object for {@link IpDate} model
 * 
 * @author Tomasz Skiba
 */
public class IpDateDTO {

	/** The ip. */
	@NotBlank
	@Pattern(regexp = SimpleRegex.IP_REGEX)
	public String ip;

	/** The register date. */
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	public Date registerDate;

	/**
	 * Instantiates a new ip date DTO.
	 *
	 * @param ip
	 * @param registerDate
	 */
	public IpDateDTO(String ip, Date registerDate) {
		super();
		this.ip = ip;
		this.registerDate = registerDate;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "IpDateDTO [ip=" + ip + ", registerDate=" + registerDate + "]";
	}

}
