package com.sailsman.hyperspring.dsroute

import jakarta.persistence.*

@Entity
abstract class Unlocking (
    @Id @GeneratedValue var id: Long? = null,
    @ManyToMany var unlocks: MutableList<Area>
)

@Entity
class Enemy  (
    @Id @GeneratedValue override var id: Long? = null,
    @ManyToMany override var unlocks: MutableList<Area>,
    var name: String,
    @ManyToOne var area: Area,
    var respawns: Boolean,
    var count: Int,
    var amountKilled: Int = 0,
) : Unlocking(id, unlocks)

@Entity
class Item  (
    @Id @GeneratedValue override var id: Long? = null,
    @ManyToMany override var unlocks: MutableList<Area>,
    var name: String,
    @ManyToOne var area: Area,
    var count: Int,
    var amountCollected: Int = 0,
) : Unlocking(id, unlocks)

@Entity
class Area (
    @Id @GeneratedValue override var id: Long? = null,
    @ManyToMany override var unlocks: MutableList<Area>,
    var name: String,
    @ManyToMany var connections: MutableList<Area>,
    @ManyToMany var dependencies: MutableList<Unlocking>,
    @OneToMany var items: MutableList<Item>,
    @OneToMany var enemies: MutableList<Enemy>,
) : Unlocking(id, unlocks)