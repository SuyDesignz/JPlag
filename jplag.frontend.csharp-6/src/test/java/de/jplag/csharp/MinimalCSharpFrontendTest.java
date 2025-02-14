package de.jplag.csharp;

import static de.jplag.csharp.CSharpTokenConstants.*;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.jplag.Token;
import de.jplag.TokenConstants;
import de.jplag.TokenPrinter;

class MinimalCSharpFrontendTest {
    private final Logger logger = LoggerFactory.getLogger("JPlag-Test");

    private static final Path BASE_PATH = Path.of("src", "test", "resources", "de", "jplag", "csharp");
    private static final String TEST_SUBJECT = "TestClass.cs";

    private de.jplag.Language frontend;
    private File baseDirectory;

    @BeforeEach
    public void setUp() {
        frontend = new Language();
        baseDirectory = BASE_PATH.toFile();
        assertTrue(baseDirectory.exists(), "Could not find base directory!");
    }

    @Test
    void testParsingTestClass() {
        List<Integer> expectedToken = List.of(CLASS, CLASS_BEGIN, FIELD, CONSTRUCTOR, LOCAL_VARIABLE, METHOD, METHOD_BEGIN, IF, IF_BEGIN, INVOCATION,
                IF_END, IF_BEGIN, INVOCATION, IF_END, METHOD_END, PROPERTY, ACCESSORS_BEGIN, ACCESSOR_BEGIN, ACCESSOR_END, ACCESSOR_BEGIN,
                ACCESSOR_END, ACCESSORS_END, FIELD, PROPERTY, ACCESSORS_BEGIN, ACCESSOR_BEGIN, RETURN, ACCESSOR_END, ACCESSOR_BEGIN, ASSIGNMENT,
                ACCESSOR_END, ACCESSORS_END, CLASS_END, TokenConstants.FILE_END);

        // Parse test input
        String[] input = new String[] {TEST_SUBJECT};
        List<Token> result = frontend.parse(baseDirectory, input);
        logger.info(TokenPrinter.printTokens(result, baseDirectory));

        // Compare parsed tokens:
        assertEquals(expectedToken.size(), result.size());
        List<Integer> actualToken = result.stream().map(Token::getType).collect(toList());
        assertEquals(expectedToken, actualToken);
    }

}
