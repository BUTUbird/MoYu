package org.butu.ucenter.api

import org.butu.common.response.R
import org.butu.ucenter.service.FansService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @program: MoYu
 * @description: Kt
 * @packagename: org.butu.ucenter.api
 * @author: BUTUbird
 * @date: 2022-04-09 11:03
 **/
@RestController
class KtController {
    @Autowired
    lateinit var fansService : FansService

    @GetMapping("/fans")
    fun fans(): R {
        val fan = fansService.getById(1)
        return R.SUCCESS("调用成功",fan);
    }
}
