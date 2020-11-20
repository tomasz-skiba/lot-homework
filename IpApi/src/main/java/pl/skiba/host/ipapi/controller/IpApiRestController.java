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

@RestController
@RequestMapping("/")
@ComponentScans({ @ComponentScan(basePackages = "pl.skiba.host.ipapi.service.impl") })
@CrossOrigin
public class IpApiRestController {
	Logger log = LoggerFactory.getLogger(IpApiRestController.class);

	private final IpDateService service;

	@Autowired
	public IpApiRestController(IpDateService ipDateService) {
		super();
		this.service = ipDateService;
	}

	@GetMapping(path = "/statistics")
	public List<IPCountByDayDTO> statistics() {
		List<IPCountByDayDTO> statistics = service.getStatistics();
		log.debug("statistics returned parametes: {}", statistics);
		return statistics;
	}

	@PostMapping(path = "/save")
	public void save(@RequestBody @Valid IpDateDTO ipObj) {
		log.debug("save executed with parametes: {}", ipObj);
		service.save(ipObj);
	}
}
