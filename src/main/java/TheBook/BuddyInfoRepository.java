package TheBook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
   BuddyInfo findById(long id);
}
