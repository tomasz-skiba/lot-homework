package pl.skiba.host.ipapi.controller.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.sun.istack.NotNull;

public class IpDateDTO {

	public static final String IP_REGEX = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

	@NotBlank
	@Pattern(regexp = IP_REGEX)
	public String ip;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	public Date registerDate;

	public IpDateDTO(String ip, Date registerDate) {
		super();
		this.ip = ip;
		this.registerDate = registerDate;
	}

}
