package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    /* repository가 jdbcMemberRepository, jdbcTemplateMemberRepository 에서 쓰임
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    /*
    // repository: jpaMemberRepository
    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    // repository: SpringDataJpaMemberRepository
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /*
    // repository: MemoryMemberRepository, JdbcMemberRepository, JdbcTemplateMemberRepository, JpaMemberRepository
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }*/

    // repository: SpringDataJpaMemberRepository
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    /*
    // repository: SpringDataJpaMemberRepository에서는 memberRepository 필요 x
    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
        // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }*/

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
