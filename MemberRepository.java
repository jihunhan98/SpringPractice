package Hello.Hanjihun.repository;

import Hello.Hanjihun.member.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional findById(Long id);
    Optional findByName(String name);
    List<Member> findAll();
}
