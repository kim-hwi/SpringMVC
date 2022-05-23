package hello.demo.servlet.domain;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();//static 이기 때문에 하나만 생성된다. 중복 생성 안됨.
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();//싱글톤을 위함 설정 static이 사실 필요 없음

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository(){
    }//생성자 private

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());//store에 모든 값을 return해줌. store를 보호하기 위한 작업
    }

    public void clearStore(){
        store.clear();
    }

}
