package hello.springcore.scan;

import hello.springcore.AutoAppConfig;
import hello.springcore.member.MemberRepository;
import hello.springcore.member.MemberService;
import hello.springcore.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

//        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
//        MemberRepository memberRepository = bean.getMemberRepository();
//        System.out.println("memberRepository = " + memberRepository);
    }
}
