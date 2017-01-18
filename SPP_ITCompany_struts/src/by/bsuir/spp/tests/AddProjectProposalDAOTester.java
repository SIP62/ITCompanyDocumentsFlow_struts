package by.bsuir.spp.tests;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import by.bsuir.spp.entities.ProjectProposal;

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class AddProjectProposalDAOTester {

	ProjectProposal projectProposal;
	
	//@InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	AddUpdateMockServiceImpl addUpdateMockServiceImpl = new AddUpdateMockServiceImpl();
		   
	//@Mock annotation is used to create the mock object to be injected
	@Mock
	IAddUpdateMockService iAddUpdateMockService;
	
	@Test
	public void testAddProjectProposal() {
		projectProposal = new ProjectProposal();
		boolean isAdded = false;
		if(projectProposal != null) isAdded = true;
		
		when(iAddUpdateMockService.addProjectProposalToDB(projectProposal)).thenReturn(isAdded);
		assertTrue(addUpdateMockServiceImpl.addProjectProposalToDB(projectProposal));
		
		
	}	
}
