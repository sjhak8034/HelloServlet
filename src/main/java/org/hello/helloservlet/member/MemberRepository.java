package org.hello.helloservlet.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 고려 x
 */
public class MemberRepository {
    private static final Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {}

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return List.copyOf(store.values());
    }

    public void clearStore() {
        store.clear();
        sequence = 0L;
    }
}
