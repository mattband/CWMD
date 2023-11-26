package matthew;

public interface PublicationController {
	boolean updatePublication(Publication publication);
	void printAllPublications();
	boolean deletePublication(String publicationID);
	boolean  getPublicationById(String publicationID);
	 boolean insertPublication(Publication publication);
}
