package com.ti.crowd_manager.groovy

import com.github.springtestdbunit.annotation.DbUnitConfiguration
import com.ti.crowd_manager.CrowdManagerApplication
import com.ti.crowd_manager.MyDbUnitTestExecutionListener
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestExecutionListeners
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener
import org.springframework.test.context.support.DirtiesContextTestExecutionListener
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import spock.lang.Specification

@ContextConfiguration
@TestExecutionListeners([
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        MyDbUnitTestExecutionListener.class
])
@DbUnitConfiguration(databaseConnection = "dataSource")
@SpringBootTest(classes = CrowdManagerApplication.class)
@ActiveProfiles("unittest")
abstract class GroovyAbstractTest extends Specification {

}
