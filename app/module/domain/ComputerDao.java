package module.domain;

import java.util.List;

public interface ComputerDao {

	public Computer getById(final int id);

	public List<Computer> getAll();

	public int save(final Computer object);

	public int remove(final int id);
}

