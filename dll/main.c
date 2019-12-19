
#include <stdio.h>
#include "dll.h"

int main(){
    
    int a, b;
    
    a = 2;
    b = 2;
    
    printf("\nSoma de %d + %d é: %d\n", a, b, soma(a, b));
    
    
    a = 3;
    b = 2;
    
    printf("\nSubtração de %d - %d é: %d\n", a, b, sub(a, b));
    
    a = 5;
    b = 5;
    
    printf("\nMltiplicação de %d * %d é: %d\n", a, b, mult(a, b));
    
    a = 30;
    b = 5;
    
    printf("\nDivição de %d / %d é: %d\n", a, b, div(a, b));
    
    
    return 0;
}
