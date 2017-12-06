package LexParser;

public class Token {
    private TokenType type;
    private String label;

    public Token(TokenType tokenType,String label){
        this.type = tokenType;
        this.label = label;
    }

    public TokenType getTokenType(){
        return type;
    }

    public String getLabel(){
        return label;
    }

}
