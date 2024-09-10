class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        char[] skillList = skill.toCharArray();
        
        int res = 0;
        
        for(String skill_tree : skill_trees){
            StringBuilder sb = new StringBuilder();
            
            for(int i=0; i<skill_tree.length(); i++){
                char c = skill_tree.charAt(i);
                
                for(char cList : skillList){
                    if(cList==c){
                        sb.append(c);
                    }
                }
                
                
            }
            String resString = sb.toString();
            boolean isTrue = true;
            for(int i=0; i<resString.length(); i++){
                if(resString.charAt(i) != skill.charAt(i)){
                    isTrue = false;
                }
            }
            if(isTrue){
                res++;
            }
              
        }
        return res;
    }
}