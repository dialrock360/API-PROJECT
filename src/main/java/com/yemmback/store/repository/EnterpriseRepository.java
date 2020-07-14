package com.yemmback.store.repository;

import com.yemmback.store.model.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dialrock361 on 01/08/20.
 */

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {


}
 