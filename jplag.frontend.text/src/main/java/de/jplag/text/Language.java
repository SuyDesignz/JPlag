package de.jplag.text;

import java.io.File;

import org.kohsuke.MetaInfServices;

import de.jplag.TokenList;

/**
 * Language class for parsing (natural language) text. This language module employs a primitive approach where
 * individual words are interpreted as token types. Whitespace and special characters are ignored. This approach works,
 * but there are better approaches for text plagiarism out there (based on NLP techniques).
 */
@MetaInfServices(de.jplag.Language.class)
public class Language implements de.jplag.Language {

    public static final String IDENTIFIER = "text";
    private final ParserAdapter parserAdapter;

    public Language() {
        parserAdapter = new ParserAdapter();
    }

    @Override
    public String[] suffixes() {
        return new String[] {".TXT", ".txt", ".ASC", ".asc", ".TEX", ".tex"};
    }

    @Override
    public String getName() {
        return "Text Parser (naive)";
    }

    @Override
    public String getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public int minimumTokenMatch() {
        return 5;
    }

    @Override
    public TokenList parse(File dir, String[] files) {
        return parserAdapter.parse(dir, files);
    }

    @Override
    public boolean hasErrors() {
        return parserAdapter.hasErrors();
    }
}
