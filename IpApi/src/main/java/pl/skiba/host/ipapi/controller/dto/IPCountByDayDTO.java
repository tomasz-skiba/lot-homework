package pl.skiba.host.ipapi.controller.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import pl.skiba.host.ipapi.utils.SimpleRegex;

public class IPCountByDayDTO {
	@JsonFormat(pattern = SimpleRegex.DATE_FORMAT)
	public LocalDate date;
	public Long count;

	public IPCountByDayDTO(LocalDate date, Long count) {
		super();
		this.date = date;
		this.count = count;
	}

	@Override
	public String toString() {
		return "IPCountByDayDTO [date=" + date + ", count=" + count + "]";
	}

}
