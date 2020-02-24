package com.kientpham.webapp.shareservice.lookup.dbgatewayimpl;
import org.springframework.data.repository.CrudRepository;
import com.kientpham.webapp.shareservice.lookup.Lookup;
import org.springframework.data.domain.Sort;
import java.util.List;


public interface LookupRepository extends CrudRepository<Lookup, Integer> {
	List<Lookup> findByLookupType(String lookupType);

	List<Lookup> findAll(Sort sort);
}