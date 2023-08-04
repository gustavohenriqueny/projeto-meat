import {Injectable, OnInit} from '@angular/core';
import {MEAT_API} from "../../constantes";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {Usuario} from "../entidades/usuario";
import {Observable, tap} from "rxjs";
import {LocalStorageService} from "./local-storage.service";

@Injectable({
    providedIn: 'root'
})
export class UsuarioService implements OnInit {

    url: string = `${MEAT_API}/autenticacao`
    usuario: Usuario = new Usuario();

    constructor(private http: HttpClient,
                private local: LocalStorageService,
                private router: Router) {
    }

    public logarUsuario(formulario: any): Observable<Usuario> {
        return this.http.post<Usuario>(`${this.url}/logar`, {
            email: formulario.value.email,
            senha: formulario.value.senha
        }).pipe(tap(usuario => {
            this.setarUsuario(usuario, true);
        }));
    }

    public cadastrarUsuario(formulario: any): Observable<Usuario> {
        return this.http.post<Usuario>(`${this.url}/cadastrar`, formulario)
            .pipe(tap(usuario => {
                this.setarUsuario(usuario, true);
            }));
    }
    private setarUsuario(usuario: Usuario, redirecionar: boolean) {
        this.usuario = usuario;
        this.local.setItem('usuario', usuario);
        if (redirecionar) {
            this.redirecionarUsuarioLogado()
        }
    }

    private redirecionarUsuarioLogado() {
        this.router.navigate(['/restaurantes']);
    }

    public usuarioEstaLogado(): boolean {
        if (this.local.getItem('usuario') != undefined) {
            if (this.usuario?.id == undefined) {
                this.usuario = this.local.getItem('usuario');
            }
        }
        return this.usuario?.id != null;
    }

    public deslogarUsuario() {
        this.usuario = new Usuario();
        this.local.removeItem('usuario');
        this.router.navigate(['/']);
    }

    ngOnInit(): void {
    }

}
