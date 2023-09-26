package hello.springcore.order;

import hello.springcore.discount.DiscountPolicy;
import hello.springcore.discount.FixDiscountPolicy;
import hello.springcore.discount.RateDiscountPolicy;
import hello.springcore.member.Member;
import hello.springcore.member.MemberRepository;
import hello.springcore.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

	// private final MemberRepository memberRepository = new MemoryMemberRepository();
	private final MemberRepository memberRepository;
//	private MemberRepository memberRepository;

	// private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
	// private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	private final DiscountPolicy discountPolicy;
//	private DiscountPolicy discountPolicy;

	// 의존관계 주입 방법 3. 필드 주입
//	@Autowired private MemberRepository memberRepository;
//	@Autowired private DiscountPolicy discountPolicy;

	// 의존관계 주입 방법 2. 수정자 주입 (setter)
//	@Autowired
//	public void setMemberRepository(MemberRepository memberRepository) {
//		System.out.println("memberRepository = " + memberRepository);
//		this.memberRepository = memberRepository;
//	}
//
//	@Autowired
//	public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//		System.out.println("discountPolicy = " + discountPolicy);
//		this.discountPolicy = discountPolicy;
//	}

	// 의존관계 주입 방법 1. 생성자 주입
	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		System.out.println("생성자 주입");
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	// 의존관계 주입 방법 4. 일반메서드 주입
//	@Autowired
//	public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//		this.memberRepository = memberRepository;
//		this.discountPolicy = discountPolicy;
//	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(memberId, itemName, itemPrice, discountPrice);
	}

	//테스트 용도
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
}
