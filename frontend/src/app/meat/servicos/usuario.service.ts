import {Injectable} from '@angular/core';
import {MEAT_API} from "../../constantes";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";
import {Usuario} from "../entidades/usuario";
import {Observable, tap} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class UsuarioService {

    url: string = `${MEAT_API}/autenticacao`
    usuario: Usuario = new Usuario();

    constructor(private http: HttpClient,
                private router: Router) {
    }

    public logarUsuario(formulario: any): Observable<any> {
        return this.http.post<any>(`${this.url}/logar`, {email: formulario.value.email, senha: formulario.value.senha})
            .pipe(tap(usuario => {
                this.usuario = usuario;
            }));
    }

    public cadastrarUsuario(formulario: any): Observable<Usuario> {
        return this.http.post<Usuario>(`${this.url}/cadastrar`, formulario)
            .pipe(tap(usuario => {
                this.usuario = usuario;
            }));
    }

    teste(token: string): Observable<any> {
        const headers = new HttpHeaders();
        headers.append('Content-Type', 'application/json');
        headers.append('Authorization', `Bearer ${token}`);
        headers.append('Access-Control-Allow-Origin', '*')
        return this.http.get(`${MEAT_API}/teste`, {headers: headers})
    }
}
