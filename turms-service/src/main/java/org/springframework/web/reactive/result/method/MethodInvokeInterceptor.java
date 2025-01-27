/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.reactive.result.method;

import org.springframework.web.server.ServerWebExchange;

import javax.annotation.Nullable;
import java.lang.reflect.Method;

/**
 * @author James Chen
 */
public abstract class MethodInvokeInterceptor {

    public static final String ATTRIBUTE_INTERCEPTOR = "INTER";
    public static final MethodInvokeInterceptor DEFAULT = new MethodInvokeInterceptor() {
    };

    @Nullable
    public Object beforeInvoke(ServerWebExchange exchange, Method method, Object[] args) {
        return null;
    }


    @Nullable
    public Object afterInvoke(ServerWebExchange exchange, Method method, Object[] args,
                              @Nullable Object returnVal, @Nullable Throwable t) {
        return null;
    }

}