/*
 * #%L
 * dev-eth0.de
 * %%
 * Copyright (C) 2016 dev-eth0.de
 * %%
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
 * #L%
 */
package com.adobe.aem.accelerator.program.core.elastic.indexing.reindex;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service that performs a reindexing
 */
@Component(service = Runnable.class,immediate = true)
public class ElasticSearchReindexJob implements Runnable {

  private static final Logger LOG = LoggerFactory.getLogger(ElasticSearchReindexJob.class);

  @Override
  public void run() {
    LOG.info("Running reindexing");
  }

}
