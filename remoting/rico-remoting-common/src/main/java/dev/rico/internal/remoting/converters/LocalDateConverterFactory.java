/*
 * Copyright 2018-2019 Karakun AG.
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
package dev.rico.internal.remoting.converters;

import dev.rico.remoting.converter.Converter;
import dev.rico.remoting.converter.ValueConverterException;
import org.apiguardian.api.API;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Collections;
import java.util.List;

import static dev.rico.internal.remoting.RemotingConstants.JAVA_DATE_FORMATTER;
import static org.apiguardian.api.API.Status.INTERNAL;

@API(since = "0.x", status = INTERNAL)
public class LocalDateConverterFactory extends AbstractConverterFactory {

    private final static Converter<?, ?> CONVERTER = new LocalDateConverter();

    @Override
    public List<Class> getSupportedTypes() {
        return Collections.singletonList(LocalDate.class);
    }

    @Override
    public int getTypeIdentifier() {
        return ValueFieldTypes.LOCAL_DATE_FIELD_TYPE;
    }

    @Override
    public Converter<?, ?> getConverterForType(final Class<?> cls) {
        return CONVERTER;
    }

    private static class LocalDateConverter
            extends AbstractStringConverter<LocalDate> {

        @Override
        public LocalDate convertFromRemoting(final String value)
                throws ValueConverterException {
            if (value == null) {
                return null;
            }
            try {
                final TemporalAccessor parsed = JAVA_DATE_FORMATTER.parse(value);
                return LocalDate.from(parsed);
            } catch (final Exception e) {
                throw new ValueConverterException(
                        "Can not convert to LocalDate", e);
            }
        }

        @Override
        public String convertToRemoting(final LocalDate value)
                throws ValueConverterException {
            if (value == null) {
                return null;
            }
            try {
                return JAVA_DATE_FORMATTER.format(value);
            } catch (final Exception e) {
                throw new ValueConverterException(
                        "Can not convert from LocalDate", e);
            }
        }
    }

}
