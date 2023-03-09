package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    // 저장
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    // 조회
    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
