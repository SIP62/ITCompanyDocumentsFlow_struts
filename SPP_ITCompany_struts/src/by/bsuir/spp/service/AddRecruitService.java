package by.bsuir.spp.service;

import by.bsuir.spp.dao.AddRecruitDAO;
import by.bsuir.spp.entities.Recruit;

public class AddRecruitService {
	AddRecruitDAO ard = new AddRecruitDAO();
	
	public boolean addRecruit(Recruit recruit) {
	
		return ard.addRecruitToDB(recruit);
	}

}
