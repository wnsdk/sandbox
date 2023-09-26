package hello.springcore;

import hello.springcore.discount.DiscountPolicy;
import hello.springcore.member.MemberRepository;
import hello.springcore.member.MemoryMemberRepository;
import hello.springcore.order.OrderService;
import hello.springcore.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.springcore.member",
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    @Autowired MemberRepository memberRepository;
    @Autowired DiscountPolicy discountPolicy;

    @Bean
    OrderService orderService(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        return new OrderServiceImpl(memberRepository, discountPolicy);
    }

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
