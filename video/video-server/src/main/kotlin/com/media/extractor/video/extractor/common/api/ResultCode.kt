package com.media.extractor.video.extractor.common.api

import com.media.extractor.video.extractor.common.api.IErrorCode

enum class ResultCode(code: Long, message: String) : IErrorCode {

    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    override var code : Long = 0
    override var message: String? = null

    init {
        this.code = code
        this.message = message
    }

}