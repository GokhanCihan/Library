package gokhan.cihan.Library.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "borrowings")
@RequiredArgsConstructor
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String borrower;

    @Column(name = "date_borrowed", nullable = false)
    private LocalDate dateBorrowed;

    @Column(name = "date_returned")
    private LocalDate dateReturned;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

}
