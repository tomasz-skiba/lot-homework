package pl.skiba.host.ipapi.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import pl.skiba.host.ipapi.utils.SimpleRegex;

public class IPCountByDayDTO {
	@NotBlank
	@DateTimeFormat(pattern = SimpleRegex.DATE_FORMAT)
	public String date;
	@NotBlank
	public Long count;

	public IPCountByDayDTO(@NotEmpty String date, @NotEmpty Long count) {
		super();
		this.date = date;
		this.count = count;
	}
}
