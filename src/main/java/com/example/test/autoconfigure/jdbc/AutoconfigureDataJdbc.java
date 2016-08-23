package com.example.test.autoconfigure.jdbc;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * {@link ImportAutoConfiguration Auto-configuration imports} for typical data tests.
 * Most tests should consider using {@link DataJpaTest @DataJdbcTest} rather than using
 * this annotation directly.
 *
 * @author Stephane Nicoll
 * @see DataJdbcTest
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ImportAutoConfiguration
public @interface AutoconfigureDataJdbc {
}
