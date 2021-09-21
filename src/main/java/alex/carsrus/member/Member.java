package alex.carsrus.member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    @Column( length = 40, nullable = false)
    private String firstName;

    @Column( length = 40, nullable = false)
    private String lastName;

    @Column( length = 120)
    private String street;

    @Column( length = 40)
    private String city;

    @Column( length = 120, unique = true, nullable = false)
    private String email;

    @Column(length=5, nullable = false)
    private int zip;

    int ranking = -1;

    boolean approved;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateEdited;

    // Constructors

    public Member(int memberId, String firstName, String lastName, String street, String city, String email, int zip, int ranking, boolean approved) {
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.email = email;
        this.zip = zip;
        this.ranking = ranking;
        this.approved = approved;
    }

    // Overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return memberId == member.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }



}
