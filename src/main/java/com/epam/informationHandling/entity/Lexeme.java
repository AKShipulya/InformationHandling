package com.epam.informationHandling.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Lexeme implements Component{
    private static final Logger LOGGER = LogManager.getLogger();

    private final String lexeme;
    private final LexemeType lexemeType;

    public Lexeme(String lexeme, LexemeType lexemeType) {
        this.lexeme = lexeme;
        this.lexemeType = lexemeType;
    }

    public static Lexeme word(String value) {
        return new Lexeme(value, LexemeType.WORD);
    }

    public static Lexeme expression(String value) {
        return new Lexeme(value, LexemeType.EXPRESSION);
    }

    public String getLexeme() {
        return lexeme;
    }

    public LexemeType getLexemeType() {
        return lexemeType;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Lexeme lexeme1 = (Lexeme) object;
        if (lexeme != null ? !lexeme.equals(lexeme1.lexeme) : lexeme1.lexeme != null) {
            return false;
        }
        return lexemeType == lexeme1.lexemeType;
    }

    @Override
    public int hashCode() {
        int result = lexeme != null ? lexeme.hashCode() : 0;
        result = 31 * result + (lexemeType != null ? lexemeType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Lexeme{");
        sb.append("lexeme='").append(lexeme).append('\'');
        sb.append(", lexemeType=").append(lexemeType);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public List<Component> getComponents() {
        LOGGER.warn("Unsupported operation in class {}", this.getClass());
        throw new UnsupportedOperationException("This operation is not supported in this Class" + this.getClass());
    }
}
