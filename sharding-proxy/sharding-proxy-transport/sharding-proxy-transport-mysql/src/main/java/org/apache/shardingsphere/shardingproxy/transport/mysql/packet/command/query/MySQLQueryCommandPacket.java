/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.shardingproxy.transport.mysql.packet.command.query;

import org.apache.shardingsphere.shardingproxy.transport.mysql.packet.MySQLPacket;
import org.apache.shardingsphere.shardingproxy.transport.mysql.packet.command.MySQLCommandPacket;

import java.sql.SQLException;

/**
 * MySQL query command packet.
 *
 * @author zhangliang
 * @author wangkai
 */
public interface MySQLQueryCommandPacket extends MySQLCommandPacket {
    
    /**
     * Goto next result value.
     *
     * @return has more result value or not
     * @throws SQLException SQL exception
     */
    boolean next() throws SQLException;
    
    /**
     * Get query data.
     *
     * @return MySQL packet of query data
     * @throws SQLException SQL exception
     */
    MySQLPacket getQueryData() throws SQLException;
}
