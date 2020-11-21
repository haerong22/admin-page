package com.example.study.controller.api;

import com.example.study.controller.CrudController;
import com.example.study.ifc.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.service.UserApiLogicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController extends CrudController<UserApiRequest, UserApiResponse> {

    private final UserApiLogicService userApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = userApiLogicService;
    }
}
