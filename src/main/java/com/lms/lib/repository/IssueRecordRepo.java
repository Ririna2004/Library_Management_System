package main.java.com.lms.lib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import main.java.com.lms.lib.domain.IssueRecord;
import java.util.List;

@Repository
public interface IssueRecordRepo extends JpaRepository<IssueRecord, Long> {
    List<IssueRecord> findByUsernameAndReturnDateIsNull(String username);
    List<IssueRecord> findByBookIdAndReturnDateIsNull(Long bookId);
}
