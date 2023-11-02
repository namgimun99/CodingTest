class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int num = -1;
        int cnt = 0;

        for(int i = 0; i< skill_trees.length; i++){
            for(int j = 0; j<skill_trees[i].length(); j++){
                String word = String.valueOf(skill_trees[i].charAt(j));
                if(skill.contains(word)) {
                     if(num + 1 == skill.indexOf(word)) {
                         num = skill.indexOf(word);
                         cnt++;
                     }
                } else {
                    cnt++;
                }
            }
            System.out.println(cnt);
            if(cnt == skill_trees[i].length()) {
                answer++;
            }
            cnt = 0;
            num = -1;
        }

        return answer;
    }
}