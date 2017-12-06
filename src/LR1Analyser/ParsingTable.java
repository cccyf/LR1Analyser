package LR1Analyser;

import LexParser.TokenType;

import java.util.HashMap;
import java.util.Map;

public class ParsingTable {

    private static final String[] productions = {
            "S' -> S",
            "S -> if S else S",
            "S -> if S",
            "S -> S ; S",
            "S -> a"
    };

    private static final String[][] actionTable = {
            {"S2", null, null, "S3", null},//0
            {null, null, "S4", null, "AC"},//1
            {"S7", null, null, "S8", null},//2
            {null, null, "R4", null, "R4"},//3
            {"S2", null, null, "S3", null},//4
            {null, null, "R3", null, "R3"},//5
            {null, "S9", "R2", null, "R2"},//6
            {"S7", null, null, "S8", null},//7
            {null, "R4", "R4", null, "R4"},//8
            {"S2", null, null, "S3", null},//9
            {"S7", null, null, "S8", null},//10
            {null, null, "S4", null, "R1"},//11
            {null, "R3", "R3", null, "R3"},//12
            {null, "S14", "R2", null, "R2"},//13
            {"S7", null, null, "S8", null},//14
            {null, "R1", "S10", null, "R1"}//15
    };
    private static final int[] gotoTable = {1, -1, 6, -1, 5, -1, -1, 13, -1, 11, 12, -1, -1, -1, 15, -1};

    private static final Map<TokenType, Integer> tokenPositionMap = new HashMap<TokenType, Integer>() {
        {
            put(TokenType.IF, 0);
            put(TokenType.ELSE, 1);
            put(TokenType.SEMICOLON, 2);
            put(TokenType.A, 3);
            put(TokenType.DOLLAR, 4);
        }
    };

    public static Action getAction(int state, TokenType tokenType) {
        ActionType actionType;
        String action = actionTable[state][tokenPositionMap.get(tokenType)];
        if (action==null){
            return null;
        }
        actionType = ActionType.getType(action.substring(0, 1));
        if (actionType == ActionType.ACCEPT)
            return new Action(actionType, 0);
        else
            return new Action(actionType, Integer.parseInt(action.substring(1)));
    }

    public static int getGOTO(int state,String s) {
        return gotoTable[state];
    }

    public static String getProduction(int p) {
        return productions[p];
    }

    public static boolean belongToGOTOs(String s){
        if ("S".equals(s)){
            return true;
        }
        return false;
    }
}
