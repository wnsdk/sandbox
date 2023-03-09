package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// (junit을 이용한) 회원도메인 테스트
public class MemberServiceTest {

//    MemberService memberService = new MemberServiceImpl(); // 멤버서비스 객체생성
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given : 이런게 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP); // 멤버 객체생성

        // when : 이렇게 했을 때
        memberService.join(member); // 회원가입
        Member findMember = memberService.findMember(1L); // 멤버서비스 객체에서 아이디를 검색하여 findMember에 저장

        // then : 이렇게 된다.
        Assertions.assertThat(member).isEqualTo(findMember); // 검증 API : Assertions
    }
}
