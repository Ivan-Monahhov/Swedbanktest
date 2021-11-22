import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.HashMap;
import java.util.Map;

public class SimpleBracketBalanceConditionTest {
    private Map<String,String> bracketMap = new HashMap<>();
    private BracketBalanceCondtion condtion;

    public SimpleBracketBalanceConditionTest(){
        bracketMap.put("(",")");
        bracketMap.put("[","]");
        bracketMap.put("{","}");
        condtion = new SimpleBracketBalanceCondition(bracketMap);
    }

    @Test
    public void testTrue(){
        assertTrue(condtion.isBalanced("{[()]}"));
        assertTrue(condtion.isBalanced("[()]{()}"));
        assertTrue(condtion.isBalanced("{{[[(())]]}}"));
    }

    @Test
    public void testFalse(){
        assertFalse(condtion.isBalanced("[()]{[)}"));
        assertFalse(condtion.isBalanced("{[(])}"));
    }
}
