

/*

Quesiton1.
Given a random number generation method: 

int random();

which could generate a random number between 0 and 1 with uniform distribution. 

Please use this method to generate any random number between 0 and 6 with uniform distribution.



*/



class solution{


   int random6(){

       int re = 4 * random() + 2 * random() + 1 * random();
       if(re == 7){
            random6();
       }
       return re; 
   }

}


/* 

Question2.

Please explain logistic regression. 

y = p*  c^n + (1-p)* c^(1-n) ...
*/


/*
Question3.

Please explain Presicion and Recall.
*/
