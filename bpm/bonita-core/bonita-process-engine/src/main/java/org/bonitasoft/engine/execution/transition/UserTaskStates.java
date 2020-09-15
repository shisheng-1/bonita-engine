/**
 * Copyright (C) 2020 Bonitasoft S.A.
 * Bonitasoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation
 * version 2.1 of the License.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth
 * Floor, Boston, MA 02110-1301, USA.
 **/
package org.bonitasoft.engine.execution.transition;

import org.bonitasoft.engine.core.process.definition.model.SFlowNodeType;
import org.bonitasoft.engine.execution.state.AbortedFlowNodeStateImpl;
import org.bonitasoft.engine.execution.state.AbortingActivityWithBoundaryStateImpl;
import org.bonitasoft.engine.execution.state.AbortingBoundaryEventsOnCompletingActivityStateImpl;
import org.bonitasoft.engine.execution.state.AbortingFlowNodeContainerStateImpl;
import org.bonitasoft.engine.execution.state.AbortingSubTaskStateImpl;
import org.bonitasoft.engine.execution.state.CancelledFlowNodeStateImpl;
import org.bonitasoft.engine.execution.state.CancellingActivityWithBoundaryStateImpl;
import org.bonitasoft.engine.execution.state.CancellingFlowNodeContainerChildrenStateImpl;
import org.bonitasoft.engine.execution.state.CompletedActivityStateImpl;
import org.bonitasoft.engine.execution.state.InitializingActivityWithBoundaryEventsStateImpl;
import org.bonitasoft.engine.execution.state.ReadyActivityStateImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserTaskStates extends FlowNodeStatesAndTransitions {

    public SFlowNodeType getFlowNodeType() {
        return SFlowNodeType.USER_TASK;
    }

    public UserTaskStates(InitializingActivityWithBoundaryEventsStateImpl initializingActivityWithBoundary,
            ReadyActivityStateImpl ready,
            AbortingBoundaryEventsOnCompletingActivityStateImpl abortingBoundaryEventsOnCompletingActivityState,
            AbortingSubTaskStateImpl abortingSubTaskState,
            CompletedActivityStateImpl completed,
            AbortingActivityWithBoundaryStateImpl abortingActivityWithBoundary,
            @Qualifier("abortingFlowNodeContainerStateImpl") AbortingFlowNodeContainerStateImpl abortingContainer,
            AbortedFlowNodeStateImpl aborted,
            @Qualifier("cancellingActivityWithBoundaryStateImpl") CancellingActivityWithBoundaryStateImpl cancellingActivityWithBoundary,
            CancellingFlowNodeContainerChildrenStateImpl cancellingContainer,
            CancelledFlowNodeStateImpl cancelled) {

        defineNormalTransitionForFlowNode(initializingActivityWithBoundary, ready,
                abortingBoundaryEventsOnCompletingActivityState, abortingSubTaskState, completed);
        defineAbortTransitionForFlowNode(abortingActivityWithBoundary, abortingContainer, aborted);
        defineCancelTransitionForFlowNode(cancellingActivityWithBoundary, cancellingContainer, cancelled);
    }
}