package pl.skiba.host.ipapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.skiba.host.ipapi.controller.dto.IPCountByDayDTO;
import pl.skiba.host.ipapi.controller.dto.IpDateDTO;
import pl.skiba.host.ipapi.service.IpDateService;

/**
 * Rest API controller for managing IP data provided or requested by the API
 * user.
 *
 * @author Tomasz Skiba
 */
@RestController
@RequestMapping("/")
@ComponentScans({ @ComponentScan(basePackages = "pl.skiba.host.ipapi.service.impl") })
@CrossOrigin
public class IpApiRestController {

	/** The logger. */
	Logger log = LoggerFactory.getLogger(IpApiRestController.class);

	/** The service. */
	private final IpDateService service;

	/**
	 * Instantiates a new ip api rest controller.
	 *
	 * @param ipDateService the ip date service
	 */
	@Autowired
	public IpApiRestController(IpDateService ipDateService) {
		super();
		this.service = ipDateService;
	}

	/**
	 * Returns statistics - IP count by day.
	 *
	 * @return the {@link List} of {@link IPCountByDayDTO }
	 */
	@GetMapping(path = "/statistics")
	public List<IPCountByDayDTO> statistics() {
		List<IPCountByDayDTO> statistics = service.getStatistics();
		log.debug("statistics returned parametes: {}", statistics);
		return statistics;
	}

	/**
	 * Save {@link IpDateDTO} object.
	 *
	 * @param ipObj data
	 */
	@PostMapping(path = "/save")
	public void save(@RequestBody @Valid IpDateDTO ipObj) {
		log.debug("save executed with parametes: {}", ipObj);
		service.save(ipObj);
	}
}
