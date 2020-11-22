package pl.skiba.host.ipapi.controller.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.skiba.host.ipapi.db.model.IpDate;
import pl.skiba.host.ipapi.utils.SimpleRegex;

/**
 * The Class IpDateDTO. This is data transfer object for {@link IpDate} model
 * 
 * @author Tomasz Skiba
 */
@NoArgsConstructor
@AllArgsConstructor
public class IpDateDTO {

	@NotBlank
	@Pattern(regexp = SimpleRegex.IP_REGEX)
	public String ip;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	public LocalDate registerDate;

	@Override
	public String toString() {
		return "IpDateDTO [ip=" + ip + ", registerDate=" + registerDate + "]";
	}

}
