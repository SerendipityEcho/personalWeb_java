package com.xiaoyi.personalweb.controller.wx;

import com.xiaoyi.personalweb.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wxMenu")
public class CreatedMenuController {

    @PostMapping
    public Result updateMenu(){
        return null;
    }

    @GetMapping
    public Result getMenu(){
        return null;
    }

}
