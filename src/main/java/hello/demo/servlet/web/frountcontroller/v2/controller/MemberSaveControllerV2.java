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

public class MemberSaveControllerV2 implements ControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        //Model에 data 보관
        request.setAttribute("member",member);
        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
