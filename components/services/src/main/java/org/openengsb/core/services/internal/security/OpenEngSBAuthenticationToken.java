/**
 * Licensed to the Austrian Association for Software Tool Integration (AASTI)
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. The AASTI licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openengsb.core.services.internal.security;

import org.apache.shiro.authc.AuthenticationToken;
import org.openengsb.core.api.security.Credentials;

/**
 * wraps OpenEngSB-specific authentication-data in a shiro-compatible {@link AuthenticationToken}
 */
public class OpenEngSBAuthenticationToken implements AuthenticationToken {

    /**
     * 
     */
    private static final long serialVersionUID = 3909132403539984150L;

    private String username;
    private Credentials credentials;

    public OpenEngSBAuthenticationToken(String username, Credentials credentials) {
        this.username = username;
        this.credentials = credentials;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

}
