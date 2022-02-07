package Hello.Hanjihun;

import Hello.Hanjihun.repository.JdbcMemberRepository;
import Hello.Hanjihun.repository.JpaMemberRepository;
import Hello.Hanjihun.repository.MemberRepository;
import Hello.Hanjihun.service.MemberService;
import org.hibernate.boot.JaccPermissionDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;


@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    //@Bean
    //public MemberRepository memberRepository(){
        //return new JdbcMembersRepository(dataSource);
        //return new MemoryMemberRepository();
        //return new JpaMemberRepository(em);
    //}
}
