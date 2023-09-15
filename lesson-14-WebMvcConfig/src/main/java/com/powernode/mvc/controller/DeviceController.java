package com.powernode.mvc.controller;

import com.powernode.mvc.model.DeviceInfo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeviceController {

    @PostMapping("/device/add")
    public String addDeviceInfo(@RequestParam("device") DeviceInfo deviceInfo) {

        System.out.println("============ debug ===============");

        return "设备信息：" + deviceInfo.toString();
    }
}
