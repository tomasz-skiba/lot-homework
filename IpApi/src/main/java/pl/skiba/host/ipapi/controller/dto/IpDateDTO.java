package pl.skiba.host.ipapi.controller.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.sun.istack.NotNull;

import pl.skiba.host.ipapi.utils.SimpleRegex;

public class IpDateDTO {
	@NotBlank
	@Pattern(regexp = SimpleRegex.IP_REGEX)
	public String ip;
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	public Date registerDate;

	public IpDateDTO(String ip, Date registerDate) {
		super();
		this.ip = ip;
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "IpDateDTO [ip=" + ip + ", registerDate=" + registerDate + "]";
	}

}
