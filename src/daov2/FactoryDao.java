package daov2;

public abstract class FactoryDao {
	
	private static FactoryDao singleton;
	
	protected FactoryDao() {
		
	}
	
	public static FactoryDao getOrCreate() {
		if (singleton == null)
			singleton = new FactoryDaoPostgres();
		
		return singleton;
	}

	public abstract DaoPersona newDaoPersona();
}
