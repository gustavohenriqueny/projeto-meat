import {Component, OnInit} from '@angular/core';
import {UsuarioService} from "../../servicos/usuario.service";
import {Usuario} from "../../entidades/usuario";

@Component({
    selector: 'meat-cabecalho',
    templateUrl: './cabecalho.component.html',
    styleUrls: ['./cabecalho.component.scss']
})
export class CabecalhoComponent implements OnInit{

    constructor(private usuarioServico: UsuarioService) {
    }

    usuario(): Usuario {
        return this.usuarioServico.usuario;
    }

    ngOnInit(): void {
    }
}
