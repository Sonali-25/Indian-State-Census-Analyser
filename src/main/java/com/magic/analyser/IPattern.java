package com.magic.analyser;

@FunctionalInterface
public interface IPattern {

    boolean patternMatcher(String pattern, String name) ;
}
