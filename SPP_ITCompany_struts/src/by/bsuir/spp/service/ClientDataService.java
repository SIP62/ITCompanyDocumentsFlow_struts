package by.bsuir.spp.service;

import by.bsuir.spp.dao.ClientDataDAO;
import by.bsuir.spp.entities.Client;

public class ClientDataService {
	ClientDataDAO cdd = new ClientDataDAO();
	

	public Client getClientData(int id_users) {
		PassDecoder pd = new PassDecoder();
		String idUsers = "" + id_users;
		
		Client client = cdd.viewClientData(idUsers);
		String password = pd.decode(client.getUsers().getPassword());
		client.getUsers().setPassword(password);
		return client;
	}

}
