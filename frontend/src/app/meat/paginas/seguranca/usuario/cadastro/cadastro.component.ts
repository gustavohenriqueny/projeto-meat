import {Component} from '@angular/core';
import {animate, keyframes, style, transition, trigger} from "@angular/animations";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {UsuarioService} from "../../../../servicos/usuario.service";
import {MensagemService} from "../../../../servicos/mensagem.service";
import {Router} from "@angular/router";
import {PADRAO_EMAIL, SUCESSO} from "../../../../../constantes";

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
            nome: new FormControl('', [Validators.required, Validators.minLength(6)]),
            email: new FormControl('', [Validators.required, Validators.pattern(PADRAO_EMAIL)]),
            senha: new FormControl('', [Validators.required, Validators.minLength(6)]),
            confirmacaoSenha: new FormControl('', [Validators.required, Validators.minLength(6)])
        }, {updateOn: 'change'})
    }

    cadastrarUsuario() {
        this.usuarioServico.cadastrarUsuario(this.formularioCadastro.value)
            .subscribe({
                next: usuario => {
                    this.mensagemServico.mensagemSucesso('Usuário cadastrado!', `Bem vindo ${usuario?.nome}`)
                },
                error: erro => {
                    this.mensagemServico.mensagemErro('Erro ao cadastrar usuário.', 'Entre em contato com o administrador.');
                }
            });
    }

    verificaSenhas(): boolean {
        return this.formularioCadastro.value?.senha == this.formularioCadastro.value?.confirmacaoSenha;
    }
}
