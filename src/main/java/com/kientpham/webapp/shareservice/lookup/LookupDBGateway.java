package com.kientpham.webapp.shareservice.lookup;
import java.util.List;
import com.kientpham.webapp.shareservice.lookup.Lookup;

public interface LookupDBGateway{
	public List<Lookup> findAll();

	public Lookup findById(Integer id);

	public List<Lookup> findByListIds(List<Integer> listId);

	public void deleteById(Integer id);

	public Lookup save(Lookup entity);

	public List<Lookup> findByLookupType(String lookupType);

	public List<Lookup> findAllSorted();
}