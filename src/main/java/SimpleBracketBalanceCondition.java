import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleBracketBalanceCondition implements BracketBalanceCondtion {
    private List<String> bracketPairs = new ArrayList<>();
    private static final Character ESCAPE = '\\';

    public SimpleBracketBalanceCondition(Map<String, String> openCloseBracketPairs) {
        for (Map.Entry<String, String> pair : openCloseBracketPairs.entrySet()) {
            bracketPairs.add( ESCAPE + pair.getKey() + ESCAPE + pair.getValue());
        }
    }

    @Override
    public boolean isBalanced(String bracketSequence) {

        if (bracketSequence.length() % 2 == 0) { // the sequence must have an even length to be balanced
            while (bracketSequence.length() > 0) {
                int lengthStart = bracketSequence.length();
                for (String pair : bracketPairs) {
                    bracketSequence = bracketSequence.replaceAll(pair, "");
                }
                if (bracketSequence.length() == 0) {
                    return true;
                } else if (bracketSequence.length() == lengthStart) {
                    return false;
                }
            }
        }
        return false;
    }
}
