import {Component} from '@angular/core';
import {animate, keyframes, style, transition, trigger} from "@angular/animations";

@Component({
    selector: 'meat-cadastro',
    templateUrl: './cadastro.component.html',
    styleUrls: ['./cadastro.component.scss'],
    animations: [
        trigger('cadastroAnimacao', [
            transition('void => visivel', [
                animate('0.8s 0s ease-in', keyframes(([
                    style({opacity: 0, offset: 0}),
                    style({opacity: 1, offset: 1})
                ])))
            ])
        ])
    ]
})
export class CadastroComponent {

    cadastroAnimacao: string = 'visivel';

}
