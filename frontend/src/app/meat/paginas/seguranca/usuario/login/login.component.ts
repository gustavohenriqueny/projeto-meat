import {Component} from '@angular/core';
import {animate, keyframes, style, transition, trigger} from "@angular/animations";

@Component({
    selector: 'meat-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [
        trigger('loginAnimacao',[
            transition('void => visivel', [
                animate('0.8s 0s ease-in', keyframes(([
                    style({opacity: 0, offset: 0}),
                    style({opacity: 1, offset: 1})
                ])))
            ])
        ])
    ]
})
export class LoginComponent {

    loginAnimacao: string = 'visivel';

}
