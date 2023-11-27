package interfaces;
import java.util.ArrayList;

public interface Entity<T> {
	public void create(T objeto);
	public void update(T objeto);
	public void delete(int id);
	public T select(int id);
	public ArrayList<T> selectAll();
}
