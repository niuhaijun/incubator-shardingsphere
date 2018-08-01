/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.core.metadata.table;

import io.shardingsphere.core.constant.SQLType;
import io.shardingsphere.core.parsing.parser.sql.SQLStatement;
import io.shardingsphere.core.rule.ShardingRule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.SQLException;

/**
 * Sharding table meta data refreshing handler.
 *
 * @author zhaojun
 */
@AllArgsConstructor
@Getter
public abstract class AbstractRefreshHandler {

    private final SQLStatement sqlStatement;

    private ShardingTableMetaData shardingTableMetaData;

    private ShardingRule shardingRule;

    /**
     * execute refresh sharding table metadata.
     *
     * @throws SQLException SQL exception
     */
    public abstract void execute() throws SQLException;
    
    protected boolean isNeedRefresh() {
        return SQLType.DDL == sqlStatement.getType() && !sqlStatement.getTables().isEmpty();
    }
}