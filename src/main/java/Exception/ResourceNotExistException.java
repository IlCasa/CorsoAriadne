package Exception;

public class ResourceNotExistException extends Exception {

	public ResourceNotExistException() {
		System.out.println("EXC: IDRisorsa non presente, impossibile eseguire l'update");
	}
	
}
