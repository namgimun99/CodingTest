#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    
    for(int i = 0; i<1001; i++){
        if(i*i > n) {
            answer = 2;
            break;
        } else if(i*i ==n) {
            answer = 1;
            break;
        }
    }
    return answer;
}