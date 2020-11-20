package pl.skiba.host.ipapi.controller.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import pl.skiba.host.ipapi.utils.SimpleRegex;

public class IPCountByDayDTO {
	@NotBlank
	@DateTimeFormat(pattern = SimpleRegex.DATE_FORMAT)
	public Date date;
	@NotBlank
	public Long count;

	public IPCountByDayDTO(@NotEmpty Date date, @NotEmpty Long count) {
		super();
		this.date = date;
		this.count = count;
	}

	@Override
	public String toString() {
		return "IPCountByDayDTO [date=" + date + ", count=" + count + "]";
	}

}
