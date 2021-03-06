/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dtstack.jlogstash.inputs;


import com.alibaba.otter.canal.parse.exception.CanalParseException;
import com.alibaba.otter.canal.parse.index.AbstractLogPositionManager;
import com.alibaba.otter.canal.protocol.position.LogPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinlogPositionManager extends AbstractLogPositionManager {

    private static final Logger logger = LoggerFactory.getLogger(BinlogPositionManager.class);

    private final Binlog binlog;

    public BinlogPositionManager(Binlog binlog) {
        this.binlog = binlog;
    }

    @Override
    public LogPosition getLatestIndexBy(String destination) {
        return null;
    }

    @Override
    public void persistLogPosition(String destination, LogPosition logPosition) throws CanalParseException {
        if(logger.isDebugEnabled()){
            logger.debug("persistLogPosition: " + logPosition.toString());
        }
        binlog.updateLastPos(logPosition.getPostion());
    }

}
