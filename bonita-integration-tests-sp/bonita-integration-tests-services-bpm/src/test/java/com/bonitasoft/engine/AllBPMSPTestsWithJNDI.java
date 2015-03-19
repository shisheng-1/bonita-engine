/*******************************************************************************
 * Copyright (C) 2015 BonitaSoft S.A.
 * BonitaSoft is a trademark of BonitaSoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * BonitaSoft, 32 rue Gustave Eiffel – 38000 Grenoble
 * or BonitaSoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 *******************************************************************************/
package com.bonitasoft.engine;

import com.bonitasoft.engine.bpm.test.ParameterAndDataExpressionIntegrationTest;
import org.bonitasoft.engine.AllBPMTests;
import org.bonitasoft.engine.TestsInitializer;
import org.bonitasoft.engine.test.runner.BonitaSuiteRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.AllTests;
import org.junit.runners.Suite.SuiteClasses;

import com.bonitasoft.engine.services.event.IdentityServiceUsingEventServiceTest;
import com.bonitasoft.engine.services.event.RecorderAndEventServiceTest;
import com.bonitasoft.engine.services.monitoring.MonitoringTests;

@RunWith(BonitaSuiteRunner.class)
@BonitaSuiteRunner.Initializer(TestsInitializer.class)
@SuiteClasses({
        ParameterAndDataExpressionIntegrationTest.class,
        AllBPMTests.class,
        AllTests.class,
        IdentityServiceUsingEventServiceTest.class,
        RecorderAndEventServiceTest.class,
        // Last test suite in order to check the correct begin/complete transactions
        MonitoringTests.class
})
public class AllBPMSPTestsWithJNDI {

        @BeforeClass
        public static void beforeClass() throws Exception {
            System.err.println("=================== AllBPMSPTestsWithJNDI.beforeClass()");
        }

        @AfterClass
        public static void afterClass() throws Exception {
            System.err.println("=================== AllBPMSPTestsWithJNDI.afterClass()");
        }

    }
