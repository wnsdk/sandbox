package hello.springcore.order;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.springcore.AppConfig;
import hello.springcore.member.Grade;
import hello.springcore.member.Member;
import hello.springcore.member.MemberService;

class OrderServiceTest {

	// MemberService memberService = new MemberServiceImpl();
	// OrderService orderService = new OrderServiceImpl();
	MemberService memberService;
	OrderService orderService;

	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
		orderService = appConfig.orderService();
	}

	@Test
	void createOrder() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);
		assertThat(order.getDiscountPrice()).isEqualTo(1000);
	}

}