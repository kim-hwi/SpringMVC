package hello.demo.servlet.web.frountcontroller.v3;

import hello.demo.servlet.web.frountcontroller.ModelView;
import hello.demo.servlet.web.frountcontroller.MyView;
import hello.demo.servlet.web.frountcontroller.v3.ControllerV3;
import hello.demo.servlet.web.frountcontroller.v3.controller.MemberFormControllerV3;
import hello.demo.servlet.web.frountcontroller.v3.controller.MemberListControllerV3;
import hello.demo.servlet.web.frountcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3",urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerv3Map = new HashMap<>();

    public FrontControllerServletV3() {
        controllerv3Map.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerv3Map.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerv3Map.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV3 controllerV3 = controllerv3Map.get(requestURI);

        System.out.println("request = " + request.getRequestURI());

        if(controllerV3 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //paramMap
        Map<String, String> paramMap = createParamMap(request);

        ModelView modelView = controllerV3.process(paramMap);
        String viewName = modelView.getViewName();
        MyView myView = viewResolver(viewName);
        myView.render(modelView.getModel(),request,response);


    }

    private MyView viewResolver(String viewName) {
        MyView myView = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        System.out.println("myView = " + "/WEB-INF/views/" + viewName + ".jsp");
        return myView;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        System.out.println("FrontControllerServletV3.createParamMap");
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
