#define PI 3.1415926
#define R 3.0
#define L 2  *  PI  *    R //You can add space here. But the item after macro name will be replaced all.
#define S PI  *  R  *  R
#define S1(r) PI*r*r
#define CIRCLE(R,L,S,V) L=2*PI*R;S=PI*R*R;V=4/3*PI*R*R*R
//#define CIRCLE(R,L,S,V) L=2*PI*R S=PI*R*R V=4/3*PI*R*R*R //This is wrong, semi colon(;) is needed.
#define PR printf
#define NL "\n"
#define D "%d"
#define D1 D NL
#define D2 D D1
#define D3 D D2
#define D4 D D3
#define ST "%s"
#define STN ST NL
#define LETTER 0
