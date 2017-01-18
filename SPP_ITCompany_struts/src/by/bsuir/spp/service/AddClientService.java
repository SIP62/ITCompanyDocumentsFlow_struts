package by.bsuir.spp.service;

import by.bsuir.spp.dao.AddClientDAO;
import by.bsuir.spp.entities.Client;

public class AddClientService {
	AddClientDAO acd = new AddClientDAO();

	public boolean addClient(Client client) {

		PassScrambler ps = new PassScrambler();
		String pass = client.getUsers().getPassword();
		client.getUsers().setPassword(ps.scramble(pass));
		
		return acd.addClientInDB(client);

	}

}
