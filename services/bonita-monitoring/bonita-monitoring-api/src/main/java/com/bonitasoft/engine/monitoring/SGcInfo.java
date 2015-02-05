/*******************************************************************************
 * Copyright (C) 2015 BonitaSoft S.A.
 * BonitaSoft is a trademark of BonitaSoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * BonitaSoft, 32 rue Gustave Eiffel – 38000 Grenoble
 * or BonitaSoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 *******************************************************************************/
package com.bonitasoft.engine.monitoring;

import java.util.Map;

/**
 * @author Matthieu Chaffotte
 */
public interface SGcInfo {

    long getStartTime();

    long getEndTime();

    long getDuration();

    Map<String, SMemoryUsage> getMemoryUsageBeforeGc();

    Map<String, SMemoryUsage> getMemoryUsageAfterGc();

}
