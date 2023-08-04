import {Component, OnInit} from '@angular/core';
import {UsuarioService} from "./meat/servicos/usuario.service";
import {Router} from "@angular/router";

@Component({
    selector: 'meat-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

    constructor(private usuarioServico: UsuarioService,
                private router: Router) {
    }

    ngOnInit(): void {
        // if (this.usuarioEstaLogado()) {
        //     this.router.navigate(['/restaurantes']);
        // } else {
        //     this.router.navigate(['/']);
        // }
    }

    usuarioEstaLogado() {
        return this.usuarioServico.usuarioEstaLogado();
    }
}
