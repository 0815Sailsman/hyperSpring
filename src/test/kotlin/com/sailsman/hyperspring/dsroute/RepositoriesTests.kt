package com.sailsman.hyperspring.dsroute

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val enemyRepository: EnemyRepository,
    val itemRepository: ItemRepository,
    val areaRepository: AreaRepository) {

    @Test
    fun `When getEnemyById then return Enemy`() {
        val testArea = Area(
            connections = mutableListOf(),
            dependencies = mutableListOf(),
            enemies = mutableListOf(),
            items = mutableListOf(),
            name = "testArea",
            unlocks = mutableListOf(),
        )
        val testEnemy = Enemy(
            unlocks = mutableListOf(),
            name = "testEnemy",
            area = testArea,
            count = 1,
            respawns = false,
        )
        entityManager.persistAndGetId(testArea)
        testEnemy.id = entityManager.persistAndGetId(testEnemy) as Long?
        entityManager.flush()
        val found = enemyRepository.getById(testEnemy.id!!)
        assertThat(found).isEqualTo(testEnemy)
    }
}