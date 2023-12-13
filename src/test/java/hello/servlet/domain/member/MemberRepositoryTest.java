package hello.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.MethodWrapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

//    @Test
//    void getInstance() {
//    }
//
    @Test
    void save() {
        // given : 주어졌을때
        Member member = new Member("hello", 20);

        //when : 실행했을때
        Member saveMember = memberRepository.save(member);

        //then : 결과
        Member findMemeber = memberRepository.findById(saveMember.getId());
        org.assertj.core.api.Assertions.assertThat(findMemeber).isEqualTo(saveMember);

    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> result = memberRepository.findAll();

        //then
        org.assertj.core.api.Assertions.assertThat(result.size()).isEqualTo(2);
        org.assertj.core.api.Assertions.assertThat(result).contains(member1,member2);
    }

}