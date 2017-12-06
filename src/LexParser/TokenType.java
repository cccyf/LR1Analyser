package LexParser;

public enum TokenType {
    IF,
    ELSE,
    SEMICOLON,
    A,
    DOLLAR,
    INVALID;

    public static TokenType parseType(String str) {
        TokenType tokenType = INVALID;
        switch (str) {
            case "if":
                tokenType = IF;
                break;
            case "else":
                tokenType = ELSE;
                break;
            case "a":
                tokenType = A;
                break;
            case ";":
                tokenType = SEMICOLON;
                break;
        }
        return tokenType;
    }
}
