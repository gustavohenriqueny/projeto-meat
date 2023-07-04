import {Component} from '@angular/core';
import {animate, keyframes, style, transition, trigger} from "@angular/animations";

@Component({
    selector: 'meat-pagina-inicial',
    templateUrl: './pagina-inicial.component.html',
    styleUrls: ['./pagina-inicial.component.scss'],
    animations: [
        trigger('paginaInicialAnimacao', [
            transition('void => visivel', [
                animate('0.8s 0s ease-in', keyframes(([
                    style({opacity: 0, offset: 0}),
                    style({opacity: 1, offset: 1})
                ])))
            ])
        ])
    ]
})
export class PaginaInicialComponent {

    paginaInicialAnimacao: string = 'visivel';

}
