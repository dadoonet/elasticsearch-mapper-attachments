/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.index.mapper.attachment.test.unit;

import org.elasticsearch.common.compress.CompressedXContent;
import org.elasticsearch.index.mapper.DocumentMapperParser;
import org.elasticsearch.index.mapper.MapperService;
import org.elasticsearch.index.mapper.attachment.AttachmentMapper;
import org.elasticsearch.index.mapper.attachment.test.MapperTestUtils;
import org.junit.Test;

import static org.elasticsearch.test.StreamsUtils.copyToBytesFromClasspath;

/**
 *
 */
public class MappingAttachmentMapperTests extends AttachmentUnitTestCase {

    /**
     * See issue https://github.com/elastic/elasticsearch-mapper-attachments/issues/169
     * @throws Exception
     */
    @Test
    public void testMapperErrorWithDotTwoLevels169() throws Exception {
        byte[] mapping = copyToBytesFromClasspath("/org/elasticsearch/index/mapper/attachment/test/unit/mapping-169/test-mapping-two-levels.json");
        DocumentMapperParser mapperParser = MapperTestUtils.newMapperParser(createTempDir());
        mapperParser.putTypeParser(AttachmentMapper.CONTENT_TYPE, new AttachmentMapper.TypeParser());

        MapperService mapperService = MapperTestUtils.newMapperService(createTempDir());
        mapperService.documentMapperParser().putTypeParser("attachment", new AttachmentMapper.TypeParser());

        mapperService.merge("mail", new CompressedXContent(mapping), false, false);
    }

    /**
     * See issue https://github.com/elastic/elasticsearch-mapper-attachments/issues/169
     * @throws Exception
     */
    @Test
    public void testMapperErrorWithDotOneLevel169() throws Exception {
        byte[] mapping = copyToBytesFromClasspath("/org/elasticsearch/index/mapper/attachment/test/unit/mapping-169/test-mapping-one-level.json");
        DocumentMapperParser mapperParser = MapperTestUtils.newMapperParser(createTempDir());
        mapperParser.putTypeParser(AttachmentMapper.CONTENT_TYPE, new AttachmentMapper.TypeParser());

        MapperService mapperService = MapperTestUtils.newMapperService(createTempDir());
        mapperService.documentMapperParser().putTypeParser("attachment", new AttachmentMapper.TypeParser());

        mapperService.merge("mail", new CompressedXContent(mapping), false, false);
    }

    /**
     * See issue https://github.com/elastic/elasticsearch-mapper-attachments/issues/169
     * @throws Exception
     */
    @Test
    public void testMapperErrorWithDotTwoLevelsNoAttachment169() throws Exception {
        byte[] mapping = copyToBytesFromClasspath("/org/elasticsearch/index/mapper/attachment/test/unit/mapping-169/test-mapping-two-levels-no-attachment.json");
        DocumentMapperParser mapperParser = MapperTestUtils.newMapperParser(createTempDir());
        mapperParser.putTypeParser(AttachmentMapper.CONTENT_TYPE, new AttachmentMapper.TypeParser());

        MapperService mapperService = MapperTestUtils.newMapperService(createTempDir());
        mapperService.documentMapperParser().putTypeParser("attachment", new AttachmentMapper.TypeParser());

        mapperService.merge("mail", new CompressedXContent(mapping), false, false);
    }

}
