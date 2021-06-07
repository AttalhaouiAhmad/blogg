package be.ehb.blogg.model;

import org.springframework.data.repository.CrudRepository;

public interface BlogDao  extends CrudRepository<Blogg, Integer> {
}
