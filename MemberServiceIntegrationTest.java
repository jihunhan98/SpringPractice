package service;

import Hello.Hanjihun.member.Member;
import Hello.Hanjihun.repository.MemberRepository;
import Hello.Hanjihun.repository.MemoryMemberRepository;
import Hello.Hanjihun.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional

class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository repository;

    @BeforeEach
    void beforeEach(){
        repository = new MemoryMemberRepository();
        memberService = new MemberService(repository);
    }

    @Test
    void join() {
        Member member = new Member();
        member.setName("spring");

        Long result = memberService.join(member);

        assertThat(member.getId()).isEqualTo(result);
    }

    @Test
    void 중복회원가입(){
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }

}
