package com.example.test.autoconfigure.jdbc;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import org.springframework.boot.test.autoconfigure.filter.AnnotationCustomizableTypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

class DataJdbcTypeExcludeFilter extends AnnotationCustomizableTypeExcludeFilter {

	private final DataJdbcTest annotation;

	DataJdbcTypeExcludeFilter(Class<?> testClass) {
		this.annotation = AnnotatedElementUtils.getMergedAnnotation(testClass,
				DataJdbcTest.class);
	}

	@Override
	protected boolean hasAnnotation() {
		return this.annotation != null;
	}

	@Override
	protected ComponentScan.Filter[] getFilters(FilterType type) {
		switch (type) {
			case INCLUDE:
				return this.annotation.includeFilters();
			case EXCLUDE:
				return this.annotation.excludeFilters();
		}
		throw new IllegalStateException("Unsupported type " + type);
	}

	@Override
	protected boolean isUseDefaultFilters() {
		return this.annotation.useDefaultFilters();
	}

	@Override
	protected boolean defaultInclude(MetadataReader metadataReader,
			MetadataReaderFactory metadataReaderFactory) throws IOException {
		return false;
	}

	@Override
	protected Set<Class<?>> getDefaultIncludes() {
		return Collections.emptySet();
	}

}