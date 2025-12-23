class Solution {
    public String solution(String new_id) {
        String one = levelOne(new_id);
        
        String two = levelTwo(one);
        
        String three = levelThree(two);
        
        String four = levelFour(three);
        
        String five = levelFive(four);
        
        String six = levelSix(five);
        String newSix = levelFour(six);
        
        String seven = levelSeven(newSix);

        
        return seven;
    }
    
    private String levelOne(String id) {
        return id.toLowerCase();
    }
    
    private String levelTwo(String id) {
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<id.length(); i++) {
            char c = id.charAt(i);
            if (('a' <= c && c <= 'z') || c == '-' || c == '_' || c == '.' || Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    
    private String levelThree(String id) {
        StringBuilder sb = new StringBuilder();
        
        boolean flag = false;
        for (int i=0; i<id.length(); i++) {
            if (id.charAt(i) == '.') {
                if (flag) {
                    continue;
                } else {
                    flag = true;
                    sb.append('.');
                }
            } else {
                sb.append(id.charAt(i));
                flag = false;
            }
        }
        return sb.toString();
    }
    
    private String levelFour(String id) {
        String result = id;
        if (id.charAt(0) == '.') {
            result = result.substring(1, id.length());
        }
        
        if (id.charAt(id.length()-1) == '.') {
            result = result.substring(0, id.length()-1);
        }
        return result;
    }
    
    private String levelFive(String id) {
        if (id.isBlank() || id.isEmpty()) {
            return "a";
        }
        return id;
    }
    
    private String levelSix(String id) {
        if (id.length() >= 16) {
            return id.substring(0, 15);
        }
        return id;
    }
    
    private String levelSeven(String id) {
        if (id.length() <= 2) {
            StringBuilder sb = new StringBuilder(id);
            
            while (sb.length() < 3) {
                sb.append(id.charAt(id.length()-1));
            }
            return sb.toString();
        }
        
        return id;
    }
}