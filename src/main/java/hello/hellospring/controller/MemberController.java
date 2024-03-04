package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller  // 스프링 컨테이너에 등록>
public class MemberController {
    private final MemberService memberService;

    @Autowired //생성자에 autowired가 있으면
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
