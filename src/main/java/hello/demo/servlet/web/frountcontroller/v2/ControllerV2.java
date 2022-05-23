package hello.demo.servlet.web.frountcontroller.v2;

import hello.demo.servlet.web.frountcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {
    MyView process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
