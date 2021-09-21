package alex.carsrus.member;
import org.springframework.data.repository.CrudRepository;



public interface MemberRepo extends CrudRepository<Member,Integer> {
}
