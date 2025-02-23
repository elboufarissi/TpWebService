package org.sami.tpwebservice.Repository;

import org.sami.tpwebservice.Entities.Custumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface CustumerRepo extends JpaRepository<Custumer, Long> {

}
