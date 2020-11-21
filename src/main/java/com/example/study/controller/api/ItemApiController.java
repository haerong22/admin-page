package com.example.study.controller.api;

import com.example.study.controller.CrudController;
import com.example.study.ifc.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.service.ItemApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse> {

    private final ItemApiLogicService itemApiLogicService;

    // ItemApiController 객체가 생성되고 실행하는 메소드
    @PostConstruct
    public void init() {
        this.baseService = itemApiLogicService;
    }

}
