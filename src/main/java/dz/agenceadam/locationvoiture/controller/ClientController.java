package dz.agenceadam.locationvoiture.controller;

import java.text.ParseException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.agenceadam.locationvoiture.dto.ClientDto;
import dz.agenceadam.locationvoiture.entities.Client;
import dz.agenceadam.locationvoiture.exception.DataFoundedException;
import dz.agenceadam.locationvoiture.service.IClientService;

@RestController
@RequestMapping(value="/api/v1")
public class ClientController {
	
	@Autowired
	private IClientService iClientService;

	@GetMapping("/test")
	public String test()
	{
		return "bonjour";
	}
	
	@GetMapping("/client/findAll")
	public List<Client> findAll()
	{
		return iClientService.findAll();
	}
	
	@PostMapping("/client/saveClient/withUser/{idUser}/{save}")
	public ClientDto save(@RequestBody ClientDto clientDto,@PathVariable Integer idUser,@PathVariable Boolean save) throws ParseException, DataFoundedException
	{
		return iClientService.saveOrUpdate(clientDto, idUser,save);
	}
}
