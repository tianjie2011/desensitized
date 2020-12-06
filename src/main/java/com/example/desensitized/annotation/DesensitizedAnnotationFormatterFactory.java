package com.example.desensitized.annotation;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.util.HashSet;
import java.util.Set;

public class DesensitizedAnnotationFormatterFactory implements AnnotationFormatterFactory<Desensitized> {


    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> hashSet = new HashSet();
        hashSet.add(String.class);
        return hashSet;
    }

    @Override
    public Printer<?> getPrinter(Desensitized desensitized, Class<?> fieldType) {
        return getFormatter(desensitized);
    }

    @Override
    public Parser<?> getParser(Desensitized desensitized, Class<?> fieldType) {
        return getFormatter(desensitized);
    }

    private DesensitizedFormatter getFormatter(Desensitized desensitized) {
        DesensitizedFormatter formatter = new DesensitizedFormatter();
        formatter.setTypeEnum(desensitized.type());
        return formatter;
    }

}
