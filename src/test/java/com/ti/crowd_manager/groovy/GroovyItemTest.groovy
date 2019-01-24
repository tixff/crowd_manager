package com.ti.crowd_manager.groovy

import com.github.springtestdbunit.annotation.DatabaseOperation
import com.github.springtestdbunit.annotation.DatabaseSetup
import com.ti.crowd_manager.domain.Item
import com.ti.crowd_manager.mapper.ItemMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.annotation.Transactional

class GroovyItemTest extends GroovyAbstractTest {
    @Autowired
    private ItemMapper itemMapper

    def item = new Item()

    def "简单打印"() {
        println "hello groovy"
    }

    @DatabaseSetup(value = "classpath:data/item.xml", type = DatabaseOperation.CLEAN_INSERT)
    @Transactional
    @Rollback
    def 添加管理员测试() {
        given:
        item.with {
            id = 81
            name = "大力水手"
        }
        when:
        itemMapper.insert(item)
        then:
        Item m = itemMapper.selectByPrimaryKey(81)
        m != null
        "大力水手".equals(m.getName())
    }
}
