package pl.skiba.host.ipapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.skiba.host.ipapi.controller.dto.IpDateDTO;
import pl.skiba.host.ipapi.service.IpDateService;

@RestController
@RequestMapping("/")
@ComponentScans({ @ComponentScan(basePackages = "pl.skiba.host.ipapi.service") })
public class IpApiRestController {

	private final IpDateService service;

	@Autowired
	public IpApiRestController(IpDateService ipDateService) {
		super();
		this.service = ipDateService;
	}

	@GetMapping(path = "/statistics")
	public List<IpDateDTO> statistics() {
		System.out.println("1");
		return service.getStatistics();
	}

	@PostMapping(path = "/save")
	public void save(@RequestBody IpDateDTO ipObj) {
		System.out.println("2");
		service.save(ipObj);
	}
}
