// 몬스터의 공격이 먼저 이루어져야함
// 공격 -> 회복 순
// 공격을 당했을 때 체력이 음수가 되면 죽음


class Solution {    
    
    static int continueHealing = 0;
    static int maxHealth;
    static int currentHealth;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        maxHealth = health;
        currentHealth = health;
        int time = attacks[attacks.length-1][0];
        
        for (int i=0; i<=time; i++) {
            boolean isAttacked = attack(attacks, i);
            if (currentHealth <= 0) {
                return -1;
            }
            if (!isAttacked) {
                heal(bandage);
            }
            // System.out.println("currentHealth = " + currentHealth);
        }
        return currentHealth;
    }
    
    public static boolean attack(int[][] attacks, int currentTime) {
        for (int i=0; i<attacks.length; i++) {
            int[] attack = attacks[i];
            
            if (currentTime == attack[0]) {
                currentHealth -= attack[1];
                continueHealing = 0;
                return true;
            }
        }
        return false;

    }
    
    public static void heal(int[] bandage) {
        continueHealing ++;
        if (currentHealth == maxHealth) {
            return;
        }
        if (bandage[0] == continueHealing) {
            currentHealth = Math.min(bandage[2] + currentHealth, maxHealth);
            continueHealing = 0;
        }
        currentHealth = Math.min(bandage[1] + currentHealth, maxHealth);
    }
  
}