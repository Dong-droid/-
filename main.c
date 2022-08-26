#include <ti/devices/msp432p4xx/inc/msp.h>
#include <ti/devices/msp432p4xx/driverlib/driverlib.h>
#include <ti/grlib/grlib.h>
#include "LcdDriver/Crystalfontz128x128_ST7735.h"
#include <stdio.h>
#include "LcdDriver/msp432p4111_classic.h"
#define S2BUT (( P1->IN & (1<<4)) == 0x00)
#define S1BUT (( P1->IN & (1<<1)) == 0x00)

#define BS_INIT 1
#define BS_DOWN 2
#define BS_UP 3

/*
 * Main function
 */
/* Graphic library context */
Graphics_Context g_sContext;
typedef struct paddle {
    /* paddle variables */
    int x;
    int y;    /* y is the 'top' of the paddle */
    int len;
    int score;
} paddle_t;

typedef struct ball {
    /* ball variables */
    int x;
    int y;
    int next_x;
    int next_y;
    int x_vel;
    int y_vel;
} ball_t;

typedef struct dimensions {
    int x;
    int y;
} dimensions_t;

void draw_ball(ball_t *input);
void draw_paddle(paddle_t *paddle);
void draw_score(paddle_t *inpt_paddle, dimensions_t *wall);
void paddle_collisions(ball_t *inpt_ball, paddle_t *inpt_paddle);
void paddle_pos(paddle_t *pddl, dimensions_t *wall, char dir);
int wall_collisions(ball_t *usr_ball, dimensions_t *walls);
char string[10]; /* string buffer for sprintf() */

void main(void)
{
    /*initialize s1,s2 buttons*/
    int s1but_bs = BS_INIT;
    int s2but_bs = BS_INIT;
    /* initialize curses */
    /*initscr();
    noecho();
    curs_set(0);
    */


    dimensions_t walls = {128,120};
   // getmaxyx(stdscr, walls.y, walls.x); /* get dimensions */

    /* set the paddle variables */
    paddle_t usr_paddle = { 0 };

    usr_paddle.x = 10;
    usr_paddle.y = 11;
    usr_paddle.len = walls.y / 4;
    usr_paddle.score = 0;

    /* set the ball */
    ball_t usr_ball = { 0 };

    usr_ball.x = walls.x / 2;
    usr_ball.y = walls.y / 2;
    usr_ball.next_x = 0;
    usr_ball.next_y = 0;
    usr_ball.x_vel = 1;
    usr_ball.y_vel = 1;

    /* we actually have to store the user's keypress somewhere... */
    int run = 1;

    /* Initializes display */
       Crystalfontz128x128_Init();

    /* Set default screen orientation */
       Crystalfontz128x128_SetOrientation(LCD_ORIENTATION_UP);

    /* Initializes graphics context */
       Graphics_initContext(&g_sContext, &g_sCrystalfontz128x128, &g_sCrystalfontz128x128_funcs);
       Graphics_setForegroundColor(&g_sContext, GRAPHICS_COLOR_RED);
       Graphics_setBackgroundColor(&g_sContext, GRAPHICS_COLOR_WHITE);
       GrContextFontSet(&g_sContext, &g_sFontFixed6x8);
       Graphics_clearDisplay(&g_sContext);

    /* Configures Pin 6.0 and 4.4 as ADC input */
       MAP_GPIO_setAsPeripheralModuleFunctionInputPin(GPIO_PORT_P6, GPIO_PIN0, GPIO_TERTIARY_MODULE_FUNCTION);
       MAP_GPIO_setAsPeripheralModuleFunctionInputPin(GPIO_PORT_P4, GPIO_PIN4, GPIO_TERTIARY_MODULE_FUNCTION);

    /* Initializing ADC (ADCOSC/64/8) */
       MAP_ADC14_enableModule();
       MAP_ADC14_initModule(ADC_CLOCKSOURCE_ADCOSC, ADC_PREDIVIDER_64, ADC_DIVIDER_8, 0);

           /* Configuring ADC Memory (ADC_MEM0 - ADC_MEM1 (A15, A9)  with repeat)
                * with internal 2.5v reference */
           MAP_ADC14_configureMultiSequenceMode(ADC_MEM0, ADC_MEM1, true);
           MAP_ADC14_configureConversionMemory(ADC_MEM0,
           ADC_VREFPOS_AVCC_VREFNEG_VSS,
           ADC_INPUT_A15, ADC_NONDIFFERENTIAL_INPUTS);

           MAP_ADC14_configureConversionMemory(ADC_MEM1,
           ADC_VREFPOS_AVCC_VREFNEG_VSS,
           ADC_INPUT_A9, ADC_NONDIFFERENTIAL_INPUTS);

           /* Setting up the sample timer to automatically step through the sequence
            * convert.
            */
           MAP_ADC14_enableSampleTimer(ADC_AUTOMATIC_ITERATION);

           /* Triggering the start of the sample */
           MAP_ADC14_enableConversion();
           MAP_ADC14_toggleConversionTrigger();

       P3->DIR &= ~BIT5;
       P5->DIR &= ~BIT1;
       P3->REN |= BIT5;
       P5->REN |= BIT1;
       P3->OUT |= BIT5;
       P5->OUT |= BIT1;

       P1->DIR = ~(uint8_t)(BIT1|BIT4);
       P1->REN = (BIT1|BIT4);
       P1->OUT = (BIT1|BIT4);

    while (run) {

        draw_ball(&usr_ball);
        draw_paddle(&usr_paddle);
        draw_score(&usr_paddle, &walls);

        /* set next positions  */
        Graphics_drawString(&g_sContext, (int8_t *)" ", 1, usr_ball.x, usr_ball.y , OPAQUE_TEXT);
        usr_ball.next_x = usr_ball.x + usr_ball.x_vel;
        usr_ball.next_y = usr_ball.y + usr_ball.y_vel;

        /* check for collisions */
        paddle_collisions(&usr_ball, &usr_paddle);
        if (wall_collisions(&usr_ball, &walls)) {
            run = 0;
            break;
        }

        /* Determine if S1 or S2 button in boostxl-edumkii is pressed */
              if (!(P5->IN & BIT1)) paddle_pos(&usr_paddle, &walls, 'k');
              if (!(P3->IN & BIT5)) paddle_pos(&usr_paddle, &walls, 'j');

              if(S1BUT){
                  s1but_bs=BS_DOWN;
                 }
              else{
                  if(s1but_bs==BS_DOWN){
                      Graphics_drawString(&g_sContext, (int8_t *)"PAUSE - press any key to resume",AUTO_STRING_LENGTH,0, 40, OPAQUE_TEXT);
                  while(1){
                      if(!(P5->IN & BIT1) || !(P3->IN & BIT5)|| S1BUT ||S2BUT) break;
                  }
                  Graphics_drawString(&g_sContext, (int8_t *)    "                               ",AUTO_STRING_LENGTH,0, 40, OPAQUE_TEXT);
                  }

                      s1but_bs=BS_UP;
              }
               if(S2BUT){
                       s2but_bs=BS_DOWN;
               }
               else {
                   if(s2but_bs==BS_DOWN)run=0;
                   s2but_bs=BS_UP;
               }
    }
    Graphics_clearDisplay(&g_sContext);
    Graphics_drawString(&g_sContext, (int8_t *)"GAME OVER",AUTO_STRING_LENGTH , 20, 50, OPAQUE_TEXT);
    sprintf(string,"FINAL SCORE %3d",usr_paddle.score);
    Graphics_drawString(&g_sContext, (int8_t *)string,AUTO_STRING_LENGTH , 20, 70, OPAQUE_TEXT);

}

/*
 * function : paddle_pos
 * purpose  : have a function that will return a proper 'y' value for the paddle
 * input    : paddle_t *inpt_paddle, dimensions_t *wall, char dir
 * output   : void
 */

void paddle_pos(paddle_t *pddl, dimensions_t *wall, char dir)
{
    int i;
       for(i=0;i<pddl->len;i++)
       Graphics_drawString(&g_sContext, (int8_t *)" ", 1, pddl->x,pddl-> y+i, OPAQUE_TEXT);
    if (dir == 'j') { /* moving down */
        if (pddl->y + pddl->len + 1 <= wall->y)
            pddl->y=pddl->y+5;
    } else {          /* moving up (must be 'k') */
        if (pddl->y - 1 >= 0)
            pddl->y=pddl->y-5;

    }

    return;
}

/*
 * function : wall_collisions
 * purpose  : to check for collisions on the terminal walls
 * input    : ball_t *, dimensions_t *
 * output   : nothing (stored within the structs)
 */
int wall_collisions(ball_t *usr_ball, dimensions_t *walls)
{
    /* check if we're supposed to leave quick */
    if (usr_ball->next_x < 0) {
        return 1;
    }

    /* check for X */
    if (usr_ball->next_x >= walls->x) {
        usr_ball->x_vel *= -1;
    } else {
        usr_ball->x += usr_ball->x_vel;
    }

    /* check for Y */
    if (usr_ball->next_y >= walls->y || usr_ball->next_y < 0) {
        usr_ball->y_vel *= -1;
    } else {
        usr_ball->y += usr_ball->y_vel;
    }

    return 0;
}

/* -------------------------------------------------------------------------- */

void paddle_collisions(ball_t *inpt_ball, paddle_t *inpt_paddle)
{
    /*
    * simply check if next_% (because we set the next_x && next_y first)
    * is within the bounds of the paddle's CURRENT position
    */

    if (inpt_ball->next_x == inpt_paddle->x) {
        if (inpt_paddle->y <= inpt_ball->y &&
            inpt_ball->y <=
            inpt_paddle->y + inpt_paddle->len) {

            inpt_paddle->score++;
            inpt_ball->x_vel *= -1;
        }
    }
    return;
}

/* -------------------------------------------------------------------------- */

/*
 * functions : draw_ball && draw_paddle
 * purpose   : condense the drawing functions to functions
 * input     : ball_t * && paddle_t *
 * output    : void
 */
void draw_ball(ball_t *input)
{

    Graphics_drawString(&g_sContext, (int8_t *)"O", 1, input->x, input->y, OPAQUE_TEXT); //mvprintw(input->y, input->x, "O");
    return;
}

void draw_paddle(paddle_t *paddle)
{
    int i;

    for(i=0;i<paddle->len;i++)
    Graphics_drawString(&g_sContext, (int8_t *)"|", 1, paddle->x, paddle->y+i, OPAQUE_TEXT);

    return;
}

void draw_score(paddle_t *inpt_paddle, dimensions_t *wall)
{
    sprintf(string,"Score: %d",inpt_paddle->score);
    Graphics_drawString(&g_sContext, (int8_t *)string, AUTO_STRING_LENGTH, 50, 0, OPAQUE_TEXT);


    return;
}
