package com.example.study.controller.api;

import com.example.study.controller.CrudController;
import com.example.study.ifc.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.OrderGroupApiRequest;
import com.example.study.model.network.response.OrderGroupApiResponse;
import com.example.study.service.OrderGroupApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/orderGroup")
@RequiredArgsConstructor
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse> {

    private final OrderGroupApiLogicService orderGroupApiLogicService;

    @PostConstruct
    public void init() {
        this.baseService = orderGroupApiLogicService;
    }
}
