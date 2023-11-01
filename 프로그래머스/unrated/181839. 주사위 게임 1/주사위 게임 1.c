#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int a, int b) {
    int answer = 0;
    int cnt = 0;
    
    if(a%2 ==1) {
        cnt++;
    }
    
    if(b%2 ==1) {
        cnt++;
    }
    
    if(cnt == 2 ){
        answer = a*a + b*b;
    } else if(cnt == 1){
        answer = 2*(a+b);        
    } else {
        answer = a-b;
        
        if(answer < 0) {
            answer = -answer;
        }
    }
      
    return answer;
}