package com.sailsman.hyperspring.dsroute

import jakarta.persistence.*

@Entity
abstract class Unlocking (
    @Id @GeneratedValue var id: Long? = null,
    @ManyToMany var unlocks: MutableList<Area> = mutableListOf()
)

@Entity
class Enemy  (
    @Id @GeneratedValue override var id: Long? = null,
    @ManyToMany override var unlocks: MutableList<Area> = mutableListOf(),
    var name: String,
    @ManyToOne var area: Area,
    var respawns: Boolean,
    var count: Int,
    var amountKilled: Int,
) : Unlocking(id, unlocks)

@Entity
class Item  (
    @Id @GeneratedValue override var id: Long? = null,
    @ManyToMany override var unlocks: MutableList<Area> = mutableListOf(),
    var name: String,
    @ManyToOne var area: Area,
    var count: Int,
    var amountCollected: Int,
) : Unlocking(id, unlocks)

@Entity
class Area (
    @Id @GeneratedValue override var id: Long? = null,
    @ManyToMany override var unlocks: MutableList<Area> = mutableListOf(),
    var name: String,
    @ManyToMany var connections: MutableList<Area> = mutableListOf(),
    @ManyToMany var dependencies: MutableList<Unlocking> = mutableListOf(),
    @OneToMany var items: MutableList<Item> = mutableListOf(),
    @OneToMany var enemies: MutableList<Enemy> = mutableListOf(),
) : Unlocking(id, unlocks)