// Person 객체 {name, List<받은 선물>, List<준 선물>}
// 1. 입력값 파싱 -> Person 객체에 값 저장해놓기 (clear)
// 2. 계산 
// - 

// 3. 선물을 가장 많이 받을 친구가 받을 선물의 수 

import java.util.*;

class Solution {
    
    static Map<String, Person> persons = new HashMap<>();
    
    public int solution(String[] friends, String[] gifts) {
        init(friends, gifts);
        
        for (int i=0; i<friends.length; i++) {
            Person person = persons.get(friends[i]);
            // System.out.println();
            // System.out.println(person.getName());
            // System.out.println("receive = " + person.receive);
            // System.out.println("send = " + person.send);

            // System.out.println();
            
            for (int j=0; j<friends.length; j++) {
                if (i==j) {
                    continue;
                }
                
                Person friend = persons.get(friends[j]);
                
                // System.out.println(friend.getName());
                
                // 준 선물 개수 추적
                int personCount = person.countSendAmount(friend.getName());
                int friendCount = friend.countSendAmount(person.getName());
                
//                 System.out.println("personCount = " + personCount);
//                 System.out.println("friendCount = " + friendCount);
                
                if (personCount > friendCount) {
                    //System.out.println("선물 받음");
                    person.gift++;
                } else if (personCount == friendCount) {
                    if (person.calPoint() > friend.calPoint()) {
                        //System.out.println("선물 받음");
                        person.gift++;
                    }
                }
            }   
        }
        
        int maxValue = 0;
        for (String friend : friends) {
            maxValue = Math.max(persons.get(friend).gift, maxValue);
        }
        
        return maxValue;
    }
    
    public void init(String[] friends, String[] gifts) {
        for (String friend : friends) {
            persons.put(friend, new Person(friend));
        }
        
        for (String gift : gifts) {
            String[] splitGift = gift.split(" ");
            String sender = splitGift[0];
            String receiver = splitGift[1];
            
            persons.get(sender).addSender(receiver);
            persons.get(receiver).addReceiver(sender);
        }
    }
}

class Person {
    private String name;
    List<String> receive = new ArrayList<>();
    List<String> send = new ArrayList<>();
    int gift = 0;
    
    public Person(String name) {
        this.name = name;
    }
    
    public void addSender(String name) {
        send.add(name);
    }
    
    public void addReceiver(String name) {
        receive.add(name);
    }
    
    public int countSendAmount(String name) {
        int cnt = 0;
        for (String s : send) {
            if (s.equals(name)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    public int calPoint() {
        return send.size() - receive.size();
    }
    
    public String getName() {
        return name;
    }
}