package hello.core.member;import org.springframework.stereotype.Component;import java.util.HashMap;import java.util.Map;import java.util.concurrent.ConcurrentHashMap;// DATABASE 미확장에 따른 Memory에 Member 정보 적재@Componentpublic class MemoryMemberRepository implements MemberRepository {    // 동시성 문제를 해결하기 위해서 실무에서는 ConcurrentHashMap을 사용한다.    // private static Map<Long, Member> store = new ConcurrentHashMap<>();    private static Map<Long, Member> store = new HashMap<>();    @Override    public void save(Member member) {        store.put(member.getId(), member);    }    @Override    public Member findMyId(Long memberId) {        return store.get(memberId);    }}