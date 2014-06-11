package com.ape.vaadin.commons.cdi.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import com.vaadin.cdi.internal.AnnotationUtil;

public class CustomAnnotationUtil extends AnnotationUtil {
	
	// public static Set<Bean<?>> getFilteredBeansOnAnnotationFieldValue(Set<Bean<?>> beans, Annotation annotation, String field, String fieldValue) {
	// HashSet<Bean<?>> retVal = new HashSet<Bean<?>>();
	// for(Bean<?> bean : beans) {
	// Annotation beanAnnotation = bean.getClass().getAnnotation(annotation.getClass());
	// }
	// return retVal;
	// }
	
	public static <T, E extends Annotation> T valueOfClassAnnotationParamater(Class<?> clazz, Class<E> annotationClass, String parameter, Class<T> returnType) {
		T annotationValue = null;
		if(clazz.isAnnotationPresent(annotationClass)) {
			E annotation = clazz.getAnnotation(annotationClass);
			try {
				Method getParameter = annotationClass.getMethod(parameter);
				Object fieldValue = getParameter.invoke(annotation);
				if(returnType.isInstance(fieldValue)) {
					annotationValue = (returnType.cast(fieldValue));
				}
			} catch(Exception e) {
				// FIXME: handle exception
				e.printStackTrace();
			}
		}
		return annotationValue;
	}
	
	public static <T, E extends Annotation> List<T> valuesOfClassAnnotationParamater(Class<?> clazz, Class<E> annotationClass, String parameter,
			Class<T> entryType) {
		LinkedList<T> annotationValue = null;
		if(clazz.isAnnotationPresent(annotationClass)) {
			E annotation = clazz.getAnnotation(annotationClass);
			try {
				Method getParameter = annotationClass.getMethod(parameter);
				Object[] fieldValue = (Object[]) getParameter.invoke(annotation);
				if(entryType.getClass().isInstance(fieldValue.getClass())) {
					annotationValue = new LinkedList<T>();
					for(Object object : fieldValue) {
						annotationValue.add((T) object);
					}
				}
			} catch(Exception e) {
				// FIXME: handle exception
				e.printStackTrace();
			}
		}
		return annotationValue;
	}
}
