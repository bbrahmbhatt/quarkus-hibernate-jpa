package demo.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlockHeaderRepository extends JpaRepository<BlockHeader, Long> {
    Optional<BlockHeader> findByMasterCustomerSetIdAndIdentifyingName(
            Long masterCustomerSetId, String identifyingName);
    Optional<BlockHeader> findByBlockTypeCategoryIdAndLongName(
            Long blockTypeCategoryId, String longName);
}
