package hello.demo.servlet.web.frountcontroller.v3.controller;

import hello.demo.servlet.domain.Member;
import hello.demo.servlet.domain.MemberRepository;
import hello.demo.servlet.web.frountcontroller.ModelView;
import hello.demo.servlet.web.frountcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username,age);
        memberRepository.save(member);


        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);
        return modelView;

    }
}
