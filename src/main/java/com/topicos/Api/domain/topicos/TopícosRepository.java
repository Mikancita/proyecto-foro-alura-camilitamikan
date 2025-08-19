package com.topicos.Api.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopícosRepository  extends JpaRepository<Topico,Long> {
    Page<Topico> findAllByActivoTrue(Pageable paginacion);
    @Query("""
            select t from Topico t
            where t.activo= TRUE
            and t.status = :status
            order by rand()
            limit 1
            """)
    boolean existsByIdAndActivoTrue(Long id);


}
