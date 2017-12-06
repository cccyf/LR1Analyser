package LR1Analyser;

public enum ActionType {
    SHIFT,REDUCE,ACCEPT,UNKNOWN;

    public static ActionType getType(String s){
        if ("S".equals(s)){
            return SHIFT;
        }else if ("R".equals(s)){
            return REDUCE;
        }else if ("A".equals(s)){
            return ACCEPT;
        }
        return UNKNOWN;
    }
}
