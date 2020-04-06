package homework.repository;

import java.util.List;
import java.util.Map;

import homework.paging.Pageable;



public interface JpaRepository<T> {
	List<T> findAll(Map<String,Object> properties,Pageable pageable,Object... where);
	List<T> findAll(Map<String,Object> properties,Object... where);
	List<T> findAll(String sql,Pageable pageable,Object... where);
	List<T> findAll(String sql,Object... where);
	Long insert(Object object);
	void delete(long id);
	void delete(String sql);
	void update(Object object);
	T findById(Long id);
}
