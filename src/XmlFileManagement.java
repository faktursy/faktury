import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class XmlFileManagement implements FileManagement{

	@Override
	public UserList loadUsersFromFile(String fileName) {
		// TODO Auto-generated method stub
		UserList users = new UserList();
		try {
			 
			File file = new File(fileName);
			JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	 
			// output pretty printed
			//jaxbUnmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			users =  (UserList) jaxbUnmarshaller.unmarshal(file);
			
			
	 
		} catch (JAXBException e) {
		    	  
		      }
		return users;

	}

	@Override
	public boolean saveUsersToFile(String fileName, UserList userList) {
		// TODO Auto-generated method stub
		try {
			File file = new File(fileName);
			JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			jaxbMarshaller.marshal(userList, file);
	 
		} catch (JAXBException e) {
				e.printStackTrace();
			}
	      
		return true;
	}

}
