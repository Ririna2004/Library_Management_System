package main.java.com.lms.lib.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "issue_record")
public class IssueRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long bookId;
    private String username;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public IssueRecord() {}
    // Getters and setters ...
}
