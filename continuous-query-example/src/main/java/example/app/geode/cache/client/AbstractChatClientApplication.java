/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package example.app.geode.cache.client;

import org.cp.elements.lang.Renderer;

import example.app.chat.model.Chat;

/**
 * The {@link AbstractChatClientApplication} class is an abstract base class encapsulating functionality
 * common to all chat client applications.
 *
 * @author John Blum
 * @see org.cp.elements.lang.Renderer
 * @see example.app.chat.model.Chat
 * @since 1.0.0
 */
public abstract class AbstractChatClientApplication {

  protected void log(Chat chat) {

    Renderer<Chat> chatRenderer = it ->
      String.format("[%1$s] %2$s: %3$s", it.getProcessId().orElse("?"), it.getPerson(), it.getMessage());

    log(chatRenderer.render(chat));
  }

  protected void log(String message, Object... args) {
    System.out.printf("%s%n", String.format(message, args));
    System.out.flush();
  }
}
