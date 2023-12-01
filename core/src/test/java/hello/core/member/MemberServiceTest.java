package hello.core.member;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();



    @Test
    void join() {
        //given
        Member member = new Member(1L,"daebeen",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findMember() {
    }
}