/*
 * The MIT License
 * Copyright © 2014-2019 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.iluwatar.data.locality.game.component.manager;

import com.iluwatar.data.locality.game.component.Component;
import com.iluwatar.data.locality.game.component.PhysicsComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Physics component Manager for Game.
 */
public class PhysicsComponentManager {

  private static final Logger LOGGER = LoggerFactory.getLogger(PhysicsComponentManager.class);

  private static final int MAX_ENTITIES = 10000;

  private final int numEntities;

  private static final Component[] PHYSICS_COMPONENTS = new PhysicsComponent[MAX_ENTITIES];

  public PhysicsComponentManager(int numEntities) {
    this.numEntities = numEntities;
  }

  /**
   * Start physics component of Game.
   */
  public void start() {
    LOGGER.info("Start Physics Game Component ");
    for (int i = 0; i < numEntities; i++) {
      PHYSICS_COMPONENTS[i] = new PhysicsComponent();
    }
  }


  /**
   * Update physics component of Game.
   */
  public void update() {
    LOGGER.info("Update Physics Game Component ");
    // Process physics.
    for (int i = 0; i < numEntities; i++) {
      if (PHYSICS_COMPONENTS.length > i && PHYSICS_COMPONENTS[i] != null) {
        PHYSICS_COMPONENTS[i].update();
      }
    }
  }
}
