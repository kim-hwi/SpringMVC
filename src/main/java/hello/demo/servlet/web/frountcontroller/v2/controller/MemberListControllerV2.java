package hello.demo.servlet.web.frountcontroller.v2.controller;

import hello.demo.servlet.domain.Member;
import hello.demo.servlet.domain.MemberRepository;
import hello.demo.servlet.web.frountcontroller.MyView;
import hello.demo.servlet.web.frountcontroller.v2.ControllerV2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Member> members = memberRepository.findAll();

        request.setAttribute("members",members);


        return new MyView("/WEB-INF/views/members.jsp");
    }
}
