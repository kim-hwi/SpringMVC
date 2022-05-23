package hello.demo.servlet.web.frountcontroller.v2;

import hello.demo.servlet.web.frountcontroller.v2.ControllerV2;
import hello.demo.servlet.web.frountcontroller.v2.controller.MemberFormControllerV2;
import hello.demo.servlet.web.frountcontroller.v2.controller.MemberListControllerV2;
import hello.demo.servlet.web.frountcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2",urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerv2Map = new HashMap<>();

    public FrontControllerServletV2() {
        controllerv2Map.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerv2Map.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerv2Map.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV2 controllerV2 = controllerv2Map.get(requestURI);


        if(controllerV2 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        controllerV2.process(request,response).render(request,response);
    }
}
