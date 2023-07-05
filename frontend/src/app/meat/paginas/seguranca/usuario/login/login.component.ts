import {Component, OnInit} from '@angular/core';
import {animate, keyframes, style, transition, trigger} from "@angular/animations";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ERROR, PADRAO_EMAIL, SUCESSO} from "../../../../../constantes";
import {UsuarioService} from "../../../../servicos/usuario.service";
import {MensagemService} from "../../../../servicos/mensagem.service";
import {Router} from "@angular/router";

@Component({
    selector: 'meat-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [
        trigger('loginAnimacao', [
            transition('void => visivel', [
                animate('0.8s 0s ease-in', keyframes(([
                    style({opacity: 0, offset: 0}),
                    style({opacity: 1, offset: 1})
                ])))
            ])
        ])
    ]
})
export class LoginComponent implements OnInit {

    loginAnimacao: string = 'visivel';
    formularioLogin: FormGroup;
    manterLogado: boolean = false;

    constructor(private usuarioServico: UsuarioService,
                private mensagemServico: MensagemService,
                private router: Router) {
        this.formularioLogin = new FormGroup({
            email: new FormControl('', [Validators.required, Validators.pattern(PADRAO_EMAIL)]),
            senha: new FormControl('', [Validators.required]),
            token: new FormControl(null)
        });
    }

    ngOnInit() {
    }

    logar() {
        this.usuarioServico.logarUsuario(this.formularioLogin)
            .subscribe(usuario => {
                this.mensagemServico.exibirMensagem(SUCESSO, 'Logado com sucesso !', `Seja bem vindo : ${usuario?.nome}`)
                console.log(usuario.token)
            }, error => {
                console.log(error)
                if (error.status === 404) {
                    this.mensagemServico.exibirMensagem(ERROR, 'Erro ao logar !', 'Usuário não encontrado !');
                } else {
                    this.mensagemServico.exibirMensagem(ERROR, 'Erro ao logar !', 'Ocorreu um erro ao buscar o usuário !')
                }
            });
    }

    teste() {
        this.usuarioServico.teste(this.formularioLogin.value.token).subscribe(mensagem => {
            console.log(mensagem)
        });
    }

}
