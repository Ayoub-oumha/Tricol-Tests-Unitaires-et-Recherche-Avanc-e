package org.tricol.supplierchain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.tricol.supplierchain.entity.MouvementStock;
import org.tricol.supplierchain.enums.TypeMouvement;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface MouvementStockRepository extends JpaRepository<MouvementStock, Long>{

    List<MouvementStock> findByProduitIdOrderByDateMouvementDesc(Long produitId);

    List<MouvementStock> findByTypeMouvementOrderByDateMouvementDesc(TypeMouvement type);

    List<MouvementStock> findByReferenceOrderByDateMouvementDesc(String reference);

    @Query("SELECT m FROM MouvementStock m WHERE m.typeMouvement = :type AND m.dateMouvement BETWEEN :startDate AND :endDate ORDER BY m.dateMouvement DESC")
    List<MouvementStock> findByTypeAndDateBetween(TypeMouvement type, LocalDateTime startDate, LocalDateTime endDate);

    List<MouvementStock> findeByDateMouvementBetweenAndTypeMouvement(LocalDateTime startDate, LocalDateTime endDate, TypeMouvement type);
}
