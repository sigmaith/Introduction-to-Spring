package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller  // 스프링 컨테이너에 등록>
public class MemberController {
    private final MemberService memberService;

    @Autowired //생성자에 autowired가 있으면
    public MemberController(MemberService memberService) {  // 객체 주입
        this.memberService = memberService;
        System.out.println("memberService = " + memberService.getClass());
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member  = new Member();
        member.setName(form.getName());

        //System.out.println("member = " + form.getName());
        System.out.println("member  = " + member.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members  = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
