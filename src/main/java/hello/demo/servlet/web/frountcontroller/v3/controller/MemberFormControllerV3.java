package hello.demo.servlet.web.frountcontroller.v3.controller;

import hello.demo.servlet.web.frountcontroller.ModelView;
import hello.demo.servlet.web.frountcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> paramMap) {
        System.out.println("MemberFormControllerV3.process");
        return new ModelView("new-form");
    }
}
