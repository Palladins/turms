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

package im.turms.service.workflow.dao.domain.conversation;

import im.turms.server.common.mongo.entity.annotation.Document;
import im.turms.server.common.mongo.entity.annotation.Field;
import im.turms.server.common.mongo.entity.annotation.Id;
import im.turms.server.common.mongo.entity.annotation.Sharded;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author James Chen
 */
@Data
@Document(GroupConversation.COLLECTION_NAME)
@Sharded
public final class GroupConversation {

    public static final String COLLECTION_NAME = "groupConversation";

    @Id
    private final Long groupId;

    @Field(Fields.MEMBER_ID_AND_READ_DATE)
    private final Map<Long, Date> memberIdAndReadDate;

    public static final class Fields {
        public static final String MEMBER_ID_AND_READ_DATE = "mr";

        private Fields() {
        }
    }

    @Data
    public static class GroupConversionMemberKey {

        private final Long groupId;
        private final Long memberId;

        @Data
        @AllArgsConstructor
        public static final class KeyList {
            private List<GroupConversionMemberKey> groupConversationMemberKeys;
        }
    }

}