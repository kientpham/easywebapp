package com.kientpham.webapp.shareservice.lookup.dbgatewayimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.kientpham.webapp.shareservice.lookup.Lookup;
import com.kientpham.webapp.shareservice.lookup.dbgatewayimpl.LookupRepository;
import com.kientpham.webapp.shareservice.lookup.LookupDBGateway;
import org.springframework.data.domain.Sort;

@Component
public class LookupDBGatewayImp implements LookupDBGateway{
	@Autowired
	private LookupRepository repository;

	@Override
	public List<Lookup> findAll() {
		return (List<Lookup>) repository.findAll();
	}

	@Override
	public Lookup findById(Integer id) {
		return repository.findById(id).orElse(new Lookup());
	}

	@Override
	public List<Lookup> findByListIds(List<Integer> listId) {		
		return (List<Lookup>) repository.findAllById(listId);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	public Lookup save(Lookup entity) {
		return repository.save(entity);
	}
	@Override
	public List<Lookup> findByLookupType(String lookupType) {
		return repository.findByLookupType(lookupType);
	}

	@Override
	public List<Lookup> findAllSorted() {
		return repository.findAll(Sort.by("order").ascending());		
	}
}