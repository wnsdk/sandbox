package hello.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.springcore.discount.DiscountPolicy;
import hello.springcore.discount.FixDiscountPolicy;
import hello.springcore.discount.RateDiscountPolicy;
import hello.springcore.member.MemberRepository;
import hello.springcore.member.MemberService;
import hello.springcore.member.MemberServiceImpl;
import hello.springcore.member.MemoryMemberRepository;
import hello.springcore.order.OrderService;
import hello.springcore.order.OrderServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}

	@Bean
	public static MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

	@Bean
	public static DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
		// return new FixDiscountPolicy();
	}

}
