package katafy;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Copied from the documentation for {@code javax.annotation.Generated}...
 * <p>Functionally, this interface is no different than
 * {@code javax.annotation.Generated}, with the exception of this annotation
 * having retention policy, {@code java.lang.annotation.RetentionPolicy.RUNTIME}
 * </p>
 * <p>The Generated annotation is used to mark source code that has been generated.
 * It can also be used to differentiate user written code from generated code
 * in a single file. When used, the value element must have the name of the
 * code generator. The recommended convention is to use the fully qualified
 * name of the code generator in the value field.</p>
 * <p>For example: com.company.package.classname.
 * The date element is used to indicate the date the source was generated.
 * The date element must follow the ISO 8601 standard. For example the date
 * element would have the following value 2001-07-04T12:08:56.235-0700
 * which represents 2001-07-04 12:08:56 local time in the U.S. Pacific
 * Time time zone.</p>
 * <p>The comment element is a place holder for any comments that the code
 * generator may want to include in the generated code.</p>
 */
@Documented
@Retention(CLASS)
@Target({PACKAGE, TYPE, ANNOTATION_TYPE, METHOD, CONSTRUCTOR, FIELD,
        LOCAL_VARIABLE, PARAMETER})
public @interface Generated {
    /**
     * value MUST have the name of the code generator.
     * The recommended convention is to use the fully qualified name of the
     * code generator. For example: com.acme.generator.CodeGen.
     */
    String[] value();

    /**
     * Date when the source was generated.
     */
    String date() default "";

    /**
     * A place holder for any comments that the code generator may want to
     * include in the generated code.
     */
    String comments() default "";
}
