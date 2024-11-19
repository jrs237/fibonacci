/*
 * Copyright 2024 Andrew Rice <acr31@cam.ac.uk>, J.R. Shovelton
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.ac.cam.jrs237.fibonacci;

import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FibonacciTableTest {

  @Test
  public void fib_makesUseOfCache() {
    CountingMap countingMap = new CountingMap();
    FibonacciTable fibonacci = new FibonacciTable(countingMap);

    int resultFirst = fibonacci.fib(1);
    int cacheCallsFirst = countingMap.getCounter();
    int resultFifth = fibonacci.fib(5);
    int cacheCallsFifth = countingMap.getCounter() - cacheCallsFirst;
    int resultTenth = fibonacci.fib(10);
    int cacheCallsTenth = countingMap.getCounter() - cacheCallsFifth;

    assertThat(resultFirst).isEqualTo(1);
    assertThat(cacheCallsFirst).isEqualTo(0);
    assertThat(resultFifth).isEqualTo(5);
    assertThat(cacheCallsFifth).isEqualTo(3);
    assertThat(resultTenth).isEqualTo(55);
    assertThat(cacheCallsTenth).isEqualTo(6);
  }
}
