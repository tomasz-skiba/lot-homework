package pl.skiba.host.ipapi.service;

import java.util.List;

import pl.skiba.host.ipapi.controller.dto.IpDateDTO;

public interface IpDateService {

	public void save(IpDateDTO ipDate);

	public List<IpDateDTO> getStatistics();
}
