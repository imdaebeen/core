package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void 주문생성(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId,"daebeen", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(memberId,"ItemA",10000);


        //then
        assertThat(order.calculatePrice()).isEqualTo(9000);
    }

}
