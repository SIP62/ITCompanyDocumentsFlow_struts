package by.bsuir.spp.service;

import by.bsuir.spp.dao.UpdateClientDataDAO;
import by.bsuir.spp.entities.Client;

public class UpdateClientDataService {
	UpdateClientDataDAO ucdd = new UpdateClientDataDAO();

	public boolean updateClientData(Client client) {

		PassScrambler ps = new PassScrambler();
		String pass = client.getUsers().getPassword();
		client.getUsers().setPassword(ps.scramble(pass));
		
		return ucdd.updateClientInDB(client);
	}

}
