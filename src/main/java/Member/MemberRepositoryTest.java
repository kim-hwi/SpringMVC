//package Member;
//
//
//import hello.demo.servlet.domain.Member;
//import hello.demo.servlet.domain.MemberRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//
//
//import java.nio.MappedByteBuffer;
//import java.util.List;
//
//public class MemberRepositoryTest {
//    MemberRepository memberRepository = MemberRepository.getInstance();//싱글톤이기 때문
//
//    @AfterEach
////테스트 끝나면 초기화 하기위함
//    void afterEach(){
//        memberRepository.clearStore();
//    }
//
//    @Test
//    void save(){
//        //given
//        Member member = new Member("hello", 20);
//        //when
//        Member savedMember = memberRepository.save(member);
//        //then
//        Member findMember = memberRepository.findById(savedMember.getId());
//        Assertions.assertThat(findMember).isEqualTo(savedMember);
//        Assertions
//    }
//
//    @Test
//    void findAll(){
//        //given
//        Member member1 = new Member("member1", 20);
//        Member member2 = new Member("member2", 30);
//
//        memberRepository.save(member1);
//        memberRepository.save(member2);
//
//
//        //when
//        List<Member> result = memberRepository.findAll();
//
//        //then
//        Assertions.assertThat(result.size()).isEqualTo(2);
//        Assertions.assertThat(result).contains(member1, member2);
//    }
//}
