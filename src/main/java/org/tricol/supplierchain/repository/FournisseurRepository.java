package org.tricol.supplierchain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tricol.supplierchain.dto.response.FournisseurResponseDTOpourEX1;
import org.tricol.supplierchain.entity.Fournisseur;

import java.util.List;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    boolean existsByEmail(String email);


    boolean existsByIce(String ice);


}
