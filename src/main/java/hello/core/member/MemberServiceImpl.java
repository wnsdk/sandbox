package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; // = new MemoryMemberRepository();

    // 생성자 주입 (AppConfig에서 구체적인 리파지토리를 결정해줌), 의존관계 주입(DI)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원가입
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    // 회원조회
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
