package pl.skiba.host.ipapi.controller.dto;

import java.util.Date;

public class IpDateDTO {
	public String ip;
	public Date registerDate;

	public IpDateDTO(String ip, Date registerDate) {
		super();
		ip = ip;
		this.registerDate = registerDate;
	}

}
