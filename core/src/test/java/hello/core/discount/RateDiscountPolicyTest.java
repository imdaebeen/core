package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다.")
    void vip_할인금액(){
        //given
        Member member = new Member(1L, "daebeen", Grade.VIP);
        //when
        int discountAmoount = discountPolicy.discount(member,10000);
        //then
        assertThat(discountAmoount).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void no_vip_할인금액(){
        //given
        Member member = new Member(2L, "daebeen2", Grade.BASIC);
        //when
        int discountAmoount = discountPolicy.discount(member,10000);
        //then
        assertThat(discountAmoount).isEqualTo(1000);
    }

}