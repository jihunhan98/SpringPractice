package Hello.Hanjihun.service;

import Hello.Hanjihun.member.Member;
import Hello.Hanjihun.repository.MemberRepository;
import Hello.Hanjihun.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    //중복이름 회원 x
    private void validateDuplicateMember(Member member)
    {
        repository.findByName(member.getName())
                .ifPresent(m-> {throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //회원가입
    public Long join(Member member){
        validateDuplicateMember(member);
        repository.save(member);
        return member.getId();
    }

    //전체 회원 조회
    public List<Member> findMembers(){
        return repository.findAll();
    }

    //아이디로 회원 조회
    public Optional<Member> findOne(Long memberId){
        return repository.findById(memberId);

    }


}
