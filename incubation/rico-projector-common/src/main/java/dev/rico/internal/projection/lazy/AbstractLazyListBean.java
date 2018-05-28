/*
 * Copyright 2018 Karakun AG.
 * Copyright 2015-2018 Canoo Engineering AG.
 *
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
 */
package dev.rico.internal.projection.lazy;

import dev.rico.internal.projection.base.AbstractProjectableBean;
import dev.rico.internal.projection.metadata.KeyValue;
import dev.rico.remoting.ObservableList;
import dev.rico.remoting.Property;
import dev.rico.remoting.RemotingBean;

@RemotingBean
public abstract class AbstractLazyListBean<E extends LazyListElement> extends AbstractProjectableBean implements LazyList<E> {

    private Property<Integer> listLenght;

    private ObservableList<Integer> neededContent;

    private ObservableList<KeyValue> layoutMetadata;

    private Property<Boolean> multiSelect;

    @Override
    public Property<Integer> listLengthProperty() {
        return listLenght;
    }

    @Override
    public ObservableList<Integer> getNeededContent() {
        return neededContent;
    }

    @Override
    public ObservableList<KeyValue> getLayoutMetadata() {
        return layoutMetadata;
    }

    @Override
    public Property<Boolean> multiSelectProperty() {
        return multiSelect;
    }

}