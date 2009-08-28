/*
 * Copyright 2002-2009 the original author or authors.
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

package org.springframework.integration.splitter;

import org.springframework.integration.core.Message;
import org.springframework.integration.handler.MessageProcessor;
import org.springframework.util.Assert;

/**
 * Base class for Message Splitter implementations that delegate to a
 * {@link MessageProcessor} instance.
 * 
 * @author Mark Fisher
 * @since 2.0
 */
abstract class AbstractMessageProcessingSplitter extends AbstractMessageSplitter {

	private final MessageProcessor messageProcessor;


	protected AbstractMessageProcessingSplitter(MessageProcessor messageProcessor) {
		Assert.notNull(messageProcessor, "messageProcessor must not be null");
		this.messageProcessor = messageProcessor;
	}

	@Override
	protected final Object splitMessage(Message<?> message) {
		return this.messageProcessor.processMessage(message);
	}

}
