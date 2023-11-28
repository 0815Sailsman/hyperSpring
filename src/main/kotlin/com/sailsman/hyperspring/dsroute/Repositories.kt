package com.sailsman.hyperspring.dsroute

import org.springframework.data.repository.CrudRepository

interface EnemyRepository : CrudRepository<Enemy, Long> {
    fun getById(id: Long): Enemy?
    fun getAllByArea(area: Area): Iterable<Enemy>
}

interface ItemRepository : CrudRepository<Item, Long> {
    fun getById(id: Long): Item?
    fun getAllByArea(area: Area): Iterable<Item>
}

interface AreaRepository : CrudRepository<Area, Long> {
    fun getById(id: Long): Area?
    fun getAllByConnectionsContains(area: Area): Iterable<Area>
}