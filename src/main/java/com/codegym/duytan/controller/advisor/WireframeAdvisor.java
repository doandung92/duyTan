package com.codegym.duytan.controller.advisor;

import com.codegym.duytan.model.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class WireframeAdvisor {

    @ModelAttribute("wireframeModel")
    public static WireframeModel getWireFrameModel() {
        WireframeModel wireframeModel = new WireframeModel();
        return wireframeModel;
    }

}
