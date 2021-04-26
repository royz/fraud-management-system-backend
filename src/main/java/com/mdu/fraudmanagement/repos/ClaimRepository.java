package com.mdu.fraudmanagement.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mdu.fraudmanagement.entities.Claim;

@Transactional // added for update query and also for delete query
@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {

	public Claim findByIdProofNo(int idProofNo);

	@Query(value = "SELECT * from claim c WHERE c.user_id=?1 ", nativeQuery = true)
	public List<Claim> findByUserId(String user_id);

//	Card findById(int id);
	@Modifying
	@Query(value = "UPDATE claim c SET c.is_duplicate=?2  WHERE c.id_proof_no=?1 ", nativeQuery = true)
	public void updateDuplicateStatus(@Param("id_proof_no") int idProofNo, @Param("id_proof_no") boolean isDuplicate);

}