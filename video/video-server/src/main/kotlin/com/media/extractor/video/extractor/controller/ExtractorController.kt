package com.media.extractor.video.extractor.controller

import com.media.extractor.video.extractor.common.api.CommonResult
import com.media.extractor.video.extractor.common.api.req.VideoUrlExtractorReq
import com.media.extractor.video.extractor.service.RequestWebService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ExtractorController {

    @Autowired
    lateinit var service: RequestWebService

    @PostMapping("/getVideoUrls")
    @ResponseBody
    fun hello(@RequestBody req: VideoUrlExtractorReq):CommonResult<MutableList<String>> {
        println(req.url)
        var vids = service.requestWeb(req.url!!)
        return CommonResult.success(vids)
    }
}