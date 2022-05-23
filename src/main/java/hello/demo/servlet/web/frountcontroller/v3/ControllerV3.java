package hello.demo.servlet.web.frountcontroller.v3;

import hello.demo.servlet.web.frountcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
