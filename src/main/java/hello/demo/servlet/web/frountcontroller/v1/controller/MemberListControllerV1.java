package hello.demo.servlet.web.frountcontroller.v1.controller;

import hello.demo.servlet.domain.Member;
import hello.demo.servlet.domain.MemberRepository;
import hello.demo.servlet.web.frountcontroller.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV1 implements ControllerV1 {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<Member> members = memberRepository.findAll();

        request.setAttribute("members",members);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/members.jsp");
        requestDispatcher.forward(request, response);
    }
}
