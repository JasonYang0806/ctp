public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        if(digits == null) return res;
        if(digits.length() == 0){
            res.add("");
            return res;
        }
        
        ArrayList<String> first = numToCharacter(digits.charAt(0) - '0');
        if(digits.length() == 1){
            return first;
        }
        
        ArrayList<String> rest = letterCombinations(digits.substring(1));
        if(first.size() == 0) return rest;
        for(String firstStr : first){
            for(String restStr : rest){
                res.add(firstStr + restStr);
            }
        }
        return res;
    }
    
    private ArrayList<String> numToCharacter(int num){
        ArrayList<String> charList = new ArrayList<String>();
        
        switch(num){
            case 0:
                charList.add(" ");
                break;
            case 1:
                break;
            case 2:
                charList.add("a");
                charList.add("b");
                charList.add("c");
                break;
            case 3:
                charList.add("d");
                charList.add("e");
                charList.add("f");
                break;
            case 4:
                charList.add("g");
                charList.add("h");
                charList.add("i");
                break;
            case 5:
                charList.add("j");
                charList.add("k");
                charList.add("l");
                break;
            case 6:
                charList.add("m");
                charList.add("n");
                charList.add("o");
                break;
            case 7: 
                charList.add("p");
                charList.add("q");
                charList.add("r");
                charList.add("s");
                break;
            case 8:
                charList.add("t");
                charList.add("u");
                charList.add("v");
                break;
            case 9:
                charList.add("w");
                charList.add("x");
                charList.add("y");
                charList.add("z");
                break;
            default:
                break;
        }
        return charList;
    }
}