package daov2;

public class FactoryDaoPostgres extends FactoryDao {

	protected FactoryDaoPostgres() {
		super();
	}
	
	@Override
	public DaoPersona newDaoPersona() {
		return new DaoPersonaPostgres();
	}
	
	//public DaoMAteria dfs
}
