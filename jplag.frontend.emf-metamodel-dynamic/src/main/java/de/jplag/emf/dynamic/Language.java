package de.jplag.emf.dynamic;

import de.jplag.emf.dynamic.parser.DynamicEcoreParser;

/**
 * Language for EMF metamodels from the Eclipse Modeling Framework (EMF). This language is based on a dynamically
 * created token set instead of a hand-picked one.
 * @author Timur Saglam
 */
public class Language extends de.jplag.emf.Language {
    private static final String NAME = "EMF metamodels (dynamically created token set)";
    private static final String SHORT_NAME = "EMF metamodel (dynamic)";

    private static final int DEFAULT_MIN_TOKEN_MATCH = 10;

    public Language() {
        super(new DynamicEcoreParser());
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getShortName() {
        return SHORT_NAME;
    }

    @Override
    public int minimumTokenMatch() {
        return DEFAULT_MIN_TOKEN_MATCH;
    }
}
