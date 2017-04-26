package com.wlewicki.repo;

import com.wlewicki.model.ReleaseItem;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by wlewicki on 3/28/2017.
 */
public interface ReleaseItemRepository extends CrudRepository<ReleaseItem, Long> {
}
