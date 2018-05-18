package com.thoughtworks.rldd.service.web.controller

import com.thoughtworks.rldd.service.user.UserResource
import com.thoughtworks.rldd.service.user.model.User
import com.thoughtworks.rldd.service.web.assembler.UserResourceAssembler
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.hateoas.PagedResources
import org.springframework.hateoas.Resource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["api/users"], produces = ["application/json"])
class UserController(val userResourceAssembler: UserResourceAssembler) {

    val users = listOf("Yusong Deng", "Yuexiang Gao", "Yugang Zhou", "Di Zhang", "Jinghu Peng")
            .mapIndexed { id, name ->
                User(id.toString(), name, "")
            }

    @GetMapping
    fun getUsers(@RequestParam("size") size: Int,
                 @RequestParam("page") page: Int,
                 @RequestParam("nameLike", required = false) nameLike: String?,
                 pagedResourcesAssembler: PagedResourcesAssembler<UserResource>):
            PagedResources<Resource<UserResource>> {
        val pageRequest = PageRequest.of(page, size)
        val userResources = users.map { userResourceAssembler.toResource(it) }
        return pagedResourcesAssembler.toResource(PageImpl(userResources, pageRequest, 6))
    }
}
