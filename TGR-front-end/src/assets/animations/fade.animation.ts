import { trigger, animate, transition, style, query } from '@angular/animations';
import { absoluteFrom } from '@angular/compiler-cli/src/ngtsc/file_system';

export const fadeAnimation =

    trigger('routeAnimations', [

        transition( '* <=> *', [

            query(':enter, :leave', 
                [
                    style({
                        position:"absolute",
                        left:0,
                        width:"100%",
                        opacity:0,
                        transform: 'scale(0) translateY(100%)'
                      })
                    ]),
               

            query(':enter', 
                [
                    animate('1s', style({ opacity: 1 }))
                ], 
                )

        ])

    ]);
