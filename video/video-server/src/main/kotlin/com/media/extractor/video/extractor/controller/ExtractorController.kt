package com.media.extractor.video.extractor.controller

import com.media.extractor.video.extractor.common.api.CommonResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ExtractorController {

    @GetMapping("/hello")
    @ResponseBody
    fun hello():CommonResult<String> {
        return CommonResult.success("HelloWorld.")
    }
}