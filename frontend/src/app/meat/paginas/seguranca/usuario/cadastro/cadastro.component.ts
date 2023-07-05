import {Component} from '@angular/core';
import {animate, keyframes, style, transition, trigger} from "@angular/animations";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {UsuarioService} from "../../../../servicos/usuario.service";
import {MensagemService} from "../../../../servicos/mensagem.service";
import {Router} from "@angular/router";
import {SUCESSO} from "../../../../../constantes";

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

    formularioCadastro: FormGroup;
    cadastroAnimacao: string = 'visivel';

    constructor(private usuarioServico: UsuarioService,
                private mensagemServico: MensagemService,
                private router: Router) {
        this.formularioCadastro = new FormGroup({
            nome: new FormControl('', Validators.required),
            email: new FormControl('', Validators.required),
            senha: new FormControl('', Validators.required),
            confirmacaoSenha: new FormControl('', Validators.required)
        }, {updateOn: 'change'})
    }

    cadastrarUsuario() {
        this.usuarioServico.cadastrarUsuario(this.formularioCadastro.value)
            .subscribe(usuario => {
                this.mensagemServico.exibirMensagem(SUCESSO, 'Usuário criado com sucesso !', `Bem vindo ${usuario.nome}`)
            });
    }


}
