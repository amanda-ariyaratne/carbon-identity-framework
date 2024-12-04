/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.action.management.service.impl;

import org.wso2.carbon.identity.action.management.model.Action;
import org.wso2.carbon.identity.action.management.service.ActionConverter;

import java.util.EnumMap;
import java.util.Map;

/**
 * This class defines the Action Converter Factory.
 * Action Converter Factory is the component that is responsible for providing the {@link ActionConverter}
 * based on the action type.
 */
public class ActionConverterFactory {

    private static final Map<Action.ActionTypes, ActionConverter> actionConverters =
            new EnumMap<>(Action.ActionTypes.class);

    private ActionConverterFactory() {
    }

    public static ActionConverter getActionConverter(Action.ActionTypes actionType) {

        switch (actionType) {
            case PRE_UPDATE_PASSWORD:
                return actionConverters.get(Action.ActionTypes.PRE_UPDATE_PASSWORD);
            case PRE_ISSUE_ACCESS_TOKEN:
            default:
                return null;
        }
    }

    public static void registerActionConverter(ActionConverter actionConverter) {

        actionConverters.put(actionConverter.getSupportedActionType(), actionConverter);
    }

    public static void unregisterActionConverter(ActionConverter actionConverter) {

        actionConverters.remove(actionConverter.getSupportedActionType());
    }
}